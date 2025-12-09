package com.example.mobilebank.navigation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebank.R

@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(containerColor = Color.White) {

        val items = listOf(
            Triple(Screen.Login.route, R.drawable.ic_home, "მთავარი"),
            Triple(Screen.Currency.route, R.drawable.ic_exchange, "ვალუტა"),
            Triple(Screen.Contact.route, R.drawable.ic_contact, "კონტაქტი")
        )

        items.forEach { item ->

            val selected = currentRoute == item.first

            val iconSize by animateFloatAsState(
                targetValue = if (selected) 28f else 22f,
                animationSpec = tween(180, easing = LinearOutSlowInEasing)
            )

            val textSize by animateFloatAsState(
                targetValue = if (selected) 13f else 11f,
                animationSpec = tween(180, easing = LinearOutSlowInEasing)
            )

            NavigationBarItem(
                selected = selected,
                onClick = {
                    onNavigate(item.first)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.second),
                        contentDescription = item.third,
                        modifier = Modifier.size(iconSize.dp),
                        tint = if (selected) Color(0xFF003EA8) else Color.Gray
                    )
                },
                label = {
                    Text(
                        text = item.third,
                        fontSize = textSize.sp,
                        color = if (selected) Color(0xFF003EA8) else Color.Gray
                    )
                }
            )
        }
    }
}
