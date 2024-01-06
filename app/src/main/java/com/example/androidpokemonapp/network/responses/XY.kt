package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de "Pokémon X" en "Pokémon Y" versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de "Pokémon X" en "Pokémon Y" versies.
 * Het omvat zowel standaard als glanzende (shiny) versies, evenals een mogelijke vrouwelijke variant van de voorkant weergave.
 *
 * @property frontDefault De standaard voorkant weergave van de Pokémon in "Pokémon X" en "Pokémon Y" stijl.
 * @property frontFemale De vrouwelijke voorkant weergave van de Pokémon, indien beschikbaar, in "Pokémon X" en "Pokémon Y" stijl.
 * @property frontShiny De glanzende versie van de voorkant weergave in "Pokémon X" en "Pokémon Y" stijl.
 * @property frontShinyFemale De vrouwelijke, glanzende versie van de voorkant weergave van de Pokémon, indien beschikbaar, in "Pokémon X" en "Pokémon Y" stijl.
 */
data class XY(
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)