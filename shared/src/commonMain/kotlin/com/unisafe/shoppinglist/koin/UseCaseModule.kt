package com.unisafe.shoppinglist.koin

import com.unisafe.shoppinglist.domain.repository.ShoppingListRepository
import com.unisafe.shoppinglist.domain.usecase.AddToShoppingListUseCase
import com.unisafe.shoppinglist.domain.usecase.AuthenticateKeyUseCase
import com.unisafe.shoppinglist.domain.usecase.CreateShoppingListUseCase
import com.unisafe.shoppinglist.domain.usecase.CreateTestKeyUseCase
import com.unisafe.shoppinglist.domain.usecase.CrossItOffUseCase
import com.unisafe.shoppinglist.domain.usecase.GetAllMyShopListsUseCase
import com.unisafe.shoppinglist.domain.usecase.GetShoppingListUseCase
import com.unisafe.shoppinglist.domain.usecase.LocalKeyUseCase
import com.unisafe.shoppinglist.domain.usecase.RemoveFromListModelUseCase
import com.unisafe.shoppinglist.domain.usecase.RemoveShoppingListUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<AddToShoppingListUseCase> { AddToShoppingListUseCase(repository = get<ShoppingListRepository>()) }
    single<AuthenticateKeyUseCase> { AuthenticateKeyUseCase(repository = get<ShoppingListRepository>()) }
    single<CreateShoppingListUseCase> { CreateShoppingListUseCase(repository = get<ShoppingListRepository>()) }
    single<CreateTestKeyUseCase> { CreateTestKeyUseCase(repository = get<ShoppingListRepository>()) }
    single<CrossItOffUseCase> { CrossItOffUseCase(repository = get<ShoppingListRepository>()) }
    single<GetAllMyShopListsUseCase> { GetAllMyShopListsUseCase(repository = get<ShoppingListRepository>()) }
    single<GetShoppingListUseCase> { GetShoppingListUseCase(repository = get<ShoppingListRepository>()) }
    single<RemoveFromListModelUseCase> { RemoveFromListModelUseCase(repository = get<ShoppingListRepository>()) }
    single<RemoveShoppingListUseCase> { RemoveShoppingListUseCase(repository = get<ShoppingListRepository>()) }
    single<LocalKeyUseCase> { LocalKeyUseCase(repository = get<ShoppingListRepository>()) }
}