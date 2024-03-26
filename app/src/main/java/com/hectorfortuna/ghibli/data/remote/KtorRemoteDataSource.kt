package com.hectorfortuna.ghibli.data.remote

import com.hectorfortuna.ghibli.data.response.MovieDataResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class KtorRemoteDataSource(private val httpClient: HttpClient): RemoteDataSource {
    companion object{
        private const val BASE_URL = "https://ghibliapi.vercel.app"
    }
    override suspend fun getMovieDataResponse(): List<MovieDataResponse> {
        return httpClient
            .get("$BASE_URL/films")
            .body()
    }
}