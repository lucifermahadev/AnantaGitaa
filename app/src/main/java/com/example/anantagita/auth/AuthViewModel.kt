package com.anantagita.auth

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anantagita.R
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.*
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

/**
 * Represents authentication state changes
 */
sealed class AuthState {
    object Idle : AuthState()
    object Loading : AuthState()
    object LoginSuccess : AuthState()
    object SignupSuccess : AuthState()
    object LogoutSuccess : AuthState()
    data class Error(val message: String) : AuthState()
}

/**
 * Handles authentication and user management
 */
class AuthViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()
    private var googleClient: GoogleSignInClient? = null

    // Authentication state exposed as immutable flow
    private val _authState = MutableStateFlow<AuthState>(AuthState.Idle)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    // Track user login status
    private val _isUserLoggedIn = MutableStateFlow(auth.currentUser != null)
    val isUserLoggedIn: StateFlow<Boolean> = _isUserLoggedIn.asStateFlow()

    val currentUser get() = auth.currentUser

    init {
        // Listen to Firebase Auth changes
        auth.addAuthStateListener { firebaseAuth ->
            _isUserLoggedIn.value = firebaseAuth.currentUser != null
        }
    }

    fun resetState() {
        _authState.value = AuthState.Idle
    }

    /**
     * Email/Password login
     */
    fun loginWithEmail(email: String, password: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                auth.signInWithEmailAndPassword(email, password).await()
                _authState.value = AuthState.LoginSuccess
            } catch (e: Exception) {
                _authState.value = AuthState.Error(getFriendlyError(e))
            }
        }
    }

    /**
     * Email/Password signup with Firestore profile storage
     */
    fun signupWithEmail(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        phone: String
    ) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                // Create user
                val result = auth.createUserWithEmailAndPassword(email, password).await()
                val user = result.user ?: throw Exception("User creation failed")

                // Update Firebase Auth profile
                val profileUpdates = UserProfileChangeRequest.Builder()
                    .setDisplayName("$firstName $lastName")
                    .build()
                user.updateProfile(profileUpdates).await()

                // Save profile in Firestore
                val userMap = mapOf(
                    "firstName" to firstName,
                    "lastName" to lastName,
                    "email" to email,
                    "phone" to phone,
                    "uid" to user.uid
                )
                firestore.collection("users")
                    .document(user.uid)
                    .set(userMap, SetOptions.merge())
                    .await()

                _authState.value = AuthState.SignupSuccess
            } catch (e: Exception) {
                _authState.value = AuthState.Error(getFriendlyError(e))
            }
        }
    }

    /**
     * Provides Google Sign-In client
     */
    fun getGoogleClient(context: Context): GoogleSignInClient {
        return googleClient ?: run {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
            GoogleSignIn.getClient(context, gso).also {
                googleClient = it
            }
        }
    }

    /**
     * Google login with Firebase + Firestore storage
     */
    fun loginWithGoogle(idToken: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                val credential = GoogleAuthProvider.getCredential(idToken, null)
                val result = auth.signInWithCredential(credential).await()
                val user = result.user ?: throw Exception("User authentication failed")

                val userMap = mapOf(
                    "firstName" to (user.displayName?.split(" ")?.getOrNull(0) ?: ""),
                    "lastName" to (user.displayName?.split(" ")?.getOrNull(1) ?: ""),
                    "email" to (user.email ?: ""),
                    "uid" to user.uid
                )
                firestore.collection("users")
                    .document(user.uid)
                    .set(userMap, SetOptions.merge())
                    .await()

                _authState.value = AuthState.LoginSuccess
            } catch (e: Exception) {
                _authState.value = AuthState.Error(getFriendlyError(e))
            }
        }
    }

    /**
     * Logout from Firebase + Google
     */
    fun signOut() {
        viewModelScope.launch {
            auth.signOut()
            googleClient?.signOut()?.await()
            _isUserLoggedIn.value = false
            _authState.value = AuthState.LogoutSuccess
        }
    }

    /**
     * Reset password (via email)
     */
    fun resetPassword(email: String) {
        viewModelScope.launch {
            _authState.value = AuthState.Loading
            try {
                auth.sendPasswordResetEmail(email).await()
                _authState.value = AuthState.Error("Password reset email sent to $email")
            } catch (e: Exception) {
                _authState.value = AuthState.Error(getFriendlyError(e))
            }
        }
    }

    /**
     * Map Firebase exceptions to user-friendly messages
     */
    private fun getFriendlyError(e: Exception): String {
        return when (e) {
            is FirebaseAuthInvalidCredentialsException -> "Invalid credentials. Please try again."
            is FirebaseAuthUserCollisionException -> "Account already exists with this email."
            is FirebaseAuthInvalidUserException -> "No account found with this email."
            else -> e.message ?: "Something went wrong. Please try again."
        }
    }
}

