package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die informatie bevat over het niveau waarop een Pokémon een zet leert, de leermethode voor de zet en de versiegroep waarin de zet beschikbaar is.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat het niveau waarop een Pokémon de zet leert, de methode om de zet te leren (bijvoorbeeld "level-up" of "TM"), en de versiegroep waarin de zet beschikbaar is.
 *
 * @property levelLearnedAt Het niveau waarop de Pokémon de zet leert.
 * @property moveLearnMethod De leermethode voor de zet, een object van de klasse MoveLearnMethod.
 * @property versionGroup De versiegroep waarin de zet beschikbaar is, een object van de klasse VersionGroup.
 */
@Serializable
data class VersionGroupDetail(
    val levelLearnedAt: Int,
    val moveLearnMethod: MoveLearnMethod,
    val versionGroup: VersionGroup
)