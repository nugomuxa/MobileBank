package com.example.mobilebank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mobilebank.navigation.MainScreen
import com.example.mobilebank.ui.theme.MobileBankTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MobileBankTheme {
                MainScreen()
            }
        }
    }
}
