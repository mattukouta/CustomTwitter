package com.kouta.customtwitter.ui.mobiletwitter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kouta.customtwitter.ui.CustomTwitterNavGraph
import com.kouta.customtwitter.ui.components.MobileTwitterBottomBar
import com.kouta.customtwitter.ui.components.MobileTwitterTopBar

@Composable
fun MobileTwitterScreen(
    viewModel: MobileTwitterViewModel = viewModel()
) {
    val navController = rememberNavController()
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
        CustomTwitterNavGraph(
            navController = navController
        )
    }
}