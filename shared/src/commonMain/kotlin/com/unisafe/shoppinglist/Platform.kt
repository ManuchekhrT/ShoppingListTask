package com.unisafe.shoppinglist

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform