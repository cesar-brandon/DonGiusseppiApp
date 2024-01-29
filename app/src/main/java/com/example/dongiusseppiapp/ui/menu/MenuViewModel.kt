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

    init {
        _menu.value = listOf(
            Americana,
            Hawaiana,
            Olivos,
            MediaAmericana,
            MediaHawaiana,
            MediaOlivo,
            PorcionAmericana,
            PorcionHawaiana,
            PorcionOlivo
        )
    }
}