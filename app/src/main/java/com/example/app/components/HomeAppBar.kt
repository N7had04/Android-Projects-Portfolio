package com.example.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.app.R
import com.example.app.ui.theme.AppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun HomeAppBar(drawerState: DrawerState, scope: CoroutineScope, openDialog: MutableState<Boolean>) {
    Box(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 50.dp)) {
        Card(shape = RoundedCornerShape(30.dp), modifier = Modifier.requiredHeight(60.dp)) {
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
                verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                }) {
                    Icon(Icons.Default.Menu, "Menu",
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp))
                }
                Text(text = "Search in emails",
                    modifier = Modifier.padding(end = 195.dp))
                Image(painter = painterResource(id = R.drawable.ic_j_icon), contentDescription = "Profile",
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .clickable { openDialog.value = true })
                if (openDialog.value) {
                    AccountsDialog(openDialog = openDialog)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {

    }
}