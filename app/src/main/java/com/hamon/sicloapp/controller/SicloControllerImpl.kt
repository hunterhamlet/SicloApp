package com.hamon.sicloapp.controller

import com.hamon.sicloapp.models.SicloResponse
import com.hamon.sicloapp.services.SicloAPI

class SicloControllerImpl(private val sicloAPI: SicloAPI) : SicloController {
    override suspend fun getActivitiesCalendar(): SicloResponse {
        return try {
            sicloAPI.getActivitiesCalendar()
        } catch (exception: Exception) {
            exception.printStackTrace()
            SicloResponse()
        }
    }

}

interface SicloController {

    suspend fun getActivitiesCalendar(): SicloResponse

}