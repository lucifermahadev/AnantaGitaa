package com.anantagita.notifications

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.anantagita.MainActivity
import com.anantagita.R
import com.anantagita.model.Shloka
import com.anantagita.data.ShlokaRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import kotlin.random.Random

class DailyWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val endings = listOf(
        "क्या आप इस श्लोक को जानते थे?\nDid you know this shloka?",
        "क्या आपने इस श्लोक पर विचार किया?\nHave you reflected on this shloka?",
        "क्या यह श्लोक आपको प्रेरित करता है?\nDoes this shloka inspire you?",
        "क्या यह श्लोक आपके जीवन से जुड़ता है?\nDoes this shloka relate to your life?",
        "क्या इस श्लोक ने आपको शांति दी?\nDid this shloka bring you peace?",
        "क्या इस श्लोक ने आपका मार्गदर्शन किया?\nDid this shloka guide you?",
        "क्या आपने इसे जीवन में अपनाया है?\nHave you applied this shloka in life?",
        "क्या यह आपके हृदय को छूता है?\nDoes this shloka touch your heart?",
        "क्या यह आपके लिए प्रेरणा का स्रोत है?\nIs this shloka a source of inspiration for you?",
        "क्या आपने इसे दूसरों से साझा किया?\nHave you shared this shloka with others?",
        "क्या आप इस पर ध्यान करेंगे?\nWill you meditate upon this shloka?",
        "क्या यह आपके जीवन में बदलाव ला सकता है?\nCan this shloka bring change to your life?",
        "क्या इसने आपको कर्म की ओर प्रेरित किया?\nDid this inspire you to act?",
        "क्या इसने आपकी आस्था को बढ़ाया?\nDid this increase your faith?",
        "क्या आपने इसकी गहराई को समझा?\nHave you grasped its depth?",
        "क्या इसने आपको उत्तर दिया?\nDid this give you an answer?",
        "क्या यह आपके दिन को उज्ज्वल बना गया?\nDid this brighten your day?",
        "क्या आपने इससे कुछ नया सीखा?\nDid you learn something new?",
        "क्या यह आपको कृष्ण के निकट लाता है?\nDoes this bring you closer to Krishna?",
        "क्या यह आपके लिए जीवन का पथ प्रदर्शक है?\nIs this shloka a guide for your life?"
    )

    override suspend fun doWork(): Result {
        val context = applicationContext

        // ✅ Fetch username from Firestore
        val username = getUserNameFromFirestore()

        // ✅ Pick a random Adhyaya
        val randomAdhyaya = ShlokaRepository.shlokas.keys.random()
        val shlokaList = ShlokaRepository.shlokas[randomAdhyaya].orEmpty()

        if (shlokaList.isNotEmpty()) {
            val randomShloka = shlokaList.random()
            val ending = endings.random()

            val fullMessage = buildMessage(username, randomShloka, ending)

            createAndSendNotification(
                context,
                "daily_channel",
                fullMessage,
                randomAdhyaya,
                randomShloka.number
            )
        }

        return Result.success()
    }

    private suspend fun getUserNameFromFirestore(): String {
        val user = FirebaseAuth.getInstance().currentUser ?: return "प्रिय साधक"
        val db = FirebaseFirestore.getInstance()

        return try {
            val snapshot = db.collection("users")
                .document(user.uid)
                .get()
                .await()

            snapshot.getString("username") ?: "प्रिय साधक"
        } catch (e: Exception) {
            "प्रिय साधक"
        }
    }

    private fun buildMessage(username: String, shloka: Shloka, ending: String): String {
        return "$username जी,\n\n" +
                "अध्याय ${shloka.number} - श्लोक ${shloka.number}\n\n" +
                "${shloka.sanskrit}\n\n" +
                "हिंदी अर्थ:\n${shloka.hindiMeaning}\n\n" +
                "English Meaning:\n${shloka.englishMeaning}\n\n" +
                "$ending"
    }

    private fun createAndSendNotification(
        context: Context,
        channelId: String,
        fullMessage: String,
        adhyayaNumber: Int,
        shlokaNumber: Int
    ) {
        createNotificationChannel(context, channelId)
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("adhyayaNumber", adhyayaNumber)
            putExtra("shlokaNumber", shlokaNumber)
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            Random.nextInt(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("AnantaGita - Daily Shloka")
            .setContentText(fullMessage)
            .setStyle(NotificationCompat.BigTextStyle().bigText(fullMessage))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

        // ✅ Permission check
        if (ActivityCompat.checkSelfPermission(
                context,
                Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED ||
            Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU
        ) {
            val notificationId = (System.currentTimeMillis() % Int.MAX_VALUE).toInt()
            NotificationManagerCompat.from(context).notify(notificationId, builder.build())
        }
    }

    private fun createNotificationChannel(context: Context, channelId: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = context.getString(R.string.notification_channel_name)
            val descriptionText = context.getString(R.string.notification_channel_description)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(channelId, name, importance).apply {
                description = descriptionText
            }
            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
