package com.kouta.customtwitter.ui.mobiletwitter.hometimeline

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kouta.customtwitter.ui.Destinations.Composable.TWEET_DETAIL_ROUTE

@Composable
fun HomeTimeLineScreen(
    navController: NavController = rememberNavController()
){
    Text(
        modifier = Modifier.clickable {
            navController.navigate(TWEET_DETAIL_ROUTE)
        },
        text = "Home"
    )
}