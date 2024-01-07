/*
package com.example.androidpokemonapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

*/
/**
 * Abstracte database klasse voor de RoomDB die de lokale opslag definieert voor Pokémon-gegevens.
 *
 * Deze klasse definieert de lijst van entiteiten en de databaseversie.
 * Typeconverters worden gespecificeerd om aangepaste typen op te slaan,
 * zoals lijsten van strings die niet direct ondersteund worden door SQLite.
 *
 * @see DbPokemon De entiteit die Pokémon-instanties in de database representeert.
 * @see Converters De klasse die de typeconverters bevat voor het omzetten van complexe datatypes.
 *//*

@Database(entities = [DbPokemon::class], version = 3)
@TypeConverters(Converters::class)
abstract class PokemonDatabase : RoomDatabase(){
    */
/**
     * Geeft de DAO (Data Access Object) terug voor interactie met de Pokémon-tabel.
     *
     * @return Een instantie van de PokemonDao interface voor toegang tot de Pokémon-gegevens.
     *//*

    abstract fun pokemonDao(): PokemonDao
}

*/
