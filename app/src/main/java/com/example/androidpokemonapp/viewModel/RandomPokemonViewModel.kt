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
import com.example.androidpokemonapp.data.mockdata.PokemonData
import com.example.androidpokemonapp.model.PokemonDataDC
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RandomPokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val _randomPokemonState = MutableStateFlow<PokemonState>(PokemonState(null))
    val randomPokemonState: StateFlow<PokemonState> = _randomPokemonState.asStateFlow()

    var RandomPokemonApiState: PokemonApiState by mutableStateOf(PokemonApiState.Loading)
        private set

    fun getRandomPokemon(){
        viewModelScope.launch {
            try {
                val pokemonList = pokemonRepository.getPokemonList()
                if (pokemonList.isNotEmpty()) {
                    val randomPokemonName = pokemonList.random().name
                    val randomPokemonDetail = pokemonRepository.getPokemonInfo(randomPokemonName)

                    _randomPokemonState.value = PokemonState(randomPokemonDetail)
                    Log.i("RandomPokemonViewModel", "!!!!!!!!!!Werkt wel")
                }
            } catch (e: Exception) {
                Log.i("RandomPokemonViewModel", "!!!!!!!!!!Werkt niet")
            }
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                RandomPokemonViewModel(pokemonRepository)
            }
        }
    }
}