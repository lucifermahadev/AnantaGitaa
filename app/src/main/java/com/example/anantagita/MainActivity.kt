package com.anantagita

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.anantagita.ads.AdsManager
import com.anantagita.auth.AuthViewModel
import com.anantagita.navigation.NavGraph
import com.anantagita.navigation.Screen
import com.anantagita.notifications.DailyWorker
import com.anantagita.ui.theme.AnantaGitaTheme
import com.android.billingclient.api.*
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity(), PurchasesUpdatedListener {

    private val authViewModel: AuthViewModel by viewModels()

    // 🔹 Billing client
    private val billingClient: BillingClient by lazy {
        BillingClient.newBuilder(this)
            .setListener(this)
            .enablePendingPurchases()
            .build()
    }

    // 🔹 Permission request launcher
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) scheduleDailyShlokaNotification()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")

        // ✅ Google Sign-In setup
        authViewModel.getGoogleClient(this)

        // ✅ Notification permission (Android 13+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            } else {
                scheduleDailyShlokaNotification()
            }
        } else {
            scheduleDailyShlokaNotification()
        }

        // ✅ Initialize Ads
        AdsManager.initialize(this)
        AdsManager.loadInterstitial(this, getString(R.string.interstitial_ad_unit_id))
        Log.d("MainActivity", "Ads initialized and interstitial preloaded")

        // ✅ Billing setup
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(result: BillingResult) {
                if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                    Log.d("MainActivity", "Billing setup OK")
                    queryExistingPurchases()
                } else {
                    Log.e("MainActivity", "Billing setup failed: ${result.responseCode}")
                }
            }

            override fun onBillingServiceDisconnected() {
                Log.w("MainActivity", "Billing service disconnected")
            }
        })

        // ✅ Compose UI
        setContent {
            AnantaGitaTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute by remember { derivedStateOf { backStackEntry?.destination?.route } }

                Column(modifier = Modifier.fillMaxSize()) {
                    // 🔹 Navigation Graph → handles MainSwipeableScreen internally
                    Box(modifier = Modifier.weight(1f)) {
                        NavGraph(
                            navController = navController,
                            authViewModel = authViewModel,
                            onLogout = {
                                authViewModel.signOut()
                                Log.d("MainActivity", "User logged out")
                            },
                            onPremiumPurchased = {
                                AdsManager.setPremiumStatus(true)
                                Log.d("MainActivity", "Premium purchased → Ads disabled")
                            }
                        )
                    }

                    // 🚫 Banner Ads → hide on some routes
                    if (
                        !AdsManager.isPremiumUser() &&
                        currentRoute != null &&
                        currentRoute !in listOf(
                            Screen.Splash.route,
                            Screen.Login.route,
                            Screen.Signup.route,
                            Screen.MainSwipeable.route,
                            Screen.QuizHome.route
                        )
                    ) {
                        AndroidView(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp), // ✅ Correct banner height
                            factory = { context ->
                                AdsManager.createBannerAdView(
                                    context,
                                    getString(R.string.banner_ad_unit_id)
                                )!!
                            }
                        )
                    }
                }

                // 🚀 Interstitial Ads → specific routes
                if (
                    !AdsManager.isPremiumUser() &&
                    currentRoute in listOf(
                        Screen.MainSwipeable.route,
                        Screen.QuizHome.route,
                        Screen.Profile.route,
                        Screen.Feedback.route,
                        Screen.About.route,
                        Screen.PrivacyTerms.route,
                        Screen.Support.route
                    )
                ) {
                    LaunchedEffect(currentRoute) {
                        Log.d("MainActivity", "Showing interstitial on $currentRoute")
                        AdsManager.showInterstitial(
                            this@MainActivity,
                            getString(R.string.interstitial_ad_unit_id)
                        )
                    }
                }
            }
        }
    }

    // 🔹 Lifecycle logging
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called → cleaning up billing")
        if (billingClient.isReady) {
            billingClient.endConnection()
        }
    }

    // 🔹 Check existing purchases (INAPP + SUBS)
    private fun queryExistingPurchases() {
        val productTypes = listOf(
            BillingClient.ProductType.INAPP,
            BillingClient.ProductType.SUBS
        )
        productTypes.forEach { type ->
            billingClient.queryPurchasesAsync(
                QueryPurchasesParams.newBuilder()
                    .setProductType(type)
                    .build()
            ) { result, purchases ->
                if (result.responseCode == BillingClient.BillingResponseCode.OK) {
                    purchases.forEach { purchase ->
                        if (purchase.products.contains("lifetime_199")) {
                            AdsManager.setPremiumStatus(true)
                            Log.d("MainActivity", "Premium purchase detected")
                        }
                    }
                }
            }
        }
    }

    // 🔹 Handle purchase updates
    override fun onPurchasesUpdated(result: BillingResult, purchases: MutableList<Purchase>?) {
        if (result.responseCode == BillingClient.BillingResponseCode.OK) {
            purchases?.forEach { purchase ->
                if (
                    purchase.products.contains("lifetime_199") &&
                    purchase.purchaseState == Purchase.PurchaseState.PURCHASED
                ) {
                    if (!purchase.isAcknowledged) {
                        val acknowledgeParams = AcknowledgePurchaseParams.newBuilder()
                            .setPurchaseToken(purchase.purchaseToken)
                            .build()
                        billingClient.acknowledgePurchase(acknowledgeParams) {}
                    }
                    AdsManager.setPremiumStatus(true)
                    Log.d("MainActivity", "Purchase acknowledged → Premium enabled")
                }
            }
        }
    }

    // 🔹 Daily notification worker
    private fun scheduleDailyShlokaNotification() {
        val workRequest = PeriodicWorkRequestBuilder<DailyWorker>(1, TimeUnit.DAYS).build()
        WorkManager.getInstance(this).enqueueUniquePeriodicWork(
            "DailyShlokaWork",
            ExistingPeriodicWorkPolicy.UPDATE,
            workRequest
        )
        Log.d("MainActivity", "Daily Shloka Worker scheduled")
    }
}

