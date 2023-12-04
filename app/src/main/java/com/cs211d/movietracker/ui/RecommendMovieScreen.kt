package com.cs211d.movietracker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cs211d.movietracker.data.UiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRecommendation(
    uiState : UiState,
    onClickHome: () -> Unit = {},
    onAddMovie: () -> Unit,
) {

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        /*** CREATE TEXT THAT SPECIFIES THE NUMBER OF MOVIES TO CHOOSE FROM ***/
        // add parameters to the MovieRecommendation composable as needed
        Text(
            text = uiState.movieList.size.toString(),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
                .wrapContentSize(align = Alignment.Center)
        )

        /*** CREATE TEXT THAT DISPLAYS THE RECOMMENDED MOVIE ***/
        // add parameters to the MovieRecommendation composable as needed
        Text(
            text = uiState.movieRecommendation.toString(),
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp)
                .wrapContentSize(align = Alignment.Center)
        )


        /*** CREATE A BUTTON TO GO TO THE EnterMovieScreen  ***/
        // add parameters to the MovieRecommendation composable as needed
        Button(
            onClick = onAddMovie,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .wrapContentHeight()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Enter Movie",
                fontSize = 24.sp
            )
        }

        /*** CREATE A BUTTON TO GO TO THE HomeScreen  ***/
        // add parameters to the MovieRecommendation composable as needed
        Button(
            onClick = onClickHome,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .wrapContentHeight()
                .padding(vertical = 16.dp)
        ) {
            Text(
                text = "Home",
                fontSize = 24.sp
            )
        }

        /*** NOTE
         * These are the styles I used in my video example. You are NOT required to use these!
         */

//        Text(
//            text = "",
//            style = MaterialTheme.typography.displaySmall,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier
//                .padding(vertical = 16.dp)
//                .wrapContentSize(align = Alignment.Center)
//        )
//        Button(
//            onClick = { }
//        ) {
//            Text(
//                text = "",
//                fontSize = 24.sp
//            )
//        }
    }
}
