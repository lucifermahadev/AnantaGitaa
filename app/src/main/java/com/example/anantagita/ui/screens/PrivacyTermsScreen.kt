package com.anantagita.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.text.withStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyTermsScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacy & Terms", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Title Card
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Text(
                    text = "Privacy Policy & Terms",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Privacy Policy
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = """
Welcome to our app! We respect your privacy and are committed to protecting it. Please read this Privacy Policy:

1. Data We Collect
   - No personal info without consent.
   - Google/Firebase login stores only name & email.
   - Anonymous analytics to improve the app.

2. How We Use Data
   - Core app features (Shlokas, Adhyayas).
   - Show ads via AdMob (non-premium only).
   - Performance improvements.

3. Third-Party Services
   - Google AdMob (ads).
   - Firebase Auth (login).
   - They may collect usage data.

4. Your Control
   - Clear app data anytime.
   - Uninstall removes everything.
   - Premium disables ads.

5. Data Security
   - Standard encryption practices.

6. Children’s Privacy
   - Not targeted to kids under 13.

7. Updates
   - Policy may update; continued use = agreement.

8. Contact
""".trimIndent(),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.Medium
                    )

                    // ✅ Clickable Email with subject & body
                    val annotatedEmail = buildAnnotatedString {
                        pushStringAnnotation(
                            tag = "EMAIL",
                            annotation = "mailto:ishanmall789@gmail.com"
                        )
                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                textDecoration = TextDecoration.Underline,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("ishanmall789@gmail.com")
                        }
                        pop()
                    }

                    ClickableText(
                        text = annotatedEmail,
                        onClick = { offset ->
                            annotatedEmail.getStringAnnotations("EMAIL", offset, offset)
                                .firstOrNull()?.let {
                                    val intent = Intent(Intent.ACTION_SENDTO).apply {
                                        data = Uri.parse("mailto:ishanmall789@gmail.com")
                                        putExtra(Intent.EXTRA_SUBJECT, "Privacy Policy & Terms Inquiry")
                                        putExtra(Intent.EXTRA_TEXT, "Hello,\n\nI would like to ask about...")
                                    }
                                    context.startActivity(intent)
                                }
                        },
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Terms of Service
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(6.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Terms of Service",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = """
1. Use app respectfully.
2. We’re not responsible for ads/links.
3. Features/UI may change anytime.
4. Continued use = agreement.
5. Disagree? Uninstall anytime.
""".trimIndent(),
                        fontSize = 18.sp,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}
