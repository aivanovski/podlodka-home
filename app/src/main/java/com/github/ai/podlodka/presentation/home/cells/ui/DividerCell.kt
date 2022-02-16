package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ai.podlodka.presentation.home.cells.model.DividerCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.DividerCellViewModel
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground

@Composable
fun DividerCell(viewModel: DividerCellViewModel) {
    Divider(
        thickness = 1.dp,
        color = Color(0xFF1A1F29),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 38.dp),
    )
}

@Composable
@Preview
fun DividerCellPreview() {
    PreviewWithBackground {
        DividerCell(
            viewModel = DividerCellViewModel(
                model = DividerCellModel()
            )
        )
    }
}
