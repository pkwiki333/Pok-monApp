package com.example.androidpokemonapp.uiTesten

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.ui.PokemonDetailScreenContent
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonDetailScreenContentTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var testPokemon: Pokemon

    @Before
    fun setup() {
        testPokemon = Pokemon(
            name = "Bulbasaur",
            pokedexIndex = 1,
            types = listOf("Grass", "Poison"),
            abilities = listOf("Overgrow", "Chlorophyll"),
            height = 70.0,
            weight = 60.0,
            moves = listOf("Tackle", "Growl")
        )
    }

    @Test
    fun pokemonDetailScreenContent_geeftPokemonDetailsName() {
        composeTestRule.setContent {
            PokemonDetailScreenContent(pokemon = testPokemon)
        }

        composeTestRule.onNodeWithTag("Name").assertTextContains("Bulbasaur")

    }

    @Test
    fun pokemonDetailScreenContent_geeftPokemonDetailsPokedexIndex() {
        composeTestRule.setContent {
            PokemonDetailScreenContent(pokemon = testPokemon)
        }

        composeTestRule.onNodeWithTag("PokedexIndex").assertIsDisplayed()

    }


    @Test
    fun pokemonDetailScreenContent_geeftPokemonDetailsTypes() {
        composeTestRule.setContent {
            PokemonDetailScreenContent(pokemon = testPokemon)
        }
        composeTestRule
            .onNodeWithTag("Types")
            .assertIsDisplayed()


    }

    @Test
    fun pokemonDetailScreenContent_geeftPokemonDetailsAbilities() {
        composeTestRule.setContent {
            PokemonDetailScreenContent(pokemon = testPokemon)
        }
        composeTestRule
            .onNodeWithTag("Abilities")
            .assertTextEquals("Overgrow, Chlorophyll")


    }

    @Test
    fun pokemonDetailScreenContent_geeftPokemonDetailsHeight() {
        composeTestRule.setContent {
            PokemonDetailScreenContent(pokemon = testPokemon)
        }
        composeTestRule
            .onNodeWithTag("Height")
            .assertIsDisplayed()


    }

    @Test
    fun pokemonDetailScreenContent_geeftPokemonDetailsWeight() {
        composeTestRule.setContent {
            PokemonDetailScreenContent(pokemon = testPokemon)
        }
        composeTestRule
            .onNodeWithTag("Weight")
            .assertIsDisplayed()


    }

    @Test
    fun pokemonDetailScreenContent_geeftPokemonDetailsMoves() {
        composeTestRule.setContent {
            PokemonDetailScreenContent(pokemon = testPokemon)
        }
        composeTestRule
            .onNodeWithTag("Moves")
            .assertTextEquals("Tackle, Growl")


    }


}
