package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class LocalKeyUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(): String {
        return repository.getSavedKey()
    }
}