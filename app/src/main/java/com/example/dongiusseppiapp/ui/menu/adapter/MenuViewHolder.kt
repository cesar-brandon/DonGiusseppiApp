package com.example.dongiusseppiapp.ui.menu.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dongiusseppiapp.databinding.ItemMenuBinding
import com.example.dongiusseppiapp.domain.model.MenuInfo

class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMenuBinding.bind(view)
    fun render(MenuInfo: MenuInfo) {
        binding.ivMenu.setImageResource(MenuInfo.image)
    }
}