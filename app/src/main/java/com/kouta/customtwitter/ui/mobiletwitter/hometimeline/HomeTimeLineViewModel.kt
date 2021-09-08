package com.kouta.customtwitter.ui.mobiletwitter.hometimeline

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.kouta.customtwitter.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeTimeLineViewModel @Inject constructor(
    private val tweetRepository: TweetRepository
) : ViewModel() {
    val tweets = Pager(PagingConfig(pageSize = 10)) {
        PageSource(tweetRepository.getTweet())
    }.flow.cachedIn(viewModelScope)
}