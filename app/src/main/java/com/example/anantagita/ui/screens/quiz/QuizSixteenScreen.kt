package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaSixteenQuestions

@Composable
fun QuizSixteenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaSixteenQuestions,
        onQuizFinished = onQuizFinished
    )
}
