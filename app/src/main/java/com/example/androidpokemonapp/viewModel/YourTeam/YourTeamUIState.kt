package com.example.androidpokemonapp.viewModel.YourTeam

import com.example.androidpokemonapp.model.PokemonDataDC
import com.example.androidpokemonapp.model.PokemonList

data class YourTeamUiState(val name: String = "", val pokedexIndex: Int = 0)

sealed interface YourPokemonApiState {
    object Success : YourPokemonApiState
    object Error : YourPokemonApiState
    object Loading : YourPokemonApiState
}