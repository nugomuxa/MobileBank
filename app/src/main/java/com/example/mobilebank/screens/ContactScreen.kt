package com.example.mobilebank.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebank.R

@Composable
fun ContactScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6FA))
            .padding(top = 32.dp, bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "დახმარება",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(14.dp))

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            color = Color(0xFFE0E0E0),
            thickness = 1.dp
        )

        Spacer(modifier = Modifier.height(14.dp))


        Box(
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
                .background(Color(0xFFEAF3FF)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = null,
                tint = Color(0xFF2F80ED),
                modifier = Modifier.size(25.dp)
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "დაგვიკავშირდი",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "დაგვირეკე ნებისმიერ დროს",
            fontSize = 15.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(20.dp))


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0XFFFFFFFF))
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {


                Text(
                    text = "დაგვიკავშირდი",
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(18.dp))


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = null,
                        tint = Color(0xFF2F80ED),
                        modifier = Modifier.size(28.dp)
                    )


                    Text(
                        text = "+995 577 11 19 92",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )


                    Text(
                        text = "დაგვირეკე",
                        fontSize = 14.sp,
                        color = Color(0xFF2F80ED)
                    )
                }
            }
        }
    }
}
