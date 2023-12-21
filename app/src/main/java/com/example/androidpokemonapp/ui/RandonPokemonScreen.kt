package com.example.androidpokemonapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.viewModel.PokedexViewModel
import com.example.androidpokemonapp.viewModel.RandomPokemonViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RandomPokemonScreen(padding: PaddingValues) {
    val randomPokemonViewModel: RandomPokemonViewModel =
        viewModel(factory = RandomPokemonViewModel.Factory)
    val randomPokemonState = randomPokemonViewModel.randomPokemonState.collectAsState().value


    LaunchedEffect(Unit) {
        randomPokemonViewModel.getRandomPokemon()
    }


    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (randomPokemonState.pokemonDetail == null) {
                CircularProgressIndicator()
            } else {
                Text(
                    "Naam: ${randomPokemonState.pokemonDetail?.name}",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                // Placeholder for the Pokémon image

                Text("Types: ${randomPokemonState.pokemonDetail?.types}")
                Text("Pokédex index: ${randomPokemonState.pokemonDetail?.pokedexIndex}")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Moves")
                Text("________________")
                Text("________________")
                Spacer(modifier = Modifier.height(8.dp))
                Text("Beschrijving")
                Text("________________")
                Text("________________")
            }

            Button(
                onClick = { randomPokemonViewModel.getRandomPokemon() }, modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp)
            ) {
                Text(text = stringResource(R.string.get_random_pok_mon))
            }

        }
    }
}