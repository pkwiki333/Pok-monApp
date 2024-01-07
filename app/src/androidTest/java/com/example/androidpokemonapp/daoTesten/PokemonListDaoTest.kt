package com.example.androidpokemonapp.daoTesten

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.androidpokemonapp.data.database.PokemonListDao
import com.example.androidpokemonapp.data.database.PokemonListDatabase
import com.example.androidpokemonapp.data.database.asDatabaseObject
import com.example.androidpokemonapp.model.PokemonList
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.IOException

class PokemonListDaoTest {

    private lateinit var pokemonListDao: PokemonListDao
    private lateinit var pokemonDb: PokemonListDatabase

    private var pokemonList= PokemonList("bulbasaur", 1, false)
    private var pokemonList2= PokemonList("ivysaur", 2, false)

    private suspend fun addOnePokemonToDb() {
        pokemonListDao.insertToYourTeam(pokemonList.asDatabaseObject())
    }


    @Before
    fun createDb() {
        val context: Context = ApplicationProvider.getApplicationContext()
        pokemonDb = Room.inMemoryDatabaseBuilder(context, PokemonListDatabase::class.java)
            .allowMainThreadQueries()
            .build()
        pokemonListDao = pokemonDb.pokemonListDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        pokemonDb.close()
    }

    @Test
    fun insertAndGetPokemon() = runBlocking {
        addOnePokemonToDb()

        val yourTeamList = pokemonListDao.getYourTeamList().first()
        assertTrue(yourTeamList.contains(pokemonList.asDatabaseObject()))
    }

    @Test
    fun deletePokemon() = runBlocking {
        addOnePokemonToDb()

        pokemonListDao.deletePokemon(pokemonList.asDatabaseObject())

        val yourTeamList = pokemonListDao.getYourTeamList().first()
        assertFalse(yourTeamList.contains(pokemonList.asDatabaseObject()))
    }

    @Test
    fun updatePokemonCatchedStatus() = runBlocking {
        PokemonList("Pikachu", 25, true).asDatabaseObject().let {
            pokemonListDao.insertToYourTeam(it)
        }
        pokemonListDao.updateCatchedStatus("Pikachu", false)

        val updatedPokemon = pokemonListDao.getYourTeamList().first().find { it.name == "Pikachu" }
        assertNotNull(updatedPokemon)
        assertFalse(updatedPokemon!!.isCatched)
    }
}