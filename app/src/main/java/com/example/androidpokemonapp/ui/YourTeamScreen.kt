package com.example.androidpokemonapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.data.mockdata.PokemonData
import com.example.androidpokemonapp.viewModel.YourTeamViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun YourTeamScreen(onBackButtonClicked: () -> Unit, onPokemonClicked: (Int) -> Unit, yourTeamViewModel: YourTeamViewModel = viewModel()) {
    val teamPokemons = yourTeamViewModel.teamPokemons.collectAsState()
    val team = yourTeamViewModel.getAll()
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Your team", fontWeight = FontWeight.Bold)
            },
                navigationIcon = {
                    IconButton(onClick = onBackButtonClicked ) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(team) { pokemon ->
                    PokemonCard(pokemon = pokemon, onPokemonClicked = { onPokemonClicked(pokemon.pokedexIndex) })
                }
            }
        }
    )
}
