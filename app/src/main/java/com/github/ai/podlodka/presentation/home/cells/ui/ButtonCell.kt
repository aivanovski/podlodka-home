package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ai.podlodka.presentation.home.cells.model.ButtonCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.ButtonCellViewModel
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground

@Composable
fun ButtonCell(viewModel: ButtonCellViewModel) {
    Button(
        onClick = { viewModel.onClicked() },
        modifier = Modifier
            .padding(start = 24.dp, end = 24.dp, top = 16.dp, bottom = 40.dp)
            .height(64.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = viewModel.model.title,
            fontSize = 20.sp,
            color = Color(0xFF050B18)
        )
    }
}

@Composable
@Preview
fun ButtonCellPreview() {
    val model = ButtonCellModel(
        title = "Install"
    )

    PreviewWithBackground {
        ButtonCell(viewModel = ButtonCellViewModel(model))
    }
}