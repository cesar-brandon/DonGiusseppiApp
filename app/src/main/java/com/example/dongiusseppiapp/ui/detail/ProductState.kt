package com.example.dongiusseppiapp.ui.detail

sealed class ProductState {
    data object Loading : ProductState()
    data class Error(val message: String) : ProductState()
    data class Success(
        val name: Int,
        val image: Int,
        val cardImage: Int,
        val description: Int,
        val price: Int
    ) :
        ProductState()
}