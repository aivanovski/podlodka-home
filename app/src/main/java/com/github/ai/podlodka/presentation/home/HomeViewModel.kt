package com.github.ai.podlodka.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ai.podlodka.domain.home.HomeInteractor
import com.github.ai.podlodka.presentation.core.BaseCellViewModel
import com.github.ai.podlodka.presentation.core.CellViewModelFactory
import com.github.ai.podlodka.presentation.home.cells.HomeCellModelFactory

class HomeViewModel(
    private val interactor: HomeInteractor,
    private val modelFactory: HomeCellModelFactory,
    private val viewModelFactory: CellViewModelFactory
) : ViewModel() {

    private val _cellViewModels = MutableLiveData<List<BaseCellViewModel>>()
    val cellViewModels: LiveData<List<BaseCellViewModel>> = _cellViewModels

    init {
        loadAndDisplayCells()
    }

    private fun loadAndDisplayCells() {
        val models = modelFactory.createCellModel(interactor.getHomePageEntity())

        _cellViewModels.value = viewModelFactory.createCellViewModels(
            models = models
        )
    }
}