package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.data.database.DbPokemon
import com.example.androidpokemonapp.data.database.PokemonDao
import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.network.responses.asDomainObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakePokemonDao : PokemonDao {
    override fun getPokemonInfo(name: String): Flow<DbPokemon> {
        return flow{
            emit(FakeApiDataSource.getFakePokemon(name).asDomainObject().asDatabaseObject())
        }
    }
}