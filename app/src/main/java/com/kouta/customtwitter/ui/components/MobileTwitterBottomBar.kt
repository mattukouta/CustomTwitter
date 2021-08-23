package com.kouta.customtwitter.ui.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.kouta.customtwitter.model.BottomNavigationItem


@Composable
fun MobileTwitterBottomBar(
    items: List<BottomNavigationItem> = listOf(
        BottomNavigationItem.Home,
        BottomNavigationItem.Search,
        BottomNavigationItem.Notification,
        BottomNavigationItem.DirectMail
    )
) {
    val selectedItem = remember { mutableStateOf(0) }
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background
    ) {
        items.forEachIndexed { index, item ->
            MobileTwitterBottomNavigationItem(
                item = item,
                selectedItem = selectedItem,
                index = index,
                onClick = { selectedItem.value = index }
            )
        }
    }
}

@Composable
fun RowScope.MobileTwitterBottomNavigationItem(
    item: BottomNavigationItem,
    selectedItem: MutableState<Int>,
    index: Int,
    onClick: () -> Unit = {}
) {
    BottomNavigationItem(
        label = {  },
        icon = {
            if (selectedItem.value == index) Icon(item.selectedIcon, contentDescription = item.label)
            else Icon(item.icon, contentDescription = item.label)
        },
        selected = selectedItem.value == index,
        onClick = { onClick() }
    )
}
