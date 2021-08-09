package com.example.nytimes.models

/**
 * Created by shande on 07-08-2021
 */
data class Media(
    val approved_for_syndication: Int,
    val caption: String,
    val copyright: String,
    val subtype: String,
    val type: String,
   /* val media-metadata: List<MediaMetadata>*/
)