package com.github.ai.podlodka.presentation.core

import com.github.ai.podlodka.presentation.home.cells.model.ButtonCellModel
import com.github.ai.podlodka.presentation.home.cells.model.CommentCellModel
import com.github.ai.podlodka.presentation.home.cells.model.DescriptionCellModel
import com.github.ai.podlodka.presentation.home.cells.model.DividerCellModel
import com.github.ai.podlodka.presentation.home.cells.model.ImagesCellModel
import com.github.ai.podlodka.presentation.home.cells.model.RatingCellModel
import com.github.ai.podlodka.presentation.home.cells.model.SectionTitleCellModel
import com.github.ai.podlodka.presentation.home.cells.model.TagsCellModel
import com.github.ai.podlodka.presentation.home.cells.model.TitleWithImageCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.ButtonCellViewModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.CommentCellViewModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.DescriptionCellViewModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.DividerCellViewModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.ImagesCellViewModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.RatingCellViewModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.SectionTitleCellViewModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.TagsCellViewModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.TitleWithImageCellViewModel
import kotlin.reflect.jvm.jvmName

class CellViewModelFactory {

    fun createCellViewModels(models: List<BaseCellModel>): List<BaseCellViewModel> {
        return models.map { createCellViewModel(it) }
    }

    private fun createCellViewModel(model: BaseCellModel): BaseCellViewModel {
        return when (model) {
            is DescriptionCellModel -> DescriptionCellViewModel(model)
            is ImagesCellModel -> ImagesCellViewModel(model)
            is SectionTitleCellModel -> SectionTitleCellViewModel(model)
            is TagsCellModel -> TagsCellViewModel(model)
            is TitleWithImageCellModel -> TitleWithImageCellViewModel(model)
            is RatingCellModel -> RatingCellViewModel(model)
            is CommentCellModel -> CommentCellViewModel(model)
            is DividerCellModel -> DividerCellViewModel(model)
            is ButtonCellModel -> ButtonCellViewModel(model)
            else -> throw IllegalArgumentException("Unknown model type: ${model::class.jvmName}")
        }
    }
}