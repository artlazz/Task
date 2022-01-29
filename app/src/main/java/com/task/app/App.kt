package com.task.app

import android.app.Application
import com.task.di.appModulesList
import com.task.domain.di.domainModulesList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(appModulesList + domainModulesList)
        }
    }
}