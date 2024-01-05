package com.example.androidpokemonapp

import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.fake.FakePokemonListDao
import com.example.androidpokemonapp.fake.FakePokemonListDb
import com.example.androidpokemonapp.network.responses.asDomainObject
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class PokedexViewModelTest {

    private val testDispatcher = TestCoroutineDispatcher()
    private lateinit var viewModel: PokedexViewModel
    private lateinit var fakeRepository: FakeApiPokemonRepository


    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        fakeRepository = FakeApiPokemonRepository()
        viewModel = PokedexViewModel(fakeRepository)

    }
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun PokedexViewModel_getPokemonList_lijstAllePokemon() = runTest {

        viewModel.fetchPokemons()
        val state = viewModel.uipokemonListApiState.value
        when (state) {
            is PokemonListApiState.Success -> {
                assertEquals(fakeRepository.getPokemonList(), state.pokemonList)
            }

            else -> {}
        }
    }

   /* @Test
    fun pokedexViewModel_updatePokemonIsCatched_isCatchedTrue() = runTest {
        val pokemonName = "Bulbasaur"
        viewModel.updateIsCatched(pokemonName, true)
        advanceUntilIdle()

        val pokemon = fakeRepository.getPokemonList().first().find { it.name == pokemonName }
        assertEquals(true, pokemon?.isCatched)
    }*/
}