package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in een bepaalde omgeving of context, vermoedelijk 'Home', bevat.
 *
 * Deze klasse slaat afbeeldingen op die gebruikt worden voor de weergave van Pokémon in deze specifieke context.
 * Het omvat zowel de standaard als de glanzende (shiny) versies, voor zowel mannelijke als vrouwelijke Pokémon, indien beschikbaar.
 *
 * @property frontDefault De standaard voorkant weergave van de Pokémon in de 'Home' context.
 * @property frontFemale De vrouwelijke variant van de voorkant weergave in de 'Home' context, indien aanwezig.
 * @property frontShiny De glanzende (shiny) versie van de voorkant weergave in de 'Home' context.
 * @property frontShinyFemale De vrouwelijke, glanzende versie van de voorkant weergave in de 'Home' context, indien aanwezig.
 */
data class Home(
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)