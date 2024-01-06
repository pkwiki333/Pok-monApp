package com.example.androidpokemonapp.viewModel.randomPokemon

import com.example.androidpokemonapp.model.Pokemon

/**
 * Een interface die de verschillende toestanden van het ophalen van willekeurige Pokemon-details vertegenwoordigt.
 */
sealed interface RandomPokemonApiState{
    /**
     * Een dataklasse die succesvolle resultaten van het ophalen van willekeurige Pokemon-details voorstelt.
     *
     * @param pokemonDetail De gedetailleerde informatie over de willekeurige Pokemon.
     */
    data class Success(val pokemonDetail: Pokemon) : RandomPokemonApiState
    /**
     * Een object dat aangeeft dat er een fout is opgetreden bij het ophalen van willekeurige Pokemon-details.
     */
    object Error: RandomPokemonApiState
    /**
     * Een object dat aangeeft dat het proces van het ophalen van willekeurige Pokemon-details nog aan de gang is.
     */
    object Loading : RandomPokemonApiState
}