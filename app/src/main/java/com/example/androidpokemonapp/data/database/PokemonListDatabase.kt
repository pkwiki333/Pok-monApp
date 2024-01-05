package com.example.androidpokemonapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * RoomDB klasse voor het beheren van de Pokémon lijst database.
 * Deze klasse definieert de entiteiten die deel uitmaken van de database en geeft toegang tot DAO's.
 *
 * @see DbPokemonList De entiteit die de Pokémon lijst in de database representeert.
 */
@Database(entities = [DbPokemonList::class], version = 5)
abstract class PokemonListDatabase : RoomDatabase(){
    /**
     * Geeft toegang tot de [PokemonListDao] voor interactie met de database.
     *
     * @return Een instantie van de [PokemonListDao].
     */
    abstract fun pokemonListDao(): PokemonListDao

    /**Markeren van de Instance als volatile om ervoor te zorgen dat de wijzigingen
     in één thread onmiddellijk zichtbaar zijn in andere threads.*/
    companion object {
        @Volatile
        private var Instance: PokemonListDatabase? = null

        /**
         * Retourneert de singleton instantie van [PokemonListDatabase].
         * Als de instantie nog niet bestaat, wordt deze gecreëerd met behulp van RoomDB builder.
         *
         * @param context De context om de database te initialiseren.
         * @return De singleton instantie van [PokemonListDatabase].
         */
        fun getDatabase(context: Context): PokemonListDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, PokemonListDatabase::class.java, "pokemonList_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}