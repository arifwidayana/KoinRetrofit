package com.arifwidayana.koinretrofit.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arifwidayana.koinretrofit.data.model.response.PopularMoviesResponse
import com.arifwidayana.koinretrofit.data.repo.NetworkRepository
import com.arifwidayana.koinretrofit.data.utils.Resource
import kotlinx.coroutines.launch

class MainActivityViewModel(private val repository: NetworkRepository): ViewModel() {
    private val dataMovies = MutableLiveData<Resource<PopularMoviesResponse>>()
    val movies: LiveData<Resource<PopularMoviesResponse>>
        get() = dataMovies

    fun getMovies() {
        viewModelScope.launch {
            dataMovies.postValue(Resource.loading())
            try {
                dataMovies.postValue(Resource.success(repository.getPopularMovies()))
            } catch (exception: Exception) {
                dataMovies.postValue(Resource.error(exception.message ?: "Error Occurred"))
            }
        }
    }
}
