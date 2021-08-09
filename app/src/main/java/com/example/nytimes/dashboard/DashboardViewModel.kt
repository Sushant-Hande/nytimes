package com.example.nytimes.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.nytimes.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by shande on 07-08-2021
 */
@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: DashboardRepository): ViewModel() {

    fun getMostViewedArticles() = liveData{
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getMostViewedArticles()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, msg = exception.message ?: "Error Occurred!"))
        }
    }


}