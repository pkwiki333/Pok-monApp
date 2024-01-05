package com.example.androidpokemonapp.data.database

import androidx.room.TypeConverter
/**
* Een klasse die typeconverters bevat voor de RoomDB om datatypes om te zetten.
* Deze klasse bevat converters voor het opslaan en ophalen van lijsten van strings
* in de database als een string waarbij de items gescheiden zijn door komma's.
*/
class Converters {

    @TypeConverter
    fun toString(data: List<String>): String {
        return data.joinToString(",")
    }

    /**
     * Zet een string met items gescheiden door komma's om naar een lijst van strings.
     * Deze methode wordt gebruikt door de RoomDB om de opgeslagen string te converteren
     * terug naar een lijst van strings na het ophalen uit de database.
     *
     * @param data De string die omgezet moet worden naar een lijst van strings.
     * @return Een lijst van strings verkregen door de input string te splitsen op komma's.
     */
    @TypeConverter
    fun toStringList(data: String): List<String> {
        return data.split(",").filter { it.isNotEmpty() }
    }
}