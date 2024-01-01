package com.example.androidpokemonapp.viewModel.Pokedex

import com.example.androidpokemonapp.model.Pokemon

data class PokedexUIState(
    val name: String = "", val pokedexIndex: Int = 0

)




sealed interface PokemonListApiState {
    object Success : PokemonListApiState
    object Error : PokemonListApiState
    object Loading : PokemonListApiState
}



