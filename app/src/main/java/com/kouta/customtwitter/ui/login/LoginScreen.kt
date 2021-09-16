package com.kouta.customtwitter.ui.login

import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import com.kouta.customtwitter.repository.DataType
import com.kouta.customtwitter.ui.components.SimpleSnackBar
import com.kouta.customtwitter.utils.Destinations.LOGIN_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Composable.HOME_TIME_LINE_ROUTE
import com.kouta.customtwitter.utils.Params.SharedPreferencesKey.ACCESS_TOKEN
import com.kouta.customtwitter.utils.Params.SharedPreferencesKey.ACCESS_TOKEN_SECRET
import com.kouta.customtwitter.utils.Params.CALLBACK_URL
import kotlinx.coroutines.CoroutineScope
import twitter4j.auth.AccessToken
import twitter4j.auth.RequestToken

@Composable
fun LoginScreen(
    navController: NavController = rememberNavController(),
    viewModel: LoginViewModel = viewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    scope: CoroutineScope = rememberCoroutineScope()
) {
    val loadingState by viewModel.loadingState.collectAsState()

    ConstraintLayout(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
    ) {
        when(loadingState) {
            is LoginState.Loading -> {
                viewModel.getRequestToken()
            }

            is LoginState.RequestingAccessToken -> {
                val authorizationURL = (loadingState as LoginState.RequestingAccessToken).requestToken.authorizationURL

                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            layoutParams = ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.MATCH_PARENT
                            )
                            webViewClient = object : WebViewClient() {
                                override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                                    if (url.toString().startsWith(CALLBACK_URL)) {
                                        Log.d("Authorization URL: ", url.toString())
                                        viewModel.getAccessToken(url.toString())

                                        return true
                                    }
                                    return false
                                }

                                override fun onPageFinished(view: WebView?, url: String?) {
                                    super.onPageFinished(view, url)
                                }
                            }

                            loadUrl(authorizationURL)
                        }
                    }
                )
            }

            is LoginState.SavingUserData -> {
                val accessToken = (loadingState as LoginState.SavingUserData).accessToken

                viewModel.putData(
                    listOf(
                        DataType.StringData(
                            key = ACCESS_TOKEN,
                            value = accessToken.token
                        ),
                        DataType.StringData(
                            key = ACCESS_TOKEN_SECRET,
                            value = accessToken.tokenSecret
                        )
                    )
                )
            }

            is LoginState.Success -> {
                navController.navigate(HOME_TIME_LINE_ROUTE) {
                    popUpTo(LOGIN_ROUTE) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }

            is LoginState.Error -> {
                SimpleSnackBar(
                    message = "ログイン時にエラーが発生しました。再度ログインしてください。",
                    scaffoldState = scaffoldState,
                    scope = scope
                )

                viewModel.resetLoadingState()
            }
        }
    }
}

sealed class LoginState {
    object Loading: LoginState()
    data class RequestingAccessToken(val requestToken: RequestToken): LoginState()
    data class SavingUserData(val accessToken: AccessToken): LoginState()
    object Success: LoginState()
    data class Error(val e: Exception): LoginState()
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}