package com.anantagita.ui.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Public
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.anantagita.R

// ---------- Data Models (UNCHANGED) ----------
data class AboutScreenContent(
    val aboutApp: SectionData,
    val universalMessage: SectionData,
    val lordKrishna: SectionData,
    val threeYogas: YogaSectionData,
    val developer: DeveloperData
)

data class SectionData(
    val title: String,
    val icon: ImageVector,
    val englishText: String,
    val hindiText: String
)

data class YogaSectionData(
    val title: String,
    val icon: ImageVector,
    val items: List<YogaItemData>
)

data class YogaItemData(
    val title: String,
    val description: String
)

data class DeveloperData(
    val name: String,
    val email: String,
    val linkedinUrl: String
)

// ---------- Screen (MODIFIED) ----------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    val context = LocalContext.current

    val content = AboutScreenContent(
        aboutApp = SectionData(
            title = "About this App",
            icon = Icons.Filled.Info,
            englishText = "Gita Gyan is a humble attempt to make the wisdom of the Bhagavad Gita accessible to everyone. It provides a clean and simple interface to read, reflect upon, and be inspired by the teachings of Lord Krishna.",
            hindiText = "यह ऐप भगवद गीता के गहन ज्ञान को सभी के लिए सुलभ बनाने का एक प्रयास है। हमारा मिशन है कि भगवान श्रीकृष्ण की शिक्षाओं को पढ़ने और उनसे प्रेरित होने के लिए एक सरल और सहज इंटरफ़ेस प्रदान करना।"
        ),
        universalMessage = SectionData(
            title = "The Universal Message",
            icon = Icons.Filled.Public,
            englishText = "The Bhagavad Gita is not just a religious text but a practical guide to living a meaningful life. Its teachings on duty (Dharma), balance, and devotion are timeless.",
            hindiText = "भगवद गीता केवल एक धार्मिक ग्रंथ नहीं है, बल्कि यह एक सार्थक जीवन जीने की व्यावहारिक मार्गदर्शिका है। धर्म, संतुलन और भक्ति पर इसकी शिक्षाएँ कालातीत हैं।"
        ),
        lordKrishna = SectionData(
            title = "Who is Lord Krishna?",
            icon = Icons.Filled.Person,
            englishText = "Lord Krishna is considered the Supreme Personality of Godhead. He guided Arjuna on the battlefield of Kurukshetra by imparting the wisdom of the Bhagavad Gita.",
            hindiText = "भगवान श्रीकृष्ण को परम पुरुषोत्तम माना जाता है। उन्होंने कुरुक्षेत्र के युद्ध में अर्जुन को गीता का दिव्य ज्ञान दिया।"
        ),
        threeYogas = YogaSectionData(
            title = "The Three Yogas",
            icon = Icons.Filled.Favorite,
            items = listOf(
                YogaItemData("Karma Yoga (Path of Action)", "Perform your duty without attachment to results."),
                YogaItemData("Bhakti Yoga (Path of Devotion)", "Surrender to the Supreme with love and devotion."),
                YogaItemData("Jnana Yoga (Path of Knowledge)", "Seek the truth of self and supreme through wisdom.")
            )
        ),
        developer = DeveloperData(
            name = "Ishan Mall",
            email = "ishanmall789@gmail.com",
            linkedinUrl = "https://www.linkedin.com/in/ishan-mall-4b20ab296"
        )
    )

    val gradient = Brush.horizontalGradient(listOf(Color(0xFF6A1B9A), Color(0xFFD81B60)))

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About Gita Gyan", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                modifier = Modifier.background(gradient)
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = PaddingValues(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item { HeroSection() }
            item { SectionCard(content.aboutApp) }

            // NEW SECTION ADDED HERE: Your Ananta Gita Info Card
            item {
                InfoCard(title = "Ananta Gita License Info", icon = Icons.Filled.Code) {
                    AboutAnantaGitaScreenContent()
                }
            }
            // END OF NEW SECTION

            item { SectionCard(content.universalMessage) }
            item { SectionCard(content.lordKrishna) }
            item {
                InfoCard(title = content.threeYogas.title, icon = content.threeYogas.icon) {
                    content.threeYogas.items.forEach { yoga ->
                        YogaItem(yoga.title, yoga.description)
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    FeatureCard(
                        modifier = Modifier.weight(1f),
                        title = "Rate the App",
                        icon = Icons.Filled.StarRate,
                        onClick = { openPlayStore(context, context.packageName) }
                    )
                    FeatureCard(
                        modifier = Modifier.weight(1f),
                        title = "Share App",
                        icon = Icons.Filled.Share,
                        onClick = { shareApp(context) }
                    )
                }
            }
            item { DeveloperInfoSection(content.developer, context) }
            item { Spacer(modifier = Modifier.height(16.dp)) }
        }
    }
}

