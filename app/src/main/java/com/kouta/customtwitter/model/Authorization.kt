package com.kouta.customtwitter.model

import com.kouta.customtwitter.utils.Params.OAuthKey.CONSUMER_KEY
import com.kouta.customtwitter.utils.Params.OAuthKey.NONCE
import com.kouta.customtwitter.utils.Params.OAuthKey.SIGNATURE
import com.kouta.customtwitter.utils.Params.OAuthKey.SIGNATURE_METHOD
import com.kouta.customtwitter.utils.Params.OAuthKey.TIMESTAMP
import com.kouta.customtwitter.utils.Params.OAuthKey.TOKEN
import com.kouta.customtwitter.utils.Params.OAuthKey.VERSION

data class Authorization(
    val oauthConsumerKey: String,
    val oauthNonce: String,
    val oauthSignature: String,
    val oauthSignatureMethod: String,
    val oauthTimestamp: String,
    val oauthToken: String,
    val oauthVersion: String
) {
    fun getAuthorizationStr(): String =
        "OAuth " +
            "$CONSUMER_KEY=\"$oauthConsumerKey\", " +
            "$NONCE=\"$oauthNonce\", " +
            "$SIGNATURE=\"$oauthSignature\", " +
            "$SIGNATURE_METHOD=\"$oauthSignatureMethod\", " +
            "$TIMESTAMP=\"$oauthTimestamp\", " +
            "$TOKEN=\"$oauthToken\", " +
            "$VERSION=\"$oauthVersion\""
}

//OAuth oauth_consumer_key="8ttsIBJqj4A5JgVCmySPSfc7F",oauth_nonce="re1sxnCWHc2n6RKMIo2OsLv79FNOUA23",oauth_signature="AoWK7Tbqu+167AvPo+i98ivlEi0=
//",oauth_signature_method="HMAC-SHA1",oauth_timestamp="1631661902",oauth_token="2444514930-NEab4MG5zUCnsSc6tU53ZyZmXXOlAKVzIvBvxy4",oauth_version="1.0"
