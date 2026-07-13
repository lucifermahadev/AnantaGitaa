package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaNineQuestions

@Composable
fun QuizNineScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaNineQuestions,
        onQuizFinished = onQuizFinished
    )
}
