package com.example.androidpokemonapp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

/**
 * Een composable functie voor de bovenste navigatiebalk van het Pokémon-scherm.
 *
 * @param canNavigateBack Geeft aan of de terugknop moet worden weergegeven om terug te navigeren.
 * @param navigateUp Een callback om te reageren wanneer de terugknop wordt geklikt.
 * @param currentScreenTitle De bron-ID van de huidige schermtitel.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonTopBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    currentScreenTitle: Int,
) {
    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
        ),

        title = {
            Text(stringResource(id = currentScreenTitle))
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "navigate back",
                    )
                }
            }
        }
    )
}
