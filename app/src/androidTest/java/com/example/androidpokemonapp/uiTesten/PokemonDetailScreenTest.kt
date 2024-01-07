package com.example.androidpokemonapp.uiTesten

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.ui.PokemonDetailScreen
import com.example.androidpokemonapp.viewModel.pokemonDetails.PokemonApiState
import com.example.androidpokemonapp.viewModel.pokemonDetails.PokemonDetailsViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonDetailScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var repository = FakeApiPokemonRepository()
    private lateinit var viewModel: PokemonDetailsViewModel

    @Before
    fun setup() {
        repository = FakeApiPokemonRepository()
        viewModel = PokemonDetailsViewModel(repository, "Pikachu")
    }
    @Test
    fun pokemonDetailScreen_loadingState_geeftGifImage() {
        viewModel.apply {
            uipokemonApiState = MutableStateFlow(PokemonApiState.Loading)
        }

        composeTestRule.setContent {
            PokemonDetailScreen(name = "Pikachu", padding = PaddingValues())
        }

        composeTestRule.onNodeWithTag("PikachuGif").assertIsDisplayed()
    }

    @Test
    fun pokemonDetailScreen_errorState_geeftErrorPage() {
        viewModel.apply {
            uipokemonApiState = MutableStateFlow(PokemonApiState.Error)
        }

        composeTestRule.setContent {
            PokemonDetailScreen(
                name = "Pikachu",
                padding = PaddingValues(),
                pokemonDetailsViewModel = viewModel
            )
        }
        composeTestRule.onNodeWithTag("errorPsyduck").assertIsDisplayed()
        composeTestRule.onNodeWithTag("errorText").assertIsDisplayed()


    }
}