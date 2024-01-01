package com.example.androidpokemonapp.viewModel.PokemonDetails

import com.example.androidpokemonapp.model.Pokemon

data class PokemonState(val pokemonDetail: Pokemon? = null)

sealed interface PokemonApiState {
    object Success : PokemonApiState
    object Error : PokemonApiState
    object Loading : PokemonApiState
}