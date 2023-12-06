package com.cs211d.movietracker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cs211d.movietracker.R
import com.cs211d.movietracker.data.UiState
import com.cs211d.movietracker.ui.components.NavigationButton


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRecommendation(
    uiState : UiState,
    onEnterMovieClick : () -> Unit = {},
    onHomeButtonClick : () -> Unit = {}
) {

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {


        /*** CREATE TEXT THAT SPECIFIES THE NUMBER OF MOVIES TO CHOOSE FROM ***/
        // add parameters to the MovieRecommendation composable as needed
        val numberOfMovie = uiState.movieList.size
        Text(stringResource(R.string.movie_list_summary_text,numberOfMovie))

        /*** CREATE TEXT THAT DISPLAYS THE RECOMMENDED MOVIE ***/
        // add parameters to the MovieRecommendation composable as needed
        val recMovie = uiState.movieRecommendation
        Text(
            text = "Recommended Movie: $recMovie",
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .wrapContentSize(align = Alignment.Center)
        )

        /*** CREATE A BUTTON TO GO TO THE EnterMovieScreen  ***/
        // add parameters to the MovieRecommendation composable as needed
        NavigationButton(stringResource(R.string.enter_movies_button_text), onEnterMovieClick)

        /*** CREATE A BUTTON TO GO TO THE HomeScreen  ***/
        // add parameters to the MovieRecommendation composable as needed
        NavigationButton(stringResource(R.string.home_button_text), onHomeButtonClick)
    }
}
