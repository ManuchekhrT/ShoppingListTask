package com.unisafe.shoppinglist.presentation.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.unisafe.shoppinglist.presentation.common.composable.ShoppingListItemError
import com.unisafe.shoppinglist.presentation.common.composable.ShoppingListLoadingSpinner

@Composable
fun ShoppingListDetailContent(
    viewModel: ShoppingListDetailViewModel,
    shoppingListDetailState: ShoppingListDetailUiState,
    modifier: Modifier
) {

    val snackBarHostState = remember { SnackbarHostState() }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        when {
            shoppingListDetailState.isLoading -> ShoppingListLoadingSpinner()
            shoppingListDetailState.shoppingItemsList.isNotEmpty() -> {
                ShopListDetailGrid(
                    shoppingItemList = shoppingListDetailState.shoppingItemsList,
                    onRemoveClick = { item -> viewModel.removeFromList(item.id) },
                    onItemClick =  { item -> viewModel.crossItOff(item.id) }
                )
            }

            else -> shoppingListDetailState.error?.let {
                ShoppingListItemError(it, onClick = {})
            }
        }
    }

    SnackbarHost(hostState = snackBarHostState)
}