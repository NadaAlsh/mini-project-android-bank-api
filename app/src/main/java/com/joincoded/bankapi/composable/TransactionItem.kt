//package com.joincoded.bankapi.composable
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.unit.dp
//import java.lang.reflect.Modifier
//
//@Composable
//fun TransactionItem(name: String, date: String, type: String, amount: String, balance: String) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        ) {
//            Text(text = "Name: $name")
//            Text(text = "Date: $date")
//            Text(text = "Type: $type")
//            Text(text = "Amount: $amount")
//            Text(text = "Balance: $balance")
//        }
//    }
//}