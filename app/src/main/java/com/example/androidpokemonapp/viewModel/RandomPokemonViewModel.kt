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
import com.example.androidpokemonapp.viewModel.RandomPokemonApiState.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class RandomPokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val _randomPokemonState = MutableStateFlow(RandomPokemonUIState(null))
    val randomPokemonState: StateFlow<RandomPokemonUIState> = _randomPokemonState.asStateFlow()

    var randomPokemonApiState: RandomPokemonApiState by mutableStateOf(Loading)
        private set

    fun getRandomPokemon() {
        viewModelScope.launch {
            try {
                val pokemonList = pokemonRepository.getPokemonList()
                if (pokemonList.isNotEmpty()) {
                    val randomPokemonName = pokemonList.random().name
                    val randomPokemonDetail = pokemonRepository.getPokemonInfo(randomPokemonName)

                    _randomPokemonState.update { it.copy(pokemonDetail = randomPokemonDetail) }
                    randomPokemonApiState = Success(randomPokemonDetail)

                }
            } catch (e: Exception) {
                randomPokemonApiState = Error

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