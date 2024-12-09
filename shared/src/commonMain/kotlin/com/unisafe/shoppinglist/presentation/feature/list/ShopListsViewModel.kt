package com.unisafe.shoppinglist.presentation.feature.list

import androidx.compose.material3.SnackbarHostState
import com.unisafe.shoppinglist.domain.usecase.AuthenticateKeyUseCase
import com.unisafe.shoppinglist.domain.usecase.CreateShoppingListUseCase
import com.unisafe.shoppinglist.domain.usecase.CreateTestKeyUseCase
import com.unisafe.shoppinglist.domain.usecase.GetAllMyShopListsUseCase
import com.unisafe.shoppinglist.domain.usecase.LocalKeyUseCase
import com.unisafe.shoppinglist.domain.usecase.RemoveShoppingListUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ShopListsViewModel(
    private val getAllMyShopListsUseCase: GetAllMyShopListsUseCase,
    private val createTestKeyUseCase: CreateTestKeyUseCase,
    private val authenticateKeyUseCase: AuthenticateKeyUseCase,
    private val createShoppingListUseCase: CreateShoppingListUseCase,
    private val localKeyUseCase: LocalKeyUseCase,
    private val removeShoppingListUseCase: RemoveShoppingListUseCase
) : ViewModel() {

    private val _shopListsState = MutableStateFlow(ShopListsUiState())
    val shopListsState: StateFlow<ShopListsUiState> = _shopListsState.asStateFlow()

    private val _isDialogVisible = MutableSharedFlow<Boolean>()
    val isDialogVisible: SharedFlow<Boolean> = _isDialogVisible.asSharedFlow()

    init {
        authenticateAndLoadAllShopLists()
    }

    private fun authenticateAndLoadAllShopLists() {
        viewModelScope.launch {
            val savedKey = localKeyUseCase.invoke()
            if (savedKey.isBlank()) {
                val key = createTestKeyUseCase.invoke()
                authenticateKeyUseCase.invoke(key)
            }
            loadAllShopLists()
        }
    }

    fun showCreateDialog(show: Boolean) {
        viewModelScope.launch {
            _isDialogVisible.emit(show)
        }
    }

    fun createShoppingList(name: String) {
        viewModelScope.launch {
            createShoppingListUseCase.invoke(name).also {
                loadAllShopLists()
                showCreateDialog(false)
            }
        }
    }

    private fun loadAllShopLists() {
        _shopListsState.update {
            it.copy(isLoading = true)
        }
        viewModelScope.launch {
            val lists = getAllMyShopListsUseCase.invoke()
            _shopListsState.update {
                it.copy(shopLists = lists, isLoading = false)
            }
        }
    }

    fun removeShoppingList(listId: Int, onComplete: (Boolean) -> Unit) {
        viewModelScope.launch {
            val removeShoppingListResult = removeShoppingListUseCase.invoke(listId)
            removeShoppingListResult?.let {
                if(it.newValue) {
                    loadAllShopLists()
                    onComplete(true)
                } else {
                    onComplete(false)
                }
            }
        }
    }

    fun showSnackBar(snackBarHostState: SnackbarHostState, message: String) {
        viewModelScope.launch {
            snackBarHostState.showSnackbar(message)
        }
    }
}