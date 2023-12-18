package com.example.androidpokemonapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidpokemonapp.ui.theme.AndroidPokemonAppTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPokemonAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //PokemonScreen()
                    PokedexScreen()
                }
            }
        }
    }
}

//---------Hoofdmenu-----------------------------------------------------------------------------------------------------------------------
@Composable
fun PokemonContent(padding: PaddingValues) {
    // Achtergrondafbeelding
    val backgroundImagePainter = painterResource(id = R.drawable.achtrgrondpokemonappstaand)

    Box(modifier = Modifier.fillMaxSize()) {
        // Achtergrond
        Image(
            painter = backgroundImagePainter,
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Inhoud
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {


            Button(
                onClick = { /* TODO: Handler for Pokémon of the day */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                    contentDescription = "Pokémon of the day",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Pokémon of the day", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /* TODO: Handler for Pokédex */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                    contentDescription = "Pokédex",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Pokédex", color = Color.Black)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /* TODO: Handler for Your team */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                    contentDescription = "Your pokémon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Your team", color = Color.Black)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen() {
    val backgroundImagePainter = painterResource(id = R.drawable.backgroundtest)

    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(
            topBar = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center, // Centreer de inhoud horizontaal
                    verticalAlignment = Alignment.CenterVertically // Centreer de inhoud verticaal
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pokemon_23),
                        contentDescription = "Pokémon logo",
                        modifier = Modifier.size(200.dp)
                    )
                }
            },
            content = { innerPadding ->
                PokemonContent(innerPadding)
            }
        )
    }
}

//--------------------------------------------------------------------------------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonOfTheDayScreen() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(text ="Pokémon of the day", fontWeight = FontWeight.Bold)
                },
                navigationIcon = {
                    IconButton(onClick = { /* handle back navigation */ }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        },
        content = { padding ->
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Naam: __________", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    // Placeholder for the Pokémon image
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Foto")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Types: __________")
                    Text("Pokédex index: __________")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Moves")
                    Text("________________")
                    Text("________________")
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Beschrijving")
                    Text("________________")
                    Text("________________")
                }
            }
        }
    )
}
//--------------------------------------------------------------------------------------------------------------------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokedexScreen() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Pokédex") },
                navigationIcon = {
                    IconButton(onClick = { /* handle back navigation */ }) {
                        Icon(Icons.Filled.ArrowBack, "Back")
                    }
                }
            )
        },
        content = { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(PokemonData.sampleData) { pokemon ->
                    PokemonCard(pokemon = pokemon)

                }
            }
        }
    )
}

@Composable
fun PokemonCard(pokemon: PokemonDataDC) {
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
            IconButton(onClick = { /* handle info */ }) {
                Icon(Icons.Filled.Info, "Info")
            }
            IconButton(onClick = { /*TODO*/ }) {
                Image(painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com), contentDescription = "pokebal", modifier = Modifier.size(24.dp))
            }
        }
    }
}

data class PokemonDataDC(val name: String, val types: String, val pokedexIndex: Int)

object PokemonData {
    val sampleData = listOf(
        PokemonDataDC("Bulbasaur", "Grass, Poison", 1),
        PokemonDataDC("Charmander", "Fire", 2),
        PokemonDataDC("Pikachu", "Electric", 3),
        PokemonDataDC("Charizard", "Fire", 4),
        PokemonDataDC("Raichu", "Fire", 5),
        PokemonDataDC("Wurmple", "Fire", 6),
        PokemonDataDC("Golem", "Fire", 7),
        // Add more sample data here
    )
}

//--------------------------------------------------------------------------------------------------------------------------------
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidPokemonAppTheme {
        PokemonScreen()
    }
}