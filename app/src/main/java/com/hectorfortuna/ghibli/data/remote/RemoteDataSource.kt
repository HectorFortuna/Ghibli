package com.hectorfortuna.ghibli.data.remote

import com.hectorfortuna.ghibli.data.response.MovieDataResponse

interface RemoteDataSource {
    suspend fun getMovieDataResponse(limit:Int): List<MovieDataResponse>
}