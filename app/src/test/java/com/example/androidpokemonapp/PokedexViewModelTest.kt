package com.example.androidpokemonapp

import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.viewModel.pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.pokedex.PokemonListApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.TestCoroutineDispatcher
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
    fun pokedexViewModel_getPokemonList_lijstAllePokemon() = runTest {

        viewModel.fetchPokemons()
        when (val state = viewModel.uipokemonListApiState.value) {
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