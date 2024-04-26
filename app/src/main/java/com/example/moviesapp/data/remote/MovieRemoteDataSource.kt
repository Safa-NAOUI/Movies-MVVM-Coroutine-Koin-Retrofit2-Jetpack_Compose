package com.example.moviesapp.data.remote

import com.example.moviesapp.data.model.MovieModel

class MovieRemoteDataSource(private val apiService: MovieApiService) {

    suspend fun getPopularMovies(page: Int, genreId: String?): List<MovieModel> {
        return apiService.getPopularMovies(page, genreId).results
    }
}