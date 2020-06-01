package com.hamon.sicloapp.di

import com.hamon.sicloapp.controller.SicloControllerImpl
import com.hamon.sicloapp.services.Retrofit
import com.hamon.sicloapp.viewmodel.CalendarViewModel
import com.hamon.sicloapp.viewmodel.LoginViewModel
import com.hamon.sicloapp.viewmodel.MainViewModel
import com.hamon.sicloapp.viewmodel.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val coreModule = module {
    single { Retrofit.createSicloServices() }
    single { SicloControllerImpl(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { MainViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { CalendarViewModel(get(), get()) }
}