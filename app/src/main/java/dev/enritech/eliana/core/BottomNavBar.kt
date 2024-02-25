package dev.enritech.eliana.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController

sealed class BottomNavBarItem(val route: String, val icon: ImageVector, val label: String) {
    data object Home : BottomNavBarItem("home", Icons.Outlined.Home, "Home")
    data object Search : BottomNavBarItem("search", Icons.Outlined.Search, "Buscar")
}

@Composable
fun BottomNavBar(navigationController: NavHostController) {
    var selectedRoute by rememberSaveable { mutableStateOf(BottomNavBarItem.Home.route) }
    val routes = listOf<BottomNavBarItem>(BottomNavBarItem.Home, BottomNavBarItem.Search)
    NavigationBar {
        routes.forEach {
            NavigationBarItem(selected = it.route == selectedRoute,
                onClick = {
                    navigationController.navigate(it.route)
                    selectedRoute = it.route
                },
                icon = { Icon(imageVector = it.icon, contentDescription = it.label) }, label = {
                    Text(text = it.label)
                }
            )
        }
    }
}