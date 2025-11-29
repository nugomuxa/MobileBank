package com.example.mobilebank.navigation

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.mobilebank.R

@Composable
fun LoginBottomNavBar(
    selectedItem: Int,
    onItemClick: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 0.dp
    ) {




        NavigationBarItem(
            selected = selectedItem == 0,
            onClick = { onItemClick(0) },
            icon = {

                val iconSize by animateFloatAsState(
                    targetValue = if (selectedItem == 0) 28f else 22f,
                    animationSpec = tween(
                        durationMillis = 180,
                        easing = LinearOutSlowInEasing
                    )
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "მთავარი",
                    modifier = Modifier.size(iconSize.dp),
                    tint = if (selectedItem == 0) Color(0xFF003EA8) else Color.Gray
                )
            },
            label = {

                val textSize by animateFloatAsState(
                    targetValue = if (selectedItem == 0) 13f else 11f,
                    animationSpec = tween(
                        durationMillis = 180,
                        easing = LinearOutSlowInEasing
                    )
                )

                Text(
                    text = "მთავარი",
                    fontSize = textSize.sp,
                    color = if (selectedItem == 0) Color(0xFF003EA8) else Color.Gray
                )
            }
        )




        NavigationBarItem(
            selected = selectedItem == 1,
            onClick = { onItemClick(1) },
            icon = {

                val iconSize by animateFloatAsState(
                    targetValue = if (selectedItem == 1) 28f else 22f,
                    animationSpec = tween(
                        durationMillis = 180,
                        easing = LinearOutSlowInEasing
                    )
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_exchange),
                    contentDescription = "ვალუტის კურსი",
                    modifier = Modifier.size(iconSize.dp),
                    tint = if (selectedItem == 1) Color(0xFF003EA8) else Color.Gray
                )
            },
            label = {

                val textSize by animateFloatAsState(
                    targetValue = if (selectedItem == 1) 13f else 11f,
                    animationSpec = tween(
                        durationMillis = 180,
                        easing = LinearOutSlowInEasing
                    )
                )

                Text(
                    text = "ვალუტის კურსი",
                    fontSize = textSize.sp,
                    color = if (selectedItem == 1) Color(0xFF003EA8) else Color.Gray
                )
            }
        )




        NavigationBarItem(
            selected = selectedItem == 2,
            onClick = { onItemClick(2) },
            icon = {

                val iconSize by animateFloatAsState(
                    targetValue = if (selectedItem == 2) 28f else 22f,
                    animationSpec = tween(
                        durationMillis = 180,
                        easing = LinearOutSlowInEasing
                    )
                )

                Icon(
                    painter = painterResource(id = R.drawable.ic_contact),
                    contentDescription = "კონტაქტები",
                    modifier = Modifier.size(iconSize.dp),
                    tint = if (selectedItem == 2) Color(0xFF003EA8) else Color.Gray
                )
            },
            label = {

                val textSize by animateFloatAsState(
                    targetValue = if (selectedItem == 2) 13f else 11f,
                    animationSpec = tween(
                        durationMillis = 180,
                        easing = LinearOutSlowInEasing
                    )
                )

                Text(
                    text = "კონტაქტები",
                    fontSize = textSize.sp,
                    color = if (selectedItem == 2) Color(0xFF003EA8) else Color.Gray
                )
            }
        )
    }
}
