package com.practice.passorder.domain

data class Shop(
    val shopId : Int,
    val image : Int,
    val name : String,
    val call : String?,
    val spot : String,
    val favorite : Int,
    val location : String,
)
