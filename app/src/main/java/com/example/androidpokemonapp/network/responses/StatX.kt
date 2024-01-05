package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die informatie over een specifieke statistiek bevat.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat de naam van de statistiek en een URL naar meer gedetailleerde informatie over de statistiek, vaak gehost op een externe Pokémon-gerelateerde database of API.
 *
 * @property name De naam van de statistiek.
 * @property url De URL die verwijst naar meer gedetailleerde informatie over de specifieke statistiek.
 */
@Serializable
data class StatX(
    val name: String,
    val url: String
)