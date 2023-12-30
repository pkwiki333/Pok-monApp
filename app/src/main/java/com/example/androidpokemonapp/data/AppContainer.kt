package com.example.androidpokemonapp.data

import android.content.Context
import androidx.room.Room
import com.example.androidpokemonapp.data.database.PokemonDao
import com.example.androidpokemonapp.data.database.PokemonDatabase
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.PokemonListDatabase
import com.example.androidpokemonapp.network.PokemonApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val pokemonRepository: PokemonRepository
}

class AppContainerImpl(private val applicationContext: Context) : AppContainer {
    private val baseUrl = "https://pokeapi.co/api/v2/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()


    private val retrofitService: PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)
    }

    private val pokemonDb: PokemonDatabase by lazy {
        Room.databaseBuilder(applicationContext, PokemonDatabase::class.java, "Pokemon_database")
            .build()
    }

    private val pokemonListDb: PokemonListDatabase by lazy {
        Room.databaseBuilder(applicationContext, PokemonListDatabase::class.java, "PokemonList_database")
            .build()
    }

    private val pokemonListDao: PokemonListDao by lazy {
        pokemonListDb.pokemonListDao()
    }
    private val pokemonDao: PokemonDao by lazy {
        pokemonDb.pokemonDao()
    }

    override val pokemonRepository: PokemonRepository by lazy {
        PokemonRepositoryImpl(pokemonListDao = pokemonListDao,pokemonDao = pokemonDao, pokemonApiService = retrofitService)
    }



}