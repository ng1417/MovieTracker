package com.cs211d.movietracker.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cs211d.movietracker.MovieAppScreen
import com.cs211d.movietracker.R

@Composable
fun HomeScreen(
    onAddMovie: () -> Unit,
    onClickRecommend: () -> Unit
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
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
        )
        Text(
            text = (stringResource(R.string.welcome_instructions_text)),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
                .wrapContentSize(align = Alignment.CenterStart)
        )

        /*** CREATE A BUTTON TO GO TO THE EnterMovieScreen  ***/
        // add parameters to the HomeScreen composable as needed
        Button(
            onClick = onAddMovie,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .wrapContentHeight()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.enter_movie),
                fontSize = 24.sp
            )
        }


        /*** CREATE A BUTTON TO GO TO THE RecommendMovieScreen  ***/
        // add parameters to the HomeScreen composable as needed
        Button(
            onClick = onClickRecommend,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .wrapContentHeight()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = stringResource(R.string.recommend_movie),
                fontSize = 24.sp
            )
        }

    }
}


