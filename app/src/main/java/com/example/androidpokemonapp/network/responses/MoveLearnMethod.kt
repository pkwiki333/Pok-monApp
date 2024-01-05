package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable
/**
 * Data klasse die informatie over de methoden bevat waarmee Pokémon bepaalde bewegingen kunnen leren.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat de naam van de leermethode en een URL naar meer gedetailleerde informatie over deze methode.
 *
 * @property name De naam van de methode waarmee een Pokémon een beweging kan leren.
 * @property url De URL die verwijst naar meer gedetailleerde informatie over de specifieke leermethode.
 */

@Serializable
data class MoveLearnMethod(
    val name: String,
    val url: String
)