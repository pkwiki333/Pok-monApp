package com.example.androidpokemonapp.data.mockdata

import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonDataDC

object PokemonData {
    val sampleData = listOf(
        Pokemon("Bulbasaur", "Grass, Poison", 1),
        Pokemon("Charmander", "Fire", 2),
        Pokemon("Pikachu", "Electric", 3),
        Pokemon("Charizard", "Fire", 4),
        Pokemon("Raichu", "Fire", 5),
        Pokemon("Wurmple", "Fire", 6),
        Pokemon("Golem", "Fire", 7),

    )
    val getAll: () -> MutableList<PokemonDataDC> = {
        val list = mutableListOf<PokemonDataDC>()
        for (item in sampleData) {
            list.add(PokemonDataDC(item.name, item.types, item.pokedexIndex))
        }
        list
    }
}