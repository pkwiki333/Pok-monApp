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
import java.io.IOException

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
        val response = getPokemonList()
        emit(response)


}
fun PokemonApiService.getPokemonAsFlow(name: String) = flow {
    emit(getPokemonInfo(name))
}

