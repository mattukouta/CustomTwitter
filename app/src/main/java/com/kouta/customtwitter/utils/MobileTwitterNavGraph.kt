package com.kouta.customtwitter.utils

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.kouta.customtwitter.ui.mobiletwitter.hometimeline.HomeTimeLineScreen
import com.kouta.customtwitter.ui.mobiletwitter.tweetdetail.TweetDetailScreen
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.DIRECT_MAIL_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.HOME_TIME_LINE_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.NOTIFICATION_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.SEARCH_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.TWEET_DETAIL_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Navigation.DIRECT_MAIL_PARENT_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Navigation.HOME_PARENT_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Navigation.NOTIFICATION_PARENT_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Navigation.SEARCH_PARENT_ROUTE

@Composable
fun MobileTwitterNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = HOME_PARENT_ROUTE
) {
    NavHost(
        modifier = Modifier.padding(bottom = 56.dp),
        navController = navController,
        startDestination = startDestination
    ) {
        navigation(
            startDestination = HOME_TIME_LINE_ROUTE,
            route = HOME_PARENT_ROUTE
        ) {
            composable(HOME_TIME_LINE_ROUTE) {
                HomeTimeLineScreen(
                    navController = navController
                )
            }

            composable(TWEET_DETAIL_ROUTE) {
                TweetDetailScreen()
            }
        }

        navigation(
            startDestination = SEARCH_ROUTE,
            route = SEARCH_PARENT_ROUTE
        ) {
            composable(SEARCH_ROUTE) {

            }
        }

        navigation(
            startDestination = NOTIFICATION_ROUTE,
            route = NOTIFICATION_PARENT_ROUTE
        ) {
            composable(NOTIFICATION_ROUTE) {
                TweetDetailScreen()
            }
        }

        navigation(
            startDestination = DIRECT_MAIL_ROUTE,
            route = DIRECT_MAIL_PARENT_ROUTE
        ) {
            composable(DIRECT_MAIL_ROUTE) {

            }
        }
    }
}