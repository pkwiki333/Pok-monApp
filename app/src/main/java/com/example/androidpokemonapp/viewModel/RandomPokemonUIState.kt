package com.example.androidpokemonapp.viewModel

import com.example.androidpokemonapp.model.Pokemon

data class RandomPokemonUIState(val pokemonDetail: Pokemon? = null)

sealed interface RandomPokemonApiState{
    object Success : RandomPokemonApiState
    object Error: RandomPokemonApiState
    object Loading : RandomPokemonApiState
}