package com.example.androidpokemonapp.uiTesten

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.ui.PokedexScreen
import com.example.androidpokemonapp.viewModel.pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.pokedex.PokemonListApiState
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokedexScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var viewModel: PokedexViewModel
    private lateinit var repository: FakeApiPokemonRepository
    private var pokedexClicked = false

    @Before
    fun setup() {
        repository = FakeApiPokemonRepository()
        viewModel = PokedexViewModel(repository)
    }

    @Test
    fun pokedexScreen_loadingState_geeftLoadingPikachuGif() {
        viewModel.apply {
            uipokemonListApiState = MutableStateFlow(PokemonListApiState.Loading)
        }

        composeTestRule.setContent {
            PokedexScreen(
                padding = PaddingValues(),
                onPokemonClicked = { pokedexClicked = true },
                pokedexViewModel = viewModel
            )
        }

        composeTestRule.onNodeWithTag("PikachuGif").assertIsDisplayed()
    }

    @Test
    fun pokedexScreen_errorState_geeftErrorPage() {
        viewModel.apply {
            uipokemonListApiState = MutableStateFlow(PokemonListApiState.Error)
        }

        composeTestRule.setContent {
            PokedexScreen(
                padding = PaddingValues(),
                onPokemonClicked = { pokedexClicked = true },
                pokedexViewModel = viewModel
            )
        }

        composeTestRule.onNodeWithTag("errorPsyduck").assertIsDisplayed()
    }
}