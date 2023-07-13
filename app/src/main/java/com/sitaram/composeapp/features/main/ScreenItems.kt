package com.sitaram.composeapp.features.main

import com.sitaram.composeapp.R

sealed class User(var route: String) {
    object Slider : User("Slider")
    object Login : User("Login")
    object Register : User("Register")
    object Main: User("Main")
}

sealed class ScreenItem(var icon: Int, var route: String) {
    object Home : ScreenItem(R.drawable.ic_home, "Home")
    object Profile : ScreenItem(R.drawable.ic_person, "Profile")
    object Message : ScreenItem(R.drawable.ic_message, "Message")
    object Game : ScreenItem(R.drawable.ic_game, "Game")
    object Setting : ScreenItem(R.drawable.ic_setting, "Setting")
}