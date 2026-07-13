package com.anantagita.ui.screens

import android.app.DatePickerDialog
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.anantagita.auth.AuthViewModel
import com.anantagita.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.storage.FirebaseStorage
import com.yalantis.ucrop.UCrop
import kotlinx.coroutines.launch
import java.io.File
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel
) {
    val auth = remember { FirebaseAuth.getInstance() }
    val firestore = remember { FirebaseFirestore.getInstance() }
    val storage = remember { FirebaseStorage.getInstance() }
    val currentUser = auth.currentUser

    var bio by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var profileImageUrl by remember { mutableStateOf(currentUser?.photoUrl?.toString() ?: "") }
    var coverImageUrl by remember { mutableStateOf("") }

    var isEditing by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(true) }
    var isUploading by remember { mutableStateOf(false) }
    var uploadProgress by remember { mutableStateOf(0f) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    // 🔹 Load Firestore User Data
    fun loadUserData() {
        val uid = currentUser?.uid ?: return
        firestore.collection("users").document(uid).get()
            .addOnSuccessListener { doc ->
                if (doc.exists()) {
                    bio = doc.getString("bio") ?: ""
                    dob = doc.getString("dob") ?: ""
                    profileImageUrl = doc.getString("profileImageUrl") ?: profileImageUrl
                    coverImageUrl = doc.getString("coverImageUrl") ?: coverImageUrl
                }
                isLoading = false
            }
            .addOnFailureListener {
                isLoading = false
                scope.launch { snackbarHostState.showSnackbar("⚠️ Failed to load profile") }
            }
    }

    // 🔹 Save Firestore User Data
    fun saveUserData() {
        val uid = currentUser?.uid ?: return
        val data = mapOf(
            "bio" to bio,
            "dob" to dob,
            "profileImageUrl" to profileImageUrl,
            "coverImageUrl" to coverImageUrl
        )
        firestore.collection("users").document(uid)
            .set(data, SetOptions.merge())
            .addOnSuccessListener {
                scope.launch { snackbarHostState.showSnackbar("✅ Profile updated") }
                isEditing = false
            }
            .addOnFailureListener {
                scope.launch { snackbarHostState.showSnackbar("❌ Failed to update profile") }
            }
    }

    LaunchedEffect(currentUser?.uid) { loadUserData() }

    // 🔹 Upload Helper
    fun uploadImage(uri: Uri, path: String, onSuccess: (String) -> Unit) {
        isUploading = true
        uploadProgress = 0f
        val ref = storage.reference.child(path)
        ref.putFile(uri)
            .addOnProgressListener { task ->
                uploadProgress = task.bytesTransferred.toFloat() / task.totalByteCount
            }
            .addOnSuccessListener {
                ref.downloadUrl.addOnSuccessListener { downloadUri ->
                    onSuccess(downloadUri.toString())
                    isUploading = false
                }
            }
            .addOnFailureListener {
                isUploading = false
                scope.launch { snackbarHostState.showSnackbar("❌ Image upload failed") }
            }
    }

    // 🔹 UCrop Launcher
    val cropLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            val resultUri = UCrop.getOutput(result.data!!)
            resultUri?.let { uri ->
                val isProfileCrop = result.data?.getBooleanExtra("isProfile", false) ?: false
                if (isProfileCrop) {
                    uploadImage(uri, "profileImages/${currentUser?.uid}.jpg") { url ->
                        profileImageUrl = url
                        saveUserData()
                    }
                } else {
                    uploadImage(uri, "coverImages/${currentUser?.uid}.jpg") { url ->
                        coverImageUrl = url
                        saveUserData()
                    }
                }
            }
        }
    }

    // 🔹 Pickers
    val profileImagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val dest = Uri.fromFile(File(context.cacheDir, "profile_${System.currentTimeMillis()}.jpg"))
            val intent = UCrop.of(it, dest)
                .withAspectRatio(1f, 1f) // square crop
                .getIntent(context)
                .putExtra("isProfile", true)
            cropLauncher.launch(intent)
        }
    }

    val coverImagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            val dest = Uri.fromFile(File(context.cacheDir, "cover_${System.currentTimeMillis()}.jpg"))
            val intent = UCrop.of(it, dest)
                .withAspectRatio(16f, 9f) // wide crop
                .getIntent(context)
                .putExtra("isProfile", false)
            cropLauncher.launch(intent)
        }
    }

    // 🔹 Date Picker
    val calendar = Calendar.getInstance()
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth -> dob = "$dayOfMonth/${month + 1}/$year" },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = { TopAppBar(title = { Text("My Profile", fontWeight = FontWeight.Bold) }) }
    ) { padding ->

        if (currentUser == null) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("⚠️ Not signed in")
                LaunchedEffect(Unit) {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Profile.route) { inclusive = true }
                    }
                }
            }
            return@Scaffold
        }

        if (isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {
                // 🔹 Cover Photo
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(Color.Gray)
                        .clickable(enabled = !isUploading) { coverImagePicker.launch("image/*") },
                    contentAlignment = Alignment.Center
                ) {
                    if (coverImageUrl.isNotEmpty()) {
                        Image(
                            painter = rememberAsyncImagePainter(coverImageUrl),
                            contentDescription = "Cover Photo",
                            modifier = Modifier.fillMaxSize()
                        )
                    } else {
                        Text("Tap to add cover photo", color = Color.White)
                    }
                }

                // 🔹 Profile Image
                Box(
                    modifier = Modifier
                        .offset(y = (-60).dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    if (profileImageUrl.isNotEmpty()) {
                        Image(
                            painter = rememberAsyncImagePainter(profileImageUrl),
                            contentDescription = "Profile Image",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                                .clickable(enabled = !isUploading) {
                                    profileImagePicker.launch("image/*")
                                }
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Default Avatar",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape)
                                .clickable { profileImagePicker.launch("image/*") },
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(Modifier.height(60.dp))

                // 🔹 Details Card
                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(Modifier.padding(20.dp)) {
                        if (isEditing) {
                            OutlinedTextField(
                                value = bio,
                                onValueChange = { bio = it },
                                label = { Text("Bio") },
                                modifier = Modifier.fillMaxWidth()
                            )
                            Spacer(Modifier.height(12.dp))
                            OutlinedTextField(
                                value = dob,
                                onValueChange = { dob = it },
                                label = { Text("Date of Birth") },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { datePickerDialog.show() },
                                readOnly = true
                            )
                        } else {
                            Text("📜 Bio: ${if (bio.isEmpty()) "No bio" else bio}")
                            Text("🎂 DOB: ${if (dob.isEmpty()) "Not set" else dob}")
                        }
                    }
                }

                Spacer(Modifier.height(16.dp))

                // 🔹 Edit/Save
                if (isEditing) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = { saveUserData() },
                            enabled = !isUploading
                        ) { Text("Save") }
                        OutlinedButton(
                            modifier = Modifier.weight(1f),
                            onClick = { isEditing = false },
                            enabled = !isUploading
                        ) { Text("Cancel") }
                    }
                } else {
                    FilledTonalButton(
                        onClick = { isEditing = true },
                        enabled = !isUploading,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Text("Edit Profile")
                    }
                }

                Spacer(Modifier.height(32.dp))

                // 🔹 Logout
                Button(
                    onClick = {
                        authViewModel.signOut()
                        navController.navigate(Screen.Login.route) {
                            popUpTo(Screen.Profile.route) { inclusive = true }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.error),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    enabled = !isUploading
                ) {
                    Text("Logout")
                }
            }
        }

        // 🔹 Upload Progress
        if (isUploading) {
            Box(
                Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.4f)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator(progress = uploadProgress)
                    Spacer(Modifier.height(8.dp))
                    Text("${(uploadProgress * 100).toInt()}%", color = Color.White)
                }
            }
        }
    }
}
