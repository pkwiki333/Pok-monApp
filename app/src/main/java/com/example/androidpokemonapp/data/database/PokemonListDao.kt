package com.example.androidpokemonapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object (DAO) interface voor het beheren van Pokémon-gegevens in de RoomDB.
 * Deze interface definieert methoden voor het invoegen, verwijderen, bijwerken en opvragen van Pokémon-gegevens.
 */
@Dao
interface PokemonListDao {

    /**
     * Voegt een Pokémon toe aan je team in de database.
     * Bij een conflict, zoals een bestaande Pokémon met dezelfde naam, wordt de bestaande vervangen.
     *
     * @param pokemon De Pokémon om toe te voegen of te vervangen in de database.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToYourTeam(pokemon: DbPokemonList)

    /**
     * Verwijdert een Pokémon uit de database.
     *
     * @param pokemon De Pokémon die verwijderd moet worden.
     */
    @Delete
    suspend fun deletePokemon(pokemon: DbPokemonList)

    /**
     * Werkt de 'gevangen' status van een specifieke Pokémon bij in de database.
     *
     * @param name De naam van de Pokémon waarvan de status wordt bijgewerkt.
     * @param isCatched De nieuwe 'gevangen' status (true of false).
     */
    @Query("UPDATE yourteam SET isCatched = :isCatched WHERE name = :name")
    suspend fun updateCatchedStatus(name: String, isCatched: Boolean)

    /**
     * Haalt een lijst op van alle Pokémon in je team, gesorteerd op Pokédex-index.
     * De lijst wordt weergegeven als een Flow, wat betekent dat elke keer als de gegevens in de database worden bijgewerkt,
     * de observer hierover wordt geïnformeerd met de nieuwste lijst.
     *
     * @return Een Flow van een lijst van [DbPokemonList] die alle Pokémon in je team bevat.
     */
    @Query("SELECT * FROM YourTeam ORDER BY pokedexIndex ASC")
    fun getYourTeamList(): Flow<List<DbPokemonList>>
}