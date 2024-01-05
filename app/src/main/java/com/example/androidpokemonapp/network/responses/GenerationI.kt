package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die informatie over de eerste generatie Pokémon-spellen, Red/Blue en Yellow, bevat.
 *
 * Deze klasse bevat geneste dataklassen voor zowel de Red/Blue versies als de Yellow versie van de eerste generatie Pokémon-spellen.
 * Elk van deze geneste klassen slaat specifieke data op die uniek is voor hun respectievelijke spelversies.
 *
 * @property redblue Een object van de klasse RedBlue, bevat informatie specifiek voor de Red en Blue versies.
 * @property yellow Een object van de klasse Yellow, bevat informatie specifiek voor de Yellow versie.
 */
data class GenerationI(
    val redblue: RedBlue,
    val yellow: Yellow
)