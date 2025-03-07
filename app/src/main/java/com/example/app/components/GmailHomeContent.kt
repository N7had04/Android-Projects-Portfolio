package com.example.app.components

import androidx.collection.objectIntMap
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.ui.theme.AppTheme
import kotlin.random.Random

data class MailData(
    val mailId: Int, val userName: String,
    val subject: String, val body: String, val timeStamp: String)

val MailList = listOf(
    MailData(1, "HackerRank Team", "Practice Coding with Solve Me First FP",
        "Hi Jake, Improve your skills with this ch...", "10 Jan"),
    MailData(2, "JetBrains Account", "Develop smarter with JetBra...",
        "Hello Jake, Thank you for choos...", "28/12/2024"),
    MailData(3, "GitHub", "[GitHub] A third-party OAuth...",
        "Hey Jake_99! A third-party OAuth...", "28/12/2024"),
    MailData(4, "HackerRank Team", "Can You Solve Looping and Sk...",
        "Hi Jake, Improve your skills with ...", "28/12/2024"),
    MailData(5, "GitHub", "GitHub Copilot: What's in yo...",
        "How to get started with GitHub Co...", "27/12/2024"),
    MailData(6, "Steam", "Steam Winter Sale on now, with ...",
        "Explore the whole Winter Sale, now...", "24/12/2024"),
    MailData(7, "Credly", "Credly email confirmation ins...",
        "Welcome to Credly! You're receiv...", "08/12/2024"),
    MailData(8, "Steam", "Steam Autumn Sale on now, wi...",
        "Explore the whole Autumn Sale, ...", "02/12/2024"),
    MailData(9, "Microsoft Rewards", "Our million dollar sweeps is h...",
        "Our biggest sweepstakes ever, an...", "26/10/2024"),
    MailData(10, "Microsoft Rewards", "$1,000,000 USD sweepstakes...",
        "Enter for a chance to win", "19/10/2024"),
    MailData(11, "HackerRank Team", "Practice Coding with Attribute...",
        "Hi Jake, Improve your skills with t...", "07/09/2024"),
    MailData(12, "Steam", "Steam Summer Sale on now, w...",
        "Explore the whole Summer Sale, ...", "03/07/2024"),
    MailData(13, "Coursera", "Interested in earning a cyber s...",
        "Study online with the University o...", "02/07/2024"),
    MailData(14, "Microsoft Rewards", "Be an instant winner - Spin to Wi...",
        "Check out our other sweepstakes ...", "09/06/2024"),
    MailData(15, "Google Developer Program", "Welcome to the Google Develop...",
        "Email not displaying correctly? View...", "28/05/2024"),)

private val mapOfColors = mapOf(
    'H' to Color(0xFF5DE0F4),
    'J' to Color(0xFFF1C30B),
    'G' to Color(0xFF36ECA3),
    'C' to Color(0xFFBDF380),
    'S' to Color(0xFFD5C8F2),
    'M' to Color(0xFFFC854E))

@Composable
fun GmailHomeContent(listState: LazyListState) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        state = listState) {
        items(MailList) { mailData -> MailItem(mailData = mailData) }
    }
}
@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth().padding(8.dp)) {
        Card(modifier = modifier
            .padding(end = 16.dp)
            .size(40.dp)
            .clip(CircleShape), colors = CardDefaults.cardColors(
            containerColor = mapOfColors.getOrDefault(mailData.userName[0], Color.Gray))) {
            Text(text = " ${mailData.userName[0]}",
                textAlign = TextAlign.Center,
                modifier = modifier.padding(start = 9.dp, end = 8.dp, top = 8.dp, bottom = 8.dp))
        }
        Column(modifier.weight(2.0f)) {
            Text(text = mailData.userName, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = mailData.subject, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(text = mailData.body, fontSize = 14.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = mailData.timeStamp, fontSize = 13.sp)
            IconButton(onClick = { /*TODO*/ },
                Modifier
                    .size(50.dp)
                    .padding(top = 16.dp, bottom = 8.dp)) {
                Icon(imageVector = Icons.Outlined.StarOutline, contentDescription = "")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview() {
    AppTheme {
        MailItem(mailData = MailData(mailId = 4, userName = "Udemy", subject = "Order complete!",
            body = "Thanks to choose to learn with us - ...", timeStamp = "7 Jan"))
    }
}