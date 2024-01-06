package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die officiële kunstwerken van Pokémon bevat.
 *
 * Deze klasse slaat afbeeldingen op van de officiële kunstwerken van Pokémon, waaronder zowel de standaard als de glanzende (shiny) versies.
 * Deze afbeeldingen kunnen gebruikt worden voor diverse doeleinden zoals weergave in de gebruikersinterface of voor promotionele materialen.
 *
 * @property frontDefault De standaard afbeelding van het officiële kunstwerk van een Pokémon.
 * @property frontShiny De glanzende (shiny) versie van het officiële kunstwerk van een Pokémon.
 */
data class OfficialArtwork(
    val frontDefault: String,
    val frontShiny: String
)