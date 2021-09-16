package com.kouta.customtwitter.model

import com.squareup.moshi.Json

data class User(
    val id: Long,
    @Json(name = "screen_name") val userID: String,
    val name: String,
    @Json(name = "profile_image_url_https") val iconUrl: String,
)
