package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Gold versie van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Gold versie.
 * Het omvat zowel standaard als glanzende (shiny) versies, evenals een transparante versie van de voorkant weergave.
 *
 * @property backDefault De standaard achterkant weergave van de Pokémon in Gold-stijl.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave in Gold-stijl.
 * @property frontDefault De standaard voorkant weergave van de Pokémon in Gold-stijl.
 * @property frontShiny De glanzende versie van de voorkant weergave in Gold-stijl.
 * @property frontTransparent De transparante versie van de voorkant weergave in Gold-stijl.
 */
data class Gold(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String,
    val frontTransparent: String
)