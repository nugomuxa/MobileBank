package com.example.mobilebank.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobilebank.R
import com.example.mobilebank.ui.theme.*

@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {

    val state = viewModel.state.value
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { focusManager.clearFocus() }
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
            value = state.username,
            onValueChange = { viewModel.onUsernameChange(it) },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            isError = state.usernameTouched && !state.isUsernameValid,
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = InputFocused,
                unfocusedIndicatorColor = InputUnfocused,
                errorIndicatorColor = InputError
            )
        )

        if (state.usernameTouched && !state.isUsernameValid) {
            Text(
                text = "გთხოვთ პირველი ასო იყოს დიდი",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = state.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            isError = state.passwordTouched && !state.isPasswordValid,
            visualTransformation =
                if (state.passwordVisible) VisualTransformation.None
                else PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = { viewModel.togglePasswordVisibility() }) {
                    Icon(
                        imageVector = if (state.passwordVisible) Icons.Default.Visibility
                        else Icons.Default.VisibilityOff,
                        contentDescription = null
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = InputFocused,
                unfocusedIndicatorColor = InputUnfocused,
                errorIndicatorColor = InputError
            )
        )

        if (state.passwordTouched && !state.isPasswordValid) {
            Text(
                text = "შეიყვანეთ მინიმუმ 6 ასო, აქედან ერთი დიდი ასო",
                color = Color.Red,
                fontSize = 14.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = { focusManager.clearFocus() },
            enabled = state.isFormValid,
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
