package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de Red en Blue versies van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de klassieke Red en Blue versies.
 * Het omvat zowel gekleurde als grijstinten afbeeldingen, evenals transparante versies van zowel de voor- als achterkant weergaven.
 *
 * @property backDefault De standaard achterkant weergave van de Pokémon in Red/Blue-stijl.
 * @property backGray De achterkant weergave in grijstinten van de Pokémon in Red/Blue-stijl.
 * @property backTransparent De transparante achterkant weergave van de Pokémon in Red/Blue-stijl.
 * @property frontDefault De standaard voorkant weergave van de Pokémon in Red/Blue-stijl.
 * @property frontGray De voorkant weergave in grijstinten van de Pokémon in Red/Blue-stijl.
 * @property frontTransparent De transparante voorkant weergave van de Pokémon in Red/Blue-stijl.
 */
data class RedBlue(
    val backDefault: String,
    val backGray: String,
    val backTransparent: String,
    val frontDefault: String,
    val frontGray: String,
    val frontTransparent: String
)