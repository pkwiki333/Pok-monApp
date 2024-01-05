package com.example.androidpokemonapp.ui

import androidx.annotation.StringRes
import com.example.androidpokemonapp.R

/**
 * Enum class representing various screens in the Android Pokémon app.
 *
 * Each enum value has an associated title resource that represents the screen title.
 *
 * @property title The title resource for the screen.
 */
enum class ScreensEnum(@StringRes val title: Int) {
    /**
     * Represents the Pokédex screen.
     */
    PokedexScreen(title = R.string.pokedex),
    /**
     * Represents the random Pokémon screen.
     */
    RandomPokemon(title = R.string.RandomPokemon),
    /**
     * Represents the Pokémon detail screen.
     */
    PokemonDetailScreen(title = R.string.pokemon_details),
    /**
     * Represents the main menu screen.
     */
    PokemonScreen(title = R.string.main_menu),
    /**
     * Represents the your team screen.
     */
    YourTeamScreen(title = R.string.your_team);

    /**
     * Gets the full route for the screen with optional arguments.
     *
     * @param args Optional arguments to be included in the route.
     * @return The full route as a string.
     */
    fun withArgs(vararg args: String): String {
        return this.name + if (args.isEmpty()) "" else args.joinToString(
            separator = "/",
            prefix = "/"
        )
    }


    companion object {
        /**
         * Gets the base route based on the provided route.
         *
         * @param route The route to extract the base screen from.
         * @return The base screen as a [ScreensEnum] value.
         */
        fun getBaseRoute(route: String?): ScreensEnum {
            val baseRoute = route?.substringBefore("/") ?: ScreensEnum.PokemonScreen.name

            return ScreensEnum.values().find { it.name == baseRoute } ?: PokemonScreen
        }
    }
}


