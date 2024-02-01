package com.joincoded.bankapi.data.response

data class TransactionResponse(
    val senderId: String,
    val receiverId: String,
    val amount: Double,
    //val type: String
    )
