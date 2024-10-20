package com.practice.passorder.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun HomeMain() {
    var searchLabel by remember {
        mutableStateOf("매장을 검색해 주세요.")
    }
    var enable by remember { mutableStateOf(false) }
    var search by remember { mutableStateOf("") }
    var location by remember {
        mutableStateOf("현재 위치")
    }
    val interactionSource = remember { MutableInteractionSource() }
    val textFieldColor = Color(0xFFF2F2F2)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        item {
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier
                        .size(30.dp),
                    imageVector = Icons.Default.Search,
                    tint = Color.Black,
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.width(4.dp))
                BasicTextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier
                        .height(40.dp)
                        .background(textFieldColor, shape = RoundedCornerShape(10.dp))
                        .weight(1f)
                        .fillMaxHeight()
                        .border(border = BorderStroke(0.5.dp, textFieldColor)),
                    visualTransformation = VisualTransformation.None,
                    interactionSource = interactionSource,
                    enabled = enable,
                    singleLine = true,
                    decorationBox = {
                        innerTextField ->   Box(contentAlignment = Alignment.CenterStart,modifier = Modifier.padding(horizontal = 8.dp)) {
                            if(search.isEmpty()){
                                Text(text=searchLabel,fontSize = 14.sp)
                            }
                        innerTextField()
                    }
                    }
                )
//
                Row(modifier = Modifier.wrapContentSize()) {
                    Text(text = location, modifier = Modifier.padding(start = 6.dp))
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
                }

            }
        }
    }
}

@Composable
fun ViewPager() {

}

@Composable
fun menu() {

}

