package com.kouta.customtwitter.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.kouta.customtwitter.ui.Destinations.Composable.DIRECT_MAIL_ROUTE
import com.kouta.customtwitter.ui.Destinations.Composable.HOME_TIME_LINE_ROUTE
import com.kouta.customtwitter.ui.Destinations.Composable.NOTIFICATION_ROUTE
import com.kouta.customtwitter.ui.Destinations.Composable.SEARCH_ROUTE
import com.kouta.customtwitter.ui.Destinations.Composable.TWEET_DETAIL_ROUTE
import com.kouta.customtwitter.ui.Destinations.Navigation.DIRECT_MAIL_PARENT_ROUTE
import com.kouta.customtwitter.ui.Destinations.Navigation.HOME_PARENT_ROUTE
import com.kouta.customtwitter.ui.Destinations.Navigation.NOTIFICATION_PARENT_ROUTE
import com.kouta.customtwitter.ui.Destinations.Navigation.SEARCH_PARENT_ROUTE
import com.kouta.customtwitter.ui.mobiletwitter.hometimeline.HomeTimeLineScreen
import com.kouta.customtwitter.ui.mobiletwitter.tweetdetail.TweetDetailScreen

object Destinations {
    object Navigation {
        const val HOME_PARENT_ROUTE = "homeParent"
        const val SEARCH_PARENT_ROUTE = "searchParent"
        const val NOTIFICATION_PARENT_ROUTE = "notificationParent"
        const val DIRECT_MAIL_PARENT_ROUTE = "directMailParent"
    }

    object Composable {
        const val HOME_TIME_LINE_ROUTE = "homeTimeLine"
        const val TWEET_DETAIL_ROUTE = "tweetDetail"
        const val SEARCH_ROUTE = "search"
        const val NOTIFICATION_ROUTE = "notification"
        const val DIRECT_MAIL_ROUTE = "directMail"
    }
}

@Composable
fun CustomTwitterNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = HOME_PARENT_ROUTE
) {
    NavHost(
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