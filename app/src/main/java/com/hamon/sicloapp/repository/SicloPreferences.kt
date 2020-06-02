package com.hamon.sicloapp.repository

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class SicloPreferences(context: Context) {

    private val SHARED_PREFERENCE = "shared_preferences"
    private val USER_NAME = "user_name"
    private val LAST_NAME = "last_name"
    private val SECOND_LAST_NAME = "second_last_name"
    private val FULL_NAME = "full_name"
    private val USER_EMAIL = "user_email"
    private val USER_PASS = "user_pass"
    private val IS_FIRST_TIME = "is_first_time"

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(
            SHARED_PREFERENCE,
            Context.MODE_PRIVATE
        )
    }

    fun setUserName(userName: String) {
        sharedPreferences
            .edit()
            .putString(USER_NAME, userName)
            .apply()
    }

    fun getUserName() = sharedPreferences.getString(USER_NAME, "")

    fun setLastName(lastName: String) {
        sharedPreferences
            .edit()
            .putString(LAST_NAME, lastName)
            .apply()
    }

    fun getLastName() = sharedPreferences.getString(LAST_NAME, "")

    fun setSecondLastName(secondLastName: String) {
        sharedPreferences
            .edit()
            .putString(SECOND_LAST_NAME, secondLastName)
            .apply()
    }

    fun getSecondLastName() = sharedPreferences.getString(SECOND_LAST_NAME, "")

    fun setFullName(fullName: String) {
        sharedPreferences
            .edit()
            .putString(FULL_NAME, fullName)
            .apply()
    }

    fun setUserEmail(userEmail: String) {
        sharedPreferences
            .edit()
            .putString(USER_EMAIL, userEmail)
            .apply()
    }

    fun getUserEmail() = sharedPreferences.getString(USER_EMAIL, "")

    fun setUserPass(userPass: String) {
        sharedPreferences
            .edit()
            .putString(USER_PASS, userPass)
            .apply()
    }

    fun getUserPass() = sharedPreferences.getString(USER_PASS, "")

    fun setIsFirsTime(isFirstTime: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(IS_FIRST_TIME, isFirstTime)
            .apply()
    }

    fun getIsFirsTime() = sharedPreferences.getBoolean(IS_FIRST_TIME, true)
}