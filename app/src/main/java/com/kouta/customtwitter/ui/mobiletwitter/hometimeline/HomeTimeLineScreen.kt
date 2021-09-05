package com.kouta.customtwitter.ui.mobiletwitter.hometimeline

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.kouta.customtwitter.model.Tweet
import com.kouta.customtwitter.ui.components.TweetItem
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.TWEET_DETAIL_ROUTE

@Composable
fun HomeTimeLineScreen(
    navController: NavController = rememberNavController(),
    viewModel: HomeTimeLineViewModel = viewModel()
){
    val listState = rememberLazyListState()

    val items: LazyPagingItems<Tweet> = viewModel.tweets.collectAsLazyPagingItems()

    LazyColumn(
        state = listState
    ){
        items(items) { item ->
            if (item != null) {
                TweetItem(
                    onItemClick = {
                        navController.navigate(TWEET_DETAIL_ROUTE)
                    },
                    tweetItem = item
                )
            }
        }
    }
}