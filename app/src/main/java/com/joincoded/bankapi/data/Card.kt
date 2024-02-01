package com.joincoded.bankapi.data

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

data class Card(
    val cardType: String,
    val cardNumber: String,
    val cardName: String,
    val color: Brush,
    var balance: Double,
    var details: String
)
