package com.kouta.customtwitter.ui.launch

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kouta.customtwitter.utils.Destinations.LAUNCH_ROUTE
import com.kouta.customtwitter.utils.Destinations.LOGIN_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.HOME_TIME_LINE_ROUTE

@Composable
fun LaunchScreen(
    navController: NavController = rememberNavController(),
    viewModel: LaunchViewModel = hiltViewModel()
) {
    val launchState by viewModel.launchState.collectAsState()

    val modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primary)

    when(launchState) {
        is LaunchState.Loading -> {
            LaunchBackground(modifier = modifier)

            viewModel.getUserData()
        }
        is LaunchState.Complete -> {
            LaunchBackground(
                modifier = modifier
                    .clickable {
                        if ((launchState as LaunchState.Complete).isUserSetting) {
                            navController.navigate(HOME_TIME_LINE_ROUTE) {
                                popUpTo(LAUNCH_ROUTE) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        } else {
                            navController.navigate(LOGIN_ROUTE) {
                                popUpTo(LAUNCH_ROUTE) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        }
                    }
            )
        }
    }
}

@Composable
fun LaunchBackground(modifier: Modifier) {
    ConstraintLayout(
        modifier = modifier
    ) {

    }
}

sealed class LaunchState {
    object Loading: LaunchState()
    data class Complete(val isUserSetting: Boolean): LaunchState()
}

@Preview
@Composable
private fun LaunchScreenPreview() {
    LaunchScreen()
}