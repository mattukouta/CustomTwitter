package com.kouta.customtwitter.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.kouta.customtwitter.model.BottomNavigationItem


@Composable
fun MobileTwitterBottomBar(
    navController: NavController = rememberNavController(),
    backStackEntry: NavBackStackEntry?,
    items: List<BottomNavigationItem> = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Search,
        BottomNavigationItem.Notification,
        BottomNavigationItem.DirectMail
    )
) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        items.forEachIndexed { index, item ->
            MobileTwitterBottomNavigationItem(
                item = item,
                selectedItem = backStackEntry?.destination?.parent?.route == item.route,
                index = index,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true

                    }
                }
            )
        }
    }
}

@Composable
fun RowScope.MobileTwitterBottomNavigationItem(
    item: BottomNavigationItem,
    selectedItem: Boolean,
    index: Int,
    onClick: () -> Unit = {}
) {
    BottomNavigationItem(
        icon = {
            if (selectedItem) Icon(item.selectedIcon, contentDescription = item.route)
            else Icon(item.icon, contentDescription = item.route)
        },
        selected = selectedItem,
        onClick = { onClick() }
    )
}
