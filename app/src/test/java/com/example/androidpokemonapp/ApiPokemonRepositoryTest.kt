package com.example.androidpokemonapp

import com.example.androidpokemonapp.data.PokemonRepositoryImpl
import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakePokemonDao
import com.example.androidpokemonapp.fake.FakePokemonListDao
import com.example.androidpokemonapp.fake.FakeapiPokemonService
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ApiPokemonRepositoryTest {

    @Test
    fun apiPokemonRepository_getAllPokemons_verifyPokemonsList() = runTest {
        val repository = PokemonRepositoryImpl(
            pokemonDao = FakePokemonDao(),
            pokemonListDao = FakePokemonListDao(),
            pokemonApiService = FakeapiPokemonService()
        )
        val actualResults = repository.getPokemonList().first()

        val expectedResults = FakeApiDataSource.getFakePokemonList().asDomainObject()

        assertEquals(expectedResults, actualResults)
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

    @Test
    fun DBPokemonRepository_getPokemonCatched_verifyPokemonCatched() = runTest {
        val repository = PokemonRepositoryImpl(
            pokemonDao = FakePokemonDao(),
            pokemonListDao = FakePokemonListDao(),
            pokemonApiService = FakeapiPokemonService()
        )
        val actualResults = repository.getPokemonListDB().first()

        val expectedResults = FakeApiDataSource.getFakeDbPokemonList().asDatabaseObject().filter { pokemon -> pokemon.isCatched }.asDomainObject()

        assertEquals(expectedResults, actualResults)
    }
}


