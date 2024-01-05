package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die informatie over de vijfde generatie Pokémon-spellen, Black en White, bevat.
 *
 * Deze klasse bevat een geneste dataklasse voor de Black en White versies van de vijfde generatie Pokémon-spellen.
 * Deze geneste klasse bevat specifieke gegevens uniek voor de Black en White spelversies.
 *
 * @property blackwhite Een object van de klasse BlackWhite, bevat informatie specifiek voor de Black en White versies.
 */
data class GenerationV(
    val blackwhite: BlackWhite
)