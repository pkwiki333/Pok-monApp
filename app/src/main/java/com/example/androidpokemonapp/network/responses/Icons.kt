package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die iconische afbeeldingen van Pokémon opslaat.
 *
 * Deze klasse is bedoeld om iconische representaties van Pokémon op te slaan, waarschijnlijk voor gebruik in gebruikersinterfaces of als kleinere, vereenvoudigde afbeeldingen.
 * Het omvat standaard iconische afbeeldingen en, indien beschikbaar, varianten voor vrouwelijke Pokémon.
 *
 * @property front_default De standaard iconische afbeelding van een Pokémon.
 * @property front_female De iconische afbeelding van een vrouwelijke Pokémon, indien deze verschilt van de standaard.
 */
data class Icons(
    val front_default: String,
    val front_female: Any
)