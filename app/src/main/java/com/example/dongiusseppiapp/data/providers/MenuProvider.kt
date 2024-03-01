package com.example.dongiusseppiapp.data.providers

import com.example.dongiusseppiapp.domain.model.MenuInfo
import com.example.dongiusseppiapp.domain.model.MenuInfo.*
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
            Brownies,
            Empanadas,
            RollosCanela,
            Yoggis,

            Helado,
            Helado4Bolas,

            SevenUpPersonal,
            SevenUp1Lt,
            SporadePersonal,
            CocaColaPersonal,
            ConcordiaPersonal,
            Concordia1Lt,
            FantaPersonal,
            IncaKolaPersonal
        )
    }
}