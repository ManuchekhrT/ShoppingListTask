package com.unisafe.shoppinglist.data.datasource.remote

import com.unisafe.shoppinglist.data.datasource.remote.dto.AddToShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.AuthenticateDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.CreateShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.CrossItOffDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.GetAllMyShopListsDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.GetShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.RemoveFromListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.RemoveShoppingListDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiServiceImpl(
    private val httpClient: HttpClient
) : ApiService {

    override suspend fun createTestKey(): Result<String> {
        return safeRequest {
            httpClient.get("CreateTestKey?")
        }
    }

    override suspend fun authenticateKey(key: String): Result<AuthenticateDto> {
       return safeRequest {
           httpClient.get("Authentication?key=$key")
       }
    }

    override suspend fun createShoppingList(
        key: String,
        name: String
    ): Result<CreateShoppingListDto> {
        return safeRequest {
            httpClient.get("CreateShoppingList?key=$key&name=$name")
        }
    }

    override suspend fun removeShoppingList(listId: Int): Result<RemoveShoppingListDto> {
        return safeRequest {
            httpClient.get("RemoveShoppingList?list_id=$listId")
        }
    }

    override suspend fun addToShoppingList(
        id: Int,
        value: String,
        n: Int
    ): Result<AddToShoppingListDto> {
        return safeRequest {
            httpClient.get("AddToShoppingList?id=$id&value=$value&n=$n")
        }
    }

    override suspend fun removeFromList(listId: Int, itemId: Int): Result<RemoveFromListDto> {
        return safeRequest {
            httpClient.get("RemoveFromList?list_id=$listId&item_id=$itemId")
        }
    }

    override suspend fun crossItOff(id: Int): Result<CrossItOffDto> {
        return safeRequest {
            httpClient.get("CrossItOff?id=$id")
        }
    }

    override suspend fun getAllMyShopLists(key: String): Result<GetAllMyShopListsDto> {
        return safeRequest {
            httpClient.get("GetAllMyShopLists?key=$key")
        }
    }

    override suspend fun getShoppingList(listId: Int): Result<GetShoppingListDto> {
        return safeRequest {
            httpClient.get("GetShoppingList?list_id=$listId")
        }
    }


}