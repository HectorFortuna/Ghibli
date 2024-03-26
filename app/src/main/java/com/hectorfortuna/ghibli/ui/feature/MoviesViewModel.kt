package com.hectorfortuna.ghibli.ui.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hectorfortuna.ghibli.data.repository.MoviesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val repository: MoviesRepository
): ViewModel() {

    private val _movieInfoState = MutableStateFlow(MoviesInfoState())
    val movieInfoState:StateFlow<MoviesInfoState> = _movieInfoState.asStateFlow()

    init {
        getMoviesInfo()
    }

    private fun getMoviesInfo(){
        viewModelScope.launch {
            val movieInfo = repository.getMoviesRepository()
            _movieInfoState.update {
                it.copy(movieInfo = movieInfo)
            }
        }
    }

}