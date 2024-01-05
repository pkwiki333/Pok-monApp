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

/**
 * Een ViewModel-klasse die verantwoordelijk is voor het beheren van de willekeurige Pokemon-gegevens.
 *
 * @param pokemonRepository De repository waarmee toegang wordt verkregen tot Pokemon-gegevens.
 */
class RandomPokemonViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    /**
     * Een [StateFlow] dat de toestand van het ophalen van willekeurige Pokemon-gegevens vertegenwoordigt.
     */
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

    companion object {
        /**
         * Een [ViewModelProvider.Factory] om een instantie van [RandomPokemonViewModel] te maken.
         */
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                RandomPokemonViewModel(pokemonRepository)
            }
        }
    }
}