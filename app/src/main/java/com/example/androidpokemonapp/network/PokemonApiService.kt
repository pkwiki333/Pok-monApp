package com.example.androidpokemonapp.network

import android.util.Log
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.network.responses.ApiPokemon
import com.example.androidpokemonapp.network.responses.ApiPokemonList
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {

    //todo tijdelijk maar 20, maar verander naar allemaal met pagination
    @GET("pokemon?limit=20&offset=0")
    suspend fun getPokemonList(
        /*@Query("limit") limit: Int,
        @Query("offset") offset: Int*/
    ): ApiPokemonList


    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String)
     : ApiPokemon
}

fun PokemonApiService.getPokemonListAsFlow() = flow {
    try {
        val response = getPokemonList()
        Log.i("PokemonApiService", "!!!!!!Duidelijk deze$response")
        emit(response)
    }catch (e: Exception){
        Log.i("PokemonApiService", "!!!!!!Duidelijk deze${e.message}")
    }

}

fun PokemonApiService.getPokemonAsFlow(name: String) = flow {
    emit(getPokemonInfo(name))
}

