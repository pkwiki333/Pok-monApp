package com.example.androidpokemonapp


import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test



class ApiPokemonRepositoryTest {

    private lateinit var repository: FakeApiPokemonRepository

    @Before
    fun setUp() {
        /*repository = PokemonRepositoryImpl(
            pokemonDao = FakePokemonDao(),
            pokemonListDao = FakePokemonListDao(),
            pokemonApiService = FakeapiPokemonService()
        )*/
        repository = FakeApiPokemonRepository()
    }

    @Test
    fun apiPokemonRepository_getAllPokemons_verifyPokemonsList() = runTest {

        val actualResults = repository.getPokemonList().first()
        val expectedResults = FakeApiDataSource.getFakePokemonList().asDomainObject()

        assertEquals(expectedResults, actualResults)
    }

    @Test
    fun apiPokemonRepository_getPokemonInfo_verifyPokemonInfo() =
        runTest {
            val actualResults = FakeApiDataSource.getFakePokemon("bulbasaur").asDomainObject()
            val expectedResults = repository.getPokemonInfo("bulbasaur").first()

            assertEquals(actualResults, expectedResults)
        }

    @Test
    fun dBPokemonRepository_getPokemonCatched_verifyPokemonCatched() = runTest {
        val actualResults = repository.getPokemonListDB().first()

        val expectedResults = FakeApiDataSource.getFakeDbPokemonList().asDatabaseObject()
            .filter { pokemon -> pokemon.isCatched }.asDomainObject()

        assertEquals(expectedResults, actualResults)
    }

   @Test
    fun dBPokemonRepository_updateIsCatched_verifyPokemonisCatchedUpdate() = runTest {

        repository.updateCatchedStatus("Bulbasaur", true)

        val actualResult = repository.getPokemonList().first().find { it.name == "Bulbasaur" }?.isCatched

        assertEquals(true, actualResult)
    }
}


