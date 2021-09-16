package com.kouta.customtwitter.repository

import com.kouta.customtwitter.data.remote.TwitterAPIService
import com.kouta.customtwitter.model.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class TweetRepository @Inject constructor(
    private val tweetAPIService: TwitterAPIService
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

    suspend fun fetchTimeline(
        count: Int = 10,
        authorizationStr: String
    ): Result<List<Tweet>> =
        withContext(IO) {
            try {
                val response: Response<List<Tweet>> = tweetAPIService.fetchTimeline(
//                count = count,
                    authorizationStr = authorizationStr
                )

                return@withContext Result.Success(response.body() ?: listOf())
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
}