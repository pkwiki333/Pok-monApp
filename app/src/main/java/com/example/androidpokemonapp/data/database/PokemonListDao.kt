package com.example.androidpokemonapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToYourTeam(pokemon: DbPokemonList)

    @Delete
    suspend fun deletePokemon(pokemon: DbPokemonList)

    /*@Query("UPDATE yourteam SET isCatched = :isCatched WHERE name = :name")
    suspend fun updateCatchedStatus(name: String, isCatched: Boolean)*/

    @Query("SELECT * FROM YourTeam ORDER BY pokedexIndex ASC")
    fun getYourTeamList(): Flow<List<DbPokemonList>>
}