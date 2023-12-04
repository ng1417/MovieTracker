package com.cs211d.movietracker.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.cs211d.movietracker.MovieAppScreen
import com.cs211d.movietracker.R
import com.cs211d.movietracker.ui.components.NavigationButton

@Composable
fun HomeScreen(
    onEnterMovieClick : () -> Unit = {},
    onRecommendationMovieClick : () -> Unit = {},
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = (stringResource(R.string.welcome)),
            style = MaterialTheme.typography.displayLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        Text(
            text = (stringResource(R.string.welcome_instructions_text)),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .wrapContentSize(align = Alignment.CenterStart)
        )

        /*** CREATE A BUTTON TO GO TO THE EnterMovieScreen  ***/
        // add parameters to the HomeScreen composable as needed
        NavigationButton(stringResource(R.string.enter_movies_button_text), onEnterMovieClick)

        /*** CREATE A BUTTON TO GO TO THE RecommendMovieScreen  ***/
        // add parameters to the HomeScreen composable as needed
        NavigationButton(stringResource(R.string.movie_recommendation_button_text), onRecommendationMovieClick)
    }
}

