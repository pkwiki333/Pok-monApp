package com.example.androidpokemonapp


import android.util.Log
import com.example.androidpokemonapp.data.PokemonRepository
import com.example.androidpokemonapp.data.PokemonRepositoryImpl
import com.example.androidpokemonapp.data.database.DbPokemonList
import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.fake.FakePokemonDao
import com.example.androidpokemonapp.fake.FakePokemonListDao
import com.example.androidpokemonapp.fake.FakeapiPokemonService
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class ApiPokemonRepositoryTest {

    private lateinit var repository: PokemonRepositoryImpl
    private lateinit var fakePokemonListDao: FakePokemonListDao

    @Before
    fun setUp() {
        fakePokemonListDao = FakePokemonListDao()
        repository = PokemonRepositoryImpl(
            pokemonDao = FakePokemonDao(),
            pokemonListDao = fakePokemonListDao,
            pokemonApiService = FakeapiPokemonService()
        )
    }

    @Test
    fun apiPokemonRepository_getAllPokemons_verifyPokemonsList() = runTest {

        val actualResults = repository.getPokemonList().first()
        advanceUntilIdle()
        val expectedResults = FakeApiDataSource.getFakePokemonList().asDomainObject()
        advanceUntilIdle()
        assertEquals(expectedResults, actualResults)
    }

    @Test
    fun apiPokemonRepository_getPokemonInfo_verifyPokemonInfo() = runTest {
        val fakePokemon = FakeApiDataSource.getPokemon()
        val expectedResults = repository.getPokemonInfo("bulbasaur").first()

        assertEquals(fakePokemon, expectedResults)
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
        val pokemon = DbPokemonList("Bulbasaur", 1, false)
        fakePokemonListDao.insertToYourTeam(pokemon)
        advanceUntilIdle()
        val bulbasaur = repository.getPokemonList().first().find { it.name == "Bulbasaur" }
        assertNotNull("bulbasaur", bulbasaur)
        advanceUntilIdle()
        if (bulbasaur != null) {
            repository.insertToYourTeam(bulbasaur)
            repository.updateCatchedStatus(bulbasaur.name, true)


            val actualResult =
                repository.getPokemonList().first().find { it.name == "Bulbasaur" }?.isCatched
            assertEquals(true, actualResult)

        }

    }
}


