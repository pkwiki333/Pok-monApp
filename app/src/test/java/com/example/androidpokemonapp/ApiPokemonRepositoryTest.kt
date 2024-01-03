package com.example.androidpokemonapp

import com.example.androidpokemonapp.data.PokemonRepositoryImpl
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakePokemonDao
import com.example.androidpokemonapp.fake.FakePokemonListDao
import com.example.androidpokemonapp.fake.FakeapiPokemonService
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ApiPokemonRepositoryTest {
    @Test
    fun apiPokemonRepository_getPokemons_verifyPokemonsList() =
        runTest {

            val repository = PokemonRepositoryImpl(
                pokemonDao = FakePokemonDao(),
                pokemonListDao = FakePokemonListDao(),
                pokemonApiService = FakeapiPokemonService()
            )
        assertEquals(FakeApiDataSource.getFakePokemonList().asDomainObject(), repository.getPokemonList().first())
    }

    @Test
    fun apiPokemonRepository_getPokemonInfo_verifyPokemonInfo() =
        runTest {
            val repository = PokemonRepositoryImpl(
                pokemonDao = FakePokemonDao(),
                pokemonListDao = FakePokemonListDao(),
                pokemonApiService = FakeapiPokemonService()
            )
            assertEquals(FakeApiDataSource.getFakePokemon("bulbasaur").asDomainObject(), repository.getPokemonInfo("bulbasaur").first())
        }
}

