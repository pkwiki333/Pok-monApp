package com.example.androidpokemonapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidpokemonapp.model.PokemonList

@Entity(tableName = "YourTeam")
data class DbPokemonList
    (
    @PrimaryKey
    val name: String,
    val pokedexIndex: Int,
    //val isCatched: Boolean = false
)

fun PokemonList.asDatabaseObject(): DbPokemonList {
    return DbPokemonList(
        name = name,
        pokedexIndex = pokedexIndex,
        //isCatched = isCatched
    )
}

fun DbPokemonList.asDomainObject(): PokemonList {
    return PokemonList(
        name = name,
        pokedexIndex = pokedexIndex,
       // isCatched = isCatched
    )
}

fun List<DbPokemonList>.asDomainObject(): List<PokemonList> {
    return map {
        it.asDomainObject()
    }
}