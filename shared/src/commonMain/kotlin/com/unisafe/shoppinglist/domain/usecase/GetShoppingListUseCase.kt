package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.model.ShoppingItemModel
import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class GetShoppingListUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(listId: Int): List<ShoppingItemModel> {
        return repository.getShoppingList(listId).getOrDefault(emptyList())
    }
}