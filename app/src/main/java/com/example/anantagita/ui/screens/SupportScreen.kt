package com.anantagita.ui.screens

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.billingclient.api.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun SupportScreen(onPremiumPurchased: () -> Unit) {
    val context = LocalContext.current
    val activity = context as? Activity
    val firestore = FirebaseFirestore.getInstance()
    val userId = FirebaseAuth.getInstance().currentUser?.uid ?: "guest"

    val upiId = "ishanmall789@oksbi"
    val membershipProductId = "lifetime_199"

    var isLoading by remember { mutableStateOf(false) }
    var amount by remember { mutableStateOf("") }
    var billingClient: BillingClient? by remember { mutableStateOf(null) }

    // ---------- Local Premium ----------
    fun setPremium(value: Boolean) {
        context.getSharedPreferences("premium_prefs", Context.MODE_PRIVATE)
            .edit().putBoolean("isPremium", value).apply()
    }

    fun isPremium() = context.getSharedPreferences("premium_prefs", Context.MODE_PRIVATE)
        .getBoolean("isPremium", false)

    // ---------- Firestore ----------
    fun logMembership(source: String) {
        val membershipData = hashMapOf(
            "userId" to userId,
            "source" to source,
            "timestamp" to System.currentTimeMillis()
        )
        firestore.collection("memberships").document(userId)
            .set(membershipData)
            .addOnSuccessListener {
                setPremium(true)
                Toast.makeText(context, "🎉 Premium Activated", Toast.LENGTH_LONG).show()
                onPremiumPurchased()
                isLoading = false
            }
            .addOnFailureListener {
                Toast.makeText(context, "Failed to log membership", Toast.LENGTH_SHORT).show()
                isLoading = false
            }
    }

    fun logDonation(amount: String, method: String) {
        firestore.collection("donations").add(
            mapOf(
                "userId" to userId,
                "amount" to amount,
                "method" to method,
                "timestamp" to System.currentTimeMillis()
            )
        )
    }

    // ---------- Billing ----------
    fun initBillingClient() {
        if (billingClient != null) return
        billingClient = BillingClient.newBuilder(context)
            .setListener { result, purchases ->
                if (result.responseCode == BillingClient.BillingResponseCode.OK && purchases != null) {
                    purchases.forEach { purchase ->
                        if (purchase.products.contains(membershipProductId)) {
                            val params = AcknowledgePurchaseParams.newBuilder()
                                .setPurchaseToken(purchase.purchaseToken)
                                .build()
                            billingClient?.acknowledgePurchase(params) { ackResult ->
                                if (ackResult.responseCode == BillingClient.BillingResponseCode.OK) {
                                    logMembership("PlayStore")
                                }
                            }
                        }
                    }
                } else isLoading = false
            }
            .enablePendingPurchases()
            .build()
    }

    fun startPlayStoreBilling() {
        if (activity == null) {
            Toast.makeText(context, "Activity not available", Toast.LENGTH_SHORT).show()
            return
        }
        isLoading = true
        initBillingClient()
        billingClient?.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(r: BillingResult) {
                if (r.responseCode == BillingClient.BillingResponseCode.OK) {
                    val params = QueryProductDetailsParams.newBuilder()
                        .setProductList(
                            listOf(
                                QueryProductDetailsParams.Product.newBuilder()
                                    .setProductId(membershipProductId)
                                    .setProductType(BillingClient.ProductType.INAPP)
                                    .build()
                            )
                        ).build()
                    billingClient?.queryProductDetailsAsync(params) { result, list ->
                        if (result.responseCode == BillingClient.BillingResponseCode.OK && list.isNotEmpty()) {
                            val product = list[0]
                            val flowParams = BillingFlowParams.newBuilder()
                                .setProductDetailsParamsList(
                                    listOf(
                                        BillingFlowParams.ProductDetailsParams.newBuilder()
                                            .setProductDetails(product)
                                            .build()
                                    )
                                ).build()
                            billingClient?.launchBillingFlow(activity, flowParams)
                        } else isLoading = false
                    }
                } else isLoading = false
            }

            override fun onBillingServiceDisconnected() {
                isLoading = false
            }
        })
    }

    fun restorePurchase() {
        initBillingClient()
        billingClient?.queryPurchasesAsync(
            QueryPurchasesParams.newBuilder()
                .setProductType(BillingClient.ProductType.INAPP).build()
        ) { result, purchases ->
            if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                val has = purchases.any { it.products.contains(membershipProductId) }
                if (has) logMembership("Restore")
                else Toast.makeText(context, "No purchase found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // ---------- UPI ----------
    val upiLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        val response = result.data?.getStringExtra("response") ?: ""
        if (response.contains("SUCCESS", ignoreCase = true) ||
            response.contains("Status=SUCCESS", ignoreCase = true)
        ) {
            logDonation(amount.ifBlank { "custom" }, "UPI")
            Toast.makeText(context, "✅ Donation Successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Payment cancelled/failed", Toast.LENGTH_SHORT).show()
        }
    }

    fun launchUpiPayment(amount: String, note: String = "Donation") {
        val finalAmount = amount.ifBlank { "50" }
        val uri = Uri.parse(
            "upi://pay?pa=$upiId&pn=AnantaGita&am=$finalAmount&cu=INR&tn=$note"
        )
        val intent = Intent(Intent.ACTION_VIEW, uri)

        // 🔍 Detect UPI apps
        val upiApps = context.packageManager.queryIntentActivities(intent, 0)

        if (upiApps.isNotEmpty()) {
            // Prefer Google Pay if installed
            val gpayPackage = "com.google.android.apps.nbu.paisa.user"
            val gpayApp = upiApps.firstOrNull { it.activityInfo.packageName == gpayPackage }

            if (gpayApp != null) {
                intent.setPackage(gpayPackage)
                upiLauncher.launch(intent)
            } else {
                val chooser = Intent.createChooser(intent, "Pay with UPI")
                upiLauncher.launch(chooser)
            }
        } else {
            Toast.makeText(context, "No UPI app installed!", Toast.LENGTH_SHORT).show()
        }
    }

    // ---------- Auto Restore ----------
    LaunchedEffect(Unit) {
        if (!isPremium()) {
            firestore.collection("memberships").document(userId).get()
                .addOnSuccessListener { doc ->
                    if (doc.exists()) {
                        setPremium(true)
                        onPremiumPurchased()
                    }
                }
        }
    }

    // ✅ Clean up billing client on dispose
    DisposableEffect(Unit) {
        onDispose {
            billingClient?.endConnection()
            billingClient = null
        }
    }

    // ---------- UI ----------
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "🌟 Support AnantaGita 🌟",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFF3E2723)
        )

        Spacer(Modifier.height(8.dp))
        Text(
            "“Like a lamp that needs oil to keep burning, this mission needs your love to keep shining.”",
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            fontSize = 16.sp
        )

        Spacer(Modifier.height(24.dp))

        // Donation Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("🙏 Make a Donation", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(8.dp))
                OutlinedTextField(
                    value = amount,
                    onValueChange = { amount = it },
                    label = { Text("Enter Amount (INR)") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = { launchUpiPayment(amount) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    enabled = !isLoading
                ) {
                    Text("Donate via UPI")
                }
            }
        }

        Spacer(Modifier.height(32.dp))

        // Membership Section
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("💎 Lifetime Membership", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = { startPlayStoreBilling() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    enabled = !isLoading
                ) {
                    Text("Buy ₹199 via Play Store")
                }
                Spacer(Modifier.height(12.dp))
                OutlinedButton(
                    onClick = { restorePurchase() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(12.dp),
                    enabled = !isLoading
                ) {
                    Text("🔄 Restore Purchase")
                }
            }
        }

        Spacer(Modifier.height(32.dp))
        Text(
            "Your contribution becomes an offering at the feet of the Lord. 🌺",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
            color = Color.DarkGray
        )
        Spacer(Modifier.height(12.dp))
        Text(
            "धन्यवाद 🙏 Thank You 🙏",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF3E2723)
        )
    }
}
