package com.cs211d.movietracker.data

data class UiState(

    val movieError : Boolean = false,
    val movieRecommendation : String = "N/A",
    val movieList: List<String> = listOf()


)
