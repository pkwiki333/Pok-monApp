package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Ruby en Sapphire versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Ruby en Sapphire versies.
 * Het omvat zowel standaard als glanzende (shiny) versies van de voor- en achterkant weergaven.
 *
 * @property backDefault De standaard achterkant weergave van de Pokémon in Ruby/Sapphire-stijl.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave in Ruby/Sapphire-stijl.
 * @property frontDefault De standaard voorkant weergave van de Pokémon in Ruby/Sapphire-stijl.
 * @property frontShiny De glanzende versie van de voorkant weergave in Ruby/Sapphire-stijl.
 */
data class RubySapphire(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String
)