package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.model.RemoveShoppingListModel
import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class RemoveShoppingListUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(listId: Int): RemoveShoppingListModel? {
        return repository.removeShoppingList(listId).getOrNull()
    }
}