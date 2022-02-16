package com.github.ai.podlodka.domain.home

import com.github.ai.podlodka.data.model.HomePageEntity

interface HomeInteractor {

    fun getHomePageEntity(): HomePageEntity
}