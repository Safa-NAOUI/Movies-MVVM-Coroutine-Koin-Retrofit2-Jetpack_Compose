package com.example.moviesapp.ui.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.moviesapp.data.model.MovieModel
import com.example.moviesapp.ui.component.MovieCard
import com.example.moviesapp.ui.component.loading.ShowLoadingIndicator
import com.example.moviesapp.ui.theme.DeepViolet
import kotlinx.coroutines.flow.StateFlow


/**
 * Created by Safa NAOUI on 28,April,2024
 */

@Composable
fun MovieListScreen(viewModel: MovieViewModel) {
    val moviesState: StateFlow<List<MovieModel>> = viewModel.movies
    val movies = moviesState.collectAsState(initial = emptyList()).value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Movie List", color = Color.White) },
                backgroundColor = DeepViolet
            )
        },
        content = { padding ->
            if (movies.isEmpty()) {
                ShowLoadingIndicator()
            } else {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    horizontalArrangement = Arrangement.spacedBy(0.dp),
                    content = {
                        itemsIndexed(movies) { _, item ->
                            item?.let {
                                MovieCard(item)
                            }
                        }
                    }
                )
            }
        }
    )
}
