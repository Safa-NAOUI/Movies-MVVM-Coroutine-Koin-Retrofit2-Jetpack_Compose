package com.example.moviesapp.data.remote

import com.example.moviesapp.data.model.MovieModel

class MovieRemoteDataSource(private val apiService: MovieApiService) {

    suspend fun getMovies(page: Int, genreId: String?): List<MovieModel> {
        return apiService.getMovies(page, genreId).results
    }
}