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
val adhyayaFourteenShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "श्रीभगवानुवाच। परं भूयः प्रवक्ष्यामि ज्ञानानां ज्ञानमुत्तमम्। यज्ज्ञात्वा मुनयः सर्वे परां सिद्धिमितो गताः।।",
        hindiMeaning = "भगवान श्रीकृष्ण कहते हैं—हे अर्जुन! अब मैं तुझे फिर से एक अत्यन्त उच्च और श्रेष्ठ ज्ञान बताऊँगा। इस ज्ञान को प्राप्त करके महान ऋषि और मुनि जन्म-मृत्यु के बंधनों से मुक्त होकर परम सिद्धि को प्राप्त हुए हैं। यह ज्ञान साधारण ज्ञान नहीं है, बल्कि वह दिव्य तत्वज्ञान है जो जीवन की दिशा और उद्देश्य को पूर्ण रूप से बदल देता है। यह आत्मा और परमात्मा के बीच के संबंध का बोध कराता है। इस ज्ञान से साधक समझ पाता है कि उसे किस प्रकार संसार में रहते हुए भी निर्लिप्त और मुक्त जीवन जीना है। इसलिए भगवान इसे ज्ञानों में सर्वोत्तम कह रहे हैं।",
        englishMeaning = "Lord Krishna said: I shall again declare to you the supreme knowledge, the best of all wisdoms. By knowing this, sages have attained the highest perfection and liberation."
    ),

    Shloka(
        number = 2,
        sanskrit = "इदं ज्ञानमुपाश्रित्य मम साधर्म्यमागताः। सर्गेऽपि नोपजायन्ते प्रलये न व्यथन्ति च।।",
        hindiMeaning = "जो साधक इस दिव्य ज्ञान को आत्मसात कर लेते हैं, वे भगवान के स्वरूप के समान स्थिति को प्राप्त हो जाते हैं। ऐसे ज्ञानी जन्म और मृत्यु के चक्र से मुक्त हो जाते हैं। वे न तो सृष्टि के आरम्भ में उत्पन्न होते हैं और न ही प्रलय के समय दुखी होते हैं। इसका अर्थ है कि वे संसार के उतार-चढ़ावों से परे हो जाते हैं। आत्मा परमात्मा से एकरूप हो जाती है और वह शाश्वत शांति और आनन्द का अनुभव करती है। यह स्थिति वही प्राप्त करता है जो निरंतर भगवान की शरण में रहता है।",
        englishMeaning = "By taking refuge in this knowledge, one attains My divine nature. Such souls are not born during creation, nor destroyed during dissolution."
    ),

    Shloka(
        number = 3,
        sanskrit = "मम योनिर्महद्ब्रह्म तस्मिन्गर्भं दधाम्यहम्। सम्भवः सर्वभूतानां ततो भवति भारत।।",
        hindiMeaning = "श्रीकृष्ण कहते हैं—हे अर्जुन! मेरी महान ब्रह्म स्वरूप प्रकृति मेरी योनि है, और उसमें मैं चेतन बीज रूप में गर्भ स्थापित करता हूँ। उसी से सभी प्राणी उत्पन्न होते हैं। यहाँ सृष्टि की उत्पत्ति का रहस्य बताया गया है। प्रकृति और पुरुष, दोनों मिलकर सृष्टि का संचालन करते हैं। भगवान प्रकृति में चेतना का संचार करते हैं और उससे विविध प्राणियों की उत्पत्ति होती है। यह दर्शाता है कि भगवान ही सृष्टि के परम कारण और नियंता हैं।",
        englishMeaning = "The great Brahman is My womb, in which I place the seed. From that, O Arjuna, all beings come into existence."
    ),

    Shloka(
        number = 4,
        sanskrit = "सर्वयोनिषु कौन्तेय मूर्तयः सम्भवन्ति याः। तासां ब्रह्म महद्योनिरहं बीजप्रदः पिता।।",
        hindiMeaning = "हे अर्जुन! सभी योनियों में जो भी जीव उत्पन्न होते हैं, उनका मूल आधार महान ब्रह्म है और मैं ही उनका बीज देने वाला पिता हूँ। इसका अर्थ है कि संपूर्ण सृष्टि में जो भी जीवन है, वह भगवान से ही उत्पन्न हुआ है। प्रकृति माता के समान है और भगवान पिता के समान। यह श्लोक हमें यह स्मरण कराता है कि हर प्राणी में दिव्यता है क्योंकि उसका मूल भगवान ही हैं। इससे हमें सबके प्रति समानता और करुणा का भाव रखना चाहिए।",
        englishMeaning = "Whatever forms are produced in all wombs, O Arjuna, the great Brahman is their womb, and I am the seed-giving father."
    ),

    Shloka(
        number = 5,
        sanskrit = "सत्त्वं रजस्तम इति गुणाः प्रकृतिसम्भवाः। निबध्नन्ति महाबाहो देहे देहिनमव्ययम्।।",
        hindiMeaning = "भगवान कहते हैं—हे महाबाहु! सत्त्व, रज और तम ये तीन गुण प्रकृति से उत्पन्न होते हैं और ये अविनाशी आत्मा को शरीर में बाँधते हैं। ये गुण आत्मा को संसार के बंधनों में फँसा देते हैं। सत्त्व गुण प्रकाश और ज्ञान देता है, रजोगुण आसक्ति और कर्म की प्रवृत्ति जगाता है, और तमोगुण अज्ञान और आलस्य में डालता है। आत्मा स्वयं शुद्ध और निर्लेप है, लेकिन ये गुण उसे विभिन्न अनुभवों में बाँधते हैं। यह जानना साधक के लिए अत्यन्त आवश्यक है ताकि वह मुक्त हो सके।",
        englishMeaning = "Sattva, Rajas, and Tamas are the qualities born of nature, O Arjuna. They bind the imperishable soul to the body."
    ),

    Shloka(
        number = 6,
        sanskrit = "तत्र सत्त्वं निर्मलत्वात्प्रकाशकमनामयम्। सुखसंगेन बध्नाति ज्ञानसंगेन चानघ।।",
        hindiMeaning = "इनमें से सत्त्वगुण अपनी निर्मलता के कारण प्रकाशमान और निर्दोष है। यह आत्मा को सुख के साथ और ज्ञान के साथ बाँधता है। सत्त्वगुण मनुष्य को उच्चतर और सात्विक जीवन की ओर ले जाता है। यह मन को शांत, स्वच्छ और संतुलित बनाता है। लेकिन फिर भी यह बंधन का कारण है क्योंकि मनुष्य सुख और ज्ञान में आसक्त हो जाता है। इसलिए साधक को सत्त्वगुण का भी अतिक्रमण करना आवश्यक है।",
        englishMeaning = "Sattva, being pure, is illuminating and free from illness. Yet it binds the soul through attachment to happiness and knowledge."
    ),

    Shloka(
        number = 7,
        sanskrit = "रजो रागात्मकं विद्धि तृष्णासंगसमुद्भवम्। तन्निबध्नाति कौन्तेय कर्मसंगेन देहिनम्।।",
        hindiMeaning = "हे अर्जुन! रजोगुण रागात्मक है, यह तृष्णा और आसक्ति से उत्पन्न होता है। यह जीव को कर्म के बंधन में बाँधता है। रजोगुण मनुष्य में कार्य करने की तीव्र इच्छा और परिणाम की अपेक्षा उत्पन्न करता है। इससे लोभ, ईर्ष्या और असंतोष पैदा होता है। यद्यपि यह गुण प्रगति और सक्रियता लाता है, परन्तु यह व्यक्ति को शांति और संतुलन से दूर कर देता है। रजोगुण में फँसा हुआ मनुष्य निरंतर कर्म और फल की चाह में उलझा रहता है।",
        englishMeaning = "Know that Rajas is of the nature of passion, born of desire and attachment. It binds the soul by attachment to action."
    ),

    Shloka(
        number = 8,
        sanskrit = "तमस्त्वज्ञानजं विद्धि मोहनं सर्वदेहिनाम्। प्रमादालस्यनिद्राभिस्तन्निबध्नाति भारत।।",
        hindiMeaning = "तमोगुण अज्ञान से उत्पन्न होता है और सभी जीवों को मोह में डालता है। यह प्रमाद, आलस्य और निद्रा के द्वारा आत्मा को बाँधता है। तमोगुण व्यक्ति की बुद्धि को ढक देता है और उसे सत्य का बोध नहीं होने देता। इसके प्रभाव से मनुष्य निष्क्रिय, आलसी और भ्रमित हो जाता है। यह गुण जीवन की प्रगति और आध्यात्मिक उन्नति में सबसे बड़ी बाधा है। इसलिए साधक को तमोगुण से सावधान रहना चाहिए।",
        englishMeaning = "Tamas, born of ignorance, deludes all beings. It binds the soul through negligence, laziness, and sleep."
    ),

    Shloka(
        number = 9,
        sanskrit = "सत्त्वं सुखे संजयति रजः कर्मणि भारत। ज्ञानमावृत्य तु तमः प्रमादे संजयत्युत।।",
        hindiMeaning = "हे भारत! सत्त्वगुण जीव को सुख में आसक्त करता है, रजोगुण कर्म में बाँधता है, और तमोगुण अज्ञान के कारण प्रमाद में डाल देता है। ये तीनों गुण आत्मा को अपनी-अपनी दिशा में बाँधते हैं। मनुष्य यदि इनसे ऊपर नहीं उठता तो वह मुक्त नहीं हो सकता। सत्त्व में सुख और शांति मिलती है, पर उसमें भी बंधन है। रजस में कर्मशीलता है, पर उसमें अशांति है। तमस में अज्ञान है, जिससे जीवन अंधकारमय हो जाता है।",
        englishMeaning = "Sattva attaches one to happiness, Rajas to action, and Tamas to negligence by covering knowledge."
    ),

    Shloka(
        number = 10,
        sanskrit = "रजस्तमश्चाभिभूय सत्त्वं भवति भारत। रजः सत्त्वं तमश्चैव तमः सत्त्वं रजस्तथा।।",
        hindiMeaning = "हे भारत! कभी सत्त्वगुण रज और तम को परास्त कर प्रबल हो जाता है, कभी रजोगुण सत्त्व और तम को दबा देता है, और कभी तमोगुण सत्त्व और रज को। इस प्रकार ये तीनों गुण निरंतर आपस में संघर्ष करते रहते हैं। मनुष्य की प्रकृति और उसकी प्रवृत्ति इस बात पर निर्भर करती है कि किस समय कौन सा गुण प्रबल है। जब तक जीव इन गुणों के प्रभाव से मुक्त नहीं होता, तब तक वह संसार के चक्र से मुक्त नहीं हो सकता।",
        englishMeaning = "Sometimes Sattva prevails over Rajas and Tamas; sometimes Rajas dominates Sattva and Tamas; and sometimes Tamas overcomes Sattva and Rajas."
    ),
    Shloka(
        number = 11,
        sanskrit = "सर्वद्वारेषु देहेऽस्मिन्प्रकाश उपजायते। ज्ञानं यदा तदा विद्याद्विवृद्धं सत्त्वमित्युत।।",
        hindiMeaning = "जब इस शरीर के सभी द्वारों में प्रकाश उत्पन्न होता है, अर्थात् जब इन्द्रियाँ और मन शुद्ध होकर ज्ञान से प्रकाशित हो जाते हैं, तब यह समझना चाहिए कि सत्त्वगुण की वृद्धि हुई है। सत्त्वगुण के प्रभाव से मनुष्य का विवेक जागृत होता है और सत्य को पहचानने की क्षमता बढ़ जाती है। उसका मन शांत, स्वच्छ और निर्मल रहता है। ऐसे व्यक्ति में करुणा, दया और समता की भावना अधिक प्रकट होती है। यह स्थिति साधक के लिए आध्यात्मिक प्रगति का सूचक है।",
        englishMeaning = "When the light of knowledge shines through all the senses in this body, then know that Sattva has increased greatly."
    ),

    Shloka(
        number = 12,
        sanskrit = "लोभः प्रवृत्तिरारम्भः कर्मणामशमः स्पृहा। रजस्येतानि जायन्ते विवृद्धे भरतर्षभ।।",
        hindiMeaning = "हे भरतश्रेष्ठ! जब लोभ, अधिक प्रवृत्ति, अनेक कर्मों का आरम्भ, अशांति और तृष्णा बढ़ती है, तब जानना चाहिए कि रजोगुण की वृद्धि हुई है। रजोगुण मनुष्य को निरंतर कर्म और इच्छाओं की ओर धकेलता है। इसमें शांति का अभाव होता है और मनुष्य संतोष नहीं पा सकता। ऐसे व्यक्ति का जीवन हमेशा दौड़-भाग और असंतोष से भरा होता है। रजोगुण प्रगति के लिए आवश्यक है, लेकिन यदि संतुलन न हो तो यह बंधन का कारण बनता है।",
        englishMeaning = "When greed, activity, restlessness, and longing arise, O best of the Bharatas, then Rajas has increased."
    ),

    Shloka(
        number = 13,
        sanskrit = "अप्रकाशोऽप्रवृत्तिश्च प्रमादो मोह एव च। तमस्येतानि जायन्ते विवृद्धे कुरुनन्दन।।",
        hindiMeaning = "हे कुरुनन्दन! जब अज्ञान, निष्क्रियता, प्रमाद और मोह बढ़ते हैं, तब समझना चाहिए कि तमोगुण की वृद्धि हुई है। तमोगुण के प्रभाव से मनुष्य सत्य और असत्य में भेद नहीं कर पाता। आलस्य, नींद और उदासीनता उसके जीवन पर हावी हो जाती है। उसका मन लक्ष्यहीन और भ्रमित रहता है। यह स्थिति आध्यात्मिक जीवन की प्रगति में बड़ी बाधा है और इसे त्यागना आवश्यक है।",
        englishMeaning = "When darkness, inactivity, negligence, and delusion arise, O Arjuna, then Tamas has increased."
    ),

    Shloka(
        number = 14,
        sanskrit = "यदा सत्त्वे प्रवृद्धे तु प्रलयं याति देहभृत्। तदोत्तमविदां लोकानमलान्प्रतिपद्यते।।",
        hindiMeaning = "जब देहधारी प्राणी सत्त्वगुण की वृद्धि के समय मृत्यु को प्राप्त होता है, तो वह उच्चतम लोकों में जाता है जहाँ विद्वान और पुण्यात्मा रहते हैं। इसका अर्थ है कि सत्त्वगुण मृत्यु के बाद भी आत्मा को उच्चतर जन्म या स्वर्गिक सुख की ओर ले जाता है। इस प्रकार सत्त्वगुण आत्मा को प्रकाश और शांति की ओर अग्रसर करता है। यह स्थिति पुण्य और ज्ञान के कारण मिलती है।",
        englishMeaning = "When a person dies in Sattva, he attains the pure worlds of the learned and wise."
    ),

    Shloka(
        number = 15,
        sanskrit = "रजसि प्रलयं गत्वा कर्मसङ्गिषु जायते। तथा प्रलीनस्तमसि मूढयोनिषु जायते।।",
        hindiMeaning = "यदि कोई व्यक्ति रजोगुण की प्रबलता के समय मृत्यु को प्राप्त होता है, तो वह कर्म में आसक्त लोगों के बीच जन्म लेता है। और यदि तमोगुण की प्रबलता के समय मृत्यु होती है, तो वह अज्ञानमयी योनियों में जन्म लेता है। इसका तात्पर्य है कि मृत्यु के समय की स्थिति और गुण ही अगले जन्म की दिशा तय करते हैं। इसलिए साधक को अपने जीवनभर सतोगुण को बढ़ाने का प्रयास करना चाहिए।",
        englishMeaning = "Dying in Rajas, one is born among those attached to action. Dying in Tamas, one is born in deluded wombs."
    ),

    Shloka(
        number = 16,
        sanskrit = "कर्मणः सुकृतस्याहुः सात्त्विकं निर्मलं फलम्। रजसस्तु फलं दुःखमज्ञानं तमसः फलम्।।",
        hindiMeaning = "सात्त्विक कर्म का फल निर्मल और शुद्ध कहा जाता है। रजोगुण से किए गए कर्म का फल दुखदायी होता है। और तमोगुण से उत्पन्न कर्म का फल अज्ञान ही होता है। इसका अर्थ है कि कर्म का स्वभाव और उसका परिणाम गुणों के आधार पर निश्चित होता है। सत्त्व से सुख और शांति मिलती है, रजस से असंतोष और दुख, और तमस से अंधकार और अज्ञान।",
        englishMeaning = "The fruit of Sattvic action is pure and uplifting; the fruit of Rajas is sorrow; and the fruit of Tamas is ignorance."
    ),

    Shloka(
        number = 17,
        sanskrit = "सत्त्वात्सञ्जायते ज्ञानं रजसो लोभ एव च। प्रमादमोहौ तमसो भवतोऽज्ञानमेव च।।",
        hindiMeaning = "सत्त्वगुण से ज्ञान उत्पन्न होता है, रजोगुण से लोभ उत्पन्न होता है और तमोगुण से प्रमाद, मोह और अज्ञान उत्पन्न होते हैं। इसका अर्थ है कि तीनों गुण मनुष्य के भीतर अलग-अलग प्रवृत्तियाँ लाते हैं। सत्त्व विवेक और प्रकाश देता है। रजस इच्छाओं और लालच को बढ़ाता है। तमस अंधकार, आलस्य और अज्ञान में डालता है। यह जानकर साधक को अपने जीवन में सत्त्वगुण को बढ़ाने का प्रयास करना चाहिए।",
        englishMeaning = "From Sattva arises knowledge, from Rajas greed, and from Tamas negligence, delusion, and ignorance."
    ),

    Shloka(
        number = 18,
        sanskrit = "ऊर्ध्वं गच्छन्ति सत्त्वस्था मध्ये तिष्ठन्ति राजसाः। जघन्यगुणवृत्तिस्था अधो गच्छन्ति तामसाः।।",
        hindiMeaning = "जो लोग सत्त्वगुण में स्थित रहते हैं, वे ऊर्ध्वगामी होते हैं अर्थात् उच्चतर लोकों को प्राप्त होते हैं। जो रजोगुणी होते हैं, वे मध्य में रहते हैं और कर्मफल के बंधन में बँधे रहते हैं। और जो तमोगुणी होते हैं, वे अधोगति को प्राप्त होते हैं। इसका अर्थ है कि तीनों गुण आत्मा के गमन की दिशा निर्धारित करते हैं। इसलिए सत्त्वगुण को अपनाना आवश्यक है।",
        englishMeaning = "Those situated in Sattva rise upwards; the Rajasic remain in the middle; the Tamasic, engaged in the lowest qualities, go downward."
    ),

    Shloka(
        number = 19,
        sanskrit = "नान्यं गुणेभ्यः कर्तारं यदा द्रष्टानुपश्यति। गुणेभ्यश्च परं वेत्ति मद्भावं सोऽधिगच्छति।।",
        hindiMeaning = "जब ज्ञानी साधक यह देखता है कि वास्तव में गुण ही सब कुछ करते हैं और आत्मा उनसे परे है, तब वह सच्चा दर्शन करता है। और जब वह इस सत्य को जानकर गुणों से परे परमात्मा को पहचान लेता है, तब वह मेरे स्वरूप को प्राप्त होता है। यह स्थिति मोक्ष और परम ज्ञान की है। इसका अर्थ है कि आत्मा न तो बंधनकारी है और न ही कर्मकारी, केवल गुण ही बंधन और कर्म के कारण हैं।",
        englishMeaning = "When the seer perceives no doer other than the gunas and knows the Supreme beyond these gunas, he attains My nature."
    ),

    Shloka(
        number = 20,
        sanskrit = "गुणानेतानतीत्य त्रीन्देही देहसमुद्भवान्। जन्ममृत्युजरादुःखैर्विमुक्तोऽमृतमश्नुते।।",
        hindiMeaning = "जब embodied soul इन तीनों गुणों से ऊपर उठ जाता है, जो शरीर की उत्पत्ति का कारण हैं, तब वह जन्म, मृत्यु, जरा और दुखों से मुक्त होकर अमृत का अनुभव करता है। यह अवस्था मुक्ति और परम शांति की है। इसका अर्थ है कि आत्मा को तभी अमरत्व और अनन्त आनन्द प्राप्त होता है जब वह गुणों के प्रभाव से पूरी तरह मुक्त हो जाता है।",
        englishMeaning = "When the soul transcends these three gunas that arise from the body, it is freed from birth, death, old age, and sorrow, and attains immortality."
    ),

    Shloka(
        number = 21,
        sanskrit = "अर्जुन उवाच। कैर्लिङ्गैस्त्रीन्गुणानेतानतीतो भवति प्रभो। किमाचारः कथं चैतांस्त्रीन्गुणानतिवर्तते।।",
        hindiMeaning = "अर्जुन ने पूछा—हे प्रभो! जिनके द्वारा मनुष्य इन तीन गुणों को पार कर जाता है, उनके क्या लक्षण होते हैं? उसका आचरण कैसा होता है और वह इन तीन गुणों को किस प्रकार अतिक्रमण करता है? यह प्रश्न अत्यंत गूढ़ है क्योंकि साधक जानना चाहता है कि गुणातीत की स्थिति कैसी होती है। वास्तव में यह प्रश्न हर साधक के मन में उठता है कि व्यवहार में गुणों से परे होना कैसे सम्भव है।",
        englishMeaning = "Arjuna said: O Lord, what are the marks of one who has transcended these three gunas? What is his conduct, and how does he go beyond them?"
    ),

    Shloka(
        number = 22,
        sanskrit = "श्रीभगवानुवाच। प्रकाशं च प्रवृत्तिं च मोहमेव च पाण्डव। न द्वेष्टि सम्प्रवृत्तानि न निवृत्तानि काङ्क्षति।।",
        hindiMeaning = "भगवान ने कहा—हे पाण्डव! जब साधक न तो प्रकाश (सत्त्व), न प्रवृत्ति (रजस), और न ही मोह (तमस) से घृणा करता है, और न ही इनके चले जाने पर उन्हें पाने की इच्छा करता है, तब वह गुणातीत कहलाता है। इसका अर्थ है कि वह साधक गुणों के प्रभाव से उदासीन हो जाता है। वह इनसे न तो आकर्षित होता है और न ही भयभीत। यही समत्व की स्थिति है।",
        englishMeaning = "The Blessed Lord said: O Arjuna, he neither hates illumination, activity, or delusion when they appear, nor desires them when they disappear."
    ),

    Shloka(
        number = 23,
        sanskrit = "उदासीनवदासीनो गुणैर्यो न विचाल्यते। गुणा वर्तन्त इत्येवं योऽवतिष्ठति नेङ्गते।।",
        hindiMeaning = "जो साधक उदासीन की भाँति स्थित रहता है और गुणों से विचलित नहीं होता, और यह समझता है कि गुण ही अपने-अपने कार्य कर रहे हैं, वह स्थिर रहता है और हिलता-डुलता नहीं। इसका अर्थ है कि उसका आत्मज्ञान इतना प्रबल हो जाता है कि गुणों का उस पर कोई प्रभाव नहीं पड़ता। वह संसार में रहते हुए भी निर्लिप्त और मुक्त रहता है।",
        englishMeaning = "He who, seated as if indifferent, is not disturbed by the gunas, knowing that they act, remains steadfast and unmoved."
    ),

    Shloka(
        number = 24,
        sanskrit = "समदुःखसुखः स्वस्थः समलोष्टाश्मकाञ्चनः। तुल्यप्रियाप्रियो धीरस्तुल्यनिन्दात्मसंस्तुतिः।।",
        hindiMeaning = "जो साधक दुख और सुख में समान रहता है, स्थिरचित्त और संतुलित रहता है, मिट्टी, पत्थर और सोने को समान समझता है, प्रिय और अप्रिय में समान रहता है, निन्दा और स्तुति में एक समान रहता है, वही गुणातीत कहलाता है। यह समभाव की अवस्था है। ऐसे व्यक्ति का मन बाहरी परिस्थितियों से प्रभावित नहीं होता। वह सदा आत्मा में स्थित रहता है।",
        englishMeaning = "He who is the same in pleasure and pain, who is steady, regards a clod, a stone, and gold alike, who is equal in praise and blame, is firm and calm."
    ),

    Shloka(
        number = 25,
        sanskrit = "मानापमानयोस्तुल्यस्तुल्यो मित्रारिपक्षयोः। सर्वारम्भपरित्यागी गुणातीतः स उच्यते।।",
        hindiMeaning = "जो साधक मान और अपमान में समान रहता है, मित्र और शत्रु को समान दृष्टि से देखता है, और सभी प्रकार के आरम्भों का त्याग कर देता है, वही गुणातीत कहलाता है। इसका अर्थ है कि वह न तो अहंकार से फूलता है और न ही अपमान से टूटता है। वह निष्काम होकर सब कार्य करता है। यही गुणातीत की विशेषता है।",
        englishMeaning = "He who is equal in honor and dishonor, the same to friend and foe, and renounces all undertakings, is said to have transcended the gunas."
    ),

    Shloka(
        number = 26,
        sanskrit = "मां च योऽव्यभिचारेण भक्तियोगेन सेवते। स गुणान्समतीत्यैतान्ब्रह्मभूयाय कल्पते।।",
        hindiMeaning = "जो साधक अव्यभिचारी भक्ति योग से मेरी सेवा करता है, वह इन तीनों गुणों को पार कर जाता है और ब्रह्म के समान हो जाता है। यहाँ भगवान स्पष्ट करते हैं कि भक्ति ही गुणों से ऊपर उठने का सबसे सरल मार्ग है। निष्काम और अखण्ड भक्ति साधक को परमात्मा के साथ एकरूप कर देती है। यही गुणातीत की पराकाष्ठा है।",
        englishMeaning = "He who serves Me with unwavering devotion, transcends these gunas and becomes fit for Brahman realization."
    ),

    Shloka(
        number = 27,
        sanskrit = "ब्रह्मणो हि प्रतिष्ठाहममृतस्याव्ययस्य च। शाश्वतस्य च धर्मस्य सुखस्यैकान्तिकस्य च।।",
        hindiMeaning = "क्योंकि मैं ही ब्रह्म का आधार हूँ, जो अमर और अविनाशी है। मैं शाश्वत धर्म और परम सुख का भी आधार हूँ। इसका अर्थ है कि परमात्मा ही वह तत्त्व है, जिस पर समस्त ब्रह्म, धर्म और सुख टिका हुआ है। भगवान ही सबका आश्रय और परम ध्येय हैं। इसलिए जो साधक भक्ति के मार्ग पर चलता है, वही गुणातीत होकर परम शांति को प्राप्त करता है।",
        englishMeaning = "For I am the foundation of the imperishable Brahman, of eternal dharma, and of absolute bliss."
    )
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaFourteenScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 14 – गुणत्रय विभाग योग",
                        fontSize = 26.sp, // ✅ bigger title
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
                onClick = { navController.navigate(Screen.QuizFourteen.route) },
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
            // ✅ Top Image for Adhyaya 14
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
                        painter = painterResource(R.drawable.gemini_generated_image_amwc75amwc75amwc),
                        contentDescription = "Chapter 14 – Gunatraya Vibhaga Yoga",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaFourteenShlokas) { shloka ->
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
