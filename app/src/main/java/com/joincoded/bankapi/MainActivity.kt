package com.joincoded.bankapi

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
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joincoded.bankapi.composable.MyBankApp
import com.joincoded.bankapi.ui.theme.BankAPITheme
import com.joincoded.bankapi.viewmodel.BankViewModel

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
                    Greeting(name = "<^~^>")
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