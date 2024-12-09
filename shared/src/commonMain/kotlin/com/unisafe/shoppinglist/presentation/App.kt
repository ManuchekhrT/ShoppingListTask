package com.unisafe.shoppinglist.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.unisafe.shoppinglist.presentation.feature.list.ShopListsScreen

@Composable
internal fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean
) {
    ShoppingListTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        Navigator(
            ShopListsScreen()
        )
    }
}