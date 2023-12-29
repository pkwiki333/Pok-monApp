package com.example.androidpokemonapp.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.viewModel.PokedexViewModel
import com.example.androidpokemonapp.viewModel.PokemonListApiState

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
            is PokemonListApiState.Loading -> gifImage()
            is PokemonListApiState.Error -> Text("Couldn't load...")
            is PokemonListApiState.Success -> pokedexScreenContent(
                padding = padding,
                onPokemonClicked = onPokemonClicked
            )
        }
    }
}








