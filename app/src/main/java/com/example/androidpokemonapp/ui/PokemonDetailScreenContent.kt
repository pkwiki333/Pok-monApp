package com.example.androidpokemonapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.viewModel.PokemonState

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun pokemonDetailScreenContent(
    padding: PaddingValues,
    uiPokemonListState: Pokemon,
    pokemonState: PokemonState
) {


    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Naam: ${uiPokemonListState.name}",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text(text = "Pokédex index: ${uiPokemonListState.pokedexIndex}")
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text("Beschrijving: __________", style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text("Type: ${uiPokemonListState.types}")
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
        }
    }
}