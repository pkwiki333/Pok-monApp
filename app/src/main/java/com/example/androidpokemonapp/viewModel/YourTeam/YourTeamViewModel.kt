
package com.example.androidpokemonapp.viewModel.YourTeam

import androidx.lifecycle.ViewModel
import com.example.androidpokemonapp.model.PokemonDataDC
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import android.util.Log
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList

class YourTeamViewModel: ViewModel() {
    /*
    private val _teamPokemons = MutableStateFlow<List<Pokemon>>(emptyList())
    val teamPokemons: StateFlow<List<Pokemon>> = _teamPokemons.asStateFlow()

    val getAll: () -> MutableList<PokemonDataDC> = {
        val list = mutableListOf<PokemonDataDC>()
        for (item in teamPokemons.value) {
            list.add(PokemonDataDC(item.name, item.pokedexIndex))
        }
        list
    }
    fun addToTeam(pokemon: Pokemon) {
        _teamPokemons.value = _teamPokemons.value + pokemon
        Log.i("YourTeamViewModel", "addToTeam: ${getAll()}")
    }

    fun removeFromTeam(pokemon: PokemonDataDC) {
        _teamPokemons.value = _teamPokemons.value.filter { it.pokedexIndex != pokemon.pokedexIndex }
    }*/
}

