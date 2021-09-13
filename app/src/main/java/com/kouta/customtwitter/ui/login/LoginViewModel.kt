package com.kouta.customtwitter.ui.login

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kouta.customtwitter.BuildConfig.*
import com.kouta.customtwitter.model.Result
import com.kouta.customtwitter.repository.DataType
import com.kouta.customtwitter.repository.UserSettingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.conf.ConfigurationBuilder
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userSettingRepository: UserSettingRepository
): ViewModel() {

    private val _loadingState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.Loading)
    val loadingState: StateFlow<LoginState> get() = _loadingState

    private lateinit var twitter: Twitter

    private fun createTwitterProperty(): Twitter {
        val returnProperty: Twitter
        val builder = ConfigurationBuilder()
            .setDebugEnabled(true)
            .setOAuthConsumerKey(CONSUMER_KEY)
            .setOAuthConsumerSecret(CONSUMER_SECRET)

        val config = builder.build()
        val factory = TwitterFactory(config)

        returnProperty = factory.instance
        return returnProperty
    }

    private fun getTwitterProperty(): Twitter = twitter

    /**
     * リクエストトークンの取得
     */
    fun getRequestToken(){
        twitter = createTwitterProperty()

        viewModelScope.launch(IO){
            try {
                _loadingState.value = LoginState.RequestingAccessToken(
                    twitter.oAuthRequestToken
                )
            } catch (e: Exception) {
                _loadingState.value = LoginState.Error(e)
            }
        }
    }

    /**
     * アクセストークンの取得用
     */
    fun getAccessToken(url: String) {
        val uri = Uri.parse(url)
        val oauthVerifier = uri.getQueryParameter("oauth_verifier") ?: ""

        viewModelScope.launch(Default) {
            try {
                val accessToken = getTwitterProperty().getOAuthAccessToken(oauthVerifier)

                _loadingState.value = LoginState.SavingUserData(accessToken)
//                _loadingState.value = LoginState.Error(Exception())
            } catch (e: Exception) {
                _loadingState.value = LoginState.Error(e)
            }
        }
    }

    /**
     * エラー時に初期画面に戻す用
     */
    fun resetLoadingState() {
        _loadingState.value = LoginState.Loading
    }

    fun putData(dataTypes: List<DataType>) {
        when(val result = userSettingRepository.putData(dataTypes)) {
            is Result.Success -> {
                _loadingState.value = LoginState.Success
            }

            is Result.Error -> {
                _loadingState.value = LoginState.Error(result.exception)
            }
        }
    }
}