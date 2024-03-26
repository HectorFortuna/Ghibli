package com.hectorfortuna.ghibli.data.remote

import com.hectorfortuna.ghibli.data.response.MovieDataResponse

interface RemoteDataSource {
    suspend fun getMovieDataResponse(): List<MovieDataResponse>
}