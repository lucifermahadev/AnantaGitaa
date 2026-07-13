package com.anantagita.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavType
import androidx.navigation.NavGraphBuilder
import com.anantagita.auth.AuthViewModel
import com.anantagita.ui.screens.*
import com.anantagita.ui.screens.home.QuizHomeScreen
import com.anantagita.ui.screens.quiz.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun NavHostController.navigateAndClear(route: String) {
    this.navigate(route) {
        popUpTo(graph.startDestinationId) { inclusive = true }
        launchSingleTop = true
    }
}

@Composable
fun NavGraph(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    onLogout: () -> Unit,
    onPremiumPurchased: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val safeNavigate: (String) -> Unit = { route ->
        scope.launch {
            delay(100)
            navController.navigate(route) {
                launchSingleTop = true
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // ---------- Splash ----------
        composable(Screen.Splash.route) {
            SplashScreen(
                navController = navController,
                onFinished = { isLoggedIn ->
                    if (isLoggedIn) {
                        navController.navigateAndClear(Screen.MainSwipeable.route)
                    } else {
                        navController.navigateAndClear(Screen.Login.route)
                    }
                }
            )
        }

        // ---------- Auth ----------
        composable(Screen.Login.route) {
            LoginScreen(
                authViewModel = authViewModel,
                onLoginSuccess = { navController.navigateAndClear(Screen.MainSwipeable.route) },
                onNavigateToSignup = { navController.navigate(Screen.Signup.route) }
            )
        }
        composable(Screen.Signup.route) {
            SignupScreen(
                authViewModel = authViewModel,
                onSignupSuccess = { navController.navigateAndClear(Screen.MainSwipeable.route) },
                onNavigateToLogin = { navController.navigateAndClear(Screen.Login.route) }
            )
        }

        // ---------- Main ----------
        composable(Screen.MainSwipeable.route) {
            MainSwipeableScreen(
                navController = navController,
                authViewModel = authViewModel,
                onLogout = {
                    onLogout()
                    navController.navigateAndClear(Screen.Login.route)
                },
                onPremiumPurchased = onPremiumPurchased,
                safeNavigate = safeNavigate
            )
        }

        // ---------- Profile & Info ----------
        composable(Screen.Profile.route) { ProfileScreen(navController, authViewModel) }
        composable(Screen.About.route) { AboutScreen(navController) }
        composable(Screen.Feedback.route) { FeedbackScreen(navController) }
        composable(Screen.PrivacyTerms.route) { PrivacyTermsScreen(navController) }
        composable(Screen.Support.route) { SupportScreen(onPremiumPurchased) }

        // ---------- Quiz ----------
        addQuizNavGraph(navController)

        // ---------- Adhyaya ----------
        addAdhyayaNavGraph(navController)
    }
}

fun NavGraphBuilder.addQuizNavGraph(navController: NavHostController) {
    composable(Screen.QuizHome.route) { QuizHomeScreen(navController) }

    composable(Screen.QuizOne.route) { QuizOneScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizTwo.route) { QuizTwoScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizThree.route) { QuizThreeScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizFour.route) { QuizFourScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizFive.route) { QuizFiveScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizSix.route) { QuizSixScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizSeven.route) { QuizSevenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizEight.route) { QuizEightScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizNine.route) { QuizNineScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizTen.route) { QuizTenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizEleven.route) { QuizElevenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizTwelve.route) { QuizTwelveScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizThirteen.route) { QuizThirteenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizFourteen.route) { QuizFourteenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizFifteen.route) { QuizFifteenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizSixteen.route) { QuizSixteenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizSeventeen.route) { QuizSeventeenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizEighteen.route) { QuizEighteenScreen { _, _ -> navController.popBackStack() } }
    composable(Screen.QuizNineteen.route) { QuizNineteenScreen { _, _ -> navController.popBackStack() } }
}

fun NavGraphBuilder.addAdhyayaNavGraph(navController: NavHostController) {
    composable(Screen.AdhyayaOne.route) { AdhyayaOneScreen(navController) }
    composable(Screen.AdhyayaTwo.route) { AdhyayaTwoScreen(navController) }
    composable(Screen.AdhyayaThree.route) { AdhyayaThreeScreen(navController) }
    composable(Screen.AdhyayaFour.route) { AdhyayaFourScreen(navController) }
    composable(Screen.AdhyayaFive.route) { AdhyayaFiveScreen(navController) }
    composable(Screen.AdhyayaSix.route) { AdhyayaSixScreen(navController) }
    composable(Screen.AdhyayaSeven.route) { AdhyayaSevenScreen(navController) }
    composable(Screen.AdhyayaEight.route) { AdhyayaEightScreen(navController) }
    composable(Screen.AdhyayaNine.route) { AdhyayaNineScreen(navController) }
    composable(Screen.AdhyayaTen.route) { AdhyayaTenScreen(navController) }
    composable(Screen.AdhyayaEleven.route) { AdhyayaElevenScreen(navController) }
    composable(Screen.AdhyayaTwelve.route) { AdhyayaTwelveScreen(navController) }
    composable(Screen.AdhyayaThirteen.route) { AdhyayaThirteenScreen(navController) }
    composable(Screen.AdhyayaFourteen.route) { AdhyayaFourteenScreen(navController) }
    composable(Screen.AdhyayaFifteen.route) { AdhyayaFifteenScreen(navController) }
    composable(Screen.AdhyayaSixteen.route) { AdhyayaSixteenScreen(navController) }
    composable(Screen.AdhyayaSeventeen.route) { AdhyayaSeventeenScreen(navController) }
    composable(Screen.AdhyayaEighteen.route) { AdhyayaEighteenScreen(navController) }
}
