package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.github.ai.podlodka.domain.home.MockedHomeInteractor.Companion.MOCKED_ENTITY
import com.github.ai.podlodka.presentation.core.ui.ImagePlaceHolder
import com.github.ai.podlodka.presentation.core.ui.RatingBar
import com.github.ai.podlodka.presentation.core.ui.shouldShowPlaceholder
import com.github.ai.podlodka.presentation.home.cells.model.TitleWithImageCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.TitleWithImageCellViewModel
import com.github.ai.podlodka.presentation.core.theme.AppTheme
import com.github.ai.podlodka.presentation.core.theme.backgroundColor
import com.github.ai.podlodka.presentation.core.theme.hintColor
import com.github.ai.podlodka.presentation.core.theme.placeHolderColor

@Composable
fun TitleWithImageCell(viewModel: TitleWithImageCellViewModel) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        val (image, icon, title, titleBackground, stars, ratingsText) = createRefs()

        Box(
            modifier = Modifier
                .height(300.dp)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            val painter = rememberImagePainter(
                data = viewModel.model.imageUrl
            )

            Image(
                painter = painter,
                contentDescription = "landing",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            if (painter.state.shouldShowPlaceholder()) {
                ImagePlaceHolder()
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)
                .background(color = backgroundColor)
                .constrainAs(titleBackground) {
                    bottom.linkTo(image.bottom)
                }
        )

        Card(
            elevation = 0.dp,
            backgroundColor = Color.Black,
            border = BorderStroke(width = 1.dp, color = Color(0xFF1f2430)),
            modifier = Modifier
                .size(84.dp)
                .constrainAs(icon) {
                    bottom.linkTo(image.bottom)
                    start.linkTo(parent.start, margin = 24.dp)
                }
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                val painter = rememberImagePainter(
                    data = viewModel.model.iconUrl
                )

                Image(
                    painter = painter,
                    contentDescription = "icon",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(54.dp)
                        .align(Alignment.Center)
                )

                if (painter.state.shouldShowPlaceholder()) {
                    ImagePlaceHolder(
                        modifier = Modifier
                            .size(width = 54.dp, height = 54.dp)
                            .background(placeHolderColor)
                            .align(Alignment.Center)
                    )
                }
            }
        }

        Text(
            text = viewModel.model.title,
            fontSize = 20.sp,
            color = Color(0xFFFFFFFF),
            modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(icon.end, margin = 14.dp)
                    bottom.linkTo(stars.top, margin = 6.dp)
                }
        )

        RatingBar(
            rating = 4.9f,
            modifier = Modifier
                .constrainAs(stars) {
                    start.linkTo(title.start)
                    bottom.linkTo(image.bottom, margin = 12.dp)
                }
        )

        Text(
            text = viewModel.model.ratingsCount,
            fontSize = 12.sp,
            color = hintColor,
            modifier = Modifier
                .constrainAs(ratingsText) {
                    start.linkTo(stars.end, margin = 10.dp)
                    bottom.linkTo(stars.bottom)
                    top.linkTo(stars.top)
                }
        )
    }
}

@Preview
@Composable
fun TitleWithImageCellPreview() {
    val model = TitleWithImageCellModel(
        title = MOCKED_ENTITY.title,
        ratingsCount = "70 M",
        rating = MOCKED_ENTITY.rating,
        imageUrl = MOCKED_ENTITY.imageUrl,
        iconUrl = MOCKED_ENTITY.iconUrl
    )

    AppTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor)
        ) {
            TitleWithImageCell(TitleWithImageCellViewModel(model))
        }
    }
}
