package com.github.ai.podlodka.presentation.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ai.podlodka.R
import com.github.ai.podlodka.presentation.core.theme.SmallPreviewWithBackground

@Composable
fun RatingBar(rating: Float, modifier: Modifier = Modifier) {
    if (rating > 5f) {
        throw IllegalArgumentException()
    }

    val filledStars = rating.toInt()
    val halfStars = if ((rating - filledStars) >= 0.1f) 1 else 0
    val emptyStars = 5 - filledStars - halfStars

    Row(modifier) {
        repeat(filledStars) { idx ->
            if (idx != 0) {
                StarIcon(
                    iconId = R.drawable.ic_star_filled,
                    modifier = Modifier.padding(start = 4.dp)
                )
            } else {
                StarIcon(
                    iconId = R.drawable.ic_star_filled
                )
            }
        }

        repeat(halfStars) { idx ->
            if (idx + filledStars != 0) {
                StarIcon(
                    iconId = R.drawable.ic_star_half,
                    modifier = Modifier.padding(start = 4.dp)
                )
            } else {
                StarIcon(
                    iconId = R.drawable.ic_star_half
                )
            }
        }

        repeat(emptyStars) { idx ->
            if (idx + (filledStars + halfStars) != 0) {
                StarIcon(
                    iconId = R.drawable.ic_star_empty,
                    modifier = Modifier.padding(start = 4.dp)
                )
            } else {
                StarIcon(
                    iconId = R.drawable.ic_star_empty
                )
            }
        }
    }
}

@Composable
private fun StarIcon(
    @DrawableRes iconId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(iconId),
        contentDescription = "star icon",
        modifier = modifier.size(12.dp)
    )
}

@Composable
private fun RatingBarPreview(rating: Float) {
    SmallPreviewWithBackground {
        RatingBar(rating)
    }
}

@Composable
@Preview
fun PreviewWithEmptyStarAtTheEnd() = RatingBarPreview(rating = 4.9f)

@Composable
@Preview
fun PreviewWithOneStar() = RatingBarPreview(rating = 1f)

@Composable
@Preview
fun PreviewWithTowStars() = RatingBarPreview(rating = 2f)

@Composable
@Preview
fun PreviewWithThreeStars() = RatingBarPreview(rating = 3f)

@Composable
@Preview
fun PreviewWithFourStars() = RatingBarPreview(rating = 4f)

@Composable
@Preview
fun PreviewWithFiveStars() = RatingBarPreview(rating = 5f)