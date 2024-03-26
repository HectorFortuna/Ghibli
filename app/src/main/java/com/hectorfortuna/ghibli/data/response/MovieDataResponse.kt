package com.hectorfortuna.ghibli.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDataResponse(
    val id: String,
    val title: String,
    @SerialName("original_title")
    val originalTitle: String,
    @SerialName("original_title_romanised")
    val originalTitleRomanised: String,
    val image: String,
    @SerialName("movie_banner")
    val movieBanner: String,
    val description: String,
    val director: String,
    val producer: String,
    @SerialName("release_date")
    val releaseDate: String,
    @SerialName("running_time")
    val runningTime: String,
    @SerialName("rt_score")
    val rtScore: String,
    val people: List<String>,
    val species: List<String>,
    val locations: List<String>,
    val vehicles: List<String>,
    val url: String
)
