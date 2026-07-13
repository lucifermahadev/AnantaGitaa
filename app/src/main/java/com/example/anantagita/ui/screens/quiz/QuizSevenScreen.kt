package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaSevenQuestions

@Composable
fun QuizSevenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaSevenQuestions,
        onQuizFinished = onQuizFinished
    )
}
