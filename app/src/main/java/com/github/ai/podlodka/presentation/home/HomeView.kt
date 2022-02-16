package com.github.ai.podlodka.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.github.ai.podlodka.domain.DateFormatProvider
import com.github.ai.podlodka.domain.MockedResourceProvider
import com.github.ai.podlodka.domain.home.MockedHomeInteractor.Companion.MOCKED_ENTITY
import com.github.ai.podlodka.presentation.core.BaseCellViewModel
import com.github.ai.podlodka.presentation.core.CellFactory
import com.github.ai.podlodka.presentation.core.CellViewModelFactory
import com.github.ai.podlodka.presentation.home.cells.HomeCellModelFactory
import com.github.ai.podlodka.presentation.theme.PreviewWithBackground

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
    val factory = CellFactory()

    LazyColumn {
        items(cells) {
            factory.createCell(it)
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