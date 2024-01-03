package com.example.androidpokemonapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidpokemonapp.model.Pokemon

@Entity
data class DbPokemon(
    @PrimaryKey
    val name: String,
    val pokedexIndex: Int,
    val height: Double,
    val weight: Double,
    val types: List<String>,
    val abilities: List<String>,
    val moves: List<String>
)

fun Pokemon.asDatabaseObject(): DbPokemon {
    return DbPokemon(
        name = name,
        pokedexIndex = pokedexIndex,
        height = height,
        weight = weight,
        types = types,
        abilities = abilities,
        moves = moves
    )
}

fun DbPokemon.asDomainObject(): Pokemon {
    return Pokemon(
        name = name,
        pokedexIndex = pokedexIndex,
        height = height,
        weight = weight,
        types = types,
        abilities = abilities,
        moves = moves
    )
}

fun List<DbPokemon>.asDomainObject(): List<Pokemon> {
    return map {
        it.asDomainObject()
    }
}