package com.github.ai.podlodka.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.ai.podlodka.R
import com.github.ai.podlodka.domain.DateFormatProvider
import com.github.ai.podlodka.domain.MockedResourceProvider
import com.github.ai.podlodka.domain.home.MockedHomeInteractor.Companion.MOCKED_ENTITY
import com.github.ai.podlodka.presentation.core.BaseCellViewModel
import com.github.ai.podlodka.presentation.core.CellFactory
import com.github.ai.podlodka.presentation.core.CellViewModelFactory
import com.github.ai.podlodka.presentation.home.cells.HomeCellModelFactory
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground
import com.github.ai.podlodka.presentation.theme.primaryColor

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val cells by viewModel.cellViewModels.observeAsState(emptyList())

    Box(modifier = Modifier.fillMaxSize()) {
        HomeScreenLayout(
            cells = cells
        )
    }
}

@Composable
private fun HomeScreenLayout(
    cells: List<BaseCellViewModel>
) {
    val cellFactory = CellFactory()

    Box {
        LazyColumn {
            items(cells) {
                cellFactory.createCell(it)
            }
        }

        Button(
            shape = CircleShape,
            colors = buttonColors(backgroundColor = primaryColor),
            onClick = {},
            modifier = Modifier
                .padding(start = 24.dp, top = 70.dp)
                .size(56.dp)
                .align(Alignment.TopStart)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back_24dp),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Black)
            )
        }

        Button(
            shape = CircleShape,
            colors = buttonColors(backgroundColor = primaryColor),
            onClick = {},
            modifier = Modifier
                .padding(end = 24.dp, top = 70.dp)
                .size(56.dp)
                .align(Alignment.TopEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_more_horiz_24dp),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Color.Black)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val models = HomeCellModelFactory(
        MockedResourceProvider(),
        DateFormatProvider()
    ).createCellModel(
        MOCKED_ENTITY
    )

    PreviewWithBackground {
        HomeScreenLayout(
            cells = CellViewModelFactory().createCellViewModels(models)
        )
    }
}