package com.example.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app.components.GmailDrawerMenu
import com.example.app.components.GmailFab
import com.example.app.components.GmailHomeContent
import com.example.app.components.HomeAppBar
import com.example.app.components.HomeBottomMenu
import com.example.app.components.MailData
import com.example.app.components.MailItem
import com.example.app.components.MailList
import com.example.app.components.Navigation
import com.example.app.ui.theme.AppTheme
import kotlinx.coroutines.flow.distinctUntilChanged

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Navigation()
            }
        }
    }
}

@Composable
fun GmailApp(navController: NavController) {
    var isVisible by remember { mutableStateOf(true) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val snackBarHostState = remember { SnackbarHostState() }
    val listState = rememberLazyListState()
    val openDialog = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(listState) {
        snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
            .collect { (index, offset) ->
                isVisible = index == 0 && offset == 0
            }
    }

    ModalNavigationDrawer(drawerState = drawerState,
        drawerContent = { ModalDrawerSheet(modifier = Modifier.fillMaxWidth(0.8f)) {
            GmailDrawerMenu() }
        })
    {
        Scaffold(topBar = { AnimatedVisibility(visible = isVisible, enter = fadeIn(), exit = fadeOut()) {
            HomeAppBar(drawerState = drawerState, scope = coroutineScope, openDialog = openDialog)
        }},
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            bottomBar = { AnimatedVisibility(visible = isVisible, enter = fadeIn(), exit = fadeOut()) {
                HomeBottomMenu(navController)
            } },
            floatingActionButton = {GmailFab(listState = listState)})
        {
            paddingValues -> Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues), // Apply contentPadding
                contentAlignment = Alignment.Center
            ) {
                GmailHomeContent(listState)
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