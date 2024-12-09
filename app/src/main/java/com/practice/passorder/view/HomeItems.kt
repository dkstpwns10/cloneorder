package com.practice.passorder.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(images: List<Int>, modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val pagerState = rememberPagerState(pageCount = { images.size })

        // 이미지 페이저
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = images[page],
                    contentDescription = "Event Image ${page + 1}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            }
        }

        // 페이지 인디케이터
        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(images.size) { iteration ->
                val color = if (pagerState.currentPage == iteration) Color.White else Color.Gray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}
@Composable
fun middleMenu() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                //TODO
            }
        ) {
            Icon(imageVector = Icons.Default.Email, contentDescription = "coupon")
            Text("쿠폰함", fontSize = 12.sp)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                //TODO
            }
        ) {
            Icon(imageVector = Icons.Default.Place, contentDescription = "point/stamp")
            Text("포인트/스탬프", fontSize = 12.sp)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                //TODO
            }
        ) {
            Icon(imageVector = Icons.Default.Notifications, contentDescription = "alarm")
            Text("알림", fontSize = 12.sp)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                //TODO
            }
        ) {
            Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "market")
            Text("적립마켓", fontSize = 12.sp)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.clickable {
                //TODO
            }
        ) {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = "gift")
            Text("선물하기", fontSize = 12.sp)
        }

    }
}


@Composable
fun BirthdaySection() {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.fillMaxWidth().background(Color.LightGray)) {
            // 제목과 드롭다운 애로우 버튼
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expanded = !expanded }
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("생일 축하해 주세요!", fontSize = 15.sp, fontWeight = FontWeight.Bold)
                }

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                    contentDescription = "Toggle birthday list"
                )
            }

            // 애니메이션과 함께 드롭다운 내용 표시
            AnimatedVisibility(
                visible = expanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                // 펼쳐졌을 때 표시할 내용
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    BirthdayItem(name = "문병진", date = "10.30")
                    BirthdayItem(name = "전유미", date = "10.31")
                    // 추가 생일 아이템들...LazyRow로 item들 리스트로 받아서 표시
                }
            }
        }
    }

}

@Composable
fun BirthdayItem(name: String, date: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(name, modifier = Modifier.weight(1f))
        Surface(
            shape = CircleShape,
            color = Color.LightGray,
            modifier = Modifier.size(40.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = date,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}

@Composable
fun Call_Shop(){

}

@Composable
fun ShopList(title : String){

}
