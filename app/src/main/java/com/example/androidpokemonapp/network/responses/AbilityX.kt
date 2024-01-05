package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

/**
 * Dataklasse die de basisinformatie van een Pokémon-vaardigheid representeert, zoals ontvangen van een netwerkrespons.
 *
 * Deze klasse wordt gebruikt binnen de responsstructuur van de Pokémon API om basisgegevens van een Pokémon-vaardigheid
 * vast te leggen, inclusief de naam en een URL waar meer informatie over de vaardigheid te vinden is.
 *
 * @property name De naam van de Pokémon-vaardigheid.
 * @property url De URL naar de bron waar meer details over de betreffende vaardigheid te vinden zijn.
 */
@Serializable
data class AbilityX(
    val name: String,
    val url: String
)