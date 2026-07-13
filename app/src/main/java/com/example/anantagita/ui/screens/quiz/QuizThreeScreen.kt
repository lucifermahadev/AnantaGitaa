package com.anantagita.ui.screens.quiz

import androidx.compose.runtime.Composable
import com.anantagita.data.adhyayaThreeQuestions

@Composable
fun QuizThreeScreen(
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    QuizScreen(
        questions = adhyayaThreeQuestions,
        onQuizFinished = onQuizFinished
    )
}
