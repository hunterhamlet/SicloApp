package com.hamon.sicloapp.viewmodel

import androidx.lifecycle.ViewModel
import com.hamon.sicloapp.repository.SicloPreferences

class RegisterViewModel(private val sicloPreferences: SicloPreferences) : ViewModel() {

    fun saveInfoUser(
        name: String,
        firstName: String,
        secondLastName: String,
        email: String,
        password: String
    ) {
        sicloPreferences.setUserName(name)
        sicloPreferences.setLastName(firstName)
        sicloPreferences.setSecondLastName(secondLastName)
        sicloPreferences.setUserEmail(email)
        sicloPreferences.setUserPass(password)
        sicloPreferences.setIsFirsTime(false)
    }
}