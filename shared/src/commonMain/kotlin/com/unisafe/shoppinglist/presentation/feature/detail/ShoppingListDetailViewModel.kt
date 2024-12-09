package com.unisafe.shoppinglist.presentation.feature.detail

import androidx.lifecycle.SavedStateHandle
import com.unisafe.shoppinglist.domain.usecase.AddToShoppingListUseCase
import com.unisafe.shoppinglist.domain.usecase.CrossItOffUseCase
import com.unisafe.shoppinglist.domain.usecase.GetShoppingListUseCase
import com.unisafe.shoppinglist.domain.usecase.RemoveFromListModelUseCase
import com.unisafe.shoppinglist.util.StringResources.SHOP_LIST_ID
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ShoppingListDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val addToShoppingListUseCase: AddToShoppingListUseCase,
    private val removeFromListModelUseCase: RemoveFromListModelUseCase,
    private val getShoppingListUseCase: GetShoppingListUseCase,
    private val crossItOffUseCase: CrossItOffUseCase
) : ViewModel() {

    private val listId: Int = checkNotNull(savedStateHandle[SHOP_LIST_ID])

    private val _shoppingListDetailState = MutableStateFlow(ShoppingListDetailUiState())
    val shoppingListDetailState: StateFlow<ShoppingListDetailUiState> =
        _shoppingListDetailState.asStateFlow()

    private val _isDialogVisible = MutableSharedFlow<Boolean>()
    val isDialogVisible: SharedFlow<Boolean> = _isDialogVisible.asSharedFlow()

    init {
        getShoppingList()
    }

    private fun getShoppingList() {
        _shoppingListDetailState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val shoppingItems = getShoppingListUseCase.invoke(listId)
            _shoppingListDetailState.update {
                it.copy(shoppingItemsList = shoppingItems, isLoading = false)
            }
        }
    }

    fun addToShoppingList(value: String, n: Int) {
        viewModelScope.launch {
            addToShoppingListUseCase.invoke(listId, value, n)?.let {
                getShoppingList()
                showCreateDialog(false)
            }
        }
    }

    fun removeFromList(itemId: Int) {
        viewModelScope.launch {
            removeFromListModelUseCase.invoke(listId, itemId).also {
                getShoppingList()
            }
        }
    }

    fun crossItOff(itemId: Int) {
        viewModelScope.launch {
            crossItOffUseCase.invoke(itemId).also {
                getShoppingList()
            }
        }
    }

    fun showCreateDialog(show: Boolean) {
        viewModelScope.launch {
            _isDialogVisible.emit(show)
        }
    }
}