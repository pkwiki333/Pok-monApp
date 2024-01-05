package com.example.androidpokemonapp.model

/**
 * Modelklasse die een Pokémon in een lijst representeert.
 *
 * Deze klasse wordt gebruikt om een beknopt overzicht van Pokémon weer te geven,
 * bijvoorbeeld in lijsten of overzichten. Het omvat basisinformatie zoals naam en Pokédex-index,
 * en houdt ook bij of de Pokémon gevangen is ('isCatched').
 *
 * @property name De naam van de Pokémon.
 * @property pokedexIndex Het unieke indexnummer van de Pokémon in de Pokédex.
 * @property isCatched Een boolean die aangeeft of de Pokémon al gevangen is door de gebruiker.
 *                     Standaardwaarde is `false`.
 */
data class PokemonList(val name: String, val pokedexIndex: Int, var isCatched: Boolean = false)
