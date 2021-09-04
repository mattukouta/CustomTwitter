package com.kouta.customtwitter.ui

import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kouta.customtwitter.ui.launch.LaunchScreen
import com.kouta.customtwitter.ui.mobiletwitter.MobileTwitterScreen

@Composable
fun CustomTwitter(
    navController: NavHostController = rememberNavController()
) {
    var launchState by remember {
        mutableStateOf(LaunchState.Shown)
    }

    when(launchState) {
        LaunchState.Shown -> LaunchScreen(
            onClick = {
                launchState = it
            }
        )

        LaunchState.Completed -> MobileTwitterScreen(
            navController = navController
        )
    }
}

enum class LaunchState{ Shown, Completed }