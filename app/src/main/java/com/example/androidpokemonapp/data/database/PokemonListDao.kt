package com.example.androidpokemonapp.data.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

@Dao
interface PokemonListDao {
    @Query("SELECT * FROM DbPokemonList ORDER BY pokedexIndex ASC")
    fun getPokemonList(): Flow<List<DbPokemonList>>
}