package com.example.androidpokemonapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.data.mockdata.PokemonData
import com.example.androidpokemonapp.data.mockdata.PokemonDataDC

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen(onBackButtonClicked: () -> Unit, onPokemonClicked: (Int) -> Unit) {
    val backgroundImagePainter = painterResource(id = R.drawable.achtrgrondpokemonappstaand)
    Scaffold(topBar = {
        SmallTopAppBar(title = { Text("Pokédex") }, navigationIcon = {
            IconButton(onClick =  onBackButtonClicked ) {
                Icon(Icons.Filled.ArrowBack, "Back")
            }
        })
    }, content = { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            items(PokemonData.sampleData) { pokemon ->
                PokemonCard(pokemon = pokemon, onPokemonClicked = onPokemonClicked)

            }
        }
    })
}

@Composable
fun PokemonCard(pokemon: PokemonDataDC, onPokemonClicked: (Int) -> Unit) {
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
            Image(
                painter = painterResource(R.drawable.backgroundtest),
                contentDescription = "Pokémon Image",
                modifier = Modifier.size(100.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp)
            ) {
                Text(pokemon.name, style = MaterialTheme.typography.titleMedium)
                Text("Types: ${pokemon.types}")
                Text("Pokédex Index: ${pokemon.pokedexIndex}")
            }
            IconButton(onClick = { onPokemonClicked(pokemon.pokedexIndex) }) {
                Icon(Icons.Filled.Info, "Info")
            }
            IconButton(onClick = {  }) {
                Image(
                    painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                    contentDescription = "pokebal",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}