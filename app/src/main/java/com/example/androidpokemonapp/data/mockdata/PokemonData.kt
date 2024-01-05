package com.example.androidpokemonapp.data.mockdata

import com.example.androidpokemonapp.model.PokemonDataDC

object PokemonData {
    val sampleData = listOf(
        PokemonDataDC("Bulbasaur", "Grass, Poison", 1),
        PokemonDataDC("Charmander", "Fire", 2),
        PokemonDataDC("Pikachu", "Electric", 3),
        PokemonDataDC("Charizard", "Fire", 4),
        PokemonDataDC("Raichu", "Fire", 5),
        PokemonDataDC("Wurmple", "Fire", 6),
        PokemonDataDC("Golem", "Fire", 7),

    )
    val getAll: () -> MutableList<PokemonDataDC> = {
        val list = mutableListOf<PokemonDataDC>()
        for (item in sampleData) {
            list.add(PokemonDataDC(item.name, item.types, item.pokedexIndex))
        }
        list
    }
}

//iets veranderd