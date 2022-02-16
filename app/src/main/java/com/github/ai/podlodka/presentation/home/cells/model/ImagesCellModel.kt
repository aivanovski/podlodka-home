package com.github.ai.podlodka.presentation.home.cells.model

import com.github.ai.podlodka.presentation.core.BaseCellModel

data class ImagesCellModel(
    val imageUrls: List<String>
) : BaseCellModel()