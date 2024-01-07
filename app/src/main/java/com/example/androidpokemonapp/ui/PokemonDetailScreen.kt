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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.viewModel.pokemonDetails.PokemonApiState
import com.example.androidpokemonapp.viewModel.pokemonDetails.PokemonDetailsViewModel

/**
 * Een composable functie voor het weergeven van gedetailleerde informatie over een Pokémon.
 *
 * @param name De naam van de Pokémon waarvoor de details worden weergegeven.
 * @param padding De paddingwaarden voor de layout.
 * @param pokemonDetailsViewModel Het ViewModel voor het ophalen van Pokémon-details.
 */
@Composable
fun PokemonDetailScreen(
    name: String,
    padding: PaddingValues,
    pokemonDetailsViewModel: PokemonDetailsViewModel = viewModel(factory = PokemonDetailsViewModel.Factory(name = name))
) {
    val uiPokemonApiState by pokemonDetailsViewModel.uipokemonApiState.collectAsState()


    LaunchedEffect(name) {
        pokemonDetailsViewModel.getPokemonDetail(name)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (uiPokemonApiState) {
            is PokemonApiState.Loading -> GifImage(modifier = Modifier.testTag("PikachuGif"))
            is PokemonApiState.Error -> {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.psyduck_logo_c81917330c_seeklogo_com),
                        contentDescription = "ErrorPagePsyduck", modifier = Modifier.testTag("errorPsyduck")
                    )
                    Text(text = "Laden mislukt", modifier = Modifier.testTag("errorText"))
                }
            }
            is PokemonApiState.Success -> {
                    PokemonDetailScreenContent(
                        pokemon = (uiPokemonApiState as PokemonApiState.Success).pokemon
                    )
            }
        }
    }

}
