package com.example.androidpokemonapp.viewModel.RandomPokemon

import android.util.Log
import androidx.compose.runtime.collectAsState
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
import com.example.androidpokemonapp.viewModel.RandomPokemon.RandomPokemonApiState.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RandomPokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    //private val _randomPokemonState = MutableStateFlow(RandomPokemonUIState(null))
    //val randomPokemonState: StateFlow<RandomPokemonUIState> = _randomPokemonState.asStateFlow()

    var randomPokemonApiState: StateFlow<RandomPokemonApiState> =
        MutableStateFlow(RandomPokemonApiState.Loading).asStateFlow()

    init {
        getRandomPokemon()
    }

    fun getRandomPokemon() {
        try {
            viewModelScope.launch {
                val pokemonList = pokemonRepository.getPokemonList().first()
                val randomPokemon = pokemonList.random()
                var pokemonName = randomPokemon.name

                randomPokemonApiState =
                    pokemonRepository.getPokemonInfo(pokemonName)
                        .map<Pokemon, RandomPokemonApiState> { RandomPokemonApiState.Success(it) }
                        .stateIn(
                            scope = viewModelScope,
                            started = SharingStarted.WhileSubscribed(5_000L),
                            initialValue = RandomPokemonApiState.Loading
                        )
            }
        } catch (e: Exception) {
            randomPokemonApiState = flowOf(RandomPokemonApiState.Error).stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = RandomPokemonApiState.Error
            )

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