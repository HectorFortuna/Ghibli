package com.hectorfortuna.ghibli.data.repository

import com.hectorfortuna.ghibli.data.MoviesMapper
import com.hectorfortuna.ghibli.data.model.MovieInfo
import com.hectorfortuna.ghibli.data.remote.RemoteDataSource

class MoviesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MoviesRepository {
    override suspend fun getMoviesRepository(): List<MovieInfo> {
        val response = remoteDataSource.getMovieDataResponse()
        return MoviesMapper.mapToDataInfoList(response)

    }
}
