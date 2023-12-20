package com.example.androidpokemonapp.data

import com.example.androidpokemonapp.network.PokemonApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val pokemonRepository: PokemonRepository
}

class AppContainerImpl : AppContainer {
    private val baseUrl = "https://pokeapi.co/api/v2/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()


    private val retrofitService: PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)
    }


    override val pokemonRepository: PokemonRepository by lazy {
        PokemonRepositoryImpl(retrofitService)
    }
}