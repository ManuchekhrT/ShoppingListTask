package com.unisafe.shoppinglist.domain.repository

import com.unisafe.shoppinglist.domain.model.AddToShoppingListModel
import com.unisafe.shoppinglist.domain.model.CreateShoppingListModel
import com.unisafe.shoppinglist.domain.model.RemoveShoppingListModel
import com.unisafe.shoppinglist.domain.model.ShoppingItemModel
import com.unisafe.shoppinglist.domain.model.ShopListItemModel

interface ShoppingListRepository {
    suspend fun createTestKey(): Result<String>
    suspend fun authenticateKey(key: String): Result<Boolean>

    suspend fun createShoppingList(name: String): Result<CreateShoppingListModel>
    suspend fun removeShoppingList(listId: Int): Result<RemoveShoppingListModel>
    suspend fun addToShoppingList(id: Int, value: String, n: Int): Result<AddToShoppingListModel>
    suspend fun removeFromList(listId: Int, itemId: Int): Result<Boolean>
    suspend fun crossItOff(id: Int): Result<Boolean>

    suspend fun getAllMyShopLists(): Result<List<ShopListItemModel>>
    suspend fun getShoppingList(listId: Int): Result<List<ShoppingItemModel>>

    suspend fun getSavedKey(): String
}