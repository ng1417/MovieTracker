package com.cs211d.movietracker

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cs211d.movietracker.ui.EnterMovieScreen
import com.cs211d.movietracker.ui.HomeScreen
import com.cs211d.movietracker.ui.MovieRecommendation
import com.cs211d.movietracker.ui.MovieViewModel


enum class MovieAppScreen(@StringRes val title: Int) {
    EnterMovie(title = R.string.enter_a_movie),
    RecommendMovie(title = R.string.movie_recommendation),
    Home(title = R.string.app_name)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieTrackAppBar(
    currentScreen: MovieAppScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieApp(
    viewModel: MovieViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        MovieAppScreen.valueOf(
            backStackEntry?.destination?.route ?: MovieAppScreen.Home.name
        )

    Scaffold(
        topBar = {
            MovieTrackAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() },
            )
        }

    ) { innerPadding ->
        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MovieAppScreen.Home.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            /*** COMPLETE THE NAVHOST DEFINITION BY SPECIFYING THE THREE ROUTES ***/

            // add to or modify this existing composable as needed
            composable(route = MovieAppScreen.Home.name) {
                HomeScreen(
                    onEnterMovieClick = {navController.navigate(MovieAppScreen.EnterMovie.name)},
                    onRecommendationMovieClick = {navController.navigate(MovieAppScreen.RecommendMovie.name)},
                )
            }

            composable(route = MovieAppScreen.EnterMovie.name) {
                EnterMovieScreen(
                    movieViewModel = viewModel,
                    onClickHome = { navController.navigate(MovieAppScreen.Home.name) },
                    onClickRecommend = { navController.navigate(MovieAppScreen.RecommendMovie.name) },
                    onMovieInputChange = { viewModel.updateMovie(it) },
                    onAddMovie = { viewModel.addMovieToList() },
                )
            }

            composable(route = MovieAppScreen.RecommendMovie.name) {
                MovieRecommendation(
                    uiState = uiState,
                    onEnterMovieClick = { navController.navigate(MovieAppScreen.EnterMovie.name) },
                    onHomeButtonClick = { navController.navigate(MovieAppScreen.Home.name)
                    viewModel.recommendMovie()}
                )
            }
        }
    }
}


