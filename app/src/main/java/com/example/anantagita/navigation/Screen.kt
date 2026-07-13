package com.anantagita.navigation

sealed class Screen(val route: String) {

    // ---------- Auth ----------
    object Splash : Screen("splash")
    object Login : Screen("login")
    object Signup : Screen("signup")

    // ---------- Home ----------
    object MainSwipeable : Screen("main_swipeable")

    // ---------- Profile / Info ----------
    object Profile : Screen("profile")
    object About : Screen("about")
    object Support : Screen("support")
    object PrivacyTerms : Screen("privacy_terms")
    object Feedback : Screen("feedback")

    // ---------- Quiz ----------
    object QuizHome : Screen("quiz_home")

    object QuizOne : Screen("quiz_one")
    object QuizTwo : Screen("quiz_two")
    object QuizThree : Screen("quiz_three")
    object QuizFour : Screen("quiz_four")
    object QuizFive : Screen("quiz_five")
    object QuizSix : Screen("quiz_six")
    object QuizSeven : Screen("quiz_seven")
    object QuizEight : Screen("quiz_eight")
    object QuizNine : Screen("quiz_nine")
    object QuizTen : Screen("quiz_ten")
    object QuizEleven : Screen("quiz_eleven")
    object QuizTwelve : Screen("quiz_twelve")
    object QuizThirteen : Screen("quiz_thirteen")
    object QuizFourteen : Screen("quiz_fourteen")
    object QuizFifteen : Screen("quiz_fifteen")
    object QuizSixteen : Screen("quiz_sixteen")
    object QuizSeventeen : Screen("quiz_seventeen")
    object QuizEighteen : Screen("quiz_eighteen")
    object QuizNineteen : Screen("quiz_nineteen")

    // ---------- Quiz Result ----------
    object QuizResult : Screen("quiz_result/{chapter}/{score}/{total}") {
        fun createRoute(chapter: Int, score: Int, total: Int): String =
            "quiz_result/$chapter/$score/$total"
    }

    // ---------- Adhyaya (Chapters) ----------
    object AdhyayaOne : Screen("adhyaya_one")
    object AdhyayaTwo : Screen("adhyaya_two")
    object AdhyayaThree : Screen("adhyaya_three")
    object AdhyayaFour : Screen("adhyaya_four")
    object AdhyayaFive : Screen("adhyaya_five")
    object AdhyayaSix : Screen("adhyaya_six")
    object AdhyayaSeven : Screen("adhyaya_seven")
    object AdhyayaEight : Screen("adhyaya_eight")
    object AdhyayaNine : Screen("adhyaya_nine")
    object AdhyayaTen : Screen("adhyaya_ten")
    object AdhyayaEleven : Screen("adhyaya_eleven")
    object AdhyayaTwelve : Screen("adhyaya_twelve")
    object AdhyayaThirteen : Screen("adhyaya_thirteen")
    object AdhyayaFourteen : Screen("adhyaya_fourteen")
    object AdhyayaFifteen : Screen("adhyaya_fifteen")
    object AdhyayaSixteen : Screen("adhyaya_sixteen")
    object AdhyayaSeventeen : Screen("adhyaya_seventeen")
    object AdhyayaEighteen : Screen("adhyaya_eighteen")
}
