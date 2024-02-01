//package com.joincoded.bankapi.composable
//
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import java.lang.reflect.Modifier
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//@Composable
//fun TopBar() {
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        contentAlignment = Alignment.CenterStart
//    ) {
//        // You can replace this with an actual profile icon
//        Icon(
//            imageVector = Icons.Default.Person,
//            contentDescription = "Profile Icon",
//            modifier = Modifier.size(40.dp)
//        )
//        Spacer(modifier = Modifier.width(16.dp))
//        Text(text = "Hello, Username", fontWeight = FontWeight.Bold)
//    }
//}