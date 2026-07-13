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

// ✅ Adhyaya 15 – All 20 Shlokas
val adhyayaFifteenShlokas = listOf(
    Shloka(
        number = 1,
        sanskrit = "श्रीभगवानुवाच। ऊर्ध्वमूलमधःशाखमश्वत्थं प्राहुरव्ययम्। छन्दांसि यस्य पर्णानि यस्तं वेद स वेदवित्।।",
        hindiMeaning = "भगवान श्रीकृष्ण कहते हैं—इस संसार रूपी वृक्ष को शाश्वत पीपल का वृक्ष कहा गया है। इसकी जड़ ऊपर परमात्मा में है और शाखाएँ नीचे फैली हुई हैं। इसके पत्ते वेद हैं और जो इस वृक्ष के स्वरूप को जानता है वही वेदों का सच्चा ज्ञाता है। यह संसार का वृक्ष कर्म, इच्छा और आसक्ति के कारण निरंतर फैलता रहता है। जीव इसके बंधनों में फँसकर जन्म और मृत्यु का चक्र भोगता है। इस वृक्ष को समझ लेना ही मुक्त होने की पहली सीढ़ी है।",
        englishMeaning = "Lord Krishna said: This eternal Ashvattha tree has its roots above and branches below. Its leaves are the Vedas; one who truly knows this tree knows the essence of the Vedas."
    ),

    Shloka(
        number = 2,
        sanskrit = "अधश्चोर्ध्वं प्रसृतास्तस्य शाखा गुणप्रवृद्धा विषयप्रवालाः। अधश्च मूलान्यनुसन्ततानि कर्मानुबन्धीनि मनुष्यलोके।।",
        hindiMeaning = "उस वृक्ष की शाखाएँ ऊपर और नीचे फैली हुई हैं, जो तीन गुणों से पुष्ट होती हैं और विषयों की कोपलों से सुसज्जित रहती हैं। इसकी जड़ें नीचे भी फैली रहती हैं जो कर्मों के बंधनों को दृढ़ करती हैं। मनुष्य इस संसार वृक्ष से इसलिए बँधा है क्योंकि उसके कर्म और इच्छाएँ इस वृक्ष की जड़ों की तरह उसे बार-बार जन्म में खींच लाती हैं। जब तक यह वृक्ष अज्ञान और कर्मफल से पोषित है, जीव इसमें फँसा रहता है।",
        englishMeaning = "Its branches spread above and below, nourished by the modes of nature and sense objects. Its roots bind the soul to this world through karma."
    ),

    Shloka(
        number = 3,
        sanskrit = "न रूपमस्येह तथोपलभ्यते नान्तो न चादिर्न च संप्रतिष्ठा। अश्वत्थमेनं सुविरूढमूलमसङ्गशस्त्रेण दृढेन छित्त्वा।।",
        hindiMeaning = "इस संसार रूपी वृक्ष का वास्तविक स्वरूप यहाँ समझ में नहीं आता, न इसका आदि दिखाई देता है, न अंत और न ही आधार। यह वृक्ष अत्यंत गहराई से जड़ें जमाए खड़ा है। इसे केवल वैराग्य और आसक्ति रहित तलवार से ही काटा जा सकता है। इसका अर्थ है कि जब तक मनुष्य संसार के विषयों और इच्छाओं से जुड़ा रहता है, तब तक वह इस वृक्ष को नहीं काट सकता। केवल असंगता और भक्ति से ही इसे नष्ट किया जा सकता है।",
        englishMeaning = "Its real form cannot be perceived here—neither beginning, end, nor foundation. With the strong weapon of detachment, one must cut down this deeply rooted Ashvattha tree."
    ),

    Shloka(
        number = 4,
        sanskrit = "ततः पदं तत्परिमार्गितव्यं यस्मिन्गता न निवर्तन्ति भूयः। तमेव चाद्यं पुरुषं प्रपद्ये यतः प्रवृत्तिः प्रसृता पुराणी।।",
        hindiMeaning = "उस वृक्ष को काटकर मनुष्य को उस परम पद की खोज करनी चाहिए, जहाँ पहुँचकर फिर लौटना नहीं पड़ता। वही आद्य पुरुष है, उसी से यह पुरानी प्रवृत्ति संसार की उत्पन्न हुई है। साधक को उसी पुरुषोत्तम भगवान की शरण ग्रहण करनी चाहिए। वही इस संसार के चक्र से मुक्ति दिलाने वाला है। वहाँ केवल शाश्वत शांति और अमरत्व है।",
        englishMeaning = "After cutting this tree, one should seek the supreme abode from which there is no return. Surrender to that primal Person, from whom this eternal process has emanated."
    ),

    Shloka(
        number = 5,
        sanskrit = "निर्मानमोहा जितसङ्गदोषा अध्यात्मनित्या विनिवृत्तकामाः। द्वन्द्वैर्विमुक्ताः सुखदुःखसंज्ञैर् गच्छन्त्यमूढाः पदमव्ययं तत्।।",
        hindiMeaning = "जो व्यक्ति अहंकार और मोह से मुक्त हो जाते हैं, जिन्होंने संगदोष को जीता है और जो आत्मा में नित्य स्थित रहते हैं, जिनकी इच्छाएँ शांत हो गई हैं और जो सुख-दुःख के द्वन्द्वों से मुक्त हैं—वे उस अविनाशी परम पद को प्राप्त होते हैं। इसका तात्पर्य है कि मुक्ति उसी को मिलती है जिसने अपने मन को नियंत्रित कर लिया है और जो जीवन की विषमताओं से ऊपर उठ चुका है।",
        englishMeaning = "Those free from pride and delusion, detached from attachments, devoted to the self, and beyond dualities of happiness and distress, attain the eternal supreme abode."
    ),

    Shloka(
        number = 6,
        sanskrit = "न तद्भासयते सूर्यो न शशाङ्को न पावकः। यद्गत्वा न निवर्तन्ते तद्धाम परमं मम।।",
        hindiMeaning = "वह परम धाम सूर्य, चन्द्र या अग्नि से प्रकाशित नहीं होता। वह स्वयंसिद्ध प्रकाश से उज्ज्वल है। वहाँ पहुँचकर जीव कभी वापस नहीं लौटता। वह भगवान का सर्वोच्च धाम है। साधक को यही लक्ष्य बनाना चाहिए क्योंकि वहाँ केवल शाश्वत शांति और आनंद है।",
        englishMeaning = "Neither the sun, moon, nor fire illuminates My supreme abode. Having reached it, souls never return to this material world."
    ),

    Shloka(
        number = 7,
        sanskrit = "ममैवांशो जीवलोके जीवभूतः सनातनः। मनःषष्ठानीन्द्रियाणि प्रकृतिस्थानि कर्षति।।",
        hindiMeaning = "यह जीव वास्तव में मेरा ही सनातन अंश है। परन्तु जब यह प्रकृति से जुड़ जाता है तो मन और इन्द्रियों को अपने साथ खींच लेता है। जीव मूल रूप से दिव्य है, लेकिन प्रकृति के संपर्क में आकर वह अपनी शुद्ध स्थिति को भूल जाता है। यही कारण है कि वह संसार के सुख-दुःख में उलझ जाता है।",
        englishMeaning = "The eternal soul in this world is indeed My fragment. It draws the senses and mind, residing in material nature."
    ),

    Shloka(
        number = 8,
        sanskrit = "शरीरं यदवाप्नोति यच्चाप्युत्क्रामतीश्वरः। गृहीत्वैतानि संयाति वायुर्गन्धानिवाशयात्।।",
        hindiMeaning = "जैसे वायु सुगंधों को स्थान-स्थान से ले जाता है, वैसे ही जीवात्मा जब नया शरीर ग्रहण करता है या पुराना छोड़ता है, तो मन और इन्द्रियों को अपने साथ ले जाता है। आत्मा अमर है, परन्तु शरीर बदलते रहते हैं। यह उदाहरण बताता है कि आत्मा निरंतर यात्रा करती रहती है।",
        englishMeaning = "As the wind carries fragrances, so does the soul carry the senses and mind from one body to another when leaving or entering."
    ),

    Shloka(
        number = 9,
        sanskrit = "श्रोत्रं चक्षुः स्पर्शनं च रसना घ्राणमेव च। अधिष्ठाय मनश्चायं विषयानुपसेवते।।",
        hindiMeaning = "यह जीव अपने साथ कान, आँख, त्वचा, जीभ और नाक को तथा मन को ले जाता है और इनसे विषयों का अनुभव करता है। आत्मा इन इन्द्रियों के माध्यम से संसार का अनुभव करता है। यही कारण है कि आत्मा शरीर और इन्द्रियों के बंधन में बँधी प्रतीत होती है।",
        englishMeaning = "Residing in the body, the soul enjoys sense objects through the ears, eyes, skin, tongue, nose, and mind."
    ),

    Shloka(
        number = 10,
        sanskrit = "उत्क्रामन्तं स्थितं वापि भुञ्जानं वा गुणान्वितम्। विमूढा नानुपश्यन्ति पश्यन्ति ज्ञानचक्षुषः।।",
        hindiMeaning = "जब आत्मा शरीर से प्रस्थान करती है, या उसमें रहती है, या जब वह इन्द्रियों के द्वारा विषयों का भोग करती है, तब अज्ञानी लोग इसे नहीं समझ पाते। परन्तु जिनके पास ज्ञान की दृष्टि है, वे इसे देख लेते हैं। यह श्लोक स्पष्ट करता है कि केवल ज्ञानी ही आत्मा और शरीर के भेद को समझ सकते हैं।",
        englishMeaning = "The ignorant cannot perceive the soul departing, dwelling, or enjoying sense objects. But those with the eyes of knowledge see it clearly."
    ),

    Shloka(
        number = 11,
        sanskrit = "यतन्तो योगिनश्चैनं पश्यन्त्यात्मन्यवस्थितम्। यतन्तोऽप्यकृतात्मानो नैनं पश्यन्त्यचेतसः।।",
        hindiMeaning = "योगीजन निरंतर प्रयास करके आत्मा को अपने भीतर स्थित देखते हैं। परन्तु जो आत्मसंयमी नहीं हैं, वे यत्न करने पर भी उसे नहीं देख पाते। इसका कारण यह है कि आत्मा को अनुभव करने के लिए मन की शुद्धि और ध्यान आवश्यक है। बिना साधना के यह संभव नहीं है।",
        englishMeaning = "Striving yogis perceive the soul situated within, but those lacking discipline, though striving, cannot perceive it."
    ),

    Shloka(
        number = 12,
        sanskrit = "यदादित्यगतं तेजो जगद्भासयतेऽखिलम्। यच्चन्द्रमसि यच्चाग्नौ तत्तेजो विद्धि मामकम्।।",
        hindiMeaning = "जो तेज सूर्य में है और जो सम्पूर्ण जगत को प्रकाशित करता है, जो चन्द्रमा और अग्नि में है—वह मेरा ही तेज है। इसका अर्थ है कि समस्त प्रकाश और ऊर्जा भगवान से ही आती है। संसार का प्रत्येक प्रकाशमान तत्व भगवान की शक्ति का ही अंश है।",
        englishMeaning = "The radiance in the sun that illuminates the whole world, and in the moon and fire—know that as Mine."
    ),

    Shloka(
        number = 13,
        sanskrit = "गामाविश्य च भूतानि धारयाम्यहमोजसा। पुष्णामि चौषधीः सर्वाः सोमो भूत्वा रसात्मकः।।",
        hindiMeaning = "मैं पृथ्वी में प्रवेश कर सब प्राणियों को धारण करता हूँ। अपनी शक्ति से सभी औषधियों का पोषण करता हूँ और चन्द्रमा बनकर सब रसों को बढ़ाता हूँ। यह श्लोक हमें याद दिलाता है कि भगवान ही जीवन के आधार हैं। हमारे भोजन, पोषण और स्वास्थ्य सब उन्हीं की शक्ति से संभव है।",
        englishMeaning = "Entering the earth, I sustain beings by My energy. Becoming the moon, I nourish all plants with juice."
    ),

    Shloka(
        number = 14,
        sanskrit = "अहं वैश्वानरो भूत्वा प्राणिनां देहमाश्रितः। प्राणापानसमायुक्तः पचाम्यन्नं चतुर्विधम्।।",
        hindiMeaning = "मैं ही प्राणियों के शरीर में वैश्वानर अग्नि बनकर स्थित हूँ और प्राण तथा अपान वायु के साथ मिलकर चार प्रकार के भोजन को पचाता हूँ। इसका भाव है कि भोजन का पाचन और जीवनी शक्ति भी भगवान की ही देन है। वास्तव में हर श्वास, हर क्रिया उनके ही कारण संभव है।",
        englishMeaning = "Becoming the digestive fire, I reside in the bodies of beings. Joined with the life-breaths, I digest the four kinds of food."
    ),

    Shloka(
        number = 15,
        sanskrit = "सर्वस्य चाहं हृदि सन्निविष्टो मत्तः स्मृतिर्ज्ञानमपोहनं च। वेदैश्च सर्वैरहमेव वेद्यो वेदान्तकृद्वेदविदेव चाहम्।।",
        hindiMeaning = "मैं ही सबके हृदय में स्थित हूँ और मुझसे ही स्मृति, ज्ञान और विस्मृति उत्पन्न होती है। सभी वेदों से मैं ही जानने योग्य हूँ। मैं ही वेदान्त का रचयिता और वेदों का ज्ञाता हूँ। इसका तात्पर्य है कि सम्पूर्ण ज्ञान और स्मृति का स्रोत भगवान ही हैं। वे ही वेदों का परम लक्ष्य हैं।",
        englishMeaning = "I am seated in everyone's heart; from Me come memory, knowledge, and forgetfulness. I am to be known by all the Vedas; I am the compiler and knower of the Vedas."
    ),

    Shloka(
        number = 16,
        sanskrit = "द्वाविमौ पुरुषौ लोके क्षरश्चाक्षर एव च। क्षरः सर्वाणि भूतानि कूटस्थोऽक्षर उच्यते।।",
        hindiMeaning = "इस लोक में दो प्रकार के पुरुष हैं—क्षर और अक्षर। सारे प्राणी क्षर कहलाते हैं और जो कूटस्थ अर्थात स्थिर आत्मा है वह अक्षर कहलाता है। क्षर अर्थात नश्वर और परिवर्तनशील जगत है और अक्षर आत्मा अमर और अटल है।",
        englishMeaning = "There are two kinds of beings—the perishable and the imperishable. All living beings are perishable, while the soul is imperishable."
    ),

    Shloka(
        number = 17,
        sanskrit = "उत्तमः पुरुषस्त्वन्यः परमात्मेत्युदाहृतः। यो लोकत्रयमाविश्य बिभर्त्यव्यय ईश्वरः।।",
        hindiMeaning = "इन दोनों से परे एक और पुरुष है जिसे परमात्मा कहा गया है। वह अविनाशी ईश्वर है जो तीनों लोकों में प्रवेश कर सबको धारण करता है। वही सर्वोच्च और शाश्वत सत्ता है। यह स्पष्ट करता है कि आत्मा और परमात्मा में भिन्नता है और परमात्मा सबका आधार है।",
        englishMeaning = "But beyond them is the Supreme Person, called the Paramatma, who, as the eternal Lord, sustains the three worlds."
    ),

    Shloka(
        number = 18,
        sanskrit = "यस्मात्क्षरमतीतोऽहमक्षरादपि चोत्तमः। अतोऽस्मि लोके वेदे च प्रथितः पुरुषोत्तमः।।",
        hindiMeaning = "मैं क्षर अर्थात नश्वर प्राणियों से भी परे हूँ और अक्षर अर्थात अविनाशी आत्मा से भी श्रेष्ठ हूँ। इस कारण मैं लोकों और वेदों में पुरुषोत्तम कहलाता हूँ। यह घोषणा भगवान की सर्वोच्चता को सिद्ध करती है। वे ही सभी प्राणियों के नियंता और धाम हैं।",
        englishMeaning = "Since I transcend both the perishable and the imperishable, I am celebrated in the world and in the Vedas as the Supreme Person."
    ),

    Shloka(
        number = 19,
        sanskrit = "यो मामेवमसम्मूढो जानाति पुरुषोत्तमम्। स सर्वविद्भजति मां सर्वभावेन भारत।।",
        hindiMeaning = "हे भारत! जो मनुष्य असम्मूढ़ होकर मुझे पुरुषोत्तम रूप में जानता है, वह सब कुछ जानने वाला माना जाता है। ऐसा भक्त पूरे भाव से मेरी भक्ति करता है। यह श्लोक बताता है कि वास्तविक ज्ञान का अंत भगवान की भक्ति में ही है।",
        englishMeaning = "One who knows Me without delusion as the Supreme Person is truly all-knowing and worships Me with full devotion."
    ),

    Shloka(
        number = 20,
        sanskrit = "इति गुह्यतमं शास्त्रमिदमुक्तं मयानघ। एतद्बुद्ध्वा बुद्धिमान्स्यात्कृतकृत्यश्च भारत।।",
        hindiMeaning = "हे निष्पाप अर्जुन! मैंने यह अत्यंत गोपनीय शास्त्र तुझे बताया है। इसे जानकर मनुष्य बुद्धिमान हो जाता है और जीवन का परम उद्देश्य प्राप्त कर लेता है। यह अध्याय स्पष्ट करता है कि जो भगवान को पुरुषोत्तम के रूप में जानता है वही पूर्णता प्राप्त करता है।",
        englishMeaning = "Thus, O sinless one, I have declared this most confidential scripture. By knowing it, a person becomes wise and fulfills the highest purpose of life."
    )

)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdhyayaFifteenScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "अध्याय 15 – पुरुषोत्तम योग",
                        fontSize = 26.sp, // ✅ Bigger title
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
                onClick = { navController.navigate(Screen.QuizFifteen.route) },
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
            contentPadding = PaddingValues(bottom = 70.dp) // ✅ prevent overlap with ad/FAB
        ) {
            // ✅ Top Image
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .height(500.dp), // ✅ same as Adhyaya 4
                    shape = RoundedCornerShape(20.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.gemini_generated_image_dh50ujdh50ujdh50),
                        contentDescription = "Chapter 15 – Purushottam Yoga",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // ✅ Shlokas
            items(adhyayaFifteenShlokas) { shloka ->
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
