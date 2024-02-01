package com.joincoded.bankapi.data.response

data class Transaction(
    val senderId: String,
    val receiverId: String,
    val amount: Double,
    val type: String
    )
