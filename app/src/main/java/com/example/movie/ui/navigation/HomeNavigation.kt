package com.example.movie.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.movie.ui.screens.movies.details.MovieDetailsScreen
import com.example.movie.ui.screens.movies.list.MovieListScreen
import com.google.gson.Gson
import com.invia.domain.datasource.database.entities.Movie

@Composable
fun NavigationComponent(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = Navigate.MovieList.route) {

        composable(Navigate.MovieList.route) {
            MovieListScreen(navHostController = navHostController)
        }

        composable(
            Navigate.MovieDetails.route.plus("/{id}"),
            arguments = Navigate.MovieDetails.arguments!!
        ) {
            val id = it.arguments?.getInt("id")
            if (id != null) {
                MovieDetailsScreen(navHostController = navHostController, movieId = id)
            }
        }
    }
}