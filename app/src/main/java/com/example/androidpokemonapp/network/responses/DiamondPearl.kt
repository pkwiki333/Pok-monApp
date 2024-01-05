package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de verschillende weergaven van een Pokémon in de 'Diamond and Pearl' stijl voorstelt.
 *
 * @property back_default De standaard achterkant weergave in 'Diamond and Pearl' stijl.
 * @property back_female De vrouwelijke variant van de achterkant weergave in 'Diamond and Pearl' stijl, indien aanwezig.
 * @property back_shiny De glanzende (shiny) versie van de achterkant weergave in 'Diamond and Pearl' stijl.
 * @property back_shiny_female De vrouwelijke, glanzende versie van de achterkant weergave in 'Diamond and Pearl' stijl, indien aanwezig.
 * @property front_default De standaard voorkant weergave in 'Diamond and Pearl' stijl.
 * @property front_female De vrouwelijke variant van de voorkant weergave in 'Diamond and Pearl' stijl, indien aanwezig.
 * @property front_shiny De glanzende versie van de voorkant weergave in 'Diamond and Pearl' stijl.
 * @property front_shiny_female De vrouwelijke, glanzende versie van de voorkant weergave in 'Diamond and Pearl' stijl, indien aanwezig.
 */
data class DiamondPearl(
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)