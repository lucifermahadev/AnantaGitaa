package com.anantagita.ui.screens.quiz

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anantagita.ui.screens.home.unlockNextQuiz

// ---------------- Save & Load Quiz Results ----------------
fun saveQuizResult(context: Context, chapter: Int, score: Int, total: Int) {
    runCatching {
        val prefs = context.getSharedPreferences("quiz_results", Context.MODE_PRIVATE)
        prefs.edit().putString("quiz_$chapter", "$score/$total").apply()
    }.onFailure { it.printStackTrace() }
}

fun loadQuizResults(context: Context): Map<Int, String> {
    val prefs = context.getSharedPreferences("quiz_results", Context.MODE_PRIVATE)
    val results = mutableMapOf<Int, String>()
    for (i in 1..19) {
        val value = prefs.getString("quiz_$i", null)
        if (value != null) results[i] = value
    }
    return results
}

// ---------------- Quiz Result Screen ----------------
@Composable
fun QuizResultScreen(
    navController: NavController,
    chapter: Int,
    score: Int,
    total: Int
) {
    val context = LocalContext.current

    // ✅ Protect against invalid values
    val safeTotal = if (total <= 0) 1 else total
    val safeScore = score.coerceIn(0, safeTotal)

    // Save result when screen opens
    LaunchedEffect(Unit) {
        try {
            saveQuizResult(context, chapter, safeScore, safeTotal)
            unlockNextQuiz(context, chapter)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    // Load results (refresh on recomposition)
    var allResults by remember { mutableStateOf(loadQuizResults(context)) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("📊 Your Quiz Results", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(16.dp))

        if (allResults.isEmpty()) {
            // Show message if no quiz attempted yet
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "✨ You haven’t attempted any quizzes yet.\nTry one to see results here! ✨",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    lineHeight = 22.sp
                )
            }
        } else {
            // Show results list
            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items((1..19).toList()) { quizNumber ->
                    val result = allResults[quizNumber]
                    ResultCard(quizNumber, result)
                }
            }
        }

        Spacer(Modifier.height(20.dp))
        Button(onClick = { navController.popBackStack() }) {
            Text("Continue / आगे बढ़ें")
        }
    }
}

// ---------------- Result Card ----------------
@Composable
fun ResultCard(quizNumber: Int, result: String?) {
    val displayText = if (result != null) {
        "Score: $result"
    } else {
        "Not Attempted"
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text("Quiz $quizNumber", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(Modifier.height(6.dp))
            Text(displayText, fontSize = 16.sp)
        }
    }
}

