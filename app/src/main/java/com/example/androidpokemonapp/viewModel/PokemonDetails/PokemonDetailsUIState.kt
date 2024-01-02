package com.example.androidpokemonapp.viewModel.PokemonDetails

import com.example.androidpokemonapp.model.Pokemon


sealed interface PokemonApiState {
    data class Success(val pokemon: Pokemon) : PokemonApiState
    object Error : PokemonApiState
    object Loading : PokemonApiState
}