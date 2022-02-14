package com.github.ai.podlodka.di

import com.github.ai.podlodka.domain.ResourceProvider
import com.github.ai.podlodka.domain.home.HomeInteractor
import com.github.ai.podlodka.domain.home.MockedHomeInteractor
import com.github.ai.podlodka.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModule {

    val appModule = module {
        single { ResourceProvider(get()) }
        single { MockedHomeInteractor() as HomeInteractor }
        viewModel { HomeViewModel(get()) }
    }
}