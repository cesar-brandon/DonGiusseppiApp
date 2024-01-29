package com.example.dongiusseppiapp.domain.model

import com.example.dongiusseppiapp.R

sealed class MenuInfo(
    val name: Int,
    val image: Int
) {
    object Americana : MenuInfo(R.string.americana, R.drawable.pizza_americana)
    object MediaAmericana : MenuInfo(R.string.americana_media, R.drawable.pizza_americana_media)
    object PorcionAmericana :
        MenuInfo(R.string.americana_porcion, R.drawable.pizza_americana_porcion)

    object Hawaiana : MenuInfo(R.string.hawaiana, R.drawable.pizza_hawaiana)
    object MediaHawaiana : MenuInfo(R.string.hawaiana_media, R.drawable.pizza_hawaiana_media)
    object PorcionHawaiana : MenuInfo(R.string.hawaiana_porcion, R.drawable.pizza_hawaiana_porcion)

    object Olivos : MenuInfo(R.string.olivo, R.drawable.pizza_olivo)
    object MediaOlivo : MenuInfo(R.string.olivo_media, R.drawable.pizza_olivo_media)
    object PorcionOlivo : MenuInfo(R.string.olivo_porcion, R.drawable.pizza_olivo_porcion)
}