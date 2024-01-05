package com.example.androidpokemonapp.network.responses

/**
 * Data klasse die de Emerald-stijl weergaven van een Pokémon voorstelt.
 *
 * Deze klasse bevat de afbeeldingen van Pokémon zoals ze worden weergegeven in het Pokémon Emerald-spel.
 * Het biedt zowel de standaard als de glanzende (shiny) versies van de voorkant van een Pokémon.
 *
 * @property front_default De standaard voorkant weergave van de Pokémon in Emerald-stijl.
 * @property front_shiny De glanzende (shiny) versie van de voorkant weergave van de Pokémon in Emerald-stijl.
 */
data class Emerald(
    val front_default: String,
    val front_shiny: String
)