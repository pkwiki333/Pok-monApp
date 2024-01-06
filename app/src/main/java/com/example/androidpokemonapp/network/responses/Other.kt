package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die verschillende alternatieve visuele representaties van Pokémon bevat.
 *
 * Deze klasse slaat informatie op over de diverse unieke weergaven van Pokémon, zoals die in de Dream World,
 * in de context van Pokémon Home, en de officiële kunstwerken. Elk van deze categorieën wordt beheerd door een aparte geneste dataklasse.
 *
 * @property dreamWorld Een object van de klasse DreamWorld, bevat de Dream World-stijl weergaven van Pokémon.
 * @property home Een object van de klasse Home, bevat de Pokémon Home-stijl weergaven van Pokémon.
 * @property officialartwork Een object van de klasse OfficialArtwork, bevat de officiële kunstwerkweergaven van Pokémon.
 */
data class Other(
    val dreamWorld: DreamWorld,
    val home: Home,
    val officialartwork: OfficialArtwork
)