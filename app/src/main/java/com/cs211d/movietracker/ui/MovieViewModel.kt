package com.cs211d.movietracker.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.cs211d.movietracker.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class MovieViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    // the movie the user is currently typing in
    var currentMovie by mutableStateOf("")

    private val movieList: MutableList<String> = mutableStateListOf()

    private fun isValidMovie(movie: String): Boolean {
        return movie.isNotEmpty()
    }

    /*** COMPLETE THIS FUNCTION ***/
    // the user is typing in a movie; update the currentMovie variable and the state of the ui
    // to indicate whether there is an error
    fun updateMovie(movie: String) {
        currentMovie = movie
        _uiState.update { currentState ->
            currentState.copy(
                movieError = !isValidMovie(movie)
            )
        }
    }

    /*** COMPLETE THIS FUNCTION ***/
    // update the state of the ui with a movie recommendation. if the list is empty,
    // the recommendation can be "N/A". otherwise, randomly select a movie from the list.
    fun recommendMovie()  {
        _uiState.update { currentState ->
            currentState.copy(
                movieRecommendation = if (movieList.isNotEmpty()) {
                    movieList.random()
                } else {
                    "N/A"
                }
            )
        }
    }

    /*** COMPLETE THIS FUNCTION ***/
    // if the movie is valid, add it to the list.
    // either way, update the state of the ui and the currentMovie.
    fun addMovieToList() {

        if (isValidMovie(currentMovie)) {
            movieList.add(currentMovie)
        }
        updateMovie("")
    }

    /*** RECOMMENDED: add one or more private methods to update the state of the ui! ***/
    private fun updateUiState() {
        val isError = !isValidMovie(currentMovie)
        val errorMessage = if (isError) "Please enter a valid movie name" else ""
        _uiState.value = _uiState.value.copy(movieError = isError, movieList = movieList, movieRecommendation = "")
    }


}