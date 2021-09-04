package com.kouta.customtwitter.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = LightBlue200,
    primaryVariant = LightBlue300,
    secondary = White,
    secondaryVariant = BlueGrey400,
    background = Grey900
)

private val LightColorPalette = lightColors(
    primary = LightBlue200,
    primaryVariant = LightBlue300,
    secondary = BlueGrey900,
    secondaryVariant = BlueGrey800,
    background = White
)

@Composable
fun CustomTwitterTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}