package com.example.androidpokemonapp.ui

import android.util.Log
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.viewModel.PokedexViewModel
import com.example.androidpokemonapp.viewModel.RandomPokemonApiState
import com.example.androidpokemonapp.viewModel.RandomPokemonUIState
import com.example.androidpokemonapp.viewModel.RandomPokemonViewModel


@Composable
fun RandomPokemonScreen(
    padding: PaddingValues, randomPokemonViewModel: RandomPokemonViewModel =
        viewModel(factory = RandomPokemonViewModel.Factory)
) {

    val randomPokemonState by randomPokemonViewModel.randomPokemonState.collectAsState()
    val randomPokemonApiState = randomPokemonViewModel.randomPokemonApiState

    LaunchedEffect(Unit) {
        randomPokemonViewModel.getRandomPokemon()
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (randomPokemonApiState) {
            is RandomPokemonApiState.Loading -> CircularProgressIndicator()
            is RandomPokemonApiState.Error -> Text("Couldn't load...")
            is RandomPokemonApiState.Success -> CardInhoud(
                randomPokemonState = randomPokemonState,
                randomPokemonViewModel = randomPokemonViewModel
            )
        }
    }
}

@Composable
fun CardInhoud(
    randomPokemonState: RandomPokemonUIState,
    randomPokemonViewModel: RandomPokemonViewModel,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                "Naam: ${randomPokemonState.pokemonDetail?.name}",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))

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

            Button(
                onClick = { randomPokemonViewModel.getRandomPokemon() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = stringResource(R.string.get_random_pok_mon))
            }

        }
    }
}


