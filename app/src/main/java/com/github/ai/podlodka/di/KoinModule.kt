package com.github.ai.podlodka.di

import com.github.ai.podlodka.domain.DateFormatProvider
import com.github.ai.podlodka.domain.ResourceProvider
import com.github.ai.podlodka.domain.home.HomeInteractor
import com.github.ai.podlodka.domain.home.MockedHomeInteractor
import com.github.ai.podlodka.presentation.core.CellViewModelFactory
import com.github.ai.podlodka.presentation.home.HomeViewModel
import com.github.ai.podlodka.presentation.home.cells.HomeCellModelFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModule {

    val appModule = module {
        single { ResourceProvider(get()) }
        single { DateFormatProvider() }

        // factories
        single { CellViewModelFactory() }

        // Home screen
        single { MockedHomeInteractor() as HomeInteractor }
        single { HomeCellModelFactory(get(), get()) }
        viewModel { HomeViewModel(get(), get(), get()) }
    }
}