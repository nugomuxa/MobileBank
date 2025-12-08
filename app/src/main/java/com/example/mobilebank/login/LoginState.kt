package com.example.mobilebank.login

data class LoginState(
    val username: String = "",
    val password: String = "",
    val usernameTouched: Boolean = false,
    val passwordTouched: Boolean = false,
    val passwordVisible: Boolean = false
) {
    val isUsernameValid: Boolean
        get() = username.isNotEmpty() && username.first().isUpperCase()

    val isPasswordValid: Boolean
        get() = password.length >= 6 && password.any { it.isUpperCase() }

    val isFormValid: Boolean
        get() = isUsernameValid && isPasswordValid
}
