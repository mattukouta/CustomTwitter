package com.kouta.customtwitter.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.kouta.customtwitter.utils.Destinations.Mobile.Navigation.DIRECT_MAIL_PARENT_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Navigation.HOME_PARENT_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Navigation.NOTIFICATION_PARENT_ROUTE
import com.kouta.customtwitter.utils.Destinations.Mobile.Navigation.SEARCH_PARENT_ROUTE

sealed class BottomNavigationItem(
    val route: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector
) {
    object Home: BottomNavigationItem(HOME_PARENT_ROUTE, Icons.Outlined.Home, Icons.Filled.Home)
    object Search: BottomNavigationItem(SEARCH_PARENT_ROUTE, Icons.Outlined.Search, Icons.Filled.Search)
    object Notification: BottomNavigationItem(NOTIFICATION_PARENT_ROUTE, Icons.Outlined.Notifications, Icons.Filled.Notifications)
    object DirectMail: BottomNavigationItem(DIRECT_MAIL_PARENT_ROUTE, Icons.Outlined.Email, Icons.Filled.Email )
}
