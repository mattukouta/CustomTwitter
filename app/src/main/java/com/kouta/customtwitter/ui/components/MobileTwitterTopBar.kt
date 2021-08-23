package com.kouta.customtwitter.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MobileTwitterTopBar(
    onClick: () -> Unit = {}
) {
    TopAppBar(
        modifier = Modifier
            .clickable {
                onClick()
            },
        backgroundColor = MaterialTheme.colors.background
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "MattuCustomTwitter",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = MaterialTheme.colors.primary
        )
    }
}

@Preview
@Composable
fun MobileTwitterTopBarPreview() {
    MobileTwitterTopBar()
}