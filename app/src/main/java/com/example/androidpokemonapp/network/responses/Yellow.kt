package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de visuele representaties van Pokémon in de "Pokémon Yellow" versie van de Pokémon-spellen bevat.
 *
 * Deze klasse slaat verschillende afbeeldingen op die gebruikt worden voor de weergave van Pokémon in de "Pokémon Yellow" versie.
 * Het omvat zowel standaard als grijze (gray) versies van zowel de achterkant als de voorkant weergave van Pokémon.
 *
 * @property backDefault De standaard achterkant weergave van de Pokémon in "Pokémon Yellow" stijl.
 * @property backGray De grijze achterkant weergave van de Pokémon in "Pokémon Yellow" stijl.
 * @property backTransparent De transparante achterkant weergave van de Pokémon in "Pokémon Yellow" stijl, indien beschikbaar.
 * @property frontDefault De standaard voorkant weergave van de Pokémon in "Pokémon Yellow" stijl.
 * @property frontGray De grijze voorkant weergave van de Pokémon in "Pokémon Yellow" stijl.
 * @property frontTransparent De transparante voorkant weergave van de Pokémon in "Pokémon Yellow" stijl, indien beschikbaar.
 */
data class Yellow(
    val backDefault: String,
    val backGray: String,
    val backTransparent: String,
    val frontDefault: String,
    val frontGray: String,
    val frontTransparent: String
)