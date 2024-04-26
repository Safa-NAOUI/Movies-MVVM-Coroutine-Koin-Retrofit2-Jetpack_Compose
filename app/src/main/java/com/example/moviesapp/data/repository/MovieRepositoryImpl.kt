package com.example.moviesapp.data.repository

import com.example.moviesapp.data.model.MovieModel
import com.example.moviesapp.data.remote.MovieRemoteDataSource

class MovieRepository(private val remoteDataSource: MovieRemoteDataSource) : IMovieRepository {

    override suspend fun getPopularMovies(page: Int, genreId: String?): List<MovieModel> {
        return remoteDataSource.getPopularMovies(page, genreId)
    }
}