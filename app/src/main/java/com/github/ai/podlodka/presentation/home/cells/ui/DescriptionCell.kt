package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.github.ai.podlodka.domain.home.MockedHomeInteractor.Companion.MOCKED_ENTITY
import com.github.ai.podlodka.presentation.home.cells.model.DescriptionCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.DescriptionCellViewModel
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground
import com.github.ai.podlodka.presentation.theme.primaryDescriptionColor

@Composable
fun DescriptionCell(viewModel: DescriptionCellViewModel) {
    Text(
        text = viewModel.model.description,
        fontSize = 19.sp,
        color = primaryDescriptionColor,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
@Preview
fun DescriptionCellPreview() {
    val model = DescriptionCellModel(
        description = MOCKED_ENTITY.description
    )

    PreviewWithBackground {
        DescriptionCell(
            viewModel = DescriptionCellViewModel(model)
        )
    }
}