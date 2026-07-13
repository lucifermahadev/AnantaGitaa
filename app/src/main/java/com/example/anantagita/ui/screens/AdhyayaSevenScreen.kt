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

val adhyayaSevenShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "श्रीभगवानुवाच ।\nमय्यासक्तमना: पार्थ योगं युञ्जन्मदाश्रय: ।\nअसंशयं समग्रं मां यथा ज्ञास्यसि तच्छृणु ॥",
        hindiMeaning = "भगवान श्रीकृष्ण अर्जुन से कहते हैं – हे पार्थ! जब मनुष्य का मन पूर्ण रूप से मुझमें आसक्त हो जाता है और वह योगाभ्यास करता हुआ मुझ पर ही आश्रित होता है, तब वह मुझे संपूर्ण रूप से जान सकता है। यहाँ ‘मय्यासक्तमना:’ का अर्थ है मन और हृदय को परमात्मा के प्रति दृढ़ता से लगाना। केवल साधारण भक्ति या सतही श्रद्धा से भगवान को पूर्ण रूप से नहीं जाना जा सकता, बल्कि जब साधक हर परिस्थिति में ईश्वर को अपना आधार मानता है, तभी वास्तविक ज्ञान प्रकट होता है। भगवान यह आश्वासन देते हैं कि ऐसा साधक बिना किसी संशय के मुझे जान पाएगा। इसका तात्पर्य यह है कि शंका और भ्रम का नाश केवल ईश्वर-आश्रित योग साधना से ही संभव है। इस श्लोक में अर्जुन को यह शिक्षा दी जा रही है कि दृढ़ आसक्ति और भक्ति से ही ईश्वर को संपूर्णता से जाना जा सकता है।",
        englishMeaning = "The Blessed Lord said: O Arjuna, if your mind becomes attached to Me and you practice yoga while taking refuge in Me, you will come to know Me completely and without any doubt."
    ),
    Shloka(
        number = 2,
        sanskrit = "ज्ञानं तेऽहं सविज्ञानमिदं वक्ष्याम्यशेषत: ।\nयज्ज्ञात्वा नेह भूयोऽन्यज्ज्ञातव्यमवशिष्यते ॥",
        hindiMeaning = "भगवान श्रीकृष्ण कहते हैं कि मैं तुम्हें ऐसा ज्ञान और विज्ञान बताऊँगा, जिसे जान लेने के बाद कुछ भी और जानना शेष नहीं रहेगा। यहाँ ‘ज्ञान’ से तात्पर्य है शास्त्रों में वर्णित सत्य का बौद्धिक ज्ञान और ‘विज्ञान’ से तात्पर्य है उस ज्ञान का प्रत्यक्ष अनुभव। केवल सैद्धांतिक ज्ञान से मनुष्य को पूर्णता नहीं मिलती, उसे जीवन में उतारना और अनुभव करना आवश्यक है। जब साधक उस सत्य को जीता है, तब उसे संपूर्ण संतोष और निश्चय प्राप्त होता है। इस श्लोक में भगवान स्पष्ट करते हैं कि उनका उपदेश केवल विचारधारा नहीं है, बल्कि यह जीवित अनुभव और परम सत्य की अनुभूति है। इस प्रकार अर्जुन को यह वचन दिया गया है कि वह जो भी सुनेगा, उससे परम ज्ञान और अनुभूति दोनों प्राप्त होंगे।",
        englishMeaning = "I shall now explain to you both knowledge and wisdom, along with realization. Once you understand this, nothing more will remain to be known in this world."
    ),
    Shloka(
        number = 3,
        sanskrit = "मनुष्याणां सहस्रेषु कश्चिद्यतति सिद्धये ।\nयततामपि सिद्धानां कश्चिन्मां वेत्ति तत्त्वत: ॥",
        hindiMeaning = "भगवान कहते हैं कि असंख्य मनुष्यों में से कोई-कोई ही सिद्धि पाने का प्रयास करता है। और उन सिद्ध पुरुषों में भी कोई-कोई ही वास्तव में मुझे मेरे वास्तविक स्वरूप में जान पाता है। इसका तात्पर्य यह है कि परमात्मा का सच्चा ज्ञान दुर्लभ है और केवल वही साधक, जो निरंतर साधना, तप और भक्ति करता है, उसे प्राप्त कर सकता है। सामान्य लोग सांसारिक इच्छाओं में फँसे रहते हैं और आत्मज्ञान की ओर अग्रसर नहीं हो पाते। यहाँ भगवान अर्जुन को यह भी समझा रहे हैं कि ज्ञान प्राप्त करने का मार्ग सरल नहीं है, बल्कि गहन निष्ठा और समर्पण चाहता है। यह कथन साधक के लिए प्रेरणा है कि यदि कोई दृढ़ निश्चय और सतत भक्ति रखे तो भगवान को तत्त्वतः जाना जा सकता है।",
        englishMeaning = "Among thousands of people, only a few strive for perfection. And among those who strive and attain success, hardly one truly knows Me as I am."
    ),
    Shloka(
        number = 4,
        sanskrit = "भूमिरापोऽनलो वायुः खं मनो बुद्धिरेव च ।\nअहङ्कार इतीयं मे भिन्ना प्रकृतिरष्टधा ॥",
        hindiMeaning = "भगवान कहते हैं कि मेरी प्रकृति आठ प्रकार की है – पृथ्वी, जल, अग्नि, वायु, आकाश, मन, बुद्धि और अहंकार। इन्हें मिलाकर भौतिक और सूक्ष्म जगत की रचना होती है। यहाँ यह समझाया गया है कि ये सब तत्व भगवान की शक्ति के विभाजन हैं, स्वतंत्र सत्ता नहीं। इनसे ही संसार का संचालन और सृजन होता है, परंतु इनका स्वामी और मूल कारण स्वयं भगवान ही हैं। जब साधक यह समझ लेता है कि सारा जगत ईश्वर की शक्ति से प्रकट हुआ है, तब उसका अहंकार मिटने लगता है। इसलिए यह श्लोक जगत की संरचना का आधार बताकर ईश्वर की महत्ता स्पष्ट करता है।",
        englishMeaning = "Earth, water, fire, air, space, mind, intellect, and ego – these eight make up My separated material energies."
    ),
    Shloka(
        number = 5,
        sanskrit = "अपरेयमितस्त्वन्यां प्रकृतिं विद्धि मे पराम् ।\nजीवभूतां महाबाहो ययेदं धार्यते जगत् ॥",
        hindiMeaning = "भगवान कहते हैं कि यह आठfold भौतिक प्रकृति मेरी निम्न शक्ति है। इसके अतिरिक्त एक और उच्च शक्ति है, जिसे ‘जीव-शक्ति’ कहा गया है। यही जीवात्मा है जो इस जगत को धारण करता है और सभी प्राणियों में चेतना भरता है। इस प्रकार भौतिक जगत केवल स्थूल है, जबकि जीवन और चेतना परमात्मा की उच्चतर ऊर्जा से आती है। यहाँ अर्जुन को यह शिक्षा दी जा रही है कि आत्मा का स्रोत भी भगवान ही हैं और इसलिए जीव तथा प्रकृति दोनों ही उन्हीं पर निर्भर हैं। साधक को यह समझना चाहिए कि परमात्मा ही इन सबका आधार और नियंता हैं।",
        englishMeaning = "But beyond this inferior nature, O mighty-armed Arjuna, know that there is My higher nature – the living beings – by which the whole world is sustained."
    ),
    Shloka(
        number = 6,
        sanskrit = "एतद्योनीनि भूतानि सर्वाणीत्युपधारय ।\nअहं कृत्स्नस्य जगतः प्रभव: प्रलयस्तथा ॥",
        hindiMeaning = "भगवान स्पष्ट करते हैं कि संपूर्ण जगत इन्हीं दो प्रकार की शक्तियों – भौतिक और जीवात्मा – से उत्पन्न होता है। मैं ही समस्त जगत का उद्गम भी हूँ और उसका विनाश भी मुझमें ही होता है। इसका अर्थ यह है कि भगवान ही कारणों के भी कारण हैं। किसी भी वस्तु, प्राणी या घटना का अंतिम कारण परमात्मा ही है। सृष्टि की उत्पत्ति और लय दोनों उन्हीं की शक्ति से संचालित होते हैं। इसलिए साधक को यह जान लेना चाहिए कि ब्रह्मांड का आधार केवल ईश्वर ही हैं। इस ज्ञान से मनुष्य का आसक्ति भाव संसार से हटकर ईश्वर की ओर बढ़ता है।",
        englishMeaning = "Understand that all beings originate from these two natures. I am the source of creation and also the place of dissolution of the entire universe."
    ),
    Shloka(
        number = 7,
        sanskrit = "मत्त: परतरं नान्यत्किञ्चिदस्ति धनञ्जय ।\nमयि सर्वमिदं प्रोतं सूत्रे मणिगणा इव ॥",
        hindiMeaning = "भगवान कहते हैं – हे धनंजय! मुझसे श्रेष्ठ कुछ भी नहीं है। यह सम्पूर्ण जगत मुझमें ही गुँथा हुआ है, जैसे धागे में मोतियों की पंक्ति गुँथी होती है। इसका तात्पर्य यह है कि सारा जगत भगवान पर निर्भर है और वह उनकी सत्ता से ही संचालित है। लोग भले ही ईश्वर को प्रत्यक्ष न देखें, पर उनकी शक्ति हर जगह व्याप्त है। जैसे बिना धागे के माला अस्तित्व में नहीं आ सकती, वैसे ही बिना ईश्वर के जगत की रचना और संचालन संभव नहीं। यह ज्ञान अर्जुन को यह समझाने के लिए है कि परमात्मा ही सब कुछ हैं और उनसे अलग कोई सत्ता नहीं।",
        englishMeaning = "O Arjuna, there is nothing higher than Me. Everything rests upon Me, like pearls strung on a thread."
    ),
    Shloka(
        number = 8,
        sanskrit = "रसोऽहमप्सु कौन्तेय प्रभास्मि शशिसूर्ययो: ।\nप्रणव: सर्ववेदेषु शब्द: खे पौरुषं नृषु ॥",
        hindiMeaning = "भगवान अर्जुन से कहते हैं – हे कुन्तीपुत्र! मैं जल में रस हूँ, सूर्य और चन्द्रमा में प्रकाश हूँ, वेदों में प्रणव (ॐ) हूँ, आकाश में ध्वनि हूँ और मनुष्यों में पुरुषार्थ हूँ। इसका तात्पर्य यह है कि हर वस्तु और गुण में भगवान ही प्रकट होते हैं। जब साधक जल पीते समय रस को भगवान का स्वरूप मानता है, तो उसका ध्यान स्वतः ईश्वर पर केंद्रित हो जाता है। इसी प्रकार जीवन के हर पहलू में भगवान को देखने की शिक्षा दी गई है। इससे मनुष्य की दृष्टि संसार से हटकर परमात्मा की सर्वव्यापकता पर टिक जाती है। यह श्लोक साधक को ईश्वर की उपस्थिति हर जगह अनुभव कराने का मार्ग दिखाता है।",
        englishMeaning = "O son of Kunti, I am the taste in water, the light of the sun and moon, the sacred syllable Om in the Vedas, the sound in space, and the ability in humans."
    ),
    Shloka(
        number = 9,
        sanskrit = "पुण्यो गन्ध: पृथिव्यां च तेजश्चास्मि विभावसौ ।\nजीवनं सर्वभूतेषु तपश्चास्मि तपस्विषु ॥",
        hindiMeaning = "भगवान कहते हैं – मैं पृथ्वी की पवित्र गंध हूँ, अग्नि में तेज हूँ, सभी प्राणियों का जीवन हूँ और तपस्वियों का तप हूँ। यह दर्शाता है कि प्रत्येक वस्तु की मूलभूत शक्ति और सौंदर्य भगवान की ही देन है। जब साधक पृथ्वी की सुगंध या अग्नि का तेज देखता है, तो उसे समझना चाहिए कि यह सब ईश्वर की अभिव्यक्ति है। इसी प्रकार प्राणियों की जीवनशक्ति और तपस्वियों की कठोर साधना भी परमात्मा से ही आती है। इस शिक्षा से साधक को प्रेरणा मिलती है कि ईश्वर से अलग कुछ भी अस्तित्व में नहीं है।",
        englishMeaning = "I am the pure fragrance of the earth, the brilliance in fire, the life in all beings, and the austerity of the ascetics."
    ),
    Shloka(
        number = 10,
        sanskrit = "बीजं मां सर्वभूतानां विद्धि पार्थ सनातनम् ।\nबुद्धिर्बुद्धिमतामस्मि तेजस्तेजस्विनामहम् ॥",
        hindiMeaning = "भगवान कहते हैं – हे पार्थ! जान लो कि मैं ही सभी प्राणियों का सनातन बीज हूँ। मैं बुद्धिमानों की बुद्धि हूँ और तेजस्वियों का तेज हूँ। इसका अर्थ यह है कि संसार में किसी भी शक्ति या गुण का अंतिम स्रोत ईश्वर ही हैं। चाहे वह ज्ञान हो, सामर्थ्य हो या तेज, सब भगवान की ही अभिव्यक्ति है। साधक को यह जानकर अहंकार छोड़कर विनम्रता से ईश्वर की शरण लेनी चाहिए। यह समझ हमें यह भी सिखाती है कि भगवान के बिना किसी भी गुण या सामर्थ्य का अस्तित्व संभव नहीं।",
        englishMeaning = "O Arjuna, know that I am the eternal seed of all beings. I am the intellect of the intelligent and the splendor of the powerful."
    ),
    Shloka(
        number = 11,
        sanskrit = "बलं बलवतां चाहं कामरागविवर्जितम् ।\nधर्माविरुद्धो भूतेषु कामोऽस्मि भरतर्षभ ॥",
        hindiMeaning = "भगवान कहते हैं – मैं बलवानों का बल हूँ, जो कामना और राग से रहित है। और मैं धर्म के अनुकूल इच्छा हूँ। इसका तात्पर्य है कि वास्तविक बल वह है, जिसमें स्वार्थ और वासना का प्रभाव न हो। ऐसा बल शुद्ध और सात्विक होता है, जो केवल धर्म और न्याय की रक्षा के लिए प्रयोग किया जाता है। इसी प्रकार, इच्छाएँ भी तब तक उचित हैं जब तक वे धर्म के विरुद्ध न हों। साधक को यह सीख मिलती है कि बल और कामना दोनों का शुद्ध स्वरूप भी भगवान से ही आता है।",
        englishMeaning = "I am the strength of the strong, free from desire and passion. I am the desire in beings that is in harmony with righteousness."
    ),
    Shloka(
        number = 12,
        sanskrit = "ये चैव सात्त्विका भावा राजसास्तामसाश्च ये ।\nमत्त एवेति तान्विद्धि न त्वहं तेषु ते मयि ॥",
        hindiMeaning = "भगवान कहते हैं कि जो भी भाव सात्त्विक, राजसिक या तामसिक हैं, वे सब मुझसे ही उत्पन्न हुए हैं। परंतु मैं उन गुणों में बंधा नहीं हूँ, बल्कि वे सब मुझमें स्थित हैं। इसका अर्थ यह है कि ईश्वर स्वयं गुणातीत हैं। तीनों गुणों से प्रभावित होकर जीव बंधन में फँसता है, जबकि भगवान इनसे परे हैं। इसलिए साधक को यह समझना चाहिए कि भले ही सब गुण ईश्वर से आए हों, पर ईश्वर स्वयं उन गुणों से अप्रभावित रहते हैं। यह शिक्षा हमें प्रेरित करती है कि हम भी धीरे-धीरे गुणातीत बनने का प्रयास करें।",
        englishMeaning = "All states of being—goodness, passion, and ignorance—are created by Me. Yet I am not in them; they are in Me."
    ),
    Shloka(
        number = 13,
        sanskrit = "त्रिभिर्गुणमयैर्भावैरेभिः सर्वमिदं जगत् ।\nमोहितं नाभिजानाति मामेभ्य: परमव्ययम् ॥",
        hindiMeaning = "भगवान बताते हैं कि यह सम्पूर्ण जगत तीनों गुणों – सात्त्विक, राजसिक और तामसिक – से मोहित है। इसलिए लोग मुझे, जो इन गुणों से परे और अविनाशी हूँ, वास्तविकता में नहीं पहचान पाते। मनुष्य अपने अहंकार और वासनाओं में उलझा रहता है और उसे ईश्वर का तत्त्वज्ञान नहीं मिलता। इसी कारण साधारण लोग भगवान के स्वरूप को नहीं समझते। यह श्लोक हमें सिखाता है कि यदि हमें ईश्वर को जानना है, तो गुणों के प्रभाव से ऊपर उठना होगा। जब तक मनुष्य गुणों में फँसा रहेगा, वह परम सत्य को नहीं समझ सकता।",
        englishMeaning = "Deluded by the three modes of nature, the entire world fails to recognize Me, who am above them and inexhaustible."
    ),
    Shloka(
        number = 14,
        sanskrit = "दैवी ह्येषा गुणमयी मम माया दुरत्यया ।\nमामेव ये प्रपद्यन्ते मायामेतां तरन्ति ते ॥",
        hindiMeaning = "भगवान कहते हैं कि मेरी यह दिव्य माया, जो तीनों गुणों से बनी है, अत्यंत कठिन है पार करना। लेकिन जो साधक पूरी तरह मेरी शरण में आता है, वह इस माया को पार कर जाता है। इसका तात्पर्य यह है कि केवल मानव प्रयासों से माया का बंधन नहीं टूट सकता, इसके लिए ईश्वर की शरण ही उपाय है। जब मनुष्य अहंकार छोड़कर ईश्वर की कृपा का आश्रय लेता है, तभी वह संसारिक भ्रम और बंधन से मुक्त हो सकता है। यह श्लोक बताता है कि ईश्वर-शरणागति ही मुक्ति का मार्ग है।",
        englishMeaning = "This divine energy of Mine, consisting of the three modes of nature, is very difficult to overcome. But those who surrender to Me alone cross beyond it."
    ),
    Shloka(
        number = 15,
        sanskrit = "न मां दुष्कृतिनो मूढा: प्रपद्यन्ते नराधमा: ।\nमाययापहृतज्ञाना आसुरं भावमाश्रिता: ॥",
        hindiMeaning = "भगवान कहते हैं कि दुष्कर्म करने वाले, मूर्ख, पापात्मा और अधम मनुष्य मेरी शरण नहीं लेते। उनकी बुद्धि माया द्वारा हर ली जाती है और वे आसुरी भाव में रहते हैं। ऐसे लोग सत्य से दूर होकर केवल भौतिक सुख और अहंकार में फँसे रहते हैं। परिणामस्वरूप वे ईश्वर की ओर आकर्षित नहीं होते। इस श्लोक से यह शिक्षा मिलती है कि यदि कोई व्यक्ति आसुरी वृत्तियों और अज्ञान में लिप्त है, तो वह भगवान की शरण नहीं ले पाएगा। लेकिन जब कोई साधक विनम्र होकर सत्य की ओर अग्रसर होता है, तभी वह दिव्यता को प्राप्त करता है।",
        englishMeaning = "The foolish, the deluded, and the lowest of mankind do not surrender to Me. Their knowledge is stolen by illusion, and they take refuge in a demonic nature."
    ),
    Shloka(
        number = 16,
        sanskrit = "चतुर्विधा भजन्ते मां जनाः सुकृतिनोऽर्जुन ।\nआर्तो जिज्ञासुरर्थार्थी ज्ञानी च भरतर्षभ ॥",
        hindiMeaning = "भगवान कहते हैं कि चार प्रकार के पुण्यात्मा लोग मेरी भक्ति करते हैं – आर्त, जिज्ञासु, अर्थार्थी और ज्ञानी। आर्त वह है जो दुख और संकट से पीड़ित होकर भगवान को याद करता है। जिज्ञासु वह है जिसे आध्यात्मिक ज्ञान की जिज्ञासा है और वह भगवान को जानने का प्रयास करता है। अर्थार्थी वह है जो सांसारिक लाभ और समृद्धि की कामना से ईश्वर की शरण में आता है। ज्ञानी वह है जो भगवान को ही सर्वोच्च मानकर निःस्वार्थ भाव से उनकी भक्ति करता है। इस श्लोक से यह स्पष्ट होता है कि भगवान सभी भक्तों का स्वागत करते हैं, चाहे उनकी भावना कैसी भी हो।",
        englishMeaning = "O Arjuna, four kinds of people worship Me: the distressed, the inquisitive, those seeking material gain, and the wise."
    ),
    Shloka(
        number = 17,
        sanskrit = "तेषां ज्ञानी नित्ययुक्त एकभक्तिर्विशिष्यते ।\nप्रियो हि ज्ञानिनोऽत्यर्थमहं स च मम प्रियः ॥",
        hindiMeaning = "भगवान कहते हैं कि उन चार प्रकार के भक्तों में ज्ञानी सबसे श्रेष्ठ है। वह निरंतर भगवान से जुड़ा रहता है और एकनिष्ठ भक्ति करता है। ऐसा ज्ञानी भगवान को अत्यंत प्रिय होता है और भगवान भी उसे प्रिय मानते हैं। यहाँ यह संदेश है कि निःस्वार्थ भाव से, केवल ईश्वर को ही सर्वोच्च मानकर की गई भक्ति ही सबसे महान है। बाकी भक्त भी भगवान तक पहुँचते हैं, लेकिन ज्ञानी का मार्ग सबसे उच्च है। इससे हमें शिक्षा मिलती है कि ज्ञान और भक्ति का संगम ही भक्त को ईश्वर के समीप लाता है।",
        englishMeaning = "Of these, the wise one, who is ever steadfast and devoted to Me alone, is the best. He is very dear to Me, and I am very dear to him."
    ),
    Shloka(
        number = 18,
        sanskrit = "उदाराः सर्व एवैते ज्ञानी त्वात्मैव मे मतम् ।\nआस्थितः स हि युक्तात्मा मामेवानुत्तमां गतिम् ॥",
        hindiMeaning = "भगवान कहते हैं कि सभी प्रकार के भक्त उदार और पुण्यात्मा हैं, लेकिन ज्ञानी तो मेरे समान ही माना जा सकता है। उसका आत्मा मुझमें स्थिर रहता है और वह मुझे ही सर्वोच्च गंतव्य मानता है। इसका अर्थ यह है कि ज्ञानी और भगवान का संबंध अत्यंत घनिष्ठ है। वह भगवान में लीन होकर अपने जीवन का लक्ष्य केवल उन्हें ही मानता है। यह श्लोक बताता है कि भक्ति के सभी रूप मूल्यवान हैं, परंतु ज्ञानयुक्त भक्ति सबसे ऊँची मानी जाती है। ज्ञानी भक्त का जीवन ही ईश्वर की ओर अग्रसर रहता है।",
        englishMeaning = "All these devotees are noble, but I consider the wise one as My very self. With a steady mind, he is established in Me as the supreme goal."
    ),
    Shloka(
        number = 19,
        sanskrit = "बहूनां जन्मनामन्ते ज्ञानवान्मां प्रपद्यते ।\nवासुदेवः सर्वमिति स महात्मा सुदुर्लभः ॥",
        hindiMeaning = "भगवान कहते हैं कि अनेक जन्मों के अंत में ज्ञानी यह निष्कर्ष निकालता है कि ‘वासुदेव ही सब कुछ हैं’। तब वह मेरी शरण में आता है। ऐसा महात्मा अत्यंत दुर्लभ है। इसका तात्पर्य यह है कि आत्मा को सत्य की पहचान और ईश्वर की महत्ता समझने में अनेक जन्मों का अनुभव आवश्यक होता है। अंततः जब आत्मा इस निष्कर्ष पर पहुँचती है कि भगवान ही सर्वस्व हैं, तभी वह पूर्ण समर्पण करता है। यह श्लोक साधक को धैर्य और निरंतरता का संदेश देता है कि अंततः सच्चा समर्पण ही मुक्ति का मार्ग है।",
        englishMeaning = "After many births, the wise one surrenders to Me, realizing that Vasudeva is everything. Such a great soul is very rare."
    ),
    Shloka(
        number = 20,
        sanskrit = "कामैस्तैस्तैर्हृतज्ञानाः प्रपद्यन्तेऽन्यदेवताः ।\nतं तं नियममास्थाय प्रकृत्या नियताः स्वया ॥",
        hindiMeaning = "भगवान बताते हैं कि जिनका ज्ञान कामनाओं द्वारा ढक लिया जाता है, वे अन्य देवताओं की शरण लेते हैं। वे अपनी-अपनी प्रकृति के अनुसार नियमों का पालन करते हुए पूजा करते हैं। इसका अर्थ यह है कि सांसारिक इच्छाएँ मनुष्य को विभ्रमित करती हैं और उसे विभिन्न देवताओं की ओर आकर्षित करती हैं। परंतु वह यह नहीं समझ पाता कि सभी शक्तियों का स्रोत एक ही परमात्मा है। यह श्लोक हमें यह शिक्षा देता है कि विविध देवताओं की पूजा भी अंततः ईश्वर तक ही ले जाती है, लेकिन यह मार्ग अप्रत्यक्ष और अपूर्ण है।",
        englishMeaning = "Those whose knowledge is carried away by desires surrender to other deities, following particular rules and worshipping according to their own nature."
    ),
    Shloka(
        number = 21,
        sanskrit = "यो यो यां यां तनुं भक्तः श्रद्धयार्चितुमिच्छति ।\nतस्य तस्याचलां श्रद्धां तामेव विदधाम्यहम् ॥",
        hindiMeaning = "भगवान कहते हैं कि जो भी भक्त किसी विशेष देवता की श्रद्धापूर्वक पूजा करना चाहता है, मैं ही उसकी श्रद्धा को दृढ़ करता हूँ। इसका अर्थ यह है कि सभी प्रकार की श्रद्धा और भक्ति की जड़ भी भगवान ही हैं। भक्त चाहे किसी देवता की पूजा करे, वास्तव में वह शक्ति भगवान से ही प्राप्त होती है। यह श्लोक बताता है कि ईश्वर ही सभी विश्वासों और आस्थाओं का आधार हैं। साधक को यह समझना चाहिए कि विविध रूपों की पूजा का अंतिम लक्ष्य परमात्मा ही है।",
        englishMeaning = "Whatever deity a devotee wishes to worship with faith, I make that faith steady in him."
    ),
    Shloka(
        number = 22,
        sanskrit = "स तया श्रद्धया युक्तस्तस्याराधनमीहते ।\nलभते च ततः कामान्मयैव विहितान्हि तान् ॥",
        hindiMeaning = "भगवान कहते हैं कि जब भक्त अपनी दृढ़ श्रद्धा से किसी देवता की पूजा करता है, तो उसे इच्छित फल मिलता है। परंतु वह फल वास्तव में भगवान की ही अनुमति और व्यवस्था से प्राप्त होता है। इसका तात्पर्य यह है कि देवताओं के द्वारा दिया गया वरदान भी अंततः ईश्वर की शक्ति से ही आता है। भक्त को यह समझना चाहिए कि सभी फल और परिणाम परमात्मा से ही सुनिश्चित होते हैं। इस शिक्षा से यह स्पष्ट होता है कि ईश्वर ही सभी इच्छाओं और फलों के अंतिम दाता हैं।",
        englishMeaning = "Endowed with that faith, he worships that deity and obtains his desires. But in reality, those benefits are given by Me alone."
    ),
    Shloka(
        number = 23,
        sanskrit = "अन्तवत्तु फलं तेषां तद्भवत्यल्पमेधसाम् ।\nदेवान्देवयजो यान्ति मद्भक्ता यान्ति मामपि ॥",
        hindiMeaning = "भगवान कहते हैं कि अल्प बुद्धि वाले लोग देवताओं की पूजा करके जो फल प्राप्त करते हैं, वह नश्वर और सीमित होता है। देवताओं की पूजा करने वाले देवताओं के लोक को प्राप्त होते हैं। परंतु जो भक्त मेरी भक्ति करते हैं, वे अंततः मेरे पास आते हैं। इसका अर्थ यह है कि देवताओं की पूजा से अस्थायी सुख मिलता है, जबकि भगवान की भक्ति से शाश्वत मुक्ति प्राप्त होती है। यह श्लोक भक्त को प्रेरित करता है कि वह स्थायी और सर्वोच्च लक्ष्य के लिए भगवान की शरण ले।",
        englishMeaning = "But the fruit gained by these people is temporary. Worshippers of the gods go to the gods, but My devotees come to Me."
    ),
    Shloka(
        number = 24,
        sanskrit = "अव्यक्तं व्यकтимापन्नं मन्यन्ते मामबुद्धयः ।\nपरं भावमजानन्तो ममाव्ययमनुत्तमम् ॥",
        hindiMeaning = "भगवान कहते हैं कि अज्ञानी लोग मुझे अव्यक्त से व्यक्त हुआ मानते हैं। वे मेरे परम, अविनाशी और सर्वोच्च स्वरूप को नहीं जानते। यह भ्रांति उनके सीमित दृष्टिकोण के कारण है। वे केवल भौतिक रूप देखते हैं और ईश्वर के शाश्वत, निराकार स्वरूप को नहीं पहचान पाते। इस श्लोक से यह शिक्षा मिलती है कि वास्तविक ज्ञान वह है जो भगवान की अनंत और शाश्वत सत्ता को समझता है।",
        englishMeaning = "Foolish people think of Me as having assumed this form from the unmanifest. They do not know My higher, imperishable, supreme nature."
    ),
    Shloka(
        number = 25,
        sanskrit = "नाहं प्रकाशः सर्वस्य योगमायासमावृतः ।\nमूढोऽयं नाभिजानाति लोको मामजमव्ययम् ॥",
        hindiMeaning = "भगवान कहते हैं कि मैं सबके सामने प्रकट नहीं होता, क्योंकि मैं अपनी योगमाया से आवृत रहता हूँ। इसलिए अज्ञान से ग्रस्त लोग मुझे, जो अजन्मा और अविनाशी हूँ, नहीं पहचान पाते। इसका अर्थ है कि भगवान केवल उन भक्तों के लिए प्रकट होते हैं जो सच्चे भाव से उन्हें खोजते हैं। बाकी लोग अपनी अज्ञानता और मोह के कारण उनकी वास्तविकता को नहीं जान पाते। यह श्लोक हमें यह समझाता है कि भगवान का दर्शन पाने के लिए योगमाया से परे उठना आवश्यक है।",
        englishMeaning = "I am not manifest to all, being veiled by My yoga-maya. The deluded world does not recognize Me, who am unborn and imperishable."
    ),
    Shloka(
        number = 26,
        sanskrit = "वेदाहं समतीतानि वर्तमानानि चार्जुन ।\nभविष्याणि च भूतानि मां तु वेद न कश्चन ॥",
        hindiMeaning = "भगवान कहते हैं कि मैं भूत, वर्तमान और भविष्य – सभी प्राणियों को जानता हूँ। परंतु कोई मुझे वास्तविकता में नहीं जान पाता। इसका तात्पर्य यह है कि ईश्वर सर्वज्ञ हैं और समय के तीनों काल उनके लिए स्पष्ट हैं। लेकिन जीव सीमित बुद्धि और अज्ञान से बंधा होता है। इसलिए वह भगवान की अनंत महिमा और ज्ञान को नहीं समझ पाता। यह श्लोक साधक को यह संदेश देता है कि केवल भगवान ही संपूर्ण सत्य को जानते हैं।",
        englishMeaning = "O Arjuna, I know all beings of the past, present, and future. But no one truly knows Me."
    ),
    Shloka(
        number = 27,
        sanskrit = "इच्छाद्वेषसमुत्थेन द्वन्द्वमोहेन भारत ।\nसर्वभूतानि सम्मोहं सर्गे यान्ति परन्तप ॥",
        hindiMeaning = "भगवान कहते हैं कि इच्छाओं और द्वेष से उत्पन्न द्वंद्व के कारण सभी प्राणी जन्म के समय मोह में पड़ जाते हैं। यह मोह उन्हें सत्य से दूर कर देता है। जब तक जीव इन द्वंद्वों में फँसा रहता है, तब तक वह ईश्वर को नहीं पहचान पाता। इसका अर्थ है कि आसक्ति और विरोध दोनों ही आत्मज्ञान में बाधा डालते हैं। यह श्लोक हमें सिखाता है कि द्वंद्व से मुक्त होकर ही भगवान की ओर बढ़ा जा सकता है।",
        englishMeaning = "O Arjuna, through the delusion of dualities arising from desire and hatred, all beings fall into delusion at birth."
    ),
    Shloka(
        number = 28,
        sanskrit = "येषां त्वन्तगतं पापं जनानां पुण्यकर्मणाम् ।\nते द्वन्द्वमोहनिर्मुक्ता भजन्ते मां दृढव्रता: ॥",
        hindiMeaning = "भगवान कहते हैं कि जिन लोगों के पाप नष्ट हो गए हैं और जो पुण्यकर्म करने वाले हैं, वे द्वंद्व-मोह से मुक्त होकर मेरी भक्ति करते हैं। वे दृढ़ निश्चय से मुझे ही अपनाते हैं। इसका अर्थ यह है कि शुद्ध मन और पुण्य कर्म से परिपूर्ण व्यक्ति ही भगवान की ओर सहज आकर्षित होता है। यह श्लोक सिखाता है कि जब मनुष्य पाप और मोह से मुक्त हो जाता है, तभी वह ईश्वर-भक्ति में दृढ़ रह पाता है।",
        englishMeaning = "But those whose sins have ended, who act virtuously, freed from delusion of dualities, they worship Me with firm determination."
    ),
    Shloka(
        number = 29,
        sanskrit = "जरामरणमोक्षाय मामाश्रित्य यतन्ति ये ।\nते ब्रह्म तद्विदुः कृत्स्नमध्यात्मं कर्म चाखिलम् ॥",
        hindiMeaning = "भगवान कहते हैं कि जो लोग जरा और मृत्यु से मुक्ति पाने के लिए मेरी शरण लेते हैं, वे ब्रह्म को, आत्मा को और संपूर्ण कर्म को भली-भांति जानते हैं। इसका अर्थ यह है कि मुक्ति चाहने वाला साधक जब भगवान की शरण लेता है, तो उसे परम सत्य का ज्ञान हो जाता है। वह आत्मा और परमात्मा के संबंध को समझ लेता है। यह श्लोक बताता है कि मुक्ति का मार्ग केवल ईश्वर की शरणागति से ही संभव है।",
        englishMeaning = "Those who strive for liberation from old age and death take refuge in Me. They know Brahman, the Self, and the entire field of action."
    ),
    Shloka(
        number = 30,
        sanskrit = "साधिभूताधिदैवं मां साधियज्ञं च ये विदुः ।\nप्रयाणकालेऽपि च मां ते विदुर्युक्तचेतसः ॥",
        hindiMeaning = "भगवान कहते हैं कि जो साधक मुझे अधिभूत, अधिदैव और अधियज्ञ रूप में जान लेते हैं, वे अंतिम समय में भी मुझे जान पाते हैं। इसका अर्थ यह है कि जिसने जीवनभर भगवान के विविध स्वरूपों को समझ लिया है, वह मृत्यु के समय भी उनसे एकत्व प्राप्त कर लेता है। यह श्लोक साधक को यह आश्वासन देता है कि यदि वह निरंतर भक्ति और ज्ञान में स्थित रहे, तो मृत्यु भी उसे ईश्वर से अलग नहीं कर सकती। यह अंततः मोक्ष का मार्ग है।",
        englishMeaning = "Those who know Me as the governing principle of beings, deities, and sacrifice, with their minds steadfast, understand Me even at the time of death."
    )


)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaSevenScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 7 – ज्ञान विज्ञान योग",
                        fontSize = 26.sp, // ✅ match other chapters
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
                onClick = { navController.navigate(Screen.QuizSeven.route) },
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
            // ✅ Top Image for Adhyaya 7
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
                        painter = painterResource(R.drawable.gemini_generated_image_xb3ysgxb3ysgxb3y),
                        contentDescription = "Chapter 7 – Jnana Vijnana Yoga",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shloka list
            items(adhyayaSevenShlokas) { shloka ->
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
