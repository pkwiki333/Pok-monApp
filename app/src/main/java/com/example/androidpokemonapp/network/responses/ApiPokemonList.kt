package com.example.androidpokemonapp.network.responses

import com.example.androidpokemonapp.model.PokemonList
import kotlinx.serialization.Serializable

@Serializable
data class ApiPokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)

fun ApiPokemonList.asDomainObject(): List<PokemonList> {
    return results.map {
        PokemonList(
            name = it.name,
            pokedexIndex = it.url.split("/")[6].toInt()
        )
    }
}