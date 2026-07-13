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


val adhyayaEightShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अर्जुन उवाच ।\nकिं तद्ब्रह्म किमध्यात्मं किं कर्म पुरुषोत्तम ।\nअधिभूतं च किं प्रोक्तमधिदैवं किमुच्यते ॥",
        hindiMeaning = "अर्जुन भगवान से प्रश्न करता है – हे पुरुषोत्तम! वह ब्रह्म क्या है, अध्यात्म किसे कहते हैं, कर्म किसे कहा जाता है, और अधिभूत तथा अधिदैव क्या कहलाते हैं? यह प्रश्न अर्जुन की जिज्ञासा का प्रतीक है। वह भगवान से जानना चाहता है कि ये दार्शनिक शब्द जिनका उल्लेख पहले किया गया है, उनके वास्तविक अर्थ और महत्व क्या हैं। अर्जुन की यह जिज्ञासा सामान्य साधकों के मन की शंका को भी व्यक्त करती है, क्योंकि इन गहन शब्दों का रहस्य सामान्य समझ से परे है। यह श्लोक स्पष्ट करता है कि अर्जुन अब केवल युद्ध की उलझन में ही नहीं है, बल्कि जीवन और अध्यात्म से जुड़े गहन प्रश्नों का उत्तर चाहता है।",
        englishMeaning = "Arjuna said: O Supreme Person, what is Brahman, what is the Self, what is action? What is called the material world, and what is the divine principle?"
    ),
    Shloka(
        number = 2,
        sanskrit = "अधियज्ञः कथं कोऽत्र देहेऽस्मिन्मधुसूदन ।\nप्रयाणकाले च कथं ज्ञेयोऽसि नियतात्मभिः ॥",
        hindiMeaning = "अर्जुन आगे पूछता है – हे मधुसूदन! अधियज्ञ कौन है और वह इस शरीर में कैसे विद्यमान है? और जब मृत्यु का समय आता है, तब संयमित आत्मा वाले साधक आपको किस प्रकार जान सकते हैं? यह प्रश्न जीवन और मृत्यु के अंतिम रहस्य से जुड़ा है। अर्जुन यह जानना चाहता है कि अंतिम समय में ईश्वर का स्मरण कैसे संभव है और उस अवस्था में उन्हें जानने का मार्ग क्या है। यह शंका हर साधक के लिए महत्वपूर्ण है, क्योंकि मृत्यु के क्षण में ही जीवन का अंतिम फल निर्धारित होता है। इस प्रकार यह श्लोक अध्याय की भूमिका को गहराई से स्थापित करता है।",
        englishMeaning = "Arjuna said: O Madhusudana, who is Adhiyajna in this body, and how are You known at the time of death by those of steady mind?"
    ),
    Shloka(
        number = 3,
        sanskrit = "श्रीभगवानुवाच ।\nअक्षरं ब्रह्म परमं स्वभावोऽध्यात्ममुच्यते ।\nभूतभावोद्भवकरो विसर्गः कर्मसञ्ज्ञितः ॥",
        hindiMeaning = "भगवान उत्तर देते हैं – ब्रह्म को अक्षर, परम और अविनाशी कहा गया है। जीव का स्वभाव अध्यात्म कहलाता है। प्राणियों की उत्पत्ति और सृष्टि का कारण बनने वाला त्याग कर्म कहलाता है। यहाँ भगवान ने अर्जुन के प्रश्न का क्रमशः उत्तर दिया है। ब्रह्म वह अविनाशी सत्ता है, जो शाश्वत है। अध्यात्म का अर्थ आत्मा का स्वरूप और उसकी प्रकृति है। कर्म का आशय उन सभी क्रियाओं से है, जिनसे सृष्टि का निर्माण और प्रवाह चलता है। इस प्रकार यह श्लोक ब्रह्म, अध्यात्म और कर्म के स्पष्ट अर्थ बताता है।",
        englishMeaning = "The Blessed Lord said: The imperishable, supreme Brahman is called the highest reality. The self’s nature is called adhyatma, and the offering that causes beings to arise is called karma."
    ),
    Shloka(
        number = 4,
        sanskrit = "अधिभूतं क्षरो भाव: पुरुषश्चाधिदैवतम् ।\nअधियज्ञोऽहमेवात्र देहे देहभृतां वर ॥",
        hindiMeaning = "भगवान कहते हैं – जो नश्वर है, वही अधिभूत कहलाता है। पुरुष को अधिदैव कहा जाता है। और हे देहधारियों में श्रेष्ठ अर्जुन! मैं ही इस शरीर में अधियज्ञ हूँ। इसका अर्थ यह है कि समस्त जीवों का भौतिक अस्तित्व अधिभूत है, देवताओं का संचालक तत्व अधिदैव है, और स्वयं भगवान अधियज्ञ रूप में सबके भीतर स्थित हैं। यह श्लोक अर्जुन को यह समझाने के लिए है कि सृष्टि के प्रत्येक स्तर पर भगवान का ही संचालन है।",
        englishMeaning = "The perishable existence is Adhibhuta, the cosmic being is Adhidaiva, and I Myself, O Arjuna, am Adhiyajna here in the body."
    ),
    Shloka(
        number = 5,
        sanskrit = "अन्तकाले च मामेव स्मरन्मुक्त्वा कलेवरम् ।\nयः प्रयाति स मद्भावं याति नास्त्यत्र संशयः ॥",
        hindiMeaning = "भगवान कहते हैं – जो मनुष्य मृत्यु के समय केवल मेरा स्मरण करता हुआ शरीर त्यागता है, वह मेरे स्वरूप को प्राप्त होता है। इसमें कोई संदेह नहीं है। इसका तात्पर्य यह है कि अंतिम समय में मन की स्थिति जीवन के अंतिम फल को निर्धारित करती है। यदि मनुष्य मृत्यु के क्षण में ईश्वर का स्मरण करता है, तो उसे भगवान की शरण और मुक्ति मिलती है। यह श्लोक साधक को सिखाता है कि जीवनभर अभ्यास और भक्ति का उद्देश्य मृत्यु के क्षण में भी भगवान को याद कर पाना है।",
        englishMeaning = "Whoever remembers Me alone at the time of death and leaves the body, he attains My nature. There is no doubt about this."
    ),
    Shloka(
        number = 6,
        sanskrit = "यं यं वापि स्मरन्भावं त्यजत्यन्ते कलेवरम् ।\nतं तमेवैति कौन्तेय सदा तद्भावभावितः ॥",
        hindiMeaning = "भगवान कहते हैं – हे कुन्तीपुत्र! मनुष्य जिस-जिस भाव का स्मरण करते हुए शरीर त्यागता है, वह उसी को प्राप्त होता है। क्योंकि मनुष्य का मन सदा जिस भाव में रहता है, वही मृत्यु के समय प्रकट होता है। इसका अर्थ यह है कि जीवनभर की साधना और प्रवृत्तियाँ अंत समय में परिणामस्वरूप सामने आती हैं। इसलिए साधक को हर समय ईश्वर-स्मरण में लगे रहना चाहिए। यह श्लोक गहरी शिक्षा देता है कि मृत्यु के क्षण का स्मरण वही होगा जो साधक ने जीवनभर अभ्यास किया है।",
        englishMeaning = "Whatever state of being one remembers at the end of life, O son of Kunti, to that state alone he goes, being always absorbed in that state."
    ),
    Shloka(
        number = 7,
        sanskrit = "तस्मात्सर्वेषु कालेषु मामनुस्मर युध्य च ।\nमय्यर्पितमनोबुद्धिर्मामेवैष्यस्यसंशयम् ॥",
        hindiMeaning = "भगवान कहते हैं – इसलिए हे अर्जुन! तू हर समय मेरा स्मरण कर और युद्ध भी कर। मन और बुद्धि को मुझमें अर्पित कर, तू निःसंदेह मुझे ही प्राप्त करेगा। यहाँ भगवान स्पष्ट कर रहे हैं कि साधक को केवल संन्यास लेकर जीवन से भागना नहीं चाहिए, बल्कि अपने कर्तव्यों का पालन करते हुए भी ईश्वर-स्मरण में रहना चाहिए। यह कर्म और भक्ति का सुंदर संगम है। जो व्यक्ति अपने मन और बुद्धि को ईश्वर में लगाता है, वह निश्चित रूप से परम लक्ष्य तक पहुँचता है।",
        englishMeaning = "Therefore, remember Me at all times and fight. With mind and intellect dedicated to Me, you will surely come to Me."
    ),
    Shloka(
        number = 8,
        sanskrit = "अभ्यासयोगयुक्तेन चेतसा नान्यगामिना ।\nपरमं पुरुषं दिव्यं याति पार्थानुचिन्तयन् ॥",
        hindiMeaning = "भगवान कहते हैं – जो साधक अभ्यासयोग से युक्त मन से, और किसी अन्य की ओर न जाकर केवल मुझे ही निरंतर चिंतन करता है, वह उस परम दिव्य पुरुष को प्राप्त होता है। अभ्यासयोग का अर्थ है बार-बार मन को ईश्वर की ओर लगाना। इस सतत अभ्यास से मनुष्य की चेतना परमात्मा में स्थिर हो जाती है। तब मृत्यु के समय भी उसका स्मरण केवल भगवान में होता है। यह श्लोक साधक को निरंतर अभ्यास और ध्यान का महत्व सिखाता है।",
        englishMeaning = "With mind disciplined by the practice of yoga, thinking of Me and not going to anything else, one attains the Supreme Divine Person."
    ),
    Shloka(
        number = 9,
        sanskrit = "कविं पुराणमनुशासितार- मणोरणीयांसमनुस्मरेद्यः ।\nसर्वस्य धातारमचिन्त्यरूप- मादित्यवर्णं तमसः परस्तात् ॥",
        hindiMeaning = "भगवान बताते हैं – जो साधक उस कवि, पुराण, सबका नियंता, अणु से भी सूक्ष्म, सबका धारणकर्ता, अचिंत्य स्वरूप वाले, सूर्य के समान प्रकाशमान और अंधकार से परे परम पुरुष का स्मरण करता है, वह उसे प्राप्त होता है। इस श्लोक में परमात्मा का व्यापक स्वरूप वर्णित है। भगवान का अस्तित्व कालातीत, सर्वव्यापक और प्रकाशमान है। उन्हें सोच पाना भी कठिन है, क्योंकि वे असीम और अचिंत्य हैं। साधक जब इस स्वरूप का चिंतन करता है, तब उसका मन संसार से ऊपर उठ जाता है।",
        englishMeaning = "He who remembers the ancient seer, the ruler, subtler than the subtle, the sustainer of all, inconceivable in form, radiant like the sun, beyond darkness—he attains Him."
    ),
    Shloka(
        number = 10,
        sanskrit = "प्रयाणकाले मनसाचलेन भक्त्या युक्तो योगबलेन चैव ।\nभ्रुवोर्मध्ये प्राणमावेश्य सम्यक् स तं परं पुरुषमुपैति दिव्यम् ॥",
        hindiMeaning = "भगवान कहते हैं – जो साधक मृत्यु के समय अचल मन से, भक्ति और योगबल से युक्त होकर, भ्रूमध्य में प्राण को स्थिर करता है, वह परम दिव्य पुरुष को प्राप्त करता है। इसका अर्थ यह है कि अंतिम समय में मन और प्राण का संयम ही साधक को ईश्वर की ओर ले जाता है। योग और भक्ति के अभ्यास से यह संभव होता है। इसलिए साधक को जीवनभर इस अभ्यास में लगना चाहिए ताकि अंतिम समय में उसका मन भगवान में ही स्थिर हो सके।",
        englishMeaning = "At the time of death, with unwavering mind, full of devotion, by the power of yoga, fixing the life force between the eyebrows, he attains the Supreme Divine Person."
    ),
    Shloka(
        number = 11,
        sanskrit = "यदक्षरं वेदविदो वदन्ति विशन्ति यद्यतयो वीतरागाः ।\nयदिच्छन्तो ब्रह्मचर्यं चरन्ति तत्ते पदं संग्रहेण प्रवक्ष्ये ॥",
        hindiMeaning = "भगवान कहते हैं – जिसे वेद के ज्ञानी अक्षर कहते हैं, जिसमें विरक्त साधु प्रवेश करते हैं, और जिसे पाने की इच्छा से लोग ब्रह्मचर्य का पालन करते हैं, उसी पद को मैं संक्षेप में तुम्हें बताऊँगा। इसका अर्थ यह है कि सभी साधनाओं और तप का अंतिम लक्ष्य वही परम पद है। विरक्ति और संयम का जीवन उसी सत्य को पाने के लिए है। यह श्लोक साधक को यह समझाता है कि सारे धर्म, तप और योग का मूल उद्देश्य परम अक्षर ब्रह्म को पाना है।",
        englishMeaning = "That imperishable state which the knowers of the Vedas speak of, into which the ascetics enter, and desiring which they practice celibacy, I shall briefly explain that to you."
    ),
    Shloka(
        number = 12,
        sanskrit = "सर्वद्वाराणि संयम्य मनो हृदि निरुध्य च ।\nमूर्ध्न्याधायात्मनः प्राणमास्थितो योगधारणाम् ॥",
        hindiMeaning = "भगवान कहते हैं – साधक जब सभी इन्द्रियों को संयमित कर, मन को हृदय में स्थिर कर, प्राण को मस्तक में रखकर योग धारणा में स्थित होता है, तब वह परम पद को प्राप्त करने के लिए तैयार होता है। यह ध्यान और योग की गहन अवस्था है। इसमें साधक अपने शरीर और इन्द्रियों को नियंत्रित कर आत्मा को परमात्मा में एकाग्र करता है। यह श्लोक साधक को ध्यान की अंतिम प्रक्रिया का वर्णन करता है।",
        englishMeaning = "Controlling all the gates of the body, confining the mind in the heart, fixing the life-breath in the head, established in yoga concentration—"
    ),
    Shloka(
        number = 13,
        sanskrit = "ॐ इत्येकाक्षरं ब्रह्म व्याहरन्मामनुस्मरन् ।\nयः प्रयाति त्यजन्देहं स याति परमां गतिम् ॥",
        hindiMeaning = "भगवान कहते हैं – जो साधक मृत्यु के समय ‘ॐ’ नामक एकाक्षर ब्रह्म का उच्चारण करते हुए मुझे स्मरण करता है, वह परम गति को प्राप्त करता है। इसका अर्थ है कि ‘ॐ’ स्वयं ईश्वर का प्रतीक है। मृत्यु के समय यदि साधक का स्मरण ईश्वर में हो और उसका उच्चारण ‘ॐ’ से हो, तो वह मोक्ष को प्राप्त करता है। यह श्लोक मृत्यु के समय ईश्वर-स्मरण की शक्ति को स्पष्ट करता है।",
        englishMeaning = "Uttering the single syllable Om, which is Brahman, and remembering Me, he who departs leaving the body attains the supreme goal."
    ),
    Shloka(
        number = 14,
        sanskrit = "अनन्यचेताः सततं यो मां स्मरति नित्यशः ।\nतस्याहं सुलभः पार्थ नित्ययुक्तस्य योगिनः ॥",
        hindiMeaning = "भगवान कहते हैं – हे पार्थ! जो साधक अनन्यचित्त होकर निरंतर मेरा स्मरण करता है, मैं उसके लिए सुलभ हो जाता हूँ। ऐसा योगी सदा मुझमें स्थित रहता है। इसका अर्थ है कि जो व्यक्ति निष्ठा और एकनिष्ठ भाव से भगवान का स्मरण करता है, उसके लिए ईश्वर तक पहुँचना कठिन नहीं है। यह श्लोक साधक को यह शिक्षा देता है कि भक्ति और स्मरण में निरंतरता ही ईश्वर को प्राप्त करने का सरल मार्ग है।",
        englishMeaning = "For one who remembers Me constantly and with undivided mind, O Arjuna, I am easily attainable by such a steadfast yogi."
    ),
    Shloka(
        number = 15,
        sanskrit = "मामुपेत्य पुनर्जन्म दुःखालयमशाश्वतम् ।\nनाप्नुवन्ति महात्मानः संसिद्धिं परमां गताः ॥",
        hindiMeaning = "भगवान कहते हैं – जो महात्मा मुझे प्राप्त कर लेते हैं, वे इस दुःखमय और अस्थायी संसार में पुनर्जन्म नहीं लेते। वे परम सिद्धि को प्राप्त होकर शाश्वत मुक्ति का आनंद लेते हैं। इसका तात्पर्य यह है कि ईश्वर को प्राप्त करना ही जन्म और मृत्यु के चक्र से मुक्ति का मार्ग है। यह श्लोक साधक को यह प्रेरणा देता है कि जीवन का अंतिम उद्देश्य भगवान की प्राप्ति और मोक्ष है।",
        englishMeaning = "Having attained Me, the great souls do not take birth again in this transient, sorrowful world, for they have reached the highest perfection."
    ),
    Shloka(
        number = 16,
        sanskrit = "आब्रह्मभुवनाल्लोकाः पुनरावर्तिनोऽर्जुन ।\nमामुपेत्य तु कौन्तेय पुनर्जन्म न विद्यते ॥",
        hindiMeaning = "भगवान कहते हैं – हे अर्जुन! ब्रह्मलोक तक के सभी लोक पुनर्जन्म के अधीन हैं। परंतु जो मुझे प्राप्त हो जाता है, उसके लिए पुनर्जन्म नहीं होता। इसका अर्थ यह है कि चाहे देवताओं का लोक हो या ब्रह्मलोक, वे भी नश्वर और अस्थायी हैं। केवल भगवान को प्राप्त करना ही शाश्वत मुक्ति का मार्ग है। इस श्लोक के माध्यम से भगवान साधक को यह चेतावनी देते हैं कि स्वर्गादि लोक स्थायी नहीं हैं। मुक्ति केवल ईश्वर की शरण और भक्ति से ही संभव है।",
        englishMeaning = "From the highest world of Brahma downwards, all are subject to return, O Arjuna. But one who attains Me never takes birth again."
    ),
    Shloka(
        number = 17,
        sanskrit = "सहस्रयुगपर्यन्तमहर्यद्ब्रह्मणो विदुः ।\nरात्रिं युगसहस्रान्तां तेऽहोरात्रविदो जनाः ॥",
        hindiMeaning = "भगवान कहते हैं – जो लोग दिन और रात का वास्तविक ज्ञान रखते हैं, वे जानते हैं कि ब्रह्मा का एक दिन हजार युगों के बराबर होता है और उनकी रात भी हजार युगों की होती है। यह श्लोक सृष्टि के विशाल कालचक्र का वर्णन करता है। भगवान समझा रहे हैं कि ब्रह्मा का एक दिन ही मानवीय दृष्टि से असीम है। यह दर्शाता है कि भौतिक सृष्टि कितनी विशाल और दीर्घ है। फिर भी यह सब नश्वर है। साधक को इस विराटता से प्रभावित होकर भटकना नहीं चाहिए, बल्कि परम शाश्वत ईश्वर की ओर ध्यान देना चाहिए।",
        englishMeaning = "Those who know the cosmic day and night understand that a day of Brahma lasts a thousand ages, and his night also a thousand ages."
    ),
    Shloka(
        number = 18,
        sanskrit = "अव्यक्ताद्व्यक्तयः सर्वाः प्रभवन्त्यहरागमे ।\nरात्र्यागमे प्रलीयन्ते तत्रैवाव्यक्तसञ्ज्ञके ॥",
        hindiMeaning = "भगवान कहते हैं – जब ब्रह्मा का दिन होता है, तो सभी प्राणी अव्यक्त से प्रकट होकर अस्तित्व में आते हैं। और जब उनकी रात होती है, तो सब पुनः उसी अव्यक्त में लीन हो जाते हैं। इसका तात्पर्य यह है कि सृष्टि का चक्र निरंतर चलता रहता है। उत्पत्ति और प्रलय का यह क्रम केवल समय की विशालता के अनुसार बदलता है। परंतु यह सब नश्वर और परिवर्तनशील है। यह श्लोक साधक को सिखाता है कि केवल परमात्मा ही शाश्वत है, शेष सब समय के अधीन है।",
        englishMeaning = "At the arrival of Brahma’s day, all beings come forth from the unmanifest, and at the arrival of his night, they merge into that same unmanifest."
    ),
    Shloka(
        number = 19,
        sanskrit = "भूतग्रामः स एवायं भूत्वा भूत्वा प्रलीयते ।\nरात्र्यागमेऽवशः पार्थ प्रभवत्यहरागमे ॥",
        hindiMeaning = "भगवान कहते हैं – हे पार्थ! यह संपूर्ण भूतसमूह बार-बार उत्पन्न होता है और रात के आगमन पर नष्ट हो जाता है। दिन के आगमन पर फिर से प्रकट हो जाता है। इसका अर्थ है कि सृष्टि की यह पुनरावृत्ति अपरिहार्य है। जीव बार-बार जन्म लेता है और नष्ट होता है। परंतु साधक यदि ईश्वर को प्राप्त कर ले, तो वह इस चक्र से मुक्त हो जाता है। यह श्लोक संसार की अस्थिरता और पुनर्जन्म के बंधन को स्पष्ट करता है।",
        englishMeaning = "This multitude of beings, being born again and again, merges helplessly at the coming of the night and emerges again at the coming of the day."
    ),
    Shloka(
        number = 20,
        sanskrit = "परस्तस्मात्तु भावोऽन्योऽव्यक्तोऽव्यक्तात्सनातनः ।\nयः स सर्वेषु भूतेषु नश्यत्सु न विनश्यति ॥",
        hindiMeaning = "भगवान कहते हैं – उस अव्यक्त से भी परे एक और अव्यक्त शाश्वत स्वरूप है। वही सच्चा सनातन अस्तित्व है। वह सभी प्राणियों के नष्ट होने पर भी नष्ट नहीं होता। यह श्लोक आत्मा और परमात्मा के शाश्वत स्वरूप को प्रकट करता है। संसार का अव्यक्त भी नश्वर है, परंतु ईश्वर और आत्मा नाशवान नहीं हैं। साधक को यह समझना चाहिए कि वास्तविक आश्रय केवल परम सनातन अव्यक्त ही है।",
        englishMeaning = "But beyond that unmanifest, there is yet another, eternal unmanifest being, which does not perish when all beings perish."
    ),
    Shloka(
        number = 21,
        sanskrit = "अव्यक्तोऽक्षर इत्युक्तस्तमाहुः परमां गतिम् ।\nयं प्राप्य न निवर्तन्ते तद्धाम परमं मम ॥",
        hindiMeaning = "भगवान कहते हैं – उस अव्यक्त को अक्षर कहा गया है और वही परम गति कहलाती है। उसे प्राप्त करके जीव पुनः संसार में नहीं लौटता। वही मेरा परम धाम है। यह श्लोक स्पष्ट करता है कि परम लक्ष्य ईश्वर का धाम है, जो अक्षर और शाश्वत है। साधक जो उस धाम को पाता है, वह जन्म और मृत्यु के चक्र से मुक्त हो जाता है।",
        englishMeaning = "That unmanifest is called the imperishable, and it is said to be the supreme goal. Reaching it, one does not return; that is My supreme abode."
    ),
    Shloka(
        number = 22,
        sanskrit = "पुरुषः स परः पार्थ भक्त्या लभ्यस्त्वनन्यया ।\nयस्यान्तःस्थानि भूतानि येन सर्वमिदं ततम् ॥",
        hindiMeaning = "भगवान कहते हैं – हे पार्थ! वह परम पुरुष केवल अनन्य भक्ति से ही प्राप्त होता है। वही सब प्राणियों के भीतर स्थित है और उसी से यह समस्त जगत व्याप्त है। यह श्लोक साधक को बताता है कि परमात्मा तक पहुँचने का मार्ग केवल भक्ति है। अन्य साधन सीमित हैं, परंतु अनन्य भक्ति सीधे ईश्वर तक पहुँचाती है। यह भक्ति ही जीव और परमात्मा को जोड़ने वाला सबसे सरल और प्रभावी साधन है।",
        englishMeaning = "That Supreme Person, O Arjuna, is attained by undivided devotion. In Him all beings dwell, and by Him all this is pervaded."
    ),
    Shloka(
        number = 23,
        sanskrit = "यत्र काले त्वनावृत्तिमावृत्तिं चैव योगिनः ।\nप्रयाता यान्ति तं कालं वक्ष्यामि भरतर्षभ ॥",
        hindiMeaning = "भगवान कहते हैं – हे भरतश्रेष्ठ! अब मैं तुम्हें वह समय बताऊँगा, जिसमें योगी मृत्यु को प्राप्त होकर पुनः नहीं लौटते, और वह समय भी बताऊँगा, जिसमें मृत्यु को प्राप्त होने पर वे लौट आते हैं। यह श्लोक काल और मृत्यु के रहस्य को समझाने वाला है। जीवन-मरण के मार्ग समय और योग के आधार पर भिन्न होते हैं। यह ज्ञान साधक के लिए महत्वपूर्ण है ताकि वह सही मार्ग चुन सके।",
        englishMeaning = "O best of the Bharatas, I shall tell you of the times when departing yogis do not return, and also the times when they return."
    ),
    Shloka(
        number = 24,
        sanskrit = "अग्निर्ज्योतिरहः शुक्लः षण्मासा उत्तरायणम् ।\nतत्र प्रयाता गच्छन्ति ब्रह्म ब्रह्मविदो जनाः ॥",
        hindiMeaning = "भगवान कहते हैं – जब योगी अग्नि, ज्योति, दिन, शुक्ल पक्ष और उत्तरायण के छह मास के समय में शरीर त्यागते हैं, तब वे ब्रह्म को प्राप्त होते हैं। यह मार्ग प्रकाश और दिव्यता का प्रतीक है। इस समय मृत्यु पाने वाले साधक पुनर्जन्म में नहीं आते। यह श्लोक साधक को मृत्यु के समय और उसके प्रभाव का ज्ञान देता है।",
        englishMeaning = "Fire, light, day, the bright fortnight, the six months of the northern path—those who die at that time, knowing Brahman, go to Brahman."
    ),
    Shloka(
        number = 25,
        sanskrit = "धूमो रात्रिस्तथा कृष्णः षण्मासा दक्षिणायनम् ।\nतत्र चान्द्रमसं ज्योतिर्योगी प्राप्य निवर्तते ॥",
        hindiMeaning = "भगवान कहते हैं – धूम, रात्रि, कृष्ण पक्ष और दक्षिणायण के छह मास का मार्ग वह है, जिसमें मृत्यु पाने वाले योगी चन्द्रमा के लोक को प्राप्त होते हैं और फिर लौट आते हैं। इसका अर्थ है कि यह मार्ग अस्थायी सुख और स्वर्ग की प्राप्ति का मार्ग है। लेकिन इसमें मोक्ष नहीं है, इसलिए पुनर्जन्म अवश्य होता है। यह श्लोक साधक को स्थायी और अस्थायी मार्ग का अंतर बताता है।",
        englishMeaning = "Smoke, night, the dark fortnight, the six months of the southern path—by these, the yogi reaches the lunar light and returns."
    ),
    Shloka(
        number = 26,
        sanskrit = "शुक्लकृष्णे गती ह्येते जगतः शाश्वते मते ।\nएकया यात्यनावृत्तिमन्ययावर्तते पुनः ॥",
        hindiMeaning = "भगवान कहते हैं – ये दो मार्ग, शुक्ल और कृष्ण, जगत में शाश्वत माने गए हैं। इनमें से एक मार्ग से साधक पुनः नहीं लौटता और दूसरे मार्ग से वापस आ जाता है। यह श्लोक स्पष्ट करता है कि मृत्यु के समय साधक की स्थिति ही उसके अगले जीवन का निर्धारण करती है। शाश्वत मुक्ति और पुनर्जन्म दोनों मार्ग ईश्वर की व्यवस्था से संचालित हैं।",
        englishMeaning = "These two paths, bright and dark, are considered eternal for the world. By one, one does not return; by the other, one returns again."
    ),
    Shloka(
        number = 27,
        sanskrit = "नैते सृती पार्थ जानन्योगी मुह्यति कश्चन ।\nतस्मात्सर्वेषु कालेषु योगयुक्तो भव अर्जुन ॥",
        hindiMeaning = "भगवान कहते हैं – हे पार्थ! जो योगी इन दोनों मार्गों को जान लेता है, वह कभी मोह में नहीं पड़ता। इसलिए हे अर्जुन! तू हर समय योगयुक्त रह। इसका अर्थ है कि मृत्यु के मार्गों का ज्ञान साधक को भ्रम से बचाता है। जब वह यह जान लेता है कि सच्चा मार्ग भक्ति और योग है, तो उसे मोक्ष की प्राप्ति में कोई संदेह नहीं रहता।",
        englishMeaning = "O Arjuna, no yogi who knows these paths is ever deluded. Therefore, always be steadfast in yoga."
    ),
    Shloka(
        number = 28,
        sanskrit = "वेदेषु यज्ञेषु तपःसु चैव दानेषु यत्पुण्यफलं प्रदिष्टम् ।\nअत्येति तत्सर्वमिदं विदित्वा योगी परं स्थानमुपैति चाद्यम् ॥",
        hindiMeaning = "भगवान कहते हैं – वेदों के अध्ययन, यज्ञों, तप और दान से जो पुण्य फल बताया गया है, उसे योगी सब पार कर जाता है। इन सबको जानकर वह परम आद्य स्थान को प्राप्त होता है। इसका अर्थ है कि योगी को वह फल मिलता है, जो सभी साधनों से भी अधिक श्रेष्ठ है। इस श्लोक में योग और भक्ति की महिमा का प्रतिपादन है। साधक को यह समझना चाहिए कि परम धाम तक पहुँचने का सर्वोत्तम मार्ग केवल योग और ईश्वर की भक्ति है।",
        englishMeaning = "Whatever merit is declared in the Vedas, sacrifices, austerities, and charities, the yogi transcends all that and attains the supreme, primal abode."
    )

)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaEightScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 8 – अक्षर ब्रह्म योग",
                        fontSize = 24.sp, // ✅ Bigger title
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
                    .height(50.dp),  // ✅ proper banner height
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
                onClick = { navController.navigate(Screen.QuizEight.route) },
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
            contentPadding = PaddingValues(bottom = 70.dp) // ✅ avoid overlap with ad
        ) {
            // ✅ Top Image
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .height(500.dp), // ✅ match Adhyaya 4 style
                    shape = RoundedCornerShape(20.dp), // ✅ consistent rounded corners
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.gemini_generated_image_vqb6hhvqb6hhvqb6), // ✅ Chapter 8 image
                        contentDescription = "Chapter 8 – Akshara Brahma Yoga",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaEightShlokas) { shloka ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    elevation = CardDefaults.cardElevation(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant // ✅ softer bg
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
