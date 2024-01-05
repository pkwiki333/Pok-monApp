package com.example.androidpokemonapp.network.responses
/**
 * Data klasse die informatie over de tweede generatie Pokémon-spellen, Crystal, Gold en Silver, bevat.
 *
 * Deze klasse bevat geneste dataklassen voor de Crystal, Gold, en Silver versies van de tweede generatie Pokémon-spellen.
 * Elk van deze geneste klassen slaat specifieke data op die uniek is voor hun respectievelijke spelversies.
 *
 * @property crystal Een object van de klasse Crystal, bevat informatie specifiek voor de Crystal versie.
 * @property gold Een object van de klasse Gold, bevat informatie specifiek voor de Gold versie.
 * @property silver Een object van de klasse Silver, bevat informatie specifiek voor de Silver versie.
 */

data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver
)