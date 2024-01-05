package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de FireRed en LeafGreen-stijl weergaven van een Pokémon voorstelt.
 *
 * Deze klasse bevat afbeeldingen van Pokémon zoals ze worden weergegeven in de Pokémon FireRed en LeafGreen spellen.
 * Het omvat zowel standaard als glanzende (shiny) versies voor zowel de voor- als achterkant van een Pokémon.
 *
 * @property back_default De standaard achterkant weergave van de Pokémon in FireRed/LeafGreen-stijl.
 * @property back_shiny De glanzende (shiny) versie van de achterkant weergave van de Pokémon in FireRed/LeafGreen-stijl.
 * @property front_default De standaard voorkant weergave van de Pokémon in FireRed/LeafGreen-stijl.
 * @property front_shiny De glanzende versie van de voorkant weergave van de Pokémon in FireRed/LeafGreen-stijl.
 */
data class FireredLeafgreen(
    val back_default: String,
    val back_shiny: String,
    val front_default: String,
    val front_shiny: String
)