package com.example.androidpokemonapp.viewModel

import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonDataDC
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.responses.ApiPokemonList

data class PokedexUIState(
    val pokemonLijst: List<PokemonList>,
    val isLoading: Boolean = false,
)

data class PokemonState(val pokemonDetail: Pokemon? = null)


sealed interface PokemonListApiState{
    data class Success(val pokemon: List<PokemonList>) : PokemonListApiState
    object Error: PokemonListApiState
    object Loading : PokemonListApiState
}
sealed interface PokemonApiState{
    data class Success(val pokemon: Pokemon) : PokemonApiState
    object Error: PokemonApiState
    object Loading : PokemonApiState
}


