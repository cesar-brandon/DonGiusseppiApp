package com.example.dongiusseppiapp.ui.order.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.dongiusseppiapp.databinding.ItemCartBinding
import com.example.dongiusseppiapp.domain.model.CartItem

class CartItemViewHolder(private val binding: ItemCartBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(cartItem: CartItem) {
        binding.tvProductName.text = cartItem.product.name.toString()
        binding.tvQuantity.text = cartItem.quantity.toString()
        binding.tvTotalPrice.text = String.format("%.2f", cartItem.totalPrice)
    }
}