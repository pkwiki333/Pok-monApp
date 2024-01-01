package com.example.androidpokemonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState

//import com.example.androidpokemonapp.viewModel.YourTeam.YourTeamViewModel

@Composable
fun PokedexScreen(
    padding: PaddingValues,
    onPokemonClicked: (String) -> Unit,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory)
) {
    val pokedexUIState by pokedexViewModel.pokemonListState.collectAsState()
    val pekedexApiState = pokedexViewModel.pokemonListApiState
    // val yourTeamViewModel: YourTeamViewModel = viewModel()
    val uiPokemonList by pokedexViewModel.uiPokemonListListState.collectAsState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (pekedexApiState) {
            is PokemonListApiState.Loading -> gifImage()
            is PokemonListApiState.Error -> {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.psyduck_logo_c81917330c_seeklogo_com),
                        contentDescription = "ErrorPagePsyduck"
                    )
                    Text(text = "Laden mislukt")
                }

            }
            is PokemonListApiState.Success -> pokedexScreenContent(
                padding = padding,
                onPokemonClicked = onPokemonClicked,
                pokedexUIState = pokedexUIState,
                uiPokemonList = uiPokemonList

            )
        }
    }
}








