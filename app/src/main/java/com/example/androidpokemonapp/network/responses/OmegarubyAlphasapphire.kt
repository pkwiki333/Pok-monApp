package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Omega Ruby en Alpha Sapphire versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Omega Ruby en Alpha Sapphire versies.
 * Het omvat zowel standaard als glanzende (shiny) versies, en voor zowel mannelijke als vrouwelijke Pokémon, indien beschikbaar.
 *
 * @property front_default De standaard voorkant weergave van de Pokémon in Omega Ruby/Alpha Sapphire-stijl.
 * @property front_female De vrouwelijke variant van de voorkant weergave in Omega Ruby/Alpha Sapphire-stijl, indien aanwezig.
 * @property front_shiny De glanzende (shiny) versie van de voorkant weergave in Omega Ruby/Alpha Sapphire-stijl.
 * @property front_shiny_female De vrouwelijke, glanzende versie van de voorkant weergave in Omega Ruby/Alpha Sapphire-stijl, indien aanwezig.
 */
data class OmegarubyAlphasapphire(
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)