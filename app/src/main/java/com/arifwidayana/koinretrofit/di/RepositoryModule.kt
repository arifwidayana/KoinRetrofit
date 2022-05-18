package com.arifwidayana.koinretrofit.data.repo

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::NetworkRepository)
}