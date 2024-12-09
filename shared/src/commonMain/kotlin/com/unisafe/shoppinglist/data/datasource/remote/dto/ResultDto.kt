package com.unisafe.shoppinglist.data.datasource.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class AuthenticateDto(
    @SerialName("success")
    val success: Boolean
)

@Serializable
class CreateShoppingListDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("list_id")
    val listId: Int
)

@Serializable
class RemoveShoppingListDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("new_value")
    val newValue: Boolean
)

@Serializable
class AddToShoppingListDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("item_id")
    val itemId: Int
)

@Serializable
class GetAllMyShopListsDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("shop_list")
    val shopList: List<ShopListItemDto> = emptyList()
)

@Serializable
data class ShopListItemDto(
    @SerialName("created")
    val created: String,
    @SerialName("name")
    val name: String,
    @SerialName("id")
    val id: Int
)

@Serializable
class GetShoppingListDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("item_list")
    val itemList: List<ShoppingItemDto> = emptyList()
)

@Serializable
data class ShoppingItemDto(
    @SerialName("created")
    val created: String,
    @SerialName("name")
    val name: String,
    @SerialName("is_crossed")
    val isCrossed: Boolean,
    @SerialName("id")
    val id: Int
)

@Serializable
class RemoveFromListDto(
    @SerialName("success")
    val success: Boolean
)

@Serializable
class CrossItOffDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("rows_affected")
    val rowsAffected: Int
)