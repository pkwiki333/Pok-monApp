package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable
/**
 * Data klasse die informatie bevat over een specifieke Pokémon-beweging.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat essentieel is voor het verwerken van netwerkdata.
 * Het bevat de naam van de beweging en een URL naar meer gedetailleerde informatie over deze beweging.
 *
 * @property name De naam van de specifieke Pokémon-beweging.
 * @property url De URL die verwijst naar meer gedetailleerde informatie over de beweging.
 */

@Serializable
data class MoveX(
    val name: String,
    val url: String
)