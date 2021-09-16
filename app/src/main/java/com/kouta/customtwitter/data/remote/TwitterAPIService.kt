package com.kouta.customtwitter.data.remote

import com.kouta.customtwitter.model.Tweet
import com.kouta.customtwitter.utils.URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface TwitterAPIService {
    @GET(URL.Version1_1.HOME_TIMELINE)
    suspend fun fetchTimeline(
//        @Query("count") count: Int,
        @Header("Authorization") authorizationStr: String
    ): Response<List<Tweet>>
}