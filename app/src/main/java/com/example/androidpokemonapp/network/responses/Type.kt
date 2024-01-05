package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die informatie bevat over het type van een Pokémon en de positie van dat type in de Pokémon.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat de positie van het type in de Pokémon en een object van de klasse TypeX dat het specifieke type beschrijft.
 *
 * @property slot De positie van het type in de Pokémon, bijvoorbeeld de eerste of tweede positie.
 * @property type Een object van de klasse TypeX dat het specifieke type van de Pokémon beschrijft.
 */
@Serializable
data class Type(
    val slot: Int,
    val type: TypeX
)