package com.example.androidpokemonapp.data

import android.util.Log
import androidx.room.Query
import com.example.androidpokemonapp.data.database.DbPokemon
import com.example.androidpokemonapp.data.database.DbPokemonList
import com.example.androidpokemonapp.data.database.PokemonDao
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.PokemonApiService
import com.example.androidpokemonapp.network.getPokemonAsFlow
import com.example.androidpokemonapp.network.getPokemonListAsFlow
import com.example.androidpokemonapp.network.responses.ApiPokemon
import com.example.androidpokemonapp.network.responses.ApiPokemonList
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

interface PokemonRepository {
    fun getPokemonListDB(): Flow<List<PokemonList>>

    fun getPokemonInfoDB(name: String): Flow<Pokemon>

    fun getPokemonList(): Flow<List<PokemonList>>

    fun getPokemonInfo(name: String): Flow<Pokemon>

    //suspend fun refresh()

}

class PokemonRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val pokemonListDao: PokemonListDao,
    private val pokemonApiService: PokemonApiService
) : PokemonRepository {
    override fun getPokemonListDB(): Flow<List<PokemonList>> {
        return pokemonListDao.getPokemonList().map {
            it.asDomainObject()
        }
}
    override fun getPokemonInfoDB(name: String): Flow<Pokemon> {
        return pokemonDao.getPokemonInfo(name).map {
            it.asDomainObject()
        }
    }

    override fun getPokemonList(): Flow<List<PokemonList>> {
        val response = pokemonApiService.getPokemonListAsFlow().map {
            it.asDomainObject()
        }
        Log.i("PokemonRepositoryImpl", "!!!!!!!!!getPokemonList: $response")
        return response
        /*return pokemonApiService.getPokemonListAsFlow().map {
            it.asDomainObject()
        }*/

    }

    override fun getPokemonInfo(name: String): Flow<Pokemon> {
        return pokemonApiService.getPokemonAsFlow(name).map {
            it.asDomainObject()
        }
    }

   /* override suspend fun refresh() {
        pokemonApiService.getPokemonListAsFlow().map {
            Log.i("PokemonRepositoryImpl", "!!!!!!!!!refresh: $it")
            it.asDomainObject()
        }
        *//*val pokemonList = pokemonApiService.getPokemonList()
        val pokemon = pokemonApiService.getPokemonInfo("bulbasaur")
        pokemonListDao.insertAll(pokemonList.results.map { it.asDatabaseObject() })
        pokemonDao.insert(pokemon.asDatabaseObject())*//*
    }*/

}


