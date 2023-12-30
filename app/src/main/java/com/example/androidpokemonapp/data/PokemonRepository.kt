package com.example.androidpokemonapp.data

import androidx.room.Query
import com.example.androidpokemonapp.data.database.DbPokemon
import com.example.androidpokemonapp.data.database.DbPokemonList
import com.example.androidpokemonapp.data.database.PokemonDao
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.PokemonApiService
import com.example.androidpokemonapp.network.getPokemonListAsFlow
import com.example.androidpokemonapp.network.responses.ApiPokemon
import com.example.androidpokemonapp.network.responses.ApiPokemonList
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

interface PokemonRepository {
    fun getPokemonList(): Flow<List<PokemonList>>

    fun getPokemonInfo(name: String): Flow<Pokemon>

}

class PokemonRepositoryImpl(
    private val pokemonDao: PokemonDao,
    private val pokemonListDao: PokemonListDao,
    private val pokemonApiService: PokemonApiService
) : PokemonRepository {
    override fun getPokemonList(): Flow<List<PokemonList>> {
        return pokemonListDao.getPokemonList().map {
            it.asDomainObject()
        }
}
    override fun getPokemonInfo(name: String): Flow<Pokemon> {
        return pokemonDao.getPokemonInfo(name).map {
            it.asDomainObject()
        }
    }
}


