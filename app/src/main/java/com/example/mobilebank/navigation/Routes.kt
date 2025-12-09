package com.example.mobilebank.navigation

sealed class Screen(val route: String) {
    data object Login : Screen("login")
    data object Home : Screen("home")
    data object Currency : Screen("currency")
    data object Contact : Screen("contact")
}
