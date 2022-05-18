package com.arifwidayana.koinretrofit.data.repo

import com.arifwidayana.koinretrofit.data.network.ApiHelper

class NetworkRepository(private val apiHelper: ApiHelper) {
    suspend fun getPopularMovies() = apiHelper.getDataMovies()
}