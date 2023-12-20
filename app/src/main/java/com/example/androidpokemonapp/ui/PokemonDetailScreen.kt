package com.example.androidpokemonapp.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.viewModel.PokedexViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun pokemonDetailScreen(
    name: String,
    onBackButtonClicked: () -> Unit,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory)
) {
    LaunchedEffect(name) {
        pokedexViewModel.getPokemonDetail(name)
    }

    val pokemonState = pokedexViewModel.pokemonState.collectAsState().value
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Details", fontWeight = FontWeight.Bold)
            },
                navigationIcon = {
                    IconButton(onClick = onBackButtonClicked) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        }
    ) { padding ->
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                if(pokemonState.pokemonDetail ==null){
                    CircularProgressIndicator()
                }else {
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
}