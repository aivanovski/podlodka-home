package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.github.ai.podlodka.R
import com.github.ai.podlodka.domain.home.MockedHomeInteractor.Companion.MOCKED_ENTITY
import com.github.ai.podlodka.presentation.home.cells.model.ImagesCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.ImagesCellViewModel
import com.github.ai.podlodka.presentation.core.theme.SmallPreviewWithBackground
import com.github.ai.podlodka.presentation.core.ui.ButtonWithIcon
import com.github.ai.podlodka.presentation.core.ui.ImageWithPlaceholder

@Composable
fun ImagesCell(viewModel: ImagesCellViewModel) {
    LazyRow(
        modifier = Modifier
            .padding(top = 12.dp, bottom = 12.dp)
    ) {
        val urls = viewModel.model.imageUrls
        items(urls) { imageUrl ->
            val idx = urls.indexOf(imageUrl)

            val startPadding = if (idx == 0) 24.dp else 16.dp
            val endPadding = if (idx == urls.size - 1) 24.dp else 0.dp

            Box(
                modifier = Modifier
                    .padding(start = startPadding, end = endPadding)
                    .size(width = 240.dp, height = 135.dp)
                    .clip(shape = RoundedCornerShape(14.dp))
            ) {
                val painter = rememberImagePainter(
                    data = imageUrl
                )

                ImageWithPlaceholder(
                    painter = painter
                )

                if (painter.state is ImagePainter.State.Success) {
                    ButtonWithIcon(
                        iconResId = R.drawable.ic_play_24dp,
                        iconSize = 18.dp,
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun ImagesCellPreview() {
    val model = ImagesCellModel(
        imageUrls = MOCKED_ENTITY.videos
    )

    SmallPreviewWithBackground {
        ImagesCell(viewModel = ImagesCellViewModel(model))
    }
}