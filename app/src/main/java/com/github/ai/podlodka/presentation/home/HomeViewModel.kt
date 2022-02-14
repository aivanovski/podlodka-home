package com.github.ai.podlodka.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ai.podlodka.domain.home.HomeInteractor
import com.github.ai.podlodka.presentation.core.BaseCellViewModel

class HomeViewModel(
    private val interactor: HomeInteractor
) : ViewModel() {

    private val _cellViewModels = MutableLiveData<List<BaseCellViewModel>>()
    val cellViewModels: LiveData<List<BaseCellViewModel>> = _cellViewModels
}