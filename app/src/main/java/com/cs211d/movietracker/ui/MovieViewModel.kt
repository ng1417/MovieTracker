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
import java.util.Random


class MovieViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    // the movie the user is currently typing in
    var currentMovie by mutableStateOf("")

    private var movieRecommendation: String = "N/A"
    private var isError = true
    private val movieList: MutableList<String> = mutableStateListOf()

    private fun isValidMovie(movie: String): Boolean {
        return movie.isNotEmpty()
    }

    /*** COMPLETE THIS FUNCTION ***/
    // the user is typing in a movie; update the currentMovie variable and the state of the ui
    // to indicate whether there is an error
    fun updateMovie(movie: String) {
        currentMovie  = movie
        isError = movie.isEmpty()
        updateUiState(isError, movieRecommendation, movieList)
    }

    /*** COMPLETE THIS FUNCTION ***/
    // update the state of the ui with a movie recommendation. if the list is empty,
    // the recommendation can be "N/A". otherwise, randomly select a movie from the list.
    fun recommendMovie()  {
        if (movieList.size > 0) {
            movieRecommendation = movieList.random()
        }
        updateUiState(isError, movieRecommendation, movieList)
    }

    /*** COMPLETE THIS FUNCTION ***/
    // if the movie is valid, add it to the list.
    // either way, update the state of the ui and the currentMovie.
    fun addMovieToList() {
        if (!isError) {
            movieList.add(currentMovie)
            recommendMovie()
        } else {
            updateMovie("")
        }
        updateUiState(isError, movieRecommendation, movieList)

    }

    /*** RECOMMENDED: add one or more private methods to update the state of the ui! ***/
    private fun updateUiState(movieError: Boolean, movieRecommendation:String, movieLIst:List<String>) {
        _uiState.update{ currentState ->
                currentState.copy(
                    movieError = movieError,
                    movieRecommendation = movieRecommendation,
                    movieList = movieList
                )
        }

    }


}