package com.github.ai.podlodka.presentation.core

import androidx.compose.runtime.Composable
import com.github.ai.podlodka.presentation.home.cells.model.CommentCellModel
import com.github.ai.podlodka.presentation.home.cells.ui.ButtonCell
import com.github.ai.podlodka.presentation.home.cells.ui.CommentCell
import com.github.ai.podlodka.presentation.home.cells.ui.DescriptionCell
import com.github.ai.podlodka.presentation.home.cells.ui.DividerCell
import com.github.ai.podlodka.presentation.home.cells.ui.ImagesCell
import com.github.ai.podlodka.presentation.home.cells.ui.RatingCell
import com.github.ai.podlodka.presentation.home.cells.ui.SectionTitleCell
import com.github.ai.podlodka.presentation.home.cells.ui.TagsCell
import com.github.ai.podlodka.presentation.home.cells.ui.TitleWithImageCell
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

class CellFactory {

    @Composable
    fun createCell(viewModel: BaseCellViewModel) {
        when (viewModel) {
            is TitleWithImageCellViewModel -> TitleWithImageCell(viewModel)
            is TagsCellViewModel -> TagsCell(viewModel)
            is DescriptionCellViewModel -> DescriptionCell(viewModel)
            is ImagesCellViewModel -> ImagesCell(viewModel)
            is SectionTitleCellViewModel -> SectionTitleCell(viewModel)
            is RatingCellViewModel -> RatingCell(viewModel)
            is CommentCellViewModel -> CommentCell(viewModel)
            is DividerCellViewModel -> DividerCell(viewModel)
            is ButtonCellViewModel -> ButtonCell(viewModel)
            else -> throw IllegalArgumentException("Unknown cell type: ${viewModel::class.jvmName}")
        }
    }
}