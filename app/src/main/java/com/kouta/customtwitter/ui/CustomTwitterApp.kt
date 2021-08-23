package com.kouta.customtwitter.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kouta.customtwitter.ui.theme.CustomTwitterTheme

@Composable
fun CustomTwitter(
    viewModel: TestViewModel = viewModel()
){
    Greeting(viewModel.hoge.toString())
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CustomTwitterTheme {
        Greeting("Android")
    }
}