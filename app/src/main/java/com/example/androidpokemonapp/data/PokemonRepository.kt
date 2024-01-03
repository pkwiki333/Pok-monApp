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

interface PokemonRepository {
    fun getPokemonListDB(): Flow<List<PokemonList>>

    fun getPokemonInfoDB(name: String): Flow<Pokemon>

    suspend fun updateCatchedStatus(name: String, isCatched: Boolean)

    suspend fun insertToYourTeam(pokemon: PokemonList)

    suspend fun deletePokemon(pokemon: PokemonList)

    fun getPokemonList(): Flow<List<PokemonList>>

    fun getPokemonInfo(name: String): Flow<Pokemon>

    suspend fun refresh()

}

class PokemonRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val pokemonListDao: PokemonListDao,
    private val pokemonApiService: PokemonApiService
) : PokemonRepository {
    override fun getPokemonListDB(): Flow<List<PokemonList>> {
        return pokemonListDao.getYourTeamList().map {
            it.asDomainObject()
        }
            .combine(pokemonListDao.getYourTeamList()) { pokemonList: List<PokemonList>, dbPokemonList: List<DbPokemonList> ->
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
    }
    override fun getPokemonInfoDB(name: String): Flow<Pokemon> {
        return pokemonDao.getPokemonInfo(name).map {
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
        return pokemonApiService.getPokemonListAsFlow().map {
            it.asDomainObject()
        }
    }

    override fun getPokemonInfo(name: String): Flow<Pokemon> {
        return pokemonApiService.getPokemonAsFlow(name).map {
            it.asDomainObject()
        }
    }

    override suspend fun refresh() {
        pokemonApiService.getPokemonListAsFlow().collect {
            for (pokemon in it.asDomainObject()) {
                Log.i(("PokemonRepositoryImpl"), "refresh: ${pokemon.name}")
                insertToYourTeam(pokemon)
            }
        }
    }
}


