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
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class PokemonDetailsViewModel(private val pokemonRepository: PokemonRepository, name: String) :
    ViewModel() {


    private val _pokemonState = MutableStateFlow(PokemonState(null))
    val pokemonState: StateFlow<PokemonState> = _pokemonState.asStateFlow()

    lateinit var uiPokemonListState: StateFlow<Pokemon>

    var pokemonApiState: PokemonApiState by mutableStateOf(PokemonApiState.Loading)
        private set

    init {
        getPokemonDetail(name)
    }

    fun getPokemonDetail(name: String) {
        //viewModelScope.launch {pokemonRepository.refresh()}   ---> todo  eventueel voor als ik de refresh nodig heb
        try {
            uiPokemonListState = pokemonRepository.getPokemonInfo(name).stateIn(
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
            pokemonApiState = PokemonApiState.Success
        } catch (e: Exception) {
            pokemonApiState = PokemonApiState.Error
        }

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