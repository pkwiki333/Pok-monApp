package com.example.androidpokemonapp

import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.fake.FakePokemonListDb
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class PokedexViewModelTest {

    private lateinit var viewModel: PokedexViewModel
    private lateinit var fakeRepository: FakeApiPokemonRepository

    @Before
    fun setup() {
        fakeRepository = FakeApiPokemonRepository()
        viewModel = PokedexViewModel(fakeRepository)
    }

    @Test
    fun getPokemonList() = runTest {

        viewModel.fetchPokemons()
        val state = viewModel.uipokemonListApiState.value
        when (state) {
            is PokemonListApiState.Success -> {
                assertEquals(fakeRepository.getPokemonList(), state.pokemonList)
            }

            else -> {}
        }
    }
}