package com.example.androidpokemonapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.viewModel.RandomPokemon.RandomPokemonViewModel
import java.io.File

/**
 * Toont een kaart met gedetailleerde informatie over een willekeurige Pokémon.
 * De inhoud bestaat uit de naam, Pokédex-index, types, abilities,
 * hoogte, gewicht, en de lijst met moves van de Pokémon.
 *
 * De kaart kan verticaal gescrold worden als de content langer is dan het scherm.
 *
 * @param pokemon De Pokémon entiteit met de gegevens die getoond moeten worden.
 * @param randomPokemonViewModel ViewModel die wordt gebruikt voor het beheren van de state en events.
 */
@Composable
fun RandomPokemonCardInhoud(
    pokemon: Pokemon,
    randomPokemonViewModel: RandomPokemonViewModel,
) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
                .verticalScroll(
                    rememberScrollState()
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    "Naam: ${pokemon.name}",
                    style = MaterialTheme.typography.titleLarge,
                )

                Text(
                    "Pokedex: ${pokemon.pokedexIndex}",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text("Types: ${pokemon.types.joinToString(separator = ", ")}")
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text("Abilities:")
            Text("${pokemon.abilities.joinToString(separator = ", ")}")
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Text("Height: ${pokemon.height / 10}m")
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    "Weight: ${pokemon.weight / 10}kg",
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_small))
                )
            }

            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Text("Moves:")
            Text("${pokemon.moves.joinToString(separator = ", ")}")
        }
    }
}
