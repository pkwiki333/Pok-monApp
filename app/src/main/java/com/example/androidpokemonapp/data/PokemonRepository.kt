package com.example.androidpokemonapp.data

import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.PokemonApiService
import com.example.androidpokemonapp.network.responses.ApiPokemon
import com.example.androidpokemonapp.network.responses.ApiPokemonList
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface PokemonRepository {
     suspend fun getPokemonList(): List<PokemonList>
     suspend fun getPokemonInfo(name: String): Pokemon

}

class PokemonRepositoryImpl(private val pokemonApiService: PokemonApiService) : PokemonRepository {
    override suspend fun getPokemonList(): List<PokemonList> {
        return pokemonApiService.getPokemonList().asDomainObject()
    }


    override suspend fun getPokemonInfo(name: String): Pokemon {
        return pokemonApiService.getPokemonInfo(name).asDomainObject()
    }


}