package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ai.podlodka.domain.home.MockedHomeInteractor.Companion.MOCKED_ENTITY
import com.github.ai.podlodka.presentation.home.cells.model.DescriptionCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.DescriptionCellViewModel
import com.github.ai.podlodka.presentation.core.theme.PreviewWithBackground
import com.github.ai.podlodka.presentation.core.theme.primaryDescriptionColor

@Composable
fun DescriptionCell(viewModel: DescriptionCellViewModel) {
    Text(
        text = viewModel.model.description,
        fontSize = 12.sp,
        color = primaryDescriptionColor,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp, top = 12.dp, bottom = 12.dp)
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