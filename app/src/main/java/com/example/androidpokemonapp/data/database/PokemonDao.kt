package com.example.androidpokemonapp.data.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM DbPokemon where name = :name")
    fun getPokemonInfo(name: String): Flow<DbPokemon>
}