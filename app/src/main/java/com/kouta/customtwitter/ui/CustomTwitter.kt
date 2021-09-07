package com.kouta.customtwitter.ui

import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.kouta.customtwitter.ui.components.MobileTwitterBottomBar
import com.kouta.customtwitter.ui.components.MobileTwitterTopBar
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.DIRECT_MAIL_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.HOME_TIME_LINE_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.NOTIFICATION_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.SEARCH_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.TWEET_DETAIL_ROUTE

@Composable
fun CustomTwitter(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            when(currentRoute) {
                HOME_TIME_LINE_ROUTE, SEARCH_ROUTE, NOTIFICATION_ROUTE, DIRECT_MAIL_ROUTE, TWEET_DETAIL_ROUTE ->
                    MobileTwitterTopBar(
                        modifier = modifier.statusBarsPadding()
                    )
            }
        },
        bottomBar = {
            when(currentRoute) {
                HOME_TIME_LINE_ROUTE, SEARCH_ROUTE, NOTIFICATION_ROUTE, DIRECT_MAIL_ROUTE  ->
                    MobileTwitterBottomBar(
                        navController = navController,
                        backStackEntry = backStackEntry
                    )
            }
        }
    ) {
        CustomTwitterNavGraph(
            scaffoldState = scaffoldState,
            modifier = modifier
                .navigationBarsPadding(),
            navController = navController
        )
    }
}