package com.joincoded.bankapi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joincoded.bankapi.data.AmountChange
import com.joincoded.bankapi.data.User
import com.joincoded.bankapi.data.response.TokenResponse
import com.joincoded.bankapi.network.BankApiService
import com.joincoded.bankapi.network.RetrofitHelper
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody

class BankViewModel : ViewModel() {
    private val apiService = RetrofitHelper.getInstance().create(BankApiService::class.java)
    var token: TokenResponse? by mutableStateOf(null)


    fun signup(username: String, password: String, image: String = "") {
        viewModelScope.launch {
            try {
                val response = apiService.signup(User(username, password, image, null, 0.0))
                token = response.body()
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun signin(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = apiService.signin(User(username, password, "", "null", 0.0))
                token = response.body()
            } catch (e: Exception) {
                println("ERROR $e")
            }
        }
    }

    fun deposit(amount: Double) {
        viewModelScope.launch {
            try {
                if (token != null) {
                    val response = apiService.deposit(
                        token?.getBearerToken(),
                        AmountChange(amount)
                    )
                } else {
                    println(" User not logged in!")
                }
            } catch (e: Exception) {
                println("ERROR $e")
            }
        }
    }

    fun withdraw(amount: Double) {
        viewModelScope.launch {
            try {
                if (token != null) {
                    //additional check for balance (assuming balance is part of token response
                    if (token?.balance ?: 0.0 >= amount) {
                        val response = apiService.withdraw(
                            token?.getBearerToken(),
                            AmountChange(amount)
                        )
                    } else {
                        println("Insufficient balance.")
                    }
                } else {
                    println(" User not logged in!")
                }
            } catch (e: Exception) {
                println("ERROR $e")
            }
        }
    }

    fun transfer(amount: Double, targetUserName: String) {
        viewModelScope.launch {
            try {
                if (token != null) {
                    // Perform additional check for balance sufficiency
                    if (token?.balance ?: 0.0 >= amount) {
                        val response = apiService.transfer(
                            token?.getBearerToken(),
                            targetUserName,
                            AmountChange(amount)
                        )
                        // Handle response as needed
                    } else {
                        // Handle insufficient balance
                        println("Insufficient balance.")
                    }
                } else {
                    // Handle not logged in
                    println("User not logged in.")
                }
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun updateProfile(username: String, password: String, image: MultipartBody.Part?) {
        viewModelScope.launch {
            try {
                if (token != null) {
                    val usernameBody = RequestBody.create(okhttp3.MultipartBody.FORM, username)
                    val passwordBody = RequestBody.create(okhttp3.MultipartBody.FORM, password)

                    val response = apiService.updateProfile(
                        token?.getBearerToken(),
                        usernameBody,
                        passwordBody,
                        image
                    )
                    // Handle response as needed
                } else {
                    // Handle not logged in
                    println("User not logged in.")
                }
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }

    fun getTransactions() {
        viewModelScope.launch {
            try {
                if (token != null) {
                    val response = apiService.getTransactions(token?.getBearerToken())
                    val transactions = response.body()
                    // Handle transactions as needed
                } else {
                    // Handle not logged in
                    println("User not logged in.")
                }
            } catch (e: Exception) {
                println("Error $e")
            }
        }
    }
}

