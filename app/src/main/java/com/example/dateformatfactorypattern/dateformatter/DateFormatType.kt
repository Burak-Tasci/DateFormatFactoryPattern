package com.example.dateformatfactorypattern.dateformatter

enum class DateFormatType(val dateScheme: String) {
    BASIC("dd.mm.yyyy"),
    DETAIL("dd.MMMM.yyyy HH:mm:ss"),
}