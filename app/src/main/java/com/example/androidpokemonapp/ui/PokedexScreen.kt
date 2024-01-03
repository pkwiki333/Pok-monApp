package com.example.androidpokemonapp.ui

import PokemonCard
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.Pokedex.PokemonListApiState
import com.example.androidpokemonapp.viewModel.YourTeam.YourPokemonApiState
import com.example.androidpokemonapp.viewModel.YourTeam.YourTeamViewModel


@Composable
fun PokedexScreen(
    padding: PaddingValues,
    onPokemonClicked: (String) -> Unit,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory),
    yourTeamViewModel: YourTeamViewModel = viewModel(factory = YourTeamViewModel.Factory),
) {
    val pokemonList by pokedexViewModel.uipokemonListApiState.collectAsState()
    val yourTeamList by yourTeamViewModel.uiYourpokemonApiState.collectAsState()
    fun onPokemonCatchDb(pokemon: PokemonList) {
        pokedexViewModel.addToTeam(pokemon)
        Log.i("PokedexScreen", "!!!!!!!!onPokemonCatched: ${pokemon.name}")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        when (pokemonList) {
            is PokemonListApiState.Loading -> GifImage()
            is PokemonListApiState.Error -> {
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.psyduck_logo_c81917330c_seeklogo_com),
                        contentDescription = "ErrorPagePsyduck"
                    )
                    Text(text = "Laden mislukt")
                }
            }

            is PokemonListApiState.Success -> {
                val lazyListState = rememberLazyListState()
                LazyColumn(
                    state = lazyListState,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(
                        items = (pokemonList as PokemonListApiState.Success).pokemonList,
                        key = { pokemon -> pokemon.name }) { pokemon ->
                        PokemonCard(
                            pokemon = pokemon,
                            yourTeamList = (yourTeamList as YourPokemonApiState.Success).pokemonDbList,
                            onPokemonClicked = onPokemonClicked,
                           //onPokemonCatchDb = { pokemon -> onPokemonCatchDb(pokemon) },
                            onPokemonCatched = { pokemon ->
                                pokedexViewModel.updateIsCatched(
                                    pokemon.name,
                                    true
                                )
                            }

                        )
                    }
                }
            }
        }
    }
}








