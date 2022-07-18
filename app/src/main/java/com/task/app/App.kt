package com.task.app

import android.app.Application
import com.task.data.di.dataModulesList
import com.task.di.appModulesList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            koin.loadModules(appModulesList + dataModulesList)
        }
    }
}