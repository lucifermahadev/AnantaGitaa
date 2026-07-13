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


val adhyayaEighteenShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अर्जुन उवाच। प्रमादात्मा विजानाति धर्मं किं कर्म कर्तुमर्हसि। यच्छ्रुतं श्रेयो हि नान्यत्किं कर्मणि विधीयते।।",
        hindiMeaning = "अर्जुन पूछते हैं: हे श्रीकृष्ण! मैं समझ नहीं पा रहा हूँ कि मेरे लिए कौन सा धर्म है और कौन सा कर्म मुझे करना चाहिए। मैंने जो कुछ भी शास्त्रों में सुना है, क्या वही श्रेष्ठ मार्ग है या कुछ और भी है? अर्जुन इस श्लोक में अपनी शंका और धर्म-बोध की जिज्ञासा व्यक्त कर रहे हैं। यह अध्याय की आरंभिक भावना को प्रस्तुत करता है।",
        englishMeaning = "Arjuna asks: O Krishna, I am confused about what is my duty and which actions I should perform. Is what I have heard truly the best way or is there another path?"
    ),

    Shloka(
        number = 2,
        sanskrit = "श्रीभगवानुवाच। कर्तव्यं कर्मणां प्रकारो भक्त्या युक्तः सदा। सत्त्वसम्पन्नो हि धर्मात्मा प्राप्यते यत्र सुखम्।।",
        hindiMeaning = "भगवान कहते हैं: कर्म करने के प्रकार को समझना आवश्यक है। व्यक्ति जो भक्ति और श्रद्धा से युक्त है, वह सत्त्वसम्पन्न होता है और धर्मात्मा बनता है। इस प्रकार के व्यक्ति को अपने कर्मों में सुख और संतोष प्राप्त होता है। यह श्लोक बताता है कि कर्म की गुणवत्ता और उसके परिणाम व्यक्ति की श्रद्धा और गुणों पर निर्भर करते हैं।",
        englishMeaning = "Lord Krishna says: Actions must be performed with devotion; one endowed with Sattva becomes righteous and attains happiness."
    ),

    Shloka(
        number = 3,
        sanskrit = "कर्मण्यकर्म यः पश्येदकर्मणि च कर्म यः। स बुद्धिमान्मनुष्येषु स युक्तः स पुरुषोत्तमः।।",
        hindiMeaning = "जो व्यक्ति कर्म और अकर्म दोनों में समान दृष्टि रखता है, वह बुद्धिमान कहलाता है। ऐसे व्यक्ति के कर्म संतुलित और युक्त होते हैं। यह श्लोक बताता है कि बुद्धिमान व्यक्ति अपने कर्तव्य और निष्ठा में संतुलन बनाए रखता है और पुरुषोत्तम की भक्ति में स्थित रहता है।",
        englishMeaning = "One who sees action and inaction equally is wise; such a person is balanced in deeds and devoted to the Supreme."
    ),

    Shloka(
        number = 4,
        sanskrit = "न हि कश्चित्क्षणमपि जातु तिष्ठत्यकर्मकृत्। कार्यते ह्यवशः कर्म सर्वः प्रकृतिजैर्गुणैः।।",
        hindiMeaning = "सृष्टि के नियम के अनुसार कोई भी व्यक्ति क्षणभर भी निष्क्रिय नहीं रह सकता। सभी कर्म प्रकृति और उसके गुणों के अनुसार अनायास ही होते रहते हैं। यह श्लोक यह स्पष्ट करता है कि कर्म से बचना असंभव है और जीवन में कर्म स्वाभाविक रूप से उत्पन्न होते रहते हैं।",
        englishMeaning = "No one can remain inactive even for a moment; all actions are driven by the qualities of nature."
    ),

    Shloka(
        number = 5,
        sanskrit = "शरीरवाऽऽवयवाश्च कर्माणि च प्रकृतिजैः। कर्मफलानि च येषु न सत्तवो न रजस्तमः।।",
        hindiMeaning = "शरीर के अंग, उसके कार्य और कर्म उसके प्रकृति के गुणों से प्रभावित होते हैं। कर्म के फल भी उन गुणों के अनुसार उत्पन्न होते हैं। यह श्लोक स्पष्ट करता है कि प्रत्येक कर्म और उसके परिणाम प्रकृति के सत्त्व, रजस और तमस गुणों से जुड़े होते हैं।",
        englishMeaning = "The body, its members, and actions are governed by the qualities of nature; their fruits arise according to Sattva, Rajas, and Tamas."
    ),

    Shloka(
        number = 6,
        sanskrit = "सत्त्वं प्रज्ञावान् सुखं धर्मः स्थिरः प्रभुः। रजसि कामकर्मा तामसि प्रमाद्युक्तः सदा।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानी, स्थिर और सुखप्रद होता है। राजसिक व्यक्ति केवल काम और इच्छाओं में लिप्त होता है। तामसिक व्यक्ति प्रमाद और अज्ञान से भरा होता है। इस प्रकार गुणों के अनुसार कर्म और उनके परिणाम भिन्न होते हैं।",
        englishMeaning = "Sattvic is wise, stable, and blissful; Rajasic acts driven by desire; Tamasic is negligent and deluded."
    ),

    Shloka(
        number = 7,
        sanskrit = "यद्भिर्गुणैरभिर्यत्स्त्रियं पुरुषं कर्मणि च। तस्मात्सर्वे गुणा जायन्ते प्रकृतिसम्भवाः सदा।।",
        hindiMeaning = "प्रकृति से उत्पन्न सभी पुरुषों और उनके कर्मों में गुणों का प्रभाव रहता है। सत्त्व, रजस और तमस का प्रभाव प्रत्येक व्यक्ति के जीवन और कर्मों में दिखाई देता है। यह श्लोक स्पष्ट करता है कि गुणों का प्रभाव जीवन की दिशा और कर्मों की गुणवत्ता तय करता है।",
        englishMeaning = "All beings and their actions are influenced by the qualities of nature; Sattva, Rajas, and Tamas shape life and deeds."
    ),

    Shloka(
        number = 8,
        sanskrit = "सत्त्वं ज्ञानमुत्तमं सुखसंकल्पकरं च। रजसि कामप्रदं तमः प्रमाद्युक्तं दुःखजनकम्।।",
        hindiMeaning = "सत्त्विक गुण ज्ञानपूर्ण, उत्तम और सुखद होते हैं। राजसिक गुण इच्छाओं और कामों को बढ़ावा देते हैं। तामसिक गुण प्रमाद और अज्ञान से भरे होते हैं और दुःख उत्पन्न करते हैं। यह श्लोक गुणों के प्रभाव को स्पष्ट रूप से दर्शाता है।",
        englishMeaning = "Sattva is pure and blissful, Rajas drives desire, Tamas brings delusion and suffering."
    ),

    Shloka(
        number = 9,
        sanskrit = "सत्त्वसम्पन्नः कर्मे स्थिरः ज्ञानी भक्त्या युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति कर्म में स्थिर, ज्ञानी और भक्तिभाव से युक्त होता है। राजसिक व्यक्ति कर्म को केवल लाभ और काम के लिए करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। गुणों के अनुसार कर्म और मनुष्य की स्थिति भिन्न होती है।",
        englishMeaning = "Sattvic are steadfast and devoted in action; Rajasic act for gain; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 10,
        sanskrit = "सत्त्वं शास्त्रवित् धर्मयुक्तं रजसः कामार्थकृत्। तमः प्रमादग्रस्तः सदा लोभिनो हि कर्मणि।।",
        hindiMeaning = "सत्त्विक व्यक्ति शास्त्रज्ञ और धर्मयुक्त होता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमादग्रस्त और लोभी होता है। यह श्लोक जीवन और कर्मों में गुणों के प्रभाव को बताता है।",
        englishMeaning = "Sattvic is knowledgeable and righteous; Rajasic acts for desire; Tamasic is heedless and greedy."
    ),

    Shloka(
        number = 11,
        sanskrit = "सत्त्वसम्पन्नः ज्ञानी धर्मात्मा स्थिरः प्रज्ञावान्। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानी, धर्मात्मा और स्थिर होता है। राजसिक व्यक्ति केवल फल और काम की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह गुणों और कर्मों के संबंध को स्पष्ट करता है।",
        englishMeaning = "Sattvic is wise, righteous, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 12,
        sanskrit = "सत्त्वं ज्ञानवित् धर्मयुक्तं रजसः कामार्थकृत्। तमः प्रमादग्रस्तः सदा लोभिनो हि कर्मणि।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानवान और धर्मयुक्त होता है। राजसिक व्यक्ति कर्म को केवल काम और लाभ के लिए करता है। तामसिक व्यक्ति प्रमादग्रस्त और लोभी होता है। यह श्लोक गुणों और कर्मों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic is knowledgeable and righteous; Rajasic act for gain; Tamasic is heedless and greedy."
    ),

    Shloka(
        number = 13,
        sanskrit = "सत्त्वसम्पन्नो धर्मात्मा प्रज्ञावान् स्थिरो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति धर्मात्मा, ज्ञानी और स्थिर होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह गुणों के अनुसार जीवन की स्थिति को बताता है।",
        englishMeaning = "Sattvic is righteous, wise, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 14,
        sanskrit = "सत्त्वं ज्ञानवित् भक्त्या युक्तः स्थिरः प्रज्ञावान्। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर रहता है। राजसिक व्यक्ति कर्म को केवल फल और काम के लिए करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और श्रद्धा के प्रभाव को पुनः रेखांकित करता है।",
        englishMeaning = "Sattvic is wise, devoted, and steadfast; Rajasic act for gain; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 15,
        sanskrit = "सत्त्वसम्पन्नः प्रज्ञावान् स्थिरः धर्मयुक्तो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, स्थिर और धर्मयुक्त होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों के अनुसार जीवन और कर्म की स्थिति बताता है।",
        englishMeaning = "Sattvic are wise, steadfast, and righteous; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 16,
        sanskrit = "सत्त्वं ज्ञानवित् धर्मयुक्तं प्रज्ञावान् स्थिरः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानवान, धर्मयुक्त और स्थिर होता है। राजसिक व्यक्ति केवल काम और लाभ के लिए कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic is knowledgeable, righteous, and steadfast; Rajasic act for gain; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 17,
        sanskrit = "सत्त्वसम्पन्नो ज्ञानी भक्त्या युक्तः स्थिरः धर्मात्मा। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर धर्मात्मा होता है। राजसिक केवल फल और काम की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक श्रद्धा और गुणों का प्रभाव बताता है।",
        englishMeaning = "Sattvic are wise, devoted, and steadfast in dharma; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 18,
        sanskrit = "सत्त्वं ज्ञानवित् धर्मयुक्तं स्थिरः प्रज्ञावान् युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, धर्मयुक्त और स्थिर रहता है। राजसिक व्यक्ति केवल काम और फल की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों के अनुसार जीवन और कर्म की स्थिति को स्पष्ट करता है।",
        englishMeaning = "Sattvic is knowledgeable, righteous, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 19,
        sanskrit = "सत्त्वसम्पन्नो ज्ञानी भक्त्या युक्तः स्थिरः धर्मात्मा। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर धर्मात्मा होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic are wise, devoted, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 20,
        sanskrit = "एवं सत्त्वराजसतमसः श्रद्धात्रयभेदः स्पष्टः। सत्त्वसम्पन्नो भवेद्व्यवस्थितः पुरुषोत्तमः।।",
        hindiMeaning = "इस प्रकार सत्त्व, रजस और तमस में श्रद्धा का भेद स्पष्ट है। सत्त्वसम्पन्न व्यक्ति पुरुषोत्तम की भक्ति में स्थित होता है और मोक्ष की प्राप्ति करता है। यह श्लोक अध्याय का सार बताता है।",
        englishMeaning = "Thus, the distinction of faith into Sattva, Rajas, and Tamas is clear; one endowed with Sattva becomes steadfast in the Supreme."
    ),

    Shloka(
        number = 30,
        sanskrit = "सत्त्वं ज्ञानवित् धर्मयुक्तं रजसः कामार्थकृत्। तमः प्रमादग्रस्तः सदा लोभिनो हि कर्मणि।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानवान और धर्मयुक्त होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमादग्रस्त और लोभी होता है। यह श्लोक गुणों और कर्मों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic is knowledgeable and righteous; Rajasic acts for desire; Tamasic is heedless and greedy."
    ),

    Shloka(
        number = 31,
        sanskrit = "सत्त्वसम्पन्नो धर्मात्मा प्रज्ञावान् स्थिरः युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति धर्मात्मा, ज्ञानी और स्थिर होता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और कर्मों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic is righteous, wise, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 32,
        sanskrit = "सत्त्वसम्पन्नः ज्ञानी भक्त्या युक्तः स्थिरः धर्मात्मा। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर धर्मात्मा होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic are wise, devoted, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 33,
        sanskrit = "सत्त्वसम्पन्नो ज्ञानी स्थिरः धर्मयुक्तः प्रज्ञावान्। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानी, स्थिर और धर्मयुक्त होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों के अनुसार कर्म और जीवन की स्थिति बताता है।",
        englishMeaning = "Sattvic is wise, stable, and righteous; Rajasic act for desire; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 34,
        sanskrit = "सत्त्वं ज्ञानेन युक्तं धर्मयुक्तं प्रज्ञावान् स्थिरः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्विक गुण ज्ञानयुक्त, धर्मयुक्त और स्थिर होते हैं। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और कर्मों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattva is knowledge-driven, righteous, and steadfast; Rajas acts for desire; Tamas is negligent and deluded."
    ),

    Shloka(
        number = 35,
        sanskrit = "सत्त्वसम्पन्नः ज्ञानी भक्त्या युक्तः स्थिरः धर्मात्मा। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर धर्मात्मा होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic are wise, devoted, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 36,
        sanskrit = "सत्त्वसम्पन्नो ज्ञानी स्थिरः धर्मयुक्तः प्रज्ञावान्। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, स्थिर और धर्मयुक्त होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic is wise, stable, and righteous; Rajasic act for desire; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 37,
        sanskrit = "सत्त्वं ज्ञानवित् धर्मयुक्तं स्थिरः प्रज्ञावान् युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानी, धर्मयुक्त और स्थिर रहता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic is knowledgeable, righteous, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 38,
        sanskrit = "सत्त्वसम्पन्नो ज्ञानी भक्त्या युक्तः स्थिरः धर्मात्मा। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर धर्मात्मा होता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic are wise, devoted, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 39,
        sanskrit = "सत्त्वसम्पन्नो ज्ञानी स्थिरः धर्मयुक्तः प्रज्ञावान्। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानी, स्थिर और धर्मयुक्त होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic is wise, stable, and righteous; Rajasic act for desire; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 40,
        sanskrit = "एवं सत्त्वराजसतमसः श्रद्धात्रयभेदः स्पष्टः। सत्त्वसम्पन्नो भवेद्व्यवस्थितः पुरुषोत्तमः।।",
        hindiMeaning = "इस प्रकार सत्त्व, रजस और तमस में श्रद्धा का भेद स्पष्ट है। सत्त्वसम्पन्न व्यक्ति पुरुषोत्तम की भक्ति में स्थित होता है और मोक्ष की प्राप्ति करता है। यह श्लोक अध्याय का सार बताता है।",
        englishMeaning = "Thus, the distinction of faith into Sattva, Rajas, and Tamas is clear; one endowed with Sattva becomes steadfast in the Supreme."
    ),Shloka(
        number = 41,
        sanskrit = "ब्राह्मणार्थार्थानां कर्माणि सनातनं प्रवर्तते। क्षत्रियाणां वीर्यकर्माणि राजसैः प्रदिश्यते।।",
        hindiMeaning = "ब्राह्मणों के लिए कर्म उनके अध्ययन, यज्ञ और ज्ञान प्राप्ति के लिए होते हैं। यह उनके धर्म और समाज में स्थायित्व के लिए आवश्यक है। क्षत्रियों के लिए वीर्यपूर्ण कर्म, युद्ध और सुरक्षा के कार्य होते हैं। यह श्लोक कर्मों को वर्णों के अनुसार विभाजित करता है।",
        englishMeaning = "For Brahmins, actions relate to learning and rituals; for Kshatriyas, valorous deeds; duties are aligned with social order."
    ),

    Shloka(
        number = 42,
        sanskrit = "वैश्याणां कृषिकर्माणि पैशून्यवाणिज्यकृत्। शूद्राणां कर्माणि सेवापरायणानि च।।",
        hindiMeaning = "वैश्य वर्ग के कर्म कृषि, पशुपालन और व्यापार से संबंधित हैं। शूद्र वर्ग अपने अधीनस्थों की सेवा और अन्य आवश्यक कार्यों में निष्ठा रखते हैं। यह श्लोक वर्णों के अनुसार कर्म और कर्तव्य का स्पष्ट विवरण देता है।",
        englishMeaning = "Vaishyas perform agriculture, animal husbandry, and trade; Shudras serve others diligently."
    ),

    Shloka(
        number = 43,
        sanskrit = "सत्त्वसम्पन्नः ब्राह्मणो धर्मज्ञो यज्ञप्रियः। रजसः क्षत्रियो वीर्यवान् कामार्थकृत् सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न ब्राह्मण धर्म और ज्ञान में निपुण, यज्ञप्रिय होता है। राजसिक क्षत्रिय वीर्यवान और केवल काम और लाभ की इच्छा से कर्म करता है। यह श्लोक गुणों के अनुसार कर्म और स्वभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic Brahmins are wise and devoted to rituals; Rajasic Kshatriyas act for desire and valor."
    ),

    Shloka(
        number = 44,
        sanskrit = "वैश्यः सत्त्वसम्पन्नो कृषिकर्मकृत् यशस्वी। रजसः व्यापारकृत् तमः लोभिनो हि सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न वैश्य कृषि और व्यवसाय में निपुण और प्रतिष्ठित होता है। राजसिक वैश्य केवल व्यापार और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति लोभी और प्रमादग्रस्त रहता है। यह श्लोक वर्णों और गुणों के अनुसार कर्म का विभाजन बताता है।",
        englishMeaning = "Sattvic Vaishyas are skillful and prosperous in agriculture and trade; Rajasic act for profit; Tamasic are greedy."
    ),

    Shloka(
        number = 45,
        sanskrit = "शूद्रः सत्त्वसम्पन्नः सेवापरायणो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न शूद्र सेवा में निपुण और समर्पित होता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक सेवाभाव और गुणों के अनुसार कर्म को स्पष्ट करता है।",
        englishMeaning = "Sattvic Shudras are dedicated to service; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 46,
        sanskrit = "सत्त्वसम्पन्नः धर्मात्मा ब्राह्मणो यत्नपूर्वक। रजसः क्षत्रियो वीर्यवान् कामार्थकृत् सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न ब्राह्मण धर्मात्मा और यत्नपूर्वक कर्म करता है। राजसिक क्षत्रिय वीर्यवान और केवल काम और लाभ के लिए कर्म करता है। यह श्लोक गुणों के अनुसार कर्म और प्रयास की विशेषता बताता है।",
        englishMeaning = "Sattvic Brahmins are righteous and diligent; Rajasic Kshatriyas act for desire and valor."
    ),

    Shloka(
        number = 47,
        sanskrit = "वैश्यः सत्त्वसम्पन्नः कृषिकर्मकृत् यशस्वी। रजसः व्यापारकृत् तमः लोभिनो हि सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न वैश्य कृषि और व्यापार में निपुण और प्रतिष्ठित होता है। राजसिक केवल लाभ और व्यापार के लिए कर्म करता है। तामसिक लोभी और प्रमादग्रस्त रहता है। यह श्लोक गुणों और कर्मों का विवरण प्रस्तुत करता है।",
        englishMeaning = "Sattvic Vaishyas excel in agriculture and trade; Rajasic act for profit; Tamasic are greedy."
    ),

    Shloka(
        number = 48,
        sanskrit = "शूद्रः सत्त्वसम्पन्नः सेवापरायणो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न शूद्र सेवा में निपुण और समर्पित होता है। राजसिक केवल लाभ और काम के लिए कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और सेवा की दिशा को स्पष्ट करता है।",
        englishMeaning = "Sattvic Shudras are devoted to service; Rajasic act for desire; Tamasic are negligent."
    ),

    Shloka(
        number = 49,
        sanskrit = "सत्त्वसम्पन्नो ब्राह्मणो धर्मज्ञः यत्नपूर्वक। रजसः क्षत्रियो वीर्यवान् कामार्थकृत् सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न ब्राह्मण धर्म और ज्ञान में निपुण, यत्नपूर्वक कर्म करता है। राजसिक क्षत्रिय केवल काम और लाभ की इच्छा से वीर्यपूर्ण कर्म करता है। यह श्लोक वर्ण और गुणों के अनुसार कर्म का विवरण देता है।",
        englishMeaning = "Sattvic Brahmins are wise and diligent; Rajasic Kshatriyas act for desire and valor."
    ),

    Shloka(
        number = 50,
        sanskrit = "वैश्यः सत्त्वसम्पन्नः कृषिकर्मकृत् यशस्वी। रजसः व्यापारकृत् तमः लोभिनो हि सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न वैश्य कृषि और व्यापार में निपुण और यशस्वी होता है। राजसिक केवल लाभ और व्यापार की इच्छा से कर्म करता है। तामसिक लोभी और प्रमादग्रस्त रहता है। यह श्लोक गुणों और कर्मों की स्पष्ट व्याख्या है।",
        englishMeaning = "Sattvic Vaishyas excel in agriculture and trade; Rajasic act for profit; Tamasic are greedy."
    ),

    Shloka(
        number = 51,
        sanskrit = "शूद्रः सत्त्वसम्पन्नः सेवापरायणो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न शूद्र सेवा में समर्पित और योग्य होता है। राजसिक केवल लाभ और काम की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic Shudras are dedicated to service; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 52,
        sanskrit = "सत्त्वसम्पन्नः ब्राह्मणो धर्मात्मा प्रज्ञावान् स्थिरः। रजसः क्षत्रियो कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न ब्राह्मण धर्मात्मा, ज्ञानी और स्थिर रहता है। राजसिक क्षत्रिय केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और कर्मों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic Brahmins are righteous, wise, and steadfast; Rajasic Kshatriyas act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 53,
        sanskrit = "वैश्यः सत्त्वसम्पन्नः कृषिकर्मकृत् यशस्वी। रजसः व्यापारकृत् तमः लोभिनो हि सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न वैश्य कृषि और व्यापार में निपुण और प्रतिष्ठित होता है। राजसिक केवल लाभ और व्यापार के लिए कर्म करता है। तामसिक लोभी और प्रमादग्रस्त रहता है।",
        englishMeaning = "Sattvic Vaishyas excel in agriculture and trade; Rajasic act for profit; Tamasic are greedy."
    ),

    Shloka(
        number = 54,
        sanskrit = "शूद्रः सत्त्वसम्पन्नः सेवापरायणो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न शूद्र सेवा में समर्पित और योग्य होता है। राजसिक केवल लाभ और काम की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic Shudras are devoted to service; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 55,
        sanskrit = "सत्त्वसम्पन्नो ब्राह्मणो धर्मात्मा प्रज्ञावान् स्थिरः। रजसः क्षत्रियो वीर्यवान् कामार्थकृत् सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न ब्राह्मण धर्मात्मा, ज्ञानी और स्थिर रहता है। राजसिक क्षत्रिय केवल काम और लाभ की इच्छा से वीर्यपूर्ण कर्म करता है।",
        englishMeaning = "Sattvic Brahmins are righteous, wise, and steadfast; Rajasic Kshatriyas act for desire and valor."
    ),

    Shloka(
        number = 56,
        sanskrit = "वैश्यः सत्त्वसम्पन्नः कृषिकर्मकृत् यशस्वी। रजसः व्यापारकृत् तमः लोभिनो हि सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न वैश्य कृषि और व्यापार में निपुण और प्रतिष्ठित होता है। राजसिक केवल लाभ और व्यापार की इच्छा से कर्म करता है। तामसिक लोभी और प्रमादग्रस्त रहता है।",
        englishMeaning = "Sattvic Vaishyas excel in agriculture and trade; Rajasic act for profit; Tamasic are greedy."
    ),

    Shloka(
        number = 57,
        sanskrit = "शूद्रः सत्त्वसम्पन्नः सेवापरायणो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न शूद्र सेवा में समर्पित और योग्य होता है। राजसिक केवल लाभ और काम की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic Shudras are dedicated to service; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 58,
        sanskrit = "सत्त्वसम्पन्नः ब्राह्मणो धर्मात्मा प्रज्ञावान् स्थिरः। रजसः क्षत्रियो कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न ब्राह्मण धर्मात्मा, ज्ञानी और स्थिर रहता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic Brahmins are righteous, wise, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 59,
        sanskrit = "वैश्यः सत्त्वसम्पन्नः कृषिकर्मकृत् यशस्वी। रजसः व्यापारकृत् तमः लोभिनो हि सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न वैश्य कृषि और व्यापार में निपुण और प्रतिष्ठित होता है। राजसिक केवल लाभ और व्यापार की इच्छा से कर्म करता है। तामसिक लोभी और प्रमादग्रस्त रहता है।",
        englishMeaning = "Sattvic Vaishyas excel in agriculture and trade; Rajasic act for profit; Tamasic are greedy."
    ),

    Shloka(
        number = 60,
        sanskrit = "शूद्रः सत्त्वसम्पन्नः सेवापरायणो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न शूद्र सेवा में समर्पित और योग्य होता है। राजसिक केवल लाभ और काम की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है।",
        englishMeaning = "Sattvic Shudras are devoted to service; Rajasic act for desire; Tamasic are negligent and deluded."
    ),
    Shloka(
        number = 61,
        sanskrit = "ईश्वरः सर्वभूतानां हृद्देशेऽर्जुन तिष्ठति। भ्रामयन्सर्वभूतानि यन्त्रारूढानि मायया।।",
        hindiMeaning = "हे अर्जुन! ईश्वर सभी जीवों के हृदय में स्थित है और उन्हें उनके कर्मों के अनुसार नियंत्रित करता है। जैसे यंत्र में घूमने वाली वस्तुएँ उसकी मर्यादा में रहती हैं, वैसे ही जीवों को ईश्वर अपनी माया से नियंत्रित करता है। यह श्लोक भगवान की सर्वव्यापक सत्ता और जीवों पर उसकी नियामक शक्ति को स्पष्ट करता है। ईश्वर केवल कर्मों का मार्गदर्शन करता है, परिणामों के लिए जिम्मेदार नहीं। यह हमें यह भी समझाता है कि जीवन में सभी घटनाएँ भगवान की योजना और नियति के अनुसार होती हैं।",
        englishMeaning = "The Supreme resides in the heart of all beings, guiding them through His maya, like a master controls the movements of instruments."
    ),

    Shloka(
        number = 62,
        sanskrit = "यः सर्वत्रानभिस्नतः कर्मोऽपि निःस्पृहः फलम्। तस्य प्रज्ञा प्रतिष्ठिता नास्तिकेभ्यः कदाचन।।",
        hindiMeaning = "जो व्यक्ति सभी कर्मों में लगे रहते हुए भी फल की इच्छा से रहित है, उसकी प्रज्ञा स्थिर होती है। ऐसा व्यक्ति कभी नास्तिकों की भांति नहीं डगमगाता। यह श्लोक हमें निष्काम कर्मयोग की महत्ता और स्थिर बुद्धि की आवश्यकता को समझाता है। अर्जुन को बताया गया है कि कर्म करते हुए भी इच्छाओं और आसक्तियों से ऊपर उठना परम ज्ञान है। यह श्लोक योग का मार्ग और स्थिर चेतना प्राप्ति के लिए मार्गदर्शन देता है।",
        englishMeaning = "One who performs all actions without attachment to results has steadfast wisdom and is never shaken like the atheists."
    ),

    Shloka(
        number = 63,
        sanskrit = "अर्जुन उवाच- एषोऽर्थः सत्त्वस्य मूलं प्रजाने। राजसस्यास्य कारणं तमसोऽस्य मौलिमेत्य च।।",
        hindiMeaning = "अर्जुन कहते हैं कि हे भगवान! मैं जानना चाहता हूँ कि सत्त्व का मूल क्या है, रजस का कारण क्या है और तमस का मूल क्या है। अर्जुन यहां तीनों गुणों और उनके मूल और कारण के बारे में स्पष्ट ज्ञान प्राप्त करने के लिए पूछते हैं। यह श्लोक ज्ञान और विवेक की खोज में उनके गंभीर सवाल को दर्शाता है। उन्होंने समझने की इच्छा जताई कि कौन-सा गुण कैसे और क्यों कार्य करता है।",
        englishMeaning = "Arjuna asks about the origin of Sattva, the cause of Rajas, and the root of Tamas."
    ),

    Shloka(
        number = 64,
        sanskrit = "श्रीभगवानुवाच- सत्त्वमेत्युच्यते ज्ञानसङ्ग्रहवर्त्मनि। राजसस्तामसस्तथा कर्मयोगे प्रवर्तते।।",
        hindiMeaning = "भगवान कहते हैं कि ज्ञान, भक्ति और कर्मयोग में कार्य करने वाले जीव में सत्त्व, रजस और तमस तीनों गुण विद्यमान हैं। सत्त्वज्ञान, संतोष और शांति लाता है; रजस कर्म और काम में प्रवृत्त करता है; तमस प्रमाद और अज्ञान का कारण होता है। यह श्लोक गुणों के महत्व और उनके कर्मों पर प्रभाव को समझाता है। यहाँ भगवान स्पष्ट रूप से बताते हैं कि प्रत्येक व्यक्ति के कर्म उसके गुणों के अनुसार निर्धारित होते हैं।",
        englishMeaning = "The Supreme explains that Sattva, Rajas, and Tamas operate in beings, influencing knowledge, desire-driven action, and ignorance, respectively."
    ),

    Shloka(
        number = 65,
        sanskrit = "सत्त्वसम्पन्नः ज्ञानवान् स्थिरः धृतिमान् च। रजसः कामार्थकृत् प्रमादी तमः प्रमाद्युक्तः।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, स्थिर और धैर्यवान होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमादी और अज्ञानपूर्ण होता है। यह श्लोक गुणों और उनके प्रभाव को स्पष्ट करता है। भगवान अर्जुन को बता रहे हैं कि जीवन में गुणों के अनुसार कर्म और मानसिक स्थिति निर्धारित होती है। सत्त्व, ज्ञान और स्थिरता लाता है; रजस, कर्म और वासना; तामस, अज्ञान और प्रमाद।",
        englishMeaning = "Sattvic are wise, steadfast, and patient; Rajasic act for desire; Tamasic are negligent and ignorant."
    ),

    Shloka(
        number = 66,
        sanskrit = "सत्त्वं शुद्धसुखसंकल्पं राजसि कामप्रदं तमः प्रमाद्युक्तं दुःखजनकम्।",
        hindiMeaning = "सत्त्विक गुण शुद्ध, सुखप्रद और संतोषजनक होते हैं। राजसिक गुण इच्छाओं और काम को बढ़ावा देते हैं। तामसिक गुण प्रमाद और अज्ञान से भरे होते हैं और दुःख उत्पन्न करते हैं। यह श्लोक गुणों के प्रभाव को संक्षेप में प्रस्तुत करता है। प्रत्येक गुण का मन और कर्म पर विशेष प्रभाव होता है।",
        englishMeaning = "Sattva is pure and blissful, Rajas drives desire, Tamas brings delusion and suffering."
    ),

    Shloka(
        number = 67,
        sanskrit = "सत्त्वसम्पन्नो ब्राह्मणो धर्मात्मा यत्नपूर्वक। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न ब्राह्मण धर्मात्मा और यत्नपूर्वक कर्म करता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और कर्मों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic Brahmins are righteous and diligent; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 68,
        sanskrit = "वैश्यः सत्त्वसम्पन्नः कृषिकर्मकृत् यशस्वी। रजसः व्यापारकृत् तमः लोभिनो हि सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न वैश्य कृषि और व्यापार में निपुण और यशस्वी होता है। राजसिक केवल लाभ और व्यापार की इच्छा से कर्म करता है। तामसिक लोभी और प्रमादग्रस्त रहता है। यह श्लोक वर्णों और गुणों के अनुसार कर्म का विवरण देता है।",
        englishMeaning = "Sattvic Vaishyas excel in agriculture and trade; Rajasic act for profit; Tamasic are greedy."
    ),

    Shloka(
        number = 69,
        sanskrit = "शूद्रः सत्त्वसम्पन्नः सेवापरायणो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न शूद्र सेवा में समर्पित और योग्य होता है। राजसिक केवल लाभ और काम की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक सेवा और गुणों के अनुसार कर्म को स्पष्ट करता है।",
        englishMeaning = "Sattvic Shudras are devoted to service; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 70,
        sanskrit = "सत्त्वसम्पन्नः ज्ञानी भक्त्या युक्तः स्थिरः धर्मात्मा। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर धर्मात्मा होता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और भक्ति की महत्ता को बताता है।",
        englishMeaning = "Sattvic are wise, devoted, and steadfast; Rajasic act for desire; Tamasic are negligent and deluded."
    ),

    Shloka(
        number = 71,
        sanskrit = "सत्त्वसम्पन्नो ज्ञानी स्थिरः धर्मयुक्तः प्रज्ञावान्। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, स्थिर और धर्मयुक्त होता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और स्थिरता की महत्ता को स्पष्ट करता है।",
        englishMeaning = "Sattvic is wise, stable, and righteous; Rajasic act for desire; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 72,
        sanskrit = "एवं सत्त्वराजसतमसः श्रद्धात्रयभेदः स्पष्टः। सत्त्वसम्पन्नो भवेद्व्यवस्थितः पुरुषोत्तमः।।",
        hindiMeaning = "इस प्रकार सत्त्व, रजस और तमस में श्रद्धा का भेद स्पष्ट है। सत्त्वसम्पन्न व्यक्ति पुरुषोत्तम की भक्ति में स्थित होता है और मोक्ष की प्राप्ति करता है। यह श्लोक अध्याय का सार बताता है और जीवन में गुणों और श्रद्धा के महत्व को समझाता है।",
        englishMeaning = "Thus, the distinction of faith into Sattva, Rajas, and Tamas is clear; one endowed with Sattva becomes steadfast in the Supreme."
    ),
    Shloka(
        number = 73,
        sanskrit = "अर्जुन उवाच- सर्वशस्त्राणि धर्माण्यस्मिन्मां प्रतिपद्य। क्रियासिद्धिं गमिष्यामि भवत्वयि न संशयः।।",
        hindiMeaning = "अर्जुन कहते हैं कि हे भगवान! आपने मुझे सम्पूर्ण शस्त्र, धर्म और ज्ञान प्रदान किया। अब मैं सम्पूर्ण विश्वास के साथ आपका उपदेश ग्रहण करता हूँ और उसके अनुसार कर्म करके सिद्धि प्राप्त करूंगा। यह श्लोक अर्जुन की पूर्ण समर्पण और विश्वास को दर्शाता है। उन्होंने अब निश्चय किया कि वे भगवान के मार्गदर्शन में चलेंगे और अपने कर्तव्य का पालन करेंगे।",
        englishMeaning = "Arjuna says he has received all knowledge of scriptures and dharma and will act accordingly without doubt."
    ),

    Shloka(
        number = 74,
        sanskrit = "श्रीभगवानुवाच- संन्यासः कर्मणां कृष्ण लिप्तस्य। योगो नाम मानसिको बलं चित्तस्य नियमितम्।।",
        hindiMeaning = "भगवान कहते हैं कि संन्यास का अर्थ केवल कर्मों का परित्याग नहीं, बल्कि मानसिक रूप से कर्मों का त्याग करना है। योग मानसिक बल है और चित्त का नियमित होना इसे संभव बनाता है। यह श्लोक हमें समझाता है कि सच्चा संन्यास और योग केवल बाहरी कर्मों में नहीं, बल्कि चित्त और मन की स्थिरता और नियंत्रण में है।",
        englishMeaning = "Krishna explains that true renunciation is mental, not merely abandoning actions; Yoga is the control and steadiness of mind."
    ),

    Shloka(
        number = 75,
        sanskrit = "कर्मण्येवाधिकारस्ते मा फलेषु कदाचन। मा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि।।",
        hindiMeaning = "भगवान कहते हैं कि तुम्हारा अधिकार केवल कर्म करने में है, उसके फलों में कभी नहीं। इसलिए कर्म के फल की चिंता मत करो और न ही कर्म न करने में आसक्ति रखो। यह श्लोक निष्काम कर्मयोग का प्रमुख सूत्र है। कर्म करते रहो, लेकिन परिणाम के लिए आसक्त मत हो। यही कृष्ण का सर्वोच्च उपदेश है।",
        englishMeaning = "You have the right to perform actions only, not the fruits; do not be attached to inaction or outcomes."
    ),

    Shloka(
        number = 76,
        sanskrit = "यदा संन्यासं कर्मणां नियतमात्मन्येव च। तदा योगोऽपि सत्त्वं सम्यक् प्रज्ञा प्रतिष्ठितम्।।",
        hindiMeaning = "जब व्यक्ति अपने कर्मों का संन्यास सही ढंग से, आत्मनियंत्रण और समर्पण के साथ करता है, तब योग और सत्त्व स्थापित होता है और प्रज्ञा स्थिर होती है। यह श्लोक कर्मयोग और संन्यासयोग के आदर्श को स्पष्ट करता है। व्यक्ति के कर्मों का सही नियमन और मानसिक नियंत्रण उसके जीवन में स्थिरता और ज्ञान लाता है।",
        englishMeaning = "When one renounces actions with self-discipline, Sattva and wisdom are established, and Yoga is realized."
    ),

    Shloka(
        number = 77,
        sanskrit = "शरीरं यान्ति भूतानि आत्मा तु सर्वत्र गम्यते। सुखं दुःखं च अनुभूयते कर्मणां अनुसारम्।।",
        hindiMeaning = "शरीर सभी जीवों में जाता है, पर आत्मा सर्वत्र व्याप्त है और उसे कहीं भी सीमित नहीं किया जा सकता। व्यक्ति कर्मों के अनुसार सुख और दुःख का अनुभव करता है। यह श्लोक शरीर और आत्मा के भेद को स्पष्ट करता है। कर्म और गुणों के अनुसार ही जीवन में अनुभव और परिणाम उत्पन्न होते हैं।",
        englishMeaning = "The body perishes, but the soul is omnipresent; experiences pleasure and pain according to actions."
    ),

    Shloka(
        number = 78,
        sanskrit = "एतद्यथावत्सर्वशास्त्रेषु समग्रेषु च। मामेव ह्यनन्यः शरणं प्राप्य योगिनः स्थिताः।।",
        hindiMeaning = "सभी शास्त्रों में यही उपदेश कहा गया है कि योगी और ज्ञानी केवल मुझमें ही पूर्ण श्रद्धा के साथ शरण ग्रहण करें। मैं ही उनका अंतिम आश्रय और मार्गदर्शक हूँ। यह श्लोक पूरे भगवद्गीता का सार है। सभी उपदेशों और ज्ञान का अंतिम उद्देश्य परमेश्वर की भक्ति और शरण ग्रहण है।",
        englishMeaning = "All scriptures declare that one should take complete refuge in Me alone; I am the ultimate guide for the yogis."
    )
    )
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaEighteenScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 18 – मोक्ष संन्यास योग",
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
            // ✅ Banner Ad
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
            // ✅ Quiz Button as Floating Action Button
            FloatingActionButton(
                onClick = { navController.navigate(Screen.QuizEighteen.route) },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.School, // 🎓 Quiz icon
                    contentDescription = "Start Quiz",
                    tint = Color.White
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
            // ✅ Chapter Image
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
                        painter = painterResource(R.drawable.gemini_generated_image_aq9175aq9175aq91),
                        contentDescription = "Chapter 18 – Moksha Sannyasa Yoga",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // ✅ Shloka list
            items(adhyayaEighteenShlokas) { shloka ->
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

            // ✅ Extra "Start Quiz" button inside list (if you prefer instead of FAB)
            item {
                Button(
                    onClick = { navController.navigate(Screen.QuizEighteen.route) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text("Start Chapter 18 Quiz", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
