package com.example.androidpokemonapp.viewModelTesten

import com.example.androidpokemonapp.TestDispatcherRule
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.viewModel.randomPokemon.RandomPokemonApiState
import com.example.androidpokemonapp.viewModel.randomPokemon.RandomPokemonViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RandomPokemonViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()
    private lateinit var viewModel: RandomPokemonViewModel
    private lateinit var fakeRepository: FakeApiPokemonRepository

    @Before
    fun setup() {
        fakeRepository = FakeApiPokemonRepository()
        viewModel = RandomPokemonViewModel(fakeRepository)
    }

    @Test
    fun randomPokemonViewModel_initialState_isLoading() = runTest {
        val initialState = viewModel.randomPokemonApiState.value
        assertTrue(initialState is RandomPokemonApiState.Loading)
    }

    @Test
    fun randomPokemonViewModel_retrievesRandomPokemon_successState() = runTest {
        val state = viewModel.randomPokemonApiState.value
        assertTrue(state is RandomPokemonApiState.Loading || state is RandomPokemonApiState.Success)

        if (state is RandomPokemonApiState.Success) {
            assertNotNull(state.pokemonDetail)
        }
    }
}