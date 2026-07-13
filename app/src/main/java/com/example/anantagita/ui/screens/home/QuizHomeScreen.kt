package com.anantagita.ui.screens.home

import android.app.Activity
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.anantagita.R
import com.anantagita.ads.AdsManager
import com.anantagita.navigation.Screen

// ---------------------- Utils ----------------------
fun unlockNextQuiz(context: Context, currentQuiz: Int) {
    val prefs = context.getSharedPreferences("quiz_prefs", Context.MODE_PRIVATE)
    val unlocked = prefs.getInt("unlocked_quizzes", 1)
    if (currentQuiz >= unlocked) {
        prefs.edit().putInt("unlocked_quizzes", currentQuiz + 1).apply()
    }
}

// ---------------------- Quiz Home Screen ----------------------
@Composable
fun QuizHomeScreen(navController: NavController) {
    val context = LocalContext.current
    val activity = context as? Activity

    val prefs = remember {
        context.getSharedPreferences("quiz_prefs", Context.MODE_PRIVATE)
    }

    var unlockedQuizzes by remember {
        mutableStateOf(prefs.getInt("unlocked_quizzes", 1))
    }

    val interstitialId = stringResource(id = R.string.interstitial_ad_unit_id)

    LaunchedEffect(Unit) {
        AdsManager.loadInterstitial(context, interstitialId)
        unlockedQuizzes = prefs.getInt("unlocked_quizzes", 1)
    }

    val chapterQuizzes = (1..19).toList()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 24.dp)
        ) {
            // Greeting
            item {
                Text(
                    text = "📖 Gita Quiz (गीता क्विज़)",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.primary
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "You have completed ${unlockedQuizzes - 1} quizzes.\nआपने ${unlockedQuizzes - 1} क्विज़ पूरी कर ली हैं।",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center
                    ),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Quiz list (1–19)
            items(chapterQuizzes) { quizNumber ->
                val isUnlocked = quizNumber <= unlockedQuizzes
                QuizCard(
                    quizNumber = quizNumber,
                    isUnlocked = isUnlocked
                ) {
                    if (isUnlocked) {
                        val destinationRoute = when (quizNumber) {
                            1 -> Screen.QuizOne.route
                            2 -> Screen.QuizTwo.route
                            3 -> Screen.QuizThree.route
                            4 -> Screen.QuizFour.route
                            5 -> Screen.QuizFive.route
                            6 -> Screen.QuizSix.route
                            7 -> Screen.QuizSeven.route
                            8 -> Screen.QuizEight.route
                            9 -> Screen.QuizNine.route
                            10 -> Screen.QuizTen.route
                            11 -> Screen.QuizEleven.route
                            12 -> Screen.QuizTwelve.route
                            13 -> Screen.QuizThirteen.route
                            14 -> Screen.QuizFourteen.route
                            15 -> Screen.QuizFifteen.route
                            16 -> Screen.QuizSixteen.route
                            17 -> Screen.QuizSeventeen.route
                            18 -> Screen.QuizEighteen.route
                            19 -> Screen.QuizNineteen.route
                            else -> Screen.QuizHome.route
                        }

                        val navigateAction: () -> Unit = {
                            navController.navigate(destinationRoute)
                        }

                        if (activity != null && !AdsManager.isPremiumUser()) {
                            AdsManager.showInterstitial(activity, interstitialId, navigateAction)
                        } else {
                            navigateAction()
                        }
                    }
                }
            }
        }
    }
}

// ---------------------- Quiz Card ----------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizCard(
    quizNumber: Int,
    isUnlocked: Boolean,
    onClick: () -> Unit
) {
    val title = when (quizNumber) {
        19 -> "Final Mega Quiz (1-18)\nफाइनल मेगा क्विज़"
        else -> "Quiz $quizNumber (क्विज़ $quizNumber, अध्याय $quizNumber)"
    }

    val backgroundBrush = if (isUnlocked) {
        Brush.horizontalGradient(
            listOf(Color(0xFFFFCDD2), Color(0xFFEEEEEE)) // half pink, half grey
        )
    } else {
        Brush.horizontalGradient(
            listOf(Color(0xFFB0BEC5), Color(0xFFB0BEC5)) // solid grey
        )
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        onClick = { if (isUnlocked) onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundBrush),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        color = if (isUnlocked) Color(0xFF880E4F) else Color.DarkGray
                    ),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = if (isUnlocked) "👉 Tap to Start / टैप करके शुरू करें"
                    else "🔒 Locked / लॉक्ड (Complete previous quiz)",
                    style = MaterialTheme.typography.bodySmall.copy(
                        color = if (isUnlocked) Color(0xFFC2185B) else Color(0xFFD32F2F)
                    ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
