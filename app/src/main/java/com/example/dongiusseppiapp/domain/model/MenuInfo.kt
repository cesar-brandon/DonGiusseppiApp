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

    data object Brownies : MenuInfo(
        R.string.brownies,
        R.drawable.brownies,
        R.drawable.card_postre_brownies,
        R.string.brownies_description,
        R.string.brownies_price,
        "postre"
    )

    data object Empanadas : MenuInfo(
        R.string.empanadas,
        R.drawable.empanadas,
        R.drawable.card_postre_empanadas,
        R.string.empanadas_description,
        R.string.empanadas_price,
        "postre"
    )

    data object RollosCanela : MenuInfo(
        R.string.rollos_canela,
        R.drawable.rollos_canela,
        R.drawable.card_postre_rollos_canela,
        R.string.rollos_canela_description,
        R.string.rollos_canela_price,
        "postre"
    )

    data object Yoggis : MenuInfo(
        R.string.yoggis,
        R.drawable.yoggis,
        R.drawable.card_postre_yoggis,
        R.string.yoggis_description,
        R.string.yoggis_price,
        "postre"
    )

    // HELADOS
    data object Helado : MenuInfo(
        R.string.helado_1_bola,
        R.drawable.helado,
        R.drawable.card_helado,
        R.string.helado_1_bola_description,
        R.string.helado_1_bola_price,
        "helado"
    )

    data object Helado4Bolas : MenuInfo(
        R.string.helado_4_bolas,
        R.drawable.helado_copa,
        R.drawable.card_helado_copa,
        R.string.helado_4_bolas_description,
        R.string.helado_4_bolas_price,
        "helado"
    )

    // BEBIDAS
    data object SevenUpPersonal : MenuInfo(
        R.string.seven_up_personal,
        R.drawable.sevenup,
        R.drawable.card_bebida_7up,
        R.string.seven_up_personal_description,
        R.string.seven_up_personal_price,
        "bebida"
    )

    data object SevenUp1Lt : MenuInfo(
        R.string.seven_up_1lt,
        R.drawable.sevenup,
        R.drawable.card_bebida_7up,
        R.string.seven_up_1lt_description,
        R.string.seven_up_1lt_price,
        "bebida"
    )

    data object SporadePersonal : MenuInfo(
        R.string.sporade_personal,
        R.drawable.sporade,
        R.drawable.card_bebida_sporade,
        R.string.sporade_personal_description,
        R.string.sporade_personal_price,
        "bebida"
    )

    data object CocaColaPersonal : MenuInfo(
        R.string.coca_cola_personal,
        R.drawable.coca_cola,
        R.drawable.card_bebida_coca_cola,
        R.string.coca_cola_personal_description,
        R.string.coca_cola_personal_price,
        "bebida"
    )

    data object ConcordiaPersonal : MenuInfo(
        R.string.concordia_personal,
        R.drawable.concordia_mini,
        R.drawable.card_bebida_concordia_mini,
        R.string.concordia_personal_description,
        R.string.concordia_personal_price,
        "bebida"
    )

    data object Concordia1Lt : MenuInfo(
        R.string.concordia_1lt,
        R.drawable.concordia,
        R.drawable.card_bebida_concordia,
        R.string.concordia_1lt_description,
        R.string.concordia_1lt_price,
        "bebida"
    )

    data object FantaPersonal : MenuInfo(
        R.string.fanta_personal,
        R.drawable.fanta,
        R.drawable.card_bebida_fanta,
        R.string.fanta_personal_description,
        R.string.fanta_personal_price,
        "bebida"
    )

    data object IncaKolaPersonal : MenuInfo(
        R.string.inca_kola_personal,
        R.drawable.inca_kola,
        R.drawable.card_bebida_inka_kola,
        R.string.inca_kola_personal_description,
        R.string.inca_kola_personal_price,
        "bebida"
    )
}