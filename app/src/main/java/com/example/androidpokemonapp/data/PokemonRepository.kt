package com.example.androidpokemonapp.data

import android.util.Log
import com.example.androidpokemonapp.data.database.DbPokemonList
import com.example.androidpokemonapp.data.database.PokemonDao
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.PokemonApiService
import com.example.androidpokemonapp.network.getPokemonAsFlow
import com.example.androidpokemonapp.network.getPokemonListAsFlow
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * Interface die definieert welke operaties beschikbaar zijn voor interactie met Pokémon-gegevens.
 * Dit omvat het ophalen van gegevens uit de lokale database en de externe API.
 */
interface PokemonRepository {
    /**
     * Haalt een lijst op van alle Pokémon in de lokale database.
     *
     * @return Een Flow van een lijst van [PokemonList], die de gevangen Pokémon vertegenwoordigt.
     */
    fun getPokemonListDB(): Flow<List<PokemonList>>

    /**
     * Werkt de vangstatus van een specifieke Pokémon bij in de lokale database.
     *
     * @param name De naam van de Pokémon.
     * @param isCatched De nieuwe vangstatus.
     */
    suspend fun updateCatchedStatus(name: String, isCatched: Boolean)

    /**
     * Voegt een Pokémon toe aan je team in de lokale database.
     *
     * @param pokemon Het [PokemonList] object dat toegevoegd moet worden.
     */
    suspend fun insertToYourTeam(pokemon: PokemonList)

    /**
     * Verwijdert een Pokémon uit je team in de lokale database.
     *
     * @param pokemon Het [PokemonList] object dat verwijderd moet worden.
     */
    suspend fun deletePokemon(pokemon: PokemonList)

    /**
     * Haalt een lijst op van alle Pokémon van een externe API.
     *
     * @return Een Flow van een lijst met [PokemonList].
     */
    fun getPokemonList(): Flow<List<PokemonList>>

    /**
     * Haalt gedetailleerde informatie op over een specifieke Pokémon van een externe API.
     *
     * @param name De naam van de Pokémon.
     * @return Een Flow van [Pokemon] met gedetailleerde informatie.
     */
    fun getPokemonInfo(name: String): Flow<Pokemon>

}

/**
 * Implementatie van [PokemonRepository] die gebruikmaakt van een lokale RoomDB, een externe API, en DAO's.
 * Biedt functionaliteiten zoals het ophalen, bijwerken en verwijderen van Pokémon-gegevens.
 *
 * @property pokemonDao DAO voor interactie met de Pokémon-gegevens in de RoomDB.
 * @property pokemonListDao DAO voor interactie met de Pokémon lijst in de RoomDB.
 * @property pokemonApiService Service voor het ophalen van gegevens van de externe Pokémon API.
 */
class PokemonRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val pokemonListDao: PokemonListDao,
    private val pokemonApiService: PokemonApiService
) : PokemonRepository {
    override fun getPokemonListDB(): Flow<List<PokemonList>> {
        return pokemonListDao.getYourTeamList().map {
            it.asDomainObject()
        }
    }

    override suspend fun updateCatchedStatus(name: String, isCatched: Boolean) {
        pokemonListDao.updateCatchedStatus(name, isCatched)
    }

    override suspend fun insertToYourTeam(pokemon: PokemonList) {
        pokemonListDao.insertToYourTeam(pokemon.asDatabaseObject())
    }

    override suspend fun deletePokemon(pokemon: PokemonList) {
        pokemonListDao.deletePokemon(pokemon.asDatabaseObject())
    }

    override fun getPokemonList(): Flow<List<PokemonList>> {
        try{
            return pokemonApiService.getPokemonListAsFlow().map {
                it.asDomainObject()
            }.combine(pokemonListDao.getYourTeamList()) { pokemonList: List<PokemonList>, dbPokemonList: List<DbPokemonList> ->
                val keys: List<String> = dbPokemonList.map {
                    it.name
                }
                pokemonList.map {
                    if (keys.contains(it.name))
                        return@map it.copy(isCatched = true)
                    else
                        return@map it
                }

            }
        }catch (e: IOException){
            throw IOException("Unable to get pokemon list", e)
        }

    }

    override fun getPokemonInfo(name: String): Flow<Pokemon> {
        try{
            return pokemonApiService.getPokemonAsFlow(name).map {
                it.asDomainObject()
            }
        }catch (e: IOException){
            throw IOException("Unable to get pokemon info", e)
        }

    }

}


