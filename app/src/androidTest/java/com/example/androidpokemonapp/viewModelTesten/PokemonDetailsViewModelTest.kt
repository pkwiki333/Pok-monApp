package com.example.androidpokemonapp.viewModelTesten

import com.example.androidpokemonapp.TestDispatcherRule
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.viewModel.pokemonDetails.PokemonApiState
import com.example.androidpokemonapp.viewModel.pokemonDetails.PokemonDetailsViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonDetailsViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    private lateinit var viewModel: PokemonDetailsViewModel
    private lateinit var fakeRepository: FakeApiPokemonRepository

    @Before
    fun setup() {
        fakeRepository = FakeApiPokemonRepository()
        viewModel = PokemonDetailsViewModel(fakeRepository, "Bulbasaur")
    }

    @Test
    fun pokemonDetailViewModel_initialState_isLoading() = runTest {
        val initialState = viewModel.uipokemonApiState.value
        assertTrue(initialState is PokemonApiState.Loading)
    }

    @Test
    fun pokemonDetailViewModel_geefDetailsPokemon_successState() = runTest {
        viewModel.getPokemonDetail("Bulbasaur")
        val state = viewModel.uipokemonApiState.value

        if (state is PokemonApiState.Success) {
            Assert.assertNotNull(state.pokemon)
        }
    }


}