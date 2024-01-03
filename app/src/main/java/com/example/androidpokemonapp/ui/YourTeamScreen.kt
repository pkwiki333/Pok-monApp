package com.example.androidpokemonapp.ui

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState
import com.example.androidpokemonapp.viewModel.YourTeam.YourPokemonApiState
import com.example.androidpokemonapp.viewModel.YourTeam.YourTeamViewModel

@Composable
fun YourTeamScreen(
    onPokemonClicked: (String) -> Unit,
    yourTeamViewModel: YourTeamViewModel = viewModel(factory = YourTeamViewModel.Factory),
    padding: PaddingValues,

    ) {
    val uiYourPokemonApiList by yourTeamViewModel.uiYourpokemonApiState.collectAsState()

    fun onPokemonRelease(pokemon: PokemonList) {
        yourTeamViewModel.deletePokemon(pokemon)
    }
    when (uiYourPokemonApiList) {
        is YourPokemonApiState.Loading -> GifImage()
        is YourPokemonApiState.Error -> Column {
            Image(
                painter = painterResource(id = R.drawable.psyduck_logo_c81917330c_seeklogo_com),
                contentDescription = "ErrorPagePsyduck"
            )
            Text(text = "Laden mislukt")
        }

        is YourPokemonApiState.Success -> {
            LazyColumn(
                modifier =Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(items = (uiYourPokemonApiList as YourPokemonApiState.Success).pokemonDbList, key = { pokemon -> pokemon.name}) { pokemon ->
                    YourTeamPokemonCard(
                        pokemon = pokemon,
                        onPokemonClicked = { onPokemonClicked(pokemon.name) },
                        onPokemonRelease = { pokemon -> onPokemonRelease(pokemon) },
                    )
                }
            }
        }
    }

}
