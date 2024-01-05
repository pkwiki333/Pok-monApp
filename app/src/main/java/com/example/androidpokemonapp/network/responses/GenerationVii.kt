package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die informatie over de zevende generatie Pokémon-spellen bevat, met specifieke aandacht voor iconen en de Ultra Sun/Ultra Moon versies.
 *
 * Deze klasse bevat geneste dataklassen die zijn afgestemd op de unieke kenmerken van de zevende generatie, waaronder de iconen gebruikt in deze spellen en de specifieke eigenschappen van de Ultra Sun en Ultra Moon versies.
 *
 * @property icons Een object van de klasse Icons, bevat iconografische representaties gerelateerd aan de zevende generatie spellen.
 * @property ultrasunultramoon Een object van de klasse UltraSunUltraMoon, bevat informatie specifiek voor de Ultra Sun en Ultra Moon versies.
 */
data class GenerationVii(
    val icons: Icons,
    val ultrasunultramoon: UltraSunUltraMoon
)