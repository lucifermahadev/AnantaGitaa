package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaSixQuestions

@Composable
fun QuizSixScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaSixQuestions,
        onQuizFinished = onQuizFinished
    )
}
