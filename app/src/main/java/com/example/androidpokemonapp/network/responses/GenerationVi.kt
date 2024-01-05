package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die informatie over de zesde generatie Pokémon-spellen, Omega Ruby/Alpha Sapphire en X/Y, bevat.
 *
 * Deze klasse bevat geneste dataklassen voor de Omega Ruby/Alpha Sapphire en X/Y versies van de zesde generatie Pokémon-spellen.
 * Deze geneste klassen bevatten specifieke gegevens uniek voor hun respectievelijke spelversies.
 *
 * @property omegarubyalphasapphire Een object van de klasse OmegarubyAlphasapphire, bevat informatie specifiek voor de Omega Ruby en Alpha Sapphire versies.
 * @property xy Een object van de klasse XY, bevat informatie specifiek voor de X en Y versies.
 */
data class GenerationVi(
    val omegarubyalphasapphire: OmegarubyAlphasapphire,
    val xy: XY
)