package com.example.androidpokemonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.viewModel.PokedexViewModel
import com.example.androidpokemonapp.viewModel.PokemonApiState

@Composable
fun pokemonDetailScreen(
    name: String,
    padding: PaddingValues,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory)
) {
    val pokemonState by pokedexViewModel.pokemonState.collectAsState()
    val pokemonApiState = pokedexViewModel.pokemonApiState
    val uiPokemonListState by pokedexViewModel.uiPokemonListState.collectAsState()


    LaunchedEffect(name) {
        pokedexViewModel.getPokemonDetail(name)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (pokemonApiState) {
            is PokemonApiState.Loading -> gifImage()
            is PokemonApiState.Error -> {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.psyduck_logo_c81917330c_seeklogo_com),
                        contentDescription = "ErrorPagePsyduck"
                    )
                    Text(text = "Laden mislukt")
                }
            }
            is PokemonApiState.Success -> {
                pokemonDetailScreenContent(
                    padding = padding,
                    pokemonState = pokemonState,
                    uiPokemonListState = uiPokemonListState,
                )
            }
        }
    }

}
