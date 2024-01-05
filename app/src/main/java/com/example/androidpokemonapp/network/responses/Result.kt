package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die algemene informatie bevat, typisch gebruikt als een onderdeel van een netwerkresponse.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat helpt bij het verwerken van netwerkdata.
 * Het bevat een naam en een URL, die vaak gebruikt worden om referenties naar specifieke items of entiteiten in de Pokémon-app te vertegenwoordigen.
 *
 * @property name De naam van het item of de entiteit, vaak een Pokémon-naam of een andere gerelateerde term.
 * @property url De URL die verwijst naar meer gedetailleerde informatie over het betreffende item of de entiteit.
 */
@Serializable
data class Result(
    val name: String,
    val url: String
)