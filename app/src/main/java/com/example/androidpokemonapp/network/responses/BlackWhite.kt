package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de verschillende weergaven van een Pokémon in zwart-wit stijl voorstelt.
 *
 * @property animated De geanimeerde weergave.
 * @property backDefault De standaard achterkant weergave.
 * @property backFemale De vrouwelijke variant van de achterkant weergave, indien aanwezig.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave.
 * @property backShinyFemale De vrouwelijke, glanzende versie van de achterkant weergave, indien aanwezig.
 * @property frontDefault De standaard voorkant weergave.
 * @property frontFemale De vrouwelijke variant van de voorkant weergave, indien aanwezig.
 * @property frontShiny De glanzende versie van de voorkant weergave.
 * @property frontShinyFemale De vrouwelijke, glanzende versie van de voorkant weergave, indien aanwezig.
 */
data class BlackWhite(
    val animated: Animated,
    val backDefault: String,
    val backFemale: Any,
    val backShiny: String,
    val backShinyFemale: Any,
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)