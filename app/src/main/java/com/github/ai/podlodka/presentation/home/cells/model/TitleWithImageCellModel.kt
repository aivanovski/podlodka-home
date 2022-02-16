package com.github.ai.podlodka.presentation.home.cells.model

import com.github.ai.podlodka.presentation.core.BaseCellModel

data class TitleWithImageCellModel(
    val title: String,
    val ratingsCount: String,
    val imageUrl: String,
    val iconUrl: String
) : BaseCellModel()