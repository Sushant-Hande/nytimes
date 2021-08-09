package com.example.nytimes.network.apiservice

import com.example.nytimes.network.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by shande on 07-08-2021
 */
interface ApiService {

    @GET("viewed/7.json")
    suspend fun getMostViewedArticles(@Query(API_KEY) apKey: String): ApiResponse

    companion object {
        const val API_KEY = "api-key"
        const val PAGE = "page"
    }
}
