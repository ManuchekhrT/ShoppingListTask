package com.unisafe.shoppinglist.domain.usecase

import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class CrossItOffUseCase(
    private val repository: ShoppingListRepository
) {
    suspend operator fun invoke(id: Int): Boolean {
        return repository.crossItOff(id).getOrDefault(false)
    }
}