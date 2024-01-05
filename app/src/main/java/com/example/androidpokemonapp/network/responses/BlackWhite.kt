package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de verschillende weergaven van een Pokémon in zwart-wit stijl voorstelt.
 *
 * @property animated De geanimeerde weergave.
 * @property back_default De standaard achterkant weergave.
 * @property back_female De vrouwelijke variant van de achterkant weergave, indien aanwezig.
 * @property back_shiny De glanzende (shiny) versie van de achterkant weergave.
 * @property back_shiny_female De vrouwelijke, glanzende versie van de achterkant weergave, indien aanwezig.
 * @property front_default De standaard voorkant weergave.
 * @property front_female De vrouwelijke variant van de voorkant weergave, indien aanwezig.
 * @property front_shiny De glanzende versie van de voorkant weergave.
 * @property front_shiny_female De vrouwelijke, glanzende versie van de voorkant weergave, indien aanwezig.
 */
data class BlackWhite(
    val animated: Animated,
    val back_default: String,
    val back_female: Any,
    val back_shiny: String,
    val back_shiny_female: Any,
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)