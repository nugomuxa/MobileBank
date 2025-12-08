package com.example.mobilebank.home

data class CardModel(
    val balance: Double,
    val currency: String = "₾",
    val cardName: String = "საბანკო ბარათი",
    val last4: String
)

data class HomeState(
    val availableBalance: Double = 0.0,
    val isBalanceHidden: Boolean = false,
    val cards: List<CardModel> = emptyList(),
    val selectedCardIndex: Int = 0
)
