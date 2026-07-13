package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaTwoQuestions

@Composable
fun QuizTwoScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaTwoQuestions,
        onQuizFinished = onQuizFinished
    )
}

