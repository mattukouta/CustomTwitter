package com.kouta.customtwitter.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager

@Module
@InstallIn(ApplicationComponentManager::class)
object Module {
//    @Provides
//    @Singleton
//    fun provideTweetRepository(): TweetRepository = TweetRepository()
}