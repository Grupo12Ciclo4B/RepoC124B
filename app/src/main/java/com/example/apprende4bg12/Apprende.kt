package com.example.apprende4bg12

import android.app.Application
import com.example.apprende4bg12.di.dataSourceModule
import com.example.apprende4bg12.di.repoModule
import com.example.apprende4bg12.di.viewModelModule
import org.koin.core.context.startKoin
import org.koin.android.ext.koin.androidLogger
import  org.koin.android.ext.koin.androidContext

class Apprende: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@Apprende)
            modules(dataSourceModule, repoModule, viewModelModule)
        }
    }
}