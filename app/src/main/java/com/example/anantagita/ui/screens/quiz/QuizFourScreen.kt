package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaFourQuestions

@Composable
fun QuizFourScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaFourQuestions,
        onQuizFinished = onQuizFinished
    )
}