// ---------- Your NEW Composable (RENAMED to avoid conflict and placed inside InfoCard) ----------

@Composable
fun AboutAnantaGitaScreenContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Use fillMaxWidth inside the InfoCard
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🕉️ Ananta Gita", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
        Spacer(Modifier.height(8.dp))
        Text("Developed by: Ishan Mall\n© 2025 Ananta Gita", fontSize = 14.sp, textAlign = TextAlign.Center, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(Modifier.height(8.dp))
        Text(
            "Licensed under CC BY-NC-ND 4.0\n" +
                    "You may view and share this app, but modification or commercial use is not allowed.\n\n" +
                    "Learn more: https://creativecommons.org/licenses/by-nc-nd/4.0/",
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}


// ---------- UI Blocks (UNCHANGED, except for adding LocalContext import) ----------
@Composable
fun HeroSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Assuming R.drawable.whatsapp_image_2025_09_09_at_18_31_43 exists
        //  - Placeholder for the image in the Hero Section
        Image(
            painter = painterResource(id = R.drawable.whatsapp_image_2025_09_09_at_18_31_43), // ensure this drawable exists
            contentDescription = "Lord Krishna",
            modifier = Modifier
                .size(120.dp)
                .clip(shape = MaterialTheme.shapes.extraLarge),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Enlighten Your Life with the Wisdom of the Gita",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "An app to bring the eternal knowledge of the Bhagavad Gita to your fingertips.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
fun FeatureCard(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .height(100.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(36.dp),
                tint = MaterialTheme.colorScheme.onSecondaryContainer
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun SectionCard(data: SectionData) {
    InfoCard(title = data.title, icon = data.icon) {
        Text(text = data.englishText, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = data.hindiText, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun YogaItem(title: String, description: String) {
    Column(modifier = Modifier.padding(bottom = 12.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                Icons.Filled.Star,
                contentDescription = "Yoga Path",
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                title,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
        }
        Text(
            text = description,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun DeveloperInfoSection(data: DeveloperData, context: Context) {
    InfoCard(title = "Developer & Contact", icon = Icons.Filled.Code) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Developed by: ${data.name}",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold
            )
            // Email
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { openEmailIntent(context, data.email) }
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.MailOutline,
                    contentDescription = "Email",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = data.email,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            // LinkedIn
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { openUrl(context, data.linkedinUrl) }
                    .padding(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Link,
                    contentDescription = "LinkedIn",
                    modifier = Modifier.size(20.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "LinkedIn Profile",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}

@Composable
fun InfoCard(
    title: String,
    icon: ImageVector,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        SectionHeader(title = title, icon = icon)
        Column(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = content
        )
    }
}

@Composable
fun SectionHeader(title: String, icon: ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp), // Adjust padding for a cleaner look
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "$title Icon",
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
    }
}

// ---------- Intents (UNCHANGED) ----------
private fun openEmailIntent(context: Context, email: String) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$email")
    }
    try {
        context.startActivity(intent)
    } catch (_: Exception) {
        Toast.makeText(context, "No email app found", Toast.LENGTH_SHORT).show()
    }
}

private fun openPlayStore(context: Context, packageName: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
    } catch (_: Exception) {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$packageName")))
    }
}

private fun shareApp(context: Context) {
    val appLink = "https://play.google.com/store/apps/details?id=${context.packageName}"
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Gita Gyan App")
        putExtra(Intent.EXTRA_TEXT, "Read the wisdom of the Bhagavad Gita on your phone. Download Gita Gyan today: $appLink")
    }
    context.startActivity(Intent.createChooser(shareIntent, "Share via"))
}

private fun openUrl(context: Context, url: String) {
    try {
        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    } catch (_: Exception) {
        Toast.makeText(context, "Could not open URL", Toast.LENGTH_SHORT).show()
    }
}

// ---------- Preview (UNCHANGED) ----------
@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen(navController = rememberNavController())
}