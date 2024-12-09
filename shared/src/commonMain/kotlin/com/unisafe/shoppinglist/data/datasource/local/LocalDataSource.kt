package com.unisafe.shoppinglist.data.datasource.local

interface LocalDataSource {
    suspend fun saveKey(key: String)
    suspend fun getKey(): String
}