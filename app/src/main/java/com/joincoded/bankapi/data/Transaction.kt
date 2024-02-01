package com.joincoded.bankapi.data

data class Transaction(

    var transactionType: String,
    var accountName: String,
    var amount: Double,
    var balance: Double,
    var date: String,


    )