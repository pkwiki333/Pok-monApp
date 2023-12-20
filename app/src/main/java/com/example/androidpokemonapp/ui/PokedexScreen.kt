package com.example.androidpokemonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.PokemonDataDC
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.viewModel.PokedexViewModel
//import com.example.androidpokemonapp.viewModel.YourTeamViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen(
    onBackButtonClicked: () -> Unit,
    onPokemonClicked: (String) -> Unit,
    pokedexViewModel: PokedexViewModel = viewModel(factory = PokedexViewModel.Factory)
) {
    val pokedexUIState = pokedexViewModel.uiState.collectAsState()
   // val yourTeamViewModel: YourTeamViewModel = viewModel()

    Scaffold(topBar = {
        SmallTopAppBar(title = { Text("Pokédex") }, navigationIcon = {
            IconButton(onClick = onBackButtonClicked) {
                Icon(Icons.Filled.ArrowBack, "Back")
            }
        })
    }, content = { padding ->
        Column {
            searchBar(
                placeholder = "Search",
                modifier = Modifier
                    .padding(padding)
                    .fillMaxWidth()
            ) {
               // pokedexViewModel.searchPokemon(it)
            }
            val lazyListState = rememberLazyListState()
            LazyColumn(
                state = lazyListState,
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(pokedexUIState.value.pokemonLijst) { pokemon ->
                    PokemonCard(pokemon = pokemon, onPokemonClicked = onPokemonClicked/*, yourTeamViewModel = yourTeamViewModel*/)
                }
        }

        }
    })
}

@Composable
fun PokemonCard(pokemon: PokemonList, onPokemonClicked: (String) -> Unit/*, yourTeamViewModel: YourTeamViewModel = viewModel()*/) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(pokemon.name, style = MaterialTheme.typography.titleMedium)
                Text("Pokédex Index: ${pokemon.pokedexIndex}")
            }
            IconButton(onClick = { onPokemonClicked(pokemon.name) }) {

                Icon(Icons.Filled.Info, "Info")
            }
            IconButton(onClick = { /*yourTeamViewModel.addToTeam(pokemon)*/}) {
                Image(
                    painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                    contentDescription = "pokebal",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchBar(
    placeholder: String = "Search",
    modifier: Modifier = Modifier,
    onsearch: (String) -> Unit
){
    var text by remember { mutableStateOf("") }

    var isPlaceholderZichtbaar by remember{ mutableStateOf(placeholder != "")}

    Box(modifier = modifier){
        TextField(
            value = text,
            onValueChange = {
                text = it
                onsearch(it)
            },
            maxLines = 1,
            singleLine = true,
            placeholder = {
                if(isPlaceholderZichtbaar){
                    Text(text = placeholder)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged { isPlaceholderZichtbaar = !it.isFocused  }
        )

        }
    }
