package com.unisafe.shoppinglist.presentation.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.unisafe.shoppinglist.presentation.common.composable.ShoppingListItemError
import com.unisafe.shoppinglist.presentation.common.composable.ShoppingListLoadingSpinner
import com.unisafe.shoppinglist.presentation.feature.detail.ShoppingListDetailScreen
import com.unisafe.shoppinglist.util.StringResources.REMOVED_SHOPPING_LIST_SUCCESSFULLY

@Composable
fun ShopListsContent(
    viewModel: ShopListsViewModel,
    state: ShopListsUiState,
    modifier: Modifier
) {
    val navigator = LocalNavigator.currentOrThrow
    val snackbarHostState = remember { SnackbarHostState() }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceVariant),
        contentAlignment = Alignment.Center
    ) {
        if (state.isLoading) ShoppingListLoadingSpinner()
        if (state.shopLists.isNotEmpty()) {
            ShoppingListGrid(
                shopLists = state.shopLists,
                navigateDetail = {
                   navigator.push(
                       ShoppingListDetailScreen(
                           shopListId = it.id,
                           shopListName = it.name
                       )
                   )
                },
                onRemoveClick = { item -> viewModel.removeShoppingList(item.id) {
                    viewModel.showSnackBar(snackbarHostState, REMOVED_SHOPPING_LIST_SUCCESSFULLY)
                } }
            )
        }
        state.error?.let {
            ShoppingListItemError(it, onClick = {})
        }
    }

    SnackbarHost(hostState = snackbarHostState)
}