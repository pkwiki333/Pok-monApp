package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de FireRed en LeafGreen-stijl weergaven van een Pokémon voorstelt.
 *
 * Deze klasse bevat afbeeldingen van Pokémon zoals ze worden weergegeven in de Pokémon FireRed en LeafGreen spellen.
 * Het omvat zowel standaard als glanzende (shiny) versies voor zowel de voor- als achterkant van een Pokémon.
 *
 * @property backDefault De standaard achterkant weergave van de Pokémon in FireRed/LeafGreen-stijl.
 * @property backShiny De glanzende (shiny) versie van de achterkant weergave van de Pokémon in FireRed/LeafGreen-stijl.
 * @property frontDefault De standaard voorkant weergave van de Pokémon in FireRed/LeafGreen-stijl.
 * @property frontShiny De glanzende versie van de voorkant weergave van de Pokémon in FireRed/LeafGreen-stijl.
 */
data class FireredLeafgreen(
    val backDefault: String,
    val backShiny: String,
    val frontDefault: String,
    val frontShiny: String
)