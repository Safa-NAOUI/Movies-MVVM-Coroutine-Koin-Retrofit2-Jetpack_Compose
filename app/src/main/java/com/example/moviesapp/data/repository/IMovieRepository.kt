package com.example.moviesapp.data.repository

import com.example.moviesapp.data.model.MovieModel

interface IMovieRepository {
    suspend fun getMovies(page: Int, genreId: String?): List<MovieModel>
}