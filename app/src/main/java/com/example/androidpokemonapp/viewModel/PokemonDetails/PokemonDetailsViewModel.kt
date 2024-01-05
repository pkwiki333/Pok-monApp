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

/**
 * ViewModel-klasse voor het ophalen van details van een specifieke Pokemon.
 *
 * @param pokemonRepository Een verwijzing naar de repository voor het ophalen van Pokemon-gegevens.
 * @param name De naam van de Pokemon waarvan de details worden opgehaald.
 */
class PokemonDetailsViewModel(private val pokemonRepository: PokemonRepository, name: String) :
    ViewModel() {

    /**
     * Een [StateFlow] die de toestand van het ophalen van Pokemon-details vertegenwoordigt.
     */
    var uipokemonApiState: StateFlow<PokemonApiState> =
        MutableStateFlow(PokemonApiState.Loading).asStateFlow()

    /**
     * Initialiseert de ViewModel en haalt de details op voor de opgegeven Pokemon-naam.
     *
     * @param name De naam van de Pokemon waarvan de details worden opgehaald.
     */
    init {
        getPokemonDetail(name)
    }

    /**
     * Haalt de details op voor de opgegeven Pokemon-naam en werkt de toestand bij.
     *
     * @param name De naam van de Pokemon waarvan de details worden opgehaald.
     */
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
    }


    companion object {
        /**
         * Factory voor het maken van een instantie van [PokemonDetailsViewModel].
         *
         * @param name De naam van de Pokemon waarvan de details worden opgehaald.
         * @return Een [ViewModelProvider.Factory] die wordt gebruikt om de ViewModel te maken.
         */
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