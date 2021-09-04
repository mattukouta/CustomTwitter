package com.kouta.customtwitter.ui.launch

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.kouta.customtwitter.ui.LaunchState

@Composable
fun LaunchScreen(
    onClick: (LaunchState) -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .clickable {
                onClick(LaunchState.Completed)
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