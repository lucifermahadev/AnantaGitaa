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
val adhyayaThreeShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अर्जुन उवाच |\nज्यायसी चेत्कर्मणस्ते मता बुद्धिर्जनार्दन।\nतत्किं कर्मणि घोरे मां नियोजयसि केशव॥",
        hindiMeaning = "अर्जुन भगवान से प्रश्न करते हैं कि यदि बुद्धि मार्ग, अर्थात् ज्ञानयोग, कर्म की अपेक्षा श्रेष्ठ माना गया है, तो हे जनार्दन! फिर आप मुझे इस भयंकर युद्ध जैसे कर्म में क्यों लगाते हैं? अर्जुन के मन में द्वंद्व था कि यदि आत्मज्ञान ही सबसे उत्तम है तो फिर कर्म क्यों करना चाहिए। वह यह नहीं समझ पा रहा था कि युद्ध और हिंसा कैसे धर्म हो सकता है। उसके मन में करुणा और मोह का भाव था, इसलिए उसने कृष्ण से स्पष्ट उत्तर माँगा। यह प्रश्न वास्तव में प्रत्येक साधक के भीतर उठता है कि ज्ञान और कर्म में से श्रेष्ठ क्या है।",
        englishMeaning = "Arjuna asks Krishna: If knowledge is superior to action, why do You urge me to engage in this dreadful war? He is confused about why action is necessary if wisdom alone leads to liberation."
    ),

    Shloka(
        number = 2,
        sanskrit = "व्यामिश्रेणेव वाक्येन बुद्धिं मोहयसीव मे।\nतदेकं वद निश्चित्य येन श्रेयोऽहमाप्नुयाम्॥",
        hindiMeaning = "अर्जुन आगे कहता है कि आपके वचनों से मेरी बुद्धि भ्रमित हो रही है। आप कभी ज्ञान की महिमा बताते हैं और कभी कर्म का महत्व समझाते हैं, जिससे मुझे यह निर्णय करना कठिन हो गया है कि वास्तव में कौन सा मार्ग श्रेष्ठ है। इसलिए कृपा करके आप मुझे एक ही मार्ग स्पष्ट रूप से बताइए, जिससे मुझे निश्चित रूप से कल्याण प्राप्त हो सके। अर्जुन का यह निवेदन साधक की उस स्थिति को दर्शाता है जब वह एक साथ अनेक मार्गों से प्रभावित होकर उलझ जाता है। यहाँ अर्जुन ईश्वर से एकमात्र मार्गदर्शन चाहता है।",
        englishMeaning = "Arjuna says: Your words seem contradictory and confuse my understanding. Please tell me one clear path by which I may attain the highest good."
    ),

    Shloka(
        number = 3,
        sanskrit = "श्रीभगवानुवाच |\nलोकेऽस्मिन्द्विविधा निष्ठा पुरा प्रोक्ता मयानघ।\nज्ञानयोगेन सांख्यानां कर्मयोगेन योगिनाम्॥",
        hindiMeaning = "भगवान श्रीकृष्ण उत्तर देते हैं कि हे निष्पाप अर्जुन! मैंने इस संसार में पहले ही दो प्रकार की निष्ठाएँ बताई हैं। सांख्य दर्शन वाले ज्ञानीजन ज्ञानयोग के मार्ग से मुक्ति प्राप्त करते हैं और योगीजन कर्मयोग का पालन करके उन्नति प्राप्त करते हैं। दोनों मार्ग अपने-अपने स्तर के साधकों के लिए हैं। जिनका मन स्थिर और विवेकपूर्ण है, वे ज्ञानयोग में सफल होते हैं। जबकि जिनका स्वभाव सक्रिय और कर्मप्रधान है, उनके लिए कर्मयोग अधिक उपयुक्त है। इस प्रकार भगवान स्पष्ट करते हैं कि दोनों मार्ग आवश्यक हैं।",
        englishMeaning = "Krishna explains that there are two paths: the path of knowledge for contemplative sages, and the path of action for those inclined to activity. Both are valid and lead to spiritual progress."
    ),

    Shloka(
        number = 4,
        sanskrit = "न कर्मणामनारम्भान्नैष्कर्म्यं पुरुषोऽश्नुते।\nन च संन्यसनादेव सिद्धिं समधिगच्छति॥",
        hindiMeaning = "भगवान कहते हैं कि केवल कर्म न करने से मनुष्य निष्कर्मता या मुक्ति को प्राप्त नहीं करता। और केवल संन्यास धारण करने से भी सिद्धि प्राप्त नहीं होती। वास्तविक मुक्ति तो तब होती है जब मनुष्य कर्म करता हुआ भी आसक्ति और फल की इच्छा से मुक्त रहता है। कर्म से भागना या केवल बाह्य त्याग करना वास्तविक त्याग नहीं है। इसलिए अर्जुन को यह समझना चाहिए कि युद्ध से भागकर संन्यास लेने से उसे सिद्धि नहीं मिलेगी।",
        englishMeaning = "One does not attain freedom from action by merely avoiding work, nor does one reach perfection by renunciation alone. True liberation comes through selfless action."
    ),

    Shloka(
        number = 5,
        sanskrit = "न हि कश्चित्क्षणमपि जातु तिष्ठत्यकर्मकृत्।\nकार्यते ह्यवशः कर्म सर्वः प्रकृतिजैर्गुणैः॥",
        hindiMeaning = "भगवान स्पष्ट करते हैं कि इस जगत में कोई भी व्यक्ति एक क्षण भी बिना कर्म किए नहीं रह सकता। प्रत्येक जीव प्रकृति के गुणों के प्रभाव से स्वाभाविक रूप से कर्म करने को विवश है। श्वास लेना, चलना, सोचना – ये सभी कर्म के अंतर्गत आते हैं। इसीलिए कर्म से भागना असंभव है। प्रश्न केवल इतना है कि कर्म स्वार्थपूर्ण किया जाए या निःस्वार्थ भाव से। यदि कर्म भगवान को समर्पित होकर किया जाए तो वही मुक्ति का साधन बन जाता है।",
        englishMeaning = "No one can remain without action even for a moment. Everyone is driven to act by the qualities of nature, whether willingly or unwillingly."
    ),

    Shloka(
        number = 6,
        sanskrit = "कर्मेन्द्रियाणि संयम्य य आस्ते मनसा स्मरन्।\nइन्द्रियार्थान्विमूढात्मा मिथ्याचारः स उच्यते॥",
        hindiMeaning = "श्रीकृष्ण कहते हैं कि जो व्यक्ति बाहर से तो इन्द्रियों को संयमित करता है, लेकिन भीतर ही भीतर विषयों का चिंतन करता रहता है, वह मिथ्याचारी कहलाता है। उसका आचरण पाखंडी है, क्योंकि बाहरी संयम वास्तविक आत्मसंयम नहीं है। यदि मन भीतर से विषयों में रमता है तो इन्द्रिय संयम का कोई मूल्य नहीं है। ऐसा व्यक्ति स्वयं को धोखा देता है और प्रगति नहीं कर सकता। आत्मिक उन्नति के लिए मन और इन्द्रियों का वास्तविक नियंत्रण आवश्यक है।",
        englishMeaning = "One who outwardly restrains the senses but dwells on objects in the mind is a hypocrite. Such self-deception does not lead to spiritual growth."
    ),

    Shloka(
        number = 7,
        sanskrit = "यस्त्विन्द्रियाणि मनसा नियम्यारभतेऽर्जुन।\nकर्मेन्द्रियैः कर्मयोगमसक्तः स विशिष्यते॥",
        hindiMeaning = "भगवान आगे कहते हैं कि जो व्यक्ति मन से इन्द्रियों को नियंत्रित करता है और कर्मों में प्रवृत्त होता है, वही श्रेष्ठ है। वह अपने कर्मेन्द्रियों का प्रयोग करते हुए आसक्ति रहित होकर कर्म करता है। ऐसा साधक बाहरी संयम के साथ-साथ आंतरिक शुद्धता भी रखता है। वह कर्म को भगवान को समर्पित भाव से करता है, न कि फल की लालसा से। इस प्रकार कर्मयोगी ही वास्तविक साधक है।",
        englishMeaning = "But one who controls the senses with the mind and engages in selfless action without attachment is superior. Such a person is a true yogi."
    ),

    Shloka(
        number = 8,
        sanskrit = "नियतं कुरु कर्म त्वं कर्म ज्यायो ह्यकर्मणः।\nशरीरयात्रापि च ते न प्रसिद्ध्येदकर्मणः॥",
        hindiMeaning = "भगवान अर्जुन से कहते हैं कि तुम्हें अपने नियत कर्म अवश्य करने चाहिए, क्योंकि कर्म करना अकर्म से श्रेष्ठ है। यदि मनुष्य कुछ न करे तो उसका शरीर भी नहीं चल सकेगा। शरीर को जीवित रखने के लिए भी कर्म आवश्यक है। इसीलिए युद्ध जैसे कठिन कार्य से भागना उचित नहीं है। नियत कर्म का पालन ही धर्म है और उससे ही प्रगति होती है।",
        englishMeaning = "Perform your prescribed duties, for action is better than inaction. Even the maintenance of the body would not be possible without work."
    ),

    Shloka(
        number = 9,
        sanskrit = "यज्ञार्थात्कर्मणोऽन्यत्र लोकोऽयं कर्मबन्धनः।\nतदर्थं कर्म कौन्तेय मुक्तसङ्गः समाचर॥",
        hindiMeaning = "भगवान कहते हैं कि यदि कर्म यज्ञार्थ अर्थात् भगवान को समर्पित भाव से नहीं किया जाता, तो वह कर्म बंधन का कारण बनता है। लेकिन यदि वही कर्म निःस्वार्थ होकर भगवान के लिए किया जाए तो वह मोक्ष का साधन बन जाता है। इसलिए, हे कौन्तेय! तुम अपने सभी कर्मों को यज्ञभाव से करो और आसक्ति से रहित रहो। इस प्रकार कर्म bondage का कारण न होकर मुक्ति का कारण बन जाएगा।",
        englishMeaning = "Work done as a sacrifice for the Lord frees one from bondage. But work done for selfish purposes binds. Therefore, perform action in a spirit of sacrifice, free from attachment."
    ),

    Shloka(
        number = 10,
        sanskrit = "सहयज्ञाः प्रजाः सृष्ट्वा पुरोवाच प्रजापतिः।\nअनेन प्रसविष्यध्वमेष वोऽस्त्विष्टकामधुक्॥",
        hindiMeaning = "भगवान बताते हैं कि सृष्टि के प्रारंभ में प्रजापति ब्रह्मा ने मनुष्यों और यज्ञ को एक साथ उत्पन्न किया और कहा – 'तुम इस यज्ञ के द्वारा वृद्धि और पोषण पाओगे। यह यज्ञ तुम्हारी सभी कामनाओं को पूर्ण करने वाला होगा।' इसका अर्थ है कि कर्म और यज्ञ मानव जीवन के अभिन्न अंग हैं। यज्ञ का तात्पर्य केवल अग्नि में आहुति देना नहीं है, बल्कि निःस्वार्थ भाव से किया गया प्रत्येक कार्य यज्ञ है। यही कर्म का शुद्ध स्वरूप है।",
        englishMeaning = "In the beginning, the Creator made mankind along with sacrifice and said: 'By sacrifice you shall prosper, and sacrifice will fulfill your desires.'"
    ),
    Shloka(
        number = 11,
        sanskrit = "देवान्भावयतानेन ते देवा भावयन्तु वः।\nपरस्परं भावयन्तः श्रेयः परमवाप्स्यथ॥",
        hindiMeaning = "भगवान कहते हैं कि इस यज्ञभाव से तुम देवताओं को प्रसन्न करो और देवता तुम्हें प्रसन्न करेंगे। इस प्रकार परस्पर सहयोग से तुम परम कल्याण को प्राप्त करोगे। यहाँ 'देवता' का अर्थ केवल देवस्वरूप शक्तियों से नहीं, बल्कि वे सब दिव्य शक्तियाँ हैं जो सृष्टि के संचालन में सहायक हैं। मनुष्य जब अपने कर्मों को निःस्वार्थ और समर्पण भाव से करता है, तो वह प्रकृति और समाज के संतुलन को बनाए रखता है। इसके बदले में प्रकृति और समाज उसे आवश्यक सहयोग और साधन प्रदान करते हैं। यही संतुलन जीवन को सुखी और उन्नत बनाता है।",
        englishMeaning = "By sacrifice, you nourish the gods, and they will nourish you in return. Thus, by mutual cooperation, you shall attain the highest good."
    ),

    Shloka(
        number = 12,
        sanskrit = "इष्टान्भोगान्हि वो देवा दास्यन्ते यज्ञभाविताः।\nतैर्दत्तानप्रदायैभ्यो यो भुङ्क्ते स्तेन एव सः॥",
        hindiMeaning = "भगवान कहते हैं कि यज्ञ से प्रसन्न होकर देवता तुम्हें इच्छित भोग देंगे। लेकिन जो व्यक्ति इन देवताओं द्वारा दिए गए संसाधनों का उपयोग करता है और बदले में कुछ नहीं लौटाता, वह वास्तव में चोर है। यहाँ चोर का अर्थ है – वह जो केवल लेता है और देता कुछ नहीं। प्रकृति, समाज और ईश्वर से प्राप्त उपकारों का प्रतिदान न करके जो केवल अपने स्वार्थ के लिए उनका उपभोग करता है, वह अधर्म करता है। इसीलिए मनुष्य को हमेशा निःस्वार्थ भाव से यज्ञ और सेवा करनी चाहिए।",
        englishMeaning = "The gods will provide you with desired needs when pleased by sacrifice. But one who enjoys these gifts without offering back is a thief."
    ),

    Shloka(
        number = 13,
        sanskrit = "यज्ञशिष्टाशिनः सन्तो मुच्यन्ते सर्वकिल्बिषैः।\nभुञ्जते ते त्वघं पापा ये पचन्त्यात्मकारणात्॥",
        hindiMeaning = "भगवान कहते हैं कि जो संत यज्ञशेष अन्न का सेवन करते हैं, वे सभी पापों से मुक्त हो जाते हैं। लेकिन जो लोग केवल अपने लिए, स्वार्थवश भोजन पकाते हैं, वे पाप का भक्षण करते हैं। यज्ञशेष अन्न का तात्पर्य है वह भोजन या संसाधन जिसे भगवान को अर्पित करके ग्रहण किया जाए। जब हम निःस्वार्थ भाव से भगवान को अर्पण करते हैं, तो वह अन्न पवित्र बन जाता है। लेकिन केवल स्वार्थ के लिए किया गया उपभोग मनुष्य को बंधन और पाप की ओर ले जाता है।",
        englishMeaning = "The righteous who eat what remains from sacrifice are freed from all sins. But those who cook only for themselves eat only sin."
    ),

    Shloka(
        number = 14,
        sanskrit = "अन्नाद्भवन्ति भूतानि पर्जन्यादन्नसम्भवः।\nयज्ञाद्भवति पर्जन्यो यज्ञः कर्मसमुद्भवः॥",
        hindiMeaning = "भगवान यहाँ सृष्टि का शाश्वत नियम बताते हैं। सभी प्राणी अन्न से उत्पन्न होते हैं, अन्न वर्षा से उत्पन्न होता है, वर्षा यज्ञ से होती है और यज्ञ कर्म से उत्पन्न होता है। इसका अर्थ यह है कि संपूर्ण जीवन चक्र परस्पर एक-दूसरे पर आधारित है। यदि मनुष्य निःस्वार्थ कर्म और यज्ञ करेगा तो वर्षा और अन्न की समृद्धि बनी रहेगी। लेकिन यदि वह स्वार्थी होकर प्रकृति के नियमों की उपेक्षा करेगा, तो संतुलन बिगड़ जाएगा। यह गीता का गहरा पर्यावरणीय और सामाजिक संदेश है।",
        englishMeaning = "All beings are sustained by food, food comes from rain, rain from sacrifice, and sacrifice arises from prescribed action. Thus, life is sustained by selfless work."
    ),

    Shloka(
        number = 15,
        sanskrit = "कर्म ब्रह्मोद्भवं विद्धि ब्रह्माक्षरसमुद्भवम्।\nतस्मात्सर्वगतं ब्रह्म नित्यं यज्ञे प्रतिष्ठितम्॥",
        hindiMeaning = "भगवान कहते हैं कि कर्म वेदों से उत्पन्न है और वेद अविनाशी ब्रह्म से उत्पन्न हैं। इसलिए कर्म का आधार ब्रह्म है और ब्रह्म सदा यज्ञ में प्रतिष्ठित है। इसका तात्पर्य है कि समस्त कर्म अंततः दिव्य नियमों से जुड़े हुए हैं। जब हम यज्ञभाव से कर्म करते हैं, तब हम वास्तव में ईश्वर की इच्छा का पालन करते हैं। इसीलिए प्रत्येक कर्म को पवित्र मानकर भगवान को अर्पित करना चाहिए।",
        englishMeaning = "Know that action arises from the Vedas, and the Vedas come from the imperishable Brahman. Therefore, the all-pervading Brahman is eternally present in sacrifice."
    ),

    Shloka(
        number = 16,
        sanskrit = "एवं प्रवर्तितं चक्रं नानुवर्तयतीह यः।\nअघायुरिन्द्रियारामो मोघं पार्थ स जीवति॥",
        hindiMeaning = "भगवान कहते हैं कि इस प्रकार सृष्टि का यह चक्र – यज्ञ, वर्षा, अन्न और जीवन – जो दिव्य नियमों से स्थापित हुआ है, यदि कोई उसका पालन नहीं करता, तो वह व्यर्थ जीता है। ऐसा व्यक्ति पापमय जीवन जीता है और केवल इन्द्रियों की तृप्ति में लिप्त रहता है। उसका जीवन केवल भोग और स्वार्थ तक सीमित होता है। लेकिन ऐसा जीवन न स्वयं के लिए कल्याणकारी होता है, न ही समाज और प्रकृति के लिए। इसीलिए इस चक्र का पालन करना प्रत्येक मनुष्य का कर्तव्य है।",
        englishMeaning = "He who does not follow the divine cycle of sacrifice lives in sin, delighting only in the senses. O Arjuna, such a life is wasted."
    ),

    Shloka(
        number = 17,
        sanskrit = "यस्त्वात्मरतिरेव स्यादात्मतृप्तश्च मानवः।\nआत्मन्येव च सन्तुष्टस्तस्य कार्यं न विद्यते॥",
        hindiMeaning = "भगवान कहते हैं कि जो मनुष्य आत्मा में ही आनंदित है, आत्मा में ही तृप्त है और आत्मा में ही संतुष्ट है, उसके लिए कोई भी कर्म करना शेष नहीं रहता। ऐसा व्यक्ति बाहरी भोग और साधनों पर निर्भर नहीं होता। उसकी शांति और आनंद केवल आत्मज्ञान से ही पूर्ण होती है। इसलिए उसे किसी बाहरी कर्तव्य की आवश्यकता नहीं है। यह अवस्था केवल परम ज्ञानी और सिद्ध पुरुषों के लिए संभव है।",
        englishMeaning = "But the person who delights in the self, is satisfied in the self, and is content in the self alone, has no duty to perform."
    ),

    Shloka(
        number = 18,
        sanskrit = "नैव तस्य कृतेनार्थो नाकृतेनेह कश्चन।\nन चास्य सर्वभूतेषु कश्चिदर्थव्यपाश्रयः॥",
        hindiMeaning = "भगवान आगे कहते हैं कि ऐसे आत्मतृप्त पुरुष का न तो किए गए कर्मों से कोई लाभ है और न ही कर्म न करने से कोई हानि। वह किसी भी प्राणी या वस्तु पर आश्रित नहीं होता। उसका जीवन पूर्ण स्वतंत्रता और आत्मनिर्भरता से युक्त होता है। उसका सुख और शांति किसी बाहरी साधन पर आधारित नहीं होता। इस प्रकार वह सच्चा मुक्त आत्मा होता है।",
        englishMeaning = "For such a self-realized person, there is nothing to gain from action or inaction, nor does he depend on any being for anything."
    ),

    Shloka(
        number = 19,
        sanskrit = "तस्मादसक्तः सततं कार्यं कर्म समाचर।\nअसक्तो ह्याचरन्कर्म परमाप्नोति पूरुषः॥",
        hindiMeaning = "भगवान अर्जुन से कहते हैं कि इसलिए तुम आसक्ति रहित होकर सदा अपने नियत कर्म करो। जब मनुष्य आसक्ति रहित होकर कर्म करता है, तो वह परम सिद्धि को प्राप्त करता है। कर्म से भागना नहीं, बल्कि उसे निःस्वार्थ भाव से करना ही मोक्ष का साधन है। ऐसे कर्म से व्यक्ति समाज का कल्याण भी करता है और आत्मा को भी शुद्ध करता है। यही कर्मयोग का मूल सिद्धांत है।",
        englishMeaning = "Therefore, perform your duty without attachment. By working without attachment, a person attains the Supreme."
    ),

    Shloka(
        number = 20,
        sanskrit = "कर्मणैव हि संसिद्धिमास्थिता जनकादयः।\nलोकसंग्रहमेवापि सम्पश्यन्कर्तुमर्हसि॥",
        hindiMeaning = "भगवान कहते हैं कि जनक आदि राजाओं ने केवल कर्म के द्वारा ही सिद्धि प्राप्त की थी। वे राजकार्य करते हुए भी आत्मज्ञानी और मुक्त थे। इसलिए हे अर्जुन! तुम्हें भी लोकसंग्रह अर्थात् समाज के कल्याण के लिए कर्म करना चाहिए। जब ज्ञानी व्यक्ति समाज के लिए कर्म करता है, तो लोग उसका अनुकरण करते हैं और धर्म का पालन करते हैं। इस प्रकार कर्मयोग केवल व्यक्तिगत मोक्ष ही नहीं, बल्कि सामूहिक कल्याण का मार्ग भी है।",
        englishMeaning = "Perfection was attained by kings like Janaka through action alone. Therefore, you too should perform action, keeping in mind the welfare of the world."
    ),

    Shloka(
        number = 21,
        sanskrit = "यद्यदाचरति श्रेष्ठस्तत्तदेवेतरो जनः।\nस यत्प्रमाणं कुरुते लोकस्तदनुवर्तते॥",
        hindiMeaning = "भगवान कहते हैं कि श्रेष्ठ पुरुष जो भी आचरण करता है, सामान्य लोग उसका अनुसरण करते हैं। समाज हमेशा अपने आदर्शों को देखकर प्रेरणा लेता है। इसलिए यदि नेता, गुरु या ज्ञानी व्यक्ति धर्म और कर्तव्य का पालन करता है, तो अन्य लोग भी वही मार्ग अपनाते हैं। इस कारण श्रेष्ठ लोगों की जिम्मेदारी और बढ़ जाती है। यदि वे गलत मार्ग अपनाएँगे तो समाज भी भटक जाएगा। इसलिए अर्जुन! तुम्हें अपना आचरण आदर्श बनाना चाहिए ताकि लोग तुम्हारे उदाहरण से प्रेरणा लें।",
        englishMeaning = "Whatever a great person does, others follow. People look up to their leaders as examples and act accordingly."
    ),

    Shloka(
        number = 22,
        sanskrit = "न मे पार्थास्ति कर्तव्यं त्रिषु लोकेषु किञ्चन।\nनानवाप्तमवाप्तव्यं वर्त एव च कर्मणि॥",
        hindiMeaning = "भगवान कहते हैं कि हे पार्थ! तीनों लोकों में मेरे लिए कोई कर्तव्य नहीं है। मुझे कुछ प्राप्त करना शेष नहीं है और न ही कुछ अप्राप्त रह गया है। फिर भी मैं कर्म में निरंतर लगा रहता हूँ। इसका कारण यह है कि ईश्वर स्वयं कर्म करके संसार को आदर्श दिखाते हैं। यदि ईश्वर भी निष्क्रिय हो जाएँ तो सृष्टि का संचालन ही रुक जाएगा। इस प्रकार भगवान स्वयं कर्म के महत्व को प्रत्यक्ष रूप से दिखाते हैं।",
        englishMeaning = "O Arjuna, I have nothing to gain or achieve in all the three worlds, yet I am always engaged in action."
    ),

    Shloka(
        number = 23,
        sanskrit = "यदि ह्यहं न वर्तेयं जातु कर्मण्यतन्द्रितः।\nमम वर्त्मानुवर्तन्ते मनुष्याः पार्थ सर्वशः॥",
        hindiMeaning = "भगवान कहते हैं कि यदि मैं कभी भी कर्म में तत्पर न रहूँ, तो लोग भी मेरी ही तरह आलसी और निष्क्रिय हो जाएँगे। मनुष्य ईश्वर और महान व्यक्तियों को देखकर ही अपने आचरण का निर्धारण करता है। यदि ईश्वर स्वयं निष्क्रिय रहते, तो मनुष्य भी कर्तव्य का पालन छोड़ देता। इससे संसार का संतुलन बिगड़ जाता। इसलिए भगवान निरंतर कर्म में लगे रहते हैं ताकि लोग धर्म और कर्म का पालन करना न भूलें।",
        englishMeaning = "If I did not engage in action, O Arjuna, people would follow my example and stop acting as well."
    ),

    Shloka(
        number = 24,
        sanskrit = "उत्सीदेयुरिमे लोका न कुर्यां कर्म चेदहम्।\nसङ्करस्य च कर्ता स्यामुपहन्यामिमाः प्रजाः॥",
        hindiMeaning = "भगवान कहते हैं कि यदि मैं कर्म न करूँ, तो ये सभी लोक नष्ट हो जाएँगे। मैं समाज में अव्यवस्था और अधर्म का कारण बनूँगा। इससे प्रजा का विनाश हो जाएगा और जीवन का क्रम रुक जाएगा। इसलिए ईश्वर स्वयं भी कर्म करके सृष्टि का संचालन करते हैं। इस श्लोक से यह स्पष्ट होता है कि कर्म का त्याग करना विनाश का कारण है। कर्म का पालन करना ही जीवन और समाज को बनाए रखता है।",
        englishMeaning = "If I did not act, these worlds would perish. Disorder would prevail, and beings would be destroyed."
    ),

    Shloka(
        number = 25,
        sanskrit = "सक्ताः कर्मण्यविद्वांसो यथा कुर्वन्ति भारत।\nकुर्याद्विद्वांस्तथासक्तश्चिकीर्षुर्लोकसंग्रहम्॥",
        hindiMeaning = "भगवान कहते हैं कि हे भारत! अज्ञानी लोग आसक्ति से कर्म करते हैं, लेकिन ज्ञानी व्यक्ति भी आसक्ति रहित होकर कर्म करता है। वह कर्म इसलिए करता है ताकि संसार में संतुलन बना रहे और लोग उसका अनुसरण करें। ज्ञानी व्यक्ति जानता है कि आत्मा निर्लिप्त है, फिर भी वह लोकसंग्रह यानी समाज के कल्याण के लिए कर्म करता है। इस प्रकार ज्ञानी और अज्ञानी दोनों कर्म करते हैं, परंतु उनके भाव अलग होते हैं।",
        englishMeaning = "As the ignorant act with attachment, so should the wise act without attachment, for the welfare of the world."
    ),

    Shloka(
        number = 26,
        sanskrit = "न बुद्धिभेदं जनयेदज्ञानां कर्मसङ्गिनाम्।\nजोषयेत्सर्वकर्माणि विद्वान्युक्तः समाचरन्॥",
        hindiMeaning = "भगवान कहते हैं कि ज्ञानी को चाहिए कि अज्ञानियों में बुद्धिभेद न उत्पन्न करे। अर्थात् उन्हें कर्म के प्रति भ्रमित न करे। ज्ञानी स्वयं निःस्वार्थ कर्म करता हुआ उन्हें भी धीरे-धीरे सही मार्ग की ओर प्रेरित करे। यदि ज्ञानी अचानक कहे कि कर्म छोड़ दो, तो अज्ञानी लोग गलत मार्ग पर चल पड़ेंगे। इसलिए ज्ञानी को व्यवहार में सहजता रखनी चाहिए और धीरे-धीरे दूसरों को यथार्थ समझाना चाहिए।",
        englishMeaning = "The wise should not unsettle the minds of the ignorant attached to action. Instead, by performing action diligently, they should inspire others."
    ),

    Shloka(
        number = 27,
        sanskrit = "प्रकृतेः क्रियमाणानि गुणैः कर्माणि सर्वशः।\nअहङ्कारविमूढात्मा कर्ताहमिति मन्यते॥",
        hindiMeaning = "भगवान कहते हैं कि सभी कर्म प्रकृति के गुणों द्वारा किए जाते हैं। परंतु अहंकार से मोहित मनुष्य सोचता है कि 'मैं ही कर्ता हूँ।' वास्तव में आत्मा कर्म का कर्ता नहीं है, बल्कि प्रकृति के तीन गुण – सत्त्व, रज और तम – ही कर्म कराते हैं। अज्ञानवश मनुष्य स्वयं को कर्ता मान लेता है और इसी से बंधन उत्पन्न होता है। आत्मज्ञान होने पर यह भ्रम मिट जाता है और व्यक्ति मुक्त हो जाता है।",
        englishMeaning = "All actions are performed by the modes of material nature. But the deluded soul thinks, 'I am the doer.'"
    ),

    Shloka(
        number = 28,
        sanskrit = "तत्त्ववित्तु महाबाहो गुणकर्मविभागयोः।\nगुणा गुणेषु वर्तन्त इति मत्वा न सज्जते॥",
        hindiMeaning = "भगवान कहते हैं कि हे महाबाहु! जो तत्वज्ञानी है, वह गुण और कर्म के भेद को जानता है। वह समझता है कि केवल प्रकृति के गुण ही गुणों में कार्य कर रहे हैं। इसलिए वह उनमें आसक्त नहीं होता। ऐसा ज्ञानी व्यक्ति जानता है कि आत्मा इन सब कर्मों से परे और शुद्ध है। इस समझ के कारण वह निर्लिप्त और शांत रहता है।",
        englishMeaning = "But the one who knows the truth understands that the senses act among the sense objects, and thus he is not attached."
    ),

    Shloka(
        number = 29,
        sanskrit = "प्रकृतेर्गुणसम्मूढाः सज्जन्ते गुणकर्मसु।\nतानकृत्स्नविदो मन्दान्कृत्स्नविन्न विचालयेत्॥",
        hindiMeaning = "भगवान कहते हैं कि जो लोग प्रकृति के गुणों से मोहित होते हैं, वे गुण और कर्म में आसक्त हो जाते हैं। वे अज्ञान के कारण कर्म में फँस जाते हैं। ज्ञानी को चाहिए कि ऐसे अज्ञानी लोगों को विचलित न करे। बल्कि धीरे-धीरे उन्हें शिक्षा दे और उनकी समझ के अनुसार मार्गदर्शन करे। यदि उन्हें अचानक पूर्ण ज्ञान दिया जाए तो वे भ्रमित हो सकते हैं। इसलिए धैर्य और करुणा के साथ उन्हें कर्मयोग की ओर प्रेरित करना चाहिए।",
        englishMeaning = "Those who are deluded by the modes of nature become attached to their actions. The wise should not disturb them but guide them gently."
    ),

    Shloka(
        number = 30,
        sanskrit = "मयि सर्वाणि कर्माणि संन्यस्याध्यात्मचेतसा।\nनिराशीर्निर्ममो भूत्वा युध्यस्व विगतज्वरः॥",
        hindiMeaning = "भगवान कहते हैं कि हे अर्जुन! अपने सभी कर्म मुझे अर्पित कर दो और अपने मन को आध्यात्मिक चेतना में स्थिर करो। आशा और ममता का त्याग करके युद्ध करो। ऐसा करने पर तुम्हारे भीतर कोई मानसिक क्लेश या संशय नहीं रहेगा। जब मनुष्य अपने कर्म को ईश्वर को अर्पित कर देता है, तो वह मुक्त हो जाता है। इस प्रकार कर्तव्य का पालन करते हुए भी आत्मा बंधन से परे रहती है।",
        englishMeaning = "Surrender all your actions to me with a spiritual mind. Fight without desire or attachment, free from mental agitation."
    ),
    Shloka(
        number = 31,
        sanskrit = "ये मे मतमिदं नित्यमनुतिष्ठन्ति मानवाः।\nश्रद्धावन्तोऽनसूयन्तो मुच्यन्ते तेऽपि कर्मभिः॥",
        hindiMeaning = "भगवान कहते हैं कि जो लोग मेरे इस मत का नित्य पालन करते हैं, श्रद्धा रखते हैं और दोषदृष्टि नहीं करते, वे भी कर्मों से मुक्त हो जाते हैं। श्रद्धा यहाँ अत्यंत महत्वपूर्ण है क्योंकि बिना विश्वास के कोई भी साधना सफल नहीं हो सकती। जब मनुष्य ईश्वर की आज्ञा को सर्वोच्च मानकर अपने कर्म करता है, तब उसके कर्म बंधनरहित हो जाते हैं। ऐसा व्यक्ति जीवन में शांति और मुक्ति की ओर अग्रसर होता है। इस श्लोक में स्पष्ट है कि केवल ज्ञान ही नहीं, बल्कि श्रद्धा और समर्पण भी आवश्यक हैं।",
        englishMeaning = "Those who follow my teaching faithfully, without envy, are freed from the bondage of karma."
    ),

    Shloka(
        number = 32,
        sanskrit = "ये त्वेतदभ्यसूयन्तो नानुतिष्ठन्ति मे मतम्।\nसर्वज्ञानविमूढांस्तान्विद्धि नष्टानचेतसः॥",
        hindiMeaning = "भगवान कहते हैं कि जो लोग इस उपदेश की निंदा करते हैं और इसे नहीं मानते, वे सभी ज्ञान से वंचित होकर नष्ट हो जाते हैं। ऐसे लोग बुद्धिहीन और अविवेकी होते हैं। वे सत्य को स्वीकार नहीं कर पाते और अपने अहंकार में अंधे बने रहते हैं। इसके परिणामस्वरूप उनका जीवन व्यर्थ हो जाता है। ऐसे लोगों का अंत दुख और अधोगति में होता है।",
        englishMeaning = "But those who ridicule and do not follow this teaching are deluded of all knowledge and doomed to destruction."
    ),

    Shloka(
        number = 33,
        sanskrit = "सदृशं चेष्टते स्वस्याः प्रकृतेर्ज्ञानवानपि।\nप्रकृतिं यान्ति भूतानि निग्रहः किं करिष्यति॥",
        hindiMeaning = "भगवान कहते हैं कि ज्ञानी भी अपनी प्रकृति के अनुसार ही आचरण करता है। सभी प्राणी अपनी प्रकृति का अनुसरण करते हैं, फिर दमन करने से क्या होगा? इसका अर्थ यह है कि प्रत्येक व्यक्ति अपनी प्रवृत्ति और गुणों से प्रभावित होकर कर्म करता है। केवल बाहरी दबाव डालकर मनुष्य को बदलना संभव नहीं है। परिवर्तन तभी होता है जब भीतर से आत्मज्ञान जागृत हो। इसीलिए आत्मा की शुद्धि और आंतरिक साधना सबसे महत्वपूर्ण है।",
        englishMeaning = "Even the wise act according to their nature. All beings follow their nature, so what will repression achieve?"
    ),

    Shloka(
        number = 34,
        sanskrit = "इन्द्रियस्येन्द्रियस्यार्थे रागद्वेषौ व्यवस्थितौ।\nतयोर्न वशमागच्छेत्तौ ह्यस्य परिपन्थिनौ॥",
        hindiMeaning = "भगवान कहते हैं कि प्रत्येक इन्द्रिय का अपने विषय के साथ राग और द्वेष स्वाभाविक रूप से जुड़ा होता है। लेकिन मनुष्य को चाहिए कि वह इनके वश में न हो। राग और द्वेष ही मनुष्य के मार्ग में सबसे बड़े शत्रु हैं। यदि मनुष्य राग में फँसता है तो वह आसक्त हो जाता है, और यदि द्वेष में फँसता है तो उसका जीवन कड़वाहट से भर जाता है। इसलिए साधक को विवेकपूर्वक इन्द्रियों पर नियंत्रण करना चाहिए।",
        englishMeaning = "Attachment and aversion reside in the senses towards their objects. One should not fall under their control, for they are obstacles."
    ),

    Shloka(
        number = 35,
        sanskrit = "श्रेयान्स्वधर्मो विगुणः परधर्मात्स्वनुष्ठितात्।\nस्वधर्मे निधनं श्रेयः परधर्मो भयावहः॥",
        hindiMeaning = "भगवान कहते हैं कि अपना धर्म चाहे गुणहीन क्यों न हो, वह परधर्म से श्रेष्ठ है। स्वधर्म का पालन करते हुए मृत्यु भी श्रेयस्कर है। परधर्म का पालन हमेशा भयावह और विनाशकारी होता है। इसका गहरा अर्थ यह है कि प्रत्येक मनुष्य को अपनी प्रकृति, क्षमता और कर्तव्य के अनुसार कर्म करना चाहिए। दूसरों का धर्म अपनाना हमेशा अस्थिरता और संकट लाता है। इसीलिए अर्जुन को अपने क्षत्रिय धर्म का पालन करके युद्ध करना चाहिए।",
        englishMeaning = "Better is one’s own duty though imperfect than another’s duty well performed. Death in one’s own duty is better; another’s duty brings fear."
    ),

    Shloka(
        number = 36,
        sanskrit = "अर्जुन उवाच ।\nअथ केन प्रयुक्तोऽयं पापं चरति पूरुषः।\nअनिच्छन्नपि वार्ष्णेय बलादिव नियोजितः॥",
        hindiMeaning = "अर्जुन ने पूछा – हे वार्ष्णेय! मनुष्य अनिच्छा होते हुए भी पाप क्यों करता है? मानो कोई उसे बलपूर्वक प्रेरित कर रहा हो। अर्जुन का प्रश्न अत्यंत गहन है क्योंकि वह जानना चाहता है कि वह कौन-सी शक्ति है जो मनुष्य को उसकी इच्छा के विरुद्ध भी अधर्म की ओर खींच ले जाती है। यह प्रश्न वास्तव में पूरे मानव जीवन के लिए अत्यंत महत्वपूर्ण है।",
        englishMeaning = "Arjuna asked: O Krishna, what force impels a person to commit sin, even unwillingly, as if compelled by force?"
    ),

    Shloka(
        number = 37,
        sanskrit = "श्रीभगवानुवाच ।\nकाम एष क्रोध एष रजोगुणसमुद्भवः।\nमहाशनो महापाप्मा विद्ध्येनमिह वैरिणम्॥",
        hindiMeaning = "भगवान उत्तर देते हैं – यह काम और क्रोध है, जो रजोगुण से उत्पन्न होते हैं। ये अतृप्त रहने वाले और महान पाप करने वाले शत्रु हैं। काम की पूर्ति न होने पर क्रोध उत्पन्न होता है, और क्रोध से विवेक नष्ट हो जाता है। काम और क्रोध ही मनुष्य को पाप और अधोगति की ओर ले जाते हैं। इसलिए इन्हें मनुष्य का सबसे बड़ा शत्रु कहा गया है। साधक को सबसे पहले इन्हें नियंत्रित करने का प्रयास करना चाहिए।",
        englishMeaning = "The Supreme Lord said: It is desire and anger, born of the mode of passion, that impel one to sin. They are insatiable and wicked enemies."
    ),

    Shloka(
        number = 38,
        sanskrit = "धूमेनाव्रियते वह्निर्यथादर्शो मलेन च।\nयथोल्बेनावृतो गर्भस्तथा तेनेदमावृतम्॥",
        hindiMeaning = "भगवान कहते हैं कि जैसे अग्नि धुएँ से, दर्पण मैल से और गर्भाशय शिशु को ढक लेता है, वैसे ही काम और क्रोध ज्ञान को ढक देते हैं। यह अज्ञान आत्मा के वास्तविक प्रकाश को छिपा देता है। मनुष्य की बुद्धि कामना और क्रोध में लिप्त होकर सत्य को नहीं देख पाती। यही कारण है कि आत्मा होने पर भी मनुष्य बंधन में रहता है। जब तक काम और क्रोध का नाश नहीं होगा, तब तक ज्ञान पूर्ण रूप से प्रकट नहीं होगा।",
        englishMeaning = "As fire is covered by smoke, a mirror by dust, or a fetus by the womb, so is knowledge covered by desire."
    ),

    Shloka(
        number = 39,
        sanskrit = "आवृतं ज्ञानमेतेन ज्ञानिनो नित्यवैरिणा।\nकामरूपेण कौन्तेय दुष्पूरेणानलेन च॥",
        hindiMeaning = "भगवान कहते हैं कि हे कौन्तेय! यह काम रूपी अग्नि ज्ञान को ढक देती है। यह ज्ञानी का भी शाश्वत शत्रु है। कामना कभी भी पूर्ण नहीं होती, वह निरंतर बढ़ती ही रहती है। इस अतृप्त इच्छा के कारण मनुष्य का विवेक नष्ट होता है। इसीलिए काम को मनुष्य का सबसे बड़ा शत्रु कहा गया है। केवल विवेक और संयम से ही इसका नाश किया जा सकता है।",
        englishMeaning = "O Arjuna, this eternal enemy of the wise is lust, which burns like an insatiable fire and covers true knowledge."
    ),

    Shloka(
        number = 40,
        sanskrit = "इन्द्रियाणि मनो बुद्धिरस्याधिष्ठानमुच्यते।\nएतैर्विमोहयत्येष ज्ञानमावृत्य देहिनम्॥",
        hindiMeaning = "भगवान कहते हैं कि इस काम का निवास इन्द्रियों, मन और बुद्धि में है। यही सब मिलकर आत्मा के ज्ञान को ढक देते हैं। मनुष्य इनसे मोहित होकर सत्य को भूल जाता है। इन्द्रियाँ विषयों की ओर दौड़ती हैं, मन उनमें उलझता है और बुद्धि कामना के पक्ष में तर्क करती है। इस प्रकार मनुष्य का संपूर्ण व्यक्तित्व वासनाओं के अधीन हो जाता है।",
        englishMeaning = "Desire dwells in the senses, the mind, and the intellect. Through them, it bewilders the soul by covering knowledge."
    ),

    Shloka(
        number = 41,
        sanskrit = "तस्मात्त्वमिन्द्रियाण्यादौ नियम्य भरतर्षभ।\nपाप्मानं प्रजहि ह्येनं ज्ञानविज्ञाननाशनम्॥",
        hindiMeaning = "भगवान कहते हैं कि इसलिए हे भरतश्रेष्ठ! सबसे पहले इन्द्रियों को नियंत्रित करो और फिर इस पापात्मा काम को नष्ट करो। यह काम ज्ञान और विज्ञान दोनों का नाश कर देता है। साधक को अपनी साधना की शुरुआत इन्द्रियनिग्रह से करनी चाहिए। यदि इन्द्रियाँ वश में होंगी, तो मन और बुद्धि भी धीरे-धीरे स्थिर हो जाएँगे। यही आत्मसाधना का पहला और आवश्यक चरण है।",
        englishMeaning = "Therefore, O best of the Bharatas, control the senses first and slay this sinful desire, which destroys knowledge and wisdom."
    ),

    Shloka(
        number = 42,
        sanskrit = "इन्द्रियाणि पराण्याहुरिन्द्रियेभ्यः परं मनः।\nमनसस्तु परा बुद्धिर्यो बुद्धेः परतस्तु सः॥",
        hindiMeaning = "भगवान कहते हैं कि इन्द्रियाँ स्थूल स्तर पर कार्य करती हैं, मन उनसे श्रेष्ठ है, बुद्धि मन से श्रेष्ठ है और आत्मा बुद्धि से भी परे है। यह क्रम दिखाता है कि आत्मा सबसे ऊँची और शुद्ध सत्ता है। मन और बुद्धि इन्द्रियों को नियंत्रित कर सकती हैं, लेकिन आत्मा मन और बुद्धि से भी परे है। साधक को इस तथ्य को समझकर अपनी साधना को आत्मा की ओर मोड़ना चाहिए। यही मोक्ष का मार्ग है।",
        englishMeaning = "The senses are said to be higher than the body, the mind higher than the senses, the intellect higher than the mind, and the soul higher than the intellect."
    ),

    Shloka(
        number = 43,
        sanskrit = "एवं बुद्धेः परं बुद्ध्वा संस्तभ्यात्मानमात्मना।\nजहि शत्रुं महाबाहो कामरूपं दुरासदम्॥",
        hindiMeaning = "भगवान कहते हैं कि जब मनुष्य आत्मा को बुद्धि से भी श्रेष्ठ समझकर अपने मन और बुद्धि को आत्मा में स्थिर कर देता है, तब वह इस काम रूपी शत्रु को जीत सकता है। यह शत्रु अत्यंत कठिनाई से जीता जाता है क्योंकि यह मनुष्य के भीतर ही छिपा रहता है। लेकिन आत्मज्ञान और आत्मसंयम के द्वारा इसे वश में किया जा सकता है। इसलिए हे महाबाहु अर्जुन! आत्मा की शक्ति से इस शत्रु का विनाश करो और मुक्त हो जाओ।",
        englishMeaning = "Thus, knowing the soul to be higher than the intellect, control the mind by the self and conquer the enemy, desire, which is difficult to overcome."
    )
)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaThreeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 3 – कर्मयोग",
                        fontSize = 26.sp,
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
            FloatingActionButton(
                onClick = { navController.navigate(Screen.QuizThree.route) }, // ✅ Go to Quiz 3
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
                        painter = painterResource(R.drawable.gemini_generated_image_olevlwolevlwolev),
                        contentDescription = "Chapter 3 – Karma Yoga",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaThreeShlokas) { shloka ->
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
