package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaTwelveQuestions

@Composable
fun QuizTwelveScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaTwelveQuestions,
        onQuizFinished = onQuizFinished
    )
}
