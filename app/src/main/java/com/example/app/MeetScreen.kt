package com.example.app

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.wear.compose.material3.IconButton
import com.example.app.components.AccountsDialog
import com.example.app.components.GmailDrawerMenu
import com.example.app.components.HomeBottomMenu
import com.example.app.components.SwipeableScreenWithIndicators
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Meet(navController: NavController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val openDialog = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = { MaterialTheme {
            ModalDrawerSheet {
                GmailDrawerMenu()
            }
        } })
    {
        Scaffold(topBar = {MeetTopAppBar(scope = coroutineScope, drawerState = drawerState, openDialog = openDialog)},
            bottomBar = { HomeBottomMenu(navController = navController)},
            snackbarHost = { SnackbarHost(hostState = remember { SnackbarHostState() }) })
        {
            paddingValues ->
            SwipeableScreenWithIndicators(paddingValues)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeetTopAppBar(scope: CoroutineScope, drawerState: DrawerState, openDialog: MutableState<Boolean>) {
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 48.dp, end = 16.dp, bottom = 8.dp)
            .requiredHeight(50.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            IconButton(onClick = {
                scope.launch {
                    drawerState.open()
                }
            }) {
                Icon(
                    Icons.Default.Menu, "Menu",
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Text(text = "Meet", fontSize = 24.sp)
            Image(painter = painterResource(id = R.drawable.ic_j_icon), contentDescription = "Profile",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .clickable { openDialog.value = true })
            if (openDialog.value) {
                AccountsDialog(openDialog = openDialog)
            }
        }
        Row(modifier = Modifier.padding(8.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF04637B)),
                modifier = Modifier.padding(end = 8.dp)) {
                Text(text = "New meeting", fontSize = 20.sp)
            }
            Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(30.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                border = BorderStroke(1.dp, Color(0xFF04637B)),
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Join with a code", color = Color(0xFF04637B), fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeetPreview() {
    MeetTopAppBar(scope = rememberCoroutineScope(),
        drawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
        openDialog = remember { mutableStateOf(false) })
}