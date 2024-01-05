package com.example.androidpokemonapp.model

/**
 * Modelklasse die essentiële gegevens van een Pokémon representeert.
 *
 * Deze klasse is bedoeld voor eenvoudige weergaven waar niet alle details van een Pokémon nodig zijn,
 * maar alleen de basisinformatie zoals naam, types en Pokédex-index.
 *
 * @property name De naam van de Pokémon.
 * @property types Een gecombineerde string van de types van de Pokémon.
 *                Verschillende types worden mogelijk gescheiden door een specifiek teken of woord.
 * @property pokedexIndex Het unieke indexnummer van de Pokémon in de Pokédex.
 */
data class PokemonDataDC(val name: String, val types: String, val pokedexIndex: Int)
