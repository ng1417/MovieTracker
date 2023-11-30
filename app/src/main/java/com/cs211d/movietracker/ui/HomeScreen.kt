package com.cs211d.movietracker.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cs211d.movietracker.R

@Composable
fun HomeScreen(
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


        /*** CREATE A BUTTON TO GO TO THE RecommendMovieScreen  ***/
        // add parameters to the HomeScreen composable as needed
    }
}

