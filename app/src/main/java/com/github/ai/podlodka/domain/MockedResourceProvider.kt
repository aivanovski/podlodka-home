package com.github.ai.podlodka.domain

import com.github.ai.podlodka.R

class MockedResourceProvider : ResourceProvider {

    override fun getString(resId: Int): String =
        when (resId) {
            R.string.review_and_ratings -> "Review & Ratings"
            R.string.install -> "Install"
            else -> ""
        }

    override fun getString(resId: Int, vararg formatArgs: Any): String = ""
}