package com.example.mobilebank.currency

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class CurrencyViewModel : ViewModel() {

    private val _state = mutableStateOf(CurrencyState())
    val state: State<CurrencyState> = _state

    fun onGiveAmountChange(value: String) {
        _state.value = _state.value.copy(giveAmount = value)
        calculate()
    }

    fun onGiveCurrencySelect(currency: String) {
        _state.value = _state.value.copy(giveCurrency = currency, giveExpanded = false)
        calculate()
    }

    fun onReceiveCurrencySelect(currency: String) {
        _state.value = _state.value.copy(receiveCurrency = currency, receiveExpanded = false)
        calculate()
    }

    fun toggleGiveExpanded(expanded: Boolean) {
        _state.value = _state.value.copy(giveExpanded = expanded)
    }

    fun toggleReceiveExpanded(expanded: Boolean) {
        _state.value = _state.value.copy(receiveExpanded = expanded)
    }

    fun swapCurrencies() {
        val s = _state.value
        _state.value = s.copy(
            giveCurrency = s.receiveCurrency,
            receiveCurrency = s.giveCurrency,
            giveAmount = s.receiveAmount,
            receiveAmount = s.giveAmount
        )
        calculate()
    }

    private fun calculate() {
        val s = _state.value
        val amount = s.giveAmount.toDoubleOrNull() ?: 0.0

        val result = when {
            s.giveCurrency == "USD" && s.receiveCurrency == "GEL" ->
                amount * s.usdToGel

            s.giveCurrency == "GEL" && s.receiveCurrency == "USD" ->
                amount / s.gelToUsd

            else -> amount
        }

        _state.value = s.copy(
            receiveAmount = String.format("%.2f", result)
        )
    }
}
