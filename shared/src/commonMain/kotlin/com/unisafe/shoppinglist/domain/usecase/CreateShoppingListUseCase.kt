package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.model.CreateShoppingListModel
import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class CreateShoppingListUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(name: String): Result<CreateShoppingListModel> {
        return repository.createShoppingList(name)
    }
}