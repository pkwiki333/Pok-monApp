package com.example.androidpokemonapp.navigationTesten

import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import com.assertCurrentRouteName
import com.example.androidpokemonapp.PokemonApp
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.ui.ScreensEnum
import com.onNodeWithStringId
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            PokemonApp(navController = navController)
        }
    }


    @Test
    fun pokemonApp_verifyStartDestination() {
        navController.assertCurrentRouteName(ScreensEnum.PokemonScreen.name)
    }


    @Test
    fun pokemonApp_verifyBackNavigationNotShownOnPokemonScreen() {
        val backText = composeTestRule.activity.getString(R.string.navigate_back)
        composeTestRule.onNodeWithContentDescription(backText).assertDoesNotExist()
    }

    @Test
    fun pokemonApp_clickRandomPokemonButton_navigatesToRandomPokemonScreen() {
        composeTestRule.onNodeWithStringId(R.string.RandomPokemon).performClick()
        navController.assertCurrentRouteName(ScreensEnum.RandomPokemon.name)
    }

    @Test
    fun pokemonApp_clickPokedexButton_navigatesToPokedexScreen() {
        composeTestRule.onNodeWithStringId(R.string.pokedex).performClick()
        navController.assertCurrentRouteName(ScreensEnum.PokedexScreen.name)
    }

    @Test
    fun pokemonApp_clickYourTeamButton_navigatesToYourTeamScreen() {
        composeTestRule.onNodeWithStringId(R.string.your_team).performClick()
        navController.assertCurrentRouteName(ScreensEnum.YourTeamScreen.name)
    }

    @Test
    fun pokemonApp_verifyBackNavigationShownOnRandomPokemonScreen() {
        composeTestRule.onNodeWithStringId(R.string.RandomPokemon).performClick()
        val backText = composeTestRule.activity.getString(R.string.navigate_back)
        composeTestRule.onNodeWithContentDescription(backText).assertExists()
    }

    @Test
    fun pokemonApp_clickBackOnRandomPokemon_navigatesToPokemonScreen() {
        composeTestRule.onNodeWithStringId(R.string.RandomPokemon).performClick()
        performNavigateUp()
        navController.assertCurrentRouteName(ScreensEnum.PokemonScreen.name)
    }


    @Test
    fun pokemonApp_verifyBackNavigationShownOnPokedexScreen() {
        composeTestRule.onNodeWithStringId(R.string.pokedex).performClick()
        val backText = composeTestRule.activity.getString(R.string.navigate_back)
        composeTestRule.onNodeWithContentDescription(backText).assertExists()
    }

    @Test
    fun pokemonApp_clickBackOnPokedex_navigatesToPokemonScreen() {
        composeTestRule.onNodeWithStringId(R.string.pokedex).performClick()
        performNavigateUp()
        navController.assertCurrentRouteName(ScreensEnum.PokemonScreen.name)
    }

   // TODO
    @Test
    fun pokemonApp_verifyBackNavigationShownOnPokemonDetailScreenForPokedex() {
        composeTestRule.onNodeWithStringId(R.string.pokedex).performClick()
        performNavigateToDetailScreen()
        val backText = composeTestRule.activity.getString(R.string.navigate_back)
        composeTestRule.onNodeWithContentDescription(backText).assertExists()
    }

    @Test
    fun pokemonApp_clickBackOnPokemonDetailScreenForPokedex_navigatesToPokedexScreen() {
        composeTestRule.onNodeWithStringId(R.string.pokedex).performClick()
        performNavigateToDetailScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(ScreensEnum.PokedexScreen.name)
    }
    //TODO
    @Test
    fun pokemonApp_verifyBackNavigationShownOnPokemonDetailScreenForYourTeam() {
        composeTestRule.onNodeWithStringId(R.string.your_team).performClick()
        performNavigateToDetailScreen()
        val backText = composeTestRule.activity.getString(R.string.navigate_back)
        composeTestRule.onNodeWithContentDescription(backText).assertExists()
    }

    @Test
    fun pokemonApp_clickBackOnPokemonDetailScreenForYourTeam_navigatesToYourTeamScreen() {
        composeTestRule.onNodeWithStringId(R.string.your_team).performClick()
        performNavigateToDetailScreen()
        performNavigateUp()
        navController.assertCurrentRouteName(ScreensEnum.YourTeamScreen.name)
    }

    @Test
     fun pokemonApp_verifyBackNavigationShownOnYourTeamScreen() {
         composeTestRule.onNodeWithStringId(R.string.your_team).performClick()
         val backText = composeTestRule.activity.getString(R.string.navigate_back)
         composeTestRule.onNodeWithContentDescription(backText).assertExists()
     }

     @Test
    fun pokemonApp_clickBackOnYourTeam_navigatesToPokemonScreen() {
        composeTestRule.onNodeWithStringId(R.string.your_team).performClick()
        performNavigateUp()
        navController.assertCurrentRouteName(ScreensEnum.PokemonScreen.name)
    }

    private fun performNavigateUp() {
        val backText = composeTestRule.activity.getString(R.string.navigate_back)
        composeTestRule.onNodeWithContentDescription(backText).performClick()
    }

    private fun performNavigateToDetailScreen() {
        composeTestRule.onNodeWithTag("onPokemonClickedButton").performClick()

    }
}
