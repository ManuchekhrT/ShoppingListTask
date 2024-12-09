package com.unisafe.shoppinglist.presentation.feature.detail

import androidx.compose.runtime.Immutable
import com.unisafe.shoppinglist.domain.model.ShoppingItemModel

@Immutable
data class ShoppingListDetailUiState(
    val shoppingItemsList: List<ShoppingItemModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)