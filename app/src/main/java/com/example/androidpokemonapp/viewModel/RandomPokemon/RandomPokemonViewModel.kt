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
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState
import com.example.androidpokemonapp.viewModel.RandomPokemon.RandomPokemonApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class RandomPokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    //private val _randomPokemonState = MutableStateFlow(RandomPokemonUIState(null))
    //val randomPokemonState: StateFlow<RandomPokemonUIState> = _randomPokemonState.asStateFlow()

    var randomPokemonApiState: StateFlow<RandomPokemonApiState> =
        //MutableStateFlow(RandomPokemonApiState.Loading).asStateFlow()
        pokemonRepository.getPokemonList().flatMapConcat {
            pokemonList ->
            pokemonRepository.getPokemonInfo(pokemonList.random().name)
        }.map<Pokemon, RandomPokemonApiState> { RandomPokemonApiState.Success(it) }
            .catch { Log.e("RandomPokemonviewModel", "getrandomPokemon: ", it)
            emit(RandomPokemonApiState.Error) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = RandomPokemonApiState.Loading
            )

   /* init {
        getRandomPokemon()
    }

     fun getRandomPokemon() {
        try {
            viewModelScope.launch {
                val pokemonList = pokemonRepository.getPokemonList().first()
                val randomPokemon = pokemonList.random()
                var pokemonName = randomPokemon.name
                loadPokemonInfo(pokemonName)
            }
        } catch (e: Exception) {
            randomPokemonApiState = flowOf(RandomPokemonApiState.Error).stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = RandomPokemonApiState.Error,
            )
            Log.e("RandomPokemonViewModel", "!!!!!getRandomPokemon: ${e.message}")
        }
    }

    private fun loadPokemonInfo(pokemonName: String){
        randomPokemonApiState =
            pokemonRepository.getPokemonInfo(pokemonName)
                .map<Pokemon, RandomPokemonApiState>
                { RandomPokemonApiState.Success(it) }
                .catch { e -> Log.e("error", "!!!!error Random Pokemon") }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.WhileSubscribed(5_000L),
                    initialValue = RandomPokemonApiState.Loading
                )
    }*/
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