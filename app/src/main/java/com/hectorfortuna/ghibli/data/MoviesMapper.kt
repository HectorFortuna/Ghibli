package com.hectorfortuna.ghibli.data

import com.hectorfortuna.ghibli.data.model.MovieInfo
import com.hectorfortuna.ghibli.data.response.MovieDataResponse

class MoviesMapper {
    companion object {
        fun mapToDataInfoList(movieList: List<MovieDataResponse>): List<MovieInfo> {
            return movieList.map { movie ->
                MovieInfo(
                    id = movie.id,
                    title = movie.title,
                    originalTitle = movie.originalTitle,
                    description = movie.description,
                    director = movie.director,
                    releaseDate = movie.releaseDate,
                    image = movie.image,
                    movieBanner = movie.movieBanner,
                )
            }
        }
    }
}