package com.anantagita.model

data class QuizQuestion(
    val englishQuestion: String,
    val hindiQuestion: String,
    val englishOptions: List<String>,
    val hindiOptions: List<String>,
    val correctAnswerIndex: Int
)
