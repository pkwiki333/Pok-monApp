package com.example.androidpokemonapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.viewModel.PokedexViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun pokemonDetailScreen(
    name: String,
    padding: PaddingValues,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory)
) {
    val pokemon = pokedexViewModel.getPokemonDetail(name)

    val pokemonState = pokedexViewModel.pokemonState.collectAsState().value

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (pokemonState.pokemonDetail == null) {
                CircularProgressIndicator()
            } else {
                Text(
                    "Naam: ${pokemonState.pokemonDetail?.name}",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Pokédex index: ${pokemonState.pokemonDetail?.pokedexIndex}")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Beschrijving: __________", style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Type: ${pokemonState.pokemonDetail?.types}")
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }

}