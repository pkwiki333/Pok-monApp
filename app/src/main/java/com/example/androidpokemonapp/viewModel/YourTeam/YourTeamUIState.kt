package com.example.androidpokemonapp.viewModel.YourTeam

import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonDataDC
import com.example.androidpokemonapp.model.PokemonList


sealed interface YourPokemonApiState {
    data class Success(val pokemonDbList: List<PokemonList>) : YourPokemonApiState
    object Error : YourPokemonApiState
    object Loading : YourPokemonApiState
}