package com.hectorfortuna.ghibli.data.repository

import com.hectorfortuna.ghibli.data.model.MovieInfo

interface MoviesRepository {

    suspend fun getMoviesRepository(): List<MovieInfo>
}