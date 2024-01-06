package com.example.androidpokemonapp.viewModelTesten

import com.example.androidpokemonapp.TestDispatcherRule
import com.example.androidpokemonapp.data.database.asDomainObject
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.viewModel.pokedex.PokemonListApiState
import com.example.androidpokemonapp.viewModel.yourTeam.YourPokemonApiState
import com.example.androidpokemonapp.viewModel.yourTeam.YourTeamViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class YourTeamViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()
    private lateinit var viewModel: YourTeamViewModel
    private lateinit var fakeRepository: FakeApiPokemonRepository

    @Before
    fun setup() {
        fakeRepository = FakeApiPokemonRepository()
        viewModel = YourTeamViewModel(fakeRepository)
    }

        @Test
        fun yourTeamViewModel_initialState_isLoading() = runTest {
            val initialState = viewModel.uiYourpokemonApiState.value
            assertTrue(initialState is YourPokemonApiState.Loading)
        }

        @Test
        fun yourTeamViewModel_fetchYourPokemon_emitsSuccessState() = runTest {
            val expectedPokemonList = FakeApiDataSource.getFakePokmeonListYourTeam()
            fakeRepository.DbPokemonListFlow.tryEmit(expectedPokemonList)

            viewModel.fetchYourPokemon()

            val emittedState = viewModel.uiYourpokemonApiState.first()

            assertTrue(emittedState is YourPokemonApiState.Success)
            assertEquals(expectedPokemonList.asDomainObject(), (emittedState as YourPokemonApiState.Success).pokemonDbList)
        }
    @Test
    fun yourTeamViewModel_retrievesRandomPokemon_successState() = runTest {
        viewModel.fetchYourPokemon()
        val state = viewModel.uiYourpokemonApiState.value

        if (state is YourPokemonApiState.Success) {
            Assert.assertNotNull(state.pokemonDbList)
        }
    }
        @Test
        fun yourTeamViewModel_updateIsCatched_updatesCatchedStatus() = runTest {
            val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.uiYourpokemonApiState.collect() }
            val state = viewModel.uiYourpokemonApiState.value

            viewModel.updateIsCatched("Bulbasaur", false)

            val state2 = viewModel.uiYourpokemonApiState.value

            if(state is YourPokemonApiState.Success && state2 is YourPokemonApiState.Success){
                assertTrue(state.pokemonDbList.find { it.name == "Bulbasaur" }!!.isCatched)
                assertFalse(state2.pokemonDbList.find { it.name == "Bulbasaur" }!!.isCatched)
            }
            else
                assertTrue(false)

            collectJob.cancel()
        }


    }
