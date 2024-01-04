package com.example.androidpokemonapp.viewModel.Pokedex

import android.util.Log
import androidx.compose.runtime.collectAsState
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
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.viewModel.RandomPokemon.RandomPokemonApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

//todo fix yourTeam in RoomDb
class PokedexViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    //private val _pokemonListState = MutableStateFlow(PokedexUIState())
    //val pokemonListState: StateFlow<PokedexUIState> = _pokemonListState.asStateFlow()
    private var offset = 0
    val hasMoreData = true

    var uipokemonListApiState: StateFlow<PokemonListApiState> =
        MutableStateFlow(PokemonListApiState.Loading).asStateFlow()

    init {
        fetchPokemons()
    }

    fun fetchPokemons(offset: Int = 0) {
        try {

            uipokemonListApiState =
                pokemonRepository.getPokemonList()
                    .map { PokemonListApiState.Success(it) }
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

   /* fun loadMorePokemons() {
        if(hasMoreData){
            offset += 20
            fetchPokemons(offset)
        }
    }*/


    fun updateIsCatched(name: String, isCatched: Boolean) {

        viewModelScope.launch {
            try {
                var currentState = uipokemonListApiState.value
                if(currentState is PokemonListApiState.Success) {
                    var pokemonList = currentState.pokemonList

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







