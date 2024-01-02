package com.example.androidpokemonapp.viewModel.PokemonDetails

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
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState
import com.example.androidpokemonapp.viewModel.RandomPokemon.RandomPokemonApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class PokemonDetailsViewModel(private val pokemonRepository: PokemonRepository, name: String) :
    ViewModel() {

    var uipokemonApiState: StateFlow<PokemonApiState> =
        MutableStateFlow(PokemonApiState.Loading).asStateFlow()

    init {
        getPokemonDetail(name)
    }

    fun getPokemonDetail(name: String) {
        try {
            uipokemonApiState =
                pokemonRepository.getPokemonInfo(name)
                    .map<Pokemon, PokemonApiState> { PokemonApiState.Success(it) }
                    .stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.WhileSubscribed(5_000L),
                        initialValue = PokemonApiState.Loading
                    )

        } catch (e: Exception) {
            uipokemonApiState = flowOf(PokemonApiState.Error).stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = PokemonApiState.Error
            )

        }




       /* try {
            uiPokemonState = pokemonRepository.getPokemonInfo(name).map { PokemonState(it)}.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = PokemonState()
            )
            pokemonApiState = PokemonApiState.Success
        } catch (e: RuntimeException) {
            pokemonApiState = PokemonApiState.Error
        }*/

    }


    companion object {
        fun Factory(name: String): ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                PokemonDetailsViewModel(pokemonRepository, name)
            }
        }
    }

}