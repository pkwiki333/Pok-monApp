package com.example.androidpokemonapp.viewModelTesten


import com.example.androidpokemonapp.TestDispatcherRule
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.network.responses.asDomainObject
import com.example.androidpokemonapp.viewModel.pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.pokedex.PokemonListApiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Rule
import kotlinx.coroutines.flow.collect

class PokedexViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    private lateinit var viewModel: PokedexViewModel
    private lateinit var fakeRepository: FakeApiPokemonRepository


    @Before
    fun setup() {
        fakeRepository = FakeApiPokemonRepository()
        viewModel = PokedexViewModel(fakeRepository)

        runTest {
            fakeRepository.pokemonListFlow.emit(
                FakeApiDataSource.getFakePokemonList().asDomainObject()
            )
        }

    }

    @Test
    fun pokedexViewModel_initialState_isLoading() = runTest {
        val initialState = viewModel.uipokemonListApiState.value
        assertTrue(initialState is PokemonListApiState.Loading)
    }


    @Test
    fun pokedexViewModel_geeflijstPokemon_successState() = runTest {
        val state = viewModel.uipokemonListApiState.value

        if (state is PokemonListApiState.Success) {
            assertNotNull(state.pokemonList)
        }
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun pokedexViewModel_updatePokemonIsCatched_isCatchedTrue() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.uipokemonListApiState.collect() }
        val state = viewModel.uipokemonListApiState.value

        viewModel.updateIsCatched("Bulbasaur", true)

        val state2 = viewModel.uipokemonListApiState.value

        if(state is PokemonListApiState.Success && state2 is PokemonListApiState.Success){
            assertFalse(state.pokemonList.find { it.name == "Bulbasaur" }!!.isCatched)
            assertTrue(state2.pokemonList.find { it.name == "Bulbasaur" }!!.isCatched)
        }
        else
            assertTrue(false)

        collectJob.cancel()
    }
}
