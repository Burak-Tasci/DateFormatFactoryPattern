package com.example.dateformatfactorypattern.dateformatter

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

abstract class DateFormatter {

    abstract val type: DateFormatType

    private val formatter: SimpleDateFormat by lazy {
        SimpleDateFormat(type.dateScheme, Locale.getDefault())
    }

    @Throws(ParseException::class)
    fun parse(source: String): Date {
        val date = formatter.parse(source) ?: throw ParseException(
            "$TAG failed to parse $source to format: ${type.dateScheme}",
            0
        )
        return date
    }

    fun format(date: Date): String {
        return formatter.format(date)
    }

    companion object {
        private val TAG = this::class.java.simpleName
    }
}