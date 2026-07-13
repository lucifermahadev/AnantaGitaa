package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaNineteenQuestions

@Composable
fun QuizNineteenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaNineteenQuestions,
        onQuizFinished = onQuizFinished
    )
}
