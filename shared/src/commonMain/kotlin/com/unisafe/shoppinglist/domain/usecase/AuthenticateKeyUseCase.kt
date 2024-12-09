package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class AuthenticateKeyUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(key: String): Boolean {
        return repository.authenticateKey(key).getOrDefault(false)
    }
}