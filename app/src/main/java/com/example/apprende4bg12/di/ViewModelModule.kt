package com.example.apprende4bg12.di

import com.example.apprende4bg12.data.repositories.HomeRepository
import com.example.apprende4bg12.data.viewmodels.HomeViewModel
import com.example.apprende4bg12.data.viewmodels.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        LoginViewModel(get())
    }
    viewModel{
        HomeViewModel(get())
    }
}