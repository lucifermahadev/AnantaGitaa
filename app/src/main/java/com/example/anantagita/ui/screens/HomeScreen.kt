package com.anantagita.ui.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anantagita.R
import com.anantagita.ads.AdsManager
import com.anantagita.navigation.Screen
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

// ---------------- Greeting Section ----------------
@Composable
fun GreetingSection(userName: String) {
    Text(
        text = "🙏 जय श्री कृष्ण, $userName",
        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
        textAlign = TextAlign.Center
    )
}

// ---------------- Shloka Card ----------------
@Composable
fun ShlokaCard(shloka: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "श्रीमद्भगवद्गीता (अध्याय ४, श्लोक ७-८)",
                style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.SemiBold),
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = shloka,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

// ---------------- Welcome Image ----------------
@Composable
fun WelcomeImage() {
    Image(
        painter = painterResource(R.drawable.whatsapp_image_2025_09_09_at_18_31_43),
        contentDescription = "Welcome Image of Krishna and Arjun",
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .padding(vertical = 16.dp),
        contentScale = ContentScale.Crop
    )
}

// ---------------- Adhyaya Card ----------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaCard(
    adhyaya: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        shape = RoundedCornerShape(24.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    androidx.compose.ui.graphics.Brush.horizontalGradient(
                        listOf(
                            androidx.compose.ui.graphics.Color(0xFFFFC0CB),
                            androidx.compose.ui.graphics.Color(0xFFB3E5FC)
                        )
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = adhyaya,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = androidx.compose.ui.graphics.Color.Black
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

// ---------------- Completion Section ----------------
@Composable
fun CompletionSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.gemini_generated_image_2yq31k2yq31k2yq3),
            contentDescription = "Completion Blessing Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(500.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "🕉️🌺 यदि आपने अब तक सभी अध्याय पूरे कर लिये हैं...",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "🕉️🌺 If you have completed all the Adhyayas...",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp
            ),
            textAlign = TextAlign.Center
        )
    }
}

// ---------------- Final Home Screen ----------------
@Composable
fun HomeScreen(navController: NavController) {
    val auth = Firebase.auth
    val user = auth.currentUser
    val userName = user?.displayName?.takeIf { it.isNotBlank() } ?: "प्रिय साधक"

    val context = LocalContext.current
    val activity = context as? Activity

    val interstitialAdId = "ca-app-pub-9218012224365288/8522728823"

    // Load interstitial only (🚫 no banner)
    LaunchedEffect(Unit) {
        AdsManager.loadInterstitial(context, interstitialAdId)
    }

    val shloka = """
यदा यदा हि धर्मस्य ग्लानिर्भवति भारत ।
अभ्युत्थानमधर्मस्य तदात्मानं सृजाम्यहम् ॥
परित्राणाय साधूनां विनाशाय च दुष्कृताम् ।
धर्मसंस्थापनार्थाय सम्भवामि युगे युगे ॥
""".trimIndent()

    val adhyayas = listOf(
        "अध्याय 1 – अर्जुन विषाद योग" to Screen.AdhyayaOne.route,
        "अध्याय 2 – सांख्य योग" to Screen.AdhyayaTwo.route,
        "अध्याय 3 – कर्म योग" to Screen.AdhyayaThree.route,
        "अध्याय 4 – ज्ञान कर्म संन्यास योग" to Screen.AdhyayaFour.route,
        "अध्याय 5 – कर्म संन्यास योग" to Screen.AdhyayaFive.route,
        "अध्याय 6 – ध्यान योग" to Screen.AdhyayaSix.route,
        "अध्याय 7 – ज्ञान विज्ञान योग" to Screen.AdhyayaSeven.route,
        "अध्याय 8 – अक्षर ब्रह्म योग" to Screen.AdhyayaEight.route,
        "अध्याय 9 – राजविद्या राजगुह्य योग" to Screen.AdhyayaNine.route,
        "अध्याय 10 – विभूति योग" to Screen.AdhyayaTen.route,
        "अध्याय 11 – विश्वरूप दर्शन योग" to Screen.AdhyayaEleven.route,
        "अध्याय 12 – भक्तियोग" to Screen.AdhyayaTwelve.route,
        "अध्याय 13 – क्षेत्र-क्षेत्रज्ञ विभाग योग" to Screen.AdhyayaThirteen.route,
        "अध्याय 14 – गुणत्रय विभाग योग" to Screen.AdhyayaFourteen.route,
        "अध्याय 15 – पुरुषोत्तम योग" to Screen.AdhyayaFifteen.route,
        "अध्याय 16 – दैवासुर सम्पद्विभाग योग" to Screen.AdhyayaSixteen.route,
        "अध्याय 17 – श्रद्धात्रय विभाग योग" to Screen.AdhyayaSeventeen.route,
        "अध्याय 18 – मोक्ष संन्यास योग" to Screen.AdhyayaEighteen.route
    )

    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { GreetingSection(userName) }
        item { ShlokaCard(shloka) }
        item { WelcomeImage() }

        itemsIndexed(adhyayas, key = { _, item -> item.second }) { _, pair ->
            AdhyayaCard(pair.first) {
                if (activity != null) {
                    AdsManager.showInterstitial(activity, interstitialAdId) {
                        navController.navigate(pair.second)
                    }
                } else {
                    navController.navigate(pair.second)
                }
            }
        }

        item { CompletionSection() }
    }
}
