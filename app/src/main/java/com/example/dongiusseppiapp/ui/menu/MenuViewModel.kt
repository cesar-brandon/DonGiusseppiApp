package com.example.dongiusseppiapp.ui.menu

import androidx.lifecycle.ViewModel
import com.example.dongiusseppiapp.domain.model.MenuInfo
import com.example.dongiusseppiapp.domain.model.MenuInfo.*
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

            "postre" -> listOf(ArrozConLeche, Brownies, Empanadas, RollosCanela, Yoggis)
            "helado" -> listOf(Helado, Helado4Bolas)
            "bebida" -> listOf(
                SevenUpPersonal,
                SevenUp1Lt,
                SporadePersonal,
                CocaColaPersonal,
                ConcordiaPersonal,
                Concordia1Lt,
                FantaPersonal,
                IncaKolaPersonal,
            )

            else -> emptyList()
        }
    }

    private fun updateMenu(category: String) {
        getMenuByCategory(category)
    }
}