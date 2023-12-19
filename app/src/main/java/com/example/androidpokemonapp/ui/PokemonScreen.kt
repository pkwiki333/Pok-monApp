package com.example.androidpokemonapp.ui

import android.annotation.SuppressLint
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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.androidpokemonapp.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonScreen(
    padding: PaddingValues,
    onPokemonOfTheDayClicked: () -> Unit,
    onPokedexClicked: () -> Unit,
    onYourTeamClicked: () -> Unit
) {
    val backgroundImagePainter = painterResource(id = R.drawable.achtrgrondpokemonappstaand)


    Box(modifier = Modifier.fillMaxSize()) {

        Scaffold(topBar = {

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
            content = {
                Image(
                    painter = backgroundImagePainter,
                    contentDescription = "Background",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {


                    Button(
                        onClick = onPokemonOfTheDayClicked,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Start)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                            contentDescription = "Random Pokémon",
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Random Pokémon", color = Color.Black)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = onPokedexClicked,
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
                        onClick = onYourTeamClicked,
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

            })
    }
}