package com.hamon.sicloapp.viewmodel

import androidx.lifecycle.ViewModel
import com.hamon.sicloapp.repository.SicloPreferences

class MainViewModel(private val preferences: SicloPreferences) : ViewModel(){

    fun getIsFirstTime(): Boolean = preferences.getIsFirsTime()

}