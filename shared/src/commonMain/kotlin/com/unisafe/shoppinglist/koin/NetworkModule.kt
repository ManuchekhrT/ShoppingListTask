package com.unisafe.shoppinglist.koin

import com.unisafe.shoppinglist.data.datasource.remote.ApiService
import com.unisafe.shoppinglist.data.datasource.remote.ApiServiceImpl
import com.unisafe.shoppinglist.data.network.createHttpClient
import io.ktor.client.HttpClient
import org.koin.dsl.module

val networkModule = module {
    single<HttpClient> { createHttpClient() }
    single<ApiService> { ApiServiceImpl(httpClient = get<HttpClient>()) }
}