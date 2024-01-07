package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.data.PokemonRepository
import com.example.androidpokemonapp.data.database.DbPokemonList
import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flowOf

class FakeApiPokemonRepository(private val fakePokemonListDao: FakePokemonListDao = FakePokemonListDao()) :
    PokemonRepository {

    val pokemonListFlow: MutableSharedFlow<List<PokemonList>> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    private val pokemonFlow: MutableSharedFlow<Pokemon> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    val dbPokemonListFlow: MutableSharedFlow<List<DbPokemonList>> =
        MutableSharedFlow(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    override fun getPokemonListDB(): Flow<List<PokemonList>> {
        return flowOf(FakeApiDataSource.getFakeDbPokemonList())
    }


    override suspend fun updateCatchedStatus(name: String, isCatched: Boolean) {
        val replayCache:List<PokemonList> = pokemonListFlow.replayCache.firstOrNull() ?: emptyList()
               pokemonListFlow.tryEmit(
                   replayCache.map {
                if (it.name == name) {
                    it.copy(isCatched = isCatched)
                } else {
                    it
                }
            }
        )
    }

    override suspend fun insertToYourTeam(pokemon: PokemonList) {
        val replayCache:List<DbPokemonList> = dbPokemonListFlow.replayCache.firstOrNull() ?: emptyList()
        val dbPokemon = pokemon.asDatabaseObject()
        dbPokemonListFlow.tryEmit(replayCache + dbPokemon)
    }

    override suspend fun deletePokemon(pokemon: PokemonList) {
        val replayCache:List<DbPokemonList> = dbPokemonListFlow.replayCache.firstOrNull() ?: emptyList()
        val dbPokemon = pokemon.asDatabaseObject()
        dbPokemonListFlow.tryEmit(replayCache.filter { it.name != dbPokemon.name })
    }

    override fun getPokemonList(): Flow<List<PokemonList>> {
        return pokemonListFlow
    }

    override fun getPokemonInfo(name: String): Flow<Pokemon> {
        return pokemonFlow.filter { it.name == name }
    }

    fun emitflow(pokemon: Pokemon){
        pokemonFlow.tryEmit(pokemon)
    }


}
