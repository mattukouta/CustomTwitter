package com.kouta.customtwitter.ui.login

import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kouta.customtwitter.repository.DataType
import com.kouta.customtwitter.repository.UserSettingRepository
import com.kouta.customtwitter.utils.TwitterAPI.CONSUMER_KEY
import com.kouta.customtwitter.utils.TwitterAPI.CONSUMER_SECRET
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

    /**
     * リクエストトークンの取得
     */
    fun getRequestToken(){
        val builder = ConfigurationBuilder()
            .setDebugEnabled(true)
            .setOAuthConsumerKey(CONSUMER_KEY)
            .setOAuthConsumerSecret(CONSUMER_SECRET)

        val config = builder.build()
        val factory = TwitterFactory(config)

        twitter = factory.instance

        viewModelScope.launch(IO){
            try {
                _loadingState.value = LoginState.Requesting(
                    twitter.oAuthRequestToken
                )
            } catch (e: IllegalStateException) {
                _loadingState.value = LoginState.Error(e)
            }
        }
    }

    /**
     * アクセストークンの取得用
     */
    fun handleUrl(url: String) {
        val uri = Uri.parse(url)
        val oauthVerifier = uri.getQueryParameter("oauth_verifier") ?: ""

        viewModelScope.launch(Default) {
            try {
                val accessToken = twitter.getOAuthAccessToken(oauthVerifier)

                _loadingState.value = LoginState.Success(accessToken)
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
        try {
            userSettingRepository.putData(dataTypes)
        } catch (e: Exception) {
            _loadingState.value = LoginState.Error(Exception())
        }
    }
}