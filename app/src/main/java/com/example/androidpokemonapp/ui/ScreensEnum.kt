package com.example.androidpokemonapp.ui

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.example.androidpokemonapp.R

enum class ScreensEnum(@StringRes val title: Int) {
    PokedexScreen(title = R.string.pokedex),
    PokemonOfTheDayScreen(title = R.string.pokemon_of_the_day),
    PokemonDetailScreen(title = R.string.pokemon_detail),
    PokemonScreen(title = R.string.main_menu),
    YourTeamScreen(title = R.string.your_team),
}
/*enum class ScreensEnum(val route: String) {
    PokedexScreen("pokedex"),
    PokemonOfTheDayScreen("pokemon_of_the_day"),
    PokemonDetailScreen("pokemon_detail"),
    PokemonScreen("pokemon_screen"),
    YourTeamScreen("your_team"),
}*/

