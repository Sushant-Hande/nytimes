package com.example.nytimes.network

import com.example.nytimes.models.Article
import com.squareup.moshi.Json

/**
 * Created by shande on 07-08-2021
 */
class ApiResponse {

    @field:Json(name = "results")
    val results: List<Article>? = null

}