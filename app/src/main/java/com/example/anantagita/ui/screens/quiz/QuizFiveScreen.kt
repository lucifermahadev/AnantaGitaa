package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaFiveQuestions

@Composable
fun QuizFiveScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaFiveQuestions,
        onQuizFinished = onQuizFinished
    )
}
