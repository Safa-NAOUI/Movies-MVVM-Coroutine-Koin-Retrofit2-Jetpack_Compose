package com.example.moviesapp.data.remote

import com.example.moviesapp.data.model.BaseModel
import com.example.moviesapp.utils.Constants.Companion.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/now_playing")
    suspend fun getMovies(
        @Query("page") page: Int,
        @Query("with_genres") genreId: String?,
        @Query("api_key") api_key: String = API_KEY
    ): BaseModel
}