package com.example.androidpokemonapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidpokemonapp.model.PokemonList

/**
 * Representeert een tabel voor de opgeslagen Pokémon-team in de lokale database.
 *
 * @property name De unieke naam van de Pokémon.
 * @property pokedexIndex Het indexnummer van de Pokémon in de Pokédex.
 * @property isCatched Geeft aan of de Pokémon gevangen is door de gebruiker en in YourTeam zit.
 */
@Entity(tableName = "YourTeam")
data class DbPokemonList
    (
    @PrimaryKey
    val name: String,
    val pokedexIndex: Int,
    var isCatched: Boolean = false
)

/**
 * Converteert een [PokemonList] instantie naar een [DbPokemonList] instantie.
 * Dit is handig voor het opslaan van de gegevens in de lokale database.
 *
 * @return Een [DbPokemonList] instantie met de overeenkomende eigenschappen van de [PokemonList].
 */
fun PokemonList.asDatabaseObject(): DbPokemonList {
    return DbPokemonList(
        name = name,
        pokedexIndex = pokedexIndex,
        isCatched = isCatched
    )
}

/**
 * Converteert een lijst van [PokemonList] instanties naar een lijst van [DbPokemonList] instanties.
 * Dit is handig voor batchoperaties in de lokale database.
 *
 * @return Een lijst van [DbPokemonList] instanties.
 */
fun List<PokemonList>.asDatabaseObject(): List<DbPokemonList> {
    return map {
        it.asDatabaseObject()
    }
}

/**
 * Converteert een [DbPokemonList] instantie terug naar een [PokemonList] instantie.
 * Dit is nuttig wanneer de gegevens uit de database worden gehaald en gebruikt in de domeinlaag.
 *
 * @return Een [PokemonList] instantie met de eigenschappen van de [DbPokemonList].
 */
fun DbPokemonList.asDomainObject(): PokemonList {
    return PokemonList(
        name = name,
        pokedexIndex = pokedexIndex,
        isCatched = isCatched
    )
}

/**
 * Converteert een lijst van [DbPokemonList] instanties terug naar een lijst van [PokemonList] instanties.
 * Dit is handig voor het ophalen van meerdere records uit de database en deze te gebruiken in de domeinlaag.
 *
 * @return Een lijst van [PokemonList] instanties.
 */
fun List<DbPokemonList>.asDomainObject(): List<PokemonList> {
    return map {
        it.asDomainObject()
    }
}