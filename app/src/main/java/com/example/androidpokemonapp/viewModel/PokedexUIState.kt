package com.example.androidpokemonapp.viewModel

import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonDataDC
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.responses.ApiPokemonList

data class PokedexUIState(
    val name: String = "", val pokedexIndex: Int = 0

)

data class PokemonState(val pokemonDetail: Pokemon? = null)


sealed interface PokemonListApiState {
    object Success : PokemonListApiState
    object Error : PokemonListApiState
    object Loading : PokemonListApiState
}

sealed interface PokemonApiState {
    data class Success(val pokemonDetail: Pokemon?) : PokemonApiState
    object Error : PokemonApiState
    object Loading : PokemonApiState
}


