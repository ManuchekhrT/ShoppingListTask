package com.unisafe.shoppinglist.data.datasource.remote

import com.unisafe.shoppinglist.data.datasource.remote.dto.AddToShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.AuthenticateDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.CreateShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.CrossItOffDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.GetAllMyShopListsDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.GetShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.RemoveFromListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.RemoveShoppingListDto

interface ApiService {
    suspend fun createTestKey(): Result<String>
    suspend fun authenticateKey(key: String): Result<AuthenticateDto>

    suspend fun createShoppingList(key: String, name: String): Result<CreateShoppingListDto>
    suspend fun removeShoppingList(listId: Int): Result<RemoveShoppingListDto>
    suspend fun addToShoppingList(id: Int, value: String, n: Int): Result<AddToShoppingListDto>
    suspend fun removeFromList(listId: Int, itemId: Int): Result<RemoveFromListDto>
    suspend fun crossItOff(id: Int): Result<CrossItOffDto>

    suspend fun getAllMyShopLists(key: String): Result<GetAllMyShopListsDto>
    suspend fun getShoppingList(listId: Int): Result<GetShoppingListDto>
}