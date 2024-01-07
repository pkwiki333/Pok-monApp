package com.example.androidpokemonapp.uiTesten

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.ui.YourTeamPokemonCard
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class YourTeamPokemonCardTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var onPokemonClicked = false
    private var onPokemonRelease = false

    @Test
    fun yourTeamPokemonCard_geeftPokemonDetails() {
        val pokemon = PokemonList("Pikachu", 25, true)

        composeTestRule.setContent {
            YourTeamPokemonCard(pokemon = pokemon, onPokemonClicked = {onPokemonClicked = true}, onPokemonRelease = {onPokemonRelease = true})
        }

        composeTestRule.onNodeWithTag("name").assertTextEquals("Pikachu")
        composeTestRule.onNodeWithTag("pokedexIndex").assertIsDisplayed()
    }

    @Test
    fun yourTeamPokemonCard_releaseButtonHidesCard() {
        var isVisible = true
        val pokemon = PokemonList("Pikachu", 25, true)

        composeTestRule.setContent {
            YourTeamPokemonCard(pokemon = pokemon, onPokemonClicked = {onPokemonClicked = true}, onPokemonRelease = { isVisible = false; onPokemonRelease = true})
        }
        composeTestRule.onNodeWithTag("Release").performClick()
        if (!isVisible) {
            composeTestRule.onNodeWithTag("PikachuCard").assertIsNotDisplayed()
        }
    }

    @Test
    fun yourTeamPokemonCard_onPokemonClicked() {
        val pokemon = PokemonList("Pikachu", 25, true)

        composeTestRule.setContent {
            YourTeamPokemonCard(pokemon = pokemon, onPokemonClicked = {onPokemonClicked = true}, onPokemonRelease = {onPokemonRelease = true})
        }
        composeTestRule.onNodeWithTag("onPokemonClickedButton_Pikachu").performClick()
        assertTrue(onPokemonClicked)
    }
}