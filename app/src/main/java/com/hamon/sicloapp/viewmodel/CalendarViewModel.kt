package com.hamon.sicloapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamon.sicloapp.controller.SicloControllerImpl
import kotlinx.coroutines.launch

class CalendarViewModel(private val sicloControllerImpl: SicloControllerImpl): ViewModel(){

    init {
        viewModelScope.launch {
            sicloControllerImpl.getActivitiesCalendar()
        }
    }

}