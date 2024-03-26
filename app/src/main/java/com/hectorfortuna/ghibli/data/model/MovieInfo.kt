package com.hectorfortuna.ghibli.data.model

data class MovieInfo(
    val id: String,
    val title: String,
    val originalTitle: String,
    val description: String,
    val director: String,
    val releaseDate: String,
    val image: String,
    val movieBanner: String
)