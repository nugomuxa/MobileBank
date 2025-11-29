package com.example.mobilebank.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebank.R
import com.example.mobilebank.ui.theme.WelcomeColor
import com.example.mobilebank.ui.theme.ButtonColor
import com.example.mobilebank.ui.theme.ButtonTextColor
import com.example.mobilebank.ui.theme.InputFocused
import com.example.mobilebank.ui.theme.InputUnfocused
import com.example.mobilebank.ui.theme.InputError

@Composable
fun LoginScreen() {

    val focusManager = LocalFocusManager.current

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var usernameTouched by remember { mutableStateOf(false) }
    var passwordTouched by remember { mutableStateOf(false) }
    var passwordVisible by remember { mutableStateOf(false) }


    val isUsernameValid = username.firstOrNull()?.isUpperCase().orDefaultFalse()
    val isPasswordValid = password.length >= 6 && password.any { it.isUpperCase() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                focusManager.clearFocus()
            }
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.bank_logo),
            contentDescription = "logo",
            modifier = Modifier.size(100.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(24.dp))


        Text(
            text = "Welcome",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            color = WelcomeColor
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { newValue ->
                username = newValue.take(15)
                usernameTouched = true
            },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,

            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = InputFocused,
                unfocusedIndicatorColor = InputUnfocused,
                errorIndicatorColor = InputError,
                cursorColor = InputFocused,
                focusedLabelColor = InputFocused,
                unfocusedLabelColor = InputUnfocused,
                errorLabelColor = InputError
            ),

            isError = usernameTouched && !isUsernameValid
        )

        if (usernameTouched && !isUsernameValid) {
            Text(
                text = "გთხოვთ პირველი ასო იყოს დიდი",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))


        OutlinedTextField(
            value = password,
            onValueChange = { newValue ->
                password = newValue.take(15)
                passwordTouched = true
            },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,

            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),

            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility
                        else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },

            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = InputFocused,
                unfocusedIndicatorColor = InputUnfocused,
                errorIndicatorColor = InputError,
                cursorColor = InputFocused,
                focusedLabelColor = InputFocused,
                unfocusedLabelColor = InputUnfocused,
                errorLabelColor = InputError
            ),

            isError = passwordTouched && !isPasswordValid
        )

        if (passwordTouched && !isPasswordValid) {
            Text(
                text = "შეიყვანეთ მინიმუმ 6 ასო, აქედან ერთი დიდი ასო",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 4.dp, top = 4.dp)
            )
        }



        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { focusManager.clearFocus() },
            enabled = isUsernameValid && isPasswordValid,
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonColor,
                contentColor = ButtonTextColor
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Login", fontSize = 20.sp)
        }
    }
}

fun Boolean?.orDefaultFalse(): Boolean = this ?: false
