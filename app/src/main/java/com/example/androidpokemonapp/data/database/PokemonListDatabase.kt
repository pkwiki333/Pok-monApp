package com.example.androidpokemonapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DbPokemonList::class], version = 2)
abstract class PokemonListDatabase : RoomDatabase(){
    abstract fun pokemonListDao(): PokemonListDao
}