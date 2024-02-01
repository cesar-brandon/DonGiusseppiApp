package com.example.dongiusseppiapp.domain.model

import com.example.dongiusseppiapp.R

sealed class MenuInfo(
    val name: Int,
    val image: Int
) {
    data object Americana : MenuInfo(R.string.americana, R.drawable.pizza_americana)
    data object MediaAmericana :
        MenuInfo(R.string.americana_media, R.drawable.pizza_americana_media)

    data object PorcionAmericana :
        MenuInfo(R.string.americana_porcion, R.drawable.pizza_americana_porcion)

    data object Hawaiana : MenuInfo(R.string.hawaiana, R.drawable.pizza_hawaiana)
    data object MediaHawaiana : MenuInfo(R.string.hawaiana_media, R.drawable.pizza_hawaiana_media)
    data object PorcionHawaiana :
        MenuInfo(R.string.hawaiana_porcion, R.drawable.pizza_hawaiana_porcion)

    data object Olivos : MenuInfo(R.string.olivo, R.drawable.pizza_olivo)
    data object MediaOlivo : MenuInfo(R.string.olivo_media, R.drawable.pizza_olivo_media)
    data object PorcionOlivo : MenuInfo(R.string.olivo_porcion, R.drawable.pizza_olivo_porcion)
}