package com.example.moviesapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.moviesapp.ui.list.MovieListScreen
import com.example.moviesapp.ui.list.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: MovieViewModel by viewModel()
           MovieListScreen(viewModel)
        }
    }
}