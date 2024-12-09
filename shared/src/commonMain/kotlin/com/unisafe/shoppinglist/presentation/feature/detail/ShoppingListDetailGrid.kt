package com.unisafe.shoppinglist.presentation.feature.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.unisafe.shoppinglist.domain.model.ShoppingItemModel

@Composable
fun ShopListDetailGrid(
    shoppingItemList: List<ShoppingItemModel>,
    onRemoveClick: (ShoppingItemModel) -> Unit,
    onItemClick: (ShoppingItemModel) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        items(shoppingItemList) { item ->
            ShopListDetailItem(
                item = item,
                onRemoveClick = onRemoveClick,
                onItemClick = onItemClick
            )
        }
    }
}