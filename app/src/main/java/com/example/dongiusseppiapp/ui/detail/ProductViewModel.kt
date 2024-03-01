package com.example.dongiusseppiapp.ui.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.dongiusseppiapp.domain.model.CartItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val application: Application,
) : ViewModel() {
    private var _state = MutableStateFlow<ProductState>(ProductState.Loading)
    val state: StateFlow<ProductState> = _state
    private val _productCount = MutableStateFlow(1)
    val productCount: StateFlow<Int> = _productCount

    private val unitPrice = MutableStateFlow(0.00)
    private val _totalPrice = MutableStateFlow(0.00)
    val totalPrice: StateFlow<Double> = _totalPrice

    private val _cartItems = MutableStateFlow<List<CartItem>>(emptyList())
    val cartItems: StateFlow<List<CartItem>> = _cartItems


    fun setProductName(name: Int, image: Int, cardImage: Int, description: Int, priceResId: Int) {
        val priceString = application.getString(priceResId)
        val price = priceString.toDoubleOrNull() ?: 0.00

        _state.value = ProductState.Success(name, image, cardImage, description, priceResId)
        unitPrice.value = price
        _totalPrice.value = unitPrice.value * _productCount.value
    }

    fun incrementProductCount() {
        _productCount.value += 1
        _totalPrice.value = unitPrice.value * _productCount.value
    }

    fun decrementProductCount() {
        if (_productCount.value > 1) {
            _productCount.value -= 1
            _totalPrice.value = unitPrice.value * _productCount.value
        }
    }

    suspend fun updateCartItems() {
        val cartItems = _cartItems.value.toMutableList()
        val product = _state.value as? ProductState.Success ?: return
        val totalPrice = _totalPrice.value
        val quantity = _productCount.value
        val cartItem = CartItem(product, quantity, totalPrice)
        cartItems.add(cartItem)
        _cartItems.value = cartItems
    }
}