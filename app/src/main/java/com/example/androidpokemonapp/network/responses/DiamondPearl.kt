package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de verschillende weergaven van een Pokémon in de 'Diamond and Pearl' stijl voorstelt.
 *
 * @property backDefault De standaard achterkant weergave in 'Diamond and Pearl' stijl.
 * @property backFemale De vrouwelijke variant van de achterkant weergave in 'Diamond and Pearl' stijl, indien aanwezig.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave in 'Diamond and Pearl' stijl.
 * @property backShinyFemale De vrouwelijke, glanzende versie van de achterkant weergave in 'Diamond and Pearl' stijl, indien aanwezig.
 * @property frontDefault De standaard voorkant weergave in 'Diamond and Pearl' stijl.
 * @property frontFemale De vrouwelijke variant van de voorkant weergave in 'Diamond and Pearl' stijl, indien aanwezig.
 * @property frontShiny De glanzende versie van de voorkant weergave in 'Diamond and Pearl' stijl.
 * @property frontShinyFemale De vrouwelijke, glanzende versie van de voorkant weergave in 'Diamond and Pearl' stijl, indien aanwezig.
 */
data class DiamondPearl(
    val backDefault: String,
    val backFemale: Any,
    val backShiny: String,
    val backShinyFemale: Any,
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)