package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die informatie bevat over een specifieke versie, inclusief de naam en een URL voor meer details.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat de naam van de versie en een URL naar meer gedetailleerde informatie over die specifieke versie, vaak gehost op een externe Pokémon-gerelateerde database of API.
 *
 * @property name De naam van de specifieke versie.
 * @property url De URL die verwijst naar meer gedetailleerde informatie over de specifieke versie.
 */
@Serializable
data class Version(
    val name: String,
    val url: String
)