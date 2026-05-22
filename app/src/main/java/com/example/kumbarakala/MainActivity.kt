package com.example.kumbarakala

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kumbarakala.data.ArtisanProfileRepository
import com.example.kumbarakala.nav.Destinations
import com.example.kumbarakala.ui.ArtisanViewModel
import com.example.kumbarakala.ui.about.AboutScreen
import com.example.kumbarakala.ui.card.CardPreviewScreen
import com.example.kumbarakala.ui.detail.ProductDetailScreen
import com.example.kumbarakala.ui.home.HomeScreen
import com.example.kumbarakala.ui.onboarding.OnboardingScreen
import com.example.kumbarakala.ui.profile.ProfileScreen
import com.example.kumbarakala.ui.theme.KumbaraKalaTheme
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val startDestination = runBlocking {
            val repo = ArtisanProfileRepository(applicationContext)
            if (repo.profile.first().isComplete) Destinations.HOME else Destinations.ONBOARDING
        }

        setContent {
            KumbaraKalaTheme {
                KumbaraKalaApp(startDestination = startDestination)
            }
        }
    }
}

@Composable
private fun KumbaraKalaApp(startDestination: String) {
    val navController = rememberNavController()
    val artisanVm: ArtisanViewModel = viewModel()
    val profile by artisanVm.profile.collectAsState()

    val openAbout = { navController.navigate(Destinations.ABOUT) }

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        enterTransition = {
            slideInHorizontally(initialOffsetX = { it / 8 }, animationSpec = tween(320)) +
                fadeIn(animationSpec = tween(320))
        },
        exitTransition = {
            fadeOut(animationSpec = tween(200))
        },
        popEnterTransition = {
            slideInHorizontally(initialOffsetX = { -it / 8 }, animationSpec = tween(320)) +
                fadeIn(animationSpec = tween(320))
        },
        popExitTransition = {
            slideOutHorizontally(targetOffsetX = { it / 8 }, animationSpec = tween(280)) +
                fadeOut(animationSpec = tween(200))
        }
    ) {
        composable(Destinations.ONBOARDING) {
            OnboardingScreen(
                onDone = {
                    navController.navigate(Destinations.HOME) {
                        popUpTo(Destinations.ONBOARDING) { inclusive = true }
                    }
                }
            )
        }

        composable(Destinations.HOME) {
            HomeScreen(
                onProductClick = { product ->
                    navController.navigate(Destinations.detail(product.id))
                },
                onProfileClick = { navController.navigate(Destinations.PROFILE) },
                onAboutClick = openAbout
            )
        }

        composable(Destinations.PROFILE) {
            ProfileScreen(
                onBack = { navController.popBackStack() },
                onAbout = openAbout
            )
        }

        composable(Destinations.ABOUT) {
            AboutScreen(onBack = { navController.popBackStack() })
        }

        composable(
            route = Destinations.DETAIL,
            arguments = listOf(navArgument("productId") { type = NavType.StringType })
        ) { backStack ->
            val productId = backStack.arguments?.getString("productId").orEmpty()
            ProductDetailScreen(
                productId = productId,
                onBack = { navController.popBackStack() },
                onAbout = openAbout,
                onGenerateCard = { id, index ->
                    if (profile.isComplete) {
                        navController.navigate(Destinations.card(id, index))
                    } else {
                        navController.navigate(Destinations.PROFILE)
                    }
                }
            )
        }

        composable(
            route = Destinations.CARD,
            arguments = listOf(
                navArgument("productId") { type = NavType.StringType },
                navArgument("benefitIndex") { type = NavType.IntType }
            )
        ) { backStack ->
            val productId = backStack.arguments?.getString("productId").orEmpty()
            val benefitIndex = backStack.arguments?.getInt("benefitIndex") ?: 0
            CardPreviewScreen(
                productId = productId,
                initialBenefitIndex = benefitIndex,
                onBack = { navController.popBackStack() },
                onAbout = openAbout
            )
        }
    }
}
