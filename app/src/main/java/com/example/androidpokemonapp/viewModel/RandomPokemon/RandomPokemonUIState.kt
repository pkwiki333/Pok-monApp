package com.example.androidpokemonapp.viewModel.RandomPokemon

import com.example.androidpokemonapp.model.Pokemon
import kotlinx.coroutines.flow.StateFlow

data class RandomPokemonUIState(val pokemonDetail: Pokemon? = null)

sealed interface RandomPokemonApiState{
    object Success : RandomPokemonApiState
    object Error: RandomPokemonApiState
    object Loading : RandomPokemonApiState
}