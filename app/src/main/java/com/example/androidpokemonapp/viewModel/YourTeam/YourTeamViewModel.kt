
package com.example.androidpokemonapp.viewModel.YourTeam

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.androidpokemonapp.PokemonApplication
import com.example.androidpokemonapp.data.PokemonRepository
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
/**
 * ViewModel-klasse die verantwoordelijk is voor het beheren van de toestand van Pokemon-gegevens van jouw team.
 *
 * @property pokemonRepository Het repository voor het beheren van Pokemon-gerelateerde gegevens.
 */

class YourTeamViewModel(private val pokemonRepository: PokemonRepository): ViewModel() {

    /**
     * Een [StateFlow] die de toestand van Pokemon-gegevens van jouw team vertegenwoordigt.
     */
    var uiYourpokemonApiState: StateFlow<YourPokemonApiState> =
        MutableStateFlow(YourPokemonApiState.Loading).asStateFlow()

    /**
     * Initialiseert de ViewModel en haalt de gegevens van Pokemon op van jouw team.
     */
    init {
        fetchYourPokemon()
    }

    /**
     * Haalt de gegevens van Pokemon op van jouw team.
     */
    private fun fetchYourPokemon() {
        try {
            uiYourpokemonApiState =
                pokemonRepository.getPokemonListDB()
                    .map { YourPokemonApiState.Success(it) }
                    .stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.WhileSubscribed(5_000L),
                        initialValue = YourPokemonApiState.Loading
                    )

        } catch (e: Exception) {
            uiYourpokemonApiState = flowOf(YourPokemonApiState.Error).stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = YourPokemonApiState.Error
            )

        }
    }

    /**
     * Werkt de status van gevangen zijn bij een Pokemon bij en verwijdert deze indien nodig.
     *
     * @param name De naam van de Pokemon.
     * @param isCatched Geeft aan of de Pokemon gevangen is.
     */
    fun updateIsCatched(name: String, isCatched: Boolean) {

        viewModelScope.launch {
            try {
                var currentState = uiYourpokemonApiState.value
                if(currentState is YourPokemonApiState.Success) {
                    var pokemonList = currentState.pokemonDbList

                    if (isCatched) {
                        pokemonRepository.updateCatchedStatus(name, false)
                        for (pokemon in pokemonList) {
                            if (pokemon.name == name) {
                                pokemonRepository.deletePokemon(pokemon)
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                Log.d("PokedexViewModel", "updateIsCatched: ${e.message}")
            }

        }
    }

    /**
     * Een [ViewModelProvider.Factory] die wordt gebruikt om een instantie van [YourTeamViewModel] te maken.
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokemonApplication)
                val pokemonRepository = application.container.pokemonRepository
                YourTeamViewModel(pokemonRepository)
            }
        }
    }

}

