package com.kouta.customtwitter.utils

object Params {
    const val CALLBACK_URL = "callback://"
    const val BIT_SIZE = 32

    object SharedPreferencesKey {
        const val ACCESS_TOKEN = "access_token"
        const val ACCESS_TOKEN_SECRET = "access_token_secret"
    }

    object OAuthKey {
        const val CONSUMER_KEY = "oauth_consumer_key"
        const val NONCE = "oauth_nonce"
        const val SIGNATURE = "oauth_signature"
        const val SIGNATURE_METHOD = "oauth_signature_method"
        const val TIMESTAMP = "oauth_timestamp"
        const val TOKEN = "oauth_token"
        const val VERSION = "oauth_version"
        const val STATUS = "status"
        const val INCLUDE_ENTITIES = "include_entities"
    }
}