package com.example.androidpokemonapp.data.database

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object voor de Pokémon entiteit.
 * Deze interface biedt methoden voor interactie met de Pokémon data in de database.
 */
@Dao
interface PokemonDao {

    /**
     * Haalt de informatie van een specifieke Pokémon op basis van de naam.
     * De informatie wordt weergegeven als een Flow.
     *
     * @param name De naam van de Pokémon waarvan de informatie moet worden opgehaald.
     * @return Een Flow van [DbPokemon] die de informatie over de Pokémon bevat.
     */
    @Query("SELECT * FROM DbPokemon where name = :name")
    fun getPokemonInfo(name: String): Flow<DbPokemon>
}