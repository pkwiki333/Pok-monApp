package com.example.androidpokemonapp.ui

import PokemonCard
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androidpokemonapp.model.PokemonList

@Composable
fun pokedexList(
    padding: PaddingValues,
    onPokemonClicked: (String) -> Unit,
    onPokemonCatched: (PokemonList) -> Unit,
    PokemonList: List<PokemonList>,
    uiyourTeamList: List<PokemonList>
) {

    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(items = PokemonList, key = {pokemon -> pokemon.name}) { pokemon ->
            PokemonCard(
                pokemon = pokemon,
                onPokemonClicked = onPokemonClicked,
                onPokemonCatched = onPokemonCatched,
                uiyourTeamList = uiyourTeamList
            )
        }
    }
}