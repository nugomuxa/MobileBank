package com.example.mobilebank.currency

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilebank.R


@Composable
fun CurrencyScreen(viewModel: CurrencyViewModel = viewModel()) {

    val state = viewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "ვალუტის კურსები",
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 20.dp),
        )

        Divider(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            color = Color(0xFFE0E0E0),
            thickness = 1.dp
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF5F7FA), RoundedCornerShape(22.dp))
        ) {

            Column(modifier = Modifier.fillMaxWidth()) {


                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "გაიცემა",
                            fontSize = 18.sp,
                            color = Color(0xFF9AA0A6)
                        )

                        CurrencyDropdown(
                            currency = state.giveCurrency,
                            flag = if (state.giveCurrency == "GEL") R.drawable.flag_georgia else R.drawable.flag_usa,
                            expanded = state.giveExpanded,
                            onClick = { viewModel.toggleGiveExpanded(true) },
                            onDismiss = { viewModel.toggleGiveExpanded(false) },
                            onSelect = { viewModel.onGiveCurrencySelect(it) }
                        )
                    }

                    OutlinedTextField(
                        value = state.giveAmount,
                        onValueChange = { viewModel.onGiveAmountChange(it) },
                        placeholder = { Text("0.00") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                    )
                }


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                            .background(Color(0xFFE5E7EB))
                            .align(Alignment.Center)
                    )

                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(Color.White, RoundedCornerShape(50))
                            .align(Alignment.Center)
                            .clickable { viewModel.swapCurrencies() },
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.SwapVert,
                            contentDescription = null,
                            tint = Color(0xFF3B82F6),
                            modifier = Modifier.size(28.dp)
                        )
                    }
                }



                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "მიიღება",
                            fontSize = 18.sp,
                            color = Color(0xFF9AA0A6)
                        )

                        CurrencyDropdown(
                            currency = state.receiveCurrency,
                            flag = if (state.receiveCurrency == "GEL") R.drawable.flag_georgia else R.drawable.flag_usa,
                            expanded = state.receiveExpanded,
                            onClick = { viewModel.toggleReceiveExpanded(true) },
                            onDismiss = { viewModel.toggleReceiveExpanded(false) },
                            onSelect = { viewModel.onReceiveCurrencySelect(it) }
                        )
                    }

                    OutlinedTextField(
                        value = state.receiveAmount,
                        onValueChange = {},
                        placeholder = { Text("0.00") },
                        enabled = false,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp)
                    )
                }
            }
        }

        Divider(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 32.dp),
            color = Color(0xFFE0E0E0),
            thickness = 1.dp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "მობილური ბანკის კურსი   1$ = 2.7050₾", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "სტანდარტული კურსი        1$ = 2.7110₾", fontSize = 16.sp)
    }
}



@Composable
fun CurrencyDropdown(
    currency: String,
    flag: Int,
    expanded: Boolean,
    onClick: () -> Unit,
    onDismiss: () -> Unit,
    onSelect: (String) -> Unit
) {

    Box {
        Row(
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(40.dp))
                .clickable { onClick() }
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = flag),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = currency, fontSize = 17.sp)

            Spacer(modifier = Modifier.width(4.dp))

            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = null
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onDismiss() }
        ) {
            DropdownMenuItem(
                text = { Text("GEL") },
                onClick = { onSelect("GEL") }
            )
            DropdownMenuItem(
                text = { Text("USD") },
                onClick = { onSelect("USD") }
            )
        }
    }
}
