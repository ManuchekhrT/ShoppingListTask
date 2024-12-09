package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.model.ShopListItemModel
import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class GetAllMyShopListsUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(): List<ShopListItemModel> {
        return repository.getAllMyShopLists().getOrDefault(emptyList())
    }
}