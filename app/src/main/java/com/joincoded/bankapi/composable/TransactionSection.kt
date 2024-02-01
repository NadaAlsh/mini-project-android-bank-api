//package com.joincoded.bankapi.composable
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.unit.dp
//import java.lang.reflect.Modifier
//
//@Composable
//fun TransactionsSection() {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 16.dp)
//    ) {
//        TransactionItem("John Doe", "2022-02-01", "Deposit", "$100", "$500")
//        Spacer(modifier = Modifier.height(16.dp))
//        TransactionItem("Jane Doe", "2022-02-02", "Withdraw", "$50", "$450")
//        Spacer(modifier = Modifier.height(16.dp))
//        TransactionItem("Bob Smith", "2022-02-03", "Transfer", "$30", "$420")
//    }
//}