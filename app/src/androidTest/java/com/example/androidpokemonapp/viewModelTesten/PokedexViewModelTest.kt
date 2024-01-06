package com.example.androidpokemonapp.viewModelTesten


import com.example.androidpokemonapp.TestDispatcherRule
import com.example.androidpokemonapp.fake.FakeApiDataSource
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.network.responses.asDomainObject
import com.example.androidpokemonapp.viewModel.pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.pokedex.PokemonListApiState
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Rule

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
        Assert.assertTrue(initialState is PokemonListApiState.Loading)
    }


    @Test
    fun PokedexViewModel_geeflijstPokemon_successState() = runTest {
        viewModel.fetchPokemons()
        val state = viewModel.uipokemonListApiState.value

        if (state is PokemonListApiState.Success) {
            assertNotNull(state.pokemonList)
        }
    }

    @Test
    fun pokedexViewModel_updatePokemonIsCatched_isCatchedTrue() = runTest {
        TODO()
    }
}
