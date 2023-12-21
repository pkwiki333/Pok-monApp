package com.example.androidpokemonapp.ui

import androidx.annotation.StringRes
import com.example.androidpokemonapp.R

enum class ScreensEnum(@StringRes val title: Int) {
    PokedexScreen(title = R.string.pokedex),
    RandomPokemon(title = R.string.pokemon_of_the_day),
    PokemonDetailScreen(title = R.string.pokemon_details),
    PokemonScreen(title = R.string.main_menu),
    YourTeamScreen(title = R.string.your_team);


    fun withArgs(vararg args: String): String {
        return this.name + if (args.isEmpty()) "" else args.joinToString(
            separator = "/",
            prefix = "/"
        )
    }


    companion object {
        fun getBaseRoute(route: String?): ScreensEnum {
            val baseRoute = route?.substringBefore("/") ?: ScreensEnum.PokemonScreen.name

            return ScreensEnum.values().find { it.name == baseRoute } ?: PokemonScreen
        }
    }
}


