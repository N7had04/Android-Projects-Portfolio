package com.example.app.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.PersonAddAlt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.wear.compose.material3.IconButton
import androidx.wear.compose.material3.Text
import com.example.app.R

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>) {
    Dialog(onDismissRequest = { openDialog.value = false}) {
        AccountsDialogUI(openDialog)
    }
}

@Composable
fun AccountsDialogUI(openDialog: MutableState<Boolean>, modifier: Modifier = Modifier) {
    Card(shape = RoundedCornerShape(30.dp)) {
        Row(modifier.fillMaxWidth().padding(top = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = {
                openDialog.value = false
            }) {
                Icon(imageVector = Icons.Default.Close, contentDescription = "")
            }
            Image(painter = painterResource(id = R.drawable.ic_google_logo_transparent),
                contentDescription = "", modifier
                    .size(30.dp)
                    .weight(2.0f)
                    .padding(end = 24.dp))
        }
        Card(shape = RoundedCornerShape(30.dp), modifier = modifier
            .padding(start = 8.dp, end = 8.dp)) {
            Column(
                modifier
                    .background(Color.White)) {
                Row(
                    modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp)) {
                    Image(painter = painterResource(id = R.drawable.ic_j_icon), contentDescription = "Profile",
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape))
                    Column(
                        modifier
                            .weight(2.0f)
                            .padding(start = 16.dp, bottom = 8.dp)) {
                        Text(text = "Jake Henderson", fontWeight = FontWeight.SemiBold,
                            color = Color.Black, modifier = modifier.padding(bottom = 4.dp))
                        Text(text = "jakehenderson99@gmail.com", fontSize = 13.sp,
                            color = Color.Black)
                    }
                    Text(text = "99+", modifier.padding(end = 16.dp, top = 16.dp), color = Color.Black,
                        fontSize = 12.sp)
                }
                Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Card(shape = RoundedCornerShape(6.dp),
                        border = BorderStroke(1.dp, Color.Gray),
                        modifier = modifier.padding(top = 16.dp, bottom = 24.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Text(text = "Manage your Google Account", color = Color.Black,
                            modifier = modifier.padding(start = 16.dp, end = 16.dp,
                                top = 8.dp, bottom = 8.dp))
                    }
                }
                Divider()
                Row(
                    modifier
                        .padding(start = 32.dp, top = 16.dp, bottom = 16.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Outlined.Cloud, contentDescription = "")
                    Text(text = "Storage used: 17% of 15GB", fontSize = 12.sp, color = Color.Black,
                        modifier = modifier.padding(start = 16.dp))
                }
                Divider()
                Row(
                    modifier
                        .padding(start = 32.dp, top = 16.dp, bottom = 8.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Outlined.PersonAddAlt, contentDescription = "")
                    Text(text = "Add another account", fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold, color = Color.Black,
                        modifier = modifier.padding(start = 16.dp))
                }
                Row(
                    modifier
                        .padding(start = 32.dp, top = 16.dp, bottom = 16.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Icon(imageVector = Icons.Outlined.ManageAccounts, contentDescription = "")
                    Text(text = "Manage accounts on this device", fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold, color = Color.Black,
                        modifier = modifier.padding(start = 16.dp))
                }
            }
        }
        Row(modifier.fillMaxWidth().padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = "Privacy Policy", fontSize = 12.sp, color = Color.Black)
            Text(text = "*", fontSize = 12.sp, color = Color.Black)
            Text(text = "Terms of service", fontSize = 12.sp, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AccountsDialogPreview() {
    AccountsDialogUI(openDialog = remember {
        mutableStateOf(true)
    })
}