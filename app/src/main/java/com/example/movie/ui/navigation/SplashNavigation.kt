package com.example.movie.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movie.ui.screens.splash.SplashScreen

@Composable
fun SplashNavigation(
    splashNavHostController: NavHostController,
) {

    val authNavController = rememberNavController()
    NavHost(navController = authNavController, startDestination = Navigate.startDestination.route) {
        composable(Navigate.Splash.route) {
            SplashScreen(onAuthSuccess = {
                splashNavHostController.navigateAndClean(Navigate.MovieList.route)
            }, onAuthFailure = {
                authNavController.navigateAndClean(Navigate.Login.route)
            })
        }
        /*composable(Route.Login.route) {
            LoginScreen(onAuthSuccess = {
                splashNavHostController.navigate("main")
            }, onAuthFailed = { route, data ->
            }, onNavigateTo = { route, data ->
                authNavController.navigateAndClean(route)
            }, onRegisterClick = { authNavController.navigateAndClean(Route.Register.route) })
        }
        composable(Route.Register.route) {
            RegisterScreen(onAuthSuccess = {
                authNavController.navigateAndClean(Route.Login.route)
            }, onAuthFailed = { route, data ->
            }, onNavigateTo = { route, data ->
                authNavController.navigateAndClean(route)
            })
        }*/
    }

}