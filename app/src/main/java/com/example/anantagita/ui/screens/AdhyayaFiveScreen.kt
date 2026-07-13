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
val adhyayaFiveShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अर्जुन उवाच ।\nसंन्यासं कर्मणां कृष्ण पुनर्योगं च शंससि ।\nयच्छ्रेय एतयोरेकं तन्मे ब्रूहि सुनिश्चितम्॥",
        hindiMeaning = "अर्जुन भगवान से पूछते हैं कि हे कृष्ण! कभी आप कर्मों का संन्यास (त्याग) श्रेष्ठ बताते हैं और कभी कर्मयोग की प्रशंसा करते हैं। इन दोनों में से वास्तव में श्रेष्ठ क्या है, इस विषय में मेरी शंका का निवारण करें। अर्जुन यहाँ भ्रमित है क्योंकि वह देख रहा है कि त्याग और कर्म दोनों ही एक-दूसरे के विपरीत प्रतीत होते हैं। यदि त्याग ही मुक्ति का मार्ग है तो फिर कर्म का क्या महत्व है? और यदि कर्म करना ही श्रेष्ठ है, तो फिर संन्यास का उपदेश क्यों दिया गया है? अर्जुन चाहता है कि श्रीकृष्ण इस विषय में स्पष्ट और निश्चित उत्तर दें।",
        englishMeaning = "Arjuna asks Krishna to clarify whether renunciation of actions or performance of actions with discipline is superior. He requests a clear and certain answer."
    ),

    Shloka(
        number = 2,
        sanskrit = "श्रीभगवानुवाच ।\nसंन्यासः कर्मयोगश्च निःश्रेयसकरावुभौ ।\nतयोस्तु कर्मसंन्यासात्कर्मयोगो विशिष्यते॥",
        hindiMeaning = "भगवान उत्तर देते हैं कि संन्यास और कर्मयोग, दोनों ही मोक्ष प्रदान करने वाले हैं। परंतु इन दोनों में से कर्मयोग संन्यास से श्रेष्ठ है। कारण यह है कि कर्मयोगी कर्म करता हुआ भी आसक्ति और अहंकार से मुक्त रहता है। वह अपने कर्तव्यों को निभाते हुए भी अंतःकरण में त्यागी होता है। संन्यासी यदि त्याग का ढोंग करे और मन में वासनाएँ बनी रहें तो वह पतन को प्राप्त हो सकता है। लेकिन कर्मयोगी, अपने कर्म को यज्ञ की भावना से करता है और धीरे-धीरे आत्मशुद्धि पाता है। इसलिए कर्मयोग को व्यवहार में अधिक व्यावहारिक और सुरक्षित मार्ग बताया गया है।",
        englishMeaning = "Krishna explains that both renunciation and karma yoga lead to liberation, but karma yoga is superior. This is because it allows one to act without attachment, leading to inner purity."
    ),

    Shloka(
        number = 3,
        sanskrit = "ज्ञेयः स नित्यसंन्यासी यो न द्वेष्टि न काङ्क्षति ।\nनिर्द्वन्द्वो हि महाबाहो सुखं बन्धात्प्रमुच्यते॥",
        hindiMeaning = "भगवान कहते हैं कि वास्तविक संन्यासी वह है जो न तो किसी से द्वेष करता है और न ही किसी वस्तु की इच्छा करता है। ऐसा व्यक्ति सुख-दुःख, लाभ-हानि, जीत-हार आदि द्वंद्वों से परे हो जाता है। द्वेष और वासना मनुष्य को बाँधते हैं और बंधन का कारण बनते हैं। परंतु जब मनुष्य का हृदय इनसे मुक्त हो जाता है, तभी वह सच्चा त्यागी कहलाता है। इसका अर्थ यह है कि संन्यास केवल बाहरी वस्त्र या जीवनशैली से नहीं होता, बल्कि यह मन की स्थिति है। जो मनुष्य इच्छाओं और द्वेष से मुक्त है, वही वास्तव में सुखपूर्वक कर्मबंधन से छूट जाता है।",
        englishMeaning = "True renunciation is not hating or desiring anything. The one free from dualities such as like-dislike is the real renunciate."
    ),

    Shloka(
        number = 4,
        sanskrit = "साङ्ख्ययोगौ पृथग्बालाः प्रवदन्ति न पण्डिताः ।\nएकमप्यास्थितः सम्यगुभयोर्विन्दते फलम्॥",
        hindiMeaning = "श्रीकृष्ण कहते हैं कि अज्ञानी लोग संन्यास (सांख्य) और कर्मयोग को भिन्न मानते हैं। लेकिन ज्ञानी जानते हैं कि दोनों का लक्ष्य एक ही है। यदि कोई व्यक्ति किसी एक मार्ग का सही ढंग से अनुसरण करता है, तो वह दोनों के ही फल को प्राप्त करता है। कर्मयोगी जब निष्काम होकर कर्म करता है तो उसे भी वह शांति और मुक्ति मिलती है जो संन्यासी को मिलती है। इसी प्रकार सच्चा संन्यासी भी कर्मयोग की भावना से ही जीवित रहता है। दोनों का सार आत्मा को शुद्ध करना और परमात्मा में लीन होना है।",
        englishMeaning = "Fools see sankhya (renunciation) and yoga (action) as different, but the wise know them to be one. Following either properly leads to the same goal."
    ),

    Shloka(
        number = 5,
        sanskrit = "यत्साङ्ख्यैः प्राप्यते स्थानं तद्योगैरपि गम्यते ।\nएकं साङ्ख्यं च योगं च यः पश्यति स पश्यति॥",
        hindiMeaning = "भगवान कहते हैं कि जिस स्थिति को संन्यासी ज्ञान और त्याग से प्राप्त करते हैं, उसी स्थिति को कर्मयोगी भी अपने निष्काम कर्म से प्राप्त करता है। वास्तव में दोनों का लक्ष्य समान है। जो व्यक्ति इन दोनों को एक ही सत्य का मार्ग मानता है, वही वास्तविक रूप से देखता है। अंतर केवल साधन का है, लेकिन फल समान है। यह शिक्षा इसलिए दी गई है कि मनुष्य किसी एक मार्ग को ही सर्वोच्च मानकर अन्य को नकारे नहीं। सत्य की प्राप्ति के अनेक मार्ग हो सकते हैं, लेकिन सबका लक्ष्य एक ही है।",
        englishMeaning = "The state attained by renunciation is also reached by karma yoga. One who sees both as one truly sees."
    ),

    Shloka(
        number = 6,
        sanskrit = "संन्यासस्तु महाबाहो दुःखमाप्तुमयोगतः ।\nयोगयुक्तो मुनिर्ब्रह्म नचिरेणाधिगच्छति॥",
        hindiMeaning = "यहाँ भगवान स्पष्ट करते हैं कि यदि कोई व्यक्ति योग (कर्मयोग) के बिना केवल बाहरी संन्यास लेता है तो उसे बहुत कष्ट सहना पड़ता है। बिना आत्मसंयम और साधना के केवल कर्मों का त्याग करना व्यर्थ है। ऐसा व्यक्ति मानसिक द्वंद्व और वासनाओं से मुक्त नहीं हो पाता। लेकिन जो योगयुक्त होकर कर्म करता है, वह शीघ्र ही ब्रह्म की प्राप्ति करता है। इसका कारण यह है कि योग मन को स्थिर करता है और अंतःकरण को शुद्ध करता है। केवल बाहरी संन्यास से मुक्ति संभव नहीं है।",
        englishMeaning = "Renunciation without yoga is difficult and painful. But one who is disciplined in yoga quickly attains Brahman."
    ),

    Shloka(
        number = 7,
        sanskrit = "योगयुक्तो विशुद्धात्मा विजितात्मा जितेन्द्रियः ।\nसर्वभूतात्मभूतात्मा कुर्वन्नपि न लिप्यते॥",
        hindiMeaning = "भगवान कहते हैं कि योगयुक्त, शुद्ध अंतःकरण वाला, आत्मसंयमी और इंद्रियों को वश में रखने वाला व्यक्ति वास्तविक कर्मयोगी है। ऐसा व्यक्ति सभी प्राणियों में आत्मा को देखता है और आत्मा में परमात्मा को अनुभव करता है। इसलिए वह कर्म करता हुआ भी पाप में लिप्त नहीं होता। उसका हर कर्म निष्काम और समर्पण की भावना से होता है। उसका जीवन दूसरों के लिए उदाहरण बन जाता है। यद्यपि वह संसार में कर्म करता है, परंतु उसका हृदय ईश्वर में स्थित रहता है।",
        englishMeaning = "The self-controlled and pure karma yogi sees all beings as the Self. Acting in this way, he is never tainted."
    ),

    Shloka(
        number = 8,
        sanskrit = "नैव किञ्चित्करोमीति युक्तो मन्येत तत्त्ववित् ।\nपश्यञ्शृण्वन्स्पृशञ्जिघ्रन्नश्नन्गच्छन्स्वपंश्वसन्॥",
        hindiMeaning = "तत्त्वज्ञानी योगी यह समझता है कि वास्तव में मैं कुछ भी नहीं कर रहा हूँ। यद्यपि शरीर इंद्रियों द्वारा देखता, सुनता, छूता, सूंघता, खाता, चलता, सोता और सांस लेता है, परंतु आत्मा इनमें से किसी भी क्रिया का कर्ता नहीं है। यह सब केवल प्रकृति और इंद्रियों की गतिविधियाँ हैं। जब यह समझ आ जाती है तो अहंकार समाप्त हो जाता है। ऐसा व्यक्ति कर्म करते हुए भी निष्काम रहता है। यह दृष्टि आत्मा को बंधन से मुक्त कर देती है।",
        englishMeaning = "The knower of truth thinks, 'I do nothing at all.' Seeing, hearing, touching, eating—he knows these are just functions of the body and senses."
    ),

    Shloka(
        number = 9,
        sanskrit = "प्रलपन्विसृजन्गृह्णन्नुन्मिषन्निमिषन्नपि ।\nइन्द्रियाणीन्द्रियार्थेषु वर्तन्त इति धारयन्॥",
        hindiMeaning = "योगी यह मानता है कि बोलना, छोड़ना, लेना, आँख खोलना या बंद करना, ये सब इंद्रियों की क्रियाएँ हैं। आत्मा इनमें कर्ता नहीं है। इंद्रियाँ अपने-अपने विषयों में प्रवृत्त होती हैं, यह प्रकृति का स्वभाव है। जब मनुष्य यह दृष्टि रखता है तो वह कर्म करते हुए भी उनके फल से बंधता नहीं है। उसका अहंकार समाप्त हो जाता है और वह साक्षी भाव में स्थित रहता है। यही ज्ञान का प्रभाव है जो जीवन को मुक्ति की ओर ले जाता है।",
        englishMeaning = "Speaking, releasing, grasping, opening or closing the eyes—all are seen by the yogi as actions of the senses in their objects, not of the Self."
    ),

    Shloka(
        number = 10,
        sanskrit = "ब्रह्मण्याधाय कर्माणि सङ्गं त्यक्त्वा करोति यः ।\nलिप्यते न स पापेन पद्मपत्रमिवाम्भसा॥",
        hindiMeaning = "भगवान कहते हैं कि जो व्यक्ति अपने सभी कर्मों को ब्रह्मार्पण करके करता है और उनसे आसक्ति त्याग देता है, वह पाप से लिप्त नहीं होता। जैसे कमल का पत्ता जल में रहते हुए भी उससे अछूता रहता है, वैसे ही योगी संसार में कर्म करता हुआ भी संसार से निर्लिप्त रहता है। उसकी शुद्ध भावना और समर्पण उसे बंधन से मुक्त रखती है। वह जानता है कि कर्म केवल कर्तव्य हैं, उनका फल ईश्वर के अधीन है। इसलिए वह स्वतंत्र और निर्मल रहता है।",
        englishMeaning = "One who offers all actions to Brahman, abandoning attachment, is untouched by sin—like a lotus leaf remains untouched by water."
    ),

    Shloka(
        number = 11,
        sanskrit = "कायेन मनसा बुद्ध्या केवलैरिन्द्रियैरपि ।\nयोगिनः कर्म कुर्वन्ति सङ्गं त्यक्त्वात्मशुद्धये॥",
        hindiMeaning = "योगी अपने शरीर, मन, बुद्धि और इंद्रियों द्वारा कर्म करता है, परंतु उनमें आसक्ति नहीं रखता। उसका उद्देश्य केवल आत्मशुद्धि होता है। वह जानता है कि प्रत्येक कर्म ईश्वर की सेवा है और उसका फल ईश्वर को समर्पित है। इसलिए उसका जीवन संतुलित और शांत रहता है। वह कर्म के बीच में रहते हुए भी भीतर से समाधिस्थ होता है। यह जीवन की वास्तविक साधना है।",
        englishMeaning = "Yogis perform actions with body, mind, intellect, and senses, abandoning attachment, only for self-purification."
    ),

    Shloka(
        number = 12,
        sanskrit = "युक्तः कर्मफलं त्यक्त्वा शान्तिमाप्नोति नैष्ठिकीम् ।\nअयुक्तः कामकारेण फले सक्तो निबध्यते॥",
        hindiMeaning = "योगयुक्त व्यक्ति कर्मफल का त्याग करके स्थायी शांति को प्राप्त करता है। परंतु जो योगयुक्त नहीं है और कर्मफल की इच्छा से कर्म करता है, वह हमेशा बंधन में रहता है। इच्छाएँ और आसक्ति ही दुःख का कारण हैं। लेकिन निष्काम भाव से कर्म करने पर मन शुद्ध और शांत हो जाता है। यही स्थायी शांति और मुक्ति की अवस्था है।",
        englishMeaning = "The yogi who renounces fruits of action attains lasting peace. But the unsteady, attached to results, remain bound."
    ),

    Shloka(
        number = 13,
        sanskrit = "सर्वकर्माणि मनसा संन्यस्यास्ते सुखं वशी ।\nनवद्वारे पुरे देही नैव कुर्वन्न कारयन्॥",
        hindiMeaning = "भगवान कहते हैं कि आत्मसंयमी योगी मन से सभी कर्मों का त्याग करता है और सुखपूर्वक जीवन जीता है। वह इस शरीररूपी नौ-द्वारों वाले नगर में रहते हुए भी न तो स्वयं कुछ करता है और न दूसरों से करवाता है। वास्तव में आत्मा कर्ता नहीं है। यह सब केवल शरीर और इंद्रियों की प्रवृत्तियाँ हैं। यह दृष्टि आत्मा को बंधन से मुक्त कर देती है।",
        englishMeaning = "The self-controlled renunciate, dwelling in the body of nine gates, neither acts nor causes action, remaining at peace."
    ),

    Shloka(
        number = 14,
        sanskrit = "न कर्तृत्वं न कर्माणि लोकस्य सृजति प्रभुः ।\nन कर्मफलसंयोगं स्वभावस्तु प्रवर्तते॥",
        hindiMeaning = "भगवान स्पष्ट करते हैं कि आत्मा वास्तव में न तो किसी कर्म का कर्ता है और न ही कर्मों के फल का कारण। ये सब केवल प्रकृति और स्वभाव से होते हैं। मनुष्य का अहंकार ही स्वयं को कर्ता मानता है। वास्तव में आत्मा साक्षी है, वह केवल देखती है। जब यह समझ आ जाती है तो बंधन से मुक्ति मिलती है।",
        englishMeaning = "The Self creates neither agency, nor actions, nor the union of action and its fruits. All these are done by nature alone."
    ),

    Shloka(
        number = 15,
        sanskrit = "नादत्ते कस्यचित्पापं न चैव सुकृतं विभुः ।\nअज्ञानेनावृतं ज्ञानं तेन मुह्यन्ति जन्तवः॥",
        hindiMeaning = "भगवान कहते हैं कि परमात्मा किसी के पाप या पुण्य को ग्रहण नहीं करता। प्रत्येक जीव अपने कर्मों का फल स्वयं भोगता है। वास्तव में आत्मा शुद्ध है, लेकिन अज्ञान के कारण ज्ञान ढक जाता है और जीव मोह में फँस जाता है। अज्ञान ही कारण है जिससे मनुष्य भेदभाव, अहंकार और मोह में पड़ता है। जब ज्ञान का प्रकाश आता है तो यह भ्रम समाप्त हो जाता है।",
        englishMeaning = "The Lord takes neither the sin nor the virtue of anyone. Knowledge is covered by ignorance, and thus beings are deluded."
    ),
    Shloka(
        number = 16,
        sanskrit = "ज्ञानेन तु तदज्ञानं येषां नाशितमात्मनः।\nतेषामादित्यवज्ज्ञानं प्रकाशयति तत्परम्॥",
        hindiMeaning = "भगवान कहते हैं कि जिन साधकों ने अपने भीतर से अज्ञान का नाश कर लिया है, उनके लिए आत्मज्ञान सूर्य के समान सब कुछ प्रकाशित कर देता है। जैसे अंधकार को केवल सूर्य ही मिटा सकता है, वैसे ही अज्ञान को केवल ज्ञान ही दूर कर सकता है। जब यह दिव्य ज्ञान प्राप्त होता है तो जीवन की सभी उलझनें और भ्रांतियाँ समाप्त हो जाती हैं। साधक के सामने मार्ग स्पष्ट हो जाता है और वह किसी भी प्रकार के भ्रम या मोह में नहीं रहता। यह ज्ञान आत्मा की शुद्धता और परम सत्य की अनुभूति कराता है। इस प्रकाश से व्यक्ति जान लेता है कि आत्मा नित्य, अविनाशी और अजर है। ऐसा ज्ञान ही मोक्ष का मार्ग खोलता है।",
        englishMeaning = "When ignorance is destroyed by true knowledge, that knowledge shines like the sun, revealing the ultimate reality. Such wisdom removes all darkness and confusion."
    ),

    Shloka(
        number = 17,
        sanskrit = "तद्बुद्धयस्तदात्मानस्तन्निष्ठास्तत्परायणाः।\nगच्छन्त्यपुनरावृत्तिं ज्ञाननिर्धूतकल्मषाः॥",
        hindiMeaning = "भगवान बताते हैं कि जो साधक अपनी बुद्धि को परमात्मा में स्थिर कर लेते हैं, आत्मा को उसी में एकाकार कर देते हैं और उसी में लीन रहते हैं, वे कभी संसार के चक्र में वापस नहीं आते। वे पूरी तरह परमात्मा के शरणागत हो जाते हैं। ऐसा करने से उनके पाप और कर्म के सभी बंधन ज्ञान द्वारा नष्ट हो जाते हैं। जब हृदय शुद्ध हो जाता है, तब आत्मा परम शांति और मुक्ति का अनुभव करती है। यह मार्ग केवल श्रद्धा, निष्ठा और साधना से संभव है। अंततः ऐसे ज्ञानीजन परमगति को प्राप्त होते हैं।",
        englishMeaning = "Those who fix their mind and soul on God, with unwavering devotion, are freed from sins by knowledge and attain liberation, never returning to this material world."
    ),

    Shloka(
        number = 18,
        sanskrit = "विद्याविनयसम्पन्ने ब्राह्मणे गवि हस्तिनि।\nशुनि चैव श्वपाके च पण्डिताः समदर्शिनः॥",
        hindiMeaning = "यहाँ भगवान समझाते हैं कि सच्चे ज्ञानी सब प्राणियों में समानता देखते हैं। वे एक विद्वान ब्राह्मण, गाय, हाथी, कुत्ते और यहाँ तक कि चांडाल (अस्पृश्य) में भी आत्मा की समान उपस्थिति का अनुभव करते हैं। बाहरी शरीर, जाति या स्थिति अलग-अलग हो सकती है, लेकिन आत्मा एक ही है। इस प्रकार, ज्ञानी के लिए किसी में कोई भेदभाव नहीं होता। यह दृष्टि तब आती है जब व्यक्ति वास्तव में आत्मा की शुद्धता और सार्वभौमिकता को समझ लेता है। ऐसे साधक न किसी से द्वेष करते हैं और न ही किसी के प्रति अहंकार रखते हैं। यही सच्चा समदृष्टि का भाव है।",
        englishMeaning = "The wise see all beings equally—whether a learned Brahmin, a cow, an elephant, a dog, or a lowly outcaste. They perceive the same soul within all."
    ),

    Shloka(
        number = 19,
        sanskrit = "इहैव तैर्जितः सर्गो येषां साम्ये स्थितं मनः।\nनिर्दोषं हि समं ब्रह्म तस्माद्ब्रह्मणि ते स्थिताः॥",
        hindiMeaning = "भगवान कहते हैं कि जिनका मन समदृष्टि में स्थिर है, उन्होंने इसी जीवन में जन्म और मृत्यु के चक्र को जीत लिया है। क्योंकि समभाव वाला मनुष्य सबको समान रूप से देखता है और किसी से द्वेष या मोह नहीं करता। वह जानता है कि ब्रह्म निरदोष और समान है, उसमें किसी प्रकार का भेद नहीं है। जब मनुष्य यह अनुभव करता है तो उसका मन स्थिर और शांत हो जाता है। ऐसे व्यक्ति संसार के सुख-दुख, लाभ-हानि या मान-अपमान से विचलित नहीं होते। यही कारण है कि वे वास्तव में परमात्मा में स्थित हो जाते हैं।",
        englishMeaning = "Those whose minds are fixed in equality conquer birth and death in this life itself. Being established in the faultless and equal Brahman, they are firmly situated in God."
    ),

    Shloka(
        number = 20,
        sanskrit = "न प्रहृष्येत्प्रियं प्राप्य नोद्विजेत्प्राप्य चाप्रियम्।\nस्थिरबुद्धिरसम्मूढो ब्रह्मविद्ब्रह्मणि स्थितः॥",
        hindiMeaning = "भगवान समझाते हैं कि जिसने ब्रह्म को जान लिया है, वह व्यक्ति परिस्थितियों से प्रभावित नहीं होता। जब उसे प्रिय वस्तु मिलती है, तो वह अति प्रसन्न नहीं होता, और जब अप्रिय परिस्थितियाँ आती हैं, तो वह दुखी नहीं होता। उसका मन स्थिर और शांत रहता है। ऐसा व्यक्ति मोह और भ्रम से मुक्त होता है। उसकी बुद्धि स्थिर रहने के कारण वह हमेशा संतुलन बनाए रखता है। यह अवस्था ब्रह्मज्ञानियों की विशेषता है।",
        englishMeaning = "One who knows Brahman remains steady, not elated by pleasant experiences nor disturbed by unpleasant ones. Such a wise person is stable and free from delusion."
    ),

    Shloka(
        number = 21,
        sanskrit = "बाह्यस्पर्शेष्वसक्तात्मा विन्दत्यात्मनि यत्सुखम्।\nस ब्रह्मयोगयुक्तात्मा सुखमक्षयमश्नुते॥",
        hindiMeaning = "भगवान कहते हैं कि जिसका मन बाहरी विषयों और इंद्रिय सुखों में आसक्त नहीं होता, वही अपने भीतर सच्चा सुख अनुभव करता है। आत्मा के भीतर स्थित आनंद कभी नष्ट नहीं होता, क्योंकि वह परमात्मा से जुड़ा हुआ है। बाहरी सुख तो क्षणिक और नाशवान हैं, लेकिन आत्मिक सुख शाश्वत और असीम है। जब साधक का मन परमात्मा में स्थिर होता है, तो वह अमर आनंद को प्राप्त करता है। यही ब्रह्मयोग की अवस्था है।",
        englishMeaning = "The self-controlled person who is detached from external pleasures finds true happiness within. Being united with the Supreme, he enjoys eternal bliss."
    ),

    Shloka(
        number = 22,
        sanskrit = "ये हि संस्पर्शजा भोगा दुःखयोनय एव ते।\nआद्यन्तवन्तः कौन्तेय न तेषु रमते बुधः॥",
        hindiMeaning = "यहाँ भगवान कहते हैं कि इंद्रियों के विषयों से उत्पन्न होने वाले सभी भोग अंततः दुख का कारण बनते हैं। ये सुख प्रारंभ और अंत में सीमित होते हैं, इसलिए वे स्थायी नहीं हैं। ज्ञानीजन इन क्षणिक भोगों में आसक्ति नहीं रखते। वे जानते हैं कि भोग असली शांति नहीं ला सकते। इसलिए जो साधक विवेकवान होता है, वह भोगों का त्याग कर देता है और आत्मा की ओर उन्मुख होता है। यही त्याग ही उसे वास्तविक सुख की ओर ले जाता है।",
        englishMeaning = "Pleasures born from contact with the senses are sources of misery. They have a beginning and an end, so the wise do not delight in them."
    ),

    Shloka(
        number = 23,
        sanskrit = "शक्नोतीहैव यः सोढुं प्राक्शरीरविमोक्षणात्।\nकामक्रोधोद्भवं वेगं स युक्तः स सुखी नरः॥",
        hindiMeaning = "भगवान बताते हैं कि जो मनुष्य इस जीवन में शरीर का त्याग करने से पहले काम और क्रोध से उत्पन्न वेग को सहन कर सकता है, वही वास्तव में योगी और सुखी कहलाता है। इच्छाएँ और क्रोध मनुष्य को अशांत करते हैं। लेकिन जो साधक धैर्य, संयम और विवेक से उन्हें नियंत्रित कर लेता है, वह वास्तविक शांति का अनुभव करता है। यह अभ्यास धीरे-धीरे आत्मिक उन्नति की ओर ले जाता है। संयमित व्यक्ति ही जीवन में स्थायी सुख प्राप्त करता है।",
        englishMeaning = "One who can control the urges of desire and anger before leaving this body is a true yogi and attains real happiness."
    ),

    Shloka(
        number = 24,
        sanskrit = "योऽन्तःसुखोऽन्तरारामस्तथान्तर्ज्योतिरेव यः।\nस योगी ब्रह्मनिर्वाणं ब्रह्मभूतोऽधिगच्छति॥",
        hindiMeaning = "भगवान कहते हैं कि जो व्यक्ति भीतर ही सुख का अनुभव करता है, भीतर ही रमण करता है और भीतर ही प्रकाश को देखता है, वही सच्चा योगी है। उसका आनंद बाहरी वस्तुओं पर निर्भर नहीं रहता। ऐसा साधक वास्तव में आत्मा और परमात्मा के मिलन का अनुभव करता है। वह ब्रह्म का स्वरूप बन जाता है और ब्रह्मनिर्वाण, अर्थात् शाश्वत मुक्ति को प्राप्त करता है। यही आत्मिक आनंद की सर्वोच्च अवस्था है।",
        englishMeaning = "The yogi who finds joy, rest, and light within himself attains union with Brahman and reaches the state of eternal liberation."
    ),

    Shloka(
        number = 25,
        sanskrit = "लभन्ते ब्रह्मनिर्वाणमृषयः क्षीणकल्मषाः।\nछिन्नद्वैधा यतात्मानः सर्वभूतहिते रताः॥",
        hindiMeaning = "भगवान कहते हैं कि जिन ऋषियों ने अपने पाप और दोषों का नाश कर लिया है, जो मन से द्वंद्व से मुक्त हो गए हैं और आत्मा को नियंत्रित कर चुके हैं, वे ब्रह्मनिर्वाण को प्राप्त करते हैं। ऐसे साधक केवल अपने लिए नहीं, बल्कि सब प्राणियों के हित में लगे रहते हैं। उनका जीवन करुणा, प्रेम और सेवा से भरा होता है। यही निःस्वार्थ भाव उन्हें शुद्ध और पूर्ण बनाता है। अंततः वे परम शांति और मुक्ति को प्राप्त करते हैं।",
        englishMeaning = "Sages who are free from sin, doubt, and dualities, and who work for the welfare of all beings, attain Brahman and eternal peace."
    ),

    Shloka(
        number = 26,
        sanskrit = "कामक्रोधवियुक्तानां यतीनां यतचेतसाम्।\nअभितो ब्रह्मनिर्वाणं वर्तते विदितात्मनाम्॥",
        hindiMeaning = "यहाँ भगवान कहते हैं कि जो साधक काम और क्रोध से मुक्त हो जाते हैं और जिनका मन पूरी तरह संयमित है, वे ब्रह्मनिर्वाण के अधिकारी बनते हैं। आत्मा को जान लेने वाले ऐसे लोग हर ओर परम शांति का अनुभव करते हैं। उनके लिए जीवन का हर क्षण आनंदमय होता है। जब मन इच्छाओं और द्वेष से मुक्त हो जाता है, तो आत्मा का प्रकाश स्वतः प्रकट होता है। यही अवस्था ब्रह्मज्ञान की प्राप्ति है।",
        englishMeaning = "Those who are free from desire and anger, with controlled minds and knowledge of the self, attain Brahman and live in constant peace."
    ),

    Shloka(
        number = 27,
        sanskrit = "स्पर्शान्कृत्वा बहिर्बाह्यांश्चक्षुश्चैवान्तरे भ्रुवोः।\nप्राणापानौ समौ कृत्वा नासाभ्यन्तरचारिणौ॥",
        hindiMeaning = "भगवान ध्यान की प्रक्रिया बताते हुए कहते हैं कि योगी बाहरी इंद्रिय विषयों को त्यागकर, अपनी दृष्टि को भौंहों के बीच केंद्रित करता है। वह प्राण और अपान वायु को नासिका के भीतर संतुलित करता है। इस प्रकार की साधना मन को एकाग्र करती है और आंतरिक शांति लाती है। जब मन बाहरी विषयों से हटकर भीतर की ओर जाता है, तब साधक आत्मा का साक्षात्कार करने लगता है। यह ध्यान योग की महत्वपूर्ण विधि है।",
        englishMeaning = "By turning away from external sense objects, fixing the gaze between the eyebrows, and balancing the breath, the yogi attains concentration and inner peace."
    ),

    Shloka(
        number = 28,
        sanskrit = "यतेन्द्रियमनोबुद्धिर्मुनिर्मोक्षपरायणः।\nविगतेच्छाभयक्रोधो यः सदा मुक्त एव सः॥",
        hindiMeaning = "भगवान कहते हैं कि जिसने इंद्रियों, मन और बुद्धि को वश में कर लिया है, और जो हमेशा मोक्ष की ओर उन्मुख रहता है, वही सच्चा मुनि है। ऐसा साधक इच्छाओं, भय और क्रोध से मुक्त हो जाता है। जब ये बंधन समाप्त हो जाते हैं, तब वह वास्तव में मुक्त हो जाता है। यह मुक्ति केवल मृत्यु के बाद नहीं, बल्कि जीवन में भी संभव है। आत्मसंयमी व्यक्ति संसार में रहते हुए भी स्वतंत्र और शांत रहता है।",
        englishMeaning = "The sage who controls his senses, mind, and intellect, and who is free from desire, fear, and anger, is always liberated, even while living in this world."
    ),

    Shloka(
        number = 29,
        sanskrit = "भोक्तारं यज्ञतपसां सर्वलोकमहेश्वरम्।\nसुहृदं सर्वभूतानां ज्ञात्वा मां शान्तिमृच्छति॥",
        hindiMeaning = "अंत में भगवान अर्जुन से कहते हैं कि जो साधक मुझे यज्ञ और तपस्या का परम भोक्ता, सभी लोकों का स्वामी और सब प्राणियों का हितैषी जान लेता है, वही शांति प्राप्त करता है। जब मनुष्य यह समझ लेता है कि परमात्मा ही सब कुछ संचालित कर रहा है, तो वह अपने अहंकार और स्वार्थ को त्याग देता है। इस भाव से वह परमात्मा से जुड़ जाता है और हृदय में शांति का अनुभव करता है। परम शांति केवल ईश्वर को अपना सच्चा स्वामी और मित्र मानने से ही प्राप्त होती है।",
        englishMeaning = "The one who knows Me as the ultimate enjoyer of sacrifices and austerities, the Supreme Lord of all worlds, and the true friend of all beings, attains real peace."
    ),
    Shloka(
            number = 21,
    sanskrit = "सत्त्वसम्पन्नो हि यत्नेन धर्मे स्थिरो भवति। रजसः कामार्थकृत् लोभिनो हि प्रमादग्रस्तः सदा।।",
    hindiMeaning = "सत्त्वसम्पन्न व्यक्ति यत्नपूर्वक धर्म में स्थिर रहता है। राजसिक व्यक्ति केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान से ग्रसित रहता है। यह श्लोक बताता है कि श्रद्धा और गुणों के अनुसार व्यक्ति का जीवन और कर्म स्थिर या अस्थिर होते हैं।",
    englishMeaning = "Sattvic are steadfast in dharma with effort; Rajasic act for gain; Tamasic are heedless and deluded."
),

