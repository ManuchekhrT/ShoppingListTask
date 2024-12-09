package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.model.AddToShoppingListModel
import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class AddToShoppingListUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(id: Int, value: String, n: Int): AddToShoppingListModel? {
        return repository.addToShoppingList(id, value, n).getOrNull()
    }
}