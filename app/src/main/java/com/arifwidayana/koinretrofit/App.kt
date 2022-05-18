package com.arifwidayana.koinretrofit

import android.app.Application
import com.arifwidayana.koinretrofit.data.repo.repositoryModule
import com.arifwidayana.koinretrofit.di.networkModule
import com.arifwidayana.koinretrofit.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    networkModule,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}