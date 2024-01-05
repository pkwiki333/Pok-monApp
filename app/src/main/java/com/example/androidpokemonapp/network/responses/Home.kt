package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in een bepaalde omgeving of context, vermoedelijk 'Home', bevat.
 *
 * Deze klasse slaat afbeeldingen op die gebruikt worden voor de weergave van Pokémon in deze specifieke context.
 * Het omvat zowel de standaard als de glanzende (shiny) versies, voor zowel mannelijke als vrouwelijke Pokémon, indien beschikbaar.
 *
 * @property front_default De standaard voorkant weergave van de Pokémon in de 'Home' context.
 * @property front_female De vrouwelijke variant van de voorkant weergave in de 'Home' context, indien aanwezig.
 * @property front_shiny De glanzende (shiny) versie van de voorkant weergave in de 'Home' context.
 * @property front_shiny_female De vrouwelijke, glanzende versie van de voorkant weergave in de 'Home' context, indien aanwezig.
 */
data class Home(
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)