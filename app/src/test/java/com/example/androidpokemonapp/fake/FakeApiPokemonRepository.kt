package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.data.PokemonRepository
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeApiPokemonRepository: PokemonRepository {
    override fun getPokemonListDB(): Flow<List<PokemonList>> {
        return flowOf(FakeApiDataSource.getFakePokemonList().asDomainObject())
    }

    override fun getPokemonInfoDB(name: String): Flow<Pokemon> {
        TODO("Not yet implemented")
    }

    override suspend fun updateCatchedStatus(name: String, isCatched: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun insertToYourTeam(pokemon: PokemonList) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePokemon(pokemon: PokemonList) {
        TODO("Not yet implemented")
    }

    override fun getPokemonList(): Flow<List<PokemonList>> {
        return flowOf(FakeApiDataSource.getFakePokemonList().asDomainObject())
    }

    override fun getPokemonInfo(name: String): Flow<Pokemon> {
        return flowOf(FakeApiDataSource.getFakePokemon(name).asDomainObject())
    }

}
