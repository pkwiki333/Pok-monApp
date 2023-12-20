package com.example.androidpokemonapp.network.responses

import com.example.androidpokemonapp.model.Pokemon
import kotlinx.serialization.Serializable

@Serializable
data class ApiPokemon(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val game_indices: List<GameIndice>,
    val height: Int,
    val held_items: List<Any>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_abilities: List<Any>,
    val past_types: List<Any>,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)


fun ApiPokemon.asDomainObject(): Pokemon {
    return Pokemon(
        name = name,
        pokedexIndex = id,
        height = height,
        weight = weight,
        types = types.map { it.type.name },
        abilities = abilities.map { it.ability.name },
    )
}



