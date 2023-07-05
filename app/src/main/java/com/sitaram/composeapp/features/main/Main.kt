package com.sitaram.composeapp.features.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.sitaram.composeapp.features.game.GameScreen
import com.sitaram.composeapp.features.home.HomeScreen
import com.sitaram.composeapp.features.login.ViewOfLoginScreen
import com.sitaram.composeapp.features.message.MessageScreen
import com.sitaram.composeapp.features.navigation.ProfileScreen
import com.sitaram.composeapp.features.register.ViewOfSignUpScreen
import com.sitaram.composeapp.features.setting.SettingsScreen

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Login") {
        // login
        composable(User.Login.route) {
            ViewOfLoginScreen(navController)
        }

        // register page
        composable(User.Register.route) {
            ViewOfSignUpScreen(navController)
        }

        // main screen
        composable(User.Main.route) {
            ViewOfMainPage()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewOfMainPage() {
    val navController = rememberNavController()
    val items = listOf(ScreenItem.Home, ScreenItem.Profile, ScreenItem.Message, ScreenItem.Game, ScreenItem.Setting,)
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(modifier = Modifier.background(color = Color.White),
                        icon = {
                            Icon(
                                painterResource(screen.icon),
                                contentDescription = null,
                                // Set the desired icon color
                                tint = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                                    Color.Black
                                } else {
                                    Color.Gray
                                }
                            )
                        },
                        label = { Text(screen.route) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // selecting the same item
                                launchSingleTop = true
                                // Restore state when selecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = ScreenItem.Home.route, Modifier.padding(innerPadding)) {
            composable(ScreenItem.Home.route) { HomeScreen() }
            composable(ScreenItem.Profile.route) { ProfileScreen() }
            composable(ScreenItem.Message.route) { MessageScreen() }
            composable(ScreenItem.Game.route) { GameScreen() }
            composable(ScreenItem.Setting.route) { SettingsScreen() }
        }
    }
}