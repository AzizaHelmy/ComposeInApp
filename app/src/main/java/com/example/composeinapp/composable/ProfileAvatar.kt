package com.example.composeinapp.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

/**
 * Created by Aziza Helmy on 7/1/2023.
 */
@Composable
fun ProfileAvatar(painter: Painter, size: Int = 128, modifier: Modifier = Modifier) {
    Image(
        painter = painter,
        contentDescription = "This is :tc:",
        modifier = modifier
            .clip(shape = RoundedCornerShape(100.dp))
            .size(size.dp),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center


    )
}