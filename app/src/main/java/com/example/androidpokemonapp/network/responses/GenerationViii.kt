package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die informatie over de achtste generatie Pokémon-spellen bevat, met specifieke focus op iconen.
 *
 * Deze klasse is ontworpen om iconografische representaties te bevatten die specifiek zijn voor de achtste generatie Pokémon-spellen.
 * Het maakt gebruik van een geneste dataklasse, Icons, om deze representaties te beheren.
 *
 * @property icons Een object van de klasse Icons, bevat iconografische representaties gerelateerd aan de achtste generatie spellen.
 */
data class GenerationViii(
    val icons: Icons
)