package denys.diomaxius.mathchamps.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import denys.diomaxius.mathchamps.ui.game.Game
import denys.diomaxius.mathchamps.ui.home.Home

@Composable
fun Navigation(
    navHostController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navHostController,
        startDestination = "home"
    ) {
        composable("home") { Home(navHostController) }

        composable(
            route = "game/{difficulty}",
            arguments = listOf(navArgument("difficulty") { type = NavType.StringType })
        ) {
            Game()
        }
    }

}