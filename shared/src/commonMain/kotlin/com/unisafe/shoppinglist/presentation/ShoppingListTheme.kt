package com.unisafe.shoppinglist.presentation

import androidx.compose.runtime.Composable

@Composable
expect fun ShoppingListTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
)