package com.example.androidpokemonapp.network.responses

/**
 * Dataklasse die verschillende geanimeerde afbeeldingen van een Pokémon representeert.
 *
 * Deze klasse bevat URL's naar de geanimeerde afbeeldingen van een Pokémon in verschillende posities en vormen,
 * zoals standaard, vrouwelijk, glanzend (shiny), en glanzend vrouwelijk.
 *
 * @property backDefault URL naar de standaard geanimeerde afbeelding van de achterkant van de Pokémon.
 * @property backFemale URL naar de geanimeerde afbeelding van de achterkant van de vrouwelijke vorm van de Pokémon, indien beschikbaar.
 * @property backShiny URL naar de geanimeerde afbeelding van de glanzende (shiny) vorm van de achterkant van de Pokémon.
 * @property backShinyFemale URL naar de geanimeerde afbeelding van de glanzende (shiny) vrouwelijke vorm van de achterkant van de Pokémon, indien beschikbaar.
 * @property frontDefault URL naar de standaard geanimeerde afbeelding van de voorkant van de Pokémon.
 * @property frontFemale URL naar de geanimeerde afbeelding van de voorkant van de vrouwelijke vorm van de Pokémon, indien beschikbaar.
 * @property frontShiny URL naar de geanimeerde afbeelding van de glanzende (shiny) vorm van de voorkant van de Pokémon.
 * @property frontShinyFemale URL naar de geanimeerde afbeelding van de glanzende (shiny) vrouwelijke vorm van de voorkant van de Pokémon, indien beschikbaar.
 */
data class Animated(
    val backDefault: String,
    val backFemale: Any,
    val backShiny: String,
    val backShinyFemale: Any,
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)