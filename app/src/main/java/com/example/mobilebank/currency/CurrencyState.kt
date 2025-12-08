package com.example.mobilebank.currency

data class CurrencyState(
    val giveCurrency: String = "GEL",
    val receiveCurrency: String = "USD",
    val giveAmount: String = "",
    val receiveAmount: String = "",
    val giveExpanded: Boolean = false,
    val receiveExpanded: Boolean = false,
    val usdToGel: Double = 2.7050,
    val gelToUsd: Double = 2.7110
)
