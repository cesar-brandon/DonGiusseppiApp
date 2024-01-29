package com.example.dongiusseppiapp.ui.menu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dongiusseppiapp.R
import com.example.dongiusseppiapp.domain.model.MenuInfo

class MenuAdapter(
    private var menuList: List<MenuInfo> = emptyList(),
    private val onItemSelect: (MenuInfo) -> Unit
) :
    RecyclerView.Adapter<MenuViewHolder>() {

    fun updateList(newList: List<MenuInfo>) {
        menuList = newList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_menu,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = menuList.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.render(menuList[position], onItemSelect)
    }
}