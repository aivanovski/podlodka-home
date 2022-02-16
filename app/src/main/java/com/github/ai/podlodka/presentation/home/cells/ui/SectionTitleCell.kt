package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ai.podlodka.presentation.home.cells.model.SectionTitleCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.SectionTitleCellViewModel
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground
import com.github.ai.podlodka.presentation.theme.primaryTitleColor

@Composable
fun SectionTitleCell(viewModel: SectionTitleCellViewModel) {
    Text(
        text = viewModel.model.title,
        fontSize = 19.sp,
        color = primaryTitleColor,
        modifier = Modifier.padding(start = 24.dp)
    )
}

@Composable
@Preview
fun SectionTitleCellPreview() {
    val model = SectionTitleCellModel(
        title = "Review & Ratings"
    )

    PreviewWithBackground {
        SectionTitleCell(
            viewModel = SectionTitleCellViewModel(
                model = model
            )
        )
    }
}