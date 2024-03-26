package com.hectorfortuna.ghibli.ui.feature

import com.hectorfortuna.ghibli.data.model.MovieInfo

data class MoviesInfoState(
    val movieInfo: List<MovieInfo>? = null
)