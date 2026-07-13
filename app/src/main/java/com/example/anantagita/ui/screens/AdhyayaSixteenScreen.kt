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

val adhyayaSixteenShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अभयं सत्त्वसंशुद्धिर्ज्ञानयोगव्यवस्थितिः। दानं दमः संयमः शौर्यं स्वाध्यायस्तप आर्जवम्।।",
        hindiMeaning = "हे अर्जुन! जो व्यक्ति भयमुक्त होता है, जिसकी संप्रकृतियाँ शुद्ध और सत्त्वप्रधान होती हैं, वह ज्ञानयोग में स्थित होता है। वह दान करता है, अपने इंद्रियों को संयमित रखता है, साहस दिखाता है, स्वाध्याय करता है और तपस्या करता है। उसका आचरण ईमानदार और सरल होता है। ये सभी गुण दैवी सम्पदा के अंग हैं। इस प्रकार के गुण व्यक्ति को धर्म, मोक्ष और सम्मान की ओर ले जाते हैं।",
        englishMeaning = "Fearlessness, purity of heart, steadfastness in knowledge, charity, self-restraint, courage, study of scriptures, austerity, and honesty constitute divine qualities."
    ),

    Shloka(
        number = 2,
        sanskrit = "अहिंसा संपर्मा शौचं क्षान्तिरार्जवमेव च। ज्ञानं विज्ञानमास्तिक्यं ब्रह्मकर्मपरायणता।।",
        hindiMeaning = "दैवी सम्पदा में अहिंसा, सत्यपरायणता, शुद्धता, क्षमा, सरलता, ज्ञान और विज्ञान का आदर, तथा ब्रह्म की सेवा में निष्ठा शामिल हैं। ऐसा व्यक्ति हिंसा से दूर रहता है, दूसरों की भलाई करता है और ज्ञान का पालन करता है। यह स्थिति उसे उच्चतम आध्यात्मिक स्तर की ओर ले जाती है। ये गुण समाज में आदर्श व्यक्ति की पहचान हैं।",
        englishMeaning = "Non-violence, truthfulness, purity, forgiveness, straightforwardness, knowledge, wisdom, and devotion to Brahman are divine qualities."
    ),

    Shloka(
        number = 3,
        sanskrit = "अभयं सत्त्वसंशुद्धिर्ज्ञानयोगव्यवस्थितिः। दानं दमः संयमः शौर्यं स्वाध्यायस्तप आर्जवम्।।",
        hindiMeaning = "जो व्यक्ति भयमुक्त, सत्त्वप्रधान, ज्ञानयोग में स्थिर, दानी, संयमी, साहसी, स्वाध्यायी, तपस्वी और ईमानदार होता है, वही दैवी सम्पदा का धनी कहलाता है। यह गुण केवल बाहरी कर्मों में ही नहीं, बल्कि आन्तरिक मनोवृत्तियों में भी परिलक्षित होते हैं। ये व्यक्ति समाज में आदर्श के रूप में प्रतिष्ठित होता है और मोक्ष की ओर अग्रसर होता है।",
        englishMeaning = "Fearlessness, purity, devotion to knowledge, charity, self-restraint, courage, study, austerity, and honesty form divine endowments."
    ),

    Shloka(
        number = 4,
        sanskrit = "असत्त्वं राजसिकं तमोऽभिमानिनं क्रोधरूपिणम्। मिथ्याचरणं चाभिजातस्याः पापानि च शाश्वताः।।",
        hindiMeaning = "जो व्यक्ति अहंकारी, क्रोधी और मिथ्याचार में लिप्त होता है, उसके कर्म असत्त्वप्रधान होते हैं। ऐसे लोग पाप में प्रवृत्त होते हैं और नश्वर बंधनों में फँसे रहते हैं। रजोगुण और तमोगुण से युक्त ये प्रवृत्तियाँ उसे जीवन में दुःख और बाधा प्रदान करती हैं। यह समझना आवश्यक है कि असुर सम्पदा का यह मार्ग अज्ञान और अंधकार की ओर ले जाता है।",
        englishMeaning = "Those born with demonic traits, arrogant, wrathful, and dishonest, engaged in sin, belong to the demonic nature."
    ),

    Shloka(
        number = 5,
        sanskrit = "द्वेषाभिभूतानां कर्माणां छन्दः प्रमादनाशनम्। अधर्मं चाभ्यसूयाः पित्रौ शत्रवः प्रजापतिः।।",
        hindiMeaning = "ईर्ष्या और द्वेष से प्रेरित कर्म करने वाले, जो पितरों, शत्रुओं और प्रजा के प्रति अधर्म करते हैं, वे असुर सम्पदा के धनी कहलाते हैं। उनका जीवन हिंसा, क्रोध और लोभ में व्यतीत होता है। उनका मन सतत अशांति और असंतोष से भरा रहता है। ये लोग आध्यात्मिक अंधकार में रहते हैं और मोक्ष की दिशा में नहीं बढ़ते।",
        englishMeaning = "Those filled with hatred, who act destructively, commit unrighteous acts towards parents, enemies, and society, belong to demonic qualities."
    ),

    Shloka(
        number = 6,
        sanskrit = "असुर सम्पदामिमां छिन्दन्ति हि मनुष्याः। अभयं सत्त्वसंशुद्धिं लभन्ति भुवि देवैः।।",
        hindiMeaning = "मानव इस असुर सम्पदा से दूर रहकर दैवी सम्पदा प्राप्त करते हैं। जो व्यक्ति भयमुक्त, शुद्ध और सत्त्वप्रधान होता है, वह भुवन में देवों की भांति प्रतिष्ठित होता है। उसका जीवन धर्म, शांति और पुण्य के मार्ग पर होता है।",
        englishMeaning = "Humans shun demonic traits and acquire divine qualities. The fearless and pure become like the gods on earth."
    ),

    Shloka(
        number = 7,
        sanskrit = "असुर सम्पदा अपरे हि मनुष्यानां दुःखप्रदाः। प्रमादभिर्विभ्रान्ताः प्रवृत्त्या दुःखं भुञ्जते।।",
        hindiMeaning = "असुर सम्पदा मनुष्य को दुःख और बंधन देती है। जो लोग प्रमाद और अज्ञान में लिप्त रहते हैं, वे इन प्रवृत्तियों के कारण दुःख भोगते हैं। असुर सम्पदा के फलस्वरूप जीवन अशांति, क्रोध, लोभ और अहंकार से भर जाता है।",
        englishMeaning = "Demonic qualities bring suffering; misled by ignorance and heedlessness, people experience pain through these traits."
    ),

    Shloka(
        number = 8,
        sanskrit = "यः सत्त्वसम्पन्नो भवति धर्मे स्थिरो महीपतिः। ज्ञानेन ज्ञानविवेकैर्युक्तः पाण्डव शरणं गच्छति।।",
        hindiMeaning = "जो व्यक्ति सत्त्वसम्पन्न है, धर्म में स्थिर है और ज्ञान के साथ विवेकपूर्ण है, वह अर्जुन के समान शरण प्राप्त करता है। उसका जीवन न्याय, सत्कार्य और धर्म के अनुसार चलता है। ऐसे व्यक्ति का मन स्थिर और शांत रहता है। यही दैवी सम्पदा का मार्ग है।",
        englishMeaning = "One endowed with Sattva, steadfast in righteousness, and guided by knowledge and wisdom, attains refuge and peace."
    ),

    Shloka(
        number = 9,
        sanskrit = "सत्त्वसम्पन्नो हि साधकः सुखी च शाश्वतः। दुःखात्क्लेशात्कृतेभ्यो विमुक्तो भवति प्रभो।।",
        hindiMeaning = "सत्त्वसम्पन्न साधक सुखी और शाश्वत होता है। वह दुःख और क्लेश से मुक्त रहता है। उसके कर्म और आचरण उसे पवित्रता और आत्मसाक्षात्कार की ओर ले जाते हैं। यह स्पष्ट करता है कि सत्त्वगुण मोक्ष और शांति का मार्ग है।",
        englishMeaning = "A Sattvic practitioner is eternally happy, free from pain and suffering, and attains liberation."
    ),

    Shloka(
        number = 10,
        sanskrit = "असत्त्वसम्पन्नो हि कामभिर्नाशयति। प्रमादभिः प्रमूढः दुःखाभियोगेन भुञ्जते।।",
        hindiMeaning = "असुर सम्पन्न व्यक्ति अपनी इच्छाओं के वश में रहता है। वह प्रमाद और अज्ञान से बंधा हुआ है और अपने कर्मों के कारण दुःख भोगता है। असुर सम्पदा का फल केवल दुख, संघर्ष और अज्ञान होता है।",
        englishMeaning = "The one endowed with demonic qualities is driven by desires, deluded by heedlessness, and suffers through misdeeds."
    ),

    Shloka(
        number = 11,
        sanskrit = "सत्त्वसम्पन्नः प्रज्ञानवान् कर्मणि समबुद्धिः। दैवसम्पन्नः प्रपन्नो विमुक्त्यै भजते प्रभुः।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति प्रज्ञावान और कर्म में समान बुद्धि वाला होता है। जो भक्त अपने जीवन में सत्त्व सम्पदा को अपनाता है, वह ईश्वर की भक्ति में स्थित होकर मोक्ष प्राप्त करता है। सत्त्वगुण मनुष्य को मार्गदर्शन और स्थिरता प्रदान करता है।",
        englishMeaning = "One endowed with Sattva is wise, equal-minded in action, and by embracing divine qualities, attains liberation through devotion."
    ),

    Shloka(
        number = 12,
        sanskrit = "दुष्कृतिनः प्रभवः सत्त्वं रजसस्तमसः च। असुरसम्पन्नाः पापान् भुञ्जते प्रमदाभिभूता।।",
        hindiMeaning = "दुष्कर्म करने वाले लोगों में सत्त्व, रजस और तमस सभी गुण होते हैं, लेकिन असुर सम्पदा के प्रभाव में वे पाप करते हैं। उनकी प्रवृत्ति प्रमाद और अज्ञान से भरी रहती है। ऐसे लोग दुःख और कर्म के बंधन में फँसे रहते हैं।",
        englishMeaning = "Among wrongdoers, though all qualities exist, influenced by demonic traits they commit sin and are overwhelmed by heedlessness."
    ),

    Shloka(
        number = 13,
        sanskrit = "सत्त्वं दैवी सम्पदा मानवांश्च विनाशयति। रजसोऽसुरसम्पद्यो दुःखसंकुलं जनयति।।",
        hindiMeaning = "सत्त्वगुण वाले व्यक्ति समाज और मानवता में कल्याण करते हैं। रजस और असुर सम्पदा वाले लोग दुःख और संघर्ष पैदा करते हैं। यह जीवन और समाज में भिन्नता और परिणाम दिखाता है।",
        englishMeaning = "Divine qualities benefit humanity, while Rajasic and demonic traits generate sorrow and disorder."
    ),

    Shloka(
        number = 14,
        sanskrit = "सत्त्वसम्पन्नः प्रज्ञावान् धर्मे स्थितो मनोऽभ्यसेत्। असुरसम्पन्नः प्रमादी लोभे व्यथते नरः।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति प्रज्ञावान होता है, धर्म में स्थित रहता है और मन से अभ्यास करता है। असुरसम्पन्न व्यक्ति प्रमादी होता है और लोभ में व्यथित रहता है। यह श्लोक स्पष्ट करता है कि गुणों का प्रभाव व्यक्ति के जीवन और कर्मों पर सीधे पड़ता है।",
        englishMeaning = "The Sattvic person is wise and steadfast in righteousness, while the demonic one is heedless and agitated by desire."
    ),

    Shloka(
        number = 15,
        sanskrit = "दैवसम्पन्नो धर्मे च रजसम्पन्नः कामिनः। तमसम्पन्नः प्रमादी लोभिनः प्रमदाभिभूता।।",
        hindiMeaning = "दैवी सम्पदा वाले व्यक्ति धर्म के मार्ग पर चलते हैं, रजस सम्पन्न व्यक्ति कामों में लिप्त रहते हैं और तमस सम्पन्न व्यक्ति प्रमाद और अज्ञान में फँसे रहते हैं। यह श्लोक तीनों प्रकार की प्रवृत्तियों को स्पष्ट करता है।",
        englishMeaning = "Those with divine qualities follow righteousness; Rajasic ones are driven by desires; Tamasic ones are deluded and heedless."
    ),

    Shloka(
        number = 16,
        sanskrit = "सत्त्वसम्पन्नः शान्तः सुखी प्रज्ञावान् धृतिः स्थितः। असुरसम्पन्नो दुःखप्रदः लोभी प्रमादग्रस्तः।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति शांत, सुखी, प्रज्ञावान और धैर्यशील होता है। असुरसम्पन्न व्यक्ति दुख देने वाला, लोभी और प्रमादग्रस्त होता है। यह स्पष्ट करता है कि गुणों के अनुसार मनुष्य का आचरण और परिणाम तय होता है।",
        englishMeaning = "The Sattvic individual is calm, happy, wise, and steadfast, while the demonic is sorrowful, greedy, and heedless."
    ),

    Shloka(
        number = 17,
        sanskrit = "सत्त्वं धृतिः प्रज्ञा दमः शौर्यं स्वाध्यायस्तप आर्जवम्। असुरसम्पन्नः लोभो क्रोधो मोहः प्रमादः शाश्वतः।।",
        hindiMeaning = "सत्त्वसम्पन्न में धृतिः, प्रज्ञा, दम, शौर्य, स्वाध्याय, तप और आर्जव शामिल हैं। असुरसम्पन्न व्यक्ति लोभी, क्रोधी, मोहग्रस्त और प्रमाद में पड़ा होता है। यह दोनों की प्रवृत्तियों की स्पष्ट तुलना है।",
        englishMeaning = "Sattvic qualities include fortitude, wisdom, self-restraint, courage, study, austerity, and honesty; demonic traits include greed, anger, delusion, and heedlessness."
    ),

    Shloka(
        number = 18,
        sanskrit = "दैवसम्पन्नः सत्त्वसम्पन्नः प्रज्ञावान् सुखी च। असुरसम्पन्नो प्रमादी लोभी क्रोधी च सदा।।",
        hindiMeaning = "दैवी सम्पदा वाले व्यक्ति सत्त्वसम्पन्न, प्रज्ञावान और सुखी होते हैं। असुर सम्पन्न व्यक्ति हमेशा प्रमादी, लोभी और क्रोधी रहते हैं। यह श्लोक गुणों के स्पष्ट अंतर को दर्शाता है।",
        englishMeaning = "Those with divine qualities are Sattvic, wise, and happy; those with demonic traits are heedless, greedy, and angry."
    ),

    Shloka(
        number = 19,
        sanskrit = "सत्त्वसम्पन्नः धर्मे स्थितो ज्ञानेन युक्तो भवेन्नरः। असुरसम्पन्नो प्रमादी लोभी क्रोधाग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति धर्म में स्थित, ज्ञानी और योगयुक्त होता है। असुरसम्पन्न व्यक्ति प्रमादी, लोभी और क्रोधग्रस्त रहता है। यह श्लोक गुणों के अनुसार व्यक्ति की स्थिति और आचरण को स्पष्ट करता है।",
        englishMeaning = "Sattvic individuals are steadfast in righteousness, wise, and disciplined; demonic individuals are heedless, greedy, and full of anger."
    ),

    Shloka(
        number = 20,
        sanskrit = "एवं दैवासुर सम्पद्विभागः स्पष्टः स नारद। सत्त्वसम्पन्नो भवेद्व्यवस्थितः पुरुषोत्तमः।।",
        hindiMeaning = "हे नारद! इस प्रकार दैवी और असुरी सम्पदा का भेद स्पष्ट किया गया। जो व्यक्ति सत्त्वसम्पन्न होता है, वह पुरुषोत्तम की भक्ति में स्थिर रहता है और मोक्ष की ओर अग्रसर होता है। यह श्लोक अध्याय के मुख्य संदेश को संक्षेप में प्रस्तुत करता है।",
        englishMeaning = "Thus, O Narada, the distinction between divine and demonic qualities is explained. One endowed with Sattva becomes steadfast in the Supreme and attains liberation."
    ),
    Shloka(
        number = 21,
        sanskrit = "असुरसम्पन्नाः प्रमादी लोभी क्रोधी च सदा। दैवसम्पन्नाः सत्कर्मा ज्ञानी भक्त्या समन्विताः।।",
        hindiMeaning = "असुर सम्पदा वाले व्यक्ति हमेशा प्रमादी, लोभी और क्रोधी रहते हैं। वे अपने वासनाओं और अज्ञान के कारण दुःख भोगते हैं। इसके विपरीत, दैवी सम्पदा वाले लोग सदैव सत्कर्मों में लिप्त रहते हैं, ज्ञानी होते हैं और भक्तिभाव से युक्त रहते हैं। उनका जीवन धर्म, ज्ञान और शांति के मार्ग पर चलता है। इससे यह स्पष्ट होता है कि गुणों के अनुसार मनुष्य का जीवन और भविष्य निर्धारित होता है।",
        englishMeaning = "Those with demonic qualities are heedless, greedy, and wrathful; those with divine qualities perform virtuous deeds, are wise, and devoted."
    ),

    Shloka(
        number = 22,
        sanskrit = "दैवसम्पन्नाः सत्कर्मा ज्ञानी भक्त्या समन्विताः। असुरसम्पन्नाः लोभी क्रोधी प्रमादग्रस्ताः सदा।।",
        hindiMeaning = "दैवी सम्पदा वाले लोग सदैव अच्छे कर्म करते हैं, ज्ञानी होते हैं और भक्तिभाव से युक्त रहते हैं। असुरी सम्पदा वाले व्यक्ति लोभी, क्रोधी और प्रमादग्रस्त होते हैं। उनके जीवन में दुःख, संघर्ष और अधर्म की वृद्धि होती रहती है। इस श्लोक से स्पष्ट होता है कि गुणों के अनुसार जीवन की दिशा बदलती है।",
        englishMeaning = "Divine beings perform righteous actions with wisdom and devotion, while demonic beings are greedy, wrathful, and heedless."
    ),

    Shloka(
        number = 23,
        sanskrit = "असुरसम्पन्नो लोभी क्रोधी प्रमादी च सदा। दैवसम्पन्नो ज्ञानी भक्त्या समन्वितः स्थिरः।।",
        hindiMeaning = "असुर सम्पदा वाला व्यक्ति हमेशा लोभी, क्रोधी और प्रमाद में फँसा रहता है। दैवी सम्पदा वाला व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर रहता है। यह श्लोक गुणों के द्वंद्व और उनके प्रभाव को समझाता है। जो सत्त्वगुण अपनाता है, उसका जीवन स्थिरता और शांति की ओर बढ़ता है, जबकि असुर सम्पदा दुःख और भ्रम में डालती है।",
        englishMeaning = "The demonic are greedy, wrathful, and heedless, while the divine are wise, devoted, and steadfast."
    ),

    Shloka(
        number = 24,
        sanskrit = "एवं दैवासुर सम्पद्विभागः स्पष्टः स नारद। सत्त्वसम्पन्नो भवेद्व्यवस्थितः पुरुषोत्तमः।।",
        hindiMeaning = "हे नारद! इस प्रकार दैवी और असुरी सम्पदा का भेद स्पष्ट किया गया। जो व्यक्ति सत्त्वसम्पन्न होता है, वह पुरुषोत्तम की भक्ति में स्थिर रहता है और मोक्ष की ओर अग्रसर होता है। यह श्लोक अध्याय के मुख्य संदेश को संक्षेप में प्रस्तुत करता है। यह शिक्षा हमें बताती है कि गुणों का चयन जीवन और मुक्ति दोनों के लिए अत्यंत महत्वपूर्ण है।",
        englishMeaning = "Thus, O Narada, the distinction between divine and demonic qualities is clear. One endowed with Sattva becomes steadfast in the Supreme and attains liberation."
    )
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaSixteenScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 16 – दैवासुर सम्पद्विभाग योग",
                        fontSize = 24.sp,
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
                onClick = { navController.navigate(Screen.QuizSixteen.route) },
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
            contentPadding = PaddingValues(bottom = 70.dp)
        ) {
            // ✅ Top Image for Chapter 16
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
                        painter = painterResource(R.drawable.gemini_generated_image_5g8hpv5g8hpv5g8h),
                        contentDescription = "Chapter 16 – Daivasura Sampad Vibhaga Yoga",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shloka list
            items(adhyayaSixteenShlokas) { shloka ->
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
                            fontSize = 22.sp,
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
                            lineHeight = 28.sp,
                            textAlign = TextAlign.Justify,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Spacer(Modifier.height(16.dp))
                        Text(
                            text = "English Meaning:\n${shloka.englishMeaning}",
                            fontSize = 20.sp,
                            lineHeight = 28.sp,
                            textAlign = TextAlign.Justify,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }
    }
}
