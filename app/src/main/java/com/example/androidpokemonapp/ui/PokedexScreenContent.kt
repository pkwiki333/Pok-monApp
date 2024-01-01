package com.example.androidpokemonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexUIState

@Composable
fun pokedexScreenContent(
    padding: PaddingValues,
    onPokemonClicked: (String) -> Unit,
    pokedexUIState: PokedexUIState,
    uiPokemonList: List<PokemonList>) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.pokemon_23),
                contentDescription = "Pokémon logo",
                modifier = Modifier.size(dimensionResource(id = R.dimen.logo_size))
            )
        }
        pokedexList(padding = padding, onPokemonClicked = onPokemonClicked, uiPokemonList = uiPokemonList)
    }
}