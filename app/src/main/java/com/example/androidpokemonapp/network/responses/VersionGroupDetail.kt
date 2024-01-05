package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Data klasse die informatie bevat over het niveau waarop een Pokémon een zet leert, de leermethode voor de zet en de versiegroep waarin de zet beschikbaar is.
 *
 * Deze klasse is gemarkeerd als Serializable om compatibel te zijn met Kotlinx Serialization, wat nuttig is voor het verwerken van netwerkdata.
 * Het bevat het niveau waarop een Pokémon de zet leert, de methode om de zet te leren (bijvoorbeeld "level-up" of "TM"), en de versiegroep waarin de zet beschikbaar is.
 *
 * @property level_learned_at Het niveau waarop de Pokémon de zet leert.
 * @property move_learn_method De leermethode voor de zet, een object van de klasse MoveLearnMethod.
 * @property version_group De versiegroep waarin de zet beschikbaar is, een object van de klasse VersionGroup.
 */
@Serializable
data class VersionGroupDetail(
    val level_learned_at: Int,
    val move_learn_method: MoveLearnMethod,
    val version_group: VersionGroup
)