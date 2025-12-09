package com.example.mobilebank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobilebank.login.LoginScreen
import com.example.mobilebank.home.HomeScreen
import com.example.mobilebank.currency.CurrencyScreen
import com.example.mobilebank.contact.ContactScreen

@Composable
fun AppNavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {

        // LOGIN SCREEN
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        launchSingleTop = true
                    }
                }
            )
        }

        // HOME SCREEN
        composable(Screen.Home.route) {
            HomeScreen()
        }

        // CURRENCY SCREEN
        composable(Screen.Currency.route) {
            CurrencyScreen()
        }

        // CONTACT SCREEN
        composable(Screen.Contact.route) {
            ContactScreen()
        }
    }
}
