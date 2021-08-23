package com.kouta.customtwitter.ui.mobiletwitter

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kouta.customtwitter.ui.components.MobileTwitterBottomBar
import com.kouta.customtwitter.ui.components.MobileTwitterTopBar

@Composable
fun MobileTwitterScreen(
    viewModel: MobileTwitterViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            MobileTwitterTopBar()
        },
        bottomBar = {
            MobileTwitterBottomBar()
        }
    ) {

    }
}