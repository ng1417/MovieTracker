package com.cs211d.movietracker.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cs211d.movietracker.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterMovieScreen(
    movieViewModel: MovieViewModel,
    onClickHome: () -> Unit = {},
    onClickRecommend: () -> Unit = {},
    onMovieInputChange: (String) -> Unit,
    onAddMovie: () -> Unit,

    ) {
    val uiState by movieViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = movieViewModel.currentMovie,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.surface,
                unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                disabledContainerColor = MaterialTheme.colorScheme.surface,
            ),
            onValueChange = { onMovieInputChange(it) },
            label = { Text(stringResource(R.string.movie_field_label)) },
            isError = uiState.movieError
        )

        Button(
            onClick = onAddMovie,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        ) {
            Text(text = stringResource(R.string.add_button_text),
                fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onClickRecommend,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.movie_recommendation_button_text),
                fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onClickHome,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.home_button_text),
                fontSize = 24.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))


        LazyColumn {
            items(uiState.movieList) { movie ->
                MovieCard(
                    movie = movie
                )
            }
        }
    }
}

@Composable
fun MovieCard(movie: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = movie, fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
