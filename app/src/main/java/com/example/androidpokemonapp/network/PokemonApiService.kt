package com.example.androidpokemonapp.network

import com.example.androidpokemonapp.network.responses.ApiPokemon
import com.example.androidpokemonapp.network.responses.ApiPokemonList
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Interface die communicatie met de Pokémon API definieert om Pokémon-gerelateerde gegevens op te halen.
 */
interface PokemonApiService {

    /**
     * Haal een lijst van Pokémon op met optionele paginering.
     *
     * @param limit Het maximum aantal Pokémon dat moet worden opgehaald.
     * @param offset De offset waarmee de lijst moet beginnen als paginering wordt toegepast.
     * @return Een [ApiPokemonList] object dat de lijst met Pokémon en metadata bevat.
     */
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int = Int.MAX_VALUE,
        @Query("offset") offset: Int = 0
    ): ApiPokemonList

    /**
     * Haal gedetailleerde informatie op over een specifieke Pokémon op basis van de naam.
     *
     * @param name De naam van de Pokémon waarvan de informatie moet worden opgehaald.
     * @return Een [ApiPokemon] object dat de gedetailleerde informatie over de Pokémon bevat.
     */
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String)
     : ApiPokemon
}

    /**
     * Haal een lijst van Pokémon op als een Flow.
     *
     * @return Een Flow van [ApiPokemonList] objecten die de lijst met Pokémon en metadata bevatten.
     */
    fun PokemonApiService.getPokemonListAsFlow() = flow {
            val response = getPokemonList()
            emit(response)
    }
    /**
     * Haal gedetailleerde informatie op over een specifieke Pokémon als een Flow op basis van de naam.
     *
     * @param name De naam van de Pokémon waarvan de informatie moet worden opgehaald.
     * @return Een Flow van [ApiPokemon] objecten die de gedetailleerde informatie over de Pokémon bevatten.
     */
    fun PokemonApiService.getPokemonAsFlow(name: String) = flow {
        emit(getPokemonInfo(name))
    }

