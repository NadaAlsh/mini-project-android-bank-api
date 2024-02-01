package com.joincoded.bankapi.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.joincoded.bankapi.data.Card
import com.joincoded.bankapi.ui.theme.Purple40
import com.joincoded.bankapi.ui.theme.Purple80
import androidx.compose.ui.graphics.Color
import com.joincoded.bankapi.R
import com.joincoded.bankapi.data.Finance
import com.joincoded.bankapi.data.Offer
import com.joincoded.bankapi.data.financeList
import com.joincoded.bankapi.ui.theme.PurpleGrey40
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

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 123.4,
        color = getGradient(Purple40, Purple80),
        details = "Cardholder: John Doe\nCard Number: ** ** ** 1234\nExpiry Date: 12/24"
    ),
    Card(
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 123.4,
        color = getGradient(PurpleGrey40, Purple80),
        details = "Cardholder: John Doe\nCard Number: ** ** ** 1234\nExpiry Date: 12/24"
    ),Card(
        cardType = "VISA",
        cardNumber = "3664 7865 3786 3976",
        cardName = "Business",
        balance = 123.4,
        color = getGradient(PurpleGrey40, Purple80),
        details = "Cardholder: John Doe\nCard Number: ** ** ** 1234\nExpiry Date: 12/24"
    ))
fun getGradient(
    startColor: Color,
    endColor: Color,
): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}
@Preview
@Composable
fun CardsSection() {
    LazyRow(//row
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 28.dp)
    ) {
        items(cards){ item ->
            CardItem(cardType = item.cardName, cardDetails = item.details, color = item.color)
            Spacer(modifier = Modifier.height(16.dp))
        }
        }
}

@Composable
fun CardItem(cardType: String, cardDetails: String, color: Brush) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(//row
            modifier = Modifier
                .fillMaxSize()
                .background(color)
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
    Column {
        Text(text = "Finance",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )}
    val financeList = listOf(
        Finance(
            icon = Icons.Rounded.ExitToApp,
            name = "Withdraw",
            background = Color.Blue
        ),
        Finance(
            icon = Icons.Rounded.AddCircle,
            name = "Deposit",
            background = Color.Green
        ),
        Finance(
            icon = Icons.Rounded.Send,
            name = "Transfer",
            background = Color.Yellow
        )
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        items(financeList) {
            FinanceItem("Deposit",it)
            Spacer(modifier = Modifier.height(16.dp))
            FinanceItem("Withdraw", it)
            Spacer(modifier = Modifier.height(16.dp))
            FinanceItem("Transfer", it)
        }
    }
}

@Composable
fun FinanceItem(type: String, finance: Finance) {
    Column(
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
        Text(text = type, fontWeight = FontWeight.Bold, fontSize = 18.sp, modifier = Modifier.padding(16.dp))

        Box(modifier = Modifier.padding(16.dp)) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(25.dp))
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .size(120.dp)
                    .clickable { }
                    .padding(13.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(finance.background)
                    .padding(6.dp)
                ){
                    Icon(
                        imageVector = finance.icon,
                        contentDescription = finance.name,
                        tint = Color.White
                    )
                }
                Text(text = finance.name,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )

            }
        }
    }

    }

@Preview
@Composable
fun OffersSection() {//+image,size
    Column {
        Text(text = "Offers",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )}
    val offersList = listOf(
        Offer(
            icon = R.drawable.pick,
            name = "Pick",
            background = Color.Blue
        ),
        Offer(
            icon = R.drawable.sparkgym,
            name = "Spark Gym",
            background = Color.Green
        ),
        Offer(
            icon = R.drawable.kuwaitairways ,
            name = "Kuwait Airways",
            background = Color.Yellow
        )
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        items(offersList.size) {
            OfferItem("Pick")
            Spacer(modifier = Modifier.height(16.dp))
            OfferItem("Spark Gym")
            Spacer(modifier = Modifier.height(16.dp))
            OfferItem("Kuwait Airways")

        }
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
