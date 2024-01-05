package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Red en Blue versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de klassieke Red en Blue versies.
 * Het omvat zowel gekleurde als grijstinten afbeeldingen, evenals transparante versies van zowel de voor- als achterkant weergaven.
 *
 * @property back_default De standaard achterkant weergave van de Pokémon in Red/Blue-stijl.
 * @property back_gray De achterkant weergave in grijstinten van de Pokémon in Red/Blue-stijl.
 * @property back_transparent De transparante achterkant weergave van de Pokémon in Red/Blue-stijl.
 * @property front_default De standaard voorkant weergave van de Pokémon in Red/Blue-stijl.
 * @property front_gray De voorkant weergave in grijstinten van de Pokémon in Red/Blue-stijl.
 * @property front_transparent De transparante voorkant weergave van de Pokémon in Red/Blue-stijl.
 */
data class RedBlue(
    val back_default: String,
    val back_gray: String,
    val back_transparent: String,
    val front_default: String,
    val front_gray: String,
    val front_transparent: String
)