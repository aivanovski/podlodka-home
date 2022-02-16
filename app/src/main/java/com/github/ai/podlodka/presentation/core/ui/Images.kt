package com.github.ai.podlodka.presentation.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.github.ai.podlodka.presentation.core.theme.SmallPreviewWithBackground

@Composable
fun ImageWithPlaceholder(painter: ImagePainter) {
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    if (painter.state is ImagePainter.State.Error || painter.state is ImagePainter.State.Loading) {
        Placeholder()
    }
}

@Composable
fun Placeholder() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
@Preview
fun ImageWithPlaceHolderPreview() {
    SmallPreviewWithBackground {
        ImageWithPlaceholder(painter = rememberImagePainter(""))
    }
}