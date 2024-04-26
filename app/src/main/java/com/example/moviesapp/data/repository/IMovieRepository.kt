package com.example.moviesapp.data.repository

import com.example.moviesapp.data.model.MovieModel

interface IMovieRepository {
    suspend fun getPopularMovies(page: Int, genreId: String?): List<MovieModel>
}