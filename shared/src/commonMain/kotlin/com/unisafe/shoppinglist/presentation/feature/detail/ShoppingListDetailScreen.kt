package com.unisafe.shoppinglist.presentation.feature.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.SavedStateHandle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.unisafe.shoppinglist.presentation.feature.dialog.AddToShoppingListDialog
import com.unisafe.shoppinglist.util.StringResources.SHOP_LIST_ID
import org.koin.compose.koinInject
import org.koin.core.parameter.parametersOf

class ShoppingListDetailScreen(
    private val shopListId: Int,
    private val shopListName: String
) : Screen {

    override val key: ScreenKey
        get() = uniqueScreenKey

    @Composable
    override fun Content() {
        val viewModel = koinInject<ShoppingListDetailViewModel>(
            parameters = { parametersOf(SavedStateHandle(mapOf(SHOP_LIST_ID to shopListId))) }
        )
        val shoppingListDetailState by viewModel.shoppingListDetailState.collectAsState()
        val isDialogVisible by viewModel.isDialogVisible.collectAsState(false)
        val navigator = LocalNavigator.currentOrThrow

        Scaffold(
            topBar = {
                ShoppingListDetailTopBar(
                    title = shopListName,
                    onAddClick = { viewModel.showCreateDialog(true) },
                    onBackClick = { navigator.pop() }
                )
            },
            content = {
                ShoppingListDetailContent(
                    viewModel,
                    shoppingListDetailState,
                    Modifier.padding(it)
                )
            }
        )

        if (isDialogVisible) {
            AddToShoppingListDialog(
                onDismissRequest = { viewModel.showCreateDialog(false) },
                onAddClick = { value, n ->
                    viewModel.addToShoppingList(value, n)
                }
            )
        }
    }
}