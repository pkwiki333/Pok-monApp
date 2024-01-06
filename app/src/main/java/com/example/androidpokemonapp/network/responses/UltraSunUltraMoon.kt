package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de "Ultra Sun" en "Ultra Moon" versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de "Ultra Sun" en "Ultra Moon" versies.
 * Het omvat zowel standaard als glanzende (shiny) versies, evenals een mogelijke vrouwelijke variant van de voorkant weergave.
 *
 * @property frontDefault De standaard voorkant weergave van de Pokémon in "Ultra Sun" en "Ultra Moon" stijl.
 * @property frontFemale De vrouwelijke voorkant weergave van de Pokémon, indien beschikbaar, in "Ultra Sun" en "Ultra Moon" stijl.
 * @property frontShiny De glanzende versie van de voorkant weergave in "Ultra Sun" en "Ultra Moon" stijl.
 * @property frontShinyFemale De vrouwelijke, glanzende versie van de voorkant weergave van de Pokémon, indien beschikbaar, in "Ultra Sun" en "Ultra Moon" stijl.
 */
data class UltraSunUltraMoon(
    val frontDefault: String,
    val frontFemale: Any,
    val frontShiny: String,
    val frontShinyFemale: Any
)