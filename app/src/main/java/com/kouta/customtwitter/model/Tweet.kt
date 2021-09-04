package com.kouta.customtwitter.model

data class Tweet(
    val tweetID: Int = 0,
    val userIconUrl: String,
    val userName: String,
    val userID: String,
    val tweetDate: String,
    val tweet: String
)

val fakeTweetItem = Tweet(
    userIconUrl = "https://pbs.twimg.com/profile_images/1112509808517611520/U0sCM5kj_bigger.png",
    userName = "まっつ",
    userID = "@mattukouta",
    tweetDate = "8月16日",
    tweet = "うせやろ..."
)
