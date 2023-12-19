package com.example.androidpokemonapp.viewModel

import com.example.androidpokemonapp.data.mockdata.PokemonDataDC

data class PokedexUIState(
    val pokemonLijst: List<PokemonDataDC>,
    val isLoading: Boolean = false
)


