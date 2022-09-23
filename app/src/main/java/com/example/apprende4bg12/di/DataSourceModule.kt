package com.example.apprende4bg12.di

import com.example.apprende4bg12.data.datasources.MemoryDataSource
import org.koin.dsl.module

val dataSourceModule = module{
    single { MemoryDataSource() }
}