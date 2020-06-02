package com.hamon.sicloapp.app

import android.app.Application
import com.hamon.sicloapp.BuildConfig
import com.hamon.sicloapp.di.coreModule
import com.hamon.sicloapp.repository.SicloPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class SicloApp : Application() {

    private val appModule = module {
        single { SicloPreferences(this@SicloApp) }
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@SicloApp)
            modules(listOf(appModule, coreModule))
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}