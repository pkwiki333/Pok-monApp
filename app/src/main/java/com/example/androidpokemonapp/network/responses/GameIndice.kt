package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable
/**
 * Data klasse die een index en versie van een Pokémon-game representeert.
 *
 * Deze klasse wordt gebruikt om de unieke index van een Pokémon in een specifieke gameversie op te slaan,
 * samen met informatie over de gameversie zelf. De klasse is gemarkeerd als Serializable voor
 * compatibiliteit met Kotlinx Serialization.
 *
 * @property game_index De unieke index van de Pokémon in de specifieke gameversie.
 * @property version Een object van de klasse Version, die informatie over de gameversie bevat.
 */

@Serializable
data class GameIndice(
    val game_index: Int,
    val version: Version
)