package com.example.mobilebank.login

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    fun onUsernameChange(newValue: String) {
        _state.value = _state.value.copy(
            username = newValue.take(15),
            usernameTouched = true
        )
    }

    fun onPasswordChange(newValue: String) {
        _state.value = _state.value.copy(
            password = newValue.take(15),
            passwordTouched = true
        )
    }

    fun togglePasswordVisibility() {
        _state.value = _state.value.copy(
            passwordVisible = !_state.value.passwordVisible
        )
    }
}
