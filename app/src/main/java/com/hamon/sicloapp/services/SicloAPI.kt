package com.hamon.sicloapp.services

import com.hamon.sicloapp.models.SicloResponse
import retrofit2.http.GET

interface SicloAPI {

    @GET("calendar/?location=603967&page_size=-1")
    suspend fun getActivitiesCalendar():SicloResponse
}