package com.example.androidpokemonapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidpokemonapp.data.mockdata.PokemonData
import com.example.androidpokemonapp.data.mockdata.PokemonDataDC
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PokedexViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PokedexUIState(PokemonData.getAll().map { pokemon ->
        PokemonDataDC(pokemon.name, pokemon.types, pokemon.pokedexIndex) }))
    val uiState: StateFlow<PokedexUIState> = _uiState.asStateFlow()


    fun getPokemonDetail(pokedexIndex: Int): PokemonDataDC? {
        return _uiState.value.pokemonLijst.find { it.pokedexIndex == pokedexIndex }
    }
}
