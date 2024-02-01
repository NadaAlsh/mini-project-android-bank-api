package com.joincoded.bankapi.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.joincoded.bankapi.network.BankApiService

@Composable
fun SigninScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var signinState by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = username, onValueChange = { username = it },
            label = { Text("Username:") })
    }
    TextField(value = password, onValueChange = { password = it },
        label = { Text("Password:") })

    TextField(value = signinState, onValueChange = { signinState = it },
        label = { Text("SigninState:") })

}