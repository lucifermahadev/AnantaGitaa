package com.anantagita.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.anantagita.R
import com.anantagita.auth.AuthViewModel
import com.anantagita.navigation.Screen
import kotlinx.coroutines.delay

private const val SPLASH_DURATION = 3000L // 3 seconds

// ✅ Extension defined in the same file
fun NavController.navigateAndClear(
    route: String,
    popUpToRoute: String
) {
    this.navigate(route) {
        popUpTo(popUpToRoute) { inclusive = true }
        launchSingleTop = true
    }
}

@Composable
fun SplashScreen(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(),
    onFinished: (Boolean) -> Unit // ✅ callback
) {
    val isUserLoggedIn by authViewModel.isUserLoggedIn.collectAsState()

    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = (SPLASH_DURATION / 2).toInt()),
        label = "splash_alpha"
    )

    // ✅ Trigger the callback instead of navigating here
    LaunchedEffect(isUserLoggedIn) {
        startAnimation = true
        delay(SPLASH_DURATION)
        onFinished(isUserLoggedIn)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.whatsapp_image_2025_09_09_at_18_31_43),
            contentDescription = "Splash Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .alpha(alphaAnim)
        )
    }
}
