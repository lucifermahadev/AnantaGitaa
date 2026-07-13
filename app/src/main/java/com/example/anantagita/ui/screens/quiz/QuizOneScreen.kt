package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaOneQuestions

@Composable
fun QuizOneScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaOneQuestions,
        onQuizFinished = onQuizFinished
    )
}
