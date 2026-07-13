package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaThirteenQuestions

@Composable
fun QuizThirteenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaThirteenQuestions,
        onQuizFinished = onQuizFinished
    )
}
