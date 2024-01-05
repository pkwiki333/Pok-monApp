package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die informatie bevat over een specifieke versiegroep, inclusief de naam en een URL voor meer details.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat de naam van de versiegroep en een URL naar meer gedetailleerde informatie over die specifieke versiegroep, vaak gehost op een externe Pokémon-gerelateerde database of API.
 *
 * @property name De naam van de specifieke versiegroep.
 * @property url De URL die verwijst naar meer gedetailleerde informatie over de specifieke versiegroep.
 */
@Serializable
data class VersionGroup(
    val name: String,
    val url: String
)