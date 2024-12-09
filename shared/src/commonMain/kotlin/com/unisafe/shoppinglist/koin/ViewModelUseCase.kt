package com.unisafe.shoppinglist.koin

import androidx.lifecycle.SavedStateHandle
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
import com.unisafe.shoppinglist.presentation.feature.detail.ShoppingListDetailViewModel
import com.unisafe.shoppinglist.presentation.feature.list.ShopListsViewModel
import org.koin.dsl.module

val viewModelModule = module {
    single<ShopListsViewModel> {
        ShopListsViewModel(
            getAllMyShopListsUseCase = get<GetAllMyShopListsUseCase>(),
            createTestKeyUseCase = get<CreateTestKeyUseCase>(),
            authenticateKeyUseCase = get<AuthenticateKeyUseCase>(),
            createShoppingListUseCase = get<CreateShoppingListUseCase>(),
            localKeyUseCase = get<LocalKeyUseCase>(),
            removeShoppingListUseCase = get<RemoveShoppingListUseCase>()
        )
    }

    single<ShoppingListDetailViewModel> { (savedStateHandle: SavedStateHandle) ->
        ShoppingListDetailViewModel(
            savedStateHandle = savedStateHandle,
            addToShoppingListUseCase = get<AddToShoppingListUseCase>(),
            removeFromListModelUseCase = get<RemoveFromListModelUseCase>(),
            getShoppingListUseCase = get<GetShoppingListUseCase>(),
            crossItOffUseCase = get<CrossItOffUseCase>()
        )
    }
}