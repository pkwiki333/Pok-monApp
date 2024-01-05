package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die afbeeldingslinks en gerelateerde informatie bevat voor de weergave van Pokémon.
 *
 * Deze klasse slaat afbeeldingslinks op voor verschillende weergaven van Pokémon, waaronder standaard, glanzend, mannelijk, vrouwelijk, en meer.
 * Het bevat ook verwijzingen naar andere gerelateerde afbeeldingen en versies.
 *
 * @property back_default De link naar de standaard achterkant weergave van de Pokémon.
 * @property back_female De link naar de vrouwelijke achterkant weergave van de Pokémon, indien beschikbaar.
 * @property back_shiny De link naar de glanzende (shiny) achterkant weergave van de Pokémon.
 * @property back_shiny_female De link naar de vrouwelijke, glanzende achterkant weergave van de Pokémon, indien beschikbaar.
 * @property front_default De link naar de standaard voorkant weergave van de Pokémon.
 * @property front_female De link naar de vrouwelijke voorkant weergave van de Pokémon, indien beschikbaar.
 * @property front_shiny De link naar de glanzende voorkant weergave van de Pokémon.
 * @property front_shiny_female De link naar de vrouwelijke, glanzende voorkant weergave van de Pokémon, indien beschikbaar.
 * @property other Een object van de klasse Other, bevat verwijzingen naar andere alternatieve weergaven van de Pokémon.
 * @property versions Een object van de klasse Versions, bevat versiespecifieke weergaven van de Pokémon.
 */
data class Sprites(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any,
    val other: Other,
    val versions: Versions
)