Shloka(
number = 22,
sanskrit = "सत्त्वसम्पन्नः प्रज्ञावान् धर्मे स्थिरो युक्तः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, धर्म में स्थिर और युक्त रहता है। राजसिक केवल काम और लाभ की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। यह गुणों के अनुसार कर्म और जीवन की स्थिति को दर्शाता है।",
englishMeaning = "Sattvic are wise, stable, and balanced in dharma; Rajasic act for desire; Tamasic are negligent and deluded."
),

Shloka(
number = 23,
sanskrit = "सत्त्वसम्पन्नो यत्नेन धर्मे स्थिरः प्रज्ञावान्। असुरसम्पन्नः प्रमादी लोभी क्रोधग्रस्तः सदा।।",
hindiMeaning = "सत्त्वसम्पन्न व्यक्ति यत्नपूर्वक धर्म में स्थिर और ज्ञानी होता है। असुरसम्पन्न व्यक्ति हमेशा प्रमादी, लोभी और क्रोधग्रस्त रहता है। यह श्लोक गुणों के अनुसार जीवन और मानसिक स्थिति को स्पष्ट करता है।",
englishMeaning = "Sattvic are steadfast in dharma and wise; demonic are heedless, greedy, and wrathful."
),

Shloka(
number = 24,
sanskrit = "सत्त्वसम्पन्नः भक्त्या युक्तः स्थिरः प्रज्ञावान् च। असुरसम्पन्नः प्रमादी लोभी क्रोधग्रस्तः सदा।।",
hindiMeaning = "सत्त्वसम्पन्न व्यक्ति भक्ति और श्रद्धा से युक्त, स्थिर और ज्ञानी होता है। असुरसम्पन्न व्यक्ति हमेशा प्रमादी, लोभी और क्रोधग्रस्त रहता है। यह श्लोक श्रद्धा और गुणों के प्रभाव को स्पष्ट करता है।",
englishMeaning = "Sattvic individuals are devoted, steadfast, and wise; demonic are heedless, greedy, and wrathful."
),

