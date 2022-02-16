package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.ai.podlodka.R
import com.github.ai.podlodka.presentation.core.ui.RatingBar
import com.github.ai.podlodka.presentation.home.cells.model.RatingCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.RatingCellViewModel
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground
import com.github.ai.podlodka.presentation.theme.primaryTitleColor

@Composable
fun RatingCell(viewModel: RatingCellViewModel) {
    Row {
        Text(
            text = viewModel.model.rating.toString(),
            fontSize = 56.sp,
            color = primaryTitleColor,
            modifier = Modifier
                .padding(start = 24.dp)
        )

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .align(Alignment.CenterVertically)
        ) {
            RatingBar(rating = 4.9f)
            Text(
                text = stringResource(R.string.reviews_with_count, viewModel.model.ratingsCount)
            )
        }
    }
}

@Composable
@Preview
fun RatingCellPreview() {
    val model = RatingCellModel(
        rating = 4.9f,
        ratingsCount = "70M"
    )

    PreviewWithBackground {
        RatingCell(
            viewModel = RatingCellViewModel(model)
        )
    }
}
