package com.anantagita.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.anantagita.ui.screens.home.QuizHomeScreen
import com.anantagita.auth.AuthViewModel
import com.anantagita.navigation.Screen
import kotlinx.coroutines.launch

// ---------------- Data Class ----------------
data class MainScreenItem(
    val title: String,
    val icon: ImageVector,
    val content: @Composable (NavHostController) -> Unit
)

// ---------------- MainSwipeableScreen ----------------
@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun MainSwipeableScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    onLogout: () -> Unit,
    onPremiumPurchased: () -> Unit,
    // 💡 NEW: Function provided by NavGraph to handle safe navigation
    safeNavigate: (String) -> Unit
) {
    val scope = rememberCoroutineScope()
    var menuExpanded by rememberSaveable { mutableStateOf(false) }
    var showLogoutDialog by rememberSaveable { mutableStateOf(false) }

    // State collections are kept for screen logic, but not directly involved in the crash fix.
    // val authState by authViewModel.authState.collectAsState()
    // val isLoggedIn by authViewModel.isUserLoggedIn.collectAsState()

    // ✅ Tab items
    val mainScreenItems = listOf(
        MainScreenItem("Home", Icons.Default.Home) { nav -> HomeScreen(nav) },
        MainScreenItem("Quiz", Icons.Default.QuestionAnswer) { nav -> QuizHomeScreen(nav) },
        MainScreenItem("Support", Icons.Default.SupportAgent) { _ -> SupportScreen(onPremiumPurchased) },
        MainScreenItem("Profile", Icons.Default.Person) { nav -> ProfileScreen(nav, authViewModel) }
    )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { mainScreenItems.size })
    val currentPage by remember { derivedStateOf { pagerState.currentPage } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Ananta Gita",
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White
                    )
                },
                actions = {
                    IconButton(onClick = { menuExpanded = true }) {
                        Icon(Icons.Default.MoreVert, contentDescription = "Menu", tint = Color.White)
                    }
                    DropdownMenu(
                        expanded = menuExpanded,
                        onDismissRequest = { menuExpanded = false }
                    ) {
                        // 🛠️ CRASH FIX: Use safeNavigate lambda for navigation
                        DropdownMenuItem(
                            text = { Text("About") },
                            leadingIcon = { Icon(Icons.Default.Info, null) },
                            onClick = {
                                menuExpanded = false
                                safeNavigate(Screen.About.route)
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Feedback") },
                            leadingIcon = { Icon(Icons.Default.Feedback, null) },
                            onClick = {
                                menuExpanded = false
                                safeNavigate(Screen.Feedback.route)
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Privacy & Terms") },
                            leadingIcon = { Icon(Icons.Default.PrivacyTip, null) },
                            onClick = {
                                menuExpanded = false
                                safeNavigate(Screen.PrivacyTerms.route)
                            }
                        )
                        HorizontalDivider()
                        DropdownMenuItem(
                            text = { Text("Logout", color = MaterialTheme.colorScheme.error) },
                            leadingIcon = {
                                Icon(
                                    Icons.AutoMirrored.Filled.Logout,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.error
                                )
                            },
                            onClick = {
                                menuExpanded = false
                                showLogoutDialog = true
                            }
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                modifier = Modifier
                    .shadow(6.dp)
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.secondary
                            )
                        )
                    )
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                NavigationBar(
                    tonalElevation = 8.dp,
                    modifier = Modifier
                        .fillMaxWidth(0.92f)
                        .shadow(12.dp, shape = MaterialTheme.shapes.extraLarge)
                        .clip(MaterialTheme.shapes.extraLarge)
                ) {
                    mainScreenItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = currentPage == index,
                            onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                            icon = {
                                Icon(
                                    item.icon,
                                    contentDescription = null,
                                    tint = if (currentPage == index)
                                        MaterialTheme.colorScheme.primary
                                    else
                                        MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            },
                            label = {
                                Text(
                                    item.title,
                                    fontWeight = if (currentPage == index) FontWeight.Bold else FontWeight.Normal
                                )
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            HorizontalPager(
                state = pagerState,
                userScrollEnabled = true,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                AnimatedVisibility(
                    visible = currentPage == page,
                    enter = fadeIn(animationSpec = tween(300)) +
                            slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300)),
                    exit = fadeOut(animationSpec = tween(300)) +
                            slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))
                ) {
                    mainScreenItems[page].content(navController)
                }
            }
        }
    }

    if (showLogoutDialog) {
        AlertDialog(
            onDismissRequest = { showLogoutDialog = false },
            title = { Text("Logout") },
            text = { Text("Are you sure you want to log out of Ananta Gita?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showLogoutDialog = false
                        onLogout()
                    }
                ) {
                    Text("Logout", color = MaterialTheme.colorScheme.error)
                }
            },
            dismissButton = {
                TextButton(onClick = { showLogoutDialog = false }) {
                    Text("Dismiss")
                }
            }
        )
    }
}