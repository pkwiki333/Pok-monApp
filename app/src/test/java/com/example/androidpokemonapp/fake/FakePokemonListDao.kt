package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.data.database.DbPokemonList
import com.example.androidpokemonapp.data.database.PokemonListDao
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow


class FakePokemonListDao: PokemonListDao {
    private val pokemonTeam = mutableListOf<DbPokemonList>()
    private val pokemonTeamFlow = MutableSharedFlow<List<DbPokemonList>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)



    override suspend fun insertToYourTeam(pokemon: DbPokemonList) {
        val existingPokemon = pokemonTeam.find { it.name == pokemon.name }
        if (existingPokemon != null) {
            val index = pokemonTeam.indexOf(existingPokemon)
            pokemonTeam[index] = pokemon
        } else {
            pokemonTeam.add(pokemon)
        }
        pokemonTeamFlow.emit(pokemonTeam.toList())
    }

    override suspend fun deletePokemon(pokemon: DbPokemonList) {
        pokemonTeam.removeIf { it.name == pokemon.name }
        pokemonTeamFlow.emit(pokemonTeam.toList())
    }

    override suspend fun updateCatchedStatus(name: String, isCatched: Boolean) {
        pokemonTeam.find { it.name == name }?.isCatched = isCatched
    }

    override fun getYourTeamList(): Flow<List<DbPokemonList>> {
        //return flow{emit(FakeApiDataSource.getFakeDbPokemonList().asDatabaseObject()) }
        return pokemonTeamFlow
    }

    fun emitflow(pokemons: List<DbPokemonList>){
        pokemonTeamFlow.tryEmit(pokemons)
    }
}