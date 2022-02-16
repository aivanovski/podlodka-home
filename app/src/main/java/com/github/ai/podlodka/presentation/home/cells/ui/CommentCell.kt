package com.github.ai.podlodka.presentation.home.cells.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.rememberImagePainter
import com.github.ai.podlodka.domain.home.MockedHomeInteractor.Companion.MOCKED_ENTITY
import com.github.ai.podlodka.presentation.core.ui.ImagePlaceHolder
import com.github.ai.podlodka.presentation.core.ui.shouldShowPlaceholder
import com.github.ai.podlodka.presentation.home.cells.model.CommentCellModel
import com.github.ai.podlodka.presentation.home.cells.viewmodel.CommentCellViewModel
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground
import com.github.ai.podlodka.presentation.theme.primaryTitleColor

@Composable
fun CommentCell(viewModel: CommentCellViewModel) {
    ConstraintLayout(
        modifier = Modifier.fillMaxWidth()
    ) {
        val (name, date, icon, text) = createRefs()

        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(shape = CircleShape)
                .constrainAs(icon) {
                    start.linkTo(parent.start, margin = 24.dp)
                    top.linkTo(parent.top, margin = 24.dp)
                }
        ) {
            val painter = rememberImagePainter(
                data = viewModel.model.userImageUrl
            )

            Image(
                painter = painter,
                contentDescription = "user_icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            if (painter.state.shouldShowPlaceholder()) {
                ImagePlaceHolder()
            }
        }

        Text(
            text = viewModel.model.username,
            fontSize = 16.sp,
            color = primaryTitleColor,
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(icon.top)
                    start.linkTo(icon.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    bottom.linkTo(date.top)
                    width = Dimension.fillToConstraints
                }
        )

        Text(
            text = viewModel.model.date,
            fontSize = 12.sp,
            color = Color(0x66FFFFFF),
            modifier = Modifier
                .constrainAs(date) {
                    top.linkTo(name.bottom)
                    start.linkTo(icon.end, margin = 16.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    bottom.linkTo(icon.bottom)
                    width = Dimension.fillToConstraints
                }
        )

        Text(
            text = viewModel.model.text,
            fontSize = 12.sp,
            color = Color(0xFFA8ADB7),
            modifier = Modifier
                .constrainAs(text) {
                    top.linkTo(icon.bottom, margin = 18.dp)
                    start.linkTo(parent.start, margin = 24.dp)
                    end.linkTo(parent.end, margin = 24.dp)
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    width = Dimension.fillToConstraints
                }
        )
    }
}

@Composable
@Preview
fun CommentCellPreview() {
    val comment = MOCKED_ENTITY.comments.first()

    val model = CommentCellModel(
        id = "1",
        username = comment.username,
        date = "February 14, 2022",
        text = comment.text,
        userImageUrl = comment.userImageUrl
    )

    PreviewWithBackground {
        CommentCell(
            viewModel = CommentCellViewModel(model)
        )
    }
}