package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de "Pokémon X" en "Pokémon Y" versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de "Pokémon X" en "Pokémon Y" versies.
 * Het omvat zowel standaard als glanzende (shiny) versies, evenals een mogelijke vrouwelijke variant van de voorkant weergave.
 *
 * @property front_default De standaard voorkant weergave van de Pokémon in "Pokémon X" en "Pokémon Y" stijl.
 * @property front_female De vrouwelijke voorkant weergave van de Pokémon, indien beschikbaar, in "Pokémon X" en "Pokémon Y" stijl.
 * @property front_shiny De glanzende versie van de voorkant weergave in "Pokémon X" en "Pokémon Y" stijl.
 * @property front_shiny_female De vrouwelijke, glanzende versie van de voorkant weergave van de Pokémon, indien beschikbaar, in "Pokémon X" en "Pokémon Y" stijl.
 */
data class XY(
    val front_default: String,
    val front_female: Any,
    val front_shiny: String,
    val front_shiny_female: Any
)