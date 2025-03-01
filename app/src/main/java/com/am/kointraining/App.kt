package com.am.kointraining

import android.app.Application
import com.am.kointraining.di.activityModule
import com.am.kointraining.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule, activityModule)
        }
    }
}