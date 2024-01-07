package com.example.androidpokemonapp.uiTesten

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.ui.PokemonCard
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class PokemonCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    var pokemonClicked = false
    var pokemonCatched = false

    @Test
    fun pokemonCard_geeftPokemonName() {
        val testPokemon = PokemonList(name = "Pikachu", pokedexIndex = 25, isCatched = false)

        composeTestRule.setContent {
            PokemonCard(
                pokemon = testPokemon,
                onPokemonClicked = {pokemonClicked = true},
                onPokemonCatched = {pokemonCatched = true},
                modifier = Modifier
            )
        }

        composeTestRule.onNodeWithTag("name").assertTextContains("Pikachu")
    }

    @Test
    fun pokemonCard_geeftPokemonPokedexIndex() {
        val testPokemon = PokemonList(name = "Pikachu", pokedexIndex = 25, isCatched = false)

        composeTestRule.setContent {
            PokemonCard(
                pokemon = testPokemon,
                onPokemonClicked = {pokemonClicked = true},
                onPokemonCatched = {pokemonCatched = true},
                modifier = Modifier
            )
        }

        composeTestRule.onNodeWithTag("pokedexIndex").assertIsDisplayed()
    }
    @Test
    fun pokemonCard_geeftPokemonPokedexButtonInfo() {
        val testPokemon = PokemonList(name = "Pikachu", pokedexIndex = 25, isCatched = false)

        composeTestRule.setContent {
            PokemonCard(
                pokemon = testPokemon,
                onPokemonClicked = {pokemonClicked = true},
                onPokemonCatched = {pokemonCatched = true},
                modifier = Modifier
            )
        }

        composeTestRule.onNodeWithTag("onPokemonClickedButton").assertIsDisplayed()
    }
    @Test
    fun pokemonCard_PokemonPokedexButtonInfoClicked() {
        val testPokemon = PokemonList(name = "Pikachu", pokedexIndex = 25, isCatched = false)

        composeTestRule.setContent {
            PokemonCard(
                pokemon = testPokemon,
                onPokemonClicked = {pokemonClicked = true},
                onPokemonCatched = {pokemonCatched = true},
                modifier = Modifier
            )
        }

        composeTestRule.onNodeWithTag("onPokemonClickedButton").performClick()
        assertTrue(pokemonClicked)
    }
    @Test
    fun pokemonCard_geeftPokemonPokedexButtonCatchIsCatchedFalse() {
        val testPokemon = PokemonList(name = "Pikachu", pokedexIndex = 25, isCatched = false)

        composeTestRule.setContent {
            PokemonCard(
                pokemon = testPokemon,
                onPokemonClicked = {pokemonClicked = true},
                onPokemonCatched = {pokemonCatched = true},
                modifier = Modifier
            )
        }

        composeTestRule.onNodeWithTag("isCatchedFalseButton").assertIsDisplayed()
    }

    @Test
    fun pokemonCard_PokemonPokedexButtonisCatchedFalseClicked() {
        val testPokemon = PokemonList(name = "Pikachu", pokedexIndex = 25, isCatched = false)

        composeTestRule.setContent {
            PokemonCard(
                pokemon = testPokemon,
                onPokemonClicked = {pokemonClicked = true},
                onPokemonCatched = {pokemonCatched = true},
                modifier = Modifier
            )
        }

        composeTestRule.onNodeWithTag("isCatchedFalseButton").performClick()
        assertTrue(pokemonCatched)
    }

    @Test
    fun pokemonCard_geeftPokemonPokedexButtonCatchIsCatchedTrue() {
        val testPokemon = PokemonList(name = "Pikachu", pokedexIndex = 25, isCatched = true)

        composeTestRule.setContent {
            PokemonCard(
                pokemon = testPokemon,
                onPokemonClicked = {pokemonClicked = true},
                onPokemonCatched = {pokemonCatched = true},
                modifier = Modifier
            )
        }

        composeTestRule.onNodeWithTag("isCatchedTrueButton").assertIsDisplayed()
    }
}