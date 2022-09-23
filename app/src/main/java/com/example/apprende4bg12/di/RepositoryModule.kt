package com.example.apprende4bg12.di

import com.example.apprende4bg12.data.repositories.HomeRepository
import com.example.apprende4bg12.data.repositories.LoginRepository
import org.koin.dsl.module

val repoModule = module {
    single { LoginRepository(get()) }
    single { HomeRepository(get()) }
}