package com.hectorfortuna.ghibli.ui.feature

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.hectorfortuna.ghibli.data.model.MovieInfo
import com.hectorfortuna.ghibli.ui.theme.GhibliTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun MoviesRoute(
    viewModel: MoviesViewModel = koinViewModel()
) {
    val movieInfoState by viewModel.movieInfoState.collectAsStateWithLifecycle()
    MoviesScreen(movieInfo = movieInfoState.movieInfo)
}

@Composable
fun MoviesScreen(
    movieInfo: List<MovieInfo>?
) {
    movieInfo?.let {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Adaptive(minSize = 128.dp)
            )
            {
                items(it) { movieInfoItem ->
                    Text(
                        text = movieInfoItem.title,
                        color = Color.Black,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    ImageFromUrl(url = movieInfoItem.image)
                }
            }
        }
    }
}


@Preview
@Composable
private fun MoviesScreenPreview() {
    GhibliTheme {
        MoviesScreen(
            movieInfo = listOf(
                MovieInfo(
                    id = "2baf70d1-42bb-4437-b551-e5fed5a87abe",
                    title = "Castle in the Sky",
                    originalTitle = "天空の城ラピュタ",
                    description = "The orphan Sheeta inherited a mysterious crystal that links her to the mythical sky-kingdom of Laputa. With the help of resourceful Pazu and a rollicking band of sky pirates, she makes her way to the ruins of the once-great civilization. Sheeta and Pazu must outwit the evil Muska, who plans to use Laputa's science to make himself ruler of the world.",
                    director = "Hayao Miyazaki",
                    releaseDate = "1986",
                    image = "https://image.tmdb.org/t/p/w600_and_h900_bestv2/npOnzAbLh6VOIu3naU5QaEcTepo.jpg",
                    movieBanner = "https://image.tmdb.org/t/p/w533_and_h300_bestv2/3cyjYtLWCBE1uvWINHFsFnE8LUK.jpg"
                )
            )
        )
    }
}