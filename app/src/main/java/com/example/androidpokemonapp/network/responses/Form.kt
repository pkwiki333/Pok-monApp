package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die een specifieke vorm van een Pokémon representeert.
 *
 * Deze klasse wordt gebruikt om informatie over verschillende vormen van Pokémon op te slaan,
 * inclusief de naam van de vorm en een URL naar bijbehorende informatie.
 * De klasse is gemarkeerd als Serializable voor compatibiliteit met Kotlinx Serialization.
 *
 * @property name De naam van de Pokémon vorm.
 * @property url De URL die verwijst naar meer informatie over de specifieke vorm.
 */
@Serializable
data class Form(
    val name: String,
    val url: String
)