import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidpokemonapp.R
import com.example.androidpokemonapp.model.PokemonList

@Composable
fun PokemonCard(
    pokemon: PokemonList,
    yourTeamList: List<PokemonList>,
    onPokemonClicked: (String) -> Unit,
    onPokemonCatchDb: (PokemonList) -> Unit,
    /*onPokemonCatched: (PokemonList) -> Unit,*/
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
            .fillMaxWidth()
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
                Text(pokemon.name, style = MaterialTheme.typography.titleMedium)
                Text("Pokédex Index: ${pokemon.pokedexIndex}")
            }
            IconButton(onClick = { onPokemonClicked(pokemon.name) }) {

                Icon(Icons.Filled.Info, "Info")
            }
            if (!yourTeamList.contains(pokemon)) {
                IconButton(onClick = { /*onPokemonCatched(pokemon)*/
                    onPokemonCatchDb(pokemon)
                    Toast.makeText(context, "${pokemon.name} is toegevoegd aan uw team", Toast.LENGTH_SHORT).show()
                    }) {
                    Image(
                        painter = painterResource(id = R.drawable.pokeball_pokemon_svgrepo_com),
                        contentDescription = "pokebal",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.pokeball_size))
                    )
                }
            }else{
                IconButton(onClick = { Toast.makeText(context, "${pokemon.name} zit al in uw team", Toast.LENGTH_SHORT).show() }) {
                    Image(
                        painter = painterResource(id = R.drawable.pokeball_png_blackwhite),
                        contentDescription = "pokeball black/white",
                        modifier = Modifier.size(dimensionResource(id = R.dimen.pokeball_size))
                    )
                }
            }
        }
    }
}