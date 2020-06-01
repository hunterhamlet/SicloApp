package com.hamon.sicloapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hamon.sicloapp.repository.SicloPreferences

class LoginViewModel(private val preferences: SicloPreferences) : ViewModel(){

    private val _isNewUserObservable: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>().apply { value = true } }
    val isNewUserObservable: LiveData<Boolean> get() = _isNewUserObservable

    fun checkUserEmailAndPass(userEmail: String, userPass: String){
        _isNewUserObservable.postValue(userEmail == preferences.getUserEmail() && userPass == preferences.getUserPass())
    }

}