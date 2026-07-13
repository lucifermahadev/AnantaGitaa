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

val adhyayaOneShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "धृतराष्ट्र उवाच- धर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः। मामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय।।",
        hindiMeaning = "धृतराष्ट्र पूछते हैं कि हे संजय! धर्मभूमि कुरुक्षेत्र में, युद्ध के लिए एकत्रित मेरे पुत्र और पाण्डु पुत्र क्या कर रहे हैं? यह श्लोक युद्ध के मैदान में घटित घटनाओं के बारे में जानने की इच्छा को दर्शाता है। यह अर्जुन और कुरुक्षेत्र के संघर्ष की शुरुआत है, जिसमें राजा अपने पुत्रों और पाण्डवों की स्थिति जानना चाहते हैं।",
        englishMeaning = "Dhritarashtra asks Sanjaya what his sons and the Pandavas are doing on the battlefield of Kurukshetra."
    ),

    Shloka(
        number = 2,
        sanskrit = "सञ्जय उवाच- दृष्ट्वा तु पाण्डवानीकं व्यूढं दुर्योधनस्तदा। आचार्यमुपसङ्गम्य राजा वचनमब्रवीत्।।",
        hindiMeaning = "संजय कहते हैं कि राजा दुर्योधन ने पाण्डवों की सेना को व्यवस्थित देखा और आचार्य द्रोण से मिलकर उनसे बातें की। यह श्लोक युद्ध के लिए सेनाओं की तैयारियों और रणनीति की जानकारी देता है। दुर्योधन की चिंता और उत्साह यहाँ स्पष्ट होता है कि अब युद्ध अपरिहार्य है।",
        englishMeaning = "Sanjaya said that Duryodhana, seeing the Pandava army arranged, approached his teacher Drona and spoke."
    ),

    Shloka(
        number = 3,
        sanskrit = "पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम्। व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता।।",
        hindiMeaning = "दुर्योधन कहते हैं, हे आचार्य! आप देखिए, आपके शिष्य द्रुपदपुत्र (द्रौपदी के भाई) ने पाण्डवों की बड़ी सेना को व्यवस्थित किया है। यह श्लोक युद्ध की तैयारी में पाण्डवों की शक्ति और उनके अनुशासन को दर्शाता है। दुर्योधन के मन में भय और चिंता का भाव है।",
        englishMeaning = "Duryodhana observes the vast Pandava army arranged by your wise disciple, Dhrishtadyumna."
    ),

    Shloka(
        number = 4,
        sanskrit = "अत्र शूरा महेष्वासा भीमार्जुनसमा युधि। युयुधानो विराटश्च द्रुपदश्च महारथः।।",
        hindiMeaning = "इस सेना में शूरवीर हैं, जैसे भीम और अर्जुन, युयुधान और विराट, और द्रुपद भी महारथी हैं। यह श्लोक युद्ध के प्रमुख योद्धाओं की पहचान करता है। उनके गुण, वीरता और युद्ध कौशल का वर्णन किया गया है।",
        englishMeaning = "Here are heroes like Bhima, Arjuna, Yuyudhana, Virata, and Drupada, all great warriors."
    ),

    Shloka(
        number = 5,
        sanskrit = "धृष्टकेतुश्चेकितानः काशिराजश्च वीर्यवान्।पुरुजित्कुन्तिभोजश्च शैब्यश्च नरपुङ्गवः।।",
        hindiMeaning = "धृष्टकेतु, शैब्य, काशी के राजा, वीर्यवान पुरुजित, कुन्तिभोज और अन्य श्रेष्ठ योद्धा इस सेना में हैं। यह श्लोक पाण्डव सेना के वीरों और उनकी योग्यता को सूचीबद्ध करता है। युद्ध के प्रत्येक योद्धा का साहस और क्षमता यहाँ वर्णित है।",
        englishMeaning = "Dhrishtaketu, Chekitana, the valiant king of Kashi, Purujit, Kuntibhoja, and Shaibya, leaders among men, are in the army."
    ),

    Shloka(
        number = 6,
        sanskrit = "युधामन्युश्च विक्रान्त उत्तमौजाश्च वीर्यवान्। सौभद्रश्च महारथः धर्मभिर्युद्धमातृषाः।।",
        hindiMeaning = "युधामन्यु, उत्तमौजा, सौभद्र जैसे महारथी योद्धा धर्म के पक्ष में युद्ध के लिए तैयार हैं। यह श्लोक उनके साहस और युद्ध में निपुणता को दर्शाता है। उनकी वीरता और धार्मिक धर्मपालन की भावना युद्ध में स्पष्ट होगी।",
        englishMeaning = "Yudhamanyu, Uttamauja, and the mighty Saubhadra, all uphold righteousness and are ready for battle."
    ),

    Shloka(
        number = 7,
        sanskrit = "अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम। नायकाः मम सैनिकानां संज्ञार्थं तान्ब्रवीमि ते।।",
        hindiMeaning = "दुर्योधन कहते हैं कि हे श्रेष्ठ ब्राह्मण! आप हमारे सैनिकों के लिए प्रमुख योद्धाओं की पहचान कीजिए। यह श्लोक सेना की संरचना और नेतृत्व की जानकारी देता है। युद्ध में प्रत्येक सैनिक के पास एक नायक होना आवश्यक है।",
        englishMeaning = "Duryodhana asks the best of Brahmins to identify the leaders of our army for knowledge."
    ),

    Shloka(
        number = 8,
        sanskrit = "भवान्भीष्मश्च कर्णश्च कृपश्च समितिंजनकः। अश्वत्थामा विकर्णश्च सौमदत्तिस्तथैव च।।",
        hindiMeaning = "आपके पास भीष्म, कर्ण, कृपा, शांतिमय जिनक और अश्वत्थामा, विकर्ण, सौमदत्त जैसे प्रमुख योद्धा हैं। यह श्लोक कौरव सेना के महान योद्धाओं की पहचान करता है। उनकी वीरता और युद्ध कौशल अपार हैं।",
        englishMeaning = "Your side has Bhishma, Karna, Kripa, Samitinjana, Ashvatthama, Vikarna, and Somadatta."
    ),

    Shloka(
        number = 9,
        sanskrit = "अयनेषु च सर्वेषु यथाभागमवस्थिताः। भिय़न्ते च महारथाः सर्वे सञ्जय ज्ञातुमिच्छति।।",
        hindiMeaning = "सभी ओर अपने-अपने हिस्से में महारथी सज्ज हैं। संजय ने इस व्यवस्था को देखा और सभी योद्धाओं की स्थिति जानना चाहा। यह श्लोक युद्ध के प्रारंभिक दृश्य और सेनाओं की तैयारी को दर्शाता है।",
        englishMeaning = "All are stationed according to their divisions; Sanjaya wished to know about all the mighty warriors."
    ),

    Shloka(
        number = 10,
        sanskrit = "ततः शंखाश्च भेर्यश्च पाण्डवानीकं व्यूढम्। दुर्योधनस्तदा प्राह द्रुपदपुत्रेण धीमता।।",
        hindiMeaning = "तत्पश्चात् पाण्डव सेना के लिए शंख और भेर्य बजाए गए। दुर्योधन ने द्रुपदपुत्र के पास जाकर उनसे कहा। यह श्लोक युद्ध की तैयारी और संकेत की प्रक्रिया को दर्शाता है।",
        englishMeaning = "Then the conchshells and kettledrums of the Pandavas were sounded; Duryodhana approached Dhrishtadyumna."
    ),

    Shloka(
        number = 11,
        sanskrit = "पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम्। व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता।।",
        hindiMeaning = "दुर्योधन कहता है कि हे आचार्य! आप देखिए कि आपके शिष्य द्रुपदपुत्र ने पाण्डवों की महाशक्ति व्यवस्थित की है। यह श्लोक युद्ध के प्रमुख योद्धाओं और सेनाओं की संरचना को दर्शाता है।",
        englishMeaning = "Duryodhana says, behold the great army of Pandavas arranged by your wise disciple, Dhrishtadyumna."
    ),

    Shloka(
        number = 12,
        sanskrit = "अत्र शूरा महेष्वासा भीमार्जुनसमा युधि। युयुधानो विराटश्च द्रुपदश्च महारथः।।",
        hindiMeaning = "इस सेना में शूरवीर हैं, जैसे भीम और अर्जुन, युयुधान और विराट, और द्रुपद भी महारथी हैं। यह श्लोक युद्ध के प्रमुख योद्धाओं की वीरता और क्षमता को बताता है।",
        englishMeaning = "Here are heroes like Bhima, Arjuna, Yuyudhana, Virata, and Drupada, all mighty in battle."
    ),
    Shloka(
        number = 13,
        sanskrit = "धृष्टद्युम्नोऽपि महानुभावः शूरा वीर्यवान्। महातेजाश्च बलवन्तश्च सर्वे युद्धविशारदाः।।",
        hindiMeaning = "इस सेना में धृष्टद्युम्न भी महानुभाव, वीर्यवान और युद्ध में प्रवीण हैं। सभी योद्धा महाप्रभावशाली, बलवान और युद्धकला में निपुण हैं। यह श्लोक पाण्डवों की सेना की शक्ति और साहस का वर्णन करता है। प्रत्येक योद्धा अपने कौशल, रणभूमि में निपुणता और निडरता के लिए प्रसिद्ध है। धृष्टद्युम्न का नेतृत्व और वीरता विशेष रूप से उल्लेखनीय है। यह श्लोक दर्शाता है कि युद्ध में पाण्डवों के पास अपार सामर्थ्य है।",
        englishMeaning = "Dhrishtadyumna is also a great warrior; all are mighty, valiant, and experts in battle."
    ),

    Shloka(
        number = 14,
        sanskrit = "अत्र शूरा महेष्वासा भीमार्जुनसमा युधि। युयुधानो विराटश्च द्रुपदश्च महारथः।।",
        hindiMeaning = "इस सेना में शूरवीर हैं, जैसे भीम और अर्जुन, युयुधान और विराट, और द्रुपद भी महारथी हैं। सभी योद्धा रणभूमि में महान साहस और शक्ति के धनी हैं। यह श्लोक युद्ध में प्रमुख योद्धाओं की स्थिति और उनके सामर्थ्य को दर्शाता है। उनकी वीरता और युद्ध कौशल सेना की ताकत को बढ़ाता है।",
        englishMeaning = "Here are heroes like Bhima, Arjuna, Yuyudhana, Virata, and Drupada, all mighty in battle."
    ),

    Shloka(
        number = 15,
        sanskrit = "धृष्टकेतुश्चेकितानः काशिराजश्च वीर्यवान्। पुरुजित्कुन्तिभोजश्च शैब्यश्च नरपुङ्गवः।।",
        hindiMeaning = "धृष्टकेतु, शैब्य, काशी के राजा, वीर्यवान पुरुजित, कुन्तिभोज और अन्य श्रेष्ठ योद्धा इस सेना में उपस्थित हैं। ये सभी अपनी वीरता, साहस और युद्धकौशल के लिए प्रसिद्ध हैं। यह श्लोक पाण्डवों की सेना के अनुभव और शक्ति का विवरण देता है। प्रत्येक योद्धा न केवल शौर्य में, बल्कि रणनीति और वीरता में भी दक्ष है। उनकी उपस्थिति सेना में आत्मविश्वास और दृढ़ता लाती है।",
        englishMeaning = "Dhrishtaketu, Chekitana, the valiant king of Kashi, Purujit, Kuntibhoja, and Shaibya, all distinguished warriors, are present."
    ),

    Shloka(
        number = 16,
        sanskrit = "युधामन्युश्च विक्रान्त उत्तमौजाश्च वीर्यवान्। सौभद्रश्च महारथः धर्मभिर्युद्धमातृषाः।।",
        hindiMeaning = "युधामन्यु, उत्तमौजा और सौभद्र जैसे महारथी योद्धा धर्म के पक्ष में युद्ध के लिए तैयार हैं। ये सभी वीरता, साहस और धर्मपरायणता में निपुण हैं। यह श्लोक सेना की तैयारी और धर्मपरायणता को दर्शाता है। युद्ध में उनकी वीरता से पाण्डवों की सेना अत्यंत सशक्त है। प्रत्येक योद्धा धर्म और न्याय के लिए अपनी शक्ति का प्रयोग करने को तत्पर है।",
        englishMeaning = "Yudhamanyu, Uttamauja, and Saubhadra, mighty warriors, are ready to fight for righteousness."
    ),

    Shloka(
        number = 17,
        sanskrit = "अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम। नायकाः मम सैनिकानां संज्ञार्थं तान्ब्रवीमि ते।।",
        hindiMeaning = "दुर्योधन कहते हैं कि हे श्रेष्ठ ब्राह्मण! आप हमारे सैनिकों के प्रमुख योद्धाओं की पहचान कीजिए। यह श्लोक सेना की संरचना और नेतृत्व को स्पष्ट करता है। युद्ध में प्रत्येक सैनिक के पास एक सक्षम नेता होना आवश्यक है। नेताओं की पहचान से रणभूमि में संगठन और नियंत्रण बनाए रखा जाता है। यह श्लोक रणभूमि में रणनीति और नेतृत्व की महत्ता को दर्शाता है।",
        englishMeaning = "Duryodhana asks the best Brahmin to identify the leaders of our army for proper organization."
    ),

    Shloka(
        number = 18,
        sanskrit = "भवान्भीष्मश्च कर्णश्च कृपश्च समितिंजनकः। अश्वत्थामा विकर्णश्च सौमदत्तिस्तथैव च।।",
        hindiMeaning = "इस सेना में भीष्म, कर्ण, कृपा, समितिंजनक, अश्वत्थामा, विकर्ण और सौमदत्त जैसे महान योद्धा हैं। ये सभी रणभूमि में अपराजेय और युद्धकला में निपुण हैं। यह श्लोक कौरव सेना के प्रमुख योद्धाओं की वीरता को दर्शाता है। उनकी उपस्थिति से दुश्मन पर दबाव बढ़ता है और सेना का मनोबल उच्च रहता है।",
        englishMeaning = "The army includes Bhishma, Karna, Kripa, Samitinjana, Ashvatthama, Vikarna, and Somadatta, all mighty warriors."
    ),

    Shloka(
        number = 19,
        sanskrit = "सौभद्रश्च महाबाहुः शिखण्डी च महारथः। धृष्टद्युम्नो विग्राह्य द्रुपदश्च महारथः।।",
        hindiMeaning = "सौभद्र, महाबाहु शिखण्डी, धृष्टद्युम्न और द्रुपद भी महारथी योद्धा हैं। ये सभी रणभूमि में शौर्य और क्षमता के धनी हैं। यह श्लोक युद्ध के प्रमुख योद्धाओं की वीरता और उनके नामों का वर्णन करता है। उनके साहस और नेतृत्व से सेना का मनोबल बढ़ता है।",
        englishMeaning = "Saubhadra, mighty-armed Shikhandi, Dhrishtadyumna, and Drupada are all great chariot-warriors."
    ),

    Shloka(
        number = 20,
        sanskrit = "अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम। नायकाः मम सैनिकानां संज्ञार्थं तान्ब्रवीमि ते।।",
        hindiMeaning = "दुर्योधन आचार्य से कहता है कि आप हमारे सैनिकों के श्रेष्ठ नायकों की पहचान कीजिए। यह श्लोक सेना के संगठन और रणनीति को स्पष्ट करता है। युद्ध में प्रत्येक योद्धा के पास मार्गदर्शक होना आवश्यक है। यह नेतृत्व सेना के अनुशासन और सामर्थ्य को बनाए रखता है।",
        englishMeaning = "Duryodhana asks to identify the chief warriors of our army for proper command."
    ),

    Shloka(
        number = 21,
        sanskrit = "पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम्। व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता।।",
        hindiMeaning = "दुर्योधन कहता है कि हे आचार्य! आप देखिए कि आपके शिष्य द्रुपदपुत्र ने पाण्डवों की महाशक्ति व्यवस्थित की है। यह श्लोक युद्ध में सेनाओं की संरचना और प्रमुख योद्धाओं की स्थिति को दर्शाता है। पाण्डवों की सेना अत्यंत संगठित और सशक्त है।",
        englishMeaning = "Duryodhana points out the Pandava army arranged by your disciple Dhrishtadyumna."
    ),

    Shloka(
        number = 22,
        sanskrit = "अत्र शूरा महेष्वासा भीमार्जुनसमा युधि। युयुधानो विराटश्च द्रुपदश्च महारथः।।",
        hindiMeaning = "इस सेना में भीम, अर्जुन, युयुधान, विराट और द्रुपद जैसे शूरवीर महारथी शामिल हैं। यह श्लोक पाण्डव सेना की प्रमुख वीरता और शक्ति को दर्शाता है। उनकी उपस्थिति युद्ध में संतुलन और प्रभाव बढ़ाती है।",
        englishMeaning = "Here are heroes like Bhima, Arjuna, Yuyudhana, Virata, and Drupada, all mighty warriors."
    ),

    Shloka(
        number = 23,
        sanskrit = "धृष्टकेतुश्चेकितानः काशिराजश्च वीर्यवान्। पुरुजित्कुन्तिभोजश्च शैब्यश्च नरपुङ्गवः।।",
        hindiMeaning = "धृष्टकेतु, शैब्य, काशी के राजा, वीर्यवान पुरुजित, कुन्तिभोज और अन्य श्रेष्ठ योद्धा पाण्डव सेना में हैं। यह श्लोक उनकी वीरता और युद्धकौशल को उजागर करता है। प्रत्येक योद्धा अपनी क्षमता और वीरता से सेना को सशक्त बनाता है।",
        englishMeaning = "Dhrishtaketu, Chekitana, the valiant king of Kashi, Purujit, Kuntibhoja, and Shaibya are in the army."
    ),

    Shloka(
        number = 24,
        sanskrit = "युधामन्युश्च विक्रान्त उत्तमौजाश्च वीर्यवान्। सौभद्रश्च महारथः धर्मभिर्युद्धमातृषाः।।",
        hindiMeaning = "युधामन्यु, उत्तमौजा और सौभद्र महारथी योद्धा धर्म के पक्ष में युद्ध के लिए तैयार हैं। वे वीरता, निष्ठा और शक्ति में उत्कृष्ट हैं। यह श्लोक पाण्डवों की सेना की ताकत और संघर्ष के लिए तत्परता को दर्शाता है।",
        englishMeaning = "Yudhamanyu, Uttamauja, and Saubhadra, mighty warriors, are ready to fight for righteousness."
    ),

    Shloka(
        number = 25,
        sanskrit = "अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम। नायकाः मम सैनिकानां संज्ञार्थं तान्ब्रवीमि ते।।",
        hindiMeaning = "दुर्योधन आचार्य से कहता है कि आप हमारे श्रेष्ठ योद्धाओं की पहचान कीजिए। यह श्लोक सेना के संगठन और रणभूमि में नेतृत्व की आवश्यकता को दर्शाता है। प्रत्येक सेनानी के पास सक्षम नेता होना अनिवार्य है।",
        englishMeaning = "Duryodhana asks the Brahmin to identify the chief warriors of our army for proper command."
    ),

    Shloka(
        number = 26,
        sanskrit = "भवान्भीष्मश्च कर्णश्च कृपश्च समितिंजनकः। अश्वत्थामा विकर्णश्च सौमदत्तिस्तथैव च।।",
        hindiMeaning = "भीष्म, कर्ण, कृपा, समितिंजनक, अश्वत्थामा, विकर्ण और सौमदत्त जैसे योद्धा कौरव सेना में उपस्थित हैं। यह श्लोक उनके साहस, युद्धकौशल और नेतृत्व क्षमता को दर्शाता है। उनकी उपस्थिति सेना के मनोबल को मजबूत करती है।",
        englishMeaning = "The Kaurava army includes Bhishma, Karna, Kripa, Samitinjana, Ashvatthama, Vikarna, and Somadatta."
    ),

    Shloka(
        number = 27,
        sanskrit = "सौभद्रश्च महाबाहुः शिखण्डी च महारथः। धृष्टद्युम्नो विग्राह्य द्रुपदश्च महारथः।।",
        hindiMeaning = "सौभद्र, महाबाहु शिखण्डी, धृष्टद्युम्न और द्रुपद महारथी योद्धा हैं। ये सभी रणभूमि में साहस और शक्ति के धनी हैं। यह श्लोक युद्ध के प्रमुख योद्धाओं की सूची और उनके सामर्थ्य को दर्शाता है।",
        englishMeaning = "Saubhadra, mighty-armed Shikhandi, Dhrishtadyumna, and Drupada are all great chariot-warriors."
    ),

    Shloka(
        number = 28,
        sanskrit = "अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम। नायकाः मम सैनिकानां संज्ञार्थं तान्ब्रवीमि ते।।",
        hindiMeaning = "दुर्योधन आचार्य से कहता है कि आप हमारे सैनिकों के श्रेष्ठ नायकों की पहचान कीजिए। यह श्लोक सेना के संगठन और रणभूमि में नेतृत्व की आवश्यकता को स्पष्ट करता है।",
        englishMeaning = "Duryodhana asks to identify the chief warriors of our army for proper command."
    ),

    Shloka(
        number = 29,
        sanskrit = "पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम्। व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता।।",
        hindiMeaning = "दुर्योधन कहता है कि हे आचार्य! आप देखिए कि आपके शिष्य द्रुपदपुत्र ने पाण्डवों की महाशक्ति व्यवस्थित की है। यह श्लोक सेना की संरचना और युद्ध में प्रमुख योद्धाओं की स्थिति को दर्शाता है।",
        englishMeaning = "Duryodhana points out the Pandava army arranged by your disciple Dhrishtadyumna."
    ),

    Shloka(
        number = 30,
        sanskrit = "अत्र शूरा महेष्वासा भीमार्जुनसमा युधि। युयुधानो विराटश्च द्रुपदश्च महारथः।।",
        hindiMeaning = "इस सेना में शूरवीर हैं, जैसे भीम और अर्जुन, युयुधान और विराट, और द्रुपद भी महारथी हैं। यह श्लोक युद्ध में प्रमुख योद्धाओं की वीरता और क्षमता को दर्शाता है।",
        englishMeaning = "Here are heroes like Bhima, Arjuna, Yuyudhana, Virata, and Drupada, all mighty in battle."
    ),
    Shloka(
        number = 31,
        sanskrit = "स एवायुधसम्पन्नः पाण्डवसैन्यं व्यवस्थितम्। भीष्मेण प्रमुखेण सेनास्थं दृष्ट्वा कुरुवृद्धः।।",
        hindiMeaning = "दुर्योधन पाण्डव सेना को सभी अस्त्र-शस्त्रों से सुसज्जित और व्यवस्थित देखकर आश्चर्यचकित और भयभीत हुआ। भीष्म के नेतृत्व वाली कौरव सेना की स्थिति और पाण्डवों की तैयारी ने उसे चिंतित कर दिया। यह श्लोक युद्ध के आरंभ में दोनों सेनाओं के मनोबल और रणनीति की स्थिति को दर्शाता है।",
        englishMeaning = "Duryodhana, seeing the Pandava army fully armed and arranged under Bhishma, was filled with apprehension."
    ),

    Shloka(
        number = 32,
        sanskrit = "अथ व्यवस्थिताः पाण्डवाः शंखं द्रुपदपुत्रेण ध्वनितम्। भीष्मस्य दर्शनात्सन्निपातमुपस्थितम्।।",
        hindiMeaning = "पाण्डवों की सेना व्यवस्थित हुई और उनके शंखों का नाद गूंज उठा। द्रुपदपुत्र के निर्देशन में यह ध्वनि युद्ध की तैयारी का प्रतीक थी। भीष्म के दर्शन से युद्ध की गंभीरता और संघर्ष की संभावना स्पष्ट हुई। यह श्लोक रणभूमि में तनाव और सैनिकों की तत्परता को दर्शाता है।",
        englishMeaning = "The Pandava army, arranged under Dhrishtadyumna, sounded their conchshells; the sight of Bhishma indicated the coming clash."
    ),

    Shloka(
        number = 33,
        sanskrit = "ततः शंखाश्च भेर्यश्च पाण्डवानीकं व्यूढम्। दुर्योधनस्तदा प्राह आचार्यमुपसङ्गम्य।।",
        hindiMeaning = "तत्पश्चात् पाण्डव सेना के शंख और भेर्य बजाए गए। दुर्योधन आचार्य द्रोण के पास जाकर उनसे बोले। यह श्लोक युद्ध की शुरुआत और संकेत के माध्यम से सेनाओं की तैयारी को दर्शाता है।",
        englishMeaning = "Then the conchshells and kettledrums of the Pandavas were sounded; Duryodhana approached teacher Drona."
    ),

    Shloka(
        number = 34,
        sanskrit = "पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम्। व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता।।",
        hindiMeaning = "दुर्योधन कहता है कि हे आचार्य! आपके शिष्य द्रुपदपुत्र ने पाण्डवों की महाशक्ति व्यवस्थित की है। यह श्लोक युद्ध के प्रमुख योद्धाओं और सेनाओं की संरचना को दर्शाता है।",
        englishMeaning = "Duryodhana observes the vast Pandava army arranged by your wise disciple, Dhrishtadyumna."
    ),

    Shloka(
        number = 35,
        sanskrit = "अत्र शूरा महेष्वासा भीमार्जुनसमा युधि। युयुधानो विराटश्च द्रुपदश्च महारथः।।",
        hindiMeaning = "इस सेना में शूरवीर हैं, जैसे भीम और अर्जुन, युयुधान और विराट, और द्रुपद भी महारथी हैं। उनके शौर्य और युद्धकौशल से पाण्डव सेना अत्यंत सशक्त है। यह श्लोक प्रमुख योद्धाओं की वीरता और क्षमता को बताता है।",
        englishMeaning = "Here are heroes like Bhima, Arjuna, Yuyudhana, Virata, and Drupada, all mighty in battle."
    ),

    Shloka(
        number = 36,
        sanskrit = "धृष्टकेतुश्चेकितानः काशिराजश्च वीर्यवान्। पुरुजित्कुन्तिभोजश्च शैब्यश्च नरपुङ्गवः।।",
        hindiMeaning = "धृष्टकेतु, शैब्य, काशी के राजा, वीर्यवान पुरुजित, कुन्तिभोज और अन्य श्रेष्ठ योद्धा इस सेना में हैं। यह श्लोक पाण्डव सेना की शक्ति और उनके प्रमुख योद्धाओं की वीरता को दर्शाता है।",
        englishMeaning = "Dhrishtaketu, Chekitana, the valiant king of Kashi, Purujit, Kuntibhoja, and Shaibya are all present in the army."
    ),

    Shloka(
        number = 37,
        sanskrit = "युधामन्युश्च विक्रान्त उत्तमौजाश्च वीर्यवान्। सौभद्रश्च महारथः धर्मभिर्युद्धमातृषाः।।",
        hindiMeaning = "युधामन्यु, उत्तमौजा और सौभद्र महारथी योद्धा धर्म के पक्ष में युद्ध के लिए तैयार हैं। यह श्लोक पाण्डवों की सेना की तत्परता और वीरता को दर्शाता है। प्रत्येक योद्धा धर्म और न्याय के लिए अपनी शक्ति का प्रयोग करने को तत्पर है।",
        englishMeaning = "Yudhamanyu, Uttamauja, and Saubhadra, mighty warriors, are ready to fight for righteousness."
    ),

    Shloka(
        number = 38,
        sanskrit = "अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम। नायकाः मम सैनिकानां संज्ञार्थं तान्ब्रवीमि ते।।",
        hindiMeaning = "दुर्योधन आचार्य से कहते हैं कि हमारे श्रेष्ठ सेनानी कौन हैं, इसकी पहचान कीजिए। यह श्लोक सेना के संगठन और प्रमुख योद्धाओं के महत्व को बताता है।",
        englishMeaning = "Duryodhana asks the Brahmin to identify the chief warriors of our army."
    ),

    Shloka(
        number = 39,
        sanskrit = "भवान्भीष्मश्च कर्णश्च कृपश्च समितिंजनकः। अश्वत्थामा विकर्णश्च सौमदत्तिस्तथैव च।।",
        hindiMeaning = "भीष्म, कर्ण, कृपा, समितिंजनक, अश्वत्थामा, विकर्ण और सौमदत्त इस सेना में उपस्थित हैं। यह श्लोक कौरव सेना के प्रमुख योद्धाओं और उनके साहस को दर्शाता है।",
        englishMeaning = "Bhishma, Karna, Kripa, Samitinjana, Ashvatthama, Vikarna, and Somadatta are all present in the army."
    ),

    Shloka(
        number = 40,
        sanskrit = "सौभद्रश्च महाबाहुः शिखण्डी च महारथः। धृष्टद्युम्नो विग्राह्य द्रुपदश्च महारथः।।",
        hindiMeaning = "सौभद्र, महाबाहु शिखण्डी, धृष्टद्युम्न और द्रुपद महारथी योद्धा हैं। ये सभी रणभूमि में शौर्य और शक्ति के धनी हैं। यह श्लोक युद्ध में प्रमुख योद्धाओं की सूची को स्पष्ट करता है।",
        englishMeaning = "Saubhadra, mighty-armed Shikhandi, Dhrishtadyumna, and Drupada are great chariot-warriors."
    ),

    Shloka(
        number = 41,
        sanskrit = "अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम। नायकाः मम सैनिकानां संज्ञार्थं तान्ब्रवीमि ते।।",
        hindiMeaning = "दुर्योधन आचार्य से कहते हैं कि आप हमारे सैनिकों के प्रमुख नायकों की पहचान करें। यह श्लोक सेना की संरचना और रणभूमि में नेतृत्व की आवश्यकता को दर्शाता है।",
        englishMeaning = "Duryodhana asks to identify the chief warriors of our army for proper command."
    ),

    Shloka(
        number = 42,
        sanskrit = "ततः शंखाश्च भेर्यश्च पाण्डवानीकं व्यूढम्। दुर्योधनस्तदा प्राह आचार्यमुपसङ्गम्य।।",
        hindiMeaning = "तत्पश्चात पाण्डव सेना के शंख और भेर्य बजाए गए। दुर्योधन आचार्य के पास जाकर उनसे बोले। यह श्लोक युद्ध की तैयारी और संकेत की प्रक्रिया को दर्शाता है।",
        englishMeaning = "Then the conchshells and kettledrums of the Pandavas were sounded; Duryodhana approached the teacher."
    ),

    Shloka(
        number = 43,
        sanskrit = "पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम्। व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता।।",
        hindiMeaning = "दुर्योधन कहता है कि हे आचार्य! आपके शिष्य द्रुपदपुत्र ने पाण्डवों की बड़ी सेना व्यवस्थित की है। यह श्लोक रणभूमि में प्रमुख योद्धाओं और उनके संगठन की जानकारी देता है।",
        englishMeaning = "Duryodhana observes the vast Pandava army arranged by your wise disciple, Dhrishtadyumna."
    ),

    Shloka(
        number = 44,
        sanskrit = "अत्र शूरा महेष्वासा भीमार्जुनसमा युधि। युयुधानो विराटश्च द्रुपदश्च महारथः।।",
        hindiMeaning = "इस सेना में शूरवीर हैं, जैसे भीम और अर्जुन, युयुधान और विराट, और द्रुपद भी महारथी हैं। यह श्लोक युद्ध के प्रमुख योद्धाओं की वीरता और क्षमता को दर्शाता है।",
        englishMeaning = "Here are heroes like Bhima, Arjuna, Yuyudhana, Virata, and Drupada, all mighty in battle."
    ),

    Shloka(
        number = 45,
        sanskrit = "धृष्टकेतुश्चेकितानः काशिराजश्च वीर्यवान्। पुरुजित्कुन्तिभोजश्च शैब्यश्च नरपुङ्गवः।।",
        hindiMeaning = "धृष्टकेतु, शैब्य, काशी के राजा, वीर्यवान पुरुजित, कुन्तिभोज और अन्य श्रेष्ठ योद्धा इस सेना में उपस्थित हैं। यह श्लोक पाण्डव सेना की शक्ति और उनके प्रमुख योद्धाओं की वीरता को दर्शाता है।",
        englishMeaning = "Dhrishtaketu, Chekitana, the valiant king of Kashi, Purujit, Kuntibhoja, and Shaibya are all present in the army."
    ),

    Shloka(
        number = 46,
        sanskrit = "युधामन्युश्च विक्रान्त उत्तमौजाश्च वीर्यवान्। सौभद्रश्च महारथः धर्मभिर्युद्धमातृषाः।।",
        hindiMeaning = "युधामन्यु, उत्तमौजा और सौभद्र महारथी योद्धा धर्म के पक्ष में युद्ध के लिए तैयार हैं। वे वीरता, निष्ठा और शक्ति में उत्कृष्ट हैं। यह श्लोक पाण्डवों की सेना की ताकत और संघर्ष के लिए तत्परता को दर्शाता है।",
        englishMeaning = "Yudhamanyu, Uttamauja, and Saubhadra, mighty warriors, are ready to fight for righteousness."
    ),

    Shloka(
        number = 47,
        sanskrit = "अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम। नायकाः मम सैनिकानां संज्ञार्थं तान्ब्रवीमि ते।।",
        hindiMeaning = "दुर्योधन आचार्य से कहते हैं कि आप हमारे सैनिकों के श्रेष्ठ नायकों की पहचान कीजिए। यह श्लोक सेना के संगठन और रणभूमि में नेतृत्व की आवश्यकता को स्पष्ट करता है।",
        englishMeaning = "Duryodhana asks to identify the chief warriors of our army for proper command."
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaOneScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 1 – अर्जुन विषाद योग",
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
                onClick = { navController.navigate(Screen.QuizOne.route) },
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
                        painter = painterResource(R.drawable.gemini_generated_image_aq9175aq9175aq91),
                        contentDescription = "Bhagavad Gita",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shloka list
            items(adhyayaOneShlokas) { shloka ->
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
