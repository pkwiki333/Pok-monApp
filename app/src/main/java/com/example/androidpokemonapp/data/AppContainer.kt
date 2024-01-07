package com.example.androidpokemonapp.data

import android.content.Context
import androidx.room.Room
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.PokemonListDatabase
import com.example.androidpokemonapp.network.PokemonApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Definieert een interface voor de applicatiecontainer die alle benodigde afhankelijkheden bevat.
 * Dit omvat repositories, database toegang, en netwerkservices.
 */
interface AppContainer {
    val pokemonRepository: PokemonRepository
}

/**
 * Implementatie van [AppContainer] die verantwoordelijk is voor het initialiseren en leveren van de benodigde componenten
 * en services voor de applicatie, zoals databases, DAO's, en netwerkservices.
 *
 * @property applicationContext De context van de applicatie, gebruikt voor database en netwerkconfiguratie.
 */
class AppContainerImpl(private val applicationContext: Context) : AppContainer {
    private val baseUrl = "https://pokeapi.co/api/v2/"
    /**Lazy initialisatie van Retrofit voor netwerkaanroepen.*/
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    /**Lazy initialisatie van de Retrofit service interface.*/
    private val retrofitService: PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)
    }


    /**Lazy initialisatie van de RoomDB voor de Pokémon lijst.*/
    private val pokemonListDb: PokemonListDatabase by lazy {
        Room.databaseBuilder(applicationContext, PokemonListDatabase::class.java, "PokemonList_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    /**Verkrijgen van DAO's uit de RoomDB.*/
    private val pokemonListDao: PokemonListDao by lazy {
        pokemonListDb.pokemonListDao()
    }


    /**Lazy initialisatie van de repository met DAO's en netwerkservice.*/
    override val pokemonRepository: PokemonRepository by lazy {
        PokemonRepositoryImpl(pokemonListDao = pokemonListDao, pokemonApiService = retrofitService)
    }



}