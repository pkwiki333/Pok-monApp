package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die iconische afbeeldingen van Pokémon opslaat.
 *
 * Deze klasse is bedoeld om iconische representaties van Pokémon op te slaan, waarschijnlijk voor gebruik in gebruikersinterfaces of als kleinere, vereenvoudigde afbeeldingen.
 * Het omvat standaard iconische afbeeldingen en, indien beschikbaar, varianten voor vrouwelijke Pokémon.
 *
 * @property frontDefault De standaard iconische afbeelding van een Pokémon.
 * @property frontFemale De iconische afbeelding van een vrouwelijke Pokémon, indien deze verschilt van de standaard.
 */
data class Icons(
    val frontDefault: String,
    val frontFemale: Any
)