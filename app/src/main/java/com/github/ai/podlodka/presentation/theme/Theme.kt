package com.github.ai.podlodka.presentation.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = AppColors,
        typography = AppTypography,
        content = content
    )
}

@Composable
fun PreviewWithBackground(content: @Composable () -> Unit) {
    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor),
        ) {
            content.invoke()
        }
    }
}

@Composable
fun SmallPreviewWithBackground(content: @Composable () -> Unit) {
    AppTheme {
        Box(
            modifier = Modifier.background(backgroundColor),
        ) {
            content.invoke()
        }
    }
}