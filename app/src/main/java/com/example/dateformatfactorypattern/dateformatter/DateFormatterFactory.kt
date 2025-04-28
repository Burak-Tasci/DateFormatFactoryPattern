package com.example.dateformatfactorypattern.dateformatter

class DateFormatterFactory private constructor() {

    companion object {
        fun create(type: DateFormatType): DateFormatter {
            return when(type) {
                DateFormatType.BASIC -> BasicDateFormatter()
                DateFormatType.DETAIL -> DetailDateFormatter()
            }
        }
    }
}