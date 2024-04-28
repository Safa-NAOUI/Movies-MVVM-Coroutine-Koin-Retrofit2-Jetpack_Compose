package com.example.moviesapp.ui.component.rating

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Created by Safa NAOUI on 28,April,2024
 */
@Composable
fun MovieRatingRow(title: String, rating: String,heightValue: Dp) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(heightValue),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(
                    top = 5.dp,
                    bottom = 5.dp,
                    start = 8.dp,
                    end = 2.dp
                )
                .weight(1f)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.weight(0.1f))
        StarRatingIndicator(
            rating,
            backgroundColor = Color.Gray,
            textColor = Color.White)
    }
}
