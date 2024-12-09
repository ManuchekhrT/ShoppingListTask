package com.unisafe.shoppinglist.domain.model

data class ShoppingItemModel(
    val created: String,
    val name: String,
    val isCrossed: Boolean,
    val id: Int
)