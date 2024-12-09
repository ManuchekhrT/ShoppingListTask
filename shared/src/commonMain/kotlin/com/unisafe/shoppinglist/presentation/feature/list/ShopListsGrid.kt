package com.unisafe.shoppinglist.presentation.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.unisafe.shoppinglist.domain.model.ShopListItemModel

@Composable
fun ShoppingListGrid(
    shopLists: List<ShopListItemModel>,
    navigateDetail: (ShopListItemModel) -> Unit,
    onRemoveClick: (ShopListItemModel) -> Unit,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        items(shopLists) { item ->
            ShopListItem(item, navigateDetail, onRemoveClick)
        }
    }
}