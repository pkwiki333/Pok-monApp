package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die afbeeldingslinks en gerelateerde informatie bevat voor de weergave van Pokémon.
 *
 * Deze klasse slaat afbeeldingslinks op voor verschillende weergaven van Pokémon, waaronder standaard, glanzend, mannelijk, vrouwelijk, en meer.
 * Het bevat ook verwijzingen naar andere gerelateerde afbeeldingen en versies.
 *
 * @property backDefault De link naar de standaard achterkant weergave van de Pokémon.
 * @property backFemale De link naar de vrouwelijke achterkant weergave van de Pokémon, indien beschikbaar.
 * @property backShiny De link naar de glanzende (shiny) achterkant weergave van de Pokémon.
 * @property backShinyFemale De link naar de vrouwelijke, glanzende achterkant weergave van de Pokémon, indien beschikbaar.
 * @property frontDefault De link naar de standaard voorkant weergave van de Pokémon.
 * @property frontFemale De link naar de vrouwelijke voorkant weergave van de Pokémon, indien beschikbaar.
 * @property frontShiny De link naar de glanzende voorkant weergave van de Pokémon.
 * @property frontShinyFemale De link naar de vrouwelijke, glanzende voorkant weergave van de Pokémon, indien beschikbaar.
 * @property other Een object van de klasse Other, bevat verwijzingen naar andere alternatieve weergaven van de Pokémon.
 * @property versions Een object van de klasse Versions, bevat versiespecifieke weergaven van de Pokémon.
 */
data class Sprites(
    val backDefault: String,
    val backFemale: Any,
    val backShiny: String,
    val backShinyFemale: Any,
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any,
    val other: Other,
    val versions: Versions
)