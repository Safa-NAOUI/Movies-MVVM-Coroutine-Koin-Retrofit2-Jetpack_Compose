package com.example.moviesapp.ui.list.item

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviesapp.data.model.MovieModel
import com.example.moviesapp.ui.component.MovieImage
import com.example.moviesapp.utils.Constants
import com.example.moviesapp.utils.roundTo
import com.example.moviesapp.ui.component.rating.MovieRatingRow

/**
 * Created by Safa NAOUI on 28,April,2024
 */

@Composable
fun MovieItem(movieItem: MovieModel) {
    val text = "${movieItem.voteAverage.roundTo(1)}"
    val cornerRadius = 4.dp
    val imageUrl = Constants.IMAGE_URL.plus(movieItem.posterPath)

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        MovieImage(
            imageUrl = imageUrl,
            cornerRadius = cornerRadius,
            contentDescription = null
        )

        MovieRatingRow(title = movieItem.title, rating = text, 70.dp)
    }
}
