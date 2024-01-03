package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.network.PokemonApiService
import com.example.androidpokemonapp.network.responses.ApiPokemon
import com.example.androidpokemonapp.network.responses.ApiPokemonList
import com.example.androidpokemonapp.network.responses.asDomainObject

class FakeapiPokemonService: PokemonApiService {
    override suspend fun getPokemonList(limit: Int, offset: Int): ApiPokemonList {
        return FakeApiDataSource.getFakePokemonList()
    }

    override suspend fun getPokemonInfo(name: String): ApiPokemon {
        return FakeApiDataSource.getFakePokemon(name)
    }
}