package com.joincoded.bankapi.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.joincoded.bankapi.viewmodel.BankViewModel

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyBankApp() {
    Scaffold(
        topBar = { TopBar() },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                CardsSection()
                FinanceSection()
                OffersSection()
                TransactionsSection()
                //HomeScreen(navController = rememberNavController())
            }
        }

    )
}

@Preview
@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color.LightGray, shape = RoundedCornerShape(18.dp)),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Profile Icon",
                modifier = Modifier.size(30.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Hi Fatma", fontWeight = FontWeight.Bold)
        }
    }
}

@Preview
@Composable
fun CardsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 28.dp)
    ) {
        CardItem(
            cardType = "Visa",
            cardDetails = "Cardholder: John Doe\nCard Number: ** ** ** 1234\nExpiry Date: 12/24"
        )
        Spacer(modifier = Modifier.height(4.dp))
        CardItem(
            cardType = "MasterCard",
            cardDetails = "Cardholder: Jane Doe\nCard Number: ** ** ** 5678\nExpiry Date: 05/23"
        )
    }
}

@Composable
fun CardItem(cardType: String, cardDetails: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = cardType, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = cardDetails)
        }
    }
}

@Preview
@Composable
fun FinanceSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        FinanceItem("Deposit")
        Spacer(modifier = Modifier.height(16.dp))
        FinanceItem("Withdraw")
        Spacer(modifier = Modifier.height(16.dp))
        FinanceItem("Transfer")
    }
}

@Composable
fun FinanceItem(type: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = type,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun OffersSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        OfferItem("Offer 1")
        Spacer(modifier = Modifier.height(16.dp))
        OfferItem("Offer 2")
        Spacer(modifier = Modifier.height(16.dp))
        OfferItem("Offer 3")
    }
}

@Composable
fun OfferItem(offerName: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = offerName,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun TransactionsSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        TransactionItem("John Doe", "2022-02-01", "Deposit", "$100", "$500")
        Spacer(modifier = Modifier.height(16.dp))
        TransactionItem("Jane Doe", "2022-02-02", "Withdraw", "$50", "$450")
        Spacer(modifier = Modifier.height(16.dp))
        TransactionItem("Bob Smith", "2022-02-03", "Transfer", "$30", "$420")
    }
}

@Composable
fun TransactionItem(name: String, date: String, type: String, amount: String, balance: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Name: $name")
            Text(text = "Date: $date")
            Text(text = "Type: $type")
            Text(text = "Amount: $amount")
            Text(text = "Balance: $balance")
        }
    }
}
//
//@Composable
//fun HomeScreen(navController: NavHostController) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(text = "Welcome to Your SOS Bank")
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                navController.navigate("deposit")
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Text(text = "Deposit Funds")
//        }
//
//        Button(
//            onClick = {
//                navController.navigate("withdraw")
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Text(text = "Withdraw Funds")
//        }
//
//        Button(
//            onClick = {
//                navController.navigate("transfer")
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Text(text = "Transfer Funds")
//        }
//
//        Button(
//            onClick = {
//                navController.navigate("profile")
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        ) {
//            Text(text = "View Profile")
//        }
//    }
//}
