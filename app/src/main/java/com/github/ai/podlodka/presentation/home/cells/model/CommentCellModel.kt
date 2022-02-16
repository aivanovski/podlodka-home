package com.github.ai.podlodka.presentation.home.cells.model

import com.github.ai.podlodka.presentation.core.BaseCellModel

data class CommentCellModel(
    override val id: String,
    val username: String,
    val date: String,
    val text: String,
    val userImageUrl: String
) : BaseCellModel(id)