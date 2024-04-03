package com.hectorfortuna.ghibli.data.repository

import com.hectorfortuna.ghibli.data.MoviesMapper
import com.hectorfortuna.ghibli.data.model.MovieInfo
import com.hectorfortuna.ghibli.data.remote.RemoteDataSource

class MoviesRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : MoviesRepository {
    override suspend fun getMoviesRepository(limit:Int): List<MovieInfo> {
        val response = remoteDataSource.getMovieDataResponse(limit)
        return MoviesMapper.mapToDataInfoList(response)

    }
}
