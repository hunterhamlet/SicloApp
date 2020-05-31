package com.hamon.sicloapp.controller

import com.hamon.sicloapp.models.SicloResponse
import com.hamon.sicloapp.services.SicloAPI

class SicloControllerImpl(private val sicloAPI: SicloAPI): SicloController {
    override suspend fun getActivitiesCalendar(): SicloResponse {
        return try {
            sicloAPI.getActivitiesCalendar()
        }catch (exception: Exception){
            SicloResponse()
        }
    }

}

interface SicloController{

    suspend fun getActivitiesCalendar(): SicloResponse

}