package com.unisafe.shoppinglist.presentation.feature.list

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import com.unisafe.shoppinglist.presentation.feature.dialog.CreateShoppingListDialog
import org.koin.compose.koinInject

class ShopListsScreen : Screen {
    override val key: ScreenKey
        get() = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel = koinInject<ShopListsViewModel>()
        val state by viewModel.shopListsState.collectAsState()
        val isDialogVisible by viewModel.isDialogVisible.collectAsState(false)

        Scaffold(
            topBar = {
                ShoppingListTopBar(
                    onAddClick = {
                        viewModel.showCreateDialog(true)
                    }
                )
            },
            content = {
                ShopListsContent(viewModel, state, Modifier.padding(it))
            }
        )

        if (isDialogVisible) {
            CreateShoppingListDialog(
                onDismissRequest = { viewModel.showCreateDialog(false) },
                onCreateClick = { name -> viewModel.createShoppingList(name) }
            )
        }
    }
}