package com.anantagita.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.anantagita.navigation.Screen
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.anantagita.R
import com.anantagita.model.Shloka
import com.anantagita.ads.AdsManager.BannerAdView
val adhyayaTenShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "श्रीभगवानुवाच ।\nभूय एव महाबाहो शृणु मे परमं वचः ।\nयत्तेऽहं प्रीयमाणाय वक्ष्यामि हितकाम्यया ॥",
        hindiMeaning = "भगवान श्रीकृष्ण कहते हैं – हे महाबाहु अर्जुन! अब तू पुनः मेरे परम वचनों को सुन। मैं तुझे ये वचन इसलिए कह रहा हूँ क्योंकि तू मुझे अत्यंत प्रिय है और मैं तेरे हित की ही कामना करता हूँ। यह श्लोक भगवान और अर्जुन के बीच के आत्मीय संबंध को प्रकट करता है। जब भक्त पूर्ण श्रद्धा से ईश्वर की शरण में आता है, तो भगवान उसके कल्याण के लिए सर्वोत्तम ज्ञान प्रदान करते हैं। इस प्रकार भगवान अपने भक्त को प्रेम और करुणा से मार्गदर्शन देते हैं।",
        englishMeaning = "The Blessed Lord said: O mighty-armed Arjuna, hear again My supreme words, which I speak to you out of love, desiring your welfare."
    ),
    Shloka(
        number = 2,
        sanskrit = "न मे विदुः सुरगणाः प्रभवं न महर्षयः ।\nअहमादिर्हि देवानां महर्षीणां च सर्वशः ॥",
        hindiMeaning = "भगवान कहते हैं – न तो देवता और न ही महर्षि मेरे उद्गम को जानते हैं। क्योंकि मैं ही देवताओं और महर्षियों का आदि कारण हूँ। यहाँ भगवान अपनी अनादि और अनंत सत्ता का वर्णन कर रहे हैं। देवता और ऋषि भी ईश्वर की उत्पत्ति नहीं जान सकते, क्योंकि वे स्वयं उनकी शक्ति से प्रकट हुए हैं। यह श्लोक हमें समझाता है कि परमात्मा से परे कुछ भी नहीं है और वे ही सबका मूल स्रोत हैं।",
        englishMeaning = "Neither the hosts of gods nor the great sages know My origin, for I am the source of all the gods and sages."
    ),
    Shloka(
        number = 3,
        sanskrit = "यो मामजमनादिं च वेत्ति लोकमहेश्वरम् ।\nअसम्मूढः स मर्त्येषु सर्वपापैः प्रमुच्यते ॥",
        hindiMeaning = "जो मनुष्य मुझे अजन्मा, अनादि और लोकों का महान ईश्वर जानता है, वह असम्मूढ़ होकर सभी पापों से मुक्त हो जाता है। यहाँ भगवान स्पष्ट करते हैं कि ईश्वर का सच्चा ज्ञान ही मुक्ति का मार्ग है। जब साधक यह समझ लेता है कि परमात्मा ही सबका नियंता और आधार हैं, तब उसके मोह और भ्रम का नाश हो जाता है। इस ज्ञान से मनुष्य के कर्मजन्य बंधन भी समाप्त हो जाते हैं।",
        englishMeaning = "He who knows Me as unborn, without beginning, and the Lord of all worlds is undeluded and freed from all sins among mortals."
    ),
    Shloka(
        number = 4,
        sanskrit = "बुद्धिर्ज्ञानमसम्मोहः क्षमा सत्यं दमः शमः ।\nसुखं दुःखं भवोऽभावो भयं चाभयमेव च ॥",
        hindiMeaning = "भगवान कहते हैं – बुद्धि, ज्ञान, असम्मोह (विवेक), क्षमा, सत्य, दम (इन्द्रिय संयम), शम (मन का नियंत्रण), सुख और दुःख, उत्पत्ति और विनाश, भय और अभय – ये सब मुझसे ही उत्पन्न होते हैं। यह श्लोक हमें बताता है कि मानवीय गुण और अनुभव सब भगवान की शक्ति से ही प्रकट होते हैं। चाहे वे सकारात्मक हों या नकारात्मक, सबका मूल स्रोत वही परमात्मा हैं। साधक को यह समझना चाहिए कि ईश्वर ही हर स्थिति के कारण हैं।",
        englishMeaning = "Intellect, knowledge, freedom from delusion, forgiveness, truthfulness, self-control, calmness, happiness and sorrow, birth and death, fear and fearlessness—all arise from Me alone."
    ),
    Shloka(
        number = 5,
        sanskrit = "अहिंसा समता तुष्टिस्तपो दानं यशोऽयशः ।\nभवन्ति भावा भूतानां मत्त एव पृथग्विधाः ॥",
        hindiMeaning = "भगवान कहते हैं – अहिंसा, समभाव, संतोष, तप, दान, यश और अपयश – ये सब भिन्न-भिन्न भाव भी मुझसे ही उत्पन्न होते हैं। यह श्लोक बताता है कि संसार में जो भी गुण और भाव देखने को मिलते हैं, वे सब ईश्वर की अभिव्यक्ति हैं। चाहे वे सुखद हों या दुःखद, सबका मूल वही है। इसका अर्थ यह है कि साधक को हर स्थिति में ईश्वर का ही दर्शन करना चाहिए।",
        englishMeaning = "Non-violence, equanimity, contentment, austerity, charity, fame, and infamy—all these various dispositions of beings arise from Me."
    ),
    Shloka(
        number = 6,
        sanskrit = "महर्षयः सप्त पूर्वे चत्वारो मनवस्तथा ।\nमद्भावा मानसा जाता येषां लोक इमाः प्रजाः ॥",
        hindiMeaning = "भगवान कहते हैं – सात महर्षि और चार मनु भी मेरे भाव से ही उत्पन्न हुए। इन्हीं से संसार की सारी प्रजाएँ उत्पन्न हुई हैं। यह श्लोक बताता है कि सृष्टि का आरंभ भी ईश्वर की शक्ति से हुआ है। चाहे वह महर्षि हों या मनु, सब परमात्मा से ही प्रकट हुए हैं। इस प्रकार सम्पूर्ण सृष्टि का मूल ईश्वर ही हैं।",
        englishMeaning = "The seven great sages and the four Manus of old were born of My mind, and from them all creatures in the world have descended."
    ),
    Shloka(
        number = 7,
        sanskrit = "एतां विभूतिं योगं च मम यो वेत्ति तत्त्वतः ।\nसोऽविकम्पेन योगेन युज्यते नात्र संशयः ॥",
        hindiMeaning = "जो मनुष्य मेरी विभूतियों और योगशक्ति को तत्व से जानता है, वह अटल योग में स्थित हो जाता है। इसमें कोई संशय नहीं है। यह श्लोक हमें बताता है कि जब साधक ईश्वर की अनंत शक्तियों और उनकी विभूतियों को समझ लेता है, तो उसका मन स्थिर हो जाता है। उसे ईश्वर के प्रति अडिग विश्वास प्राप्त होता है। यही अडिग योग ही साधना का परम फल है।",
        englishMeaning = "He who truly knows this glory and power of Mine is united with Me through unwavering yoga—of this there is no doubt."
    ),
    Shloka(
        number = 8,
        sanskrit = "अहं सर्वस्य प्रभवो मत्तः सर्वं प्रपर्तते ।\nइति मत्वा भजन्ते मां बुधा भावसमन्विताः ॥",
        hindiMeaning = "भगवान कहते हैं – मैं ही सम्पूर्ण सृष्टि का मूल कारण हूँ। मुझसे ही सब प्रकट होते हैं और मुझमें ही स्थित हैं। यह जानकर बुद्धिमान व्यक्ति भावपूर्ण भक्ति के साथ मेरी उपासना करते हैं। यह श्लोक हमें यह सिखाता है कि जब साधक समझ लेता है कि सबका मूल ईश्वर हैं, तो उसके भीतर स्वाभाविक भक्ति उत्पन्न हो जाती है। बुद्धिमान व्यक्ति सदा भावपूर्वक भगवान की शरण में जाता है।",
        englishMeaning = "I am the source of all creation; everything emanates from Me. The wise, knowing this, worship Me with loving devotion."
    ),
    Shloka(
        number = 9,
        sanskrit = "मच्चित्ता मद्गतप्राणा बोधयन्तः परस्परम् ।\nकथयन्तश्च मां नित्यं तुष्यन्ति च रमन्ति च ॥",
        hindiMeaning = "वे भक्त जिनका मन मुझमें ही स्थिर है और जिनका जीवन मुझमें ही लगा हुआ है, वे एक-दूसरे को मेरी बातें बताते रहते हैं। वे सदैव मेरे गुणों का कीर्तन करते हैं और उसमें संतुष्टि और आनंद प्राप्त करते हैं। यह श्लोक सच्चे भक्तों के लक्षण बताता है। ऐसे भक्त ईश्वर के चिंतन और नामस्मरण में ही आनंद पाते हैं। भक्ति ही उनका जीवन बन जाती है।",
        englishMeaning = "With minds fixed on Me and lives dedicated to Me, My devotees enlighten one another and speak of Me constantly; they are satisfied and rejoice together."
    ),
    Shloka(
        number = 10,
        sanskrit = "तेषां सततयुक्तानां भजतां प्रीतिपूर्वकम् ।\nददामि बुद्धियोगं तं येन मामुपयान्ति ते ॥",
        hindiMeaning = "जो लोग सदा योग में स्थित रहते हैं और प्रेमपूर्वक मेरी भक्ति करते हैं, मैं उन्हें वह बुद्धियोग प्रदान करता हूँ, जिससे वे मुझे प्राप्त कर सकें। यह श्लोक बताता है कि भगवान स्वयं भक्त के मार्ग को प्रकाशित करते हैं। जब साधक पूरी श्रद्धा से भगवान की भक्ति करता है, तो उसकी साधना में भगवान ही मार्गदर्शन करते हैं। यही बुद्धियोग है, जो अंततः ईश्वर तक ले जाता है।",
        englishMeaning = "To those who are constantly devoted and worship Me with love, I give the yoga of wisdom by which they come to Me."
    ),
    Shloka(
        number = 11,
        sanskrit = "तेषामेवानुकम्पार्थमहमज्ञानजं तमः ।\nनाशयाम्यात्मभावस्थो ज्ञानदीपेन भाजस्वतः ॥",
        hindiMeaning = "उन पर अनुकम्पा करने के लिए, मैं उनके अज्ञानजन्य अंधकार का नाश करता हूँ। मैं उनके हृदय में स्थित होकर ज्ञानरूपी दीपक से उस अंधकार को मिटा देता हूँ। यह श्लोक भगवान की करुणा को दर्शाता है। सच्चा भक्त जब ईश्वर की शरण लेता है, तो भगवान स्वयं उसके अज्ञान को दूर कर ज्ञान का प्रकाश देते हैं। इस प्रकार साधक का जीवन आलोकित हो जाता है।",
        englishMeaning = "Out of compassion for them, I dwell in their hearts and destroy the darkness of ignorance with the shining lamp of knowledge."
    ),
    Shloka(
        number = 12,
        sanskrit = "अर्जुन उवाच ।\nपरं ब्रह्म परं धाम पवित्रं परमं भवान् ।\nपुरुषं शाश्वतं दिव्यमादिदेवं अजं विभुम् ॥",
        hindiMeaning = "अर्जुन कहते हैं – आप ही परम ब्रह्म, परम धाम और परम पवित्र हैं। आप शाश्वत पुरुष, दिव्य और आदिदेव हैं। आप अजन्मा और सर्वव्यापक हैं। यह श्लोक अर्जुन की भक्ति और श्रद्धा को प्रकट करता है। भगवान के स्वरूप को जानकर अर्जुन उनकी महिमा का गुणगान करते हैं। यह भक्त की सच्ची अवस्था है, जब वह ईश्वर के वैभव को पहचानता है।",
        englishMeaning = "Arjuna said: You are the Supreme Brahman, the supreme abode, the supreme purifier, the eternal divine Person, the primal God, unborn, and all-pervading."
    ),
    Shloka(
        number = 13,
        sanskrit = "आहुस्त्वामृषयः सर्वे देवर्षिर्नारदस्तथा ।\nअसितो देवलो व्यासः स्वयं चैव ब्रवीषि मे ॥",
        hindiMeaning = "अर्जुन कहते हैं – सभी ऋषि आपको ऐसा ही बताते हैं, देवर्षि नारद, असित, देवल और व्यास भी यही कहते हैं। और आप स्वयं भी मुझसे यही कह रहे हैं। यह श्लोक इस बात का प्रमाण देता है कि ईश्वर के स्वरूप की पुष्टि अनेक ऋषियों और शास्त्रों ने की है। भक्त केवल अपने अनुभव से ही नहीं, बल्कि ऋषियों के वचनों और शास्त्रों से भी ईश्वर की महिमा को समझता है।",
        englishMeaning = "All the sages proclaim You as such, and so do the divine sage Narada, Asita, Devala, and Vyasa. You Yourself also declare it to me."
    ),
    Shloka(
        number = 14,
        sanskrit = "सर्वमेतदृतं मन्ये यन्मां वदसि केशव ।\nन हि ते भगवन् व्यक्तिं विदुर्देवा न दानवाः ॥",
        hindiMeaning = "अर्जुन कहते हैं – हे केशव! जो कुछ भी आप मुझसे कहते हैं, मैं उसे सत्य मानता हूँ। हे भगवान! न तो देवता और न ही दानव आपकी वास्तविकता को जान सकते हैं। यह श्लोक बताता है कि ईश्वर का स्वरूप मानव की साधारण समझ से परे है। यहाँ तक कि देवता और दानव भी उन्हें पूरी तरह नहीं समझ सकते। भक्त को भी केवल ईश्वर की कृपा से ही उनका सच्चा ज्ञान प्राप्त होता है।",
        englishMeaning = "O Krishna, I accept as true all that You say to me. Neither the gods nor the demons comprehend Your real manifestation."
    ),
    Shloka(
        number = 15,
        sanskrit = "स्वयमेवात्मनात्मानं वेत्थ त्वं पुरुषोत्तम ।\nभूतभावन भूतेश देवदेव जगत्पते ॥",
        hindiMeaning = "अर्जुन कहते हैं – हे पुरुषोत्तम! आप स्वयं ही अपने स्वरूप को जानते हैं। आप भूतों के भावनहार, उनके ईश्वर, देवताओं के देवता और जगत के स्वामी हैं। यह श्लोक बताता है कि परमात्मा का सच्चा ज्ञान केवल परमात्मा के पास ही है। मनुष्य केवल उनकी कृपा से ही कुछ जान सकता है। भक्त इस बात को स्वीकार करता है कि ईश्वर ही सबके स्वामी हैं।",
        englishMeaning = "O Supreme Person, You alone know Yourself truly. You are the origin of beings, the Lord of beings, the God of gods, and the Lord of the universe."
    ),
    Shloka(
        number = 16,
        sanskrit = "वक्तुमर्हस्यशेषेण दिव्या ह्यात्मविभूतयः ।\nयाभिर्विभूतिभिर्लोकानिमांस्त्वं व्याप्य तिष्ठसि ॥",
        hindiMeaning = "अर्जुन कहते हैं – आप अपनी दिव्य विभूतियों को संपूर्ण रूप से बताने योग्य हैं। उन विभूतियों के द्वारा आप इस सम्पूर्ण जगत को व्याप्त करके स्थित हैं। यह श्लोक भक्त की जिज्ञासा को दर्शाता है। अर्जुन चाहता है कि भगवान अपनी अनंत शक्तियों और विभूतियों को विस्तार से बताएं, जिससे उनका हृदय और अधिक श्रद्धा से भर जाए। यह भक्ति का स्वाभाविक भाव है कि भक्त भगवान की महिमा सुनकर आनन्दित होता है।",
        englishMeaning = "You should indeed speak to me fully of Your divine glories, by which You pervade and sustain all these worlds."
    ),
    Shloka(
        number = 17,
        sanskrit = "कथं विद्यामहं योगिन्त्वां सदा परिचिन्तयन् ।\nकेषु केषु च भावेषु चिन्त्योऽसि भगवन्मया ॥",
        hindiMeaning = "अर्जुन पूछते हैं – हे योगेश्वर! मैं आपको किस प्रकार सदा ध्यान में रखूँ? और किन-किन रूपों में हे भगवान! आपको मुझे चिंतन करना चाहिए? यह श्लोक अर्जुन की साधक रूपी स्थिति को बताता है। वह यह जानना चाहता है कि भगवान की उपासना किस प्रकार की जाए। भक्त का यह प्रश्न यह दिखाता है कि सही भक्ति के लिए मार्गदर्शन आवश्यक है।",
        englishMeaning = "O Lord, how shall I know You by constant meditation? In what forms, O Blessed Lord, should I think of You?"
    ),
    Shloka(
        number = 18,
        sanskrit = "विस्तरेणात्मनो योगं विभूतिं च जनार्दन ।\nभूयः कथय तृप्तिर्हि शृण्वतो नास्ति मेऽमृतम् ॥",
        hindiMeaning = "अर्जुन कहते हैं – हे जनार्दन! आप पुनः विस्तार से अपनी योगशक्ति और विभूतियों का वर्णन करें। क्योंकि आपके अमृतमय वचनों को सुनकर मुझे कभी तृप्ति नहीं होती। यह श्लोक भक्त के हृदय का भाव दर्शाता है। सच्चा भक्त भगवान की महिमा सुनने में कभी ऊबता नहीं, बल्कि बार-बार सुनने की इच्छा करता है। यही भक्ति की प्यास है।",
        englishMeaning = "O Janardana, please again describe in detail Your yoga and glories. For I never tire of hearing Your nectar-like words."
    ),
    Shloka(
        number = 19,
        sanskrit = "श्रीभगवानुवाच ।\nहन्त ते कथयिष्यामि दिव्या ह्यात्मविभूतयः ।\nप्राधान्यतः कुरुश्रेष्ठ नास्त्यन्तो विस्तरस्य मे ॥",
        hindiMeaning = "भगवान कहते हैं – हे कुरुश्रेष्ठ! अब मैं तुझे अपनी दिव्य विभूतियों का वर्णन करूंगा। परंतु यह वर्णन केवल मुख्य-मुख्य रूपों में होगा, क्योंकि मेरी विभूतियों का कोई अंत नहीं है। यह श्लोक बताता है कि भगवान की विभूतियाँ असीम हैं। वे केवल कुछ उदाहरण देकर भक्त के हृदय में भक्ति को दृढ़ करते हैं। यह भक्त के लिए पर्याप्त है कि वह ईश्वर की अनंतता को समझ ले।",
        englishMeaning = "The Blessed Lord said: I shall now declare to you My divine glories, O best of the Kurus, but only the chief ones, for there is no end to My vastness."
    ),
    Shloka(
        number = 20,
        sanskrit = "अहमात्मा गुडाकेश सर्वभूताशयस्थितः ।\nअहमादिश्च मध्यं च भूतानामन्त एव च ॥",
        hindiMeaning = "भगवान कहते हैं – हे गुडाकेश (अर्जुन)! मैं ही सब प्राणियों के हृदय में स्थित आत्मा हूँ। मैं ही सभी भूतों का आदि, मध्य और अंत हूँ। यह श्लोक स्पष्ट करता है कि ईश्वर हर जीव में आत्मरूप से उपस्थित हैं। वे ही सबका आरंभ, बीच और अंत हैं। साधक को यह जानना चाहिए कि जीवन का संपूर्ण प्रवाह ईश्वर से ही जुड़ा है।",
        englishMeaning = "O Arjuna, I am the Self seated in the hearts of all beings. I am the beginning, the middle, and also the end of all beings."
    ),
    Shloka(
        number = 21,
        sanskrit = "आदित्यानामहं विष्णुर्ज्योतिषां रविरंशुमान् ।\nमरीचिर्मरुतामस्मि नक्षत्राणामहं शशी ॥",
        hindiMeaning = "भगवान कहते हैं – आदित्यों में मैं विष्णु हूँ, ज्योतिषियों (प्रकाश देने वालों) में मैं किरणों से युक्त सूर्य हूँ। मरुतों में मैं मरीचि हूँ और नक्षत्रों में मैं चंद्रमा हूँ। यह श्लोक स्पष्ट करता है कि भगवान प्रत्येक समूह में सर्वोत्तम रूप से प्रकट होते हैं। जब भक्त संसार के श्रेष्ठ और चमकते रूपों को देखता है, तो उसे उनमें भगवान की झलक मिलती है। यह दृष्टिकोण भक्त को हर वस्तु में ईश्वर का अनुभव कराता है।",
        englishMeaning = "Among the Adityas, I am Vishnu; among lights, I am the radiant Sun. Among the Maruts, I am Marichi; among stars, I am the Moon."
    ),
    Shloka(
        number = 22,
        sanskrit = "वेदानां सामवेदोऽस्मि देवानामस्मि वासवः ।\nइन्द्रियाणां मनश्चास्मि भूतानामस्मि चेतना ॥",
        hindiMeaning = "भगवान कहते हैं – वेदों में मैं सामवेद हूँ, देवताओं में मैं वासव (इंद्र) हूँ। इन्द्रियों में मैं मन हूँ और भूतों में मैं चेतना हूँ। यह श्लोक हमें बताता है कि वेदों में सामवेद की मधुरता और देवताओं में इंद्र का बल भगवान की ही अभिव्यक्ति है। इसी प्रकार मन और चेतना, जो जीवन के केंद्र हैं, वे भी ईश्वर से ही उत्पन्न होते हैं। साधक को समझना चाहिए कि हर श्रेष्ठता का मूल ईश्वर ही हैं।",
        englishMeaning = "Of the Vedas, I am the Sama Veda; of the gods, I am Indra. Of the senses, I am the mind; and among beings, I am consciousness."
    ),
    Shloka(
        number = 23,
        sanskrit = "रुद्राणां शङ्करश्चास्मि वित्तेशो यक्षरक्षसाम् ।\nवसूनां पावकश्चास्मि मेरुः शिखरिणामहम् ॥",
        hindiMeaning = "भगवान कहते हैं – रुद्रों में मैं शंकर हूँ, यक्ष और राक्षसों में मैं धन के स्वामी कुबेर हूँ। वसुओं में मैं अग्नि हूँ और पर्वतों में मैं सुमेरु हूँ। यह श्लोक दर्शाता है कि भगवान शक्तिशाली और महानतम रूपों में प्रकट होते हैं। चाहे वह विनाश के देव शंकर हों, संपत्ति के स्वामी कुबेर हों, अग्नि की शक्ति हो या पर्वतों का विशाल रूप, सबमें ईश्वर की ही छवि है।",
        englishMeaning = "Among the Rudras, I am Shankara; among Yakshas and Rakshasas, I am Kubera. Among the Vasus, I am Agni; among mountains, I am Meru."
    ),
    Shloka(
        number = 24,
        sanskrit = "पुरोधसां च मुख्यं मां विद्धि पार्थ बृहस्पतिम् ।\nसेनानीनामहं स्कन्दः सरसामस्मि सागरः ॥",
        hindiMeaning = "भगवान कहते हैं – हे पार्थ! पुरोहितों में मैं बृहस्पति हूँ। सेनानायकों में मैं स्कन्द (कार्तिकेय) हूँ और जलाशयों में मैं समुद्र हूँ। यह श्लोक बताता है कि धर्म के ज्ञाता बृहस्पति, युद्ध के वीर सेनापति कार्तिकेय और समुद्र की विशालता – ये सब भगवान की विभूतियाँ हैं। भक्त जब इन्हें देखता है तो उसे ईश्वर का वैभव स्मरण होना चाहिए।",
        englishMeaning = "Among priests, I am Brihaspati; among generals, I am Skanda; among bodies of water, I am the ocean."
    ),
    Shloka(
        number = 25,
        sanskrit = "महर्षीणां भृगुरहं गिरामस्म्येकमक्षरम् ।\nयज्ञानां जपयज्ञोऽस्मि स्थावराणां हिमालयः ॥",
        hindiMeaning = "भगवान कहते हैं – महर्षियों में मैं भृगु हूँ, वाणियों में मैं एक अक्षर (ॐ) हूँ। यज्ञों में मैं जपयज्ञ हूँ और स्थावर (अचल वस्तुओं) में मैं हिमालय हूँ। यह श्लोक स्पष्ट करता है कि भगवान सादगी और महत्ता दोनों में प्रकट होते हैं। ॐ का स्वर, जप की सरलता और हिमालय की विशालता सब ईश्वर की अभिव्यक्ति हैं।",
        englishMeaning = "Among great sages, I am Bhrigu; of words, I am the single syllable Om. Of sacrifices, I am japa (chanting); of immovable things, I am the Himalayas."
    ),
    Shloka(
        number = 26,
        sanskrit = "अश्वत्थः सर्ववृक्षाणां देवर्षीणां च नारदः ।\nगन्धर्वाणां चित्ररथः सिद्धानां कपिलो मुनिः ॥",
        hindiMeaning = "भगवान कहते हैं – वृक्षों में मैं अश्वत्थ (पीपल) हूँ, देवर्षियों में मैं नारद हूँ। गंधर्वों में मैं चित्ररथ हूँ और सिद्धों में मैं कपिल मुनि हूँ। यह श्लोक दर्शाता है कि भगवान धर्म, कला और ज्ञान के श्रेष्ठतम रूपों में प्रकट होते हैं। भक्त को हर श्रेष्ठ सत्ता में ईश्वर की झलक देखनी चाहिए।",
        englishMeaning = "Among trees, I am the Peepal tree; among divine sages, I am Narada. Among Gandharvas, I am Chitraratha; among Siddhas, I am Kapila."
    ),
    Shloka(
        number = 27,
        sanskrit = "उच्चैःश्रवसमश्वानां विद्धि माममृतोद्भवम् ।\nऐरावतं गजेन्द्राणां नराणां च नराधिपम् ॥",
        hindiMeaning = "भगवान कहते हैं – घोड़ों में मैं उच्चैःश्रवा हूँ, जो समुद्र मंथन से प्रकट हुआ। गजेन्द्रों में मैं ऐरावत हूँ और मनुष्यों में मैं राजा हूँ। यह श्लोक बताता है कि ऐश्वर्य, शक्ति और नेतृत्व का सर्वोत्तम रूप भी भगवान की विभूति है। साधक को यह देखना चाहिए कि नेतृत्व और सामर्थ्य ईश्वर का ही वरदान है।",
        englishMeaning = "Among horses, I am Ucchaisravas, born of the nectar; among elephants, I am Airavata; among men, I am the king."
    ),
    Shloka(
        number = 28,
        sanskrit = "आयुधानामहं वज्रं धेनूनामस्मि कामधुक् ।\nप्रजनश्चास्मि कन्दर्पः सर्पाणामस्मि वासुकिः ॥",
        hindiMeaning = "भगवान कहते हैं – अस्त्रों में मैं वज्र हूँ, धेनुओं में मैं कामधेनु हूँ। सृजन में मैं कामदेव हूँ और सर्पों में मैं वासुकि हूँ। यह श्लोक स्पष्ट करता है कि शक्ति, संपन्नता, सृजन और रहस्यमय शक्ति – सबका मूल भगवान हैं।",
        englishMeaning = "Among weapons, I am the thunderbolt; among cows, I am Kamadhenu. I am Kandarpa, the cause of procreation; among serpents, I am Vasuki."
    ),
    Shloka(
        number = 29,
        sanskrit = "अनन्तश्चास्मि नागानां वरुणो यादसामहम् ।\nपितॄणामर्यमा चास्मि यमः संयमतामहम् ॥",
        hindiMeaning = "भगवान कहते हैं – नागों में मैं अनंत हूँ, जलचर प्राणियों में मैं वरुण हूँ। पितरों में मैं अर्यमा हूँ और संयम करने वालों में मैं यमराज हूँ। यह श्लोक बताता है कि ईश्वर अनंत शक्ति, जल का स्वामी, पूर्वजों का आदर और न्याय के रूप में प्रकट होते हैं।",
        englishMeaning = "Among serpents, I am Ananta; among aquatics, I am Varuna. Among ancestors, I am Aryama; among controllers, I am Yama."
    ),
    Shloka(
        number = 30,
        sanskrit = "प्रह्लादश्चास्मि दैत्यानां कालः कलयतामहम् ।\nमृगाणां च मृगेन्द्रोऽहं वैनतेयश्च पक्षिणाम् ॥",
        hindiMeaning = "भगवान कहते हैं – दैत्यों में मैं प्रह्लाद हूँ, गणना करने वालों में मैं काल हूँ। पशुओं में मैं सिंह हूँ और पक्षियों में मैं गरुड़ (वैनतेय) हूँ। यह श्लोक भक्त को यह सिखाता है कि धर्म, समय, बल और आकाश की स्वतंत्रता – सब ईश्वर के रूप हैं।",
        englishMeaning = "Among the Daityas, I am Prahlada; among calculators, I am time. Among beasts, I am the lion; among birds, I am Garuda."
    ),
    Shloka(
        number = 31,
        sanskrit = "पवनः पवतामस्मि रामः शस्त्रभृतामहम् ।\nझषाणां मकరश्चास्मि स्रोतसामस्मि जान्हवः ॥",
        hindiMeaning = "भगवान कहते हैं – शुद्ध करने वालों में मैं पवन हूँ, शस्त्रधारियों में मैं राम हूँ। मछलियों में मैं मगरमच्छ हूँ और नदियों में मैं गंगा हूँ। यह श्लोक दर्शाता है कि पवित्रता, धर्मरक्षा, शक्ति और पवित्र जलधारा – सब ईश्वर की विभूतियाँ हैं।",
        englishMeaning = "Among purifiers, I am the wind; among warriors, I am Rama. Among fishes, I am the shark; among rivers, I am the Ganges."
    ),
    Shloka(
        number = 32,
        sanskrit = "सर्गाणामादिरन्तश्च मध्यं चैवाहमर्जुन ।\nअध्यात्मविद्या विद्यानां वादः प्रवदतामहम् ॥",
        hindiMeaning = "भगवान कहते हैं – हे अर्जुन! सृष्टियों का आदि, मध्य और अंत मैं ही हूँ। विद्या में मैं आत्मविद्या हूँ और विवाद करने वालों में मैं तर्क हूँ। यह श्लोक दर्शाता है कि ईश्वर ही जीवन के आरंभ से अंत तक उपस्थित हैं और सर्वोच्च ज्ञान आत्मविद्या है।",
        englishMeaning = "Of creations, I am the beginning, middle, and end, O Arjuna. Of sciences, I am the science of the Self; among debaters, I am logical reasoning."
    ),
    Shloka(
        number = 33,
        sanskrit = "अक्षराणामकारोऽस्मि द्वन्द्वः सामासिकस्य च ।\nअहमेवाक्षयः कालो धाताहं विश्वतोमुखः ॥",
        hindiMeaning = "भगवान कहते हैं – अक्षरों में मैं अकार हूँ और समासों में मैं द्वंद्व हूँ। मैं ही अक्षय काल हूँ और सब दिशाओं में मुख वाला धाता हूँ। यह श्लोक बताता है कि भाषा, समय और सृष्टि की मूल धुरी भी भगवान हैं।",
        englishMeaning = "Of letters, I am the letter A; of compounds, I am the dual. I am the inexhaustible time, and I am the all-faced dispenser."
    ),
    Shloka(
        number = 34,
        sanskrit = "मृत्युः सर्वहरश्चाहमुद्भवश्च भविष्यताम् ।\nकीर्तिः श्रीर्वाक्च नारीणां स्मृतिर्मेधा धृतिः क्षमा ॥",
        hindiMeaning = "भगवान कहते हैं – मैं सबका हरण करने वाला मृत्यु हूँ और भविष्य में उत्पन्न होने वाला जन्म भी मैं ही हूँ। स्त्रियों में मैं कीर्ति, श्री, वाणी, स्मृति, मेधा, धृति और क्षमा हूँ। यह श्लोक दर्शाता है कि जीवन और मृत्यु दोनों ही भगवान की सत्ता हैं और श्रेष्ठ स्त्रैण गुण भी ईश्वर की अभिव्यक्ति हैं।",
        englishMeaning = "I am all-seizing death, and the origin of all that shall be. Among women, I am fame, prosperity, speech, memory, intelligence, firmness, and forgiveness."
    ),
    Shloka(
        number = 35,
        sanskrit = "बृहत्साम तथा साम्नां गायत्री छन्दसामहम् ।\nमासानां मार्गशीर्षोऽहमृतूनां कुसुमाकरः ॥",
        hindiMeaning = "भगवान कहते हैं – सामवेद में मैं बृहत्साम हूँ, छंदों में मैं गायत्री हूँ। महीनों में मैं मार्गशीर्ष हूँ और ऋतुओं में मैं वसंत हूँ। यह श्लोक बताता है कि संगीत, छंद, समय और ऋतु की सुंदरता भी भगवान की विभूतियाँ हैं।",
        englishMeaning = "Of the Sama hymns, I am the Brihatsama; among meters, I am Gayatri. Of months, I am Margashirsha; of seasons, I am spring."
    ),
    Shloka(
        number = 36,
        sanskrit = "द्यूतं छलयतामस्मि तेजस्तेजस्विनामहम् ।\nजयोऽस्मि व्यवसायोऽस्मि सत्त्वं सत्त्ववतामहम् ॥",
        hindiMeaning = "भगवान कहते हैं – छल करने वालों में मैं जुआ हूँ, तेजस्वियों में मैं तेज हूँ। विजय में मैं ही हूँ, प्रयास में मैं ही हूँ और सत्त्ववानों में मैं सत्त्व हूँ। यह श्लोक बताता है कि शक्ति, उत्साह और गुणों का स्रोत भी भगवान हैं।",
        englishMeaning = "Of the deceitful, I am gambling; of the splendid, I am splendor. I am victory, I am effort, I am the goodness of the good."
    ),
    Shloka(
        number = 37,
        sanskrit = "वृष्णीनां वासुदेवोऽस्मि पाण्डवानां धनंजयः ।\nमुनीनामप्यहं व्यासः कवीनामुशना कविः ॥",
        hindiMeaning = "भगवान कहते हैं – वृष्णियों में मैं वासुदेव हूँ, पाण्डवों में मैं धनंजय (अर्जुन) हूँ। मुनियों में मैं व्यास हूँ और कवियों में मैं शुक्राचार्य हूँ। यह श्लोक दिखाता है कि भगवान अपने प्रियतम भक्तों और विद्वानों में प्रकट होते हैं।",
        englishMeaning = "Among the Vrishnis, I am Vasudeva; among the Pandavas, I am Arjuna. Among sages, I am Vyasa; among poets, I am Ushanas."
    ),
    Shloka(
        number = 38,
        sanskrit = "दण्डो दमयतामस्मि नीतिरस्मि जिगीषताम् ।\nमौनं चैवास्मि गुह्यानां ज्ञानं ज्ञानवतामहम् ॥",
        hindiMeaning = "भगवान कहते हैं – दमन करने वालों में मैं दण्ड हूँ, विजय की इच्छा रखने वालों में मैं नीति हूँ। गुप्त बातों में मैं मौन हूँ और ज्ञानियों में मैं ज्ञान हूँ। यह श्लोक दर्शाता है कि नीति, अनुशासन, मौन और ज्ञान का आधार भी भगवान हैं।",
        englishMeaning = "Of punishments, I am the rod; among seekers of victory, I am policy. Of secrets, I am silence; of the wise, I am knowledge."
    ),
    Shloka(
        number = 39,
        sanskrit = "यच्चापि सर्वभूतानां बीजं तदहमर्जुन ।\nन तदस्ति विना यत्स्यान्मया भूतं चराचरम् ॥",
        hindiMeaning = "भगवान कहते हैं – हे अर्जुन! जो भी बीज सब प्राणियों में है, वह मैं हूँ। ऐसा कुछ भी नहीं है, चाहे चल हो या अचल, जो मेरे बिना अस्तित्व में हो। यह श्लोक स्पष्ट करता है कि ईश्वर ही जीवन और जगत के मूल बीज हैं।",
        englishMeaning = "Whatever is the seed of all beings, O Arjuna, that am I. Nothing moving or unmoving exists without Me."
    ),
    Shloka(
        number = 40,
        sanskrit = "नान्तोऽस्ति मम दिव्यानां विभूतीनां परन्तप ।\nएष तूद्देशतः प्रोक्तो विभूतेर्विस्तरो मया ॥",
        hindiMeaning = "भगवान कहते हैं – हे परंतप! मेरी दिव्य विभूतियों का कोई अंत नहीं है। जो मैंने तुझे कहा है, वह तो केवल संक्षेप में बताया गया है। यह श्लोक दर्शाता है कि भगवान की विभूतियाँ असीम और अनंत हैं। उन्होंने अर्जुन को केवल कुछ उदाहरण देकर समझाया है।",
        englishMeaning = "There is no end to My divine glories, O conqueror of foes. What I have spoken to you is only a brief description of My vastness."
    ),
    Shloka(
        number = 41,
        sanskrit = "यद्यद्विभूतिमत्सत्त्वं श्रीमदूर्जितमेव वा ।\nतत्तदेवावगच्छ त्वं मम तेजोंऽशसम्भवम् ॥",
        hindiMeaning = "भगवान कहते हैं – जो भी विभूतियुक्त, शोभायुक्त और उन्नत वस्तु है, उसे तू मेरा ही अंश समझ। वह सब मेरे तेज का ही अंश है। यह श्लोक सिखाता है कि जीवन में हर श्रेष्ठता ईश्वर की ही कृपा है।",
        englishMeaning = "Whatever is endowed with glory, beauty, or power, know that to be born of a fragment of My splendor."
    ),
    Shloka(
        number = 42,
        sanskrit = "अथवा बहुनैतेन किं ज्ञातेन तवार्जुन ।\nविष्टभ्याहमिदं कृत्स्नमेकांशेन स्थितो जगत् ॥",
        hindiMeaning = "भगवान कहते हैं – हे अर्जुन! इन सबको विस्तार से जानने की आवश्यकता नहीं है। मैं इस सम्पूर्ण जगत को अपने एक अंश से धारण करता हूँ। यह श्लोक भक्त को यह समझाता है कि ईश्वर की शक्ति इतनी विशाल है कि उनके एक छोटे से अंश में ही संपूर्ण सृष्टि स्थित है।",
        englishMeaning = "But what need is there, O Arjuna, for all this detailed knowledge? With a single fragment of Myself, I pervade and support this entire universe."
    )


)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaTenScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 10 – विभूतियोग",
                        fontSize = 26.sp, // ✅ bigger title like chapter 9
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            // ✅ Banner Ad at bottom
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                BannerAdView(
                    modifier = Modifier.fillMaxSize(),
                    adUnitId = "ca-app-pub-9218012224365288/7740076296"
                )
            }
        },
        floatingActionButton = {
            // ✅ Floating Quiz Button
            FloatingActionButton(
                onClick = { navController.navigate(Screen.QuizTen.route) },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.School,
                    contentDescription = "Start Quiz"
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 70.dp) // ✅ keep content above ad
        ) {
            // ✅ Top Image
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .height(500.dp),
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.gemini_generated_image_ece92yece92yece9),
                        contentDescription = "Chapter 10 – Vibhuti Yoga",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaTenShlokas) { shloka ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    shape = RoundedCornerShape(18.dp)
                ) {
                    Column(modifier = Modifier.padding(18.dp)) {
                        Text(
                            text = "श्लोक ${shloka.number}",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(Modifier.height(12.dp))
                        Text(
                            text = shloka.sanskrit,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                            lineHeight = 32.sp,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "हिंदी अर्थ:\n${shloka.hindiMeaning}",
                            fontSize = 20.sp,
                            lineHeight = 30.sp,
                            textAlign = TextAlign.Justify,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "English Meaning:\n${shloka.englishMeaning}",
                            fontSize = 20.sp,
                            lineHeight = 30.sp,
                            textAlign = TextAlign.Justify,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
