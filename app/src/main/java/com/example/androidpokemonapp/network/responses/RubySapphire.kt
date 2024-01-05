package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Ruby en Sapphire versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Ruby en Sapphire versies.
 * Het omvat zowel standaard als glanzende (shiny) versies van de voor- en achterkant weergaven.
 *
 * @property back_default De standaard achterkant weergave van de Pokémon in Ruby/Sapphire-stijl.
 * @property back_shiny De glanzende (shiny) versie van de achterkant weergave in Ruby/Sapphire-stijl.
 * @property front_default De standaard voorkant weergave van de Pokémon in Ruby/Sapphire-stijl.
 * @property front_shiny De glanzende versie van de voorkant weergave in Ruby/Sapphire-stijl.
 */
data class RubySapphire(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)