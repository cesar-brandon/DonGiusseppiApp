package com.example.dongiusseppiapp.ui.detail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor() : ViewModel() {
    private var _state = MutableStateFlow<ProductState>(ProductState.Loading)
    val state: StateFlow<ProductState> = _state

    fun setProductName(name: Int, image: Int, cardImage: Int, description: Int, price: Int) {
        _state.value = ProductState.Success(name, image, cardImage, description, price)
    }
}