package com.kouta.customtwitter.ui.mobiletwitter.hometimeline

import android.util.Base64
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.kouta.customtwitter.BuildConfig
import com.kouta.customtwitter.model.Authorization
import com.kouta.customtwitter.model.Result
import com.kouta.customtwitter.repository.DataType
import com.kouta.customtwitter.repository.TweetRepository
import com.kouta.customtwitter.repository.UserSettingRepository
import com.kouta.customtwitter.utils.Params.BIT_SIZE
import com.kouta.customtwitter.utils.Params.OAuthKey.CONSUMER_KEY
import com.kouta.customtwitter.utils.Params.OAuthKey.NONCE
import com.kouta.customtwitter.utils.Params.OAuthKey.SIGNATURE_METHOD
import com.kouta.customtwitter.utils.Params.OAuthKey.TIMESTAMP
import com.kouta.customtwitter.utils.Params.OAuthKey.TOKEN
import com.kouta.customtwitter.utils.Params.OAuthKey.VERSION
import com.kouta.customtwitter.utils.Params.SharedPreferencesKey.ACCESS_TOKEN
import com.kouta.customtwitter.utils.Params.SharedPreferencesKey.ACCESS_TOKEN_SECRET
import com.kouta.customtwitter.utils.URL.BASE_URL
import com.kouta.customtwitter.utils.URL.Version1_1.HOME_TIMELINE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URLEncoder
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject

@HiltViewModel
class HomeTimeLineViewModel @Inject constructor(
    private val tweetRepository: TweetRepository,
    private val userSettingRepository: UserSettingRepository
) : ViewModel() {
    val tweets = Pager(PagingConfig(pageSize = 10)) {
        PageSource(tweetRepository.getTweet())
    }.flow.cachedIn(viewModelScope)

    init {
        fetchTimeline()
    }

    fun fetchTimeline() {
        viewModelScope.launch(IO) {
            val accessTokenResult = getData(
                DataType.StringData(
                    key = ACCESS_TOKEN
                )
            )

            val accessTokenSecretResult = getData(
                DataType.StringData(
                    key = ACCESS_TOKEN_SECRET
                )
            )

            if(accessTokenResult is Result.Success && accessTokenSecretResult is Result.Success) {
                val authToken = (accessTokenResult.data as DataType.StringData).value
                val authTokenSecret = (accessTokenSecretResult.data as DataType.StringData).value
                val consumerKey = BuildConfig.CONSUMER_KEY
                val consumerSecret = BuildConfig.CONSUMER_SECRET
                val unixTime = getUnixTime()
                val oauthNonce = getNonce()
                val signatureMethod = "HMAC-SHA1"
                val version = "1.0"

                val test = createSignature(
                    oauthConsumerKey = consumerKey,
                    oauthConsumerSecret = consumerSecret,
                    oauthNonce = oauthNonce,
                    oauthSignatureMethod = signatureMethod,
                    oauthTimestamp = unixTime.toString(),
                    oauthToken = authToken,
                    oauthTokenSecret = authTokenSecret,
                    oauthVersion = version
                )

                val response = tweetRepository.fetchTimeline(
                    authorizationStr = Authorization(
                        oauthConsumerKey = replaceParams(encode(BuildConfig.CONSUMER_KEY)),
                        oauthNonce = replaceParams(encode(oauthNonce)),
                        oauthSignature = replaceParams(encode(test)),
                        oauthSignatureMethod = replaceParams(encode("HMAC-SHA1")),
                        oauthTimestamp = replaceParams(encode(unixTime.toString())),
                        oauthToken = replaceParams(encode(authToken)),
                        oauthVersion = replaceParams(encode("1.0"))
                    ).getAuthorizationStr()
                )



            } else {

            }
        }
    }

    private fun getData(dataType: DataType): Result<DataType> = userSettingRepository.getData(dataType)

    private fun getUnixTime(): Long = System.currentTimeMillis()/1000

    private suspend fun getNonce(): String = withContext(IO) {
        val chars = ('A'..'Z') + ('a'..'z') + ('0'..'9')

        List(BIT_SIZE) {
            chars.random()
        }.joinToString("")
    }

    private suspend fun createSignature(
        oauthConsumerKey: String,
        oauthConsumerSecret: String,
        oauthNonce: String,
        oauthSignatureMethod: String,
        oauthTimestamp: String,
        oauthToken: String,
        oauthTokenSecret: String,
        oauthVersion: String
    ): String = withContext(IO) {
        val algorithm = "HmacSHA1"
        val method = "GET"
        val url = BASE_URL + HOME_TIMELINE

        val signatureKey = createSignatureKey(
            oauthTokenSecret = oauthTokenSecret,
            oauthConsumerSecret = oauthConsumerSecret
        )

        val paramStr = (encode(CONSUMER_KEY) + "=" + encode(oauthConsumerKey) +
                    "&" + encode(NONCE) + "=" + encode(oauthNonce) +
                    "&" + encode(SIGNATURE_METHOD) + "=" + encode(oauthSignatureMethod) +
                    "&" + encode(TIMESTAMP) + "=" + encode(oauthTimestamp) +
                    "&" + encode(TOKEN) + "=" + encode(oauthToken) +
                    "&" + encode(VERSION) + "=" + encode(oauthVersion)
        ).replace("%2B", "+").replace("+", "%20").replace("%7E", "~")

        val signatureBaseStr = encode(method) + "&" + encode(url) + "&" + encode(paramStr)

        val signatureByte = createSignatureByte(
            algorithm = algorithm,
            signatureKey = signatureKey.toByteArray(),
            signatureBaseStr = signatureBaseStr.toByteArray()
        )

        Base64.encodeToString(signatureByte, Base64.NO_WRAP)
    }

    private fun encode(str: String): String = URLEncoder.encode(str,"utf-8")

    private fun createSignatureKey(
        oauthTokenSecret: String,
        oauthConsumerSecret: String
    ): String = "${encode(oauthConsumerSecret)}&${encode(oauthTokenSecret)}"

    private fun replaceParams(params: String): String = params.replace("%2B", "+").replace("+", "%20").replace("%7E", "~")
    private fun createSignatureByte(
        algorithm: String,
        signatureKey: ByteArray,
        signatureBaseStr: ByteArray
    ): ByteArray {
        val secretKeySpec = SecretKeySpec(signatureKey, algorithm)
        val mac = Mac.getInstance(algorithm)
        mac.init(secretKeySpec)
        mac.update(signatureBaseStr)
        return mac.doFinal()
    }
}