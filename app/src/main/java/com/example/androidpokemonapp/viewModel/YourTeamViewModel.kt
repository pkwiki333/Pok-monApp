package com.example.androidpokemonapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.androidpokemonapp.model.PokemonDataDC
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import android.util.Log

class YourTeamViewModel: ViewModel() {
    private val _teamPokemons = MutableStateFlow<List<PokemonDataDC>>(emptyList())
    val teamPokemons: StateFlow<List<PokemonDataDC>> = _teamPokemons.asStateFlow()

    val getAll: () -> MutableList<PokemonDataDC> = {
        val list = mutableListOf<PokemonDataDC>()
        for (item in teamPokemons.value) {
            list.add(PokemonDataDC(item.name, item.types, item.pokedexIndex))
        }
        list
    }
    fun addToTeam(pokemon: PokemonDataDC) {
        _teamPokemons.value = _teamPokemons.value + pokemon
        Log.i("YourTeamViewModel", "addToTeam: ${getAll()}")
    }

    fun removeFromTeam(pokemon: PokemonDataDC) {
        _teamPokemons.value = _teamPokemons.value.filter { it.pokedexIndex != pokemon.pokedexIndex }
    }
}