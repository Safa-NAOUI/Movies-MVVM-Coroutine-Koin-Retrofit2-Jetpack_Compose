package com.example.moviesapp.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.moviesapp.R

/**
 * Created by Safa NAOUI on 28,April,2024
 */

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun MovieImage(
    imageUrl: String,
    cornerRadius: Dp,
    modifier: Modifier = Modifier,
    contentDescription: String? = null
) {
    GlideImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
            .height(350.dp)
            .fillMaxWidth()
            .border(
                BorderStroke(width = 1.dp, color = Color.LightGray), // Optional border
                shape = RoundedCornerShape(
                    topStart = cornerRadius,
                    topEnd = cornerRadius,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            ),
        contentScale = ContentScale.Crop,
        loading = placeholder(R.drawable.ic_loading),
        failure = placeholder(R.drawable.ic_failure),
    )
}