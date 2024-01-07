package com.example.androidpokemonapp.uiTesten

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.ui.RandomPokemonScreen
import com.example.androidpokemonapp.viewModel.randomPokemon.RandomPokemonApiState
import com.example.androidpokemonapp.viewModel.randomPokemon.RandomPokemonViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RandomPokemonScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var repository = FakeApiPokemonRepository()
    private lateinit var viewModel: RandomPokemonViewModel

    @Before
    fun setup() {
        repository = FakeApiPokemonRepository()
        viewModel = RandomPokemonViewModel(repository)
    }
    @Test
    fun randomPokemonScreen_loadingState_geeftGifImage() {
        viewModel.apply {
            randomPokemonApiState = MutableStateFlow(RandomPokemonApiState.Loading)
        }

        composeTestRule.setContent {
            RandomPokemonScreen(padding = PaddingValues(), randomPokemonViewModel = viewModel)
        }

        composeTestRule.onNodeWithTag("PikachuGif").assertIsDisplayed()
    }

    @Test
    fun randomPokemonScreen_errorState_geeftPsyduckImageEnText() {
        viewModel.apply {
            randomPokemonApiState = MutableStateFlow(RandomPokemonApiState.Error)
        }

        composeTestRule.setContent {
            RandomPokemonScreen(padding = PaddingValues(), randomPokemonViewModel = viewModel)
        }

        composeTestRule.onNodeWithTag("errorPsyduck").assertIsDisplayed()
        composeTestRule.onNodeWithTag("ladenmislukttekst").assertIsDisplayed()
    }
}