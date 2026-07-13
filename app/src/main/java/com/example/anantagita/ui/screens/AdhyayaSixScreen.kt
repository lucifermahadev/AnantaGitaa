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

val adhyayaSixShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अनाश्रितः कर्मफलं कार्यं कर्म करोति यः।\nस संन्यासी च योगी च न निरग्निर्न चाक्रियः॥",
        hindiMeaning = "भगवान कृष्ण कहते हैं कि जो मनुष्य कर्म के फलों पर आश्रित नहीं होता और केवल अपने कर्तव्य को करने के लिए कर्म करता है, वही सच्चा संन्यासी और योगी है। केवल अग्नि का त्याग करना या क्रियाहीन हो जाना संन्यास नहीं कहलाता। वास्तविक संन्यास तो वह है, जिसमें मनुष्य बिना किसी स्वार्थ के कर्म करता है। फल की आसक्ति त्याग कर जब कर्म किए जाते हैं, तब मनुष्य का जीवन शुद्ध हो जाता है। इस प्रकार का त्याग ही योग और संन्यास दोनों का वास्तविक स्वरूप है। यही सच्चा आध्यात्मिक जीवन है।",
        englishMeaning = "A true renunciate and yogi is one who performs his duties without attachment to the results, not one who merely abandons action or ritual fire."
    ),

    Shloka(
        number = 2,
        sanskrit = "यं संन्यासमिति प्राहुर्योगं तं विद्धि पाण्डव।\nन ह्यसंन्यस्तसंकल्पो योगी भवति कश्चन॥",
        hindiMeaning = "कृष्ण कहते हैं कि जिस त्याग को लोग संन्यास कहते हैं, वही वास्तव में योग है। क्योंकि जब तक मनुष्य अपने संकल्पों और इच्छाओं का त्याग नहीं करता, वह योगी नहीं बन सकता। केवल बाहरी क्रिया या वस्त्र बदल लेना योग नहीं है। योग का सार यह है कि मन इच्छाओं से मुक्त हो और परमात्मा की ओर केंद्रित हो। जब संकल्प और आसक्ति समाप्त हो जाते हैं, तभी योग की सिद्धि संभव होती है। इस प्रकार, त्याग और योग दोनों का आधार एक ही है।",
        englishMeaning = "Renunciation and yoga are the same, for no one becomes a yogi without giving up selfish desires and attachments in the mind."
    ),

    Shloka(
        number = 3,
        sanskrit = "आरुरुक्षोर्मुनेर्योगं कर्म कारणमुच्यते।\nयोगारूढस्य तस्यैव शमः कारणमुच्यते॥",
        hindiMeaning = "भगवान समझाते हैं कि जो साधक योग की शुरुआत करना चाहता है, उसके लिए कर्म का पालन करना आवश्यक है। कर्म ही उसकी उन्नति का साधन बनता है। लेकिन जब वह योग में दृढ़ता से स्थापित हो जाता है, तब उसके लिए शांति और त्याग ही साधन बन जाते हैं। प्रारंभ में कर्म के द्वारा चित्त शुद्धि होती है और आगे चलकर शांति और ध्यान से आत्मसाक्षात्कार होता है। इसलिए साधना की शुरुआत और परिपूर्णता के साधन भिन्न होते हैं।",
        englishMeaning = "For a beginner in yoga, action (karma) is the means, but for one established in yoga, peace and renunciation become the way."
    ),

    Shloka(
        number = 4,
        sanskrit = "यदा हि नेन्द्रियार्थेषु न कर्मस्वनुषज्जते।\nसर्वसंकल्पसंन्यासी योगारूढस्तदोच्यते॥",
        hindiMeaning = "जब साधक इंद्रियों के विषयों और कर्मों में आसक्त नहीं रहता तथा सभी संकल्पों का त्याग कर देता है, तब उसे योगारूढ़ कहा जाता है। यह स्थिति तब आती है जब मनुष्य का मन बाहर की वस्तुओं से हटकर भीतर की ओर जाता है। संसारिक इच्छाओं और लालसाओं का त्याग करके ही योग में पूर्ण स्थिति प्राप्त होती है। यह अवस्था आत्मिक उन्नति की चरम सीमा है।",
        englishMeaning = "When one is detached from sense pleasures and actions, and has renounced all desires, he is said to be firmly established in yoga."
    ),

    Shloka(
        number = 5,
        sanskrit = "उद्धरेदात्मनात्मानं नात्मानमवसादयेत्।\nआत्मैव ह्यात्मनो बन्धुरात्मैव रिपुरात्मनः॥",
        hindiMeaning = "भगवान अर्जुन को समझाते हैं कि मनुष्य को अपने द्वारा ही स्वयं को ऊपर उठाना चाहिए और कभी अपने को नीचे नहीं गिराना चाहिए। क्योंकि आत्मा ही उसका मित्र भी है और शत्रु भी। जब मन संयमित होता है तो आत्मा मित्र बनती है, और जब मन असंयमित होता है तो आत्मा शत्रु बन जाती है। इसीलिए साधक को आत्मसंयम से ही अपनी उन्नति करनी चाहिए। यही आत्मोन्नति का मार्ग है।",
        englishMeaning = "One should uplift oneself by one’s own self and not degrade it, for the self alone is both friend and enemy of the self."
    ),

    Shloka(
        number = 6,
        sanskrit = "बन्धुरात्मात्मनस्तस्य येनात्मैवात्मना जितः।\nअनात्मनस्तु शत्रुत्वे वर्तेतात्मैव शत्रुवत्॥",
        hindiMeaning = "जिस व्यक्ति ने अपने मन और आत्मा को वश में कर लिया है, उसके लिए आत्मा मित्र समान हो जाती है। लेकिन जो मनुष्य अपने ही मन को वश में नहीं कर पाता, उसके लिए वही आत्मा शत्रु समान हो जाती है। इसीलिए आत्मसंयम और मन की साधना ही वास्तविक साधना है। मन का मित्र बनना जीवन की सबसे बड़ी उपलब्धि है।",
        englishMeaning = "For one who has conquered the mind, the self is the best friend; but for one who has failed to control it, the same self acts like an enemy."
    ),

    Shloka(
        number = 7,
        sanskrit = "जितात्मनः प्रशान्तस्य परमात्मा समाहितः।\nशीतोष्णसुखदुःखेषु तथा मानापमानयोः॥",
        hindiMeaning = "भगवान कहते हैं कि जिसने अपने मन को जीत लिया है और जो शांति में स्थित है, उसके लिए परमात्मा सहज ही प्राप्त होता है। ऐसा व्यक्ति शीत और ऊष्णता, सुख और दुःख, मान और अपमान में समान रहता है। बाहरी परिस्थितियाँ उसके संतुलन को नहीं बिगाड़ सकतीं। उसका मन स्थिर रहता है और वह परमात्मा के सान्निध्य का अनुभव करता है।",
        englishMeaning = "The self-realized person who has conquered the mind remains peaceful and is steady amidst heat and cold, pleasure and pain, honor and dishonor."
    ),

    Shloka(
        number = 8,
        sanskrit = "ज्ञानविज्ञानतृप्तात्मा कूटस्थो विजितेन्द्रियः।\nयुक्त इत्युच्यते योगी समलोष्टाश्मकाञ्चनः॥",
        hindiMeaning = "जिस साधक का आत्मा ज्ञान और विज्ञान से संतुष्ट हो गया है, जो स्थिरचित्त और इंद्रियों को वश में कर चुका है, वही वास्तविक योगी कहलाता है। वह मिट्टी, पत्थर और सोने में समान दृष्टि रखता है। उसके लिए मूल्यवान और तुच्छ वस्तुओं में कोई अंतर नहीं होता। यही समदृष्टि योग की परिपूर्ण अवस्था है।",
        englishMeaning = "The yogi satisfied with knowledge and wisdom, self-controlled and steady, regards a lump of earth, stone, or gold as the same."
    ),

    Shloka(
        number = 9,
        sanskrit = "सुहृन्मित्रार्युदासीनमध्यस्थद्वेष्यबन्धुषु।\nसाधुष्वपि च पापेषु समबुद्धिर्विशिष्यते॥",
        hindiMeaning = "भगवान बताते हैं कि श्रेष्ठ योगी वह है जो सबमें समान दृष्टि रखता है। चाहे वह मित्र हो या शत्रु, निकट संबंधी हो या दूर का व्यक्ति, धर्मात्मा हो या पापी – योगी सबको समान भाव से देखता है। वह किसी से आसक्ति या द्वेष नहीं करता। उसका मन सबके प्रति करुणा और समभाव से भरा होता है। यही योग की श्रेष्ठता है।",
        englishMeaning = "The best yogi is one who looks equally upon friends, enemies, relatives, neutrals, the virtuous, and even the sinful."
    ),

    Shloka(
        number = 10,
        sanskrit = "योगी युञ्जीत सततमात्मानं रहसि स्थितः।\nएकाकी यतचित्तात्मा निराशीरपरिग्रहः॥",
        hindiMeaning = "कृष्ण कहते हैं कि योगी को सदैव एकांत में रहकर अपने मन को संयमित करते हुए ध्यान करना चाहिए। उसे अकेले, निराश्रित और बिना किसी संग्रह की प्रवृत्ति के रहना चाहिए। जब योगी अपने भीतर ही संतुष्ट होता है, तब उसका मन परमात्मा की ओर स्थिर हो जाता है। यही ध्यान योग का प्रारंभिक अभ्यास है।",
        englishMeaning = "The yogi should constantly engage in meditation, remaining alone in seclusion, self-controlled, free from desires and possessions."
    ),

    Shloka(
        number = 11,
        sanskrit = "शुचौ देशे प्रतिष्ठाप्य स्थिरमासनमात्मनः।\nनात्युच्छ्रितं नातिनीचं चैलाजिनकुशोत्तरम्॥",
        hindiMeaning = "भगवान ध्यान की विधि बताते हैं – योगी को एक स्वच्छ स्थान पर आसन स्थापित करना चाहिए। आसन न बहुत ऊँचा होना चाहिए और न ही बहुत नीचा। उसे कुशा घास, मृगचर्म और कपड़े पर बिछाकर स्थिर बनाया जाता है। यह व्यवस्था ध्यान में स्थिरता और एकाग्रता लाने में सहायक होती है। उचित आसन के बिना मन का ध्यान स्थिर नहीं हो सकता।",
        englishMeaning = "The yogi should prepare a clean seat in a sacred place, neither too high nor too low, using kusa grass, deer skin, and cloth one over the other."
    ),

    Shloka(
        number = 12,
        sanskrit = "तत्रैकाग्रं मनः कृत्वा यतचित्तेन्द्रियक्रियः।\nउपविश्यासने युञ्ज्याद्योगमात्मविशुद्धये॥",
        hindiMeaning = "उस आसन पर बैठकर योगी को अपने मन को एकाग्र करना चाहिए और इंद्रियों तथा चित्त को वश में करना चाहिए। इस प्रकार ध्यान का अभ्यास आत्मा की शुद्धि के लिए किया जाता है। जब मन एकाग्र होता है और इंद्रियाँ संयमित होती हैं, तब आत्मज्ञान की प्राप्ति होती है। ध्यान ही आत्मिक उन्नति का सबसे बड़ा साधन है।",
        englishMeaning = "Sitting on that seat, controlling mind and senses, the yogi should focus the mind in meditation for the purification of the soul."
    ),

    Shloka(
        number = 13,
        sanskrit = "समं कायशिरोग्रीवं धारयन्नचलं स्थिरः।\nसंप्रेक्ष्य नासिकाग्रं स्वं दिशश्चानवलोकयन्॥",
        hindiMeaning = "योगी को अपने शरीर, सिर और गले को सीधा और स्थिर रखना चाहिए। दृष्टि को नासिका के अग्र भाग पर केंद्रित करना चाहिए और चारों दिशाओं में न देखना चाहिए। यह आसन और दृष्टि की स्थिरता ध्यान की गहराई बढ़ाती है। इससे मन भटकता नहीं और भीतर की ओर एकाग्र होता है। यही स्थिति आत्मिक उन्नति के लिए सहायक है।",
        englishMeaning = "Keeping the body, head, and neck upright and steady, the yogi should fix the gaze on the tip of the nose without looking around."
    ),

    Shloka(
        number = 14,
        sanskrit = "प्रशान्तात्मा विगतभीर्ब्रह्मचारिव्रते स्थितः।\nमनः संयम्य मच्चित्तो युक्त आसीत मत्परः॥",
        hindiMeaning = "योगी को शांतचित्त, निर्भय और ब्रह्मचर्य का पालन करने वाला होना चाहिए। उसे मन को संयमित कर मेरे प्रति अर्पित करना चाहिए। ऐसा योगी ध्यान में बैठकर पूरी तरह मुझ पर केंद्रित हो जाता है। यह समर्पण और शांति ही ध्यान योग की आत्मा है।",
        englishMeaning = "The yogi should be tranquil, fearless, practicing celibacy, with a controlled mind, meditating on Me with full devotion."
    ),

    Shloka(
        number = 15,
        sanskrit = "युञ्जन्नेवं सदात्मानं योगी नियतमानसः।\nशान्तिं निर्वाणपरमां मत्संस्थामधिगच्छति॥",
        hindiMeaning = "कृष्ण कहते हैं कि इस प्रकार निरंतर आत्मा को मुझमें एकाग्र करने वाला और मन को संयमित रखने वाला योगी परम शांति को प्राप्त करता है। यह शांति मोक्ष स्वरूप है और अंततः वही मेरी प्राप्ति है। ऐसा योगी जीवन में और मृत्यु के बाद दोनों स्थितियों में शांति का अनुभव करता है।",
        englishMeaning = "By always disciplining the mind and meditating on Me, the yogi attains supreme peace and liberation, ultimately reaching My abode."
    ),

    Shloka(
        number = 16,
        sanskrit = "नात्यश्नतस्तु योगोऽस्ति न चैकान्तमनश्नतः।\nन चातिस्वप्नशीलस्य जाग्रतो नैव चार्जुन॥",
        hindiMeaning = "भगवान कहते हैं कि जो व्यक्ति अधिक खाता है या बिल्कुल नहीं खाता, वह योग में सफल नहीं हो सकता। इसी प्रकार, जो अधिक सोता है या बिल्कुल नहीं सोता, वह भी योग के मार्ग पर स्थिर नहीं रह सकता। योग का अभ्यास संतुलन में ही संभव है। जीवन के प्रत्येक क्षेत्र में संयम आवश्यक है।",
        englishMeaning = "Yoga is not for one who overeats or fasts excessively, nor for one who oversleeps or stays awake too long. Balance is essential in yoga."
    ),

    Shloka(
        number = 17,
        sanskrit = "युक्ताहारविहारस्य युक्तचेष्टस्य कर्मसु।\nयुक्तस्वप्नावबोधस्य योगो भवति दुःखहा॥",
        hindiMeaning = "जो साधक भोजन और विहार में संयम रखता है, कर्मों में संतुलित है, और नींद-जागरण में उचित संतुलन रखता है, उसके लिए योग दुःखों का नाश करने वाला बन जाता है। योग संतुलन और संयम का ही नाम है। जीवन के प्रत्येक कार्य में संतुलन साधक को आत्मिक शांति की ओर ले जाता है। यही योग का व्यावहारिक स्वरूप है।",
        englishMeaning = "For one who is moderate in eating, recreation, actions, sleep, and wakefulness, yoga becomes the destroyer of sorrow."
    ),

    Shloka(
        number = 18,
        sanskrit = "यदा विनियतं चित्तमात्मन्येवावतिष्ठते।\nनिःस्पृहः सर्वकामेभ्यो युक्त इत्युच्यते तदा॥",
        hindiMeaning = "जब साधक का मन पूरी तरह संयमित होकर आत्मा में स्थित हो जाता है और सभी कामनाओं से रहित हो जाता है, तब वह योगी कहलाता है। यह अवस्था आत्मसाक्षात्कार की होती है। मन की चंचलता और इच्छाओं के शांत हो जाने पर आत्मा का साक्षात्कार होता है। यही योग की सिद्धि है।",
        englishMeaning = "When the disciplined mind is fully established in the self and free from all desires, then one is said to be truly united in yoga."
    ),

    Shloka(
        number = 19,
        sanskrit = "यथा दीपो निवातस्थो नेङ्गते सोपमा स्मृता।\nयोगिनो यतचित्तस्य युञ्जतो योगमात्मनः॥",
        hindiMeaning = "भगवान योग की स्थिति की तुलना दीपक से करते हैं। जैसे वायु रहित स्थान में दीपक की ज्योति नहीं हिलती, वैसे ही योगी का चित्त ध्यान में स्थिर रहता है। यह उपमा ध्यान की गहराई और स्थिरता को स्पष्ट करती है। स्थिर मन ही आत्मसाक्षात्कार का साधन है।",
        englishMeaning = "Just as a lamp in a windless place does not flicker, so is the mind of the yogi absorbed in meditation, steady and unmoving."
    ),

    Shloka(
        number = 20,
        sanskrit = "यत्रोपरमते चित्तं निरुद्धं योगसेवया।\nयत्र चैवात्मनात्मानं पश्यन्नात्मनि तुष्यति॥",
        hindiMeaning = "जब योगाभ्यास द्वारा मन पूरी तरह निरुद्ध हो जाता है और चित्त शांत हो जाता है, तब साधक आत्मा को आत्मा में देखता है। वह स्वयं में ही संतुष्ट हो जाता है। इस अवस्था में आत्मा परम शांति और सुख का अनुभव करती है। यही ध्यान योग की परिपूर्णता है।",
        englishMeaning = "When by yoga practice the mind is stilled, the yogi realizes the self within and finds complete satisfaction in the self alone."
    ),
    Shloka(
        number = 21,
        sanskrit = "सुखमात्यन्तिकं यत्तद्बुद्धिग्राह्यमतीन्द्रियम्।\nवेत्ति यत्र न चैवायं स्थितश्चलति तत्त्वतः॥",
        hindiMeaning = "भगवान श्रीकृष्ण कहते हैं कि योगी उस परम सुख का अनुभव करता है जो इंद्रियों से परे है और जिसे केवल बुद्धि के द्वारा ही ग्रहण किया जा सकता है। यह सुख बाहरी विषयों से नहीं, बल्कि आत्मा के भीतर से उत्पन्न होता है। जब योगी इस स्थिति को प्राप्त कर लेता है, तब वह कभी विचलित नहीं होता। वह समझ जाता है कि यही सच्चा और अटल सुख है। सांसारिक सुख तो अस्थायी और परिवर्तनशील होते हैं, लेकिन यह आत्मिक आनंद शाश्वत है। इस अवस्था में योगी न तो दुख से प्रभावित होता है और न ही सुख में अहंकार करता है। यही आत्मा की वास्तविक स्थिति है।",
        englishMeaning = "The yogi experiences supreme bliss, beyond the senses but grasped by the intellect. Once established in this state, he never departs from the truth."
    ),

    Shloka(
        number = 22,
        sanskrit = "यं लब्ध्वा चापरं लाभं मन्यते नाधिकं ततः।\nयस्मिन्स्थितो न दुःखेन गुरुणापि विचाल्यते॥",
        hindiMeaning = "यहाँ श्रीकृष्ण बताते हैं कि जब योगी उस आत्मिक आनंद को प्राप्त कर लेता है, तब उसे किसी अन्य लाभ की आवश्यकता नहीं रहती। संसार के सारे भौतिक लाभ उस परम लाभ के सामने तुच्छ हो जाते हैं। उस अवस्था में स्थित योगी को कोई भी बड़ा से बड़ा दुख भी विचलित नहीं कर सकता। चाहे विपत्ति कितनी भी गहरी क्यों न हो, योगी स्थिर और संतुलित बना रहता है। उसका मन परम शांति में स्थित हो जाता है। यह स्थिति ही आत्मसाक्षात्कार की परिपूर्ण अवस्था है।",
        englishMeaning = "Having attained that bliss, he considers no other gain greater, and even severe sorrow cannot shake him from it."
    ),

    Shloka(
        number = 23,
        sanskrit = "तं विद्याद्दुःखसंयोगवियोगं योगसंज्ञितम्।\nस निश्चयेन योक्तव्यो योगोऽनिर्विण्णचेतसा॥",
        hindiMeaning = "भगवान कहते हैं कि जिस स्थिति में मनुष्य दुख के सभी संबंधों से मुक्त हो जाता है, वही स्थिति योग कहलाती है। योग का अर्थ केवल आसन या क्रियाएँ नहीं, बल्कि दुख और मोह से पूर्ण मुक्ति है। यह योग निश्चय और दृढ़ता से ही प्राप्त किया जा सकता है। मनुष्य को कभी निराश या ऊबना नहीं चाहिए, बल्कि निरंतर अभ्यास करना चाहिए। योग साधना में धैर्य और निरंतरता अनिवार्य है। जो व्यक्ति दृढ़ निश्चय के साथ अभ्यास करता है, वही योग की पराकाष्ठा तक पहुँचता है।",
        englishMeaning = "Yoga is the severance from union with sorrow. It should be practiced with determination and an unwavering mind."
    ),

    Shloka(
        number = 24,
        sanskrit = "सङ्कल्पप्रभवान्कामांस्त्यक्त्वा सर्वानशेषतः।\nमनसैवेन्द्रियग्रामं विनियम्य समन्ततः॥",
        hindiMeaning = "श्रीकृष्ण कहते हैं कि योगी को सबसे पहले अपने मन में उत्पन्न सभी इच्छाओं का त्याग करना चाहिए, क्योंकि वे संकल्प से उत्पन्न होती हैं। इच्छाएँ ही मनुष्य को भटकाती और बंधन में डालती हैं। योगी को अपने इंद्रियों के समूह को भी मन द्वारा नियंत्रित करना चाहिए। जब इंद्रियाँ मन के वश में हों और मन बुद्धि के अधीन हो, तभी साधक का मार्ग स्पष्ट होता है। इच्छाओं का त्याग और इंद्रियनिग्रह योग की बुनियादी शर्तें हैं। इस प्रकार मन शुद्ध और स्थिर हो जाता है।",
        englishMeaning = "Abandoning all desires born of mental imaginings, the yogi controls the senses with the mind on all sides."
    ),

    Shloka(
        number = 25,
        sanskrit = "शनैः शनैरुपरमेद् बुद्ध्या धृतिगृहीतया।\nआत्मसंस्थं मनः कृत्वा न किञ्चिदपि चिन्तयेत्॥",
        hindiMeaning = "भगवान अर्जुन को बताते हैं कि योग का अभ्यास धीरे-धीरे करना चाहिए। जल्दबाज़ी और अधीरता साधना में बाधा डालते हैं। दृढ़ बुद्धि और धैर्य के साथ साधक को धीरे-धीरे मन को स्थिर करना चाहिए। मन को आत्मा में स्थापित करके अन्य किसी विषय का चिंतन नहीं करना चाहिए। धीरे-धीरे यह अभ्यास साधक को ध्यान की गहराई तक ले जाता है। यह निरंतर अभ्यास ही योगी को आत्मसाक्षात्कार की ओर अग्रसर करता है।",
        englishMeaning = "Step by step, with determination and steady intellect, the yogi should quieten the mind, fixing it in the Self, and think of nothing else."
    ),

    Shloka(
        number = 26,
        sanskrit = "यतो यतो निश्चरति मनश्चञ्चलमस्थिरम्।\nततस्ततो नियम्यैतदात्मन्येव वशं नयेत्॥",
        hindiMeaning = "श्रीकृष्ण कहते हैं कि मन स्वभाव से ही चंचल और अस्थिर है। वह बार-बार विभिन्न विषयों की ओर भागता है। लेकिन साधक को चाहिए कि जब भी मन भटके, उसे फिर से आत्मा में स्थिर करे। बार-बार मन को वापस लाना ही योगाभ्यास का मूल है। इस निरंतर अभ्यास से मन नियंत्रित और शांत हो जाता है। अंततः यह मन आत्मा और परमात्मा में स्थायी रूप से स्थापित हो जाता है।",
        englishMeaning = "Wherever the restless mind wanders, the yogi should bring it back and place it under the control of the Self."
    ),

    Shloka(
        number = 27,
        sanskrit = "प्रशान्तमनसं ह्येनं योगिनं सुखमुत्तमम्।\nउपैति शान्तरजसं ब्रह्मभूतमकल्मषम्॥",
        hindiMeaning = "श्रीकृष्ण बताते हैं कि जब योगी का मन पूर्णतः शांत हो जाता है, तब वह सर्वोच्च सुख को प्राप्त करता है। उसके भीतर की रजोगुण और वासनाएँ शांत हो जाती हैं। वह निष्पाप और निर्मल हो जाता है। ऐसी स्थिति में योगी वास्तव में ब्रह्मस्वरूप हो जाता है। उसका सुख किसी बाहरी वस्तु पर निर्भर नहीं होता। यही आत्मसाक्षात्कार की पूर्णता है।",
        englishMeaning = "The yogi with a peaceful mind, free from desire and sin, attains supreme bliss and becomes united with Brahman."
    ),

    Shloka(
        number = 28,
        sanskrit = "युञ्जन्नेवं सदात्मानं योगी विगतकल्मषः।\nसुखेन ब्रह्मसंस्पर्शमत्यन्तं सुखमश्नुते॥",
        hindiMeaning = "यहाँ भगवान कहते हैं कि जब योगी इस प्रकार आत्मा में निरंतर योग करता है, तब उसके सारे पाप नष्ट हो जाते हैं। वह सहज ही ब्रह्म के साथ एकत्व का अनुभव करता है। इस ब्रह्मानंद की तुलना संसार के किसी भी सुख से नहीं की जा सकती। यह आनंद स्थायी और शाश्वत होता है। सांसारिक सुख अस्थायी होते हैं, लेकिन आत्मिक सुख असीम और अनंत है। यही योग का वास्तविक फल है।",
        englishMeaning = "Thus the yogi, constantly engaging the Self, freed from sin, attains infinite bliss through union with Brahman."
    ),

    Shloka(
        number = 29,
        sanskrit = "सर्वभूतस्थमात्मानं सर्वभूतानि चात्मनि।\nईक्षते योगयुक्तात्मा सर्वत्र समदर्शनः॥",
        hindiMeaning = "श्रीकृष्ण कहते हैं कि योगी सभी प्राणियों में अपने आत्मा को और अपने आत्मा में सभी प्राणियों को देखता है। वह समझ जाता है कि सब एक ही परमात्मा के अंश हैं। ऐसा योगी सबको समान दृष्टि से देखता है। उसके लिए मित्र-शत्रु, सुख-दुख और ऊँच-नीच का भेद मिट जाता है। वह जानता है कि सब जीवों का आधार परमात्मा ही है। यही समदृष्टि योग की पराकाष्ठा है।",
        englishMeaning = "The yogi sees the Self in all beings and all beings in the Self, viewing everything with equal vision."
    ),

    Shloka(
        number = 30,
        sanskrit = "यो मां पश्यति सर्वत्र सर्वं च मयि पश्यति।\nतस्याहं न प्रणश्यामि स च मे न प्रणश्यति॥",
        hindiMeaning = "भगवान कहते हैं कि जो योगी मुझे हर जगह देखता है और हर जगह मुझे ही अनुभव करता है, वह मुझे कभी नहीं खोता और मैं भी उसे कभी नहीं खोता। यह संबंध केवल बाहरी पूजा से नहीं, बल्कि हृदय में परमात्मा का अनुभव करने से होता है। जब योगी यह अनुभव कर लेता है कि सब कुछ वास्तव में भगवान ही है, तब वह सदा ईश्वर के साथ जुड़ा रहता है। यह अटूट संबंध ही भक्ति और योग का सार है।",
        englishMeaning = "One who sees Me everywhere and everything in Me never becomes lost to Me, nor do I become lost to him."
    ),

    Shloka(
        number = 31,
        sanskrit = "सर्वभूतस्थितं यो मां भजत्येकत्वमास्थितः।\nसर्वथा वर्तमानोऽपि स योगी मयि वर्तते॥",
        hindiMeaning = "श्रीकृष्ण कहते हैं कि जो योगी सब प्राणियों में स्थित मुझे देखता है और एकत्व की भावना से मेरी भक्ति करता है, वह जहाँ कहीं भी रहता हो, वास्तव में मुझमें ही रहता है। यह भक्ति स्थान या परिस्थिति पर निर्भर नहीं करती। चाहे योगी किसी भी अवस्था में हो, वह सदा परमात्मा के साथ जुड़ा रहता है। यह स्थिति सच्चे योग की पहचान है।",
        englishMeaning = "The yogi who worships Me as abiding in all beings, with a sense of unity, lives in Me, no matter how he conducts himself."
    ),

    Shloka(
        number = 32,
        sanskrit = "आत्मौपम्येन सर्वत्र समं पश्यति योऽर्जुन।\nसुखं वा यदि वा दुःखं स योगी परमो मतः॥",
        hindiMeaning = "भगवान अर्जुन से कहते हैं कि जो योगी अपने समान सब प्राणियों को देखता है, वही परम योगी है। वह दूसरों के सुख-दुःख को अपना ही मानता है। इस कारण वह किसी के साथ अन्याय या अहित नहीं कर सकता। उसका हृदय करुणा और समानता से भरा होता है। यह समदृष्टि ही योग की सबसे ऊँची अवस्था है। ऐसा योगी सच्चा परोपकारी और परम साधक कहलाता है।",
        englishMeaning = "That yogi who sees the happiness and suffering of all beings as his own is regarded as the highest yogi."
    ),

    Shloka(
        number = 33,
        sanskrit = "अर्जुन उवाच ।\nयोऽयं योगस्त्वया प्रोक्तः साम्येन मधुसूदन।\nएतस्याहं न पश्यामि चञ्चलत्वात्स्थितिं स्थिराम्॥",
        hindiMeaning = "अर्जुन यहाँ श्रीकृष्ण से कहता है – हे मधुसूदन! आपने जो समभावयुक्त योग बताया है, उसमें स्थिरता मैं अपने भीतर नहीं देख पाता। क्योंकि मेरा मन अत्यंत चंचल है और स्थिर नहीं रह पाता। यह मन हर समय किसी न किसी विषय की ओर भागता है। इसलिए इस योग की साधना मुझे कठिन प्रतीत होती है।",
        englishMeaning = "Arjuna said: O Madhusudana, the yoga of equanimity You describe does not seem steady to me, because of the restlessness of my mind."
    ),

    Shloka(
        number = 34,
        sanskrit = "चञ्चलं हि मनः कृष्ण प्रमाथि बलवद् दृढम्।\nतस्याहं निग्रहं मन्ये वायोरिव सुदुष्करम्॥",
        hindiMeaning = "अर्जुन आगे कहता है कि हे कृष्ण! मन तो बड़ा ही चंचल, उग्र, प्रबल और दुष्ट है। इसे वश में करना वायु को रोकने के समान कठिन है। मन बार-बार इच्छाओं और कल्पनाओं की ओर भाग जाता है। इसलिए इसका नियंत्रण अत्यंत कठिन प्रतीत होता है।",
        englishMeaning = "The mind is very restless, turbulent, strong, and obstinate, O Krishna. Controlling it seems as difficult as controlling the wind."
    ),

    Shloka(
        number = 35,
        sanskrit = "श्रीभगवानुवाच ।\nअसंशयं महाबाहो मनो दुर्निग्रहं चलम्।\nअभ्यासेन तु कौन्तेय वैराग्येण च गृह्यते॥",
        hindiMeaning = "श्रीकृष्ण उत्तर देते हैं – हे महाबाहो अर्जुन! निस्संदेह मन चंचल और कठिनाई से वश में होने वाला है। लेकिन यह अभ्यास और वैराग्य से नियंत्रित किया जा सकता है। अभ्यास का अर्थ है बार-बार मन को आत्मा में स्थिर करना। वैराग्य का अर्थ है विषयों से आसक्ति का त्याग। इन दोनों के मेल से मन को साधना संभव है।",
        englishMeaning = "The Blessed Lord said: O mighty-armed Arjuna, the mind is restless and hard to control, no doubt. But it can be restrained by practice and detachment."
    ),

    Shloka(
        number = 36,
        sanskrit = "असंयतात्मना योगो दुष्प्राप इति मे मतिः।\nवश्यात्मना तु यतता शक्योऽवाप्तुमुपायतः॥",
        hindiMeaning = "भगवान कहते हैं कि जिसका मन असंयमित है, उसके लिए योग प्राप्त करना अत्यंत कठिन है। लेकिन जिसका मन संयमित है और जो प्रयत्नशील है, वह उचित साधन से योग प्राप्त कर सकता है। आत्मसंयम योग की पहली सीढ़ी है। बिना आत्मसंयम के योग साधना निष्फल हो जाती है।",
        englishMeaning = "Yoga is hard to attain for the uncontrolled, but for one with self-control and striving by right means, it is attainable."
    ),

    Shloka(
        number = 37,
        sanskrit = "अर्जुन उवाच ।\nअयतिः श्रद्धयोपेतो योगाच्चलितमानसः।\nअप्राप्य योगसंसिद्धिं कां गतिं कृष्ण गच्छति॥",
        hindiMeaning = "अर्जुन पूछते हैं – हे कृष्ण! यदि कोई श्रद्धा तो रखता है परंतु उसका मन स्थिर नहीं रह पाता और वह योगसिद्धि प्राप्त नहीं कर पाता, तो उसकी क्या गति होती है? क्या उसका परिश्रम व्यर्थ चला जाता है? यही संदेह अर्जुन प्रकट करता है।",
        englishMeaning = "Arjuna said: O Krishna, what is the fate of one who has faith but whose mind strays from yoga and fails to achieve perfection?"
    ),

    Shloka(
        number = 38,
        sanskrit = "कच्चिन्नोभयविभ्रष्टश्छिन्नाभ्रमिव नश्यति।\nअप्रतिष्ठो महाबाहो विमूढो ब्रह्मणः पथि॥",
        hindiMeaning = "अर्जुन आगे कहते हैं कि हे महाबाहो! क्या ऐसा योगी दोनों ओर से नष्ट हो जाता है? न तो वह सांसारिक सुख पाता है और न ही आध्यात्मिक सिद्धि। जैसे बादल का टुकड़ा हवा में टूटकर बिखर जाता है, वैसे ही क्या उसका जीवन व्यर्थ हो जाता है? यह अर्जुन की चिंता है।",
        englishMeaning = "Does he not perish, fallen from both sides, like a scattered cloud, having no firm support on the path of Brahman?"
    ),

    Shloka(
        number = 39,
        sanskrit = "एतन्मे संशयं कृष्ण छेत्तुमर्हस्यशेषतः।\nत्वदन्यः संशयस्यास्य छेत्ता न ह्युपपद्यते॥",
        hindiMeaning = "अर्जुन कहते हैं – हे कृष्ण! आप ही मेरे इस संदेह को पूरी तरह दूर कर सकते हैं। आपके अलावा कोई और इस प्रश्न का समाधान नहीं कर सकता। आप ही सच्चे ज्ञानी और गुरु हैं।",
        englishMeaning = "This doubt of mine, O Krishna, You alone can dispel completely. None but You is capable of clearing it."
    ),

    Shloka(
        number = 40,
        sanskrit = "श्रीभगवानुवाच ।\nपार्थ नैवेह नामुत्र विनाशस्तस्य विद्यते।\nनहि कल्याणकृत्कश्चिद्दुर्गतिं तात गच्छति॥",
        hindiMeaning = "श्रीकृष्ण उत्तर देते हैं – हे पार्थ! न तो इस लोक में और न ही परलोक में ऐसे साधक का विनाश होता है। कोई भी जो कल्याणकारी कर्म करता है, उसका कभी अनिष्ट नहीं होता। ईश्वर कभी भी उसके प्रयास को व्यर्थ नहीं जाने देते।",
        englishMeaning = "The Blessed Lord said: O Arjuna, neither here nor hereafter is there destruction for such a yogi. One who does good never comes to grief."
    ),

    Shloka(
        number = 41,
        sanskrit = "प्राप्य पुण्यकृतां लोकानुषित्वा शाश्वतीः समाः।\nशुचीनां श्रीमतां गेहे योगभ्रष्टोऽभिजायते॥",
        hindiMeaning = "भगवान कहते हैं कि ऐसा योगभ्रष्ट साधक पुण्यात्माओं के लोकों में लम्बे समय तक वास करता है। उसके बाद वह किसी पवित्र और समृद्ध परिवार में जन्म लेता है। यह उसका संचित पुण्य है जो उसे उत्तम जन्म दिलाता है। इस प्रकार उसका प्रयास कभी व्यर्थ नहीं जाता।",
        englishMeaning = "Fallen yogis, after enjoying heavenly worlds, are reborn in pure and prosperous families."
    ),

    Shloka(
        number = 42,
        sanskrit = "अथवा योगिनामेव कुले भवति धीमताम्।\nएतद्धि दुर्लभतरं लोके जन्म यदीदृशम्॥",
        hindiMeaning = "या फिर वह सीधे योगियों और ज्ञानी व्यक्तियों के परिवार में जन्म लेता है। ऐसा जन्म अत्यंत दुर्लभ होता है। यह उसके पिछले जन्म की साधना का फल है। इस जन्म में वह योग साधना को और आगे बढ़ा सकता है।",
        englishMeaning = "Or he is born into a family of wise yogis. Such a birth is very rare and precious in this world."
    ),

    Shloka(
        number = 43,
        sanskrit = "तत्र तं बुद्धिसंयोगं लभते पौर्वदेहिकम्।\nयतते च ततो भूयः संसिद्धौ कुरुनन्दन॥",
        hindiMeaning = "ऐसे जन्म में उसे अपने पूर्वजन्म का ज्ञान और संस्कार सहज ही प्राप्त हो जाते हैं। फिर वह उसी आधार पर और अधिक योग साधना में लग जाता है। इस प्रकार वह शीघ्र ही सिद्धि की ओर अग्रसर होता है।",
        englishMeaning = "There he regains the wisdom of his previous birth and strives again for perfection, O son of the Kurus."
    ),

    Shloka(
        number = 44,
        sanskrit = "पूर्वाभ्यासेन तेनैव ह्रियते ह्यवशोऽपि सः।\nजिज्ञासुरपि योगस्य शब्दब्रह्मातिवर्तते॥",
        hindiMeaning = "अपने पूर्व जन्म के अभ्यास के प्रभाव से वह अनायास ही योग की ओर आकर्षित हो जाता है। साधारण जिज्ञासु भी अपने पूर्व संस्कार के कारण योग के मार्ग में आगे बढ़ता है। वह केवल शास्त्र ज्ञान पर नहीं रुकता, बल्कि सीधे अनुभव की ओर अग्रसर होता है।",
        englishMeaning = "By the force of previous practice, even against his will, he is drawn toward yoga. Such a seeker transcends scriptural rituals."
    ),

    Shloka(
        number = 45,
        sanskrit = "प्रयत्नाद्यतमानस्तु योगी संशुद्धकिल्बिषः।\nअनेकजन्मसंसिद्धस्ततो याति परां गतिम्॥",
        hindiMeaning = "जब ऐसा योगी पुनः प्रयास करता है, तब वह अपने सारे पापों से मुक्त हो जाता है। अनेक जन्मों के अभ्यास और संस्कार से वह अंततः परमगति को प्राप्त करता है। यह मुक्ति ही योग का चरम लक्ष्य है।",
        englishMeaning = "Striving with effort, purified of all sins, and perfected through many births, the yogi ultimately attains the supreme goal."
    ),

    Shloka(
        number = 46,
        sanskrit = "तपस्विभ्योऽधिको योगी ज्ञानिभ्योऽपि मतोऽधिकः।\nकर्मिभ्यश्चाधिको योगी तस्माद्योगी भवार्जुन॥",
        hindiMeaning = "भगवान कहते हैं कि योगी तपस्वियों से श्रेष्ठ है, विद्वानों से भी श्रेष्ठ है और कर्मयोगियों से भी श्रेष्ठ है। इसलिए, हे अर्जुन! तुम योगी बनो। योग ही सबसे ऊँचा मार्ग है।",
        englishMeaning = "The yogi is greater than ascetics, greater than the learned, and greater than those who perform rituals. Therefore, be a yogi, O Arjuna."
    ),

    Shloka(
        number = 47,
        sanskrit = "योगिनामपि सर्वेषां मद्गतेनान्तरात्मना।\nश्रद्धावान्भजते यो मां स मे युक्ततमो मतः॥",
        hindiMeaning = "अंत में भगवान कहते हैं कि सभी योगियों में भी वह योगी सबसे श्रेष्ठ है, जो अपनी अंतरात्मा से मुझे भजता है और मुझमें लीन होकर श्रद्धा से भक्ति करता है। ऐसा योगी वास्तव में मेरे साथ एक हो जाता है। इसलिए भक्ति सहित योग ही सर्वोत्तम साधना है।",
        englishMeaning = "Of all yogis, the greatest is the one who worships Me with unwavering faith, absorbed in Me. Such a yogi is most united with Me."
    )

)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaSixScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 6 – ध्यान योग",
                        fontSize = 24.sp, // ✅ consistent with others
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
                onClick = { navController.navigate(Screen.QuizSix.route) },
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
            // ✅ Top Image for Adhyaya 6
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
                        painter = painterResource(R.drawable.gemini_generated_image_2onquu2onquu2onq),
                        contentDescription = "Chapter 6 – Dhyana Yoga",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shloka list
            items(adhyayaSixShlokas) { shloka ->
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
