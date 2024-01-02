package com.example.androidpokemonapp.viewModel.RandomPokemon

import com.example.androidpokemonapp.model.Pokemon
import kotlinx.coroutines.flow.StateFlow


sealed interface RandomPokemonApiState{
    data class Success(val pokemonDetail: Pokemon) : RandomPokemonApiState
    object Error: RandomPokemonApiState
    object Loading : RandomPokemonApiState
}