
package com.example.androidpokemonapp.viewModel.YourTeam

import androidx.lifecycle.ViewModel
import com.example.androidpokemonapp.model.PokemonDataDC
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.androidpokemonapp.PokemonApplication
import com.example.androidpokemonapp.data.PokemonRepository
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexUIState
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class YourTeamViewModel(private val pokemonRepository: PokemonRepository): ViewModel() {
    private val _teamPokemonsState = MutableStateFlow(YourTeamUiState())
    val teamPokemonsState: StateFlow<YourTeamUiState> = _teamPokemonsState.asStateFlow()

    lateinit var uiTeamPokemonsState: StateFlow<List<PokemonList>>

    var yourPokemonApiState: YourPokemonApiState by mutableStateOf(YourPokemonApiState.Loading)
        private set

    init {
        fetchYourPokemon()
    }

    private fun fetchYourPokemon() {
        try {
           // viewModelScope.launch { pokemonRepository.refresh() }
            uiTeamPokemonsState = pokemonRepository.getPokemonListDB().stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = emptyList()
            )
            yourPokemonApiState = YourPokemonApiState.Success
        } catch (e: Exception) {
            yourPokemonApiState = YourPokemonApiState.Error
        }
    }

    fun deletePokemon(pokemon: PokemonList){
        viewModelScope.launch {
            pokemonRepository.deletePokemon(pokemon)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                YourTeamViewModel(pokemonRepository)
            }
        }
    }

}

