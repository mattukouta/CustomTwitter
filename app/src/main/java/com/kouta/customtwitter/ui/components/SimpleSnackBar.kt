package com.kouta.customtwitter.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SimpleSnackBar(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    scope: CoroutineScope = rememberCoroutineScope(),
    message: String = "",
    snackBarDuration: SnackbarDuration = SnackbarDuration.Short
) {
    run {
        scope.launch {
            scaffoldState.snackbarHostState.showSnackbar(
                message = message,
                duration = snackBarDuration
            )
        }
    }
}