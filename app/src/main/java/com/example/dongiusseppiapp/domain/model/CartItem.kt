package com.example.dongiusseppiapp.domain.model

import com.example.dongiusseppiapp.ui.detail.ProductState

data class CartItem(
    val product: ProductState.Success,
    val quantity: Int,
    val totalPrice: Double
)