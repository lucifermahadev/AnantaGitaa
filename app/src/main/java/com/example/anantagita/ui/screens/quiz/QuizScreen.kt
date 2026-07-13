package com.anantagita.ui.screens.quiz   // ✅ must match your folder path

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anantagita.model.QuizQuestion
import com.anantagita.ui.theme.DarkBlue
import com.anantagita.ui.theme.DarkPink
import com.anantagita.ui.theme.LightBlue
import com.anantagita.ui.theme.MainPink
import com.anantagita.ui.theme.SoftPink
import com.anantagita.ui.theme.VeryDarkBlue
import com.anantagita.ui.theme.White

// Default fallback box color for options
val DefaultBoxColor: Color = LightBlue   // ✅ make sure LightBlue is defined as a Color in theme

@Composable
fun QuizScreen(
    questions: List<QuizQuestion>,
    onQuizFinished: (score: Int, total: Int) -> Unit
) {
    // State management
    var currentQuestionIndex by rememberSaveable { mutableIntStateOf(0) }
    var selectedAnswerIndex by rememberSaveable { mutableIntStateOf(-1) }
    var score by rememberSaveable { mutableIntStateOf(0) }

    val totalQuestions = questions.size
    val currentQuestion = questions[currentQuestionIndex]

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // 1. Header
        QuestionStatusHeader(
            current = currentQuestionIndex + 1,
            total = totalQuestions,
            score = score
        )

        Spacer(modifier = Modifier.height(24.dp))

        // 2. Question Card
        QuestionCard(question = currentQuestion)

        Spacer(modifier = Modifier.height(24.dp))

        // 3. Answer Options
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            itemsIndexed(currentQuestion.englishOptions) { index, option ->
                AnswerOption(
                    text = option,
                    isSelected = selectedAnswerIndex == index,
                    isCorrect = index == currentQuestion.correctAnswerIndex,
                    onClick = {
                        if (selectedAnswerIndex == -1) {
                            selectedAnswerIndex = index
                        }
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 4. Next/Finish Button
        Button(
            enabled = selectedAnswerIndex != -1,
            onClick = {
                if (selectedAnswerIndex == currentQuestion.correctAnswerIndex) {
                    score++
                }

                if (currentQuestionIndex < totalQuestions - 1) {
                    currentQuestionIndex++
                    selectedAnswerIndex = -1
                } else {
                    onQuizFinished(score, totalQuestions)
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkBlue,
                contentColor = White
            )
        ) {
            Text(
                text = if (currentQuestionIndex == totalQuestions - 1) "Finish Quiz" else "Next Question",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun QuestionStatusHeader(current: Int, total: Int, score: Int) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Question $current of $total",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = DarkBlue
        )

        Spacer(modifier = Modifier.height(8.dp))

        LinearProgressIndicator(
            progress = { current.toFloat() / total.toFloat() },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(RoundedCornerShape(50)),
            color = MainPink,
            trackColor = LightBlue
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Score: $score",
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = VeryDarkBlue
        )
    }
}

@Composable
fun QuestionCard(question: QuizQuestion) {
    ElevatedCard(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = SoftPink
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = question.englishQuestion,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = VeryDarkBlue
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = question.hindiQuestion,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = DarkPink
            )
        }
    }
}

@Composable
fun AnswerOption(
    text: String,
    isSelected: Boolean,
    isCorrect: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = when {
        isSelected && isCorrect -> Color(0xFF4CAF50) // Green
        isSelected && !isCorrect -> Color(0xFFF44336) // Red
        else -> DefaultBoxColor.copy(alpha = 0.6f)
    }

    val borderColor = if (isSelected) VeryDarkBlue else Color.Transparent

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(BorderStroke(2.dp, borderColor), RoundedCornerShape(12.dp))
            .clickable(enabled = !isSelected, onClick = onClick)
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}
