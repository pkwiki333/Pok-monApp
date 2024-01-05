package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die informatie bevat over het specifieke type van een Pokémon.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat de naam van het type en een URL naar meer gedetailleerde informatie over dat specifieke type, vaak gehost op een externe Pokémon-gerelateerde database of API.
 *
 * @property name De naam van het specifieke type.
 * @property url De URL die verwijst naar meer gedetailleerde informatie over het specifieke type.
 */
@Serializable
data class TypeX(
    val name: String,
    val url: String
)