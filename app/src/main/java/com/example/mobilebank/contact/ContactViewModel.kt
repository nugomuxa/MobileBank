package com.example.mobilebank.contact

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel

class ContactViewModel : ViewModel() {

    private val _state = mutableStateOf(ContactState())
    val state: State<ContactState> = _state

    //  ლოგიკა არ გვაქვს ჯერ-ჯერობით <3.
}
