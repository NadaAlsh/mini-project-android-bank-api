package com.joincoded.bankapi

import CardsSection
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.joincoded.bankapi.data.FinanceSection
import com.joincoded.bankapi.data.TransactionsSection
//import com.joincoded.bankapi.data.StatementCard
//import com.joincoded.bankapi.data.TransactionList
import com.joincoded.bankapi.data.WalletSection
import com.joincoded.bankapi.ui.theme.BankAPITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeScreen() {
    Scaffold(
//        bottomBar = {
//        BottomNavigationBar()
//    }
    ) {
        padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)){

            WalletSection()
            CardsSection()
            FinanceSection()
            Spacer(modifier = Modifier.height(10.dp))
            TransactionsSection()
            //TransactionList()
            //StatementCard("Deposit", "Fatma", 10.0, 2000.0, "1/31")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BankAPITheme {
//        Greeting("Android")
//    }
//}