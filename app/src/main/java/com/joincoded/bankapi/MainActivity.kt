package com.joincoded.bankapi

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.joincoded.bankapi.composable.MyBankApp
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

                    MyBankApp()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BankAPITheme {
        Greeting("Android")
    }

}

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview
//@Composable
//fun HomeScreen() {
//    Scaffold(
////        bottomBar = {
////        BottomNavigationBar()
////    }
//    ) {
//            padding ->
//        Column (
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(padding)){
//
//            WalletSection()
//            CardsSection()
//            FinanceSection()
//            Spacer(modifier = Modifier.height(10.dp))
//            TransactionsSection()
//            //TransactionList()
//            //StatementCard("Deposit", "Fatma", 10.0, 2000.0, "1/31")
//        }
//    }
//}