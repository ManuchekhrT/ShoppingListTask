package com.unisafe.shoppinglist.data.mapper

import com.unisafe.shoppinglist.data.datasource.remote.dto.AddToShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.CreateShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.RemoveShoppingListDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.ShopListItemDto
import com.unisafe.shoppinglist.data.datasource.remote.dto.ShoppingItemDto
import com.unisafe.shoppinglist.domain.model.AddToShoppingListModel
import com.unisafe.shoppinglist.domain.model.CreateShoppingListModel
import com.unisafe.shoppinglist.domain.model.RemoveShoppingListModel
import com.unisafe.shoppinglist.domain.model.ShoppingItemModel
import com.unisafe.shoppinglist.domain.model.ShopListItemModel

fun ShopListItemDto.toDomain() = ShopListItemModel(
    created = created,
    name = name,
    id = id
)

fun List<ShopListItemDto>.toShopListItemModel(): List<ShopListItemModel> {
    return map {
        it.toDomain()
    }
}

fun ShoppingItemDto.toDomain() = ShoppingItemModel(
    created = created,
    name = name,
    isCrossed = isCrossed,
    id = id
)

fun List<ShoppingItemDto>.toShoppingItemModel(): List<ShoppingItemModel> {
    return map {
        it.toDomain()
    }
}


fun CreateShoppingListDto.toDomain() = CreateShoppingListModel(
    listId = listId
)

fun RemoveShoppingListDto.toDomain() = RemoveShoppingListModel(
    newValue = newValue
)

fun AddToShoppingListDto.toDomain() = AddToShoppingListModel(
    itemId = itemId
)