package com.example.moviesapp.ui.component.rating

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.cos
import kotlin.math.sin

/**
 * Created by Safa NAOUI on 28,April,2024
 */

@Composable
fun StarRatingIndicator(
    rating: String,
    backgroundColor: Color = Color.Gray,
    textColor: Color = Color.White
) {
    Box(
        contentAlignment = Alignment.BottomEnd
    ) {
        Canvas(
            modifier = Modifier
                .size(45.dp)
                .align(Alignment.BottomEnd)
        ) {
            drawStar(
                center = Offset(size.width / 2, size.height / 2),
                outerRadius = size.width / 2,
                innerRadius = size.width / 4,
                points = 5,
                color = backgroundColor
            )
            val textPaint = Paint().asFrameworkPaint().apply {
                color = textColor.toArgb()
                textAlign = android.graphics.Paint.Align.CENTER
                textSize = 10.sp.toPx()
            }

            val textBounds = android.graphics.Rect()
            textPaint.getTextBounds(rating, 0, rating.length, textBounds)

            val textOffsetY =
                size.height / 2 + textBounds.height() / 2 - textBounds.bottom // Adjust vertical position for centering
            drawContext.canvas.nativeCanvas.drawText(
                rating,
                size.width / 2,
                textOffsetY,
                textPaint
            )
        }
    }
}

fun DrawScope.drawStar(
    center: Offset,
    outerRadius: Float,
    innerRadius: Float,
    points: Int,
    color: Color
) {
    val path = Path()

    for (i in 0 until points * 2) {
        val angle = Math.PI * i / points
        val radius = if (i % 2 == 0) outerRadius else innerRadius
        val x = center.x + radius.toFloat() * cos(angle).toFloat()
        val y = center.y + radius.toFloat() * sin(angle).toFloat()
        if (i == 0) {
            path.moveTo(x, y)
        } else {
            path.lineTo(x, y)
        }
    }

    path.close()

    drawPath(
        path = path,
        color = color
    )
}
