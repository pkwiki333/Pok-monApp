package com.example.androidpokemonapp.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.androidpokemonapp.PokemonApplication
import com.example.androidpokemonapp.data.PokemonRepository
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonDataDC
import com.example.androidpokemonapp.model.PokemonList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokedexViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(PokedexUIState(emptyList(), isLoading = true))
    val uiState: StateFlow<PokedexUIState> = _uiState.asStateFlow()

    private val _pokemonState = MutableStateFlow(PokemonState(null))
    val pokemonState: StateFlow<PokemonState> = _pokemonState.asStateFlow()

    //lateinit var uiListState: StateFlow<PokemonListState>

    var pokemonApiState: PokemonApiState by mutableStateOf(PokemonApiState.Loading)
        private set

    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            try {
                val listResult = pokemonRepository.getPokemonList()
                _uiState.update {
                    it.copy(pokemonLijst = listResult)
                }
                pokemonApiState = PokemonListApiState.Success(listResult)
            } catch (e: Exception) {
                pokemonApiState = PokemonListApiState.Error
            }

        }
    }

    fun getPokemonDetail(name: String){
        viewModelScope.launch {
            try {
                val pokemonResult = pokemonRepository.getPokemonInfo(name)
                _pokemonState.update {
                    it.copy(pokemonDetail = pokemonResult)
                }
                Log.i("PokedexViewModel", "Pokemon details opgehaald: $pokemonResult")
                pokemonApiState = PokemonApiState.Success(pokemonResult)
            } catch (e: Exception) {
                Log.e("PokedexViewModel", "Fout bij het ophalen van Pokémon-details: ${e.message}")
                pokemonApiState = PokemonApiState.Error
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                PokedexViewModel(
                    pokemonRepository = pokemonRepository
                )
            }
        }
    }
}







