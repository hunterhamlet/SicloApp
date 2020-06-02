package com.hamon.sicloapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hamon.sicloapp.controller.SicloControllerImpl
import com.hamon.sicloapp.models.SicloClass
import com.hamon.sicloapp.models.SicloResponse
import com.hamon.sicloapp.repository.SicloPreferences
import com.hamon.sicloapp.utils.getKeysAndValues
import kotlinx.coroutines.launch
import timber.log.Timber

class CalendarViewModel(
    private val sicloControllerImpl: SicloControllerImpl,
    private val preferences: SicloPreferences
) : ViewModel() {

    private val _listOfDays: MutableLiveData<MutableList<String>> by lazy { MutableLiveData<MutableList<String>>() }
    val listOfDays: MutableLiveData<MutableList<String>> get() = _listOfDays
    private var sicloCalendar = SicloResponse()
    private val _userName: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    private var mapDays: Map<String, List<SicloClass>> = mapOf()
    val userName: MutableLiveData<String> get() = _userName
    private val _listEvents: MutableLiveData<List<SicloClass>> by lazy { MutableLiveData<List<SicloClass>>() }
    val listEvents: MutableLiveData<List<SicloClass>> get() = _listEvents

    init {
        viewModelScope.launch {
            sicloCalendar = sicloControllerImpl.getActivitiesCalendar()
            mapDays = sicloCalendar.calendar
            _listOfDays.postValue(sicloCalendar.calendar.getKeysAndValues().first)
        }
        _userName.postValue(preferences.getUserName())
    }

    fun getListEvents(keyDay: String) {
        _listEvents.postValue(mapDays.getValue(keyDay))
    }


}