package com.example.moviesapp.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.data.model.MovieModel
import com.example.moviesapp.data.repository.IMovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel(private val repository: IMovieRepository) : ViewModel() {
    private val _movies = MutableStateFlow<List<MovieModel>>(emptyList())
    val movies: StateFlow<List<MovieModel>> = _movies

    init {
        fetchMovies(page = 1, genreId = null)
    }

    private fun fetchMovies(page: Int, genreId: String?) {
        viewModelScope.launch {
            _movies.value = repository.getMovies(page, genreId)
        }
    }
}