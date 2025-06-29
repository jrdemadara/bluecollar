package org.jrdemadara.bluecollar.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.russhwolf.settings.Settings

object NavGraph {
    const val GUEST_GRAPH = "guest_graph"
    const val AUTH_GRAPH = "auth_graph"

    const val HOME_GRAPH = "home_graph"

}

object Routes {
    // Auth Routes
    const val WELCOME = "welcome"
    const val REGISTER = "register"
    const val LOGIN = "login"

    // Root Routes
    const val HOME = "home"

    const val CHAT = "chat"
    const val SEARCH_MEMBER = "search_member"
    const val MESSAGE_REQUEST = "message_request"
    const val THREAD = "thread"
}

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
) {
    val settings: Settings = Settings()
    val isAuthenticated = settings.hasKey("auth_token")

    NavHost(
        navController = navController,
        startDestination = if (isAuthenticated) NavGraph.AUTH_GRAPH else NavGraph.GUEST_GRAPH
    ) {
        guestNavGraph(navController)
        authNavGraph(navController)
    }
}