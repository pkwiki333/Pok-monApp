package com.example.androidpokemonapp.ui

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.PokemonList
import kotlinx.coroutines.delay

/**
 * Composable voor het weergeven van een Pokemon-kaart in het "Your Team" scherm.
 *
 * @param pokemon De PokemonList die moet worden weergegeven op de kaart.
 * @param onPokemonClicked De lambda-functie om uit te voeren wanneer er op de Pokemon-kaart wordt geklikt.
 * @param onPokemonRelease De lambda-functie om uit te voeren wanneer de Pokemon wordt vrijgegeven.
 */
@Composable
fun YourTeamPokemonCard(
    pokemon: PokemonList,
    onPokemonClicked: (String) -> Unit,
    onPokemonRelease: (PokemonList) -> Unit,
) {
    val context = LocalContext.current
    var isVisible by remember {
        mutableStateOf(true)
    }

    AnimatedVisibility(
        visible = isVisible,
        exit = fadeOut(animationSpec = tween(durationMillis = 2000)),
    ) {

        Card(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .fillMaxWidth()
                .testTag("PikachuCard")
        ) {
            Row(
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_medium))
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = dimensionResource(id = R.dimen.padding_medium))
                ) {
                    Text(pokemon.name, style = MaterialTheme.typography.titleMedium, modifier = Modifier.testTag("name"))
                    Text("Pokédex Index: ${pokemon.pokedexIndex}", modifier = Modifier.testTag("pokedexIndex"))
                }
                IconButton(onClick = { onPokemonClicked(pokemon.name) }, modifier = Modifier.testTag("onPokemonClickedButton_${pokemon.name}")) {

                    Icon(Icons.Filled.Info, "Info")
                }
                Button(
                    onClick = {
                        isVisible = false
                        Toast.makeText(context,"${pokemon.name} is released", Toast.LENGTH_SHORT).show()
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.error
                    ),
                    modifier = Modifier.testTag("Release")
                ) {
                    Text("Release")
                }
            }
        }
    }
    LaunchedEffect(key1 = isVisible) {
        if(!isVisible){
            delay(2000)
            onPokemonRelease(pokemon)
        }
    }
}

