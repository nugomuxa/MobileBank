package com.example.mobilebank.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.mobilebank.screens.LoginScreen
import com.example.mobilebank.screens.CurrencyScreen
import com.example.mobilebank.screens.ContactScreen

@Composable
fun MainScreen() {
    var selectedTab by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            LoginBottomNavBar(
                selectedItem = selectedTab,
                onItemClick = { selectedTab = it }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            when (selectedTab) {
                0 -> LoginScreen()
                1 -> CurrencyScreen()
                2 -> ContactScreen()
            }
        }
    }
}
