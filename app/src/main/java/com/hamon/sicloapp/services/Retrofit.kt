package com.hamon.sicloapp.services

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object Retrofit {

    const val URL_BASE = "https://api.siclo.com/api/v2/plus/"

    private fun createInstance(baseURL: String) : Retrofit{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .build()
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
            .client(okHttpClient)
            .build()
    }

    fun createSicloServices(): SicloAPI = createInstance(URL_BASE).create(SicloAPI::class.java)

}