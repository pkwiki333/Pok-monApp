package com.example.androidpokemonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.androidpokemonapp.viewModel.RandomPokemon.RandomPokemonApiState
import com.example.androidpokemonapp.viewModel.RandomPokemon.RandomPokemonViewModel


@Composable
fun RandomPokemonScreen(
    padding: PaddingValues, randomPokemonViewModel: RandomPokemonViewModel =
        viewModel(factory = RandomPokemonViewModel.Factory)
) {

    val randomPokemonApiState by randomPokemonViewModel.randomPokemonApiState.collectAsState()

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
            is RandomPokemonApiState.Loading -> GifImage()
            is RandomPokemonApiState.Error -> {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.psyduck_logo_c81917330c_seeklogo_com),
                        contentDescription = "ErrorPagePsyduck"
                    )
                    Text(text = "Laden mislukt")
                }
            }
            is RandomPokemonApiState.Success -> RandomPokemonCardInhoud(
                pokemon = (randomPokemonApiState as RandomPokemonApiState.Success).pokemonDetail,
                randomPokemonViewModel = randomPokemonViewModel
            )
        }
    }
}



