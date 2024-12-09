package com.practice.passorder.view

import android.view.WindowInsets
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.practice.passorder.R

@Preview
@Composable
fun HomeMain() {
    val searchLabel by remember {
        mutableStateOf("매장을 검색해 주세요.")
    }

    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("리스트로 주문", "지도로 주문")

    var enable by remember { mutableStateOf(false) }
    var search by remember { mutableStateOf("") }
    var location by remember {
        mutableStateOf("현재 위치")
    }
    val interactionSource = remember { MutableInteractionSource() }
    val textFieldColor = Color(0xFFF2F2F2)
    val focusManager = LocalFocusManager.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .systemBarsPadding()
            .clickable { focusManager.clearFocus() }
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = Icons.Default.Search,
                    tint = Color.Black,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(4.dp))
                BasicTextField(value = search,
                    onValueChange = { search = it },
                    modifier = Modifier
                        .height(40.dp)
                        .background(textFieldColor, shape = RoundedCornerShape(10.dp))
                        .weight(1f)
                        .fillMaxHeight()
                        .border(border = BorderStroke(0.5.dp, textFieldColor)),
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    //enabled = enable,
                    singleLine = true,
                    decorationBox = { innerTextField ->
                        Box(
                            contentAlignment = Alignment.CenterStart,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        ) {
                            if (search.isEmpty()) {
                                Text(text = searchLabel, fontSize = 14.sp)
                            }
                            innerTextField()
                        }
                    })
//
                Row(modifier = Modifier
                    .wrapContentSize()
                    .clickable {
                        //누르면 바텀시트 열리고 등록된 위치 + 현재 위치로 설정 버튼
                        /*TODO*/
                    }) {
                    Text(text = location, modifier = Modifier.padding(start = 6.dp))
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }

            }
            Spacer(modifier = Modifier.size(4.dp))
            TabRow(selectedTabIndex = selectedTabIndex, contentColor = Color.Black) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = { Text(title) },
                        selectedContentColor = Color.Black
                    )
                }
            }
            when (selectedTabIndex) {
                0 -> ListOrder()
                1 -> MapOrder()
            }
        }
    }
}

@Composable
fun ListOrder() {
    val imageList = listOf(
        R.drawable.event1,
        R.drawable.event2,
        R.drawable.event3
    )
    Column(modifier = Modifier.fillMaxSize()) {
        BirthdaySection()
        middleMenu()
        Pager(imageList, modifier = Modifier)
    }
}



@Composable
fun bottomNavigation() {

}


@Composable
fun MapOrder() {
    Column(modifier = Modifier.fillMaxSize()) {

    }
}