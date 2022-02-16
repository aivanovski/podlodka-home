package com.github.ai.podlodka.presentation.home.cells

import com.github.ai.podlodka.R
import com.github.ai.podlodka.data.model.HomePageEntity
import com.github.ai.podlodka.domain.DateFormatProvider
import com.github.ai.podlodka.domain.ResourceProvider
import com.github.ai.podlodka.presentation.core.BaseCellModel
import com.github.ai.podlodka.presentation.home.cells.model.ButtonCellModel
import com.github.ai.podlodka.presentation.home.cells.model.CommentCellModel
import com.github.ai.podlodka.presentation.home.cells.model.DescriptionCellModel
import com.github.ai.podlodka.presentation.home.cells.model.DividerCellModel
import com.github.ai.podlodka.presentation.home.cells.model.ImagesCellModel
import com.github.ai.podlodka.presentation.home.cells.model.RatingCellModel
import com.github.ai.podlodka.presentation.home.cells.model.SectionTitleCellModel
import com.github.ai.podlodka.presentation.home.cells.model.TagsCellModel
import com.github.ai.podlodka.presentation.home.cells.model.TitleWithImageCellModel
import com.github.ai.podlodka.presentation.home.cells.ui.CommentCell
import com.github.ai.podlodka.presentation.home.cells.viewmodel.ButtonCellViewModel
import com.github.ai.podlodka.presentation.theme.primaryTitleColor
import java.util.Date

class HomeCellModelFactory(
    private val resourceProvider: ResourceProvider,
    private val dateFormatProvider: DateFormatProvider
) {

    fun createCellModel(entity: HomePageEntity): List<BaseCellModel> {
        val models = mutableListOf(
            TitleWithImageCellModel(
                title = entity.title,
                ratingsCount = formatRatingsCount(entity.reviewCount),
                imageUrl = entity.imageUrl,
                iconUrl = entity.iconUrl
            ),
            TagsCellModel(
                tags = entity.tags
            ),
            DescriptionCellModel(
                description = entity.description
            ),
            ImagesCellModel(
                imageUrls = entity.videos
            ),
            SectionTitleCellModel(
                title = resourceProvider.getString(R.string.review_and_ratings)
            ),
            RatingCellModel(
                rating = "4.9",
                ratingsCount = formatRatingsCount(entity.reviewCount)
            )
        )

        for ((idx, comment) in entity.comments.withIndex()) {
            models.add(
                CommentCellModel(
                    id = idx.toString(),
                    username = comment.username,
                    date = formatTimestamp(comment.timestamp),
                    text = comment.text,
                    userImageUrl = comment.userImageUrl
                )
            )
            if (idx != entity.comments.size - 1) {
                models.add(
                    DividerCellModel()
                )
            }
        }

        models.add(
            ButtonCellModel(
                title = resourceProvider.getString(R.string.install)
            )
        )

        return models
    }

    private fun formatRatingsCount(count: Int): String {
        return when {
            count >= MILLION -> "${(count / MILLION)} M"
            count >= THOUSAND -> "${(count / THOUSAND)} K"
            else -> count.toString()
        }
    }

    private fun formatTimestamp(timestamp: Long): String {
        return dateFormatProvider.getDateFormat().format(Date(timestamp))
    }

    companion object {
        private const val MILLION = 1_000_000
        private const val THOUSAND = 1_000
    }
}