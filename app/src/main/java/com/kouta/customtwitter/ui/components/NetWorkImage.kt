package com.kouta.customtwitter.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberImagePainter
import com.kouta.customtwitter.R

@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Fit
) {
    Image(
        modifier = modifier,
        painter = rememberImagePainter(
            data = url,
            builder = {
                placeholder(R.drawable.ic_launcher_background)
            }
        ),
        contentDescription = contentDescription,
        contentScale = contentScale
    )
}

@Preview
@Composable
private fun NetworkImagePreview() {
    NetworkImage(
        modifier = Modifier.fillMaxSize(),
        url = "",
        contentScale = ContentScale.Crop
    )
}