package com.example.app.components

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.app.GmailApp
import com.example.app.Meet

@Composable
fun HomeBottomMenu(navController: NavController) {
    val items = listOf(BottomMenuData.Mail, BottomMenuData.Meet)
    val currentBackStackEntry by navController.currentBackStackEntryFlow.collectAsState(initial = navController.currentBackStackEntry)
    val currentRoute = currentBackStackEntry?.destination?.route

    NavigationBar {
        items.forEach {
            NavigationBarItem(
                selected = (currentRoute == it.route),
                onClick = { if (currentRoute != it.route) {
                    navController.navigate(it.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    } } },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title)},)
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BottomMenuData.Mail.route) {
        composable(BottomMenuData.Mail.route) {
            GmailApp(navController)
        }
        composable(BottomMenuData.Meet.route) {
            Meet(navController)
        }
    }
}

sealed class BottomMenuData(val route: String, val icon: ImageVector, val title: String) {
    data object Mail: BottomMenuData(route = "mail", icon = Icons.Outlined.Mail, title = "Mail")
    data object Meet: BottomMenuData(route = "meet", icon = Icons.Outlined.Videocam, title = "Meet")
}