package com.unisafe.shoppinglist.koin

import com.unisafe.shoppinglist.data.datasource.local.LocalDataSource
import com.unisafe.shoppinglist.data.datasource.remote.ShoppingListRemoteDataSource
import com.unisafe.shoppinglist.data.repository.ShoppingListRepositoryImpl
import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<ShoppingListRepository> {
        ShoppingListRepositoryImpl(
            remoteDataSource = get<ShoppingListRemoteDataSource>(),
            localDataSource = get<LocalDataSource>()
        )
    }
}