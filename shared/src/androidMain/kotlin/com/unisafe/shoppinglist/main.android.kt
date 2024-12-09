package com.unisafe.shoppinglist

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.unisafe.shoppinglist.presentation.App

@Composable
fun MainView() = App(
    darkTheme = isSystemInDarkTheme(),
    dynamicColor = true
)