package com.example.androidpokemonapp.viewModel.pokemonDetails

import com.example.androidpokemonapp.model.Pokemon

/**
 * Een afdichtingsinterface die verschillende toestanden vertegenwoordigt voor het ophalen van Pokemon-gegevens.
 */
sealed interface PokemonApiState {
    /**
     * Een gegevensklasse die de succesvolle respons van Pokemon-gegevens bevat.
     *
     * @property pokemon Het Pokemon-object dat is opgehaald.
     */
    data class Success(val pokemon: Pokemon) : PokemonApiState
    /**
     * Een object dat aangeeft dat er een fout is opgetreden bij het ophalen van Pokemon-gegevens.
     */
    object Error : PokemonApiState
    /**
     * Een object dat aangeeft dat Pokemon-gegevens aan het laden zijn.
     */
    object Loading : PokemonApiState
}