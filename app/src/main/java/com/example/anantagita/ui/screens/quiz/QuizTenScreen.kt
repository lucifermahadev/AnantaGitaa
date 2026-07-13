package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaTenQuestions

@Composable
fun QuizTenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaTenQuestions,
        onQuizFinished = onQuizFinished
    )
}
