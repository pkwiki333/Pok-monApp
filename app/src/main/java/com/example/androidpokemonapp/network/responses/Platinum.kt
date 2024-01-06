package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Platinum versie van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de Platinum versie.
 * Het omvat zowel standaard als glanzende (shiny) versies, en voor zowel mannelijke als vrouwelijke Pokémon, indien beschikbaar.
 *
 * @property backDefault De standaard achterkant weergave van de Pokémon in Platinum-stijl.
 * @property backFemale De vrouwelijke variant van de achterkant weergave in Platinum-stijl, indien aanwezig.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave in Platinum-stijl.
 * @property backShinyFemale De vrouwelijke, glanzende versie van de achterkant weergave in Platinum-stijl, indien aanwezig.
 * @property frontDefault De standaard voorkant weergave van de Pokémon in Platinum-stijl.
 * @property frontFemale De vrouwelijke variant van de voorkant weergave in Platinum-stijl, indien aanwezig.
 * @property frontShiny De glanzende versie van de voorkant weergave in Platinum-stijl.
 * @property frontShinyFemale De vrouwelijke, glanzende versie van de voorkant weergave in Platinum-stijl, indien aanwezig.
 */
data class Platinum(
    val backDefault: String,
    val backFemale: Any,
    val backShiny: String,
    val backShinyFemale: Any,
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)