package com.example.mobilebank.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {

    val state by viewModel.state

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6FA))
            .padding(horizontal = 20.dp)
            .padding(top = 55.dp)
    ) {

        // HEADER

        Text(
            text = "მთავარი",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "მოგესალმებით, ნუგო 👋",
                fontSize = 15.sp,
                color = Color.DarkGray
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        // BALANCE

        Text(
            text = "ხელმისაწვდომი თანხა",
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(6.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {

            Text(
                text = if (state.isBalanceHidden) "••••" else "${state.availableBalance} ₾",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector = if (state.isBalanceHidden) Icons.Default.Visibility
                else Icons.Default.VisibilityOff,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.clickable { viewModel.toggleBalanceVisibility() }
            )
        }

        Spacer(modifier = Modifier.height(28.dp))

        // REAL CAROUSEL (PAGER)

        val pagerState = rememberPagerState(pageCount = { state.cards.size })

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp),
            contentPadding = PaddingValues(horizontal = 10.dp),
            pageSpacing = 8.dp
        ) { page ->
            val card = state.cards[page]

            CardItem(
                amount = "${card.balance} ₾",
                lastDigits = card.last4,
                background = Color(0xFF0D47A1)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // ACTION BUTTONS

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            ActionButton(
                title = "საკუთარ ანგარიშზე",
                background = Color(0xFFDDEAFF),
                textColor = Color(0xFF003EA8),
                modifier = Modifier.weight(1f)
            )

            ActionButton(
                title = "სხვასთან გადარიცხვა",
                background = Color(0xFFFFE7D6),
                textColor = Color(0xFFE16A00),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// CARD ITEM COMPOSABLE

@Composable
fun CardItem(amount: String, lastDigits: String, background: Color) {
    Column(
        modifier = Modifier
            .fillMaxWidth(0.85f)
            .height(110.dp)
            .background(background, RoundedCornerShape(18.dp))
            .padding(14.dp)
    ) {
        Text(
            text = amount,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "•••• $lastDigits",
            fontSize = 16.sp,
            color = Color.White.copy(alpha = 0.85f)
        )
    }
}

// ACTION BUTTONS

@Composable
fun ActionButton(
    title: String,
    background: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(70.dp)
            .background(background, RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = textColor,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
