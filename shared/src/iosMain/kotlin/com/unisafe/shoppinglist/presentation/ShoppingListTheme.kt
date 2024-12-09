package com.unisafe.shoppinglist.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import com.unisafe.shoppinglist.presentation.common.theme.DarkColors
import com.unisafe.shoppinglist.presentation.common.theme.LightColors
import com.unisafe.shoppinglist.presentation.common.theme.Typography

@Composable
actual fun ShoppingListTheme(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColors else LightColors,
        typography = Typography,
        content = content
    )
}