Shloka(
number = 25,
sanskrit = "दैवसम्पन्नो धर्मयुक्तो ज्ञानेन युक्तः स्थिरः। असुरसम्पन्नः प्रमादी लोभी क्रोधग्रस्तः सदा।।",
hindiMeaning = "दैवी सम्पदा वाला व्यक्ति धर्मयुक्त, ज्ञानी और स्थिर रहता है। असुरी सम्पदा वाला हमेशा प्रमादी, लोभी और क्रोधग्रस्त रहता है। यह श्लोक गुणों के अनुसार जीवन के परिणाम को स्पष्ट करता है।",
englishMeaning = "Divine are righteous, knowledgeable, and steadfast; demonic are heedless, greedy, and wrathful."
),

Shloka(
number = 26,
sanskrit = "एवं सत्त्वराजसतमसः श्रद्धात्रयभेदः स्पष्टः। सत्त्वसम्पन्नो भवेद्व्यवस्थितः पुरुषोत्तमः।।",
hindiMeaning = "इस प्रकार सत्त्व, रजस और तमस में श्रद्धा का भेद स्पष्ट है। सत्त्वसम्पन्न व्यक्ति पुरुषोत्तम की भक्ति में स्थित होता है और मोक्ष की प्राप्ति करता है। यह श्लोक अध्याय का सार बताता है।",
englishMeaning = "Thus, the distinction of faith into Sattva, Rajas, and Tamas is clear; one endowed with Sattva becomes steadfast in the Supreme."
),

