package com.example.androidpokemonapp.model


/**
 * Modelklasse die een Pokémon representeert.
 *
 * @property name De naam van de Pokémon.
 * @property pokedexIndex Het unieke indexnummer van de Pokémon in de Pokédex.
 * @property height De hoogte van de Pokémon, uitgedrukt in decimeters.
 * @property weight Het gewicht van de Pokémon, uitgedrukt in hectogram.
 * @property types Een lijst van de types van de Pokémon. Een Pokémon kan meer dan één type hebben.
 * @property abilities Een lijst van de vaardigheden (abilities) van de Pokémon.
 * @property moves Een lijst van de aanvallen (moves) die de Pokémon kan leren.
 */
data class Pokemon(
    val name: String,
    val pokedexIndex: Int,
    val height: Double,
    val weight: Double,
    val types: List<String>,
    val abilities: List<String>,
    val moves: List<String>
)

