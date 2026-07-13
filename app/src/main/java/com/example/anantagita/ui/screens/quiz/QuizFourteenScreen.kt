package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaFourteenQuestions

@Composable
fun QuizFourteenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaFourteenQuestions,
        onQuizFinished = onQuizFinished
    )
}
