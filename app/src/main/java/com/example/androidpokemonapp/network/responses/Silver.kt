package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Silver versie van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Silver versie.
 * Het omvat zowel standaard als glanzende (shiny) versies, evenals een transparante versie van de voorkant weergave.
 *
 * @property backDefault De standaard achterkant weergave van de Pokémon in Silver-stijl.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave in Silver-stijl.
 * @property frontDefault De standaard voorkant weergave van de Pokémon in Silver-stijl.
 * @property frontShiny De glanzende versie van de voorkant weergave in Silver-stijl.
 * @property frontTransparent De transparante versie van de voorkant weergave in Silver-stijl.
 */
data class Silver(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String,
    val frontTransparent: String
)