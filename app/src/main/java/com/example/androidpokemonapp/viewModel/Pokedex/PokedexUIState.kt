package com.example.androidpokemonapp.viewModel.Pokedex

import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList

sealed interface PokemonListApiState {
    data class Success(val pokemonList: List<PokemonList>/*, val hasMoreData: Boolean*/) : PokemonListApiState
    object Error : PokemonListApiState
    object Loading : PokemonListApiState
}



