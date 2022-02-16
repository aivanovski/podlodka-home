package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ai.podlodka.presentation.home.cells.model.TagsCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.TagsCellViewModel
import com.github.ai.podlodka.presentation.core.theme.PreviewWithBackground

@Composable
fun TagsCell(viewModel: TagsCellViewModel) {
    LazyRow(
        modifier = Modifier
            .padding(start = 14.dp, top = 12.dp, bottom = 12.dp)
            .fillMaxWidth()
    ) {
        items(viewModel.model.tags) { tag ->
            Box(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Text(
                    text = tag,
                    fontSize = 10.sp,
                    color = Color(0xFF41A0E7),
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(Color(0x3D44A9F4))
                        .padding(horizontal = 10.dp, vertical = 5.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun TagsCellPreview() {
    val model = TagsCellModel(
        listOf(
            "MOBA",
            "MULTIPLAYER",
            "STRATEGY"
        )
    )

    PreviewWithBackground {
        TagsCell(
            viewModel = TagsCellViewModel(model)
        )
    }
}