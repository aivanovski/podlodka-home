package com.github.ai.podlodka.presentation.core.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

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