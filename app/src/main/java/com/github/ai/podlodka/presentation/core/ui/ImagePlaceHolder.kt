package com.github.ai.podlodka.presentation.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ai.podlodka.presentation.theme.AppTheme
import com.github.ai.podlodka.presentation.theme.placeHolderColor

@Composable
fun ImagePlaceHolder(
    modifier: Modifier = Modifier.fillMaxSize().background(placeHolderColor)
) {
    Box(
        modifier = modifier
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
@Preview
fun ImagePlaceHolderPreview() {
    AppTheme {
        Box(
            modifier = Modifier.size(240.dp, 135.dp)
        ) {
            ImagePlaceHolder()
        }
    }
}