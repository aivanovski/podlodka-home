package com.github.ai.podlodka.presentation.core.ui

import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter

@ExperimentalCoilApi
fun ImagePainter.State.shouldShowPlaceholder(): Boolean {
    return this is ImagePainter.State.Error || this is ImagePainter.State.Loading
}