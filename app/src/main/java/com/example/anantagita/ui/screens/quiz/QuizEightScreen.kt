package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaEightQuestions

@Composable
fun QuizEightScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaEightQuestions,
        onQuizFinished = onQuizFinished
    )
}
