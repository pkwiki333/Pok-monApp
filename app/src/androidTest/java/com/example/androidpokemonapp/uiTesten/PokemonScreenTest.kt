package com.example.androidpokemonapp.uiTesten

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.androidpokemonapp.MainActivity
import com.example.androidpokemonapp.ui.PokemonScreen
import com.example.androidpokemonapp.ui.ScreensEnum
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PokemonScreenTest {
    var randomPokemon = false
    var pokedexClicked = false
    var yourTeamClicked = false

    @get:Rule
    val composeTestRule =createComposeRule()

    @Test
    fun pokemonScreen_randomPokemonButton_isDisplayed() {
        composeTestRule.setContent {
            PokemonScreen(
                onRandomPokemonClick = { randomPokemon = true },
                onPokedexClicked = { pokedexClicked = true },
                onYourTeamClicked = { yourTeamClicked = true }
            )
        }

        composeTestRule
            .onNodeWithText("Random Pokémon")
            .performClick()
        assertTrue(randomPokemon)
    }

    @Test
    fun pokemonScreen_pokedexButton_isDisplayed() {
        composeTestRule.setContent {
            PokemonScreen(
                onRandomPokemonClick = { randomPokemon = true },
                onPokedexClicked = { pokedexClicked = true },
                onYourTeamClicked = { yourTeamClicked = true }
            )
        }

        // Assert dat de "Pokédex" knop wordt weergegeven
        composeTestRule
            .onNodeWithText("Pokédex")
            .performClick()
        assertTrue(pokedexClicked)
    }

    @Test
    fun pokemonScreen_yourTeamButton_isDisplayed() {
        composeTestRule.setContent {
            PokemonScreen(
                onRandomPokemonClick = { randomPokemon = true },
                onPokedexClicked = { pokedexClicked = true },
                onYourTeamClicked = { yourTeamClicked = true }
            )
        }

        // Assert dat de "Your team" knop wordt weergegeven
        composeTestRule
            .onNodeWithText("Your team")
            .performClick()
        assertTrue(yourTeamClicked)
    }
}