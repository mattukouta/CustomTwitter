package com.kouta.customtwitter.utils

object Destinations {
    const val LAUNCH_ROUTE = "launch"

    object Mobile {
        const val MOBILE_TWITTER_ROUTE = "mobileTwitter"

        object Navigation {
            const val HOME_PARENT_ROUTE = "homeParent"
            const val SEARCH_PARENT_ROUTE = "searchParent"
            const val NOTIFICATION_PARENT_ROUTE = "notificationParent"
            const val DIRECT_MAIL_PARENT_ROUTE = "directMailParent"
        }

        object Composable {
            const val HOME_TIME_LINE_ROUTE = "homeTimeLine"
            const val TWEET_DETAIL_ROUTE = "tweetDetail"
            const val SEARCH_ROUTE = "search"
            const val NOTIFICATION_ROUTE = "notification"
            const val DIRECT_MAIL_ROUTE = "directMail"
        }
    }
}