package com.example.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Help
import androidx.compose.material.icons.automirrored.outlined.Label
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.AllInbox
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Drafts
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Inbox
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Label
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Outbox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Snooze
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material.icons.outlined.Tag
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GmailDrawerMenu() {
    val menuList = listOf(
        DrawerMenuData.Divider, DrawerMenuData.Primary, DrawerMenuData.Promotions,
        DrawerMenuData.Social, DrawerMenuData.Updates, DrawerMenuData.HeaderOne,
        DrawerMenuData.Starred, DrawerMenuData.Snoozed, DrawerMenuData.Important,
        DrawerMenuData.Sent, DrawerMenuData.Schedule, DrawerMenuData.Outbox,
        DrawerMenuData.Draft, DrawerMenuData.AllMail, DrawerMenuData.Spam,
        DrawerMenuData.HeaderTwo, DrawerMenuData.Calendar, DrawerMenuData.Contacts,
        DrawerMenuData.Divider, DrawerMenuData.Setting, DrawerMenuData.Help)
    Column(modifier = Modifier
        .background(MaterialTheme.colorScheme.surface)
        .padding(16.dp)
        .verticalScroll(rememberScrollState())) {
        Text(text = "Gmail",
            color = Color.Red,
            modifier = Modifier.padding(start = 20.dp, top = 30.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        menuList.forEach { GmailDrawerItem(item = it) }
    }
}

@Composable
fun GmailDrawerItem(item: DrawerMenuData) {
    when {
        item.isDivider -> {
            Divider(modifier = Modifier
                .padding(bottom = 20.dp, top = 20.dp)
                .width(300.dp))
        }
        item.isHeader -> {
            Text(text = item.title!!, fontWeight = FontWeight.Light,
                modifier = Modifier.padding(start = 20.dp, bottom = 10.dp, top = 20.dp))
        }
        else -> {
            Row(modifier = Modifier
                .height(50.dp)
                .padding(top = 16.dp)) {
                Icon(imageVector = item.icon!!, contentDescription = item.title,
                    modifier = Modifier.padding(start = 8.dp, end = 16.dp))
                Text(text = item.title!!)
            }
        }
    }
}

sealed class DrawerMenuData(val icon: ImageVector? = null,
    val title: String? = null, val isDivider: Boolean = false,
    val isHeader: Boolean = false) {
    object AllInboxes: DrawerMenuData(icon = Icons.Outlined.AllInbox, title = "All inboxes")
    object Primary: DrawerMenuData(icon = Icons.Outlined.Inbox, title = "Primary")
    object Social: DrawerMenuData(icon = Icons.Outlined.Person, title = "Social")
    object Promotions: DrawerMenuData(icon = Icons.Outlined.Tag, title = "Promotions")
    object Starred: DrawerMenuData(icon = Icons.Outlined.StarOutline, title = "Starred")
    object Snoozed: DrawerMenuData(icon = Icons.Outlined.Snooze, title = "Snoozed")
    object Important: DrawerMenuData(icon = Icons.AutoMirrored.Outlined.Label, title = "Important")
    object Sent: DrawerMenuData(icon = Icons.AutoMirrored.Outlined.Send, title = "Sent")
    object Schedule: DrawerMenuData(icon = Icons.Outlined.Schedule, title = "Scheduled")
    object Outbox: DrawerMenuData(icon = Icons.Outlined.Outbox, title = "Outbox")
    object Draft: DrawerMenuData(icon = Icons.Outlined.Drafts, title = "Drafts")
    object AllMail: DrawerMenuData(icon = Icons.Outlined.Mail, title = "All Mail")
    object Calendar: DrawerMenuData(icon = Icons.Outlined.CalendarToday, title = "Calendar")
    object Contacts: DrawerMenuData(icon = Icons.Outlined.Contacts, title = "Contacts")
    object Setting: DrawerMenuData(icon = Icons.Outlined.Settings, title = "Setting")
    object Spam: DrawerMenuData(icon = Icons.Outlined.Info, title = "Spam")
    object Help: DrawerMenuData(icon = Icons.AutoMirrored.Outlined.Help, title = "Help & FeedBack")
    object Updates: DrawerMenuData(icon = Icons.Outlined.Info, title = "Updates")
    object Divider: DrawerMenuData(isDivider = true)
    object HeaderOne: DrawerMenuData(isHeader = true, title = "ALL LABELS")
    object HeaderTwo: DrawerMenuData(isHeader = true, title = "GOOGLE APPS")
}