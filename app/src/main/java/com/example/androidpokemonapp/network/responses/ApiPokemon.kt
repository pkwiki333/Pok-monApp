package com.example.androidpokemonapp.network.responses

import com.example.androidpokemonapp.model.Pokemon
import kotlinx.serialization.Serializable

/**
 * Dataklasse die een Pokémon representeert zoals die door de externe API wordt geleverd.
 *
 * Deze klasse bevat gedetailleerde informatie over een specifieke Pokémon, inclusief
 * vaardigheden, ervaringspunten, vormen, spelindices, grootte, en meer.
 *
 * @property abilities Lijst van vaardigheden die de Pokémon heeft.
 * @property height De hoogte van de Pokémon, uitgedrukt in decimeters.
 * @property id Uniek identificatienummer van de Pokémon.
 * @property moves Lijst van aanvallen die de Pokémon kan leren.
 * @property name De naam van de Pokémon.
 * @property types Lijst van types waartoe de Pokémon behoort.
 * @property weight Het gewicht van de Pokémon, uitgedrukt in hectogram.
 */
@Serializable
data class ApiPokemon(
    val abilities: List<Ability>,
    val height: Double,
    val id: Int,
    val moves: List<Move>,
    val name: String,
    val types: List<Type>,
    val weight: Double
)

/**
 * Converteert een [ApiPokemon] instantie naar een [Pokemon] instantie voor gebruik in de domeinlaag.
 * Dit omvat het transformeren van API-specifieke structuren naar meer algemene vormen.
 *
 * @return Een [Pokemon] object met overeenkomende velden van de [ApiPokemon].
 */
fun ApiPokemon.asDomainObject(): Pokemon {
    return Pokemon(
        name = name,
        pokedexIndex = id,
        height = height,
        weight = weight,
        types = types.map { it.type.name },
        abilities = abilities.map { it.ability.name },
        moves = moves.map { it.move.name }
    )
}



