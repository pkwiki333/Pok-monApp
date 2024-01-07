package com.example.androidpokemonapp.navigationTesten

import android.content.Context
import androidx.activity.ComponentActivity
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.testing.TestNavHostController
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.assertCurrentRouteName
import com.example.androidpokemonapp.PokemonApp
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.data.AppContainer
import com.example.androidpokemonapp.data.AppContainerImpl
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.PokemonListDatabase
import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.ui.ScreensEnum
import com.onNodeWithStringId
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PokemonScreenNavigationTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    private lateinit var navController: TestNavHostController
    private lateinit var appContainer: AppContainer
    private lateinit var context: Context

    @Before
    fun setup() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current).apply {
                navigatorProvider.addNavigator(ComposeNavigator())
            }
            PokemonApp(navController = navController)
        }
        context = ApplicationProvider.getApplicationContext()

        appContainer = AppContainerImpl(context)
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

    @Test
    fun pokemonApp_verifyBackNavigationShownOnPokemonDetailScreenForPokedex() {
        composeTestRule.onNodeWithStringId(R.string.pokedex).performClick()
        performNavigateToDetailScreen()
        composeTestRule.onNodeWithTag("onPokemonClickedButton_bulbasaur").performClick()
        val backText = composeTestRule.activity.getString(R.string.navigate_back)
        composeTestRule.onNodeWithContentDescription(backText).assertExists()
    }

    @Test
    fun pokemonApp_clickBackOnPokemonDetailScreenForPokedex_navigatesToPokedexScreen() {
        composeTestRule.onNodeWithStringId(R.string.pokedex).performClick()
        performNavigateToDetailScreen()
        composeTestRule.onNodeWithTag("onPokemonClickedButton_bulbasaur").performClick()
        performNavigateUp()
        navController.assertCurrentRouteName(ScreensEnum.PokedexScreen.name)
    }

    @Test
    fun pokemonApp_verifyBackNavigationShownOnPokemonDetailScreenForYourTeam() {
        runBlocking { addToPokemonListDB(ApplicationProvider.getApplicationContext()) }
        composeTestRule.onNodeWithStringId(R.string.your_team).performClick()
        performNavigateToDetailScreen()
        composeTestRule.onNodeWithTag("onPokemonClickedButton_bulbasaur").performClick()
        val backText = composeTestRule.activity.getString(R.string.navigate_back)
        composeTestRule.onNodeWithContentDescription(backText).assertExists()
    }

    @Test
    fun pokemonApp_clickBackOnPokemonDetailScreenForYourTeam_navigatesToYourTeamScreen() {
        runBlocking { addToPokemonListDB(ApplicationProvider.getApplicationContext()) }

        composeTestRule.onNodeWithStringId(R.string.your_team).performClick()
        performNavigateToDetailScreen()
        composeTestRule.onNodeWithTag("onPokemonClickedButton_bulbasaur").performClick()
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
        var isCardLoaded = false
        repeat(200) {
            Thread.sleep(100)
            isCardLoaded = try {
                composeTestRule.onNodeWithTag("onPokemonClickedButton_bulbasaur")
                    .assertIsDisplayed()
                true
            } catch (e: AssertionError) {
                false
            }
        }
    }

    private  suspend fun addToPokemonListDB(context: Context)  {
        val pokemon = PokemonList("bulbasaur", 1, true)
        appContainer.pokemonRepository.insertToYourTeam(pokemon)
    }
}
