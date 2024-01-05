package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Dataklasse die een Pokémon-vaardigheid (ability) representeert, zoals ontvangen van een netwerkrespons.
 *
 * Deze klasse maakt deel uit van de datastructuur die gebruikt wordt voor het deserializeren van
 * responsgegevens van de Pokémon API. Het bevat details over een specifieke vaardigheid van een Pokémon.
 *
 * @property ability Een genest object van type [AbilityX] dat de daadwerkelijke vaardigheid beschrijft.
 * @property is_hidden Een boolean die aangeeft of de vaardigheid een verborgen vaardigheid is.
 * @property slot Een integer die de specifieke slot positie van deze vaardigheid op een Pokémon aangeeft.
 */
@Serializable
data class Ability(
    val ability: AbilityX,
    val is_hidden: Boolean,
    val slot: Int
)