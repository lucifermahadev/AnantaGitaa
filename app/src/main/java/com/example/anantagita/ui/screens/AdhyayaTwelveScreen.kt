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

val adhyayaTwelveShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "अर्जुन उवाच। एवṁ सततयुक्ता ये भक्तास्त्वां पर्युपासते। ये चाप्यक्षरमव्यक्तं तेषां के योगवित्तमाः॥",
        hindiMeaning = "अर्जुन ने पूछा – हे कृष्ण! जो भक्त निरंतर आपके प्रति अनन्य भक्ति से जुड़कर आपकी उपासना करते हैं, और जो उस अव्यक्त, अक्षर, निर्गुण ब्रह्म का ध्यान करते हैं – उनमें से कौन श्रेष्ठ योगी माना जाता है? यहाँ अर्जुन दो मार्गों का अंतर जानना चाहते हैं – सगुण भगवान की उपासना और निर्गुण ब्रह्म की साधना। वे स्पष्ट करना चाहते हैं कि इनमें से कौन सा मार्ग अधिक सहज और कल्याणकारी है। यह प्रश्न हर साधक के मन में उठता है कि भक्ति या ज्ञान में कौन श्रेष्ठ है।",
        englishMeaning = "Arjuna asks Krishna which devotees are superior: those who worship Him personally with devotion, or those who meditate on the formless, imperishable Absolute."
    ),

    Shloka(
        number = 2,
        sanskrit = "श्रीभगवानुवाच। मय्यावेश्य मनो ये मां नित्ययुक्ता उपासते। श्रद्धया परयोपेतास्ते मे युक्ततमा मताः॥",
        hindiMeaning = "भगवान श्रीकृष्ण ने उत्तर दिया – जो भक्त अपना मन मुझमें स्थिर करके निरंतर श्रद्धा और भक्ति के साथ मेरी उपासना करते हैं, वे मुझे श्रेष्ठ योगी प्रतीत होते हैं। यहाँ भगवान यह स्पष्ट करते हैं कि सगुण स्वरूप की उपासना भक्त के लिए सहज और प्रेमपूर्ण होती है। ऐसे भक्त भगवान के साथ आत्मीय संबंध बनाते हैं और अपने मन को निरंतर ईश्वर में लगाकर सहजता से मुक्ति की ओर बढ़ते हैं। भक्ति में भावनात्मक निकटता और करुणा का अनुभव होता है, इसलिए यह साधक के लिए अधिक प्रिय और उपलब्धि देने वाला मार्ग है।",
        englishMeaning = "Krishna replies that those who worship Him with unwavering devotion, fixing their minds on Him with supreme faith, are considered the best yogis."
    ),

    Shloka(
        number = 3,
        sanskrit = "ये त्वक्षरमनिर्देश्यमव्यक्तं पर्युपासते। सर्वत्रगमचिन्त्यं च कूटस्थमचलं ध्रुवम्॥",
        hindiMeaning = "भगवान कहते हैं – जो साधक उस अव्यक्त, अक्षर, अनिर्देश्यम, सर्वत्र व्यापी, अचिन्त्य, स्थिर और ध्रुव ब्रह्म का ध्यान करते हैं, वे भी मुझे ही प्राप्त करने का प्रयास करते हैं। यह मार्ग अत्यंत कठिन और सूक्ष्म है, क्योंकि इसमें किसी रूप, लीलाओं या गुणों का आधार नहीं होता। साधक को निराकार, निर्गुण, अचिन्त्य ब्रह्म पर मन को स्थिर करना पड़ता है, जो सामान्य मनुष्य के लिए बहुत कठिन है। फिर भी यह मार्ग भी ईश्वर प्राप्ति की दिशा में ले जाने वाला है।",
        englishMeaning = "Those who meditate on the unmanifest, imperishable, all-pervading, inconceivable, immovable, and eternal Absolute are also on the path to God."
    ),

    Shloka(
        number = 4,
        sanskrit = "संनियम्येन्द्रियग्रामं सर्वत्र समबुद्धयः। ते प्राप्नुवन्ति मामेव सर्वभूतहिते रताः॥",
        hindiMeaning = "जो साधक अपने इन्द्रियों को संयमित रखते हैं, सबमें समभाव रखते हैं और सभी प्राणियों के कल्याण में लगे रहते हैं, वे अंततः मुझे ही प्राप्त करते हैं। यहाँ भगवान निर्गुण साधना के लिए आवश्यक शर्तें बता रहे हैं – इन्द्रिय संयम, समान दृष्टि और परोपकार भावना। यह मार्ग अत्यंत कठोर है क्योंकि इसमें मन को निराकार और अनिर्देश्यम लक्ष्य में स्थिर रखना होता है। फिर भी जो इसे निभाते हैं, वे भी परमात्मा तक पहुँचते हैं।",
        englishMeaning = "Those who control their senses, remain equal-minded everywhere, and are devoted to the welfare of all beings also attain Krishna through the unmanifest path."
    ),

    Shloka(
        number = 5,
        sanskrit = "क्लेशोऽधिकतरस्तेषामव्यक्तासक्तचेतसाम्। अव्यक्ता हि गतिर्दुःखं देहवद्भिरवाप्यते॥",
        hindiMeaning = "भगवान कहते हैं – जिनका चित्त अव्यक्त ब्रह्म में आसक्त है, उनके लिए मार्ग अधिक कठिन है। क्योंकि शरीरधारी जीव के लिए अव्यक्त की साधना अत्यंत दुर्गम होती है। मानव मन सगुण और साकार में अधिक सहजता से जुड़ता है, जबकि निर्गुण ब्रह्म की उपासना में स्थिर होना बहुत कठिन है। इसीलिए सगुण भक्ति मार्ग को अधिक सरल और सुलभ माना गया है।",
        englishMeaning = "Krishna explains that those attached to the unmanifest find the path very difficult, for embodied beings struggle to reach the imperceptible Absolute."
    ),

    Shloka(
        number = 6,
        sanskrit = "ये तु सर्वाणि कर्माणि मयि संन्यस्य मत्पराः। अनन्येनैव योगेन मां ध्यायन्त उपासते॥",
        hindiMeaning = "लेकिन जो साधक अपने सभी कर्म मुझमें समर्पित करते हैं, मुझे ही परम मानते हैं और अनन्य योग द्वारा निरंतर मेरा ध्यान करते हैं, वे भक्ति मार्ग में सहजता से बढ़ते हैं। यहाँ भगवान कार्य को त्यागने की नहीं, बल्कि उसे ईश्वर को अर्पित करने की शिक्षा देते हैं। भक्त जब कर्म करता है तो उसका फल भगवान को अर्पित कर देता है, जिससे वह बंधनमुक्त हो जाता है। ऐसा समर्पण भाव ईश्वर तक पहुँचने का सरल साधन है।",
        englishMeaning = "Those who dedicate all their actions to Krishna, considering Him supreme and worshipping with undivided devotion, steadily progress in bhakti."
    ),

    Shloka(
        number = 7,
        sanskrit = "तेषामहं समुद्धर्ता मृत्युसंसारसागरात्। भवामि नचिरात्पार्थ मय्यावेशितचेतसाम्॥",
        hindiMeaning = "हे पार्थ! जिनका मन मुझमें स्थित है, मैं शीघ्र ही उन्हें जन्म-मृत्यु के समुद्र से पार कर देता हूँ। यहाँ भगवान अपने भक्त को आश्वासन देते हैं कि सच्चा भक्ति मार्ग उन्हें संसार के बंधनों से मुक्त कराता है। जो व्यक्ति पूर्ण समर्पण करता है, उसे बार-बार जन्म-मृत्यु के चक्र से भयभीत होने की आवश्यकता नहीं रहती। ईश्वर स्वयं उसका उद्धार करते हैं।",
        englishMeaning = "Krishna assures Arjuna that He quickly delivers His devotees, whose minds are fixed on Him, from the ocean of birth and death."
    ),

    Shloka(
        number = 8,
        sanskrit = "मय्येव मन आधत्स्व मयि बुद्धिं निवेशय। निवसिष्यसि मय्येव अत ऊर्ध्वं न संशयः॥",
        hindiMeaning = "भगवान कहते हैं – अपना मन और बुद्धि मुझमें लगा दो। ऐसा करने से तुम निश्चित रूप से सदा मेरे ही पास रहोगे, इसमें कोई संदेह नहीं है। यहाँ ईश्वर भक्त से केवल मन और बुद्धि का समर्पण चाहते हैं। जब मन और बुद्धि ईश्वर में लग जाते हैं, तो मनुष्य संसारिक भ्रम से ऊपर उठकर दिव्य शांति और आनंद को प्राप्त करता है।",
        englishMeaning = "Fix your mind and intellect on Krishna alone, and you will live in Him forever, without any doubt."
    ),

    Shloka(
        number = 9,
        sanskrit = "अथ चित्तं समाधातुं न शक्कोषि मयि स्थिरम्। अभ्यासयोगेन ततो मामिच्छाप्तुं धनञ्जय॥",
        hindiMeaning = "यदि तुम अपना चित्त मुझमें स्थिर करने में असमर्थ हो, तो अभ्यासयोग के द्वारा मुझे प्राप्त करने का प्रयास करो। भगवान यहाँ साधकों के लिए सरल उपाय बता रहे हैं। यदि मन एकाग्र नहीं होता तो अभ्यास द्वारा धीरे-धीरे मन को ईश्वर में लगाया जा सकता है। अभ्यास से ही मनुष्य स्थिरता और भक्ति में प्रगति करता है।",
        englishMeaning = "If you cannot fix your mind steadily on Krishna, then practice regularly through the discipline of devotion to reach Him."
    ),

    Shloka(
        number = 10,
        sanskrit = "अभ्यासेऽप्यसमर्थोऽसि मत्कर्मपरमो भव। मदर्थमपि कर्माणि कुर्वन्सिद्धिमवाप्स्यसि॥",
        hindiMeaning = "यदि अभ्यासयोग में भी असमर्थ हो, तो मेरे लिए कर्म करो। मेरे लिए किए गए कर्म से भी तुम सिद्धि को प्राप्त कर सकते हो। भगवान बताते हैं कि ईश्वर के लिए किया गया कार्य भी भक्ति का अंग है। चाहे सेवा हो, यज्ञ हो, या कोई और कार्य, जब उसे ईश्वर के लिए किया जाता है, तो वह साधना बन जाता है।",
        englishMeaning = "If you are unable to practice meditation, then engage in actions dedicated to Krishna. By doing work for Him, you will also attain perfection."
    ),

    Shloka(
        number = 11,
        sanskrit = "अथैतदप्यशक्तोऽसि कर्तुं मद्योगमाश्रितः। सर्वकर्मफलत्यागं ततः कुरु यतात्मवान्॥",
        hindiMeaning = "यदि तुम यह भी करने में असमर्थ हो, तो अपने सभी कर्मों के फलों का त्याग करके यतात्मवान होकर रहो। अर्थात् तुम कर्म करो, परंतु उसके फल की आसक्ति मत रखो और उसे ईश्वर को अर्पित कर दो। यह सबसे सरल मार्ग है, जिसमें मनुष्य अपने कार्य करता है परंतु उसका बंधन नहीं होता। कर्मफलत्याग से मनुष्य धीरे-धीरे ईश्वर के समीप पहुँचता है।",
        englishMeaning = "If you cannot dedicate actions to Krishna, then renounce the fruits of all your actions with self-control. This too will lead you toward Him."
    ),

    Shloka(
        number = 12,
        sanskrit = "श्रेयो हि ज्ञानमभ्यासाज्ज्ञानाद्ध्यानं विशिष्यते। ध्यानात्कर्मफलत्यागस्त्यागाच्छान्तिरनन्तरम्॥",
        hindiMeaning = "ज्ञान अभ्यास से श्रेष्ठ है, ध्यान ज्ञान से श्रेष्ठ है, और ध्यान से भी श्रेष्ठ है कर्मफलत्याग। क्योंकि कर्मफलत्याग के बाद तुरंत शांति प्राप्त होती है। यहाँ भगवान यह बताते हैं कि सर्वोच्च साधन भक्ति के साथ निष्काम भाव है। जब मनुष्य कर्म के परिणाम से मुक्त हो जाता है, तो उसके भीतर तुरंत शांति और संतोष उत्पन्न होता है।",
        englishMeaning = "Knowledge is better than practice, meditation is higher than knowledge, but renunciation of results is greater than meditation, for renunciation brings immediate peace."
    ),

    Shloka(
        number = 13,
        sanskrit = "अद्वेष्टा सर्वभूतानां मैत्रः करुण एव च। निर्ममो निरहङ्कारः समदुःखसुखः क्षमी॥",
        hindiMeaning = "जो व्यक्ति किसी से द्वेष नहीं करता, सबके प्रति मित्रवत और करुणामय है, जिसमें ममता और अहंकार नहीं है, जो सुख-दुःख में समान रहता है और क्षमाशील है – ऐसा भक्त भगवान को प्रिय है। यह श्लोक भक्ति के लक्षण बताता है। सच्चा भक्त सब प्राणियों में ईश्वर को देखता है, इसलिए उसमें न तो द्वेष होता है और न ही अहंकार। उसकी करुणा और क्षमा भाव उसकी भक्ति का प्रमाण है।",
        englishMeaning = "A true devotee is free from hatred, friendly and compassionate to all, without possessiveness or ego, balanced in joy and sorrow, and forgiving."
    ),

    Shloka(
        number = 14,
        sanskrit = "सन्तुष्टः सततं योगी यतात्मा दृढनिश्चयः। मय्यर्पितमनोबुद्धिर्यो मद्भक्तः स मे प्रियः॥",
        hindiMeaning = "जो साधक सदा संतुष्ट रहता है, आत्मसंयमी है, दृढ़ निश्चयी है और जिसने अपना मन और बुद्धि मुझे अर्पित कर दी है – ऐसा भक्त मुझे प्रिय है। भगवान बताते हैं कि संतोष और समर्पण भक्ति के मुख्य आधार हैं। जो मनुष्य अपनी बुद्धि और विचार भी ईश्वर को समर्पित कर देता है, वही वास्तविक भक्त कहलाता है।",
        englishMeaning = "The devotee who is content, self-controlled, firm in determination, and has surrendered mind and intellect to Krishna is very dear to Him."
    ),

    Shloka(
        number = 15,
        sanskrit = "यस्मान्नोद्विजते लोको लोकान्नोद्विजते च यः। हर्षामर्षभयोद्वेगैर्मुक्तो यः स च मे प्रियः॥",
        hindiMeaning = "जिससे संसार के लोग भयभीत नहीं होते और जो स्वयं भी दूसरों से विचलित नहीं होता, जो हर्ष, द्वेष, भय और उद्वेग से मुक्त है – वह भक्त मुझे प्रिय है। सच्चा भक्त किसी के लिए भय का कारण नहीं बनता और न ही किसी से भयभीत होता है। उसका मन स्थिर रहता है और वह अपने जीवन से दूसरों को शांति प्रदान करता है।",
        englishMeaning = "One who neither disturbs others nor is disturbed by them, and who is free from joy, anger, fear, and anxiety, is dear to Krishna."
    ),

    Shloka(
        number = 16,
        sanskrit = "अनपेक्षः शुचिर्दक्ष उदासीनो गतव्यथः। सर्वारम्भपरित्यागी यो मद्भक्तः स मे प्रियः॥",
        hindiMeaning = "जो भक्त अनपेक्षी है, शुद्ध है, कुशल है, उदासीन है, व्यथाओं से रहित है और सभी कार्यों के आरंभ में आसक्ति नहीं रखता – वह मुझे प्रिय है। इसका अर्थ है कि सच्चा भक्त अपनी आवश्यकताओं को सीमित रखता है और हर परिस्थिति में शांति बनाए रखता है। वह परिणाम की चिंता नहीं करता, इसलिए हमेशा संतुलित रहता है।",
        englishMeaning = "A devotee who is detached, pure, efficient, indifferent, free from distress, and not entangled in undertakings is dear to Krishna."
    ),

    Shloka(
        number = 17,
        sanskrit = "यो न हृष्यति न द्वेष्टि न शोचति न काङ्क्षति। शुभाशुभपरित्यागी भक्तिमान्यः स मे प्रियः॥",
        hindiMeaning = "जो न हर्षित होता है, न द्वेष करता है, न शोक करता है और न ही किसी वस्तु की कामना करता है, शुभ और अशुभ का त्याग कर चुका है – ऐसा भक्त मुझे प्रिय है। यह अवस्था समता की है। सच्चा भक्त न तो सुख में उछलता है और न दुःख में टूटता है। वह शुभ और अशुभ दोनों को समान भाव से देखता है।",
        englishMeaning = "The devotee who neither rejoices nor hates, neither grieves nor desires, and who has renounced both good and evil, is dear to Krishna."
    ),

    Shloka(
        number = 18,
        sanskrit = "समः शत्रौ च मित्रे च तथा मानापमानयोः। शीतोष्णसुखदुःखेषु समः सङ्गविवर्जितः॥",
        hindiMeaning = "जो शत्रु और मित्र दोनों में समान रहता है, मान और अपमान में भी समान है, शीत-उष्ण और सुख-दुःख में भी संतुलित है और आसक्ति से रहित है – वह भक्त भगवान को प्रिय है। यहाँ समत्व की शिक्षा है। भक्त परिस्थितियों के प्रभाव से विचलित नहीं होता और हर स्थिति में स्थिर रहता है।",
        englishMeaning = "A devotee who remains the same toward friend and foe, in honor and dishonor, in heat and cold, in pleasure and pain, free from attachment, is dear to Krishna."
    ),

    Shloka(
        number = 19,
        sanskrit = "तुल्यनिन्दास्तुतिर्मौनी सन्तुष्टो येन केनचित्। अनिकेतः स्थिरमतिर्भक्तिमान्मे प्रियो नरः॥",
        hindiMeaning = "जो निंदा और स्तुति में समान रहता है, मौनप्रिय है, जैसा भी मिलता है उसमें संतुष्ट रहता है, घर-गृहस्थ के बंधन से मुक्त है और जिसकी बुद्धि स्थिर है – ऐसा भक्त मुझे प्रिय है। यह त्याग और संतोष की पराकाष्ठा है। सच्चा भक्त बाहरी परिस्थितियों पर निर्भर नहीं रहता, वह भीतर से ही संतुष्ट और शांत रहता है।",
        englishMeaning = "The devotee who treats praise and blame alike, is silent, content with anything, homeless, steady-minded, and full of devotion, is dear to Krishna."
    ),

    Shloka(
        number = 20,
        sanskrit = "ये तु धर्म्यामृतमिदं यथोक्तं पर्युपासते। श्रद्धधानाः मत्परमा भक्तास्तेऽतीव मे प्रियाः॥",
        hindiMeaning = "जो भक्त इस धर्म रूपी अमृत को, जैसा मैंने कहा है, श्रद्धा और भक्ति से अपनाते हैं, और मुझे ही परम मानते हैं – वे मुझे अत्यंत प्रिय हैं। यह श्लोक पूरे अध्याय का निष्कर्ष है। सच्चा भक्त जो गुण भगवान ने बताए, उन्हें आचरण में लाता है और पूर्ण श्रद्धा से भगवान को ही परम मानता है, वही भगवान का प्रिय होता है।",
        englishMeaning = "Those devotees who follow this nectar of dharma as described, with faith and considering Krishna supreme, are exceedingly dear to Him."
    ),


    )
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaTwelveScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 12 – भक्तियोग",
                        fontSize = 24.sp,
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
            FloatingActionButton(
                onClick = { navController.navigate(Screen.QuizTwelve.route) }, // ✅ Direct quiz access
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
            // ✅ Top Image for Chapter 12
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
                        contentDescription = "Chapter 12 – Bhakti Yoga",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }
            }

            // ✅ Shloka list
            items(adhyayaTwelveShlokas) { shloka ->
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
