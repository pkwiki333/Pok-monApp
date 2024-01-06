package com.example.androidpokemonapp.viewModel.pokedex

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.androidpokemonapp.PokemonApplication
import com.example.androidpokemonapp.data.PokemonRepository
import com.example.androidpokemonapp.model.PokemonList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

/**
 * ViewModel voor het beheren van de Pokedex-gegevens en interacties.
 *
 * @param pokemonRepository Het repository voor het ophalen en beheren van Pokemon-gegevens.
 */
class PokedexViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {


    var uipokemonListApiState: StateFlow<PokemonListApiState> =
        MutableStateFlow(PokemonListApiState.Loading).asStateFlow()

    /**
     * Initialiseert de ViewModel en haalt de Pokemon-gegevens op.
     */
    init {
        fetchPokemons()
    }

    /**
     * Haalt de Pokemon-gegevens op van de repository.
     *
     */
    private fun fetchPokemons() {
        try {

            uipokemonListApiState =
                pokemonRepository.getPokemonList()
                    .map<List<PokemonList>, PokemonListApiState> { PokemonListApiState.Success(it) }
                    .catch { emit(PokemonListApiState.Error) }
                    .stateIn(
                        scope = viewModelScope,
                        started = SharingStarted.WhileSubscribed(5_000L),
                        initialValue = PokemonListApiState.Loading
                    )

        } catch (e: Exception) {
            uipokemonListApiState = flowOf(PokemonListApiState.Error).stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = PokemonListApiState.Error
            )

        }
    }

    /**
     * Update de vangstatus van een Pokemon en voeg deze toe aan het team als deze is gevangen.
     *
     * @param name De naam van de Pokemon.
     * @param isCatched True als de Pokemon is gevangen, anders False.
     */
    fun updateIsCatched(name: String, isCatched: Boolean) {

        viewModelScope.launch {
            try {
                val currentState = uipokemonListApiState.value
                if (currentState is PokemonListApiState.Success) {
                    val pokemonList = currentState.pokemonList

                    if (isCatched) {
                        for (pokemon in pokemonList) {
                            if (pokemon.name == name) {
                                pokemonRepository.insertToYourTeam(pokemon)
                            }
                        }
                        pokemonRepository.updateCatchedStatus(name, true)
                    }
                }
            } catch (e: Exception) {
                Log.d("PokedexViewModel", "updateIsCatched: ${e.message}")
            }

        }
    }


    companion object {
        /**
         * Fabrieksmethode voor het maken van een `PokedexViewModel`.
         */
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







