//package com.joincoded.bankapi.composable
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.material3.Card
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import java.lang.reflect.Modifier
//
//@Composable
//fun CardItem(cardType: String, cardDetails: String) {
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
//            Text(text = cardType, fontWeight = FontWeight.Bold)
//            Spacer(modifier = Modifier.height(8.dp))
//            Text(text = cardDetails)
//        }
//    }
//}