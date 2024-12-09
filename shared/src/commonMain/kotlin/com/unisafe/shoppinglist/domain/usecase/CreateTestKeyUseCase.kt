package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class CreateTestKeyUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(): String {
        return repository.createTestKey().getOrDefault("")
    }
}