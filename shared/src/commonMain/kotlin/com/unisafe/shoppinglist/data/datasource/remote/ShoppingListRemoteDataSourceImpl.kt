package com.unisafe.shoppinglist.data.datasource.remote

import com.unisafe.shoppinglist.data.datasource.remote.dto.AddToShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.AuthenticateDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.CreateShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.CrossItOffDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.GetAllMyShopListsDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.GetShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.RemoveFromListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.RemoveShoppingListDto

class ShoppingListRemoteDataSourceImpl(
    private val apiService: ApiService
) : ShoppingListRemoteDataSource {

    override suspend fun createTestKey(): Result<String> {
        return apiService.createTestKey()
    }

    override suspend fun authenticateKey(key: String): Result<AuthenticateDto> {
        return apiService.authenticateKey(key)
    }

    override suspend fun createShoppingList(
        key: String,
        name: String
    ): Result<CreateShoppingListDto> {
        return apiService.createShoppingList(key, name)
    }

    override suspend fun removeShoppingList(listId: Int): Result<RemoveShoppingListDto> {
        return apiService.removeShoppingList(listId)
    }

    override suspend fun addToShoppingList(
        id: Int,
        value: String,
        n: Int
    ): Result<AddToShoppingListDto> {
        return apiService.addToShoppingList(id, value, n)
    }

    override suspend fun removeFromList(listId: Int, itemId: Int): Result<RemoveFromListDto> {
        return apiService.removeFromList(listId, itemId)
    }

    override suspend fun crossItOff(id: Int): Result<CrossItOffDto> {
        return apiService.crossItOff(id)
    }

    override suspend fun getAllMyShopLists(key: String): Result<GetAllMyShopListsDto> {
        return apiService.getAllMyShopLists(key)
    }

    override suspend fun getShoppingList(listId: Int): Result<GetShoppingListDto> {
        return apiService.getShoppingList(listId)
    }

}