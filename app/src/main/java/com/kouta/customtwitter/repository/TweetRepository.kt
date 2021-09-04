package com.kouta.customtwitter.repository

import com.kouta.customtwitter.model.Tweet
import com.kouta.customtwitter.model.fakeTweetItem
import javax.inject.Inject

class TweetRepository @Inject constructor(

) {
    fun getTweet(): List<Tweet> = listOf(
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem,
        fakeTweetItem
    )

}