package com.example.dongiusseppiapp.ui.menu

import androidx.lifecycle.ViewModel
import com.example.dongiusseppiapp.domain.model.MenuInfo
import com.example.dongiusseppiapp.domain.model.MenuInfo.Americana
import com.example.dongiusseppiapp.domain.model.MenuInfo.Hawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaAmericana
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaHawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaOlivo
import com.example.dongiusseppiapp.domain.model.MenuInfo.Olivos
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionAmericana
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionHawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionOlivo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor() : ViewModel() {
    private val _menu = MutableStateFlow<List<MenuInfo>>(emptyList())
    val menu: StateFlow<List<MenuInfo>> = _menu
    private val _category = MutableStateFlow("")
    val category: StateFlow<String> = _category

    fun setCategory(category: String) {
        _category.value = category
        updateMenu(_category.value)
    }

    fun getMenuByCategory(category: String) {
        _menu.value = when (category) {
            "pizza" -> listOf(
                Americana,
                Hawaiana,
                Olivos,
                MediaAmericana,
                PorcionAmericana,
                MediaHawaiana,
                PorcionHawaiana,
                MediaOlivo,
                PorcionOlivo
            )

            "postre" -> listOf(Hawaiana, MediaHawaiana, PorcionHawaiana)
            "helado" -> listOf(Olivos, MediaOlivo, PorcionOlivo)
            "bebida" -> listOf(Americana, Hawaiana, Olivos)
            else -> emptyList()
        }
    }

    private fun updateMenu(category: String) {
        getMenuByCategory(category)
    }
}