package com.example.app.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.app.R
import com.google.accompanist.pager.HorizontalPagerIndicator


@OptIn(ExperimentalPagerApi::class)
@Composable
fun SwipeableScreenWithIndicators(paddingValues: PaddingValues) {
    val pagerState = rememberPagerState()

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues)) {
        HorizontalPager(
            count = 2,
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                when (page) {
                    0 -> {
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(start = 48.dp, end = 48.dp)) {
                            Image(painter = painterResource(id = R.drawable.gmail_meet_screen_1),
                                contentDescription = "Page 1", modifier = Modifier.clip(CircleShape))
                            Text(text = "Get a link that you can share", fontSize = 24.sp,
                                modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center)
                            Text(text = "Tap New meeting to get a link that you can send to people that you want to meet with",
                                fontSize = 16.sp,
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center)
                        }
                    }
                    1 -> {
                        Column(horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(start = 36.dp, end = 36.dp)) {
                            Image(painter = painterResource(id = R.drawable.gmail_meet_screen_2),
                                contentDescription = "Page 2", modifier = Modifier.clip(CircleShape))
                            Text(text = "Your meeting is safe", fontSize = 24.sp,
                                modifier = Modifier.padding(16.dp), fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center)
                            Text(text = "No one can join a meeting unless invited or admitted by the host",
                                fontSize = 16.sp,
                                modifier = Modifier.padding(16.dp),
                                textAlign = TextAlign.Center)
                        }
                    }
                }
            }
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PagerPreview() {
    SwipeableScreenWithIndicators(paddingValues = PaddingValues())
}