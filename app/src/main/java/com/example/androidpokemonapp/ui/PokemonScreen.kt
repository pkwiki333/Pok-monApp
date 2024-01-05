package com.example.androidpokemonapp.ui

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidpokemonapp.R

/**
 * Een composable functie voor het hoofdscherm van de Pokémon-applicatie.
 *
 * @param padding De paddingwaarden voor de layout.
 * @param onPokemonOfTheDayClicked Een callback om te reageren wanneer "Random Pokémon" wordt geklikt.
 * @param onPokedexClicked Een callback om te reageren wanneer "Pokédex" wordt geklikt.
 * @param onYourTeamClicked Een callback om te reageren wanneer "Your team" wordt geklikt.
 */
@Composable
fun PokemonScreen(
    padding: PaddingValues,
    onPokemonOfTheDayClicked: () -> Unit,
    onPokedexClicked: () -> Unit,
    onYourTeamClicked: () -> Unit
) {
    val backgroundImagePainter = painterResource(id = R.drawable.achtrgrondpokemonappstaand)

    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = backgroundImagePainter,
            contentDescription = "Background",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (isLandscape) {
                Image(
                    painter = painterResource(id = R.drawable.pokemon_23),
                    contentDescription = "Pokémon logo",
                    modifier = Modifier
                        .size(180.dp)
                        .padding(bottom = 80.dp)
                )

            } else {
                Image(
                    painter = painterResource(id = R.drawable.pokemon_23),
                    contentDescription = "Pokémon logo",
                    modifier = Modifier.size(dimensionResource(id = R.dimen.logo_size))
                )
            }
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        ) {

            if (isLandscape) {
                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(id = R.dimen.padding_medium))) {
                    Button(
                        onClick = onPokemonOfTheDayClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
                        modifier = Modifier
                            .width(400.dp)

                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                            contentDescription = "Random Pokémon",
                            modifier = Modifier.size(dimensionResource(id = R.dimen.pokeball_size))
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                        Text("Random Pokémon", color = MaterialTheme.colorScheme.onSurface)
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

                    Button(
                        onClick = onPokedexClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
                        modifier = Modifier.width(400.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                            contentDescription = "Pokédex",
                            modifier = Modifier.size(dimensionResource(id = R.dimen.pokeball_size))
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                        Text("Pokédex", color = MaterialTheme.colorScheme.onSurface)
                    }

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

                    Button(
                        onClick = onYourTeamClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
                        modifier = Modifier.width(400.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                            contentDescription = "Your pokémon",
                            modifier = Modifier.size(dimensionResource(id = R.dimen.pokeball_size))
                        )
                        Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                        Text("Your team", color = MaterialTheme.colorScheme.onSurface)
                    }
                }


            } else {


                Button(
                    onClick = onPokemonOfTheDayClicked,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                        contentDescription = "Random Pokémon",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.pokeball_size))
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                    Text("Random Pokémon", color = MaterialTheme.colorScheme.onSurface)
                }

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

                Button(
                    onClick = onPokedexClicked,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                        contentDescription = "Pokédex",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.pokeball_size))
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                    Text("Pokédex", color = MaterialTheme.colorScheme.onSurface)
                }

                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))

                Button(
                    onClick = onYourTeamClicked,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                        contentDescription = "Your pokémon",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.pokeball_size))
                    )
                    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                    Text("Your team", color = MaterialTheme.colorScheme.onSurface)
                }
            }
        }

    }
}