@file:OptIn(ExperimentalMaterial3Api::class)

package dev.jay.multiplebackstacks

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.jay.multiplebackstacks.ui.theme.MultipleBackStacksTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultipleBackStacksTheme {
                val rootNavController = rememberNavController()
                val navBackStackEntry by rootNavController.currentBackStackEntryAsState()
                Scaffold(bottomBar = {
                    NavigationBar {
                        items.forEach { item ->
                            val isSelected = item.title.lowercase() == navBackStackEntry?.destination?.route
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = {
                                    rootNavController.navigate(item.title.lowercase()) {
                                        popUpTo(rootNavController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                },
                                label = { Text(text = item.title) }
                            )
                        }
                    }
                }) {
                    NavHost(navController = rootNavController, startDestination = "home") {
                        composable("home") {
                            HomeNavHost()
                        }
                        composable("search") {
                            SearchNavHost()
                        }
                        composable("upload") {
                            UploadNavHost()
                        }
                        composable("create") {
                            CreateNavHost()
                        }
                        composable("account") {
                            AccountNavHost()
                        }
                    }
                }
            }
        }
    }
}