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

val adhyayaSeventeenShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अर्जुन उवाच। ये श्रुताः संश्रिताः सत्त्वजाताः रजसाः तमसाः च ये। तेषां भेदं प्रकृतिसंश्रितं विज्ञातुमिच्छामि भुवि देवा।।",
        hindiMeaning = "अर्जुन पूछते हैं: हे भगवान! जो श्रुति और परंपरा के अनुसार हैं, उनमें सत्त्व, रजस और तमस में कैसे भेद होता है, मैं जानना चाहता हूँ। वे कैसे जन्म लेते हैं और उनका प्रभाव क्या होता है, इसे समझाना मुझे चाहिए। यह प्रश्न इस अध्याय की मूल भावना को प्रस्तुत करता है—श्रद्धा के प्रकार और उनके फल।",
        englishMeaning = "Arjuna asks: O Lord, I wish to understand the distinction of faiths—Sattvic, Rajasic, and Tamasic—and their origin and effects."
    ),

    Shloka(
        number = 2,
        sanskrit = "श्रीभगवानुवाच। श्रद्धा त्रयप्रकृतिर्मेधा, बुद्धि, कार्ये च पृथक् पृथक्। सत्त्विकं शुद्धमनसः, राजसि तामसि चात्मनः।।",
        hindiMeaning = "भगवान कहते हैं: श्रद्धा तीन प्रकार की होती है—सत्त्विक, राजसिक और तामसिक। यह श्रद्धा व्यक्ति के मन, बुद्धि और कार्य में परिलक्षित होती है। सत्त्विक श्रद्धा शुद्ध और निर्मल मन की होती है, राजसिक श्रद्धा सांसारिक कामों और इच्छाओं से प्रेरित होती है, और तामसिक श्रद्धा अज्ञान और प्रमाद से युक्त होती है।",
        englishMeaning = "Lord Krishna says: Faith manifests as Sattvic, Rajasic, or Tamasic, according to the mind, intellect, and actions of a person."
    ),

    Shloka(
        number = 3,
        sanskrit = "सत्त्विकं सुखसंकम्पं यच्छ्रुतं या ज्ञात्वा प्रजायते। रजसि कामकर्मणां यदास्ति तामसि नित्यमेव च।।",
        hindiMeaning = "सत्त्विक श्रद्धा वे है जो शास्त्र और धर्म के अनुसार सुखपूर्वक उत्पन्न होती है। राजसिक श्रद्धा वह है जो काम और लोभ से प्रेरित होती है। तामसिक श्रद्धा अज्ञान और प्रमाद के कारण जन्म लेती है और व्यक्ति को स्थिरता और शांति से दूर रखती है। प्रत्येक प्रकार की श्रद्धा के परिणाम अलग-अलग होते हैं और यह व्यक्ति के कर्म और जीवन को प्रभावित करती है।",
        englishMeaning = "Sattvic faith arises from knowledge and virtue; Rajasic from desires; Tamasic from ignorance and delusion, affecting a person’s deeds."
    ),

    Shloka(
        number = 4,
        sanskrit = "यच्छ्रुतेर्ज्ञानेनैव दत्तं सत्त्वं, यद्रामेणानुरक्तं। रजसा भक्तं कामात्स्थावरजङ्गमेषु। तामसा हि यदभिक्ष्यं प्राप्यते प्रमदाभिभूता।।",
        hindiMeaning = "सत्त्विक व्यक्ति जो श्रुति और ज्ञान से प्रभावित होता है, वह धर्म का पालन करता है। राजसिक व्यक्ति कामों में लिप्त होकर स्थावर और जंगम वस्तुओं में आकर्षित होता है। तामसिक व्यक्ति प्रमाद और अज्ञान के कारण भिक्षा या लाभ प्राप्त करता है, लेकिन उसका फल दुःख और बंधन होता है। यह श्रद्धा और कर्म का स्पष्ट विवरण है।",
        englishMeaning = "What is heard and known by the Sattvic is followed with devotion; Rajasic faith is desire-driven, while Tamasic faith, born of delusion, leads to misfortune."
    ),

    Shloka(
        number = 5,
        sanskrit = "अन्नं प्रीत्यर्थमिदं सर्वं भक्त्या युक्तः सेवनम्। रजसा फलप्राप्त्यर्थं तामसा प्रमदाभिभूतः।।",
        hindiMeaning = "सत्त्विक व्यक्ति भोजन और वस्तुओं का उपभोग श्रद्धा और भक्ति से करता है। राजसिक व्यक्ति केवल फल की प्राप्ति के लिए कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है और उसका जीवन केवल भ्रम और लोभ में व्यतीत होता है। यह श्लोक बताता है कि श्रद्धा का प्रकार कर्मों के उद्देश्य और दृष्टिकोण को निर्धारित करता है।",
        englishMeaning = "The Sattvic consume offerings with devotion, Rajasic for gain, and Tamasic due to delusion and negligence."
    ),

    Shloka(
        number = 6,
        sanskrit = "यद्यदाश्नाति सत्त्वभूतं रजस्तमसंप्रभवम्। तत्तत्राप्तमिच्छन्ति तं भुञ्जन्मुख्येन भारत।।",
        hindiMeaning = "जो कुछ भी लोग खाते हैं, उसमें सत्त्व, रजस या तमस के अनुसार गुण होते हैं। प्रत्येक व्यक्ति उस भोजन के अनुसार अनुभव प्राप्त करता है। सत्त्विक भोजन शरीर और मन को स्थिर और निर्मल बनाता है, राजसिक भोजन वासनाओं को बढ़ाता है, और तामसिक भोजन प्रमाद और आलस्य पैदा करता है।",
        englishMeaning = "Whatever is eaten carries Sattva, Rajas, or Tamas; people experience effects according to the nature of the food."
    ),

    Shloka(
        number = 7,
        sanskrit = "सत्त्वमित्सुकृतं सुखकरं राजसः कामप्रदं तत्। तमः पच्यते प्रमाद्युक्तं भोजनं दुःखजनकम्।।",
        hindiMeaning = "सत्त्विक भोजन शुद्ध और सुख देने वाला होता है। राजसिक भोजन वासनाओं को बढ़ाने वाला होता है। तामसिक भोजन, जो प्रमाद और अज्ञान से लिया जाता है, दुःख और रोग उत्पन्न करता है। यह श्लोक स्पष्ट करता है कि भोजन का गुण मन और शरीर पर सीधे प्रभाव डालता है।",
        englishMeaning = "Sattvic food is pure and nourishing, Rajasic food incites desires, Tamasic food is stale or impure, causing pain and lethargy."
    ),

    Shloka(
        number = 8,
        sanskrit = "सत्त्वसम्पन्नो भूतेषु सर्वेषु रमते चात्मनि। रजसिकः कामभोगार्थी तामसः प्रमदाग्रतः।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति सभी प्राणियों में रमणीय और आत्मा में स्थित होता है। राजसिक व्यक्ति केवल काम और भोग में लिप्त रहता है। तामसिक व्यक्ति प्रमाद और अज्ञान में खोया रहता है। यह श्लोक बताता है कि श्रद्धा और गुण के अनुसार व्यक्ति की मानसिक और आध्यात्मिक स्थिति बदलती है।",
        englishMeaning = "A Sattvic person delights in all beings and dwells in the self; Rajasic is pleasure-seeking; Tamasic is heedless and deluded."
    ),

    Shloka(
        number = 9,
        sanskrit = "सत्त्वं शास्त्रवित् भक्त्या युक्तः क्रियायां सतां गतः। रजसः कामार्थी फलप्रदः तमः प्रमादग्रस्तः।।",
        hindiMeaning = "सत्त्विक व्यक्ति शास्त्र ज्ञाता होता है, भक्तिभाव से कर्म करता है और सत्य के मार्ग पर चलता है। राजसिक व्यक्ति कर्म को केवल लाभ या फल के लिए करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। इस प्रकार श्रद्धा का प्रकार कर्म के उद्देश्य और परिणाम को प्रभावित करता है।",
        englishMeaning = "Sattvic act with knowledge and devotion; Rajasic for result-oriented desires; Tamasic out of negligence and delusion."
    ),

    Shloka(
        number = 10,
        sanskrit = "सत्त्वसम्पन्नः कर्मणि स्थिरः धर्मेण युक्तः। रजसः कामभोगार्थी तामसः प्रमादग्रस्तः।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति अपने कर्मों में स्थिर और धर्मयुक्त होता है। राजसिक व्यक्ति कर्मों में काम और लाभ की इच्छा से लिप्त होता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह स्पष्ट करता है कि व्यक्ति की श्रद्धा और गुण उसके कर्मों की गुणवत्ता और दिशा निर्धारित करते हैं।",
        englishMeaning = "The Sattvic are steady in action and guided by dharma; Rajasic act for desire, Tamasic due to negligence."
    ),

    Shloka(
        number = 11,
        sanskrit = "सत्त्वसम्पन्नः प्रज्ञावान् क्रियायां स्थिरो युक्तः। रजसः कामार्थी फलप्रदः तामसः प्रमादग्रस्तः।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी और स्थिर होता है, अपने कर्मों में धर्म और भक्तिभाव से युक्त रहता है। राजसिक व्यक्ति केवल फल की प्राप्ति के लिए कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में खोया रहता है। यह गुणों और श्रद्धा का व्यवहारिक प्रभाव स्पष्ट करता है।",
        englishMeaning = "Sattvic person is wise, stable, and devoted in action; Rajasic acts for gain; Tamasic is heedless and deluded."
    ),

    Shloka(
        number = 12,
        sanskrit = "सत्त्वं ज्ञानवित् धर्मयुक्तं रजसः कामार्थकृत्। तमः प्रमादग्रस्तो हि सदा लोभः कर्मणि।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानवान और धर्मयुक्त होता है। राजसिक व्यक्ति कर्म को केवल काम और लाभ के लिए करता है। तामसिक व्यक्ति प्रमादग्रस्त और लोभी होता है। यह श्लोक जीवन में गुणों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic is knowledgeable and righteous, Rajasic seeks gain, Tamasic is heedless and greedy in action."
    ),

    Shloka(
        number = 13,
        sanskrit = "सत्त्वसम्पन्नो धर्मे स्थिरः प्रज्ञावान् युक्तः। रजसः कामार्थी फलप्रदः तमः प्रमादग्रस्तः।।",
        hindiMeaning = "सत्त्विक व्यक्ति धर्म में स्थिर और ज्ञानी होता है। राजसिक केवल लाभ और काम के लिए कर्म करता है। तामसिक प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक श्रद्धा और गुणों का स्पष्ट वर्णन है।",
        englishMeaning = "Sattvic are steadfast in dharma and wise; Rajasic seek gain; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 14,
        sanskrit = "सत्त्वं शास्त्रवित् भक्त्या युक्तः क्रियायां सतां गतः। रजसः कामार्थी फलप्रदः तमः प्रमादग्रस्तः।।",
        hindiMeaning = "सत्त्विक व्यक्ति शास्त्रज्ञ, भक्तिभावयुक्त और कर्म में स्थिर होता है। राजसिक व्यक्ति कर्म को केवल फल के लिए करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। इस प्रकार श्रद्धा के प्रकार कर्मों और जीवन पर प्रभाव डालते हैं।",
        englishMeaning = "Sattvic are scripture-knowing, devoted, and steadfast; Rajasic act for result; Tamasic act from negligence."
    ),

    Shloka(
        number = 15,
        sanskrit = "सत्त्वसम्पन्नः धर्मयुक्तो ज्ञानेन युक्तः स्थिरः। रजसः कामार्थी फलप्रदः तामसः प्रमादग्रस्तः।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति धर्मयुक्त, ज्ञानी और स्थिर होता है। राजसिक व्यक्ति केवल फल की प्राप्ति के लिए कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों और श्रद्धा के प्रभाव को पुनः रेखांकित करता है।",
        englishMeaning = "Sattvic are righteous, wise, and steadfast; Rajasic seek gain; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 16,
        sanskrit = "सत्त्वं धृतिः प्रज्ञा दमः शौर्यं स्वाध्यायस्तप आर्जवम्। असुरसम्पन्नः लोभो क्रोधो मोहः प्रमादः शाश्वतः।।",
        hindiMeaning = "सत्त्वसम्पन्न में धृति, प्रज्ञा, दम, शौर्य, स्वाध्याय, तप और आर्जव शामिल हैं। असुरसम्पन्न व्यक्ति लोभी, क्रोधी, मोहग्रस्त और प्रमाद में रहता है। यह दोनों प्रवृत्तियों की स्पष्ट तुलना है।",
        englishMeaning = "Sattvic qualities: fortitude, wisdom, self-restraint, courage, study, austerity, honesty; Demonic traits: greed, anger, delusion, heedlessness."
    ),

    Shloka(
        number = 17,
        sanskrit = "सत्त्वसम्पन्नः ज्ञानी भक्त्या समन्वितः स्थिरः। असुरसम्पन्नो प्रमादी लोभी क्रोधग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभावयुक्त और स्थिर होता है। असुरसम्पन्न व्यक्ति हमेशा प्रमादी, लोभी और क्रोधग्रस्त रहता है। यह श्लोक गुणों के स्पष्ट अंतर को दर्शाता है।",
        englishMeaning = "Sattvic individuals are wise, devoted, and steadfast; demonic are heedless, greedy, and wrathful."
    ),

    Shloka(
        number = 18,
        sanskrit = "सत्त्वं ज्ञानवित् धर्मयुक्तं रजसः कामार्थकृत्। तमः प्रमादग्रस्तो हि सदा लोभः कर्मणि।।",
        hindiMeaning = "सत्त्विक व्यक्ति ज्ञानी और धर्मयुक्त होता है। राजसिक व्यक्ति कर्म को केवल लाभ और काम के लिए करता है। तामसिक व्यक्ति प्रमादग्रस्त और लोभी होता है। यह श्लोक जीवन में गुणों के प्रभाव को स्पष्ट करता है।",
        englishMeaning = "Sattvic is knowledgeable and righteous; Rajasic acts for gain; Tamasic is heedless and greedy."
    ),

    Shloka(
        number = 19,
        sanskrit = "दैवसम्पन्नो धर्मे स्थिरः ज्ञानेन युक्तः प्रज्ञावान्। असुरसम्पन्नः प्रमादी लोभी क्रोधाग्रस्तः सदा।।",
        hindiMeaning = "दैवी सम्पदा वाले व्यक्ति धर्म में स्थिर, ज्ञानी और प्रज्ञावान होते हैं। असुर सम्पदा वाले व्यक्ति प्रमादी, लोभी और क्रोधग्रस्त रहते हैं। यह श्लोक गुणों के अनुसार जीवन की स्पष्ट तस्वीर देता है।",
        englishMeaning = "Divine are steadfast in dharma, wise, and knowledgeable; demonic are heedless, greedy, and wrathful."
    ),

    Shloka(
        number = 20,
        sanskrit = "एवं दैवासुर सम्पद्विभागः स्पष्टः स नारद। सत्त्वसम्पन्नो भवेद्व्यवस्थितः पुरुषोत्तमः।।",
        hindiMeaning = "हे नारद! इस प्रकार दैवी और असुरी सम्पदा का भेद स्पष्ट किया गया। जो व्यक्ति सत्त्वसम्पन्न होता है, वह पुरुषोत्तम की भक्ति में स्थिर रहता है और मोक्ष की ओर अग्रसर होता है। यह श्लोक मुख्य शिक्षा को संक्षेप में प्रस्तुत करता है।",
        englishMeaning = "Thus, O Narada, the distinction between divine and demonic qualities is clear. One endowed with Sattva becomes steadfast in the Supreme and attains liberation."
    ),
    Shloka(
        number = 21,
        sanskrit = "भक्त्या च युक्तो ह्येवं श्रुतं यथार्जुनः स्मृतम्। सत्त्वसम्पन्नः प्रजायते, रजसः कामप्रदः च तमः प्रमादग्रस्तः।।",
        hindiMeaning = "जो व्यक्ति भक्ति और श्रद्धा के साथ कर्म करता है, वह सत्त्वसम्पन्न कहलाता है। जो केवल काम और इच्छाओं के लिए कर्म करता है, वह राजसिक होता है। और जो प्रमाद और अज्ञान में फँसा रहता है, वह तामसिक कहलाता है। इस प्रकार श्रद्धा और मनोवृत्ति के अनुसार व्यक्ति का स्वभाव और कर्म तय होते हैं।",
        englishMeaning = "One performing actions with devotion becomes Sattvic; for desire-driven actions, Rajasic; and heedless actions make one Tamasic."
    ),

    Shloka(
        number = 22,
        sanskrit = "सत्त्वसम्पन्नो हि यत्नेन धर्मे स्थिरो भवति। रजसः कामार्थकृत् लोभिनो हि प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति यत्नपूर्वक धर्म में स्थिर रहता है। राजसिक व्यक्ति केवल काम और लाभ के लिए कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान से ग्रसित होता है। गुणों के अनुसार व्यक्ति के कर्म और मनोवृत्ति में भिन्नता स्पष्ट होती है।",
        englishMeaning = "Sattvic are steadfast in dharma with effort; Rajasic act for gain; Tamasic are heedless and deluded."
    ),

    Shloka(
        number = 23,
        sanskrit = "सत्त्वसम्पन्नः प्रज्ञावान् धर्मे स्थिरो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी और धर्म में स्थिर होता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह श्लोक गुणों के प्रभाव को संक्षेप में प्रस्तुत करता है।",
        englishMeaning = "Sattvic are wise and steadfast in dharma; Rajasic act for desire; Tamasic are deluded and negligent."
    ),

    Shloka(
        number = 24,
        sanskrit = "सत्त्वसम्पन्नो यत्नेन धर्मे स्थिरः प्रज्ञावान्। असुरसम्पन्नः प्रमादी लोभी क्रोधग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति यत्नपूर्वक धर्म में स्थिर और ज्ञानी होता है। असुर सम्पन्न व्यक्ति हमेशा प्रमादी, लोभी और क्रोधग्रस्त रहता है। गुणों के अनुसार जीवन की स्थिरता और मन की स्थिति तय होती है।",
        englishMeaning = "Sattvic is steadfast in dharma and wise with effort; demonic are heedless, greedy, and wrathful."
    ),

    Shloka(
        number = 25,
        sanskrit = "सत्त्वसम्पन्नः भक्त्या युक्तः स्थिरः प्रज्ञावान् च। असुरसम्पन्नः प्रमादी लोभी क्रोधग्रस्तः सदा।।",
        hindiMeaning = "सत्त्वसम्पन्न व्यक्ति भक्ति और श्रद्धा से युक्त, स्थिर और ज्ञानी होता है। असुरसम्पन्न व्यक्ति हमेशा प्रमादी, लोभी और क्रोधग्रस्त रहता है। यह श्लोक श्रद्धा और गुणों के प्रभाव को पुनः स्पष्ट करता है।",
        englishMeaning = "Sattvic individuals are devoted, steadfast, and wise; demonic are heedless, greedy, and wrathful."
    ),

    Shloka(
        number = 26,
        sanskrit = "दैवसम्पन्नः धर्मयुक्तो ज्ञानेन युक्तः स्थिरः। असुरसम्पन्नः प्रमादी लोभी क्रोधग्रस्तः सदा।।",
        hindiMeaning = "दैवी सम्पदा वाला व्यक्ति धर्मयुक्त, ज्ञानी और स्थिर रहता है। असुर सम्पदा वाला हमेशा प्रमादी, लोभी और क्रोधग्रस्त रहता है। यह गुणों के अनुसार जीवन के परिणाम को स्पष्ट करता है।",
        englishMeaning = "Divine are righteous, knowledgeable, and steadfast; demonic are heedless, greedy, and wrathful."
    ),

    Shloka(
        number = 27,
        sanskrit = "एवं सत्त्वराजसतमसः श्रद्धात्रयभेदः स्पष्टः। सत्त्वसम्पन्नो भवेद्व्यवस्थितः पुरुषोत्तमः।।",
        hindiMeaning = "इस प्रकार सत्त्व, रजस और तमस में श्रद्धा का भेद स्पष्ट किया गया। सत्त्वसम्पन्न व्यक्ति पुरुषोत्तम की भक्ति में स्थित होता है और मोक्ष की ओर अग्रसर होता है। यह श्लोक इस अध्याय की सारभूत शिक्षा को संक्षेप में प्रस्तुत करता है।",
        englishMeaning = "Thus, the distinction of faith into Sattva, Rajas, and Tamas is clear; one endowed with Sattva becomes steadfast in the Supreme."
    ),

    Shloka(
        number = 28,
        sanskrit = "श्रद्धा त्रयप्रकृत्या न केवलं कर्मण्यपि प्रभावति। मनसि च बुद्धौ च शरीरसंपत्तौ च तथा।।",
        hindiMeaning = "श्रद्धा तीन प्रकार की केवल कर्मों में ही नहीं, बल्कि मन, बुद्धि और शरीर की सम्पत्ति में भी प्रभाव डालती है। सत्त्विक श्रद्धा मन और बुद्धि को शुद्ध बनाती है, राजसिक इच्छाओं और कामनाओं को बढ़ाती है, और तामसिक प्रमाद और आलस्य में डालती है। यह स्पष्ट करता है कि श्रद्धा का प्रभाव समग्र जीवन पर पड़ता है।",
        englishMeaning = "Faith of three types affects not only actions but also mind, intellect, and bodily well-being; Sattvic purifies, Rajasic fuels desire, Tamasic causes heedlessness."
    )
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaSeventeenScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 17 – श्रद्धात्रयविभाग योग",
                        fontSize = 26.sp, // ✅ consistent with other chapters
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
                onClick = { navController.navigate(Screen.QuizSeventeen.route) },
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
            contentPadding = PaddingValues(bottom = 70.dp) // ✅ content stays above banner
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
                        painter = painterResource(R.drawable.gemini_generated_image_poipkbpoipkbpoip),
                        contentDescription = "Chapter 17 – Shraddhatraya Vibhaga Yoga",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaSeventeenShlokas) { shloka ->
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
