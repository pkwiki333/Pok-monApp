package com.example.androidpokemonapp.network.responses

import kotlinx.serialization.Serializable

@Serializable
data class GameIndice(
    val game_index: Int,
    val version: Version
)