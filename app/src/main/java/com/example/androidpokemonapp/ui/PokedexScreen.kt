package com.example.androidpokemonapp.ui

import PokemonCard
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.viewModel.PokedexUIState
import com.example.androidpokemonapp.viewModel.PokedexViewModel
import com.example.androidpokemonapp.viewModel.PokemonListApiState
import com.example.androidpokemonapp.viewModel.RandomPokemonApiState

//import com.example.androidpokemonapp.viewModel.YourTeamViewModel

@Composable
fun PokedexScreen(
    padding: PaddingValues,
    onPokemonClicked: (String) -> Unit,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory)
) {
    val pokedexUIState by pokedexViewModel.pokemonListState.collectAsState()
    val pekedexApiState = pokedexViewModel.pokemonListApiState
    // val yourTeamViewModel: YourTeamViewModel = viewModel()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (pekedexApiState) {
            is PokemonListApiState.Loading -> CircularProgressIndicator()
            is PokemonListApiState.Error -> Text("Couldn't load...")
            is PokemonListApiState.Success -> PokedexScreenContent(
                padding = padding,
                onPokemonClicked = onPokemonClicked
            )
        }
    }
}

@Composable
fun PokedexScreenContent(padding: PaddingValues, onPokemonClicked: (String) -> Unit) {
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
                modifier = Modifier.size(200.dp)
            )
        }
        PokedexList(padding = padding, onPokemonClicked = onPokemonClicked)
    }
}

@Composable
fun PokedexList(
    padding: PaddingValues,
    onPokemonClicked: (String) -> Unit,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory)
) {
    val pokedexUIState by pokedexViewModel.pokemonListState.collectAsState()
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(pokedexUIState.pokemonLijst) { pokemon ->
            PokemonCard(
                pokemon = pokemon,
                onPokemonClicked = onPokemonClicked
            )
        }
    }
}




