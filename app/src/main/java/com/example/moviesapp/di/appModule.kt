package com.example.moviesapp.di

import com.example.moviesapp.data.remote.MovieApiService
import com.example.moviesapp.data.remote.MovieRemoteDataSource
import com.example.moviesapp.data.repository.IMovieRepository
import com.example.moviesapp.data.repository.MovieRepository
import com.example.moviesapp.ui.list.MovieViewModel
import com.example.moviesapp.utils.Constants
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val appModule = module {
    /** Retrofit **/
    single { provideRetrofit() }

    /** MovieApiService **/
    single { provideMovieApiService(get()) }

    /** MovieRemoteDataSource  **/
    single { MovieRemoteDataSource(get()) }

    /** MovieRepository **/
    single<IMovieRepository> { MovieRepository(get()) }

    /** MovieViewModel  **/
    viewModel { MovieViewModel(get()) }
}

private fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideMovieApiService(retrofit: Retrofit): MovieApiService {
    return retrofit.create(MovieApiService::class.java)
}