package com.arifwidayana.koinretrofit.data.network

class ApiHelper(private val apiService: ApiService) {
    suspend fun getDataMovies() = apiService.getPopularMovies()
}