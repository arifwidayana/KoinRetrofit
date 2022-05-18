package com.arifwidayana.koinretrofit.data.network

import com.arifwidayana.koinretrofit.data.model.response.PopularMoviesResponse
import retrofit2.http.GET

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(): PopularMoviesResponse
}