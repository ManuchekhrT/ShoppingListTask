package com.unisafe.shoppinglist.koin

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.unisafe.shoppinglist.data.datasource.local.LocalDataSource
import com.unisafe.shoppinglist.data.datasource.local.LocalDataSourceImpl
import com.unisafe.shoppinglist.data.datasource.remote.ApiService
import com.unisafe.shoppinglist.data.datasource.remote.ShoppingListRemoteDataSource
import com.unisafe.shoppinglist.data.datasource.remote.ShoppingListRemoteDataSourceImpl
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration? = {}) =
    startKoin {
        appDeclaration?.let { it() }
        modules(
            networkModule,
            dataSourceModule,
            repositoryModule,
            useCaseModule,
            viewModelModule,
            getDatastoreModuleByPlatform()
        )
    }


private val dataSourceModule = module {
    single<ShoppingListRemoteDataSource> { ShoppingListRemoteDataSourceImpl(apiService = get<ApiService>()) }
    single<LocalDataSource> { LocalDataSourceImpl(dataStore = get<DataStore<Preferences>>()) }
}