Shloka(
number = 27,
sanskrit = "श्रद्धा त्रयप्रकृत्या न केवलं कर्मण्यपि प्रभावति। मनसि च बुद्धौ च शरीरसंपत्तौ च तथा।।",
hindiMeaning = "श्रद्धा के तीन प्रकार न केवल कर्मों पर, बल्कि मन, बुद्धि और शरीर की संपत्ति पर भी प्रभाव डालते हैं। सत्त्विक श्रद्धा मन और बुद्धि को शुद्ध करती है, राजसिक उत्साह और कामना बढ़ाती है, और तामसिक प्रमाद और आलस्य उत्पन्न करती है। यह श्लोक श्रद्धा के व्यापक प्रभाव को दर्शाता है।",
englishMeaning = "Faith of three types affects actions, mind, intellect, and bodily well-being; Sattva purifies, Rajas excites desire, Tamas causes negligence."
),

Shloka(
number = 28,
sanskrit = "सत्त्वं शुद्धसुखसंकल्पं राजसि कामप्रदं तमः प्रमाद्युक्तं दुःखजनकम्।",
hindiMeaning = "सत्त्विक गुण शुद्ध, सुखप्रद और संतोषजनक होते हैं। राजसिक गुण इच्छाओं और कामों को बढ़ावा देते हैं। तामसिक गुण प्रमाद और अज्ञान से भरे होते हैं और दुःख उत्पन्न करते हैं। यह श्लोक गुणों के प्रभाव को संक्षेप में प्रस्तुत करता है।",
englishMeaning = "Sattva is pure and blissful, Rajas drives desire, Tamas brings delusion and suffering."
),

Shloka(
number = 29,
sanskrit = "सत्त्वसम्पन्नो ज्ञानी भक्त्या युक्तः स्थिरः। रजसः कामार्थकृत् तमः प्रमादग्रस्तः सदा।।",
hindiMeaning = "सत्त्वसम्पन्न व्यक्ति ज्ञानी, भक्तिभाव से युक्त और स्थिर रहता है। राजसिक व्यक्ति केवल फल और काम की इच्छा से कर्म करता है। तामसिक व्यक्ति प्रमाद और अज्ञान में फँसा रहता है। गुणों के अनुसार कर्म और जीवन की स्थिति भिन्न होती है।",
englishMeaning = "Sattvic are wise, devoted, and steadfast; Rajasic act for gain; Tamasic are heedless and deluded."
)

)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaFiveScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 5 – संन्यास योग",
                        fontSize = 26.sp, // ✅ bigger title for readability
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
                onClick = { navController.navigate(Screen.QuizFive.route) },
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
                        painter = painterResource(R.drawable.gemini_generated_image_hq56khq56khq56kh),
                        contentDescription = "Chapter 5 – Sannyasa Yoga",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaFiveShlokas) { shloka ->
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
