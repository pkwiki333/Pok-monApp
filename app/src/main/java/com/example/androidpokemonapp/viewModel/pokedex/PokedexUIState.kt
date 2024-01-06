package com.example.androidpokemonapp.viewModel.pokedex

import com.example.androidpokemonapp.model.PokemonList

/**
 * Sealed interface die verschillende staten vertegenwoordigt voor het ophalen van de Pokemon-lijst.
 */
sealed interface PokemonListApiState {
    /**
     * Een succesvolle staat die de lijst van Pokemon bevat.
     *
     * @property pokemonList De lijst van Pokemon.
     */
    data class Success(val pokemonList: List<PokemonList>/*, val hasMoreData: Boolean*/) : PokemonListApiState
    /**
     * Een foutstaat die aangeeft dat er een fout is opgetreden bij het ophalen van de gegevens.
     */
    object Error : PokemonListApiState
    /**
     * Een laadstaat die aangeeft dat de gegevens aan het laden zijn.
     */
    object Loading : PokemonListApiState
}



