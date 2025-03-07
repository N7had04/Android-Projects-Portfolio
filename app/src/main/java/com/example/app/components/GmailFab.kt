package com.example.app.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.MaterialTheme

@Composable
fun GmailFab(listState: LazyListState) {
    val showExtendedFab = listState.firstVisibleItemIndex > 0 || listState.firstVisibleItemScrollOffset > 100
    if (showExtendedFab) {
        FloatingActionButton(onClick = { /*TODO*/ },
            containerColor = Color(0xFFC5D9F2)) {
            Icon(imageVector = Icons.Default.Edit, contentDescription = "")
        }
    } else {
        ExtendedFloatingActionButton(
            text = {
                Text(text = "Compose", fontSize = 16.sp)
            },
            icon = {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "")
            },
            onClick = { /*TODO*/ },
            containerColor = Color(0xFFC5D9F2))
    }
}