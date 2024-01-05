package com.example.androidpokemonapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.androidpokemonapp.model.Pokemon

/**
 * Data class die een Pokémon representeert in de lokale database.
 * Deze entiteit wordt gebruikt om Pokémon-gerelateerde gegevens op te slaan in de RoomDB.
 *
 * @property name De unieke naam van de Pokémon.
 * @property pokedexIndex Het indexnummer van de Pokémon in de Pokédex.
 * @property height De hoogte van de Pokémon in decimeters.
 * @property weight Het gewicht van de Pokémon in hectogram.
 * @property types Een lijst van types die de Pokémon beschrijft.
 * @property abilities Een lijst van abilities die de Pokémon heeft.
 * @property moves Een lijst van moves die de Pokémon kan leren.
 */
@Entity
@TypeConverters(Converters::class)
data class DbPokemon(
    @PrimaryKey
    val name: String,
    val pokedexIndex: Int,
    val height: Double,
    val weight: Double,
    val types: List<String>,
    val abilities: List<String>,
    val moves: List<String>
)

/**
 * Converteert een [Pokemon] instantie naar een [DbPokemon] instantie voor opslag in de database.
 *
 * @return Een nieuwe [DbPokemon] instantie met waarden overgenomen van de [Pokemon] instantie.
 */
fun Pokemon.asDatabaseObject(): DbPokemon {
    return DbPokemon(
        name = name,
        pokedexIndex = pokedexIndex,
        height = height,
        weight = weight,
        types = types,
        abilities = abilities,
        moves = moves
    )
}

/**
 * Converteert een [DbPokemon] instantie terug naar een [Pokemon] instantie voor gebruik in de domeinlaag.
 *
 * @return Een nieuwe [Pokemon] instantie met waarden overgenomen van de [DbPokemon] instantie.
 */
fun DbPokemon.asDomainObject(): Pokemon {
    return Pokemon(
        name = name,
        pokedexIndex = pokedexIndex,
        height = height,
        weight = weight,
        types = types,
        abilities = abilities,
        moves = moves
    )
}

/**
 * Converteert een lijst van [DbPokemon] instanties naar een lijst van [Pokemon] instanties.
 *
 * @return Een lijst van [Pokemon] instanties.
 */
fun List<DbPokemon>.asDomainObject(): List<Pokemon> {
    return map {
        it.asDomainObject()
    }
}