package com.example.androidpokemonapp.uiTesten

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidpokemonapp.fake.FakeApiPokemonRepository
import com.example.androidpokemonapp.ui.YourTeamScreen
import com.example.androidpokemonapp.viewModel.yourTeam.YourPokemonApiState
import com.example.androidpokemonapp.viewModel.yourTeam.YourTeamViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class YourTeamScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var viewModel: YourTeamViewModel
    private lateinit var repository: FakeApiPokemonRepository
    private var onPokemonClicked = false

    @Before
    fun setup() {
        repository = FakeApiPokemonRepository()
        viewModel = YourTeamViewModel(repository)
    }


    @Test
    fun yourTeamScreen_loadingState_geeftLoadingIndicator() {
        viewModel.apply {
            uiYourpokemonApiState = MutableStateFlow(YourPokemonApiState.Loading)
        }

        composeTestRule.setContent {
            YourTeamScreen(onPokemonClicked = {onPokemonClicked = true}, padding = PaddingValues())
        }

        composeTestRule.onNodeWithTag("PikachuGif").assertIsDisplayed()
    }

    @Test
    fun yourTeamScreen_errorState_geeftErrorPage() {
        viewModel.apply {
            uiYourpokemonApiState = MutableStateFlow(YourPokemonApiState.Error)
        }

        composeTestRule.setContent {
            YourTeamScreen(
                padding = PaddingValues(),
                onPokemonClicked = { onPokemonClicked = true },
                yourTeamViewModel = viewModel
            )
        }
        composeTestRule.onNodeWithTag("errorPsyduck").assertIsDisplayed()
        composeTestRule.onNodeWithTag("errorText").assertIsDisplayed()
    }
}