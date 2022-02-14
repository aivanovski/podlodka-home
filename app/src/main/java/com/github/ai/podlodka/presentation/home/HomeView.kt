package com.github.ai.podlodka.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.ai.podlodka.presentation.theme.AppTheme
import com.github.ai.podlodka.presentation.theme.backgroundColor

@Composable
fun HomeScreen() {
    Box(modifier = Modifier.fillMaxSize())
}

@Preview
@Composable
fun HomeScreenPreview() {
    AppTheme {
        Box(modifier = Modifier.background(backgroundColor)) {
            HomeScreen()
        }
    }
}