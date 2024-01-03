package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.model.PokemonList

object FakeApiDataSource {

    private val fakeApiPokemonList = listOf(
        PokemonList(name = "Bulbasaur", pokedexIndex = 1, isCatched = false),
        PokemonList(name = "Charmander", pokedexIndex = 4, isCatched = false),
        PokemonList(name = "Squirtle", pokedexIndex = 7, isCatched = false),
        PokemonList(name = "Pikachu", pokedexIndex = 25, isCatched = false)
    )

    fun getPokemonList(): List<PokemonList> {
        return fakeApiPokemonList
    }

}