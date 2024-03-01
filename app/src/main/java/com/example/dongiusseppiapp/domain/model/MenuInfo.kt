package com.example.dongiusseppiapp.domain.model

import com.example.dongiusseppiapp.R

sealed class MenuInfo(
    val name: Int,
    val image: Int,
    val cardImage: Int,
    val description: Int,
    val price: Int,
    val category: String = "pizza"
) {
    data object Americana : MenuInfo(
        R.string.americana,
        R.drawable.pizza_americana,
        R.drawable.card_pizza_americana,
        R.string.americana_description,
        R.string.americana_price
    )

    data object MediaAmericana :
        MenuInfo(
            R.string.americana_media,
            R.drawable.pizza_americana_media,
            R.drawable.card_pizza_americana_media,
            R.string.americana_media_description,
            R.string.americana_media_price
        )

    data object PorcionAmericana :
        MenuInfo(
            R.string.americana_porcion,
            R.drawable.pizza_americana_porcion,
            R.drawable.card_pizza_americana_porcion,
            R.string.americana_porcion_description,
            R.string.americana_porcion_price
        )

    data object Hawaiana : MenuInfo(
        R.string.hawaiana,
        R.drawable.pizza_hawaiana,
        R.drawable.card_pizza_hawaiana,
        R.string.hawaiana_description,
        R.string.hawaiana_price
    )

    data object MediaHawaiana : MenuInfo(
        R.string.hawaiana_media,
        R.drawable.pizza_hawaiana_media,
        R.drawable.card_pizza_hawaiana_media,
        R.string.hawaiana_media_description,
        R.string.hawaiana_media_price
    )

    data object PorcionHawaiana :
        MenuInfo(
            R.string.hawaiana_porcion,
            R.drawable.pizza_hawaiana_porcion,
            R.drawable.card_pizza_hawaiana_porcion,
            R.string.hawaiana_porcion_description,
            R.string.hawaiana_porcion_price
        )

    data object Olivos : MenuInfo(
        R.string.olivo,
        R.drawable.pizza_olivo,
        R.drawable.card_pizza_olivo,
        R.string.olivo_description,
        R.string.olivo_price
    )

    data object MediaOlivo : MenuInfo(
        R.string.olivo_media,
        R.drawable.pizza_olivo_media,
        R.drawable.card_pizza_olivo_media,
        R.string.olivo_media_description,
        R.string.olivo_media_price
    )

    data object PorcionOlivo : MenuInfo(
        R.string.olivo_porcion,
        R.drawable.pizza_olivo_porcion,
        R.drawable.card_pizza_olivo_porcion,
        R.string.olivo_porcion_description,
        R.string.olivo_porcion_price
    )

    // POSTRES
    data object ArrozConLeche : MenuInfo(
        R.string.arroz_con_leche,
        R.drawable.arroz_con_leche,
        R.drawable.card_postre_arroz_con_leche,
        R.string.arroz_con_leche_description,
        R.string.arroz_con_leche_price,
        "postre"
    )

    // HELADOS
    data object Helado1Bola : MenuInfo(
        R.string.helado_1_bola,
        R.drawable.helado,
        R.drawable.card_helado,
        R.string.helado_1_bola_description,
        R.string.helado_1_bola_price,
        "helado"
    )
    // BEBIDAS
}