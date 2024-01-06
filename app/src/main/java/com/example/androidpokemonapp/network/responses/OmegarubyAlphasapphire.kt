package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Omega Ruby en Alpha Sapphire versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Omega Ruby en Alpha Sapphire versies.
 * Het omvat zowel standaard als glanzende (shiny) versies, en voor zowel mannelijke als vrouwelijke Pokémon, indien beschikbaar.
 *
 * @property frontDefault De standaard voorkant weergave van de Pokémon in Omega Ruby/Alpha Sapphire-stijl.
 * @property frontFemale De vrouwelijke variant van de voorkant weergave in Omega Ruby/Alpha Sapphire-stijl, indien aanwezig.
 * @property frontShiny De glanzende (shiny) versie van de voorkant weergave in Omega Ruby/Alpha Sapphire-stijl.
 * @property frontShinyFemale De vrouwelijke, glanzende versie van de voorkant weergave in Omega Ruby/Alpha Sapphire-stijl, indien aanwezig.
 */
data class OmegarubyAlphasapphire(
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)