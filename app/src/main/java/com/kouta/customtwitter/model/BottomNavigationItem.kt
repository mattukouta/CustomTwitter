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

sealed class BottomNavigationItem(
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector
) {
    object Home: BottomNavigationItem("Home", Icons.Outlined.Home, Icons.Filled.Home)
    object Search: BottomNavigationItem("Search", Icons.Outlined.Search, Icons.Filled.Search)
    object Notification: BottomNavigationItem("Notification", Icons.Outlined.Notifications, Icons.Filled.Notifications)
    object DirectMail: BottomNavigationItem("DirectMail", Icons.Outlined.Email, Icons.Filled.Email )
}
