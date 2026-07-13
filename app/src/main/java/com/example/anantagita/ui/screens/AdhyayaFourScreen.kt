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

val adhyayaFourShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "श्रीभगवानुवाच ।\nइमं विवस्वते योगं प्रोक्तवानहमव्ययम्।\nविवस्वान्मनवे प्राह मनुरिक्ष्वाकवेऽब्रवीत्॥",
        hindiMeaning = "भगवान कहते हैं – इस अविनाशी योग को मैंने सूर्यदेव विवस्वान को कहा, विवस्वान ने मनु को बताया और मनु ने इक्ष्वाकु को कहा। यह परंपरा सदैव से चली आ रही है। इसका अर्थ है कि यह योग सनातन है और युगों से ऋषियों व महापुरुषों के माध्यम से मानव समाज को बताया जाता रहा है। इस श्लोक से ज्ञात होता है कि गीता का उपदेश नया नहीं है बल्कि आदिकाल से जीवों के मार्गदर्शन हेतु प्रकट होता रहा है।",
        englishMeaning = "The Blessed Lord said: I taught this eternal yoga to the Sun god; he told it to Manu, and Manu told it to King Ikshvaku."
    ),

    Shloka(
        number = 2,
        sanskrit = "एवं परम्पराप्राप्तमिमं राजर्षयो विदुः।\nस कालेनेह महता योगो नष्टः परन्तप॥",
        hindiMeaning = "भगवान कहते हैं कि इस योग को राजर्षियों ने परंपरा से जाना। परंतु कालांतर में यह योग लुप्त हो गया। जब साधक और समाज परंपरा से विमुख हो जाते हैं तो शुद्ध ज्ञान धीरे-धीरे खो जाता है। इसी कारण भगवान समय-समय पर इसे पुनः प्रकट करते हैं।",
        englishMeaning = "This supreme science was thus received through the tradition of saintly kings, but in course of time it was lost, O Arjuna."
    ),

    Shloka(
        number = 3,
        sanskrit = "स एवायं मया तेऽद्य योगः प्रोक्तः पुरातनः।\nभक्तोऽसि मे सखा चेति रहस्यं ह्येतदुत्तमम्॥",
        hindiMeaning = "भगवान कहते हैं – वही प्राचीन योग आज मैंने तुझे बताया है क्योंकि तू मेरा भक्त और सखा है। यह उत्तम रहस्य है जिसे केवल योग्य व्यक्ति को ही बताया जाता है। अर्जुन का भक्तिभाव और मित्रता उसे इस ज्ञान का अधिकारी बनाती है। इससे स्पष्ट है कि गीता का ज्ञान गुरु की कृपा और पात्रता पर ही मिलता है।",
        englishMeaning = "Today I have spoken to you this ancient science, because you are My devotee and friend. This is the supreme mystery."
    ),

    Shloka(
        number = 4,
        sanskrit = "अर्जुन उवाच ।\nअपरं भवतो जन्म परं जन्म विवस्वतः।\nकथमेतद्विजानीयां त्वमादौ प्रोक्तवानिति॥",
        hindiMeaning = "अर्जुन ने पूछा – आपका जन्म तो हाल ही में हुआ है और विवस्वान का जन्म आपसे बहुत पहले हुआ। फिर आपने सूर्यदेव को यह योग सबसे पहले कैसे बताया? यह प्रश्न अत्यंत तर्कसंगत है क्योंकि भगवान मानव रूप में सामने हैं और अर्जुन उनके दिव्य स्वरूप को पूरी तरह नहीं जानता।",
        englishMeaning = "Arjuna said: You were born later, while the Sun god was born earlier. How then am I to understand that You instructed him in the beginning?"
    ),

    Shloka(
        number = 5,
        sanskrit = "श्रीभगवानुवाच ।\nबहूनि मे व्यतीतानि जन्मानि तव चार्जुन।\nतान्यहं वेद सर्वाणि न त्वं वेत्थ परन्तप॥",
        hindiMeaning = "भगवान कहते हैं – हे अर्जुन! मेरे और तेरे अनेक जन्म बीत चुके हैं। मैं उन सबको जानता हूँ पर तू नहीं जानता। यह भगवान और जीव में अंतर बताता है। भगवान सर्वज्ञ हैं जबकि जीव अज्ञानवश अपने पिछले जन्मों को भूल जाता है।",
        englishMeaning = "The Lord said: Many births of Mine and yours have passed, O Arjuna. I know them all, but you do not, O scorcher of foes."
    ),

    Shloka(
        number = 6,
        sanskrit = "अजोऽपि सन्नव्ययात्मा भूतानामीश्वरोऽपि सन्।\nप्रकृतिं स्वामधिष्ठाय सम्भवाम्यात्ममायया॥",
        hindiMeaning = "भगवान कहते हैं – यद्यपि मैं अजन्मा हूँ, अविनाशी आत्मा हूँ और सभी प्राणियों का स्वामी हूँ, फिर भी अपनी योगमाया से अपनी प्रकृति का अधिष्ठान करके अवतार लेता हूँ। भगवान का जन्म साधारण जीवों जैसा नहीं है, बल्कि यह दिव्य और लोककल्याण के लिए होता है।",
        englishMeaning = "Though unborn and imperishable, the Lord of beings, I manifest Myself by My own divine power."
    ),

    Shloka(
        number = 7,
        sanskrit = "यदा यदा हि धर्मस्य ग्लानिर्भवति भारत।\nअभ्युत्थानमधर्मस्य तदाऽअत्मानं सृजाम्यहम्॥",
        hindiMeaning = "भगवान कहते हैं – जब-जब धर्म की हानि और अधर्म की वृद्धि होती है, तब-तब मैं स्वयं प्रकट होता हूँ। यह अवतार का सिद्धांत है। जब संसार में असंतुलन बढ़ जाता है तो भगवान स्वयं उसे सुधारने आते हैं।",
        englishMeaning = "Whenever there is decline of righteousness and rise of unrighteousness, O Arjuna, then I manifest Myself."
    ),

    Shloka(
        number = 8,
        sanskrit = "परित्राणाय साधूनां विनाशाय च दुष्कृताम्।\nधर्मसंस्थापनार्थाय सम्भवामि युगे युगे॥",
        hindiMeaning = "भगवान कहते हैं – साधुओं की रक्षा, दुष्टों का विनाश और धर्म की स्थापना के लिए मैं युग-युग में प्रकट होता हूँ। यह अवतार का मुख्य उद्देश्य है। श्रीराम, श्रीकृष्ण जैसे अवतार इसी सिद्धांत को पूर्ण करते हैं।",
        englishMeaning = "For the protection of the righteous, the destruction of the wicked, and the establishment of dharma, I appear in every age."
    ),

    Shloka(
        number = 9,
        sanskrit = "जन्म कर्म च मे दिव्यमेवं यो वेत्ति तत्त्वतः।\nत्यक्त्वा देहं पुनर्जन्म नैति मामेति सोऽर्जुन॥",
        hindiMeaning = "भगवान कहते हैं – जो मेरे जन्म और कर्म को दिव्य रूप से जान लेता है, वह शरीर त्यागने के बाद पुनर्जन्म नहीं लेता, बल्कि मुझे प्राप्त होता है। इसका अर्थ है कि भगवान का अवतार सांसारिक नहीं है बल्कि दिव्य है। जो साधक इस सत्य को समझ लेता है, वह मोक्ष को प्राप्त होता है।",
        englishMeaning = "He who knows the divine nature of My birth and deeds, upon leaving the body, does not take birth again but comes to Me."
    ),

    Shloka(
        number = 10,
        sanskrit = "वीतरागभयक्रोधा मन्मया मामुपाश्रिताः।\nबहवो ज्ञानतपसा पूता मद्भावमागताः॥",
        hindiMeaning = "भगवान कहते हैं – राग, भय और क्रोध से मुक्त होकर, मुझमें मन लगाकर और मेरा आश्रय लेकर, अनेक लोग ज्ञान और तपस्या द्वारा शुद्ध होकर मेरे स्वरूप को प्राप्त हुए हैं। इससे पता चलता है कि भगवान को पाना संभव है, बशर्ते साधक मन को निर्मल बनाए और श्रद्धा से जुड़ जाए।",
        englishMeaning = "Freed from attachment, fear, and anger, absorbed in Me, purified by knowledge and penance, many have attained My divine nature."
    ),

    Shloka(
        number = 11,
        sanskrit = "ये यथा मां प्रपद्यन्ते तांस्तथैव भजाम्यहम्।\nमम वर्त्मानुवर्तन्ते मनुष्याः पार्थ सर्वशः॥",
        hindiMeaning = "भगवान कहते हैं – लोग जैसे-जिस प्रकार मुझे भजते हैं, मैं वैसे ही उन्हें फल देता हूँ। सभी मनुष्य हर प्रकार से मेरे मार्ग का ही अनुसरण करते हैं। इसका अर्थ यह है कि चाहे कोई किसी रूप में साधना करे, अंततः उसकी यात्रा भगवान तक ही पहुँचती है।",
        englishMeaning = "As men approach Me, so do I reward them. In all ways, O Arjuna, people follow My path."
    ),

    Shloka(
        number = 12,
        sanskrit = "काङ्क्षन्तः कर्मणां सिद्धिं यजन्त इह देवताः।\nक्षिप्रं हि मानुषे लोके सिद्धिर्भवति कर्मजा॥",
        hindiMeaning = "भगवान कहते हैं – जो लोग कर्मों की सिद्धि चाहते हैं, वे देवताओं की पूजा करते हैं, क्योंकि मनुष्य लोक में कर्म से उत्पन्न फल शीघ्र प्राप्त होते हैं। लेकिन ये फल अस्थायी होते हैं। जबकि भगवान की भक्ति से शाश्वत फल यानी मोक्ष मिलता है।",
        englishMeaning = "Desiring success in action, men worship the gods, for success is quickly attained in the human world by action."
    ),

    Shloka(
        number = 13,
        sanskrit = "चातुर्वर्ण्यं मया सृष्टं गुणकर्मविभागशः।\nतस्य कर्तारमपि मां विद्ध्यकर्तारमव्ययम्॥",
        hindiMeaning = "भगवान कहते हैं – मैंने गुण और कर्म के आधार पर चार वर्णों की रचना की है। यद्यपि मैं इसका कर्ता हूँ, फिर भी मुझे अकर्त्ता और अविनाशी समझना चाहिए। यहाँ भगवान वर्ण व्यवस्था को दिव्य दृष्टि से समझाते हैं कि यह जन्म पर नहीं बल्कि गुण और कर्म पर आधारित है।",
        englishMeaning = "The four divisions of society were created by Me according to qualities and actions. Though I am the creator, know Me to be the non-doer and immutable."
    ),

    Shloka(
        number = 14,
        sanskrit = "न मां कर्माणि लिम्पन्ति न मे कर्मफले स्पृहा।\nइति मां योऽभिजानाति कर्मभिर्न स बध्यते॥",
        hindiMeaning = "भगवान कहते हैं – कर्म मुझे नहीं बाँधते और न ही मुझे उनके फलों की इच्छा है। जो व्यक्ति इस सत्य को जान लेता है, वह भी कर्मों से बंधता नहीं है। साधक को यह समझना चाहिए कि निष्काम भाव से किया गया कर्म ही उसे मुक्त करता है।",
        englishMeaning = "Actions do not bind Me, nor do I desire the fruits of action. He who knows this is not bound by actions."
    ),

    Shloka(
        number = 15,
        sanskrit = "एवं ज्ञात्वा कृतं कर्म पूर्वैरपि मुमुक्षुभिः।\nकुरु कर्मैव तस्मात्त्वं पूर्वैः पूर्वतरं कृतम्॥",
        hindiMeaning = "भगवान कहते हैं – इस प्रकार जानकर प्राचीन मुमुक्षुओं ने भी कर्म किए। इसलिए तू भी वैसे ही कर्म कर जैसा प्राचीन लोग करते आए हैं। इसका अर्थ यह है कि मुक्त होने की इच्छा रखने वाला व्यक्ति कर्म से भागता नहीं, बल्कि उसे ईश्वरार्पण भाव से करता है।",
        englishMeaning = "Knowing this, the seekers of liberation in ancient times performed action. Therefore, you too should perform action as the ancients did."
    ),
    Shloka(
        number = 16,
        sanskrit = "किं कर्म किमकर्मेति कवयोऽप्यत्र मोहिताः।\nतत्ते कर्म प्रवक्ष्यामि यज्ज्ञात्वा मोक्ष्यसेऽशुभात्॥",
        hindiMeaning = "भगवान कहते हैं – कर्म क्या है और अकर्म क्या है, इस विषय में बड़े-बड़े विद्वान भी भ्रमित हो जाते हैं। इसलिए मैं तुझे कर्म का सही रहस्य बताऊँगा, जिसे जानकर तू अशुभ से मुक्त हो जाएगा। यहाँ भगवान यह समझाते हैं कि केवल बाहरी दृष्टि से कर्म को समझना पर्याप्त नहीं है। कर्म का वास्तविक स्वरूप तभी जाना जा सकता है जब हम उसकी गहराई में उतरें और उसे भगवान के दृष्टिकोण से देखें। इस ज्ञान से मनुष्य पाप और बंधन से मुक्त हो जाता है।",
        englishMeaning = "Even the wise are confused about what is action and inaction. I will explain this to you, knowing which you will be freed from all evil."
    ),

    Shloka(
        number = 17,
        sanskrit = "कर्मणो ह्यपि बोद्धव्यं बोद्धव्यं च विकर्मणः।\nअकर्मणश्च बोद्धव्यं गहना कर्मणो गतिः॥",
        hindiMeaning = "भगवान कहते हैं – यह समझना आवश्यक है कि कौन-सा कर्म उचित है, कौन-सा विकर्म (अनुचित कर्म) है और कौन-सा अकर्म (निष्क्रियता या कर्म के मध्य छिपा ज्ञान) है। क्योंकि कर्म की गति अत्यंत गूढ़ है और साधारण मनुष्य के लिए इसे समझ पाना कठिन है। इसी कारण शास्त्र और गुरु के मार्गदर्शन की आवश्यकता होती है। जो इसे भली-भाँति जान लेता है, वही वास्तविक कर्मयोगी कहलाता है।",
        englishMeaning = "One must understand proper action, wrong action, and inaction. The nature of action is very deep and difficult to understand."
    ),

    Shloka(
        number = 18,
        sanskrit = "कर्मण्यकर्म यः पश्येदकर्मणि च कर्म यः।\nस बुद्धिमान्मनुष्येषु स युक्तः कृत्स्नकर्मकृत्॥",
        hindiMeaning = "भगवान कहते हैं – जो मनुष्य कर्म में अकर्म और अकर्म में कर्म देखता है, वही वास्तव में बुद्धिमान है। इसका अर्थ यह है कि बाहरी रूप से कर्म करने पर भी वह आत्मा को अकर्मस्वरूप जानता है। और जो निष्क्रिय दिखाई देता है, वह भी भीतर ज्ञान का कर्म कर सकता है। ऐसा व्यक्ति सच्चा योगी है क्योंकि उसने कर्म और अकर्म के रहस्य को समझ लिया है।",
        englishMeaning = "He who sees inaction in action and action in inaction is wise among men. He is truly a yogi and a doer of all action."
    ),

    Shloka(
        number = 19,
        sanskrit = "यस्य सर्वे समारम्भाः कामसङ्कल्पवर्जिताः।\nज्ञानाग्निदग्धकर्माणं तमाहुः पण्डितं बुधाः॥",
        hindiMeaning = "भगवान कहते हैं – जिसके सभी कर्म कामना और संकल्प से रहित होते हैं, और जिसका समस्त कर्म ज्ञानरूपी अग्नि से जल चुका होता है, उसी को विद्वान और ज्ञानी कहते हैं। ऐसा व्यक्ति कर्म करते हुए भी उनसे बंधता नहीं। उसकी दृष्टि में कर्म केवल कर्तव्य है, व्यक्तिगत स्वार्थ का साधन नहीं।",
        englishMeaning = "He whose actions are free from desire and whose deeds are burnt in the fire of knowledge is called a wise man by the learned."
    ),

    Shloka(
        number = 20,
        sanskrit = "त्यक्त्वा कर्मफलासङ्गं नित्यतृप्तो निराश्रयः।\nकर्मण्यभिप्रवृत्तोऽपि नैव किञ्चित्करोति सः॥",
        hindiMeaning = "भगवान कहते हैं – जो मनुष्य कर्मफल की आसक्ति त्याग चुका है, जो नित्य संतुष्ट और निराश्रय है, वह कर्म में लगा हुआ भी वास्तव में कुछ नहीं करता। उसका कर्म उसे बाँधता नहीं क्योंकि वह निष्काम भाव से किया गया होता है। ऐसे योगी के लिए हर कर्म पूजा बन जाता है।",
        englishMeaning = "Having renounced attachment to the fruits of action, ever content and independent, he does nothing though engaged in all actions."
    ),

    Shloka(
        number = 21,
        sanskrit = "निराशीर्यतचित्तात्मा त्यक्तसर्वपरिग्रहः।\nशारीरं केवलं कर्म कुर्वन्नाप्नोति किल्बिषम्॥",
        hindiMeaning = "भगवान कहते हैं – जो मनुष्य निराशा से रहित है, जिसने मन और आत्मा को संयमित कर लिया है और जिसने सब प्रकार के संग्रह का त्याग कर दिया है, वह केवल शरीर निर्वाह हेतु कर्म करता है। ऐसा करने से उसे कोई पाप नहीं लगता। इस श्लोक से सादगी और संतोष का महत्व स्पष्ट होता है।",
        englishMeaning = "One who is free from desire, self-controlled, and without possessions, performs bodily action only and incurs no sin."
    ),

    Shloka(
        number = 22,
        sanskrit = "यदृच्छालाभसन्तुष्टो द्वन्द्वातीतो विमत्सरः।\nसमः सिद्धावसिद्धौ च कृत्वापि न निबध्यते॥",
        hindiMeaning = "भगवान कहते हैं – जो मनुष्य सहज प्राप्ति से संतुष्ट रहता है, जो द्वन्द्वों (जैसे सुख-दुःख, लाभ-हानि) से ऊपर है, जो मत्सर (ईर्ष्या) रहित है और सफलता-असफलता में समान रहता है, वह कर्म करते हुए भी बंधता नहीं। उसकी आंतरिक स्थिरता ही उसे मुक्त बनाती है।",
        englishMeaning = "Content with whatever comes by chance, free from dualities, without envy, equal in success and failure, he is not bound even when acting."
    ),

    Shloka(
        number = 23,
        sanskrit = "गतसङ्गस्य मुक्तस्य ज्ञानावस्थितचेतसः।\nयज्ञायाचरतः कर्म समग्रं प्रविलीयते॥",
        hindiMeaning = "भगवान कहते हैं – जिसने आसक्ति त्याग दी है, जो मुक्त है और जिसका चित्त ज्ञान में स्थित है, उसके द्वारा यज्ञभाव से किया गया कर्म पूर्णतः विलीन हो जाता है। अर्थात वह कर्म के बंधन से मुक्त हो जाता है। ऐसा साधक कर्म करता है लेकिन उसे फल की आसक्ति नहीं होती।",
        englishMeaning = "The actions of one who is free from attachment, liberated, and established in knowledge, performed as sacrifice, dissolve entirely."
    ),

    Shloka(
        number = 24,
        sanskrit = "ब्रह्मार्पणं ब्रह्म हविर्ब्रह्माग्नौ ब्रह्मणा हुतम्।\nब्रह्मैव तेन गन्तव्यं ब्रह्मकर्मसमाधिना॥",
        hindiMeaning = "भगवान कहते हैं – यज्ञ में अर्पण भी ब्रह्म है, हवि भी ब्रह्म है, अग्नि भी ब्रह्म है और आहुति देने वाला भी ब्रह्म है। जो मनुष्य इस भाव से कर्म करता है, वह ब्रह्म को ही प्राप्त होता है। यह ज्ञानयोगी का दृष्टिकोण है, जहाँ हर वस्तु और हर कर्म में केवल ईश्वर ही दिखता है।",
        englishMeaning = "In the act of offering, the offering itself, the fire, and the offerer are all Brahman. One who realizes this attains Brahman."
    ),

    Shloka(
        number = 25,
        sanskrit = "दैवमेवापरे यज्ञं योगिनः पर्युपासते।\nब्रह्माग्नावपरे यज्ञं यज्ञेनैवोपजुह्वति॥",
        hindiMeaning = "भगवान कहते हैं – कुछ योगी देवताओं की पूजा रूपी यज्ञ करते हैं, जबकि अन्य योगी ब्रह्माग्नि में यज्ञ स्वरूप स्वयं यज्ञ ही अर्पित करते हैं। इसका अर्थ यह है कि साधक अलग-अलग मार्गों से साधना करते हैं, लेकिन उद्देश्य आत्मोन्नति ही होता है।",
        englishMeaning = "Some yogis worship the gods by sacrifice, while others offer sacrifice itself into the fire of Brahman."
    ),

    Shloka(
        number = 26,
        sanskrit = "श्रोत्रादीनीन्द्रियाण्यन्ये संयमाग्निषु जुह्वति।\nशब्दादीन्विषयानन्य इन्द्रियाग्निषु जुह्वति॥",
        hindiMeaning = "भगवान कहते हैं – कुछ योगी अपने इंद्रियों को संयम की अग्नि में आहुति देते हैं, अर्थात इंद्रिय संयम करते हैं। अन्य योगी विषयों को इंद्रियों की अग्नि में आहुति देते हैं, अर्थात इंद्रियों को उचित मार्ग पर लगाते हैं। यह दोनों साधना के मार्ग आत्मसंयम और इंद्रिय संयम की ओर इंगित करते हैं।",
        englishMeaning = "Some offer their senses into the fire of self-control, while others offer sense objects into the fire of the senses."
    ),

    Shloka(
        number = 27,
        sanskrit = "सर्वाणीन्द्रियकर्माणि प्राणकर्माणि चापरे।\nआत्मसंयमयोगाग्नौ जुह्वति ज्ञानदीपिते॥",
        hindiMeaning = "भगवान कहते हैं – अन्य योगी सभी इंद्रिय और प्राणों की क्रियाओं को आत्मसंयम योग की अग्नि में अर्पित करते हैं, जो ज्ञान से प्रकाशित होती है। अर्थात वे अपने समस्त जीवन को आत्मसंयम और ज्ञान के मार्ग पर समर्पित कर देते हैं।",
        englishMeaning = "Others sacrifice all the functions of the senses and life-breaths into the fire of self-discipline kindled by knowledge."
    ),

    Shloka(
        number = 28,
        sanskrit = "द्रव्ययज्ञास्तपोयज्ञा योगयज्ञास्तथापरे।\nस्वाध्यायज्ञानयज्ञाश्च यतयः संशितव्रताः॥",
        hindiMeaning = "भगवान कहते हैं – कुछ तपस्वी द्रव्य का यज्ञ करते हैं, कुछ तपस्या का यज्ञ, कुछ योग का और कुछ स्वाध्याय एवं ज्ञान का यज्ञ करते हैं। इस प्रकार अनेक प्रकार की साधनाएँ हैं जिनके द्वारा मनुष्य आत्मोन्नति करता है। यह सब अंततः आत्मशुद्धि के साधन हैं।",
        englishMeaning = "Some perform sacrifice with wealth, some with austerity, some with yoga, and some with study and knowledge."
    ),

    Shloka(
        number = 29,
        sanskrit = "अपाने जुह्वति प्राणं प्राणेऽपानं तथापरे।\nप्राणापानगती रुद्ध्वा प्राणायामपरायणाः॥",
        hindiMeaning = "भगवान कहते हैं – कुछ योगी प्राण को अपान में और अपान को प्राण में आहुति देते हैं। वे प्राण और अपान की गति को रोककर प्राणायाम साधना करते हैं। यह प्राणयज्ञ साधना की उच्च अवस्था है जिसमें साधक श्वास-प्रश्वास को नियंत्रित कर आत्मसाक्षात्कार की ओर बढ़ता है।",
        englishMeaning = "Some offer the outgoing breath into the incoming breath and the incoming into the outgoing, restraining the breath in pranayama."
    ),

    Shloka(
        number = 30,
        sanskrit = "अपरे नियताहाराः प्राणान्प्राणेषु जुह्वति।\nसर्वेऽप्येते यज्ञविदो यज्ञक्षपितकल्मषाः॥",
        hindiMeaning = "भगवान कहते हैं – अन्य योगी नियत आहार का पालन करते हुए प्राणों को प्राणों में आहुति देते हैं। ये सब यज्ञ को जानने वाले साधक हैं, जिनके पाप यज्ञ के द्वारा नष्ट हो जाते हैं। इसका अर्थ यह है कि अनुशासन और संयम के द्वारा साधक अपने जीवन को शुद्ध करता है।",
        englishMeaning = "Others, with regulated diet, offer the life-breaths into the life-breaths. All these are knowers of sacrifice, whose sins are destroyed by sacrifice."
    ),
    Shloka(
        number = 31,
        sanskrit = "यज्ञशिष्टामृतभुजो यान्ति ब्रह्म सनातनम्।\nनायं लोकोऽस्त्ययज्ञस्य कुतोऽन्यः कुरुसत्तम॥",
        hindiMeaning = "भगवान श्रीकृष्ण अर्जुन से कहते हैं कि जो लोग यज्ञ से बचे हुए अमृत स्वरूप अन्न का सेवन करते हैं, वे सनातन ब्रह्म को प्राप्त होते हैं। यज्ञ का अर्थ केवल अग्नि में आहुति डालना नहीं है, बल्कि त्याग, कर्तव्य पालन और परहित की भावना से किए गए कर्म भी यज्ञ कहलाते हैं। जो लोग यज्ञ का पालन नहीं करते, वे इस लोक में भी सुख और शांति प्राप्त नहीं कर सकते, फिर परलोक की तो बात ही क्या। इसका तात्पर्य है कि जीवन का प्रत्येक कर्म यज्ञ भावना से किया जाए। बिना यज्ञभावना के किया हुआ कर्म बंधनकारक बनता है। परंतु यज्ञभावना से किया हुआ कर्म शुद्ध होकर मुक्ति की ओर ले जाता है।",
        englishMeaning = "Those who partake of the remnants of sacrifice attain eternal Brahman. But for one who does not perform sacrifice, even this world is joyless—what then of the next?"
    ),

    Shloka(
        number = 32,
        sanskrit = "एवं बहुविधा यज्ञा वितता ब्रह्मणो मुखे।\nकर्मजान्विद्धि तान्सर्वानेवं ज्ञात्वा विमोक्ष्यसे॥",
        hindiMeaning = "श्रीकृष्ण यहाँ बताते हैं कि वेदों में अनेक प्रकार के यज्ञों का वर्णन किया गया है। ये सभी यज्ञ वास्तव में कर्म से उत्पन्न होते हैं और मनुष्य को शुद्ध करते हैं। प्रत्येक व्यक्ति अपनी प्रवृत्ति और क्षमता के अनुसार यज्ञ कर सकता है, चाहे वह ज्ञानयज्ञ हो, द्रव्ययज्ञ हो या तपस्यायज्ञ। इन सभी का उद्देश्य आत्मशुद्धि और ईश्वर की प्राप्ति है। जब मनुष्य यह समझ लेता है कि कर्म का सर्वोच्च रूप यज्ञ है, तब वह कर्म के बंधन से मुक्त हो जाता है। इसलिए अर्जुन, तुम्हें इन यज्ञों को समझकर अपने जीवन में धारण करना चाहिए। इससे तुम्हारी आत्मा निर्मल होगी और मुक्ति का मार्ग प्रशस्त होगा।",
        englishMeaning = "Various kinds of sacrifices are spread out in the Vedas, all born of work. Understanding them, one becomes free from bondage."
    ),

    Shloka(
        number = 33,
        sanskrit = "श्रेयान्द्रव्यमयाद्यज्ञाज्ज्ञानयज्ञः परन्तप।\nसर्वं कर्माखिलं पार्थ ज्ञाने परिसमाप्यते॥",
        hindiMeaning = "यहाँ भगवान अर्जुन को समझाते हैं कि यद्यपि द्रव्य से किए गए यज्ञ भी उत्तम हैं, लेकिन ज्ञानयज्ञ उनसे श्रेष्ठ है। द्रव्ययज्ञ बाहरी साधनों से किया जाता है, जबकि ज्ञानयज्ञ आत्मा की गहराई में जाकर अज्ञान का नाश करता है। जब ज्ञान प्राप्त हो जाता है तो सभी कर्म उसी में विलीन हो जाते हैं। इसका अर्थ है कि ज्ञान ही कर्म का अंतिम लक्ष्य और फल है। यदि मनुष्य के पास सही ज्ञान न हो तो द्रव्ययज्ञ भी उसे मुक्ति नहीं दिला सकता। इसलिए अर्जुन! ज्ञानयज्ञ की महत्ता समझो और उसे प्राप्त करने का प्रयास करो।",
        englishMeaning = "Knowledge-sacrifice is superior to material sacrifice, O Arjuna, for all actions culminate in knowledge."
    ),

    Shloka(
        number = 34,
        sanskrit = "तद्विद्धि प्रणिपातेन परिप्रश्नेन सेवया।\nउपदेक्ष्यन्ति ते ज्ञानं ज्ञानिनस्तत्त्वदर्शिनः॥",
        hindiMeaning = "श्रीकृष्ण अर्जुन को बताते हैं कि उस परम ज्ञान को प्राप्त करने के लिए ज्ञानी महात्माओं की शरण लेनी चाहिए। उनके प्रति विनम्र भाव से प्रणाम करके, उचित प्रश्न पूछकर और उनकी सेवा करके ही सच्चा ज्ञान प्राप्त किया जा सकता है। गुरु केवल वही ज्ञान प्रदान करते हैं जो शिष्य की निष्ठा और श्रद्धा से अर्जित होता है। तत्त्वदर्शी महापुरुष स्वयं सत्य का अनुभव कर चुके होते हैं, इसलिए वे दूसरों को भी उस सत्य का बोध करा सकते हैं। केवल बाहरी चर्चा या तर्क से ज्ञान प्राप्त नहीं होता। ज्ञान गुरु के चरणों की सेवा और विनम्रता से ही मिलता है।",
        englishMeaning = "Approach the wise with humility, inquiry, and service. Those who have realized the truth will impart knowledge to you."
    ),

    Shloka(
        number = 35,
        sanskrit = "यज्ज्ञात्वा न पुनर्मोहमेवं यास्यसि पाण्डव।\nयेन भूतान्यशेषेण द्रक्ष्यस्यात्मन्यथो मयि॥",
        hindiMeaning = "भगवान कहते हैं कि जब तुम यह ज्ञान प्राप्त कर लोगे, तब पुनः कभी मोह में नहीं पड़ोगे। इस ज्ञान से तुम सभी प्राणियों को आत्मा और परमात्मा में एक ही रूप से देख पाओगे। तब तुम्हें समझ आएगा कि सब कुछ वास्तव में ईश्वर का ही अंश है। जब यह दृष्टि प्राप्त हो जाती है तो किसी से द्वेष या आसक्ति नहीं रहती। यह ज्ञान सभी भेदभाव को मिटा देता है। ऐसा व्यक्ति सभी जीवों में स्वयं को और मुझमें एक ही सत्य को अनुभव करता है। यही आत्मसाक्षात्कार की अवस्था है।",
        englishMeaning = "With this knowledge, you will never fall into delusion again. You will see all beings equally in yourself and in Me."
    ),

    Shloka(
        number = 36,
        sanskrit = "अपि चेदसि पापेभ्यः सर्वेभ्यः पापकृत्तमः।\nसर्वं ज्ञानप्लवेनैव वृजिनं सन्तरिष्यसि॥",
        hindiMeaning = "भगवान अर्जुन को आश्वस्त करते हुए कहते हैं कि यदि तुम सबसे बड़े पापी भी हो, तब भी यह ज्ञान तुम्हें सारे पापों से पार करा देगा। ज्ञान एक नौका की तरह है, जो मनुष्य को संसार के दुःखसागर से पार कर देता है। जैसे अंधकार को प्रकाश तुरंत मिटा देता है, वैसे ही ज्ञान पापों को नष्ट कर देता है। पाप चाहे कितना भी बड़ा क्यों न हो, ज्ञान के प्रभाव से उसका नाश हो जाता है। यह ईश्वर का वचन है कि सच्चे ज्ञान की शक्ति अपरिमित है। इसलिए अर्जुन, इस ज्ञान की प्राप्ति में संदेह मत करो।",
        englishMeaning = "Even if you are the worst sinner of all, with the boat of knowledge you will cross over all sin."
    ),

    Shloka(
        number = 37,
        sanskrit = "यथैधांसि समिद्धोऽग्निर्भस्मसात्कुरुतेऽर्जुन।\nज्ञानाग्निः सर्वकर्माणि भस्मसात्कुरुते तथा॥",
        hindiMeaning = "श्रीकृष्ण ज्ञान की महिमा का उदाहरण देकर कहते हैं कि जैसे प्रज्वलित अग्नि लकड़ियों को भस्म कर देती है, वैसे ही ज्ञान की अग्नि सभी कर्मों को जला देती है। कर्म चाहे शुभ हों या अशुभ, वे आत्मा को बाँधते हैं। लेकिन ज्ञान आत्मा को इन सब बंधनों से मुक्त कर देता है। यह ज्ञान ही है जो मनुष्य को जन्म और मृत्यु के चक्र से छुड़ाता है। जैसे आग सब कुछ जलाकर राख कर देती है, वैसे ही ज्ञान सब कर्मों को नष्ट कर देता है। इसीलिए ज्ञान को सबसे उच्च कहा गया है।",
        englishMeaning = "Just as fire reduces wood to ashes, so does the fire of knowledge burn all actions to ashes."
    ),

    Shloka(
        number = 38,
        sanskrit = "न हि ज्ञानेन सदृशं पवित्रमिह विद्यते।\nतत्स्वयं योगसंसिद्धः कालेनात्मनि विन्दति॥",
        hindiMeaning = "भगवान कहते हैं कि इस संसार में ज्ञान से बढ़कर कोई पवित्र वस्तु नहीं है। ज्ञान ही मनुष्य की आत्मा को शुद्ध करता है और उसे ईश्वर से जोड़ता है। यह ज्ञान साधना और योग की पूर्णता के बाद स्वयं प्रकट होता है। समय के साथ साधक को भीतर से यह अनुभव होने लगता है कि सब कुछ ईश्वर ही है। इस ज्ञान से मनुष्य के जीवन का अंधकार दूर हो जाता है। यही सबसे बड़ा धन और सबसे बड़ी प्राप्ति है। इसलिए अर्जुन, ज्ञान की महिमा को समझो और उसे प्राप्त करने का प्रयास करो।",
        englishMeaning = "There is nothing as pure as knowledge. In due course, one perfected in yoga discovers this within himself."
    ),

    Shloka(
        number = 39,
        sanskrit = "श्रद्धावान्लभते ज्ञानं तत्परः संयतेन्द्रियः।\nज्ञानं लब्ध्वा परां शान्तिमचिरेणाधिगच्छति॥",
        hindiMeaning = "यहाँ भगवान बताते हैं कि केवल वही व्यक्ति ज्ञान प्राप्त कर सकता है जिसके भीतर श्रद्धा हो। श्रद्धा के साथ-साथ इंद्रियों पर नियंत्रण और आत्मसंयम भी आवश्यक है। ऐसा व्यक्ति जब गुरु की शरण लेकर ज्ञान प्राप्त करता है तो शीघ्र ही परम शांति को प्राप्त करता है। यह शांति बाहरी परिस्थितियों से प्रभावित नहीं होती। इसका कारण यह है कि सच्चा ज्ञान आत्मा को ईश्वर से जोड़ देता है। जब आत्मा और परमात्मा का मिलन होता है, तभी वास्तविक शांति प्राप्त होती है।",
        englishMeaning = "The faithful, self-controlled, and devoted person obtains knowledge. Having gained it, he quickly attains supreme peace."
    ),

    Shloka(
        number = 40,
        sanskrit = "अज्ञश्चाश्रद्दधानश्च संशयात्मा विनश्यति।\nनायं लोकोऽस्ति न परो न सुखं संशयात्मनः॥",
        hindiMeaning = "भगवान कहते हैं कि जो व्यक्ति अज्ञानी है, श्रद्धा नहीं रखता और हर बात में संदेह करता है, वह नष्ट हो जाता है। ऐसे व्यक्ति के लिए न यह लोक है, न परलोक और न ही कहीं सुख है। संदेहशील व्यक्ति कभी भी स्थिर नहीं हो पाता। उसका मन हमेशा उलझन और द्वंद्व में रहता है। ज्ञान केवल उसी को मिलता है जो पूरी श्रद्धा से गुरु और शास्त्रों में विश्वास रखता है। संदेह आत्मा की प्रगति का सबसे बड़ा शत्रु है।",
        englishMeaning = "The ignorant, the faithless, and the doubting self perish. For the doubter, there is neither this world, nor the next, nor happiness."
    ),

    Shloka(
        number = 41,
        sanskrit = "योगसंन्यस्तकर्माणं ज्ञानसञ्छिन्नसंशयम्।\nआत्मवन्तं न कर्माणि निबध्नन्ति धनञ्जय॥",
        hindiMeaning = "भगवान कहते हैं कि जो व्यक्ति योग की भावना से अपने कर्मों का त्याग कर देता है और जिसने ज्ञान से अपने सभी संदेह नष्ट कर दिए हैं, उसे कर्म कभी बाँध नहीं सकते। ऐसा आत्मनिष्ठ व्यक्ति कर्म करते हुए भी उनसे मुक्त रहता है। वह जानता है कि कर्म केवल शरीर और इंद्रियों का कार्य है, आत्मा उनका कर्ता नहीं है। इसलिए वह कर्म करते हुए भी निष्काम रहता है। इस प्रकार का ज्ञानी व्यक्ति वास्तव में कर्मबंधन से परे हो जाता है।",
        englishMeaning = "The self-controlled person, who has renounced actions through yoga and destroyed doubts with knowledge, is not bound by actions."
    ),

    Shloka(
        number = 42,
        sanskrit = "तस्मादज्ञानसम्भूतं हृत्स्थं ज्ञानासिनात्मनः।\nछित्त्वैनं संशयं योगमातिष्ठोत्तिष्ठ भारत॥",
        hindiMeaning = "अंत में भगवान अर्जुन को उपदेश देते हैं कि अज्ञान से उत्पन्न जो संशय तेरे हृदय में बैठा है, उसे ज्ञान की तलवार से काट डाल। ज्ञान अज्ञान और संशय को नष्ट करने वाली तलवार की तरह है। अर्जुन! उठ और योग में स्थिर होकर अपने कर्तव्य का पालन कर। संशय में पड़े रहने से केवल पतन होता है। दृढ़ संकल्प और विश्वास से ही महान कार्य सिद्ध होते हैं। इसलिए संदेह छोड़कर कर्मयोग में लग जा।",
        englishMeaning = "Therefore, cut off this doubt in your heart born of ignorance with the sword of knowledge. Stand up, O Arjuna, and take to yoga."
    )

)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaFourScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 4 – ज्ञान कर्म संन्यास योग",
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
                onClick = { navController.navigate(Screen.QuizFour.route) },
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
            // ✅ Top Image for Adhyaya 4
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
                        painter = painterResource(R.drawable.gemini_generated_image_gkcj9bgkcj9bgkcj),
                        contentDescription = "Chapter 4 – Jnana Karma Sannyasa Yoga",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaFourShlokas) { shloka ->
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
