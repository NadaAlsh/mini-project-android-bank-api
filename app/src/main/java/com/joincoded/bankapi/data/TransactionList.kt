package com.joincoded.bankapi.data

import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import com.joincoded.bankapi.ui.theme.BankAPITheme

//
//import androidx.compose.animation.animateContentSize
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.BoxWithConstraints
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.rounded.KeyboardArrowDown
//import androidx.compose.material.icons.rounded.KeyboardArrowUp
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.Icon
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.Dp
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import com.joincoded.bankapi.ui.theme.BankAPITheme
//
//
@Composable
fun StatementCard(
transactionType: String,
accountName: String,
amount: Double,
balance: Double,
date: String,
modifier: Modifier = Modifier,

){

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(15.dp),
        color = transactions
       // color = CardDefaults.cardColors(containerColor =
       // MaterialTheme.colorScheme.primaryContainer
        )
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Column {
                Text(text = "$accountName Account ")
                Text(text = "$date")
            }
            Text(text = "$transactionType")

            Column {
                Text(text = "$amount KWD")
                Text(text = "$balance KWD")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatementCardPreview() {
    BankAPITheme {
        StatementCard(
            transactionType = "Deposit",
            accountName = "Saving",
            amount = 15.0,
            balance = 30.5,
            date = "1/23"
        )
    }
}

//@Preview
//@Composable
//fun TransactionList(){
//    var isVisible by remember {
//        mutableStateOf(false)
//    }
//    var iconState by remember {
//        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
//    }
//
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(top = 32.dp),
//            contentAlignment = Alignment.BottomCenter
//    )
//    Column {
//        Text(text = "Transactions",
//            fontSize = 24.sp,
//            color = MaterialTheme.colorScheme.onBackground,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(16.dp)
//        ){
//            Column(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
//                    .background(MaterialTheme.colorScheme.inverseOnSurface)
//                    .animateContentSize()
//            ) {
//
//                Row(
//                    modifier = Modifier
//                        .padding(16.dp)
//                        .animateContentSize()
//                        .fillMaxWidth(),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//
//                    Box(modifier = Modifier
//                        .clip(CircleShape)
//                        .background(MaterialTheme.colorScheme.secondary)
//                        .clickable {
//                            isVisible = !isVisible
//                            iconState = if (isVisible) {
//                                Icons.Rounded.KeyboardArrowUp
//                            } else {
//                                Icons.Rounded.KeyboardArrowDown
//                            }
//                        }
//                    ) {
//                        Icon(
//                            modifier = Modifier.size(25.dp),
//                            imageVector = iconState,
//                            contentDescription = "Currencies",
//                            tint = MaterialTheme.colorScheme.onSecondary
//                        )
//                    }
//
//                    Spacer(modifier = Modifier.width(20.dp))
//
//                    Text(
//                        text = "Currencies",
//                        fontSize = 20.sp,
//                        color = MaterialTheme.colorScheme.onSecondaryContainer,
//                        fontWeight = FontWeight.Bold
//                    )
//
//                }
//
//                Spacer(
//                    modifier = Modifier
//                        .height(1.dp)
//                        .fillMaxWidth()
//                        .background(MaterialTheme.colorScheme.secondaryContainer)
//                )
//
//                if (isVisible) {
//                    BoxWithConstraints(
//                        modifier = Modifier
//                            .fillMaxSize()
//                            .padding(horizontal = 16.dp)
//                            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
//                            .background(MaterialTheme.colorScheme.background)
//                    ) {
//
//                        val boxWithConstraintsScope = this
//                        val width = boxWithConstraintsScope.maxWidth / 3
//
//                        Column(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(horizontal = 16.dp)
//                        ) {
//
//                            Spacer(modifier = Modifier.height(16.dp))
//
//                            Row(
//                                modifier = Modifier.fillMaxWidth()
//                            ) {
//
//                                Text(
//                                    modifier = Modifier.width(width),
//                                    text = "Currency",
//                                    fontWeight = FontWeight.SemiBold,
//                                    fontSize = 16.sp,
//                                    color = MaterialTheme.colorScheme.onBackground
//                                )
//
//
//                                Text(
//                                    modifier = Modifier.width(width),
//                                    text = "Buy",
//                                    fontWeight = FontWeight.SemiBold,
//                                    fontSize = 16.sp,
//                                    color = MaterialTheme.colorScheme.onBackground,
//                                    textAlign = TextAlign.End
//                                )
//
//
//                                Text(
//                                    modifier = Modifier.width(width),
//                                    text = "Sell",
//                                    fontWeight = FontWeight.SemiBold,
//                                    fontSize = 16.sp,
//                                    color = MaterialTheme.colorScheme.onBackground,
//                                    textAlign = TextAlign.End
//                                )
//                            }
//
//                            Spacer(modifier = Modifier.height(16.dp))
//
//                            LazyColumn {
//                                items(financeList.size) { index ->
//                                    FinanceItem(it)(
//                                        index = index,
//                                        width = width
//                                    )
//                                }
//                            }
//
//                        }
//                    }
//                }
//            }
//
//        }
//
//    }
//
//    @Composable
//    fun FinanceItem(index: Int, width: Dp) {
//        val transaction = transaction[index]
//        LazyColumn{
//            items(financeList.size){
////
////            }
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//
//            Row(
//                modifier = Modifier.width(width),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Box(
//                    modifier = Modifier
//                        .clip(RoundedCornerShape(8.dp))
//                        .background(GreenStart)
//                        .padding(4.dp)
//                ) {
//                    Icon(
//                        modifier = Modifier.size(18.dp),
//                        imageVector = currency.icon,
//                        contentDescription = currency.name,
//                        tint = Color.White
//                    )
//                }
//
////                Text(
////                    modifier = Modifier
////                        .padding(start = 10.dp),
////                    text = currency.name,
////                    fontWeight = FontWeight.Bold,
////                    fontSize = 18.sp,
////                    color = MaterialTheme.colorScheme.onBackground,
////                )
//            }
////
////            Text(
////                modifier = Modifier
////                    .width(width)
////                    .padding(start = 10.dp),
////                text = "$ ${currency.buy}",
////                fontWeight = FontWeight.Bold,
////                fontSize = 16.sp,
////                color = MaterialTheme.colorScheme.onBackground,
////                textAlign = TextAlign.End
////            )
//
////            Text(
////                modifier = Modifier
////                    .width(width)
////                    .padding(start = 10.dp),
////                text = "$ ${currency.sell}",
////                fontWeight = FontWeight.Bold,
////                fontSize = 16.sp,
////                color = MaterialTheme.colorScheme.onBackground,
////                textAlign = TextAlign.End
////            )
//
//        }
//    }
//
//}
////
//        }
//    }
////}
//


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


val transactions = listOf(
    Transaction(
        transactionType = "Deposit",
        accountName = "Fatma Account",
        amount = 23.25,
        balance = 1209.8,
        date = "1/2"
    ),

    Transaction(
        transactionType = "Deposit",
        accountName = "Fatma Account",
        amount = 23.25,
        balance = 1209.8,
        date = "1/2"
    ),

    Transaction(
        transactionType = "Deposit",
        accountName = "Fatma Account",
        amount = 23.25,
        balance = 1209.8,
        date = "1/2"
    ),

    Transaction(
        transactionType = "Deposit",
        accountName = "Fatma Account",
        amount = 23.25,
        balance = 1209.8,
        date = "1/2"
    ),

    Transaction(
        transactionType = "Deposit",
        accountName = "Fatma Account",
        amount = 23.25,
        balance = 1209.8,
        date = "1/2"
    ),

    Transaction(
        transactionType = "Deposit",
        accountName = "Fatma Account",
        amount = 23.25,
        balance = 1209.8,
        date = "1/2"
    ),
)


@Preview
@Composable
fun TransactionsSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }
//    Card(
//        modifier = modifier
//            .fillMaxWidth()
//            .height(100.dp)
//            .padding(15.dp),
//        colors = CardDefaults.cardColors(
//            containerColor =
//            MaterialTheme.colorScheme.primaryContainer
//        )
//    )
//    {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween,
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp)
//        ) {
//            Column {
//                Text(text = "$accountName Account ")
//                Text(text = "$date")
//            }
//            Text(text = "$transactionType")
//
//            Column {
//                Text(text = "$amount KWD")
//                Text(text = "$balance KWD")
//            }
//        }
//    }
//}

  /////////------------------------
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(top = 32.dp),
//        contentAlignment = Alignment.BottomCenter
//    ) {
//
//        Column(
//            modifier = Modifier
//                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
//                .background(MaterialTheme.colorScheme.inverseOnSurface)
//                .animateContentSize()
//        ) {
//
//            Row(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .animateContentSize()
//                    .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                Box(modifier = Modifier
//                    .clip(CircleShape)
//                    .background(MaterialTheme.colorScheme.secondary)
//                    .clickable {
//                        isVisible = !isVisible
//                        iconState = if (isVisible) {
//                            Icons.Rounded.KeyboardArrowUp
//                        } else {
//                            Icons.Rounded.KeyboardArrowDown
//                        }
//                    }
//                ) {
//                    Icon(
//                        modifier = Modifier.size(25.dp),
//                        imageVector = iconState,
//                        contentDescription = "Currencies",
//                        tint = MaterialTheme.colorScheme.onSecondary
//                    )
//                }
//
//                Spacer(modifier = Modifier.width(20.dp))
//
//                Text(
//                    text = "Currencies",
//                    fontSize = 20.sp,
//                    color = MaterialTheme.colorScheme.onSecondaryContainer,
//                    fontWeight = FontWeight.Bold
//                )
//
//            }
//
//            Spacer(
//                modifier = Modifier
//                    .height(1.dp)
//                    .fillMaxWidth()
//                    .background(MaterialTheme.colorScheme.secondaryContainer)
//            )
//
//            if (isVisible) {
//                BoxWithConstraints(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(horizontal = 16.dp)
//                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
//                        .background(MaterialTheme.colorScheme.background)
//                ) {
//
//                    val boxWithConstraintsScope = this
//                    val width = boxWithConstraintsScope.maxWidth / 3
//
//                    Column(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(horizontal = 16.dp)
//                    ) {
//
//                        Spacer(modifier = Modifier.height(16.dp))
//
//                        Row(
//                            modifier = Modifier.fillMaxWidth()
//                        ) {
//
//
////TODO cards
//
//                        }
//
//                        Spacer(modifier = Modifier.height(16.dp))
//
//                        LazyColumn {
//                            items(transactions.size) { index ->
//                                TransactionItem(
//                                    index = index,
//                                    width = width
//                                )
//                            }
//                        }
//
//                    }
//                }
//            }
//        }
//
//    }
//
//}
//
//@Composable
//fun TransactionItem(index: Int, width: Dp) {
//    val transaction = transactions[index]
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(bottom = 16.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//
//        Row(
//            modifier = Modifier.width(width),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Box(
//                modifier = Modifier
//                    .clip(RoundedCornerShape(8.dp))
//                    .background(Blue10)
//                    .padding(4.dp)
//            ) {
////                Icon(
////                    modifier = Modifier.size(18.dp),
////                    imageVector = transactions.icon ,
////                    contentDescription = currency.name,
////                    tint = Color.White
////                )
//            }
//
////            Text(
////                modifier = Modifier
////                    .padding(start = 10.dp),
////                text = transactions.size ,
////                fontWeight = FontWeight.Bold,
////                fontSize = 18.sp,
////                color = MaterialTheme.colorScheme.onBackground,
////            )
//        }
//
//        Text(
//            modifier = Modifier
//                .width(width)
//                .padding(start = 10.dp),
//            text = "whhere",
//            fontWeight = FontWeight.Bold,
//            fontSize = 16.sp,
//            color = MaterialTheme.colorScheme.onBackground,
//            textAlign = TextAlign.End
//        )
//
//        Text(
//            modifier = Modifier
//                .width(width)
//                .padding(start = 10.dp),
//            text = "$ ${transactions.size}",
//            fontWeight = FontWeight.Bold,
//            fontSize = 16.sp,
//            color = MaterialTheme.colorScheme.onBackground,
//            textAlign = TextAlign.End
//        )
//
//    }
//}
