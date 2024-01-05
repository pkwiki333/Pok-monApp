package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die basisinformatie over een specifieke Pokémon-soort bevat.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat de naam van de soort en een URL naar meer gedetailleerde informatie over deze soort, vaak gehost op een externe Pokémon-gerelateerde database of API.
 *
 * @property name De naam van de Pokémon-soort.
 * @property url De URL die verwijst naar meer gedetailleerde informatie over de specifieke Pokémon-soort.
 */
@Serializable
data class Species(
    val name: String,
    val url: String
)