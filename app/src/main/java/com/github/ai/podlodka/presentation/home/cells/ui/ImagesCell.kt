package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.github.ai.podlodka.domain.home.MockedHomeInteractor.Companion.MOCKED_ENTITY
import com.github.ai.podlodka.presentation.home.cells.model.ImagesCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.ImagesCellViewModel
import com.github.ai.podlodka.presentation.core.ui.ImagePlaceHolder
import com.github.ai.podlodka.presentation.core.ui.shouldShowPlaceholder
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground

@Composable
fun ImagesCell(viewModel: ImagesCellViewModel) {
    LazyRow {
        items(viewModel.model.imageUrls) { imageUrl ->
            Box(
                modifier = Modifier
                    .size(width = 240.dp, height = 135.dp)
                    .padding(start = 15.dp)
            ) {
                val painter = rememberImagePainter(
                    data = imageUrl
                )

                Image(
                    painter = painter,
                    contentDescription = "video",
                    contentScale = ContentScale.Crop
                )

                if (painter.state.shouldShowPlaceholder()) {
                    ImagePlaceHolder()
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

    PreviewWithBackground {
        ImagesCell(viewModel = ImagesCellViewModel(model))
    }
}