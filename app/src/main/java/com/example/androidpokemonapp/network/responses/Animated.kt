package com.example.androidpokemonapp.network.responses

/**
 * Dataklasse die verschillende geanimeerde afbeeldingen van een Pokémon representeert.
 *
 * Deze klasse bevat URL's naar de geanimeerde afbeeldingen van een Pokémon in verschillende posities en vormen,
 * zoals standaard, vrouwelijk, glanzend (shiny), en glanzend vrouwelijk.
 *
 * @property back_default URL naar de standaard geanimeerde afbeelding van de achterkant van de Pokémon.
 * @property back_female URL naar de geanimeerde afbeelding van de achterkant van de vrouwelijke vorm van de Pokémon, indien beschikbaar.
 * @property back_shiny URL naar de geanimeerde afbeelding van de glanzende (shiny) vorm van de achterkant van de Pokémon.
 * @property back_shiny_female URL naar de geanimeerde afbeelding van de glanzende (shiny) vrouwelijke vorm van de achterkant van de Pokémon, indien beschikbaar.
 * @property front_default URL naar de standaard geanimeerde afbeelding van de voorkant van de Pokémon.
 * @property front_female URL naar de geanimeerde afbeelding van de voorkant van de vrouwelijke vorm van de Pokémon, indien beschikbaar.
 * @property front_shiny URL naar de geanimeerde afbeelding van de glanzende (shiny) vorm van de voorkant van de Pokémon.
 * @property front_shiny_female URL naar de geanimeerde afbeelding van de glanzende (shiny) vrouwelijke vorm van de voorkant van de Pokémon, indien beschikbaar.
 */
data class Animated(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)