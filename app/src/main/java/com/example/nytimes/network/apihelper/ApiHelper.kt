package com.example.nytimes.network.apihelper


import com.example.nytimes.network.apiservice.ApiService
import javax.inject.Inject

/**
 * Created by shande on 07-08-2021
 */
class ApiHelper @Inject constructor(private val apiService: ApiService) {

    suspend fun getMostViewedArticles(apiKey:String) = apiService.getMostViewedArticles(apiKey)

}