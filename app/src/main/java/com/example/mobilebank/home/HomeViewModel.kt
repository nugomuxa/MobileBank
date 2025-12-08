package com.example.mobilebank.home

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _state = mutableStateOf(
        HomeState(
            availableBalance = 53.64,
            cards = listOf(
                CardModel(balance = 53.64, last4 = "7777"),
                CardModel(balance = 120.50, last4 = "4444"),
                CardModel(balance = 1343.50, last4 = "5555")
            )
        )
    )
    val state: State<HomeState> = _state

    fun toggleBalanceVisibility() {
        _state.value = _state.value.copy(
            isBalanceHidden = !_state.value.isBalanceHidden
        )
    }

    fun onCardChanged(newIndex: Int) {
        val cards = _state.value.cards
        if (cards.isEmpty()) return

        val safeIndex = newIndex.coerceIn(0, cards.size - 1)

        _state.value = _state.value.copy(
            selectedCardIndex = safeIndex
        )
    }


}
