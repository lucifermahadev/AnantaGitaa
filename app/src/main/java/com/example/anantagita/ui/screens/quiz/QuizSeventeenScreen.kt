package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaSeventeenQuestions

@Composable
fun QuizSeventeenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaSeventeenQuestions,
        onQuizFinished = onQuizFinished
    )
}
