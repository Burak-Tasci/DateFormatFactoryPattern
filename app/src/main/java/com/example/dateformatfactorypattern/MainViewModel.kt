package com.example.dateformatfactorypattern

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dateformatfactorypattern.dateformatter.DateFormatType
import com.example.dateformatfactorypattern.dateformatter.DateFormatterFactory
import java.util.Date

class MainViewModel: ViewModel() {

    private val _dateFormatResult = MutableLiveData<String>()
    val dateFormatResult: LiveData<String> = _dateFormatResult

    fun format(date: Date, type: DateFormatType) {
        val formatter = DateFormatterFactory.create(type)
        val result = formatter.format(date)
        _dateFormatResult.postValue(result)
    }
}