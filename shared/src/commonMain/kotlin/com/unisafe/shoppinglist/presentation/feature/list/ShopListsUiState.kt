package com.unisafe.shoppinglist.presentation.feature.list

import androidx.compose.runtime.Immutable
import com.unisafe.shoppinglist.domain.model.ShopListItemModel

@Immutable
data class ShopListsUiState(
    val shopLists: List<ShopListItemModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)