package com.kouta.customtwitter.ui.launch

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kouta.customtwitter.utils.Destinations.LAUNCH_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.HOME_TIME_LINE_ROUTE

@Composable
fun LaunchScreen(
    navController: NavController = rememberNavController()
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                navController.navigate(HOME_TIME_LINE_ROUTE) {
                    popUpTo(LAUNCH_ROUTE) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
            .background(color = MaterialTheme.colors.primary)
    ) {

    }
}

@Preview
@Composable
private fun LaunchScreenPreview() {
    LaunchScreen()
}