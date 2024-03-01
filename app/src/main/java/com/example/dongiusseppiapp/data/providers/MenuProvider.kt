package com.example.dongiusseppiapp.data.providers

import com.example.dongiusseppiapp.domain.model.MenuInfo
import com.example.dongiusseppiapp.domain.model.MenuInfo.Americana
import com.example.dongiusseppiapp.domain.model.MenuInfo.ArrozConLeche
import com.example.dongiusseppiapp.domain.model.MenuInfo.Hawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.Helado1Bola
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaAmericana
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaHawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.MediaOlivo
import com.example.dongiusseppiapp.domain.model.MenuInfo.Olivos
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionAmericana
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionHawaiana
import com.example.dongiusseppiapp.domain.model.MenuInfo.PorcionOlivo
import javax.inject.Inject

class MenuProvider @Inject constructor() {
    fun getMenuList(): List<MenuInfo> {
        return listOf(
            Americana,
            Hawaiana,
            Olivos,
            MediaAmericana,
            MediaHawaiana,
            MediaOlivo,
            PorcionAmericana,
            PorcionHawaiana,
            PorcionOlivo,
            ArrozConLeche,
            Helado1Bola,
        )
    }
}