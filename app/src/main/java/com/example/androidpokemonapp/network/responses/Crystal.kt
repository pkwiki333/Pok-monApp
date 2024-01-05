package com.example.androidpokemonapp.network.responses
/**
 * Data klasse die de verschillende weergaven van een Pokémon in kristalstijl voorstelt.
 *
 * @property back_default De standaard achterkant weergave in kristalstijl.
 * @property back_shiny De glanzende (shiny) versie van de achterkant weergave in kristalstijl.
 * @property back_shiny_transparent De glanzende en transparante versie van de achterkant weergave in kristalstijl.
 * @property back_transparent De transparante versie van de achterkant weergave in kristalstijl.
 * @property front_default De standaard voorkant weergave in kristalstijl.
 * @property front_shiny De glanzende versie van de voorkant weergave in kristalstijl.
 * @property front_shiny_transparent De glanzende en transparante versie van de voorkant weergave in kristalstijl.
 * @property front_transparent De transparante versie van de voorkant weergave in kristalstijl.
 */

data class Crystal(
    val back_default: String,
    val back_shiny: String,
    val back_shiny_transparent: String,
    val back_transparent: String,
    val front_default: String,
    val front_shiny: String,
    val front_shiny_transparent: String,
    val front_transparent: String
)