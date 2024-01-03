package com.example.androidpokemonapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DbPokemonList::class], version = 4)
abstract class PokemonListDatabase : RoomDatabase(){
    abstract fun pokemonListDao(): PokemonListDao

    companion object {
        @Volatile
        private var Instance: PokemonListDatabase? = null

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