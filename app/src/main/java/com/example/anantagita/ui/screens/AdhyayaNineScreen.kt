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

val adhyayaNineShlokas= listOf(
    Shloka(
        number = 1,
        sanskrit = "श्रीभगवानुवाच ।\nइदं तु ते गुह्यतमं प्रवक्ष्याम्यनसूयवे ।\nज्ञानं विज्ञानसहितं यज्ज्ञात्वा मोक्ष्यसेऽशुभात् ॥",
        hindiMeaning = "भगवान श्रीकृष्ण अर्जुन से कहते हैं – हे अनसूयक (निर्दोष) अर्जुन! मैं अब तुझे यह परम गुप्ततम ज्ञान बताऊँगा, जो विज्ञान सहित है। इसे जानकर तू सब अशुभ से मुक्त हो जाएगा। यहाँ ‘गुह्यतम’ का अर्थ है सबसे गोपनीय, क्योंकि यह ज्ञान सामान्य जन तक नहीं पहुँचता, केवल श्रद्धा और निष्कपट भाव वाले साधक ही इसे समझ सकते हैं। यह ज्ञान केवल सैद्धांतिक नहीं है, बल्कि अनुभवजन्य भी है, इसलिए इसे विज्ञान सहित कहा गया है। जब साधक इसे समझता है, तो जीवन के सारे बंधन और क्लेश मिट जाते हैं। यह श्लोक साधक को बताता है कि ईश्वर का ज्ञान केवल अध्ययन से नहीं, बल्कि निष्कपट श्रद्धा और भक्ति से ही पाया जा सकता है।",
        englishMeaning = "The Blessed Lord said: To you, who are free from envy, I shall declare this most confidential knowledge along with realization. Knowing it, you shall be liberated from all misfortune."
    ),
    Shloka(
        number = 2,
        sanskrit = "राजविद्या राजगुह्यं पवित्रमिदमुत्तमम् ।\nप्रत्यक्षावगमं धर्म्यं सुसुखं कर्तुमव्ययम् ॥",
        hindiMeaning = "भगवान कहते हैं – यह ज्ञान राजविद्या है, अर्थात् सभी विद्याओं में श्रेष्ठ है। यह राजगुह्य है, क्योंकि यह सभी रहस्यों में सबसे गुप्त है। यह पवित्र और उत्तम है। इसे प्रत्यक्ष अनुभव किया जा सकता है और यह धर्मानुकूल है। इसे करना बहुत सरल है और इसका फल अविनाशी है। इस श्लोक में भगवान इस ज्ञान की महिमा बताते हैं, कि यह केवल बौद्धिक विचार नहीं, बल्कि साधक को सीधा अनुभव कराने वाला है। यह साधना सहज और सरल है, क्योंकि इसमें केवल भक्ति और श्रद्धा की आवश्यकता है।",
        englishMeaning = "This knowledge is the king of sciences, the king of secrets, the most sacred, and it can be directly experienced. It is righteous, easy to practice, and imperishable."
    ),
    Shloka(
        number = 3,
        sanskrit = "अश्रद्दधानाः पुरुषा धर्मस्यास्य परन्तप ।\nअप्राप्य मां निवर्तन्ते मृत्युसंसारवर्त्मनि ॥",
        hindiMeaning = "भगवान कहते हैं – हे परन्तप अर्जुन! जो लोग इस धर्म में श्रद्धा नहीं रखते, वे मुझे प्राप्त नहीं करते। वे मृत्यु और संसार के चक्र में लौट आते हैं। इसका तात्पर्य है कि श्रद्धा के बिना साधना निष्फल है। केवल बुद्धि या तर्क से ईश्वर को नहीं पाया जा सकता। श्रद्धा वह द्वार है, जो भक्ति और योग के मार्ग को खोलती है। जो व्यक्ति इसे नहीं अपनाता, वह संसार के जन्म-मरण के चक्र में भटकता रहता है।",
        englishMeaning = "Those who lack faith in this dharma, O Arjuna, do not attain Me. They return to the path of birth and death in this world."
    ),
    Shloka(
        number = 4,
        sanskrit = "मया ततमिदं सर्वं जगदव्यक्तमूर्तिना ।\nमत्स्थानि सर्वभूतानि न चाहं तेष्ववस्थितः ॥",
        hindiMeaning = "भगवान कहते हैं – यह समस्त जगत मेरी अव्यक्त मूर्ति से व्याप्त है। सभी प्राणी मुझमें स्थित हैं, परंतु मैं उनमें स्थित नहीं हूँ। इसका अर्थ है कि ईश्वर सर्वव्यापक है, वह सृष्टि के हर कण में व्याप्त है। फिर भी उनकी स्वतंत्र सत्ता है, वे किसी विशेष वस्तु या जीव में सीमित नहीं हैं। यह श्लोक साधक को यह समझाता है कि परमात्मा अदृश्य होकर भी सबमें समाहित है। जीव उनसे अलग नहीं, बल्कि उसी का अंश है।",
        englishMeaning = "By My unmanifest form, this entire universe is pervaded. All beings are in Me, yet I am not in them."
    ),
    Shloka(
        number = 5,
        sanskrit = "न च मत्स्थानि भूतानि पश्य मे योगमैश्वरम् ।\nभूतभृन्न च भूतस्थो ममात्मा भूतभावनः ॥",
        hindiMeaning = "भगवान कहते हैं – वास्तव में प्राणी मुझमें स्थित नहीं हैं, यह मेरा दिव्य योग है। मैं सभी भूतों का धारणकर्ता और उत्पन्न करने वाला हूँ, परंतु फिर भी उनमें स्थित नहीं हूँ। यह विरोधाभास जैसा प्रतीत होता है, परंतु यही ईश्वर की अद्भुत लीला है। वे सर्वत्र हैं और फिर भी अपनी दिव्यता में निरपेक्ष रहते हैं। यह श्लोक साधक को ईश्वर की महिमा और उनकी असीम शक्ति का अनुभव कराता है।",
        englishMeaning = "And yet beings are not in Me. Behold My divine mystery! I support all beings, bring them into existence, yet I am not situated in them."
    ),
    Shloka(
        number = 6,
        sanskrit = "यथाकाशस्थितो नित्यं वायु: सर्वत्रगो महान् ।\nतथा सर्वाणि भूतानि मत्स्थानीत्युपधारय ॥",
        hindiMeaning = "भगवान उदाहरण देते हैं – जैसे आकाश में वायु हमेशा विद्यमान रहती है और सर्वत्र गति करती है, वैसे ही सभी प्राणी मुझमें स्थित हैं। यहाँ भगवान यह स्पष्ट कर रहे हैं कि जीव और जगत ईश्वर में ही आधार पाते हैं। आकाश सर्वव्यापक होते हुए भी स्वतंत्र है, उसी प्रकार ईश्वर सबका आधार होकर भी उनसे परे हैं। यह श्लोक जीव और परमात्मा के संबंध को सरल ढंग से समझाता है।",
        englishMeaning = "As the mighty wind, moving everywhere, always rests in space, so all beings rest in Me."
    ),
    Shloka(
        number = 7,
        sanskrit = "सर्वभूतानि कौन्तेय प्रकृतिं यान्ति मामिकाम् ।\nकल्पक्षये पुनस्तानि कल्पादौ विसृजाम्यहम् ॥",
        hindiMeaning = "भगवान कहते हैं – हे कुन्तीपुत्र! कल्प के अंत में सभी प्राणी मेरी प्रकृति में लीन हो जाते हैं। और कल्प के आरंभ में मैं उन्हें पुनः उत्पन्न करता हूँ। इसका अर्थ है कि सृष्टि का चक्र निरंतर चलता रहता है। भगवान ही इस उत्पत्ति और प्रलय के कर्ता हैं। जीव उनका ही अंश हैं, जो समय-समय पर प्रकट और लीन होते रहते हैं। यह श्लोक साधक को सृष्टि के दिव्य रहस्य को समझाता है।",
        englishMeaning = "At the end of a kalpa, all beings merge into My nature, and at the beginning of the next kalpa, I again manifest them."
    ),
    Shloka(
        number = 8,
        sanskrit = "प्रकृतिं स्वामवष्टभ्य विसृजामि पुन: पुन: ।\nभूतग्राममिमं कृत्स्नमवशं प्रकृतेर्वशात् ॥",
        hindiMeaning = "भगवान कहते हैं – अपनी ही प्रकृति को धारण करके मैं इस संपूर्ण प्राणी समूह को बार-बार उत्पन्न करता हूँ। वे सब प्रकृति के वश में होकर उत्पन्न होते हैं। इसका तात्पर्य है कि जीव स्वतंत्र रूप से प्रकट नहीं होते, बल्कि ईश्वर की शक्ति से ही उनका अस्तित्व होता है। यहाँ भगवान अपनी सृष्टि करने की लीला को स्पष्ट करते हैं। यह श्लोक साधक को यह स्मरण दिलाता है कि जीव प्रकृति के बंधन से बँधे हैं, परंतु उसके स्वामी भगवान स्वयं हैं।",
        englishMeaning = "Controlling My own material nature, I manifest again and again this whole multitude of beings, helpless under the sway of nature."
    ),
    Shloka(
        number = 9,
        sanskrit = "न च मां तानि कर्माणि निबध्नन्ति धनञ्जय ।\nउदासीनवदासीनमसक्तं तेषु कर्मसु ॥",
        hindiMeaning = "भगवान कहते हैं – हे धनंजय! ये कर्म मुझे बाँधते नहीं हैं। मैं उन सब कर्मों में असक्त और उदासीन-सा रहता हूँ। इसका अर्थ है कि सृष्टि का संचालन भगवान करते हैं, परंतु वे उससे बँधते नहीं हैं। जीव अपने कर्म से बंधन में पड़ते हैं, परंतु परमात्मा निरपेक्ष रहते हैं। यह श्लोक साधक को यह शिक्षा देता है कि आसक्ति रहित होकर कर्म करना ही मोक्ष का मार्ग है।",
        englishMeaning = "These actions do not bind Me, O Arjuna. I remain unattached and indifferent to those actions."
    ),
    Shloka(
        number = 10,
        sanskrit = "मयाध्यक्षेण प्रकृतिः सूयते सचराचरम् ।\nहेतुनानेन कौन्तेय जगद्विपरिवर्तते ॥",
        hindiMeaning = "भगवान कहते हैं – हे कुन्तीपुत्र! मेरी अध्यक्षता में ही प्रकृति चलायमान होकर चराचर जगत को उत्पन्न करती है। यही कारण है कि जगत निरंतर चक्र में परिवर्तित होता रहता है। यह श्लोक ईश्वर को सृष्टि का परम नियंत्रक बताता है। प्रकृति भले ही कार्य करती है, परंतु उसकी प्रेरणा और नियंत्रण भगवान से ही होता है। साधक को यह समझना चाहिए कि सभी घटनाएँ ईश्वर की अनुमति और शक्ति से होती हैं।",
        englishMeaning = "Under My supervision, nature produces the moving and unmoving. Because of this, O Arjuna, the universe revolves."
    ),
    Shloka(
        number = 11,
        sanskrit = "अवजानन्ति मां मूढा मानुषीं तनुमाश्रितम् ।\nपरं भावमजानन्तो मम भूतमहेश्वरम् ॥",
        hindiMeaning = "भगवान कहते हैं – मूर्ख लोग मेरी मानवीय देह को देखकर मुझे साधारण मनुष्य समझ लेते हैं। वे मेरे परम दिव्य स्वरूप और मेरे द्वारा सभी प्राणियों के स्वामी होने को नहीं जानते। यह श्लोक बताता है कि ईश्वर जब अवतार लेकर मानव रूप में आते हैं, तो सामान्य लोग उनकी दिव्यता को पहचान नहीं पाते। वे केवल बाह्य रूप देखते हैं और उनके परब्रह्म स्वरूप को नहीं समझते। यह अज्ञान ही उनका बंधन है।",
        englishMeaning = "Fools disregard Me when I appear in human form. They do not know My higher nature as the great Lord of beings."
    ),
    Shloka(
        number = 12,
        sanskrit = "मोघाशा मोघकर्माणो मोघज्ञाना विचेतसः ।\nराक्षसीमासुरीं चैव प्रकृतिं मोहिनीं श्रिताः ॥",
        hindiMeaning = "भगवान कहते हैं – जिनकी आशाएँ व्यर्थ हैं, जिनके कर्म निष्फल हैं और जिनका ज्ञान व्यर्थ है, वे अज्ञानी लोग राक्षसी और आसुरी प्रकृति को धारण करते हैं। यह श्लोक उन लोगों का वर्णन करता है जो अहंकार और अज्ञान से ईश्वर को नकारते हैं। उनके जीवन में भटकाव और दुःख ही मिलता है। क्योंकि उनकी चेतना मायावी और मोहिनी प्रकृति में फँसी रहती है। साधक को सावधान किया गया है कि आसुरी प्रवृत्तियाँ ईश्वर से दूर ले जाती हैं।",
        englishMeaning = "Vain are their hopes, vain their actions, vain their knowledge; senseless, they follow the deluding nature of demons and atheists."
    ),
    Shloka(
        number = 13,
        sanskrit = "महात्मानस्तु मां पार्थ दैवीं प्रकृतिमाश्रिताः ।\nभजन्त्यनन्यमनसो ज्ञात्वा भूतादिमव्ययम् ॥",
        hindiMeaning = "भगवान कहते हैं – परंतु हे पार्थ! महात्मा लोग दैवी प्रकृति को धारण करके, मुझे अविनाशी और सबका आदि जानकर, एकनिष्ठ भाव से भजन करते हैं। यह श्लोक महात्माओं की विशेषता को बताता है। वे आसुरी प्रवृत्तियों से दूर होकर भक्ति और दिव्यता के मार्ग को अपनाते हैं। उनकी भक्ति अनन्य और शुद्ध होती है। ऐसा साधक संसार से ऊपर उठकर ईश्वर से सीधा संबंध जोड़ता है।",
        englishMeaning = "But the great souls, O Arjuna, taking refuge in the divine nature, worship Me with undivided mind, knowing Me as the imperishable source of beings."
    ),
    Shloka(
        number = 14,
        sanskrit = "सततं कीर्तयन्तो मां यतन्तश्च दृढव्रताः ।\nनमस्यन्तश्च मां भक्त्या नित्ययुक्ता उपासते ॥",
        hindiMeaning = "भगवान कहते हैं – महात्मा लोग निरंतर मेरा कीर्तन करते हैं, दृढ़ व्रत से प्रयास करते हैं, और भक्ति भाव से मुझे प्रणाम करते हैं। वे सदा योगयुक्त होकर मेरी उपासना करते हैं। यह श्लोक भक्तों के लक्षण बताता है। उनकी भक्ति केवल समयानुसार नहीं होती, बल्कि हर समय होती है। उनका जीवन ईश्वर के नाम और कीर्तन में ही समर्पित होता है। यही सच्ची भक्ति है।",
        englishMeaning = "Always chanting My glories, striving with firm vows, bowing down to Me with devotion, they worship Me, ever steadfast in their practice."
    ),
    Shloka(
        number = 15,
        sanskrit = "ज्ञानयज्ञेन चाप्यन्ये यजन्तो मामुपासते ।\nएकत्वेन पृथक्त्वेन बहुधा विश्वतोमुखम् ॥",
        hindiMeaning = "भगवान कहते हैं – अन्य भक्त मुझे ज्ञानयज्ञ के रूप में उपासना करते हैं। कोई मुझे एकत्व रूप में पूजता है, कोई पृथक रूप में, और कोई मुझे अनेक रूपों में, विश्वरूप में पूजता है। यह श्लोक बताता है कि भक्ति के अनेक रूप हैं। साधक अपनी श्रद्धा और समझ के अनुसार भगवान की पूजा करता है। परंतु सबका लक्ष्य एक ही है – ईश्वर की उपासना और भक्ति।",
        englishMeaning = "Others worship Me with the sacrifice of knowledge, seeing Me as one, as separate, or as manifold in the form of the universe."
    ),
    Shloka(
        number = 16,
        sanskrit = "अहं क्रतुरहं यज्ञः स्वधाहमहमौषधम् ।\nमन्त्रोऽहमहमेवाज्यमहमग्निरहं हुतम् ॥",
        hindiMeaning = "भगवान कहते हैं – मैं ही क्रतु हूँ, मैं ही यज्ञ हूँ, मैं ही स्वधा हूँ, मैं ही औषध हूँ। मैं ही मंत्र हूँ, मैं ही आज्य हूँ, मैं ही अग्नि हूँ और मैं ही आहुति हूँ। इसका अर्थ है कि यज्ञ में जो कुछ भी होता है, वह सब भगवान ही हैं। इस श्लोक में ईश्वर की सर्वव्यापकता का वर्णन है। यह साधक को यह समझाता है कि उपासना और कर्म सब ईश्वर में ही मिलते हैं।",
        englishMeaning = "I am the ritual, I am the sacrifice, I am the offering to the ancestors, I am the healing herb. I am the mantra, I am the clarified butter, I am the fire, and I am the oblation."
    ),
    Shloka(
        number = 17,
        sanskrit = "पिताहमस्य जगतो माता धाता पितामहः ।\nवेद्यं पवित्रमोङ्कार ऋक्साम यजुरेव च ॥",
        hindiMeaning = "भगवान कहते हैं – मैं इस जगत का पिता हूँ, माता हूँ, धारणकर्ता हूँ और पितामह हूँ। मैं ही वेद्य हूँ, पवित्र हूँ और ओंकार हूँ। मैं ही ऋक, साम और यजुर् वेद हूँ। यह श्लोक बताता है कि भगवान ही सृष्टि के आदि और अंत हैं। वे ही जगत के पोषक और आधार हैं। सभी वेद और ज्ञान भी उन्हीं में निहित हैं। साधक को समझना चाहिए कि जो कुछ है, सब ईश्वर ही है।",
        englishMeaning = "I am the father of this world, the mother, the sustainer, and the grandsire. I am the object of knowledge, the purifier, the syllable Om, and also the Rig, Sama, and Yajur Vedas."
    ),
    Shloka(
        number = 18,
        sanskrit = "गतिर्भर्ता प्रभुः साक्षी निवासः शरणं सुहृत् ।\nप्रभवः प्रलयः स्थानं निधानं बीजमव्ययम् ॥",
        hindiMeaning = "भगवान कहते हैं – मैं ही गति हूँ, भर्ता हूँ, प्रभु हूँ, साक्षी हूँ। मैं ही निवास हूँ, शरण हूँ और सच्चा मित्र हूँ। मैं ही उत्पत्ति, प्रलय, स्थान, निधान और अविनाशी बीज हूँ। इस श्लोक में भगवान अपनी सर्वगुणात्मक महिमा का वर्णन करते हैं। वे ही सबके रक्षक और साक्षी हैं। जीव का प्रत्येक संबंध अंततः भगवान से ही जुड़ता है।",
        englishMeaning = "I am the goal, the sustainer, the Lord, the witness, the abode, the refuge, the friend, the origin, the dissolution, the resting place, the repository, and the imperishable seed."
    ),
    Shloka(
        number = 19,
        sanskrit = "तपनाहमहमर्षिर्ग्रहाणामहमक्षयः ।\nअहमक्षयवृद्धिश्च धर्मोऽहमधमः तथा ॥",
        hindiMeaning = "भगवान कहते हैं – मैं ही सूर्य के रूप में तपन हूँ, मैं ही वर्षा देने वाला हूँ और मैं ही अमृत तथा मृत्यु हूँ। मैं ही सत् और असत् हूँ। इसका तात्पर्य यह है कि जीवन में जो कुछ भी दिखाई देता है, सबका मूल भगवान हैं। चाहे वह सुख हो या दुःख, जीवन हो या मृत्यु, सब उन्हीं से उत्पन्न होते हैं। साधक को यह समझना चाहिए कि परमात्मा ही सबका स्रोत है।",
        englishMeaning = "I give heat, I withhold and send forth the rain. I am immortality and also death; I am being and non-being."
    ),
    Shloka(
        number = 20,
        sanskrit = "त्रैविद्या मां सोमपाः पूतपापा यज्ञैरिष्ट्वा स्वर्गतिं प्रार्थयन्ते ।\nते पुण्यमासाद्य सुरेन्द्रलोकमश्नन्ति दिव्यान्दिवि देवभोगान् ॥",
        hindiMeaning = "भगवान कहते हैं – जो लोग तीनों वेदों के ज्ञाता हैं, सोमपान करते हैं और पापरहित होते हैं, वे यज्ञ द्वारा मुझे पूजकर स्वर्ग की इच्छा करते हैं। वे पुण्य प्राप्त करके इंद्र के लोक में जाते हैं और स्वर्ग के दिव्य सुखों का भोग करते हैं। यह श्लोक बताता है कि वेदपाठी और यज्ञकर्मी लोग स्वर्ग की कामना करते हैं। परंतु यह सुख क्षणभंगुर है। साधक को केवल स्वर्ग के सुख की नहीं, बल्कि परमात्मा की शाश्वत प्राप्ति की आकांक्षा रखनी चाहिए।",
        englishMeaning = "Those who study the Vedas, drink soma, and seek heaven, worship Me through sacrifices. They reach the pure world of Indra and enjoy the divine pleasures of the gods."
    ),
    Shloka(
        number = 21,
        sanskrit = "ते तं भुक्त्वा स्वर्गलोकं विशालं क्षीणे पुण्ये मर्त्यलोकं विशन्ति ।\nएवं त्रयीधर्ममनुप्रपन्ना गतागतं कामकामा लभन्ते ॥",
        hindiMeaning = "भगवान कहते हैं – वे लोग स्वर्ग के विशाल लोक में दिव्य भोग का उपभोग करने के बाद, जब उनका पुण्य समाप्त हो जाता है, तो पुनः मर्त्यलोक में लौट आते हैं। इस प्रकार वे लोग, जो वेदों के त्रैविद्य धर्म में लगे रहते हैं और केवल कामनाओं से प्रेरित होकर कर्म करते हैं, बार-बार आवागमन में पड़ते रहते हैं। यह श्लोक यह स्पष्ट करता है कि स्वर्ग भी स्थायी नहीं है। स्वर्ग प्राप्त करने वाले लोग अंततः पुनः जन्म-मरण के चक्र में बँध जाते हैं। इसलिए केवल स्वर्ग की आकांक्षा साधक के लिए अंतिम लक्ष्य नहीं हो सकती।",
        englishMeaning = "After enjoying the vast heaven, when their merit is exhausted, they return to the mortal world. Thus, those who follow the rituals of the Vedas, desiring pleasures, repeatedly come and go."
    ),
    Shloka(
        number = 22,
        sanskrit = "अनन्याश्चिन्तयन्तो मां ये जनाः पर्युपासते ।\nतेषां नित्याभियुक्तानां योगक्षेमं वहाम्यहम् ॥",
        hindiMeaning = "भगवान कहते हैं – जो लोग अनन्य भाव से मेरा चिंतन और उपासना करते हैं, मैं उनके योगक्षेम का वहन करता हूँ। अर्थात् जो उनके पास नहीं है, उसे मैं उपलब्ध कराता हूँ और जो है उसकी रक्षा करता हूँ। यह श्लोक भक्तों के लिए परम आश्वासन है। भगवान स्वयं भक्त के जीवन की देखभाल करते हैं। जब साधक अपनी सम्पूर्ण श्रद्धा ईश्वर पर अर्पित करता है, तो उसके लिए किसी प्रकार की चिंता शेष नहीं रहती। यही अनन्य भक्ति का फल है।",
        englishMeaning = "Those who worship Me with exclusive devotion, thinking of no one else, I provide what they lack and preserve what they have."
    ),
    Shloka(
        number = 23,
        sanskrit = "येऽप्यन्यदेवता भक्ता यजन्ते श्रद्धयान्विताः ।\nतेऽपि मामेव कौन्तेय यजन्त्यविधिपूर्वकम् ॥",
        hindiMeaning = "भगवान कहते हैं – हे कुन्तीपुत्र! जो भक्त अन्य देवताओं की श्रद्धापूर्वक उपासना करते हैं, वे भी वास्तव में मेरी ही उपासना करते हैं, परंतु अविधिपूर्वक। इसका अर्थ यह है कि समस्त देवता भगवान के ही अंश हैं। उनकी पूजा भी अंततः परमात्मा को ही प्राप्त होती है। परंतु सीधे ईश्वर की शरण में जाने का फल अधिक श्रेष्ठ और सरल है। यह श्लोक भक्त को यह समझाता है कि देवताओं की पूजा भी अंततः भगवान तक पहुँचाती है, परंतु वह अप्रत्यक्ष मार्ग है।",
        englishMeaning = "Even those who worship other deities with faith, O Arjuna, actually worship Me alone, though not in the proper way."
    ),
    Shloka(
        number = 24,
        sanskrit = "अहं हि सर्वयज्ञानां भोक्ता च प्रभुरेव च ।\nन तु मामभिजानन्ति तत्वेनातश्च्यवन्ति ते ॥",
        hindiMeaning = "भगवान कहते हैं – मैं ही सभी यज्ञों का भोक्ता और स्वामी हूँ। परंतु लोग मुझे तत्व से नहीं जानते, इसलिए वे च्युत हो जाते हैं। यह श्लोक भक्त को यह चेतावनी देता है कि यदि ईश्वर को समझे बिना केवल यज्ञ या उपासना करते रहेंगे, तो वह पूर्ण फलदायी नहीं होगा। वास्तविक साधना वही है जिसमें भगवान की सत्ता का सच्चा ज्ञान हो। जब तक यह नहीं होता, साधक लक्ष्य से भटकता रहता है।",
        englishMeaning = "I am the only enjoyer and Lord of all sacrifices. But those who do not recognize Me in truth fall back."
    ),
    Shloka(
        number = 25,
        sanskrit = "यान्ति देवव्रता देवान् पितॄन्यान्ति पितृव्रताः ।\nभूतानि यान्ति भूतेज्या यान्ति मद्याजिनोऽपि माम् ॥",
        hindiMeaning = "भगवान कहते हैं – देवताओं की पूजा करने वाले देवताओं के लोक को प्राप्त होते हैं। पितरों की पूजा करने वाले पितृलोक को जाते हैं। भूतों की पूजा करने वाले भूतों में जाते हैं। परंतु मेरे भक्त मुझे ही प्राप्त होते हैं। यह श्लोक स्पष्ट करता है कि साधक जिस मार्ग को चुनता है, उसी के अनुसार उसे फल मिलता है। सबसे श्रेष्ठ मार्ग ईश्वर की सीधी उपासना है।",
        englishMeaning = "Worshipers of the gods go to the gods; worshipers of ancestors go to the ancestors; worshipers of spirits go to the spirits; but My devotees come to Me."
    ),
    Shloka(
        number = 26,
        sanskrit = "पत्रं पुष्पं फलं तोयं यो मे भक्त्या प्रयच्छति ।\nतदहं भक्त्युपहृतमश्नामि प्रयतात्मनः ॥",
        hindiMeaning = "भगवान कहते हैं – यदि कोई मुझे पत्र, पुष्प, फल या जल भक्तिपूर्वक अर्पण करता है, तो मैं उस श्रद्धाभाव से अर्पित वस्तु को स्वीकार करता हूँ। यहाँ वस्तु की महत्ता नहीं है, बल्कि भावना की महत्ता है। यह श्लोक भक्ति के सार को बताता है कि भगवान केवल प्रेम और श्रद्धा को देखते हैं। साधक यदि छोटे से छोटा अर्पण भी निष्कपट हृदय से करता है, तो वह भगवान को प्रिय होता है।",
        englishMeaning = "If one offers Me with devotion a leaf, a flower, a fruit, or water, I accept it from the self-controlled soul with devotion."
    ),
    Shloka(
        number = 27,
        sanskrit = "यत्करोषि यदश्नासि यज्जुहोषि ददासि यत् ।\nयत्तपस्यसि कौन्तेय तत्कुरुष्व मदर्पणम् ॥",
        hindiMeaning = "भगवान कहते हैं – हे कुन्तीपुत्र! जो कुछ भी तू करता है, जो खाता है, जो यज्ञ करता है, जो दान देता है और जो तप करता है, उसे मेरे अर्पण रूप में कर। यह श्लोक साधक को कर्मयोग और भक्तियोग का संगम सिखाता है। जब हर कर्म ईश्वर को समर्पित कर दिया जाता है, तब वह पवित्र हो जाता है। ऐसा जीवन ही सच्ची उपासना है।",
        englishMeaning = "Whatever you do, whatever you eat, whatever you offer in sacrifice, whatever you give in charity, whatever austerity you perform—do that as an offering to Me."
    ),
    Shloka(
        number = 28,
        sanskrit = "शुभाशुभफलैरेवं मोक्ष्यसे कर्मबन्धनैः ।\nसंन्यासयोगयुक्तात्मा विमुक्तो मामुपैष्यसि ॥",
        hindiMeaning = "भगवान कहते हैं – इस प्रकार जब तू सब कर्मों को मुझे अर्पण करेगा, तो शुभ और अशुभ फल से मुक्त हो जाएगा। तू कर्मबंधन से छूटकर, संन्यासयोग से युक्त होकर अंततः मुझे प्राप्त करेगा। यह श्लोक बताता है कि समर्पण से साधक को कर्मों के बंधन से मुक्ति मिलती है। भक्ति और योग से संयुक्त जीवन ही मोक्ष का मार्ग है।",
        englishMeaning = "Thus, freed from the bonds of actions by their results, with mind united in renunciation, you shall be liberated and come to Me."
    ),
    Shloka(
        number = 29,
        sanskrit = "समोऽहं सर्वभूतेषु न मे द्वेष्योऽस्ति न प्रियः ।\nये भजन्ति तु मां भक्त्या मयि ते तेषु चाप्यहम् ॥",
        hindiMeaning = "भगवान कहते हैं – मैं सभी प्राणियों में समान हूँ। न तो कोई मेरा शत्रु है और न ही कोई विशेष प्रिय। परंतु जो मुझे भक्ति से पूजते हैं, वे मेरे साथ रहते हैं और मैं उनके साथ। यह श्लोक ईश्वर की समदृष्टि को दर्शाता है। भगवान सभी को समान दृष्टि से देखते हैं, परंतु भक्ति से जुड़े लोग उन्हें विशेष रूप से प्राप्त होते हैं।",
        englishMeaning = "I am equal to all beings; there is none hateful or dear to Me. But those who worship Me with devotion, they are in Me and I am in them."
    ),
    Shloka(
        number = 30,
        sanskrit = "अपि चेत्सुदुराचारो भजते मामनन्यभाक् ।\nसाधुरेव स मन्तव्यः सम्यग्व्यवसितो हि सः ॥",
        hindiMeaning = "भगवान कहते हैं – यदि कोई अत्यंत दुराचारी भी हो, किंतु वह अनन्य भाव से मेरी भक्ति करता है, तो उसे साधु ही मानना चाहिए। क्योंकि उसने सही संकल्प कर लिया है। यह श्लोक भक्तों को प्रोत्साहित करता है कि चाहे जीवन में कितनी भी त्रुटियाँ हों, यदि हृदय से ईश्वर की ओर मुड़ते हैं, तो भगवान उन्हें स्वीकार करते हैं। यह अनन्य भक्ति का महत्त्व दर्शाता है।",
        englishMeaning = "Even if a very wicked person worships Me with exclusive devotion, he should be considered saintly, for he has rightly resolved."
    ),
    Shloka(
        number = 31,
        sanskrit = "क्षिप्रं भवति धर्मात्मा शश्वच्छान्तिं निगच्छति ।\nकौन्तेय प्रतिजानीहि न मे भक्तः प्रणश्यति ॥",
        hindiMeaning = "भगवान कहते हैं – ऐसा व्यक्ति शीघ्र ही धर्मात्मा बन जाता है और स्थायी शांति को प्राप्त करता है। हे कुन्तीपुत्र! तू यह निश्चयपूर्वक जान ले कि मेरा भक्त कभी नष्ट नहीं होता। यह श्लोक भक्ति के महत्त्व का सबसे बड़ा प्रमाण है। चाहे पूर्व में कितना भी पाप किया हो, सच्ची भक्ति सबका नाश कर देती है। भगवान अपने भक्त की रक्षा का वचन देते हैं।",
        englishMeaning = "Quickly he becomes righteous and attains lasting peace. O son of Kunti, declare it boldly that My devotee never perishes."
    ),
    Shloka(
        number = 32,
        sanskrit = "मां हि पार्थ व्यपाश्रित्य येऽपि स्युः पापयोनयः ।\nस्त्रियो वैश्यास्तथा शूद्रास्तेऽपि यान्ति परां गतिम् ॥",
        hindiMeaning = "भगवान कहते हैं – हे पार्थ! जो लोग मुझे शरण लेते हैं, वे चाहे पापयोनि हों, स्त्रियाँ हों, वैश्य हों या शूद्र हों, वे भी परम गति को प्राप्त होते हैं। यह श्लोक बताता है कि ईश्वर की भक्ति में कोई भेदभाव नहीं है। समाज में चाहे जिसे नीचा समझा जाए, भक्ति के मार्ग में सबको समान अवसर है। भगवान सबको अपनी ओर बुलाते हैं।",
        englishMeaning = "O Arjuna, those who take refuge in Me, even if they are born of sinful origin—women, Vaishyas, or Shudras—they also attain the supreme goal."
    ),
    Shloka(
        number = 33,
        sanskrit = "किं पुनर्ब्राह्मणाः पुण्या भक्ता राजर्षयस्तथा ।\nअनित्यमसुखं लोकमिमं प्राप्य भजस्व माम् ॥",
        hindiMeaning = "भगवान कहते हैं – फिर तो पुण्यात्मा ब्राह्मण और भक्तिमान राजर्षि तो निश्चित ही मुझे प्राप्त होंगे। इसलिए इस अनित्य और दुःखरूप संसार को पाकर मेरी भक्ति कर। यह श्लोक बताता है कि उच्च गुण और श्रेष्ठ जन्म वाले लोग तो सहज ही भगवान को प्राप्त हो सकते हैं। परंतु वास्तव में सभी के लिए सच्चा मार्ग केवल भक्ति ही है। संसार की नश्वरता को समझकर ही साधक को भगवान की ओर मुड़ना चाहिए।",
        englishMeaning = "How much more, then, the righteous Brahmanas and devoted royal sages! Having attained this transient, joyless world, devote yourself to Me."
    ),
    Shloka(
        number = 34,
        sanskrit = "मन्मना भव मद्भक्तो मद्याजी मां नमस्कुरु ।\nमामेवैष्यसि सत्यं ते प्रतिजाने प्रियोऽसि मे ॥",
        hindiMeaning = "भगवान कहते हैं – मन में मेरा चिंतन कर, मेरा भक्त बन, मेरी पूजा कर और मुझे नमस्कार कर। इस प्रकार तू निश्चित ही मुझे प्राप्त होगा। यह सत्य है, क्योंकि तू मुझे प्रिय है। यह अंतिम श्लोक पूरे अध्याय का सार है। साधना का मूल यही है – मन, वचन और कर्म से भगवान की ओर मुड़ना। जो ऐसा करता है, वह निश्चित रूप से भगवान को पाता है।",
        englishMeaning = "Fix your mind on Me, be devoted to Me, worship Me, and bow to Me. You shall surely come to Me—this is My promise, for you are dear to Me."
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaNineScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 9 – राजविद्या राजगुह्य योग",
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
                onClick = { navController.navigate(Screen.QuizNine.route) },
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
            // ✅ Top Image for Adhyaya 9
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
                        painter = painterResource(R.drawable.gemini_generated_image_ag56hmag56hmag56),
                        contentDescription = "Chapter 9 – Raja Vidya Raja Guhya Yoga",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaNineShlokas) { shloka ->
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
