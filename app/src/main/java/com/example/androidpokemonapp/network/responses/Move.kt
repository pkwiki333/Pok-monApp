package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die informatie over een specifieke Pokémon-beweging en de bijbehorende details in verschillende spelversies bevat.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat handig is voor het serialiseren en deserialiseren van netwerkdata.
 * Het omvat een object van de klasse MoveX, die de beweging zelf representeert, en een lijst van VersionGroupDetail, die de details van de beweging in verschillende spelversies bevat.
 *
 * @property move Een object van de klasse MoveX, representeert de specifieke Pokémon-beweging.
 * @property versionGroupDetails Een lijst van VersionGroupDetail objecten, bevat details van de beweging in verschillende versiegroepen van de spellen.
 */
@Serializable
data class Move(
    val move: MoveX,
    val versionGroupDetails: List<VersionGroupDetail>
)