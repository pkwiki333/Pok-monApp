package com.example.androidpokemonapp.network.responses

import com.example.androidpokemonapp.model.PokemonList
import kotlinx.serialization.Serializable

/**
 * Dataklasse die een lijst van Pokémon representeert zoals die door de externe API wordt geleverd.
 *
 * Deze klasse bevat basisinformatie over een lijst van Pokémon, inclusief het totale aantal beschikbare Pokémon,
 * navigatielinks naar de volgende en vorige delen van de lijst, en de daadwerkelijke lijst van Pokémon.
 *
 * @property count Het totale aantal Pokémon dat beschikbaar is via de API.
 * @property next URL naar de volgende set van resultaten in de lijst (indien beschikbaar).
 * @property previous URL naar de vorige set van resultaten in de lijst (indien beschikbaar).
 * @property results Lijst van [Result] objecten, elk vertegenwoordigt een Pokémon in de lijst.
 */
@Serializable
data class ApiPokemonList(
    val count: Int,
    val next: String,
    val previous: String, //origineel Any voor als String problemen meost veroorzaken
    val results: List<Result>
)

/**
 * Converteert een [ApiPokemonList] instantie naar een lijst van [PokemonList] instanties voor gebruik in de domeinlaag.
 * Dit proces houdt in dat URL's worden geanalyseerd om Pokédex-indexen af te leiden en de nodige informatie wordt
 * geëxtraheerd voor het maken van [PokemonList] objecten.
 *
 * @return Een lijst van [PokemonList] objecten met overeenkomende namen en afgeleide Pokédex-indexen.
 */
fun ApiPokemonList.asDomainObject(): List<PokemonList> {
    return results.map {
        PokemonList(
            name = it.name,
            pokedexIndex = it.url.split("/")[6].toInt()
        )
    }
}
