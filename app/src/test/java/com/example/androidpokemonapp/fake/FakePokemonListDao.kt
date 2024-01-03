package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.data.database.DbPokemonList
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakePokemonListDao: PokemonListDao {
    override suspend fun insertToYourTeam(pokemon: DbPokemonList) {
        TODO("Not yet implemented")
    }

    override suspend fun deletePokemon(pokemon: DbPokemonList) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCatchedStatus(name: String, isCatched: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getYourTeamList(): Flow<List<DbPokemonList>> {
        return flow{emit(FakeApiDataSource.getFakeDbPokemonList().asDatabaseObject()) }
    }
}