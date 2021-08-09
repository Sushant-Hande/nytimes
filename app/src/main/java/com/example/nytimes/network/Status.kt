package com.example.nytimes.network

/**
 * Created by shande on 07-08-2021
 */
sealed class Status {
    object Success : Status()
    object Error : Status()
    object Loading : Status()
}