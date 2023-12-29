package com.example.androidpokemonapp.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.androidpokemonapp.PokemonApplication
import com.example.androidpokemonapp.data.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PokedexViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val _pokemonListState = MutableStateFlow(PokedexUIState(emptyList()))
    val pokemonListState: StateFlow<PokedexUIState> = _pokemonListState.asStateFlow()

    private val _pokemonState = MutableStateFlow(PokemonState(null))
    val pokemonState: StateFlow<PokemonState> = _pokemonState.asStateFlow()

    //lateinit var uiListState: StateFlow<PokemonListState>

    var pokemonApiState: PokemonApiState by mutableStateOf(PokemonApiState.Loading)
        private set

    var pokemonListApiState: PokemonListApiState by mutableStateOf(PokemonListApiState.Loading)
        private set


    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        viewModelScope.launch {
            try {
                val listResult = pokemonRepository.getPokemonList()
                _pokemonListState.update {
                    it.copy(pokemonLijst = listResult)
                }
                pokemonListApiState = PokemonListApiState.Success(listResult)
            } catch (e: Exception) {
                pokemonListApiState = PokemonListApiState.Error
            }

        }
    }

    fun getPokemonDetail(name: String) {
        viewModelScope.launch {
            try {
                val pokemonResult = pokemonRepository.getPokemonInfo(name)
                _pokemonState.update {
                    it.copy(pokemonDetail = pokemonResult)
                }
                pokemonApiState = PokemonApiState.Success(pokemonResult)
            } catch (e: Exception) {
                pokemonApiState = PokemonApiState.Error
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                PokedexViewModel(pokemonRepository)
            }
        }
    }
}







