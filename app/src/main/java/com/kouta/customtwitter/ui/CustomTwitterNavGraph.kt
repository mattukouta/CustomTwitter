package com.kouta.customtwitter.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.kouta.customtwitter.ui.launch.LaunchScreen
import com.kouta.customtwitter.ui.login.LoginScreen
import com.kouta.customtwitter.ui.mobiletwitter.hometimeline.HomeTimeLineScreen
import com.kouta.customtwitter.ui.mobiletwitter.tweetdetail.TweetDetailScreen
import com.kouta.customtwitter.utils.Destinations.LAUNCH_ROUTE
import com.kouta.customtwitter.utils.Destinations.LOGIN_ROUTE
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
fun CustomTwitterNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = LAUNCH_ROUTE,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(LAUNCH_ROUTE) {
            LaunchScreen(navController = navController)
        }

        composable(LOGIN_ROUTE) {
            LoginScreen(
                navController = navController,
                scaffoldState = scaffoldState
            )
        }

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