package com.example.androidpokemonapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidpokemonapp.data.mockdata.PokemonData
import com.example.androidpokemonapp.model.PokemonDataDC

class RandomPokemonViewModel : ViewModel() {

    private val pokemonList = PokemonData.getAll()

    fun getRandomPokemon(): PokemonDataDC {
        return pokemonList.random()
    }

}