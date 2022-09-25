package com.example.apprende4bg12.di

import androidx.room.Room
import com.example.apprende4bg12.AppDatabase
import com.example.apprende4bg12.dao.CoursesDao
import com.example.apprende4bg12.data.dao.ServiceDao
import com.example.apprende4bg12.data.datasources.MemoryDataSource
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataSourceModule = module{
    single { MemoryDataSource() }
    single<AppDatabase>{
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "apprendemintic").build()
    }
    single<CoursesDao> {
        get<AppDatabase>().coursesDao()
    }

    single<ServiceDao> {
        get<AppDatabase>().serviceDao()
    }
}