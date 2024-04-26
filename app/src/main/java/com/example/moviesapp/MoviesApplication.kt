package com.example.moviesapp

import android.app.Application
import com.example.moviesapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        /** Start Koin **/
        startKoin {
            androidContext(this@MoviesApplication)
            /** modules **/
            modules(appModule)
        }
    }
}