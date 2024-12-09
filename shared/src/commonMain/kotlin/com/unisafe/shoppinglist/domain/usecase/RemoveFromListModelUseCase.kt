package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class RemoveFromListModelUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(listId: Int, itemId: Int): Boolean {
        return repository.removeFromList(listId, itemId).getOrDefault(false)
    }
}