package org.jrdemadara.bluecollar.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = Routes.LOGIN, route = NavGraph.AUTH_GRAPH) {
//        composable(Routes.WELCOME) { WelcomeScreen(navController) }
//        composable(Routes.LOGIN) { LoginScreen(navController) }
    }
}