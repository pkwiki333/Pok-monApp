package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de "Pokémon Yellow" versie van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de "Pokémon Yellow" versie.
 * Het omvat zowel standaard als grijze (gray) versies van zowel de achterkant als de voorkant weergave van Pokémon.
 *
 * @property back_default De standaard achterkant weergave van de Pokémon in "Pokémon Yellow" stijl.
 * @property back_gray De grijze achterkant weergave van de Pokémon in "Pokémon Yellow" stijl.
 * @property back_transparent De transparante achterkant weergave van de Pokémon in "Pokémon Yellow" stijl, indien beschikbaar.
 * @property front_default De standaard voorkant weergave van de Pokémon in "Pokémon Yellow" stijl.
 * @property front_gray De grijze voorkant weergave van de Pokémon in "Pokémon Yellow" stijl.
 * @property front_transparent De transparante voorkant weergave van de Pokémon in "Pokémon Yellow" stijl, indien beschikbaar.
 */
data class Yellow(
    val back_default: String,
    val back_gray: String,
    val back_transparent: String,
    val front_default: String,
    val front_gray: String,
    val front_transparent: String
)