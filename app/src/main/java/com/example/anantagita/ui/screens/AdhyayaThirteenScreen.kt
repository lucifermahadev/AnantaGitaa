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
val adhyayaThirteenShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अर्जुन उवाच। प्रकृतिं पुरुषं चैव क्षेत्रं क्षेत्रज्ञमेव च। एतद्वेदितुमिच्छामि ज्ञानं ज्ञेयं च केशव॥",
        hindiMeaning = "अर्जुन ने कहा – हे केशव! मैं प्रकृति और पुरुष के विषय में, क्षेत्र और क्षेत्रज्ञ के विषय में तथा ज्ञान और ज्ञेय के विषय में जानना चाहता हूँ। यहाँ अर्जुन ईश्वर से ज्ञान के गहन विषयों पर स्पष्टता चाहते हैं। वे समझना चाहते हैं कि यह शरीर (क्षेत्र), उसमें रहने वाला जानने वाला (क्षेत्रज्ञ), प्रकृति (माया) और पुरुष (परमात्मा) कैसे संबंधित हैं। यह अध्याय वास्तव में ज्ञानमार्ग का मूल है और इसमें आत्मा और शरीर के भेद को स्पष्ट किया गया है।",
        englishMeaning = "Arjuna asks Krishna to explain about nature (prakriti), the enjoyer (purusha), the field (body), the knower of the field, as well as knowledge and the knowable."
    ),

    Shloka(
        number = 2,
        sanskrit = "श्रीभगवानुवाच। इदं शरीरं कौन्तेय क्षेत्रमित्यभिधीयते। एतद्यो वेत्ति तं प्राहुः क्षेत्रज्ञ इति तद्विदः॥",
        hindiMeaning = "भगवान श्रीकृष्ण ने कहा – हे कौन्तेय! यह शरीर 'क्षेत्र' कहलाता है और जो इस शरीर को जानता है, उसे 'क्षेत्रज्ञ' कहा जाता है। ज्ञानीजन ऐसा ही कहते हैं। यहाँ भगवान बताते हैं कि शरीर एक क्षेत्र है जिसमें अनुभव, कर्म और संस्कार बोए जाते हैं। आत्मा वह है जो इस शरीर को जानती है, परंतु उससे भिन्न है। इस भेद को समझना ही आत्मज्ञान की शुरुआत है।",
        englishMeaning = "Krishna explains that the body is called the field, and the one who knows this body is called the knower of the field by the wise."
    ),

    Shloka(
        number = 3,
        sanskrit = "क्षेत्रज्ञं चापि मां विद्धि सर्वक्षेत्रेषु भारत। क्षेत्रक्षेत्रज्ञयोर्ज्ञानं यत्तज्ज्ञानं मतं मम॥",
        hindiMeaning = "हे भारत! सभी शरीरों में जो क्षेत्रज्ञ है, वह मैं ही हूँ। क्षेत्र और क्षेत्रज्ञ के संबंध को जो समझता है, वही वास्तव में ज्ञानवान है। भगवान यहाँ यह बताते हैं कि प्रत्येक जीवात्मा में क्षेत्रज्ञ का प्रतिबिंब है, लेकिन सर्वोच्च क्षेत्रज्ञ परमात्मा स्वयं हैं। जब साधक समझ लेता है कि आत्मा और परमात्मा का संबंध अविभाज्य है, तब वह वास्तविक ज्ञान प्राप्त करता है।",
        englishMeaning = "Krishna says that He Himself is the knower of the field in all bodies. True knowledge is understanding the distinction between the field and the knower."
    ),

    Shloka(
        number = 4,
        sanskrit = "तत्क्षेत्रं यच्च यादृक्च यद्विकारि यतश्च यत्। स च यो यत्प्रभावश्च तत्समासेन मे शृणु॥",
        hindiMeaning = "भगवान कहते हैं – वह क्षेत्र कैसा है, उसमें क्या-क्या परिवर्तन होते हैं, वह कहाँ से उत्पन्न हुआ और उसका क्या प्रभाव है – यह सब मैं संक्षेप में तुम्हें बताऊँगा। यहाँ शरीर (क्षेत्र) का स्वरूप समझाने की भूमिका रखी गई है। शरीर की प्रकृति, उसकी विकारशीलता और उसका स्रोत क्या है, यह जानना आत्मज्ञान की कुंजी है।",
        englishMeaning = "Krishna promises to explain briefly what the field is, its nature, its changes, its origin, and its influences."
    ),

    Shloka(
        number = 5,
        sanskrit = "ऋषिभिर्बहुधा गीतं छन्दोभिर्विविधैः पृथक्। ब्रह्मसूत्रपदैश्चैव हेतुमद्भिर्विनिश्चितैः॥",
        hindiMeaning = "यह विषय अनेक ऋषियों द्वारा, विभिन्न छंदों में और ब्रह्मसूत्र जैसे युक्तिपूर्ण शास्त्रों में वर्णित किया गया है। अर्थात् यह कोई नया विषय नहीं है, बल्कि शास्त्र और ऋषियों की वाणी से बार-बार समझाया गया है। भगवान यहाँ शास्त्रीय प्रमाण देते हैं कि जो वे बताने जा रहे हैं, वह सनातन ज्ञान है।",
        englishMeaning = "This knowledge has been sung in many ways by the sages, in Vedic hymns, and confirmed by reasoned statements in the Brahma-sutras."
    ),

    Shloka(
        number = 6,
        sanskrit = "महाभूतान्यहंकारो बुद्धिरव्यक्तमेव च। इन्द्रियाणि दशैकं च पञ्च चेन्द्रियगोचराः॥",
        hindiMeaning = "पाँच महाभूत (पृथ्वी, जल, अग्नि, वायु, आकाश), अहंकार, बुद्धि, अव्यक्त (मूल प्रकृति), दस इन्द्रियाँ (पाँच ज्ञानेंद्रियाँ और पाँच कर्मेंद्रियाँ), एक मन तथा पाँच विषय (शब्द, स्पर्श, रूप, रस, गंध) – ये सब क्षेत्र में सम्मिलित हैं। यह शरीर और जगत इन्हीं तत्वों से बना है। यह विवरण साधक को यह समझने में मदद करता है कि शरीर अस्थायी और भौतिक तत्वों का मिश्रण है।",
        englishMeaning = "The field includes the five great elements, ego, intellect, the unmanifest, the ten senses, the mind, and the five sense objects."
    ),

    Shloka(
        number = 7,
        sanskrit = "इच्छा द्वेषः सुखं दुःखं संघातश्चेतना धृतिः। एतत्क्षेत्रं समासेन सविकारमुदाहृतम्॥",
        hindiMeaning = "इच्छा, द्वेष, सुख, दुःख, शरीर का संघटन, चेतना और धृति – ये सब भी क्षेत्र के विकार हैं। अर्थात् ये सभी अनुभव शरीर और मन से संबंधित हैं, आत्मा से नहीं। आत्मा शुद्ध, नित्य और अचल है, जबकि ये सब क्षेत्र में उत्पन्न होकर बदलते रहते हैं।",
        englishMeaning = "Desire, aversion, pleasure, pain, the body’s combination, consciousness, and firmness are also described as modifications of the field."
    ),

    Shloka(
        number = 8,
        sanskrit = "अमानित्वमदम्भित्वमहिंसा क्षान्तिरार्जवम्। आचार्योपासनं शौचं स्थैर्यमात्मविनिग्रहः॥",
        hindiMeaning = "अमानित्व (अभिमान का अभाव), अदम्भित्व (दंभ का अभाव), अहिंसा, क्षमा, सरलता, आचार्य की सेवा, शौच (आंतरिक और बाह्य शुद्धि), स्थिरता और आत्मसंयम – ये सब ज्ञान के अंग बताए गए हैं। यहाँ भगवान ज्ञान को केवल बौद्धिक समझ नहीं, बल्कि आचरण और गुणों से जोड़े हुए बताते हैं।",
        englishMeaning = "Humility, freedom from hypocrisy, nonviolence, forgiveness, simplicity, service to the teacher, cleanliness, steadiness, and self-control are aspects of knowledge."
    ),

    Shloka(
        number = 9,
        sanskrit = "इन्द्रियार्थेषु वैराग्यमनहंकार एव च। जन्ममृत्युजराव्याधिदुःखदोषानुदर्शनम्॥",
        hindiMeaning = "इन्द्रिय विषयों से वैराग्य, अहंकार का अभाव और जन्म, मृत्यु, जरा तथा व्याधि के दुःख को बार-बार देखना – ये सब भी ज्ञान के अंग हैं। यहाँ भगवान बताते हैं कि साधक को संसार के दुःखों का यथार्थ ज्ञान होना चाहिए, तभी वैराग्य उत्पन्न होगा और वह ईश्वर की ओर बढ़ेगा।",
        englishMeaning = "Detachment from sense objects, absence of ego, and constant awareness of the miseries of birth, death, old age, and disease are also knowledge."
    ),

    Shloka(
        number = 10,
        sanskrit = "असक्तिरनभिष्वङ्गः पुत्रदारगृहादिषु। नित्यं च समचित्तत्वमिष्टानिष्टोपपत्तिषु॥",
        hindiMeaning = "पुत्र, स्त्री, गृह आदि में आसक्ति और मोह का अभाव तथा इष्ट और अनिष्ट की प्राप्ति में समचित्त रहना – यह भी ज्ञान है। भगवान यहाँ परिवार और भौतिक वस्तुओं से अत्यधिक आसक्ति को त्यागने की शिक्षा देते हैं। समत्व ही वास्तविक आत्मिक प्रगति का आधार है।",
        englishMeaning = "Non-attachment to family and possessions, and equanimity in favorable and unfavorable situations, are marks of knowledge."
    ),

    Shloka(
        number = 11,
        sanskrit = "मयि चानन्ययोगेन भक्तिरव्यभिचारिणी। विविक्तदेशसेवित्वमरतिर्जनसंसदि॥",
        hindiMeaning = "मेरे प्रति अनन्य और अव्यभिचारी भक्ति, एकांत स्थानों में निवास और जनसमूह में अरुचि – ये भी ज्ञान के लक्षण हैं। साधक जब बाहरी आकर्षण से हटकर भगवान की भक्ति में मन लगाता है, तब उसे वास्तविक ज्ञान प्राप्त होता है।",
        englishMeaning = "Unflinching devotion to Krishna, preference for solitude, and disinterest in crowds are also knowledge."
    ),

    Shloka(
        number = 12,
        sanskrit = "अध्यात्मज्ञाननित्यत्वं तत्त्वज्ञानार्थदर्शनम्। एतज्ज्ञानमिति प्रोक्तमज्ञानं यदतोऽन्यथा॥",
        hindiMeaning = "आध्यात्मिक ज्ञान में नित्य लगे रहना और तत्त्वज्ञान के अर्थ का दर्शन करना – यह सब ज्ञान कहा गया है। इसके अतिरिक्त जो है, वह अज्ञान है। यहाँ भगवान ज्ञान और अज्ञान का स्पष्ट भेद करते हैं। वास्तविक ज्ञान वही है जो आत्मा और परमात्मा की ओर ले जाए।",
        englishMeaning = "Constant engagement in spiritual knowledge and perception of the truth are called knowledge. Whatever is contrary to this is ignorance."
    ),

    Shloka(
        number = 13,
        sanskrit = "ज्ञेयं यत्तत्प्रवक्ष्यामि यज्ज्ञात्वामृतमश्नुते। अनादिमत्परं ब्रह्म न सत्तन्नासदुच्यते॥",
        hindiMeaning = "अब मैं तुम्हें उस ज्ञेय का वर्णन करूँगा जिसे जानकर मनुष्य अमृतत्व को प्राप्त होता है। वह ब्रह्म अनादि है, परम है और न तो सत कहा जा सकता है और न असत। यह परम सत्य शाश्वत और अव्याख्येय है। इसे जान लेने पर साधक मोक्ष का अनुभव करता है।",
        englishMeaning = "Krishna describes the knowable: the supreme Brahman, beginningless and beyond cause, which is neither called existence nor non-existence."
    ),

    Shloka(
        number = 14,
        sanskrit = "सर्वतः पाणिपादं तत्सर्वतोऽक्षिशिरोमुखम्। सर्वतः श्रुतिमल्लोके सर्वमावृत्य तिष्ठति॥",
        hindiMeaning = "उस परमात्मा के हाथ-पाँव सर्वत्र हैं, नेत्र, शिर और मुख सर्वत्र हैं, कान सर्वत्र हैं। वह सबको आच्छादित करके संसार में स्थित है। अर्थात् परमात्मा सर्वव्यापक है। सबमें वही कार्य करता है और सब इन्द्रियों में वही चेतना के रूप में विद्यमान है।",
        englishMeaning = "That Supreme has hands and feet everywhere, eyes, heads, and mouths everywhere, ears everywhere; it pervades all in the universe."
    ),

    Shloka(
        number = 15,
        sanskrit = "सर्वेन्द्रियगुणाभासं सर्वेन्द्रियविवर्जितम्। असक्तं सर्वभृच्चैव निर्गुणं गुणभोक्तृ च॥",
        hindiMeaning = "वह सब इन्द्रियों के गुणों को प्रकाशित करता है, परंतु स्वयं उन इन्द्रियों से रहित है। वह सबमें आसक्त नहीं है, फिर भी सबको धारण करता है। वह निर्गुण है, परंतु गुणों का भोग कराने वाला भी वही है। यह परमात्मा की दिव्य विरोधाभासी प्रकृति है।",
        englishMeaning = "It illuminates the functions of all senses, yet is devoid of senses. Detached, yet sustains all; beyond the gunas, yet enjoys them."
    ),

    Shloka(
        number = 16,
        sanskrit = "बहिरन्तश्च भूतानामचरं चरमेव च। सूक्ष्मत्वात्तदविज्ञेयं दूरस्थं चान्तिके च तत्॥",
        hindiMeaning = "वह सभी प्राणियों के बाहर भी है और भीतर भी। वह अचर भी है और चर भी। सूक्ष्म होने के कारण वह अविज्ञेय है। वह दूरस्थ भी प्रतीत होता है और अत्यंत समीप भी। यह परमात्मा की सर्वव्यापकता और रहस्यमयी प्रकृति है।",
        englishMeaning = "It exists inside and outside all beings, moving and unmoving. Being subtle, it is unknowable, appearing distant yet very near."
    ),

    Shloka(
        number = 17,
        sanskrit = "अविभक्तं च भूतेषु विभक्तमिव च स्थितम्। भूतभर्तृ च तज्ज्ञेयं ग्रसिष्णु प्रभविष्णु च॥",
        hindiMeaning = "वह प्राणियों में अविभाजित होकर भी विभक्त सा प्रतीत होता है। वह सबका धारक है, सबको निगलने वाला है और सबको उत्पन्न करने वाला भी। यहाँ परमात्मा की सृष्टि, पालन और संहार की शक्ति का वर्णन है।",
        englishMeaning = "It appears divided among beings, yet is undivided. It sustains all, devours all, and generates all."
    ),

    Shloka(
        number = 18,
        sanskrit = "ज्योतिषामपि तज्ज्योतिस्तमसः परमुच्यते। ज्ञानं ज्ञेयं ज्ञानगम्यं हृदि सर्वस्य विष्ठितम्॥",
        hindiMeaning = "वह सब प्रकाशों का भी प्रकाश है और अंधकार से परे है। वही ज्ञान है, वही ज्ञेय है और वही ज्ञान द्वारा प्राप्त किया जा सकता है। वह सबके हृदय में स्थित है। यह परमात्मा का आत्मस्वरूप है, जो सबका आंतरिक प्रकाश है।",
        englishMeaning = "It is the light of all lights, beyond darkness. It is knowledge, the object of knowledge, and the goal of knowledge, dwelling in all hearts."
    ),

    Shloka(
        number = 19,
        sanskrit = "इति क्षेत्रं तथा ज्ञानं ज्ञेयं चोक्तं समासतः। मद्भक्त एतद्विज्ञाय मद्भावायोपपद्यते॥",
        hindiMeaning = "इस प्रकार क्षेत्र, ज्ञान और ज्ञेय का संक्षेप में वर्णन किया गया। जो भक्त इसे समझ लेता है, वह मेरे स्वरूप को प्राप्त हो जाता है। यहाँ भगवान कहते हैं कि इस ज्ञान का उद्देश्य केवल बौद्धिक समझ नहीं, बल्कि परमात्मा की प्राप्ति है।",
        englishMeaning = "Thus the field, knowledge, and the knowable have been briefly described. A devotee who understands this attains Krishna’s being."
    ),

    Shloka(
        number = 20,
        sanskrit = "प्रकृतिं पुरुषं चैव विद्ध्यनादी उभावपि। विकारांश्च गुणांश्चैव विद्धि प्रकृतिसम्भवान्॥",
        hindiMeaning = "प्रकृति और पुरुष – इन दोनों को अनादि जानो। प्रकृति से विकार और गुण उत्पन्न होते हैं। यहाँ भगवान बताते हैं कि सृष्टि के विविध रूप प्रकृति के विकार और गुणों से उत्पन्न होते हैं, परंतु उनके आधार में पुरुष अर्थात् परमात्मा है।",
        englishMeaning = "Know both nature (prakriti) and the purusha to be beginningless. Modifications and qualities are born of prakriti."
    ),
    Shloka(
        number = 21,
        sanskrit = "पुरुषः प्रकृतिस्थो हि भुङ्क्ते प्रकृतिजान्गुणान्। कारणं गुणसङ्गोऽस्य सदसद्योनिजन्मसु॥",
        hindiMeaning = "जब जीवात्मा प्रकृति में स्थित होकर उसके गुणों का भोग करता है, तो उसे अच्छे और बुरे जन्म मिलते हैं। यह सब गुणों के साथ उसके संबंध का परिणाम है। यहाँ भगवान यह स्पष्ट करते हैं कि जीवात्मा अपने कर्म और प्रकृति के गुणों के अनुसार बार-बार जन्म लेता है। यह संबंध ही संसार में बंधन का कारण है। जब तक साधक गुणों से ऊपर नहीं उठता, तब तक वह पुनर्जन्म के चक्र में फँसा रहता है।",
        englishMeaning = "When the soul associates with material nature, it enjoys the qualities born of nature. This attachment to the modes causes birth in good and evil wombs."
    ),

    Shloka(
        number = 22,
        sanskrit = "उपद्रष्टानुमन्ता च भर्ता भोक्ता महेश्वरः। परमात्मेति चाप्युक्तो देहेऽस्मिन्पुरुषः परः॥",
        hindiMeaning = "इस शरीर में जो परमात्मा है, वह उपद्रष्टा (साक्षी), अनुमन्ता, भर्ता (पालन करने वाला), भोक्ता और महेश्वर कहलाता है। वह पर पुरुष है। यहाँ भगवान जीव और परमात्मा का भेद स्पष्ट करते हैं। जीव भोग करता है, लेकिन परमात्मा सबका नियंता और साक्षी है। परमात्मा ही सबको धारण करता है और उसी की कृपा से सब क्रियाएँ होती हैं।",
        englishMeaning = "The Supreme Soul in this body is said to be the observer, permitter, supporter, experiencer, and the great Lord."
    ),

    Shloka(
        number = 23,
        sanskrit = "य एवं वेत्ति पुरुषं प्रकृतिं च गुणैः सह। सर्वथा वर्तमानोऽपि न स भूयोऽभिजायते॥",
        hindiMeaning = "जो पुरुष और प्रकृति को गुणों सहित यथार्थ जान लेता है, वह किसी भी प्रकार से आचरण करते हुए भी पुनर्जन्म नहीं लेता। यह ज्ञान उसे जन्म-मरण के चक्र से मुक्त कर देता है। यहाँ भगवान ज्ञान के महत्व को बताते हैं। केवल आत्मा-परमात्मा और प्रकृति के संबंध को जान लेने से ही मोक्ष का मार्ग खुल जाता है।",
        englishMeaning = "One who truly understands the purusha and prakriti with its qualities is not born again, regardless of how he lives."
    ),

    Shloka(
        number = 24,
        sanskrit = "ध्यानेनात्मनि पश्यन्ति केचिदात्मानमात्मना। अन्ये सांख्येन योगेन कर्मयोगेन चापरे॥",
        hindiMeaning = "कुछ लोग ध्यानयोग द्वारा आत्मा को आत्मा में देखते हैं। अन्य सांख्य योग से, और कुछ कर्मयोग द्वारा भी आत्मज्ञान प्राप्त करते हैं। यहाँ भगवान विभिन्न मार्गों का वर्णन करते हैं। चाहे साधक ध्यान में लगे, दार्शनिक विवेचन में या कर्म के मार्ग में, यदि उसका लक्ष्य आत्मज्ञान है, तो वह मोक्ष की ओर बढ़ता है।",
        englishMeaning = "Some see the soul within through meditation, others through Sankhya philosophy, and still others through the path of selfless action."
    ),

    Shloka(
        number = 25,
        sanskrit = "अन्ये त्वेवमजानन्तः श्रुत्वाऽन्येभ्य उपासते। तेऽपि चातितरन्त्येव मृत्युं श्रुतिपरायणाः॥",
        hindiMeaning = "कुछ लोग इस ज्ञान को न जानकर भी दूसरों से सुनकर उपासना करते हैं। वे भी श्रुति के मार्ग का अनुसरण करते हुए मृत्यु को पार कर जाते हैं। यहाँ भगवान बताते हैं कि श्रवण और विश्वास भी मुक्ति का साधन बन सकता है। यदि साधक श्रद्धा से सुनता है और ईश्वर में मन लगाता है, तो वह भी मोक्ष प्राप्त कर सकता है।",
        englishMeaning = "Others, not knowing in detail, worship by hearing from others. Even they, being devoted to what they hear, transcend death."
    ),

    Shloka(
        number = 26,
        sanskrit = "यावत्संजायते किञ्चित्सत्त्वं स्थावरजङ्गमम्। क्षेत्रक्षेत्रज्ञसंयोगात्तद्विद्धि भरतर्षभ॥",
        hindiMeaning = "हे भरतर्षभ! जितने भी स्थावर (अचल) और जंगम (चल) प्राणी उत्पन्न होते हैं, वे सब क्षेत्र और क्षेत्रज्ञ के संयोग से ही उत्पन्न होते हैं। यहाँ भगवान जीव और शरीर के संबंध को कारण बताते हैं। जब आत्मा शरीर के साथ जुड़ती है, तभी जीव की उत्पत्ति होती है।",
        englishMeaning = "Whatever moving or unmoving being is born, know it to be produced by the union of the field and the knower of the field."
    ),

    Shloka(
        number = 27,
        sanskrit = "समं सर्वेषु भूतेषु तिष्ठन्तं परमेश्वरम्। विनश्यत्स्वविनश्यन्तं यः पश्यति स पश्यति॥",
        hindiMeaning = "जो परमेश्वर को सभी प्राणियों में समान रूप से स्थित देखता है, जो स्वयं अविनाशी होते हुए भी नाशवान शरीरों में रहता है – वही वास्तविक दृष्टि वाला है। यहाँ भगवान समदृष्टि का महत्व बताते हैं। जो साधक सबमें परमात्मा को देखता है, वही सच्चा ज्ञानी है।",
        englishMeaning = "He truly sees who sees the Supreme Lord existing equally in all beings, the imperishable within the perishable."
    ),

    Shloka(
        number = 28,
        sanskrit = "समं पश्यन्हि सर्वत्र समवस्थितमीश्वरम्। न हिनस्त्यात्मनात्मानं ततो याति परां गतिम्॥",
        hindiMeaning = "जो साधक ईश्वर को सब जगह समान रूप से स्थित देखता है, वह स्वयं को दूसरों में और दूसरों को स्वयं में देखता है। इस प्रकार वह किसी को हानि नहीं पहुँचाता और परम गति को प्राप्त होता है। यहाँ भगवान बताते हैं कि समदृष्टि अहिंसा और मोक्ष की ओर ले जाती है।",
        englishMeaning = "Seeing the Lord equally everywhere, one does not degrade oneself by harming others, and thus attains the supreme goal."
    ),

    Shloka(
        number = 29,
        sanskrit = "प्रकृत्यैव च कर्माणि क्रियमाणानि सर्वशः। यः पश्यति तथाऽऽत्मानमकर्तारं स पश्यति॥",
        hindiMeaning = "जो यह देखता है कि सभी कर्म वास्तव में प्रकृति द्वारा ही कराए जाते हैं और आत्मा अकर्ता है – वही सही दृष्टि रखता है। यहाँ भगवान बताते हैं कि आत्मा शुद्ध साक्षी है, कर्म का कर्ता केवल प्रकृति और उसके गुण हैं।",
        englishMeaning = "He who sees that all actions are performed by nature alone, while the self is non-doer, truly sees."
    ),

    Shloka(
        number = 30,
        sanskrit = "यदा भूतपृथग्भावमेकस्थमनुपश्यति। तत एव च विस्तारं ब्रह्म संपद्यते तदा॥",
        hindiMeaning = "जब साधक यह देखता है कि विविध भूत एक ही ब्रह्म में स्थित हैं और उसी से विस्तार पाते हैं, तब वह ब्रह्म को प्राप्त होता है। यहाँ भगवान अद्वैत का सत्य प्रकट करते हैं। सभी प्राणी अंततः एक ही परमात्मा से उत्पन्न और उसी में स्थित हैं।",
        englishMeaning = "When one sees that all beings rest in the One and are expanded from Him, then he attains Brahman."
    ),

    Shloka(
        number = 31,
        sanskrit = "अनादित्वान्निर्गुणत्वात्परमात्मायमव्ययः। शरीरस्थोऽपि कौन्तेय न करोति न लिप्यते॥",
        hindiMeaning = "हे कौन्तेय! परमात्मा अनादि है, निर्गुण है और अविनाशी है। शरीर में स्थित होकर भी वह न कुछ करता है और न किसी कर्म से लिप्त होता है। यहाँ भगवान बताते हैं कि परमात्मा सदा शुद्ध और अचल है, वह कभी भी संसार के कर्मों से प्रभावित नहीं होता।",
        englishMeaning = "Because He is beginningless and beyond the gunas, the Supreme Soul is imperishable. Though dwelling in the body, He neither acts nor is tainted."
    ),

    Shloka(
        number = 32,
        sanskrit = "यथा सर्वगतं सौक्ष्म्यादाकाशं नोपलिप्यते। सर्वत्रावस्थितो देहे तथात्मा नोपलिप्यते॥",
        hindiMeaning = "जैसे आकाश सर्वत्र होने पर भी अपनी सूक्ष्मता के कारण लिप्त नहीं होता, वैसे ही आत्मा शरीर में स्थित होकर भी उससे लिप्त नहीं होता। आत्मा शुद्ध और निरपेक्ष है। शरीर के विकार और कर्म आत्मा को प्रभावित नहीं कर सकते।",
        englishMeaning = "Just as the all-pervading sky is not tainted due to its subtlety, so the soul, though present in the body, is not tainted."
    ),

    Shloka(
        number = 33,
        sanskrit = "यथा प्रकाशयत्येकः कृत्स्नं लोकमिमं रविः। क्षेत्रं क्षेत्री तथा कृत्स्नं प्रकाशयति भारत॥",
        hindiMeaning = "जैसे एक सूर्य समस्त लोक को प्रकाशित करता है, वैसे ही क्षेत्रज्ञ (आत्मा) पूरे शरीर को प्रकाशित करता है। यहाँ भगवान आत्मा की चेतनाशक्ति का वर्णन करते हैं। आत्मा ही शरीर में प्रकाश और चेतना का कारण है।",
        englishMeaning = "As the one sun illuminates the whole world, so the knower of the field illuminates the entire body, O Bharata."
    ),

    Shloka(
        number = 34,
        sanskrit = "क्षेत्रक्षेत्रज्ञयोरेवमन्तरं ज्ञानचक्षुषा। भूतप्रकृतिमोक्षं च ये विदुर्यान्ति ते परम्॥",
        hindiMeaning = "जो लोग ज्ञान की दृष्टि से क्षेत्र और क्षेत्रज्ञ के भेद को जानते हैं तथा भूतों की प्रकृति से मुक्त हो जाते हैं – वे परम पद को प्राप्त होते हैं। यहाँ भगवान बताते हैं कि यही विवेक मोक्ष का कारण है। शरीर और आत्मा का भेद समझकर जीव मुक्त हो जाता है।",
        englishMeaning = "Those who, with the eye of knowledge, perceive the distinction between the field and the knower, and the liberation from nature, attain the Supreme."
    ),

    Shloka(
        number = 35,
        sanskrit = "इति क्षेत्रं तथा ज्ञानं ज्ञेयं चोक्तं समासतः। मद्भक्त एतद्विज्ञाय मद्भावायोपपद्यते॥",
        hindiMeaning = "इस प्रकार क्षेत्र, ज्ञान और ज्ञेय का संक्षेप में वर्णन किया गया। जो भक्त इसे समझ लेता है, वह मेरे स्वरूप को प्राप्त होता है। यह श्लोक इस अध्याय का निष्कर्ष है। भगवान कहते हैं कि ज्ञान का अंतिम लक्ष्य ईश्वर से एकत्व प्राप्त करना है।",
        englishMeaning = "Thus the field, knowledge, and the knowable have been briefly described. A devotee who understands this attains Krishna’s state."
    )

)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaThirteenScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 13 – क्षेत्रक्षेत्रज्ञ विभाग योग",
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
                onClick = { navController.navigate(Screen.QuizThirteen.route) },
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
                        painter = painterResource(R.drawable.gemini_generated_image_5nko2l5nko2l5nko),
                        contentDescription = "Chapter 13 – Kshetra Kshetragya Vibhaga Yoga",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaThirteenShlokas) { shloka ->
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
