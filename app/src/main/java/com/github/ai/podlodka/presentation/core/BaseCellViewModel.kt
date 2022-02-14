package com.github.ai.podlodka.presentation.core

import androidx.lifecycle.ViewModel

abstract class BaseCellViewModel(
    open val model: BaseCellModel
) : ViewModel()