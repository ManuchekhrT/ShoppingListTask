package com.unisafe.shoppinglist.data.repository

import com.unisafe.shoppinglist.data.datasource.local.LocalDataSource
import com.unisafe.shoppinglist.data.datasource.remote.ShoppingListRemoteDataSource
import com.unisafe.shoppinglist.data.mapper.toDomain
import com.unisafe.shoppinglist.data.mapper.toShopListItemModel
import com.unisafe.shoppinglist.data.mapper.toShoppingItemModel
import com.unisafe.shoppinglist.domain.model.AddToShoppingListModel
import com.unisafe.shoppinglist.domain.model.CreateShoppingListModel
import com.unisafe.shoppinglist.domain.model.RemoveShoppingListModel
import com.unisafe.shoppinglist.domain.model.ShoppingItemModel
import com.unisafe.shoppinglist.domain.model.ShopListItemModel
import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository

class ShoppingListRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: ShoppingListRemoteDataSource
) : ShoppingListRepository {

    override suspend fun createTestKey(): Result<String> {
        return remoteDataSource.createTestKey().map { aKey ->
            localDataSource.saveKey(aKey)
            aKey
        }
    }

    override suspend fun authenticateKey(key: String): Result<Boolean> {
        return remoteDataSource.authenticateKey(key).map {
            it.success
        }
    }

    override suspend fun createShoppingList(
        name: String
    ): Result<CreateShoppingListModel> {
        val key = localDataSource.getKey()
        return remoteDataSource.createShoppingList(key, name).map {
            it.toDomain()
        }
    }

    override suspend fun removeShoppingList(listId: Int): Result<RemoveShoppingListModel> {
        return remoteDataSource.removeShoppingList(listId).map {
            it.toDomain()
        }
    }

    override suspend fun addToShoppingList(
        id: Int,
        value: String,
        n: Int
    ): Result<AddToShoppingListModel> {
        return remoteDataSource.addToShoppingList(id, value, n).map {
            it.toDomain()
        }
    }

    override suspend fun removeFromList(listId: Int, itemId: Int): Result<Boolean> {
        return remoteDataSource.removeFromList(listId, itemId).map {
            it.success
        }
    }

    override suspend fun crossItOff(id: Int): Result<Boolean> {
        return remoteDataSource.crossItOff(id).map {
            it.success
        }
    }

    override suspend fun getAllMyShopLists(): Result<List<ShopListItemModel>> {
        val key = localDataSource.getKey()
        return remoteDataSource.getAllMyShopLists(key).map {
            it.shopList.toShopListItemModel()
        }
    }

    override suspend fun getShoppingList(listId: Int): Result<List<ShoppingItemModel>> {
        return remoteDataSource.getShoppingList(listId).map {
            it.itemList.toShoppingItemModel()
        }
    }

    override suspend fun getSavedKey(): String {
        return localDataSource.getKey()
    }
}