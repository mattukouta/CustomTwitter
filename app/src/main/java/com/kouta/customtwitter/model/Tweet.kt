package com.kouta.customtwitter.model

import com.squareup.moshi.Json

data class Tweet(
    val id: Long = 0,
    @Json(name = "created_at") val tweetDate: String,
    val text: String,
    val user: User
)

val fakeTweetItem = Tweet(
    tweetDate = "8月16日",
    text = "うせやろ...",
    user = User(
        id = 123,
        name = "まっつ",
        userID = "mattukouta",
        iconUrl = "https://pbs.twimg.com/profile_images/1112509808517611520/U0sCM5kj_bigger.png"
    )
)
