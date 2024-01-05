package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Silver versie van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Silver versie.
 * Het omvat zowel standaard als glanzende (shiny) versies, evenals een transparante versie van de voorkant weergave.
 *
 * @property back_default De standaard achterkant weergave van de Pokémon in Silver-stijl.
 * @property back_shiny De glanzende (shiny) versie van de achterkant weergave in Silver-stijl.
 * @property front_default De standaard voorkant weergave van de Pokémon in Silver-stijl.
 * @property front_shiny De glanzende versie van de voorkant weergave in Silver-stijl.
 * @property front_transparent De transparante versie van de voorkant weergave in Silver-stijl.
 */
data class Silver(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String,
    val front_transparent: String
)