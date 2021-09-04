package com.kouta.customtwitter.ui.mobiletwitter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kouta.customtwitter.ui.components.MobileTwitterBottomBar
import com.kouta.customtwitter.ui.components.MobileTwitterTopBar
import com.kouta.customtwitter.utils.MobileTwitterNavGraph

@Composable
fun MobileTwitterScreen(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        topBar = {
            MobileTwitterTopBar()
        },
        bottomBar = {
            MobileTwitterBottomBar(
                navController = navController,
                backStackEntry = backStackEntry
            )
        }
    ) {
        MobileTwitterNavGraph(
            navController = navController
        )
    }
}