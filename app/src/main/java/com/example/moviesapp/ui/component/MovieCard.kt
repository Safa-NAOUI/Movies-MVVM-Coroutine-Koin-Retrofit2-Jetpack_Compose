package com.example.moviesapp.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesapp.data.model.MovieModel
import com.example.moviesapp.ui.list.item.MovieItem

/**
 * Created by Safa NAOUI on 28,April,2024
 */

@Composable
fun MovieCard(movieItem: MovieModel) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier.padding(4.dp)
    ) {
        MovieItem(movieItem)
    }
}