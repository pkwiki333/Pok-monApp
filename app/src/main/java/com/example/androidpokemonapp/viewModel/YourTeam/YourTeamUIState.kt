package com.example.androidpokemonapp.viewModel.YourTeam

import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonDataDC
import com.example.androidpokemonapp.model.PokemonList

/**
 * Een verzegelde interface die de verschillende toestanden van het ophalen van Pokemon-gegevens van jouw team vertegenwoordigt.
 */
sealed interface YourPokemonApiState {
    /**
     * Een toestand die aangeeft dat het ophalen van Pokemon-gegevens van jouw team met succes is voltooid.
     *
     * @param pokemonDbList Een lijst met Pokemon-gegevens van jouw team.
     */
    data class Success(val pokemonDbList: List<PokemonList>) : YourPokemonApiState
    /**
     * Een toestand die aangeeft dat er een fout is opgetreden tijdens het ophalen van Pokemon-gegevens van jouw team.
     */
    object Error : YourPokemonApiState
    /**
     * Een toestand die aangeeft dat het ophalen van Pokemon-gegevens van jouw team aan de gang is.
     */
    object Loading : YourPokemonApiState
}