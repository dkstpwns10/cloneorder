package com.practice.passorder.domain

data class Order(
    val orderId : Int,
    val shopId : Int,
    val userId : Int,
    val menu : List<String>,
    val price : Int,
)
