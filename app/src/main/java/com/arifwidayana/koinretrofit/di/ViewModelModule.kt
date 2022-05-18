package com.arifwidayana.koinretrofit.di

import com.arifwidayana.koinretrofit.ui.activity.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::MainActivityViewModel)
}