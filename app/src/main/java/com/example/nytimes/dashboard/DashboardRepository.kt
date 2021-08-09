package com.example.nytimes.dashboard

import com.example.nytimes.API_KEY
import com.example.nytimes.network.apihelper.ApiHelper
import javax.inject.Inject

/**
 * Created by shande on 07-08-2021
 */
class DashboardRepository @Inject constructor(private val apiHelper: ApiHelper) {

    suspend fun getMostViewedArticles() = apiHelper.getMostViewedArticles(API_KEY)

}