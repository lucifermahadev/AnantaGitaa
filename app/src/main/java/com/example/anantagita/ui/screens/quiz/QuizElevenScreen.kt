package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaElevenQuestions

@Composable
fun QuizElevenScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaElevenQuestions,
        onQuizFinished = onQuizFinished
    )
}
