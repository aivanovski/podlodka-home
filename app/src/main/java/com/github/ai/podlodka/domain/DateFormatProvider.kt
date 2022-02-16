package com.github.ai.podlodka.domain

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Locale

class DateFormatProvider {

    fun getDateFormat(): DateFormat = DATE_FORMAT

    companion object {
        val DATE_FORMAT = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
    }
}