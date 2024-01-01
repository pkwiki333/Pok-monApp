package com.example.androidpokemonapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidpokemonapp.model.PokemonList

@Entity(tableName = "YourTeam")
data class DbPokemonList
    (
    @PrimaryKey
    val name: String,
    val pokedexIndex: Int
)

fun PokemonList.asDatabaseObject(): DbPokemonList {
    return DbPokemonList(
        name = name,
        pokedexIndex = pokedexIndex
    )
}

fun DbPokemonList.asDomainObject(): PokemonList {
    return PokemonList(
        name = name,
        pokedexIndex = pokedexIndex
    )
}

fun List<DbPokemonList>.asDomainObject(): List<PokemonList> {
    return map {
        it.asDomainObject()
    }
}