package com.sitaram.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.sitaram.composeapp.features.intro.IntroSlider
import com.sitaram.composeapp.features.main.NavigationAppHost
import com.sitaram.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val getSharedPreferences = getSharedPreferences("selfPrefs", MODE_PRIVATE)
//        val hasIntroSlider: Boolean = getSharedPreferences.getBoolean("has_view_slider", false)

        setContent {
            ComposeAppTheme {
//                installSplashScreen() // splash screen
                val navController = rememberNavController()
                NavigationAppHost(navController)
            }
        }
    }
}