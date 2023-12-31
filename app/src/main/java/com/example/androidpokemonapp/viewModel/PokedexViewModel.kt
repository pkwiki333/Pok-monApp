package com.example.androidpokemonapp.viewModel

import android.util.Log
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


//todo fix pokedex nu opgehaald uit RoomDb, maar moet uit de api komen. zelfde voor een pokemon en Random Pokemon.
//todo fix yourTeam in RoomDb
class PokedexViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {

    private val _pokemonListState = MutableStateFlow(PokedexUIState())
    val pokemonListState: StateFlow<PokedexUIState> = _pokemonListState.asStateFlow()

    private val _pokemonState = MutableStateFlow(PokemonState(null))
    val pokemonState: StateFlow<PokemonState> = _pokemonState.asStateFlow()


    lateinit var uiPokemonListListState: StateFlow<List<PokemonList>>

    lateinit var uiPokemonListState: StateFlow<Pokemon>

    var pokemonApiState: PokemonApiState by mutableStateOf(PokemonApiState.Loading)
        private set

    var pokemonListApiState: PokemonListApiState by mutableStateOf(PokemonListApiState.Loading)
        private set


    init {
        fetchPokemons()
    }

    private fun fetchPokemons() {
        try {
            //viewModelScope.launch {pokemonRepository.refresh()}   ---> todo eventueel voor als ik de refresh nodig heb
            uiPokemonListListState = pokemonRepository.getPokemonList().stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = emptyList()
            )
            Log.i("PokedexViewModel", "fetchPokemons: ${uiPokemonListListState.value}")
            pokemonListApiState = PokemonListApiState.Success


        } catch (e: Exception) {
            pokemonListApiState = PokemonListApiState.Error

        }
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
            pokemonApiState = PokemonApiState.Success(uiPokemonListState.value)
        } catch (e: Exception) {
            pokemonApiState = PokemonApiState.Error
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







