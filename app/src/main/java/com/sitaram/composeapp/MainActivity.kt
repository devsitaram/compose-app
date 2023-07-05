package com.sitaram.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.sitaram.composeapp.features.main.NavigationAppHost
import com.sitaram.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                // A surface container using the 'background' color from the theme
                installSplashScreen() // splash screen
                setContent {
                    val navController = rememberNavController()
                    NavigationAppHost(navController)
                }
            }
        }
    }
}