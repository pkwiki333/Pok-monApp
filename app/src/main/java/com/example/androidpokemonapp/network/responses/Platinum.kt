package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Platinum versie van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Platinum versie.
 * Het omvat zowel standaard als glanzende (shiny) versies, en voor zowel mannelijke als vrouwelijke Pokémon, indien beschikbaar.
 *
 * @property back_default De standaard achterkant weergave van de Pokémon in Platinum-stijl.
 * @property back_female De vrouwelijke variant van de achterkant weergave in Platinum-stijl, indien aanwezig.
 * @property back_shiny De glanzende (shiny) versie van de achterkant weergave in Platinum-stijl.
 * @property back_shiny_female De vrouwelijke, glanzende versie van de achterkant weergave in Platinum-stijl, indien aanwezig.
 * @property front_default De standaard voorkant weergave van de Pokémon in Platinum-stijl.
 * @property front_female De vrouwelijke variant van de voorkant weergave in Platinum-stijl, indien aanwezig.
 * @property front_shiny De glanzende versie van de voorkant weergave in Platinum-stijl.
 * @property front_shiny_female De vrouwelijke, glanzende versie van de voorkant weergave in Platinum-stijl, indien aanwezig.
 */
data class Platinum(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)