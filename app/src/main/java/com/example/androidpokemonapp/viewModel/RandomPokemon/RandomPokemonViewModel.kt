package com.example.androidpokemonapp.viewModel.RandomPokemon

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
import com.example.androidpokemonapp.viewModel.RandomPokemon.RandomPokemonApiState.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RandomPokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val _randomPokemonState = MutableStateFlow(RandomPokemonUIState(null))
    val randomPokemonState: StateFlow<RandomPokemonUIState> = _randomPokemonState.asStateFlow()

    var randomPokemonApiState: RandomPokemonApiState by mutableStateOf(Loading)
        private set

    lateinit var uiRandomPokemonState: StateFlow<Pokemon>

    fun getRandomPokemon() {
        try {
            viewModelScope.launch {
                val pokemonList = pokemonRepository.getPokemonList().first()
                val randomPokemon = pokemonList.random()
                val pokemonName = randomPokemon.name

                uiRandomPokemonState = pokemonRepository.getPokemonInfo(pokemonName).stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = Pokemon(
                        name = "",
                        pokedexIndex = 0,
                        height = 0,
                        weight = 0,
                        types = emptyList(),
                        abilities = emptyList()
                    )
                )

                randomPokemonApiState = Success
                Log.i(
                    "RandomPokemonViewModel",
                    "!!!!!!!!!getRandomPokemon: $uiRandomPokemonState"
                )
            }

        } catch (e: Exception) {
            randomPokemonApiState = Error

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