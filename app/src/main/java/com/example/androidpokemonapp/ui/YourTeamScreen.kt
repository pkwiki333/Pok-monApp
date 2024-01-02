package com.example.androidpokemonapp.ui

import PokemonCard
import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.data.mockdata.PokemonData
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.viewModel.Pokedex.PokedexViewModel
import com.example.androidpokemonapp.viewModel.YourTeam.YourTeamViewModel

@Composable
fun YourTeamScreen(
    onPokemonClicked: (Int) -> Unit,
    yourTeamViewModel: YourTeamViewModel = viewModel(factory = YourTeamViewModel.Factory),
    padding: PaddingValues
) {
    val teamPokemons = yourTeamViewModel.teamPokemonsState.collectAsState()
    val uiYourPokemonList by yourTeamViewModel.uiTeamPokemonsState.collectAsState()

    fun onPokemonRelease(pokemon: PokemonList) {
        yourTeamViewModel.deletePokemon(pokemon)
        Log.i("PokedexScreen", "!!!!!!!!onPokemonDelete: ${pokemon.name}")
    }
    LazyColumn(
        modifier = Modifier
            .padding(padding)
            .fillMaxSize()
    ) {
        items(uiYourPokemonList) { pokemon ->
            YourTeamPokemonCard(
                pokemon = pokemon,
                onPokemonClicked = { onPokemonClicked(pokemon.pokedexIndex) },
                onPokemonRelease = { pokemon -> onPokemonRelease(pokemon) },
            )
        }
    }

}
