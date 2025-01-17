package com.practice.passorder.domain

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object OrderHistory : Screen("order_history")
    object Favorites : Screen("favorites")
    object QrOrder : Screen("qr_order")
    object Profile : Screen("profile")
}