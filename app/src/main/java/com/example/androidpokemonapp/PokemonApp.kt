package com.example.androidpokemonapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.androidpokemonapp.ui.PokemonScreen
import com.example.androidpokemonapp.ui.ScreensEnum
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidpokemonapp.ui.PokedexScreen
import com.example.androidpokemonapp.ui.PokemonTopBar
import com.example.androidpokemonapp.ui.RandomPokemonScreen
import com.example.androidpokemonapp.ui.pokemonDetailScreen

import com.example.androidpokemonapp.ui.YourTeamScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonApp(
    navController: NavHostController = rememberNavController(),
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen =
        ScreensEnum.getBaseRoute(backStackEntry?.destination?.route)

    val currentScreenTitle = ScreensEnum.valueOf(
        ScreensEnum.getBaseRoute(backStackEntry?.destination?.route).toString(),
    ).title

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                if (currentScreen != ScreensEnum.PokemonScreen) {
                    PokemonTopBar(
                        canNavigateBack = navController.previousBackStackEntry != null,
                        navigateUp = { navController.navigateUp() },
                        currentScreenTitle = currentScreenTitle,
                    )
                }
            },
            content = { innerPadding ->
                NavHost(
                    navController = navController,
                    startDestination = ScreensEnum.PokemonScreen.name
                ) {
                    composable(ScreensEnum.PokemonScreen.name) {
                        PokemonScreen(
                            padding = innerPadding,
                            onPokemonOfTheDayClicked = { navController.navigate(ScreensEnum.RandomPokemon.name) },
                            onPokedexClicked = { navController.navigate(ScreensEnum.PokedexScreen.name) },
                            onYourTeamClicked = { navController.navigate(ScreensEnum.YourTeamScreen.name) },
                        )
                    }
                    composable(ScreensEnum.RandomPokemon.name) {
                        RandomPokemonScreen(padding = innerPadding)
                    }
                    composable(ScreensEnum.PokedexScreen.name) {
                        PokedexScreen(
                            padding = innerPadding,
                            onPokemonClicked = { pokemonName -> navController.navigate(ScreensEnum.PokemonDetailScreen.name + "/$pokemonName") },
                        )
                    }
                    composable(ScreensEnum.YourTeamScreen.name) {
                        YourTeamScreen(onPokemonClicked = { navController.navigate(ScreensEnum.PokemonDetailScreen.name) },)
                    }
                    composable(
                        route = ScreensEnum.PokemonDetailScreen.withArgs("{pokemonName}"),
                        arguments = listOf(navArgument("pokemonName") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val pokemonName = backStackEntry.arguments?.getString("pokemonName")
                            ?: "Naam niet gevonden"
                        pokemonDetailScreen(name = pokemonName, padding = innerPadding)
                    }
                }
            })
    }
}

