package com.example.androidpokemonapp.uiTesten

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.ui.RandomPokemonCardInhoud
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RandomPokemonCardInhoudTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    lateinit var testPokemon : Pokemon

    @Before
    fun setup() {
        testPokemon = Pokemon(
            name = "Squirtle",
            pokedexIndex = 1,
            types = listOf("Water"),
            abilities = listOf("Rain Dish"),
            height = 50.0,
            weight = 100.0,
            moves = listOf("Splash")
        )
    }

    @Test
    fun randomPokemonCardInhoud_displaysPokemonName() {
        composeTestRule.setContent {
            RandomPokemonCardInhoud(pokemon = testPokemon)
        }
        composeTestRule.onNodeWithTag("PokemonName").assertTextContains("Squirtle")
    }
    @Test
    fun randomPokemonCardInhoud_displaysPokemonPokedexIndex() {
        composeTestRule.setContent {
            RandomPokemonCardInhoud(pokemon = testPokemon)
        }
        composeTestRule.onNodeWithTag("PokemonPokedexIndex").assertIsDisplayed()
    }

    @Test
    fun randomPokemonCardInhoud_geeftPokemonTypes() {
        composeTestRule.setContent {
            RandomPokemonCardInhoud(pokemon = testPokemon)
        }
        composeTestRule.onNodeWithTag("PokemonTypes").assertTextEquals("Water")
    }

    @Test
    fun randomPokemonCardInhoud_geeftPokemonAbilities() {
        composeTestRule.setContent {
            RandomPokemonCardInhoud(pokemon = testPokemon)
        }
        composeTestRule.onNodeWithTag("PokemonAbilities").assertTextEquals("Rain Dish")
    }

    @Test
    fun randomPokemonCardInhoud_geeftPokemonHeight() {
        composeTestRule.setContent {
            RandomPokemonCardInhoud(pokemon = testPokemon)
        }
        composeTestRule.onNodeWithTag("PokemonHeight").assertIsDisplayed()
    }

    @Test
    fun randomPokemonCardInhoud_geeftPokemonWeight() {
        composeTestRule.setContent {
            RandomPokemonCardInhoud(pokemon = testPokemon)
        }
        composeTestRule.onNodeWithTag("PokemonWeight").assertIsDisplayed()
    }
    @Test
    fun randomPokemonCardInhoud_geeftPokemonMoves() {
        composeTestRule.setContent {
            RandomPokemonCardInhoud(pokemon = testPokemon)
        }
        composeTestRule.onNodeWithTag("PokemonMoves").assertTextEquals("Splash")
    }

}