import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.PokemonList

@Composable
fun PokemonCard(
    pokemon: PokemonList,
    onPokemonClicked: (String) -> Unit/*, yourTeamViewModel: YourTeamViewModel = viewModel()*/
) {
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
            IconButton(onClick = { /*yourTeamViewModel.addToTeam(pokemon)*/ }) {
                Image(
                    painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                    contentDescription = "pokebal",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}