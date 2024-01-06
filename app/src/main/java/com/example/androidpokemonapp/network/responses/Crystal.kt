package com.example.androidpokemonapp.network.responses
/**
 * Data klasse die de verschillende weergaven van een Pokémon in kristalstijl voorstelt.
 *
 * @property backDefault De standaard achterkant weergave in kristalstijl.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave in kristalstijl.
 * @property backShinyTransparent De glanzende en transparante versie van de achterkant weergave in kristalstijl.
 * @property backTransparent De transparante versie van de achterkant weergave in kristalstijl.
 * @property frontDefault De standaard voorkant weergave in kristalstijl.
 * @property frontShiny De glanzende versie van de voorkant weergave in kristalstijl.
 * @property frontShinyTransparent De glanzende en transparante versie van de voorkant weergave in kristalstijl.
 * @property frontTransparent De transparante versie van de voorkant weergave in kristalstijl.
 */

data class Crystal(
    val backDefault: String,
    val backShiny: String,
    val backShinyTransparent: String,
    val backTransparent: String,
    val frontDefault: String,
    val frontShiny: String,
    val frontShinyTransparent: String,
    val frontTransparent: String
)