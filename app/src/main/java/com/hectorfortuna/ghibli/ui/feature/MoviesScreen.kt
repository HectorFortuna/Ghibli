package com.hectorfortuna.ghibli.ui.feature

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
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
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                columns = GridCells.Adaptive(minSize = 130.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),


            )
            {
                items(it) { movieInfoItem ->
                    Card(modifier = Modifier.fillMaxWidth())
                    {
                        ImageFromUrl(url = movieInfoItem.image)
                        Text(
                            text = movieInfoItem.title,
                            color = Color.Black,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}