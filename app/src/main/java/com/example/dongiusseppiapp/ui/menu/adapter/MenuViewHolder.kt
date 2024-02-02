package com.example.dongiusseppiapp.ui.menu.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.dongiusseppiapp.databinding.ItemMenuBinding
import com.example.dongiusseppiapp.domain.model.MenuInfo

class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemMenuBinding.bind(view)
    fun render(MenuInfo: MenuInfo, onItemSelect: (MenuInfo) -> Unit) {
        binding.ivMenu.setImageResource(MenuInfo.cardImage)

        binding.parent.setOnClickListener {
            startAnimation(binding.ivMenu, onItemSelect = { onItemSelect(MenuInfo) })
        }
    }

    fun startAnimation(view: View, onItemSelect: () -> Unit) {
        view.animate().scaleX(1.1f).scaleY(1.1f).setDuration(200).withEndAction {
            view.animate().scaleX(1f).scaleY(1f).setDuration(200).withEndAction {
                onItemSelect()
            }.start()
        }.start()
    }
}