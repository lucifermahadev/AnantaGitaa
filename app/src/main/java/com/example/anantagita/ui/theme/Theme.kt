package com.anantagita.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat

private val LightColors = lightColorScheme(
    primary = DarkBlue,
    onPrimary = White,
    primaryContainer = LightBlue,
    onPrimaryContainer = VeryDarkBlue,

    secondary = MainPink,
    onSecondary = White,
    secondaryContainer = SoftPink,
    onSecondaryContainer = DarkPink,

    background = White,
    onBackground = Black,

    surface = LightBlue,
    onSurface = VeryDarkBlue,

    error = ErrorRed,
    errorContainer = ErrorContainer
)

private val DarkColors = darkColorScheme(
    primary = LightBlue,
    onPrimary = VeryDarkBlue,
    primaryContainer = DarkBlue,
    onPrimaryContainer = White,

    secondary = SoftPink,
    onSecondary = DarkPink,
    secondaryContainer = MainPink,
    onSecondaryContainer = White,

    background = VeryDarkBlue,
    onBackground = White,

    surface = DarkBlue,
    onSurface = LightBlue,

    error = ErrorRed,
    errorContainer = ErrorContainer
)

private val AppShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp),
    large = RoundedCornerShape(24.dp)
)

@Composable
fun AnantaGitaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalView.current.context
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.setDecorFitsSystemWindows(window, false)

            // System bar colors
            window.statusBarColor = colorScheme.primary.toArgb()
            window.navigationBarColor = colorScheme.background.toArgb()

            val insetsController = WindowCompat.getInsetsController(window, view)
            insetsController.isAppearanceLightStatusBars = !darkTheme
            insetsController.isAppearanceLightNavigationBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = AppShapes,
        content = content
    )
}
