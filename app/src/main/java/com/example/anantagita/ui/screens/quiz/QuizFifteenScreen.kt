package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaFifteenQuestions

@Composable
fun QuizFifteenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaFifteenQuestions,
        onQuizFinished = onQuizFinished
    )
}
