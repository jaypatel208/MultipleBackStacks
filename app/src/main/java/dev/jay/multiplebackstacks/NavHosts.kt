package dev.jay.multiplebackstacks

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeNavHost() {
    val homeNavController = rememberNavController()
    NavHost(navController = homeNavController, startDestination = "home1") {
        for (i in 1..10) {
            composable("home$i") {
                GeneralScreen(text = "Home $i", onNextClick = {
                    if (i < 10) homeNavController.navigate("home${i + 1}")
                })
            }
        }
    }
}

@Composable
fun SearchNavHost() {
    val searchNavController = rememberNavController()
    NavHost(navController = searchNavController, startDestination = "search1") {
        for (i in 1..10) {
            composable("search$i") {
                GeneralScreen(text = "Search $i", onNextClick = {
                    if (i < 10) searchNavController.navigate("search${i + 1}")
                })
            }
        }
    }
}

@Composable
fun UploadNavHost() {
    val uploadNavController = rememberNavController()
    NavHost(navController = uploadNavController, startDestination = "upload1") {
        for (i in 1..10) {
            composable("upload$i") {
                GeneralScreen(text = "Upload $i", onNextClick = {
                    if (i < 10) uploadNavController.navigate("upload${i + 1}")
                })
            }
        }
    }
}

@Composable
fun CreateNavHost() {
    val createNavController = rememberNavController()
    NavHost(navController = createNavController, startDestination = "create1") {
        for (i in 1..10) {
            composable("create$i") {
                GeneralScreen(text = "Create $i", onNextClick = {
                    if (i < 10) createNavController.navigate("create${i + 1}")
                })
            }
        }
    }
}

@Composable
fun AccountNavHost() {
    val accountNavController = rememberNavController()
    NavHost(navController = accountNavController, startDestination = "account1") {
        for (i in 1..10) {
            composable("account$i") {
                GeneralScreen(text = "Account $i", onNextClick = {
                    if (i < 10) accountNavController.navigate("account${i + 1}")
                })
            }
        }
    }
}