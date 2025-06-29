package org.jrdemadara.bluecollar.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import org.jrdemadara.bluecollar.features.login.presentation.LoginScreen
import org.jrdemadara.bluecollar.features.register.presentation.RegisterScreen
import org.jrdemadara.bluecollar.features.welcome.presentation.WelcomeScreen

fun NavGraphBuilder.guestNavGraph(navController: NavHostController) {
    navigation(startDestination = Routes.REGISTER, route = NavGraph.GUEST_GRAPH) {
        composable(Routes.WELCOME) { WelcomeScreen(navController) }
        composable(Routes.REGISTER) { RegisterScreen(navController) }
        composable(Routes.LOGIN) { LoginScreen(navController) }
    }
}