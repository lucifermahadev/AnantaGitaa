package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaEighteenQuestions

@Composable
fun QuizEighteenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaEighteenQuestions,
        onQuizFinished = onQuizFinished
    )
}
