/*
package com.example.androidpokemonapp.daoTesten

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.androidpokemonapp.data.database.DbPokemon
import com.example.androidpokemonapp.data.database.PokemonDao
import com.example.androidpokemonapp.data.database.PokemonDatabase
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.PokemonListDatabase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PokemonDaoTest {

    lateinit var pokemonDao: PokemonDao
    lateinit var pokemonDb: PokemonDatabase

    @Before
    fun createDb() {
        pokemonDb = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            PokemonDatabase::class.java
        ).allowMainThreadQueries().build()
        pokemonDao = pokemonDb.pokemonDao()
    }

    @After
    fun closeDb() {
        pokemonDb.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getPokemonInfo_returnsCorrectData() = runBlockingTest {
            val samplePokemon = DbPokemon( "bulbasaur", 1, 7.0, 69.0, listOf("grass", "poison"), listOf("overgrow", "chlorophyll"), listOf("razor-wind"))
        pokemonDao.insertPokemon(samplePokemon)

        val retrievedPokemon = pokemonDao.getPokemonInfo(samplePokemon.name).first()

        assertEquals(samplePokemon, retrievedPokemon)
    }
}
*